% Esta fun��o faz a transformada de Fourier de um sinal
% e o plota no dom�nio frequ�ncia
% [X, freq] = fftf(x, Fs)
%
% x - Sinal de Entrada
% Fs - Frequencia de Amostragem do Sinal
% X - M�dulo do sinal no dom�nio frequ�ncia
% freq - Vetor de frequ�ncia (abscissas)

function [X, freq] = fftf(x, Fs)

N = length(x);       % N recebe o tamanho do vetor x
k = 0:N-1;           % k � um vetor de 0 at� o tamanho m�ximo de x
                     % menos um.
T = N/Fs;            % Vetor que define o valor do tempo em determinado instante
freq = k/T;          % frequ�ncia
X = fftn(x)/N;       % X recebe a transformada de Fourier normalizada
cutOff = ceil(N/2);  % frequ�ncia de corte para ajustar os dados
X = X(1:cutOff);     % plota o X de 1 at� a frequ�ncia cutOff

%figure();
%plot(freq(1:cutOff), abs(X));
%title('Espectro de Frequencias');
%xlabel('Frequencia (Hz)');
%ylabel('Amplitude');