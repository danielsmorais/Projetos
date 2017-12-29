function [ M ] = par(M)
    if mod(M,2) ~= 0
		M=M+1;
    end
end

