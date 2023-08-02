n = int(input())
children = [[] for i in range(n + 1)]
depth = [-1 for i in range(n+1)]

for _ in range(n - 1):
    a, b = map(int, input().split())
    children[a].append(b)
    children[b].append(a)

depth[1] = 0
q = [[1, 0, 0]]
total = 0
while q:
    curr, parent, dept = q.pop()
    cnt = 0
    for c in children[curr]:
        if c is not parent:
            cnt += 1
            depth[c] = dept+1
            q.append([c, curr, dept+1])
    if cnt == 0:
        total += dept
if total % 2 == 0:
    answer = "No"
else:
    answer = "Yes"
print(answer)
