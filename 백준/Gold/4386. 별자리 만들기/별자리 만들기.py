import heapq
import math

n = int(input())
stars = [[0, 0] for _ in range(n)]
parents = [i for i in range(n)]


def findRoot(i):
    cur = i
    while parents[cur] != cur:
        cur = parents[cur]
    return cur


for i in range(n):
    stars[i][0], stars[i][1] = map(float, input().split())

pq = []
for i in range(n):
    for j in range(i + 1, n):
        heapq.heappush(pq, [math.sqrt((stars[i][0] - stars[j][0]) ** 2 + (stars[i][1] - stars[j][1]) ** 2), i, j])
cnt = 0
sum = 0
while pq:
    cur = heapq.heappop(pq)
    a = findRoot(cur[1])
    b = findRoot(cur[2])
    if a != b:
        parents[b] = a
        sum += cur[0]
        cnt += 1
        if cnt == n - 1:
            break
print('%.2f' % sum)