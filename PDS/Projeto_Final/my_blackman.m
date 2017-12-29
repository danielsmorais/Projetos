function [ w ] = my_blackman( M )
    n = 0:M;
    w = 0.42 - 0.5 * cos((2*pi*n)/M) + 0.08 * cos((4*pi*n)/M);
end

