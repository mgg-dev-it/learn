import os

cwd = os.getcwd()
print (f'Current working directory is: \'{cwd}\'')

dircontent = os.listdir()
print(dircontent)
for d in dircontent:
    print(d)

