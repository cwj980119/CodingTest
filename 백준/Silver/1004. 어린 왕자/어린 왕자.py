import math

T = int(input())


def inside(x, y, cx, cy, r):
    dist = math.sqrt((x - cx) ** 2 + (y - cy) ** 2)
    if dist < r:
        return True
    else:
        return False


for _ in range(T):
    x_1, y_1, x_2, y_2 = map(int, input().split())
    n = int(input())
    cnt = 0
    for _ in range(n):
        cx, cy, r = map(int, input().split())
        s = inside(x_1, y_1, cx, cy, r)
        e = inside(x_2, y_2, cx, cy, r)
        if s and e:
            continue
        elif s or e:
            cnt += 1
    print(cnt)