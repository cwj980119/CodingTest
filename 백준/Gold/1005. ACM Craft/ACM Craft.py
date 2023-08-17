T = int(input())

for _ in range(T):
    n, k = map(int, input().split())
    time = [0 for _ in range(n + 1)]
    count = [0 for _ in range(n + 1)]
    before = [[] for _ in range(n + 1)]
    children = [[] for _ in range(n + 1)]
    total = [0 for _ in range(n + 1)]

    time[1:] = map(int, input().split())
    for _ in range(k):
        x, y = map(int, input().split())
        before[y].append(x)
        count[y] += 1
    w = int(input())

    visited = [False for _ in range(n+1)]
    q = [w]
    node_list = []
    while q:
        curr = q.pop(0)
        node_list.append(curr)
        for b in before[curr]:
            children[b].append(curr)
            if not visited[b]:
                q.append(b)
                visited[b] = True

    q = []
    for i in node_list:
        if not before[i]:
            q.append(i)
            total[i] = time[i]
    while q:
        curr = q.pop()
        if curr is w:
            print(total[curr])
        for child in children[curr]:
            count[child] -= 1
            total[child] = max(total[child], total[curr] + time[child])
            if count[child] is 0:
                q.append(child)