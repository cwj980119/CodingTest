word = input()
l = len(word)
mid = int(l / 2)
isOdd = (l%2 == 1)

def check_line(mid):
    half = mid
    if isOdd:
        for i in range(1, half + 2):
            if(mid + i) >=l:
                return l;
            if word[mid - i] != word[mid + i]:
                break

    while(True):
        for i in range(1, half+2):
            if (mid + i -1) >= l:
                return half*2
            if word[mid - i] != word[mid + i - 1]:
                break
        for i in range(1, half+2):
            if (mid + i) >= l:
                return half*2 + 1
            if word[mid - i] != word[mid + i]:
                break
        mid += 1
        half += 1

print(check_line(mid))
