function [ hd ] = passa_alta( wc,M )
    n = -(M/2):(M/2);
    n = n + eps;
    hd = delta_calc(M) - (sin(wc * n))./(pi*n);
end

