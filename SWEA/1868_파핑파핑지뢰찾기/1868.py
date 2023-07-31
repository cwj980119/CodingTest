T = int(input())
 
dx = [-1, -1, -1, 0, 0, 1, 1, 1]
dy = [-1, 0, 1, -1, 1, -1, 0, 1]
 
def cnt_mine(r, c):
    cnt = 0; dr = 0; dc = 0;
    for i in range(8):
        dr = r + dx[i]
        dc = c + dy[i]
        if dr < 0 or dr >= n or dc < 0 or dc >= n:
            continue
        if mine_map[dr][dc] == '*':
            cnt+=1;
    return cnt;
 
def open_mine(r, c):
    cnt = 0; dr = 0; dc = 0;
    num_map[r][c] = -1
    for i in range(8):
        dr = r + dx[i]
        dc = c + dy[i]
        if dr < 0 or dr >= n or dc < 0 or dc >= n:
            continue
        if num_map[dr][dc] == 0:
            open_mine(dr, dc)
        num_map[dr][dc] = -1
 
for test_case in range(1, T + 1):
    n = int(input())
    mine_map = [' ' for j in range(n)]
    num_map = [[0 for j in range(n)] for i in range(n)]
    for i in range(n):
        mine_map[i] = str(input())
    for r in range(n):
        for c in range(n):
            if mine_map[r][c] == '*':
                num_map[r][c] = -1
            else:
                num_map[r][c] = cnt_mine(r, c)
    cnt = 0
    for r in range(n):
        for c in range(n):
            if num_map[r][c] == 0:
                cnt+=1
                open_mine(r, c)
 
    for r in range(n):
        for c in range(n):
            if num_map[r][c] != -1:
                cnt+=1
    print("#", test_case," ",cnt,sep="")
