function [ w ] = my_hanning(M)
    n = 0:M;
    w = 0.5 - 0.5 * cos((2*pi*n)./M);
end