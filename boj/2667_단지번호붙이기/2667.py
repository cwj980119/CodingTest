dx = [-1, 1 ,0, 0]
dy = [0, 0, -1, 1]

def bfs(i, j):
    q = []
    visited[i][j] = True
    q.append([i,j])
    cnt = 0
    while(q):
        cnt+=1
        cur = q.pop()
        for i in range(4):
            nr = cur[0] + dx[i]
            nc = cur[1] + dy[i]
            if arr[nr][nc] is '1' and not visited[nr][nc]:
                visited[nr][nc] = True
                q.append([nr,nc])
    result.append(cnt)

N = int(input())
arr = []
visited = [[False for j in range(N+2)] for i in range(N+2)]
arr.append(['0' for i in range(N+2)])
for _ in range(N):
    arr.append('0'+input()+'0')
arr.append(['0' for i in range(N+2)])

result = []

for i in range(1,N+1):
    for j in range(1,N+1):
        if arr[i][j] is '1' and not visited[i][j]:
            bfs(i, j)
result.sort()
length = len(result)
print(length)
for i in range(length):
    print(result[i])
