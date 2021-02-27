# https://docs.python.org/3/library/os.html
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

