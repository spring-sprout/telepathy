https://code.google.com/codejam/contest/32003/dashboard

"외계 숫자어"

라는 문제인데.. 간단하게 이야기하자면 "진수 변환"입니다.

Input
4
9 0123456789 oF8
Foo oF8 0123456789
13 0123456789abcdef 01
CODE O!CDE? A?JM!.

Output
Case #1: Foo
Case #2: 9
Case #3: 10011
Case #4: JAM!

Input의 첫번째 4는 4개를 풀어야 한다는 뜻. 그래서 그 아래에 4줄이 더 있는데..
여기서 첫번째 줄..

9 0123456789 oF8

여기서 9는 변화해야 하는 수.. 9는 그 다음에 있는 0123456789라는 숫자 체계에서의 9를 뜻한다. 이걸 oF8이라는 숫자체계로 표현하면 어떻게 되는가??

Foo가 된다.

이런식으로 나머지도 풀면 됨.