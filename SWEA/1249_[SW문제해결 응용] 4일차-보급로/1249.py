import heapq
 
T = int(input())
 
def find_way():
    pq = []
    dx = [-1, 1, 0, 0] # 상하좌우
    dy = [0, 0, -1, 1]
    heapq.heappush(pq, (0, 0, 0))
    visited[0][0] = True
    while pq:
        cur = heapq.heappop(pq)
        if(cur[1] == n-1 and cur[2] == n-1):
            return cur[0]
        for i in range(4):
            nr = cur[1] + dx[i]
            nc = cur[2] + dy[i]
            if nr < 0 or nr >= n or nc < 0 or nc >= n:
                continue
            if not visited[nr][nc]:
                visited[nr][nc] = True
                heapq.heappush(pq,(cur[0] + arr[nr][nc], nr, nc))
 
for test_case in range(1, T + 1):
    n = int(input())
    arr = []
    visited = [[False for _ in range(n)] for _ in range(n)]
    for i in range(n):
        arr.append(list(map(int,input())))
 
    result = find_way()
    print("#", test_case," ",result,sep="")
