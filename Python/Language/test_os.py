# https://docs.python.org/3/library/os.html
# https://docs.python.org/3/library/os.path.html

import os

cwd = os.getcwd()
# print ('Current working directory is:', cwd)
print (f'Current working directory is: \'{cwd}\'')

print (os.curdir)

env = os.environ
print(type(env))
for e in env:
    #clearprint (e, ' = ', os.environ[e])
    print (f'{e} = { os.environ[e]}')

print (os.path.expanduser("~"))
print (os.path.expanduser("~abc"))

print (f'os.sep = {os.sep}')
print (f'os.altsep = {os.altsep}')
print (f'os.extsep = {os.extsep}')
print (f'os.pathsep = {os.pathsep}')
print (f'os.defpath = {os.defpath}')
print (f'os.devnull = {os.devnull}')

print (os.path.join("abc", "def", "ghi"))
print (os.path.join("c:", os.sep, "abc", "def", "ghi"))

