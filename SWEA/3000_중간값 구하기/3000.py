import heapq
 
T = int(input())
 
for tc in range(1, T + 1):
    n, a = map(int, input().split())
    low = [0]
    high = [10000000001]
    mid = a
    sum = 0
    for i in range(1, n + 1):
        x, y = map(int, input().split())
        if x > mid and y > mid:
            heapq.heappush(high, x)
            heapq.heappush(high, y)
            heapq.heappush(low, 0 - mid)
            mid = heapq.heappop(high)
        elif x <= mid and y <= mid:
            heapq.heappush(low, 0 - x)
            heapq.heappush(low, 0 - y)
            heapq.heappush(high, mid)
            mid = 0 - heapq.heappop(low)
        elif y <= mid:
            heapq.heappush(high, x)
            heapq.heappush(low, 0 - y)
        else:
            heapq.heappush(high, y)
            heapq.heappush(low, 0 - x)
        sum += mid
        sum %= 20171109
    print("#", tc," ", sum,sep="")
