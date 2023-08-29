import sys
import heapq
input = sys.stdin.readline

n, m = map(int,input().split())

before = [0 for _ in range(n + 1)]
next = [[] for _ in range(n+1)]

for _ in range(m):
    a, b = map(int, input().split())
    before[b] += 1
    next[a].append(b)

q = []
for i in range(1, n+1):
    if before[i] == 0:
        heapq.heappush(q, i)
while q:
    curr = heapq.heappop(q)
    print(curr, end=" ")
    for n in next[curr]:
        before[n] -= 1
        if before[n] == 0:
            heapq.heappush(q, n)