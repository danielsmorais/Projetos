% Esta função faz a transformada de Fourier de um sinal
% e o plota no domínio frequência
% [X, freq] = fftf(x, Fs)
%
% x - Sinal de Entrada
% Fs - Frequencia de Amostragem do Sinal
% X - Módulo do sinal no domínio frequência
% freq - Vetor de frequência (abscissas)

function [X, freq] = fftf(x, Fs)

N = length(x);       % N recebe o tamanho do vetor x
k = 0:N-1;           % k é um vetor de 0 até o tamanho máximo de x
                     % menos um.
T = N/Fs;            % Vetor que define o valor do tempo em determinado instante
freq = k/T;          % frequência
X = fftn(x)/N;       % X recebe a transformada de Fourier normalizada
cutOff = ceil(N/2);  % frequência de corte para ajustar os dados
X = X(1:cutOff);     % plota o X de 1 até a frequência cutOff

%figure();
%plot(freq(1:cutOff), abs(X));
%title('Espectro de Frequencias');
%xlabel('Frequencia (Hz)');
%ylabel('Amplitude');