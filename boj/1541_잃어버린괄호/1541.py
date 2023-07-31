s = input()
a = 0;
arr = []

for i in range(0, len(s)):
    if s[i] == '+' or s[i] == '-':
        arr.append(s[a:i])
        arr.append(s[i])
        a = i + 1
arr.append(s[a:])

sum = 0
sub_sum = 0
m = len(arr)

for n in range(len(arr)):
    if arr[n] is '-':
        m = n + 1
        break
    elif arr[n] is '+':
        pass
    else:
        sum += int(arr[n])

for n in arr[m:]:
    if n is '-':
        sum -= sub_sum
        sub_sum = 0
    elif n is '+':
        pass
    else:
        sub_sum += int(n)
sum -= sub_sum

print(sum)
