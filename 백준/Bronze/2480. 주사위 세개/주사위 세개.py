a, b, c = map(int,input().split())

if a==b and b==c and a==c:
    price = 10000 + a*1000
elif a==b or a==c:
    price = 1000 + a*100
elif b==c:
    price = 1000 + b*100
else:
    price = max(a,b,c) * 100


print(price)