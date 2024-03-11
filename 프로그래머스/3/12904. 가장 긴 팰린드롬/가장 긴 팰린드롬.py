def solution(s):
    s_len = len(s)
    for i in range(s_len):
        for j in range(i+1):
            if j == 0:
                if s[j:s_len+j-i] == s[s_len+j-i-1::-1]: return s_len-i
            else:
                if s[j:s_len+j-i] == s[s_len+j-i-1:j-1:-1]: return s_len-i

