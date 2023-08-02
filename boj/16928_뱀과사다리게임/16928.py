import heapq

game = [-1 for i in range(101)]
visited = [False for i in range(101)]

n, m = map(int, input().split())

for _ in range(n + m):
    a, b = map(int, input().split())
    game[a] = b

pq = [[0, 1]]
while pq:
    d, curr = heapq.heappop(pq)
    if curr == 100:
        print(d)
        break
    if game[curr] is not -1 and not visited[game[curr]]:
        heapq.heappush(pq, [d, game[curr]])
        visited[game[curr]] = True
    else:
        for i in range(1, 7):
            dc = curr + i
            if dc <= 100 and not visited[dc]:
                if game[dc] is -1:
                    heapq.heappush(pq, [d + 1, dc])
                    visited[dc] = True
                elif not visited[game[dc]]:
                    heapq.heappush(pq, [d + 1, game[dc]])
                    visited[game[dc]] = True
