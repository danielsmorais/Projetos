function [ w ] = my_hamming( M )
    n = 0:M;
    w = 0.54 - 0.46 * cos((2*pi*n)/M);
end

