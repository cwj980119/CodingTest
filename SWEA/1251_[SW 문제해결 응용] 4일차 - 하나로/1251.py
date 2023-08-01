import heapq
import math
 
class Island:
    def __init__(self, x, y):
        self.x = x
        self.y = y
        self.group = -1
        self.conn = []
 
    def connect(self, g):
        global visited
        self.group = g
        for next in self.conn:
            if not visited[next] and islands[next].group is not g:
                visited[next] = True
                islands[next].connect(g)
 
T = int(input())
 
for tc in range(1, T+1):
    n = int(input())
    islands = []
    distance = [[math.inf for _ in range(n)] for _ in range(n)]
    x = list(map(int, input().split()))
    y = list(map(int, input().split()))
    e = float(input())
    for i in range(n):
        islands.append(Island(x[i], y[i]))
    heap = []
    for i in range(n):
        for j in range(n):
            if i is not j and distance[i][j] is math.inf:
                distance[i][j] = distance[j][i] = math.pow(islands[i].x - islands[j].x, 2) + math.pow(
                    islands[i].y - islands[j].y, 2)
                heapq.heappush(heap, [distance[i][j], i, j])
    line = 0
    sum = 0
    size = [0 for _ in range(n)]
 
    while line < n - 1:
        dist, a, b = heapq.heappop(heap)
        if islands[a].group is -1 and islands[b].group is -1:
            sum += dist*e
            islands[a].group = islands[b].group = line
            islands[a].conn.append(b)
            islands[b].conn.append(a)
            size[line] += 2
            line += 1
        elif islands[a].group is not islands[b].group:
            sum += dist*e
            line += 1
            if islands[a].group is -1:
                islands[a].group = islands[b].group
                size[islands[b].group] += 1
            elif islands[b].group is -1:
                islands[b].group = islands[a].group
                size[islands[a].group] += 1
            else:
                visited = [False for _ in range(n)]
                if size[islands[a].group] > size[islands[b].group]:
                    size[islands[a].group] += size[islands[b].group]
                    size[islands[b].group] = 0
                    islands[b].connect(islands[a].group)
                else:
                    size[islands[b].group] += size[islands[a].group]
                    size[islands[a].group] = 0
                    islands[a].connect(islands[b].group)
            islands[a].conn.append(b)
            islands[b].conn.append(a)
 
    print("#",tc, " ", round(sum),sep="")
