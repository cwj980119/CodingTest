import heapq

v, e = map(int,input().split())
parents = [i for i in range(v+1)]

def find(x):
    cur = parents[x]
    while cur is not parents[cur]:
        cur = parents[cur]
    return cur

def merge(x, y):
    px = find(x)
    py = find(y)
    parents[py] = px


pq = []
for _ in range(e):
    a, b, c = map(int,input().split())
    heapq.heappush(pq,[c, [a,b]])

cnt = sum = 0
while pq:
    curr = heapq.heappop(pq)
    if find(curr[1][0]) == find(curr[1][1]):
        continue
    merge(curr[1][0], curr[1][1])
    sum += curr[0]
    cnt += 1
    if cnt >= v-1:
        print(sum)
        break