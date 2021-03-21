import math

n = 100

print("n^1.01 : ", n**(1.01))
print("n(logn)^2 : ", n * (math.log(n,10) ** 2))
print("2^n : ", 2**n)
print("sqrt(n) : ", n**(0.5))
print("(logn)^3 : ", math.log(n,10) ** 3)
print("n * 2^n : ", n * (2**n))
print("3^n : ", 3**n)
print("2^n+1 : ", 2**(n+1))
print("5^log2(n)", 5**(math.log(n,2)) )
print("logn : ", math.log(n,10))

# print(math.log(1000,10))

