function [ delta ] = delta_calc( M )
    delta = zeros(1,M+1);
    delta(M/2 + 1) = 1;
end

