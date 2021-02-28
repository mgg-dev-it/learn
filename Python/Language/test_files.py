# https://docs.python.org/3/library/fileinput.html
# https://docs.python.org/3/library/os.html

import os

cwd = os.getcwd()
print (f'Current working directory is: \'{cwd}\'')

dircontent = os.listdir()
print(dircontent)
for d in dircontent:
    print(d)

