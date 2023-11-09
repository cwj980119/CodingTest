n = int(input())

word = input()
w_l = list(word)
for _ in range(n-1):
    new_word = input()
    for i in range(len(word)):
        if(word[i] != new_word[i]):
            w_l[i] = '?'
print(''.join(w_l))