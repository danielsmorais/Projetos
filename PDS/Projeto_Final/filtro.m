%Parametros de entradas:
%   sinal - sinal de audio
%   fa - frequencia de amostragem do sinal
%   fs - frequencia de rejeição
%   fp - frequencia de passagem
%   tipo do filtro - (passa-baixa, passa-alta, passa-faixa ou rejeita-faixa)
%   delta - vetor com todos os deltas do sinal

function [audio_filtrado, win, nomejanela] = filtro(sinal, fa, fs, fp, tipo_filtro, delta)
	
    % Delta minimo
    delta_min = min(delta);
    
    % Atenuacao Ar
    ar = -(20)*log10(delta_min);
    
    wt1 = 0;
    M = 0;
    win = 0;
    var_w = 0;
    wc = 0;
    nomejanela = '';
    
    if isequal(tipo_filtro,'passa-faixa') || isequal(tipo_filtro,'rejeita-faixa')
        % Normalização das frequencias entre 0 e pi
        wp1 = (fp(1)/(fa/2))*pi; 
        ws1 = (fs(1)/(fa/2))*pi;
        wp2 = (fp(2)/(fa/2))*pi; 
        ws2 = (fs(2)/(fa/2))*pi;        
        
        % Faixa de transicao do filtro 
        wt1 = abs(ws1-wp1);
        wt2 = abs(ws2-wp2);
        var_w =  min(wt1,wt2);
                
        % Frequencia de corte
        if isequal(tipo_filtro,'passa-faixa')
            wc1 = wp1 - var_w/2;
            wc2 = wp2 + var_w/2;
        else
            wc1 = wp1 + var_w/2;
            wc2 = wp2 - var_w/2;
        end
    else
        % Parte para saber as características dos filtros passa-baixa e
        % passa-alta
        % Normalização das frequencias entre 0 e pi
        wp1 = (fp(1)/(fa/2))*pi; 
        ws1 = (fs(1)/(fa/2))*pi;
            
        % Faixa de transicao do filtro 
        wt1 = abs(ws1-wp1);
        var_w = wt1;
        
        % Frequencia de corte
        wc = (ws1 + wp1)/2; 
    end
    
	% Variacao de f
	delta_f = var_w/(2*pi);
    
    % Definicao da janela
    if ar <= 21
        %Rectangular
        M = ceil(0.9/delta_f);
        M = par(M);
        win = my_rectangular(M);
        nomejanela = 'Retangular';
    elseif ar <= 44
        %Hanning
		M = ceil(3.1/delta_f);
        M = par(M);
        win = my_hanning(M);
        nomejanela = 'Hanning';
    elseif ar <= 53
        %Hamming
		M = ceil(3.3/delta_f);
        M = par(M);
        win = my_hamming(M);
        nomejanela = 'Hamming';
    elseif ar <= 74
        %Blackman
		M = ceil(5.5/delta_f);
        M = par(M);
        win = my_blackman(M);
        nomejanela = 'Blackman';
    else
        %Kaiser
        M = ceil((ar-8)/(2.285*var_w));
        M = par(M);
        B = 0.1102*(ar-8.7);
        win = my_kaiser(M,B);
        nomejanela = 'Kaiser';
    end
    
    % Calcula h[n]
    if isequal(tipo_filtro,'passa-baixa')
        hd = passa_baixa(wc,M);
    elseif isequal(tipo_filtro,'passa-alta')
        hd = passa_alta(wc,M);
    elseif isequal(tipo_filtro,'passa-faixa')
        hd = passa_faixa(wc1,wc2,M);
    elseif isequal(tipo_filtro,'rejeita-faixa')
        hd = rejeita_faixa(wc1,wc2,M);
    end
    
    h = hd.*win; 
    
    audio_filtrado = conv(h,sinal);
end
