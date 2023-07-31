T = int(input())
 
for test_case in range(1, T + 1):
    order = input()
    arr = [[0 for j in range(16)] for i in range(len(order) + 1)]
    initial = (1 << (ord(order[0]) - 65)) | 1
    arr[0][1] = 1
 
    for i in range(0,len(order)):
        curr = (1 << (ord(order[i]) - 65))
        for j in range(1, 16):
            for k in range(1, 16):
                if(j&k > 0):
                    if(k&curr > 0):
                        arr[i+1][k] += arr[i][j]
                        arr[i+1][k] %= 1000000007
    cnt = 0
    for i in range(16):
        cnt += arr[len(order)][i]
    print('#'+ str(test_case) + ' ' + str(cnt % 1000000007))
