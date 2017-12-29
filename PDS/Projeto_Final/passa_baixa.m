function [ hd ] = passa_baixa( wc,M )
    n = -(M/2):(M/2);
    n = n + eps;
    hd = (sin (wc * n))./(pi*n);
end

