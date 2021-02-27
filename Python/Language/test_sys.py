# https://docs.python.org/3/library/sys.html

import sys

argv = sys.argv

print (type(argv))
print (len(argv))
for a in argv:
    print(a)

for x in range(0, len(argv)):
    print(f'{x}: {argv[x]}')
