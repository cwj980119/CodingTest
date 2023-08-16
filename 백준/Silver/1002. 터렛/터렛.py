import math

T = int(input())

for _ in range(T):
    x_1, y_1, r_1, x_2, y_2, r_2 = map(int, input().split())
    if x_1 == x_2 and y_1 == y_2:
        if r_1 == r_2:
            print(-1)
            continue
        else:
            print(0)
            continue
    dist = math.sqrt((x_1 - x_2) ** 2 + (y_1 - y_2) ** 2)
    r_dist = r_1 + r_2

    if dist + r_1 < r_2 or dist + r_2 < r_1:
        print(0)
        continue
    if dist + r_1 == r_2 or dist + r_2 == r_1:
        print(1)
        continue

    if dist == r_dist:
        print(1)
        continue
    if dist < r_dist:
        print(2)
        continue
    if dist > r_dist:
        print(0)