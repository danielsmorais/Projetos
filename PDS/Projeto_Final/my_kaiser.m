function [ w ] = my_kaiser(M, B)
    n = -(M/2):(M/2);
    w = besseli(0,B*sqrt(1-(((0:M)- M/2)/(M/2)).^2))/besseli(0,B);
end

