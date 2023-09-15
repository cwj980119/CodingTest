n, m = map(int,input().split())

basket = [i for i in range(0, n+1)]

for _ in range(m):
    a, b = map(int,input().split())
    temp = basket[a];
    basket[a] = basket[b];
    basket[b] = temp;

for i in range(1, n+1):
    print(basket[i], end=" ")