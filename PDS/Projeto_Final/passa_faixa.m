function [ hd ] = passa_faixa( wc1,wc2,M )
    n = -(M/2):(M/2);
    n = n + eps;
    hd = (sin (wc2 * n))./(pi*n) - (sin (wc1 * n))./(pi*n);
end

