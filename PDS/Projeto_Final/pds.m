% PROJETO DA DISCIPLINA DE PROCESSAMENTO DIGITAL DE SINAIS
% PROJETO DE FILTROS FIR AUTOMATIZADO
% ENGENHARIA DE COMPUTAÇÃO - UFRN - 2017.2 - 09.12.2017
% AUTORES: DANIEL MORAIS, MAILSON RIBEIRO E WYSTERLANYA KYURY

function varargout = pds(varargin)
% PDS MATLAB code for pds.fig
%      PDS, by itself, creates a new PDS or raises the existing
%      singleton*.
%
%      H = PDS returns the handle to a new PDS or the handle to
%      the existing singleton*.
%
%      PDS('CALLBACK',hObject,eventData,handles,...) calls the local
%      function named CALLBACK in PDS.M with the given input arguments.
%
%      PDS('Property','Value',...) creates a new PDS or raises the
%      existing singleton*.  Starting from the left, property value pairs are
%      applied to the GUI before pds_OpeningFcn gets called.  An
%      unrecognized property name or invalid value makes property application
%      stop.  All inputs are passed to pds_OpeningFcn via varargin.
%
%      *See GUI Options on GUIDE's Tools menu.  Choose "GUI allows only one
%      instance to run (singleton)".
%
% See also: GUIDE, GUIDATA, GUIHANDLES

% Edit the above text to modify the response to help pds

% Last Modified by GUIDE v2.5 07-Dec-2017 21:24:56

% Begin initialization code - DO NOT EDIT
gui_Singleton = 1;
gui_State = struct('gui_Name',       mfilename, ...
                   'gui_Singleton',  gui_Singleton, ...
                   'gui_OpeningFcn', @pds_OpeningFcn, ...
                   'gui_OutputFcn',  @pds_OutputFcn, ...
                   'gui_LayoutFcn',  [] , ...
                   'gui_Callback',   []);
if nargin && ischar(varargin{1})
    gui_State.gui_Callback = str2func(varargin{1});
end

if nargout
    [varargout{1:nargout}] = gui_mainfcn(gui_State, varargin{:});
else
    gui_mainfcn(gui_State, varargin{:});
end
% End initialization code - DO NOT EDIT


% --- Executes just before pds is made visible.
function pds_OpeningFcn(hObject, eventdata, handles, varargin)
% This function has no output args, see OutputFcn.
% hObject    handle to figure
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)
% varargin   command line arguments to pds (see VARARGIN)

% Choose default command line output for pds
handles.output = hObject;

% Update handles structure
guidata(hObject, handles);

% UIWAIT makes pds wait for user response (see UIRESUME)
% uiwait(handles.figure1);


% --- Outputs from this function are returned to the command line.
function varargout = pds_OutputFcn(hObject, eventdata, handles) 
% varargout  cell array for returning output args (see VARARGOUT);
% hObject    handle to figure
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)

% Get default command line output from handles structure
varargout{1} = handles.output;


% --- Executes on button press in pushbuttonPlay1.
function pushbuttonPlay1_Callback(hObject, eventdata, handles)
% hObject    handle to pushbuttonPlay1 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)

audio = evalin('base', 'audio');
tempo = evalin('base', 'tempo');
fa = evalin('base', 'fa');

aux = audioplayer(audio,fa);
play(aux);
pause(tempo);

% --- Executes on button press in pushbuttonPlay2.
function pushbuttonPlay2_Callback(hObject, eventdata, handles)
% hObject    handle to pushbuttonPlay2 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)

audio_filtrado = evalin('base', 'filtrado');
tempo = evalin('base', 'tempo');
fa = evalin('base', 'fa');

aux = audioplayer(audio_filtrado,fa);
play(aux);
pause(tempo);


% --- Executes on button press in pushbutton5.
function pushbutton5_Callback(hObject, eventdata, handles)
% hObject    handle to pushbutton5 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)



function editTempo_Callback(hObject, eventdata, handles)
% hObject    handle to editTempo (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)

% Hints: get(hObject,'String') returns contents of editTempo as text
%        str2double(get(hObject,'String')) returns contents of editTempo as a double


