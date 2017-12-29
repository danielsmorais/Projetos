function [ w ] = my_bartlett( M )
    n1 = 0:(M/2);
    w1 = n1*(2/M);
    
    n2 = (M/2+1):M;
    w2 = 2 - n2*(2/M);
    
    w = [w1 w2];
end

