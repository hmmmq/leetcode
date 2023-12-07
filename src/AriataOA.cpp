//
// Created by Hmq Hmq on 2023/12/7.
//
/***
 * you are given a string to reformat.
 * the string consists of N characters of letters, digits, spaces and/or dashes .
 * the string alsways contains at least two alphanumeric characters.
 * spaces and dashes in the string should be ignored. we want to reformat the string so that the characters are grouped in blocks of three, separated by single spaces.
 * if necessary, the final block or the last two blocks can be of length two.  here is the signature: string FormatString(string s)
 */
#include <string>

using namespace std;

string FormatString(string s) {
    string result;
    string alphanumeric;

    // 提取所有字母数字字符
    for (char c : s) {
        if (isalnum(c)) {
            alphanumeric += c;
        }
    }

    // 格式化字符串
    int n = alphanumeric.size();
    for (int i = 0; i < n; ++i) {
        result += alphanumeric[i];
        if ((i + 1) % 3 == 0 && i != n - 1) {
            result += ' ';
        }
    }

    // 调整最后一个或最后两个块的长度
    int len = result.length();
    if (len > 1 && result[len - 2] == ' ') {
        swap(result[len - 2], result[len - 3]);
    }

    return result;
}