% --- Executes during object creation, after setting all properties.
function editTempo_CreateFcn(hObject, eventdata, handles)
% hObject    handle to editTempo (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    empty - handles not created until after all CreateFcns called

% Hint: edit controls usually have a white background on Windows.
%       See ISPC and COMPUTER.
if ispc && isequal(get(hObject,'BackgroundColor'), get(0,'defaultUicontrolBackgroundColor'))
    set(hObject,'BackgroundColor','white');
end



function editAmostragem_Callback(hObject, eventdata, handles)
% hObject    handle to editAmostragem (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)

% Hints: get(hObject,'String') returns contents of editAmostragem as text
%        str2double(get(hObject,'String')) returns contents of editAmostragem as a double


% --- Executes during object creation, after setting all properties.
function editAmostragem_CreateFcn(hObject, eventdata, handles)
% hObject    handle to editAmostragem (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    empty - handles not created until after all CreateFcns called

% Hint: edit controls usually have a white background on Windows.
%       See ISPC and COMPUTER.
if ispc && isequal(get(hObject,'BackgroundColor'), get(0,'defaultUicontrolBackgroundColor'))
    set(hObject,'BackgroundColor','white');
end


% --- Executes on button press in pushbuttonGravar.
function pushbuttonGravar_Callback(hObject, eventdata, handles)
% hObject    handle to pushbuttonGravar (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)

% Record your voice for 5 seconds.
fa = str2num(get(handles.editAmostragem,'String'));
T = str2num(get(handles.editTempo,'String'));
nBits = 8;
nChannels = 1; % 1 mono | 2 estereo
Device = -1;

recObj = audiorecorder(fa,nBits,nChannels,Device);
disp('Start speaking.')
recordblocking(recObj, T);
disp('End of Recording.');

% Play back the recording.
% play(recObj);

% Store data in double-precision array.
audio = getaudiodata(recObj);
%f=figure;
%setappdata(f,'audio',audio);

assignin ('base','audio',audio);
assignin ('base','tempo',T);
assignin ('base','fa',fa);



[X,freq] = my_fft(audio,fa);
N = length(audio);
cutOff = ceil(N/2);

plot(handles.axesOriginal,freq(1:cutOff), abs(X));
title(handles.axesOriginal,'Espectro de Frequencias','FontSize',8);
xlabel(handles.axesOriginal,'Frequencia (Hz)','FontSize',8);
ylabel(handles.axesOriginal,'Amplitude','FontSize',8);



% --- Executes on button press in pushbuttonAplicar.
function pushbuttonAplicar_Callback(hObject, eventdata, handles)
% hObject    handle to pushbuttonAplicar (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)

fs = str2num(get(handles.editfs,'String'));
fp = str2num(get(handles.editfp,'String'));
delta = str2num(get(handles.editDelta,'String'));
filtroValue = get(handles.popupmenuFiltro,'Value'); 

tipofiltro = '';

switch filtroValue
    case 2
        tipofiltro = 'passa-baixa';
    case 3
        tipofiltro = 'passa-alta';
    case 4
        tipofiltro = 'passa-faixa';
    case 5
        tipofiltro = 'rejeita-faixa';
    otherwise
        tipofiltro = ' ';
end


audio = evalin('base', 'audio');
fa = evalin('base', 'fa');

% Chamar a função...

[filtrado, janela, nomejanela] = filtro(audio, fa, fs, fp, tipofiltro, delta);

assignin ('base','filtrado',filtrado);
assignin ('base','janela',janela);


plot(handles.axesJanela, janela);
title(handles.axesJanela,'Janela Resultante','FontSize',8);
xlabel(handles.axesJanela,'Pontos','FontSize',8);
ylabel(handles.axesJanela,'Amplitude','FontSize',8);
legend(handles.axesJanela, nomejanela);


[X,freq] = my_fft(filtrado,fa);
N = length(filtrado);
cutOff = ceil(N/2);

plot(handles.axesFiltrado,freq(1:cutOff), abs(X));
title(handles.axesFiltrado,'Espectro de Frequencias','FontSize',8);
xlabel(handles.axesFiltrado,'Frequencia (Hz)','FontSize',8);
ylabel(handles.axesFiltrado,'Amplitude','FontSize',8);



function editfs_Callback(hObject, eventdata, handles)
% hObject    handle to editfs (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)

% Hints: get(hObject,'String') returns contents of editfs as text
%        str2double(get(hObject,'String')) returns contents of editfs as a double


% --- Executes during object creation, after setting all properties.
function editfs_CreateFcn(hObject, eventdata, handles)
% hObject    handle to editfs (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    empty - handles not created until after all CreateFcns called

% Hint: edit controls usually have a white background on Windows.
%       See ISPC and COMPUTER.
if ispc && isequal(get(hObject,'BackgroundColor'), get(0,'defaultUicontrolBackgroundColor'))
    set(hObject,'BackgroundColor','white');
end



function editfp_Callback(hObject, eventdata, handles)
% hObject    handle to editfp (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)

% Hints: get(hObject,'String') returns contents of editfp as text
%        str2double(get(hObject,'String')) returns contents of editfp as a double


% --- Executes during object creation, after setting all properties.
function editfp_CreateFcn(hObject, eventdata, handles)
% hObject    handle to editfp (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    empty - handles not created until after all CreateFcns called

% Hint: edit controls usually have a white background on Windows.
%       See ISPC and COMPUTER.
if ispc && isequal(get(hObject,'BackgroundColor'), get(0,'defaultUicontrolBackgroundColor'))
    set(hObject,'BackgroundColor','white');
end



function editDelta_Callback(hObject, eventdata, handles)
% hObject    handle to editDelta (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)

% Hints: get(hObject,'String') returns contents of editDelta as text
%        str2double(get(hObject,'String')) returns contents of editDelta as a double


% --- Executes during object creation, after setting all properties.
function editDelta_CreateFcn(hObject, eventdata, handles)
% hObject    handle to editDelta (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    empty - handles not created until after all CreateFcns called

% Hint: edit controls usually have a white background on Windows.
%       See ISPC and COMPUTER.
if ispc && isequal(get(hObject,'BackgroundColor'), get(0,'defaultUicontrolBackgroundColor'))
    set(hObject,'BackgroundColor','white');
end


% --- Executes on selection change in popupmenuFiltro.
function popupmenuFiltro_Callback(hObject, eventdata, handles)
% hObject    handle to popupmenuFiltro (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)

% Hints: contents = cellstr(get(hObject,'String')) returns popupmenuFiltro contents as cell array
%        contents{get(hObject,'Value')} returns selected item from popupmenuFiltro


% --- Executes during object creation, after setting all properties.
function popupmenuFiltro_CreateFcn(hObject, eventdata, handles)
% hObject    handle to popupmenuFiltro (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    empty - handles not created until after all CreateFcns called

% Hint: popupmenu controls usually have a white background on Windows.
%       See ISPC and COMPUTER.
if ispc && isequal(get(hObject,'BackgroundColor'), get(0,'defaultUicontrolBackgroundColor'))
    set(hObject,'BackgroundColor','white');
end
