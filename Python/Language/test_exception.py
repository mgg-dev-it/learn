# https://docs.python.org/3/library/exceptions.html

print('program start')

#print (1/0)

print(1/2)

try:
    #print(1/0)
    print (a)
except ZeroDivisionError as zde:
    print('Handled ZeroDivisionError:', zde)
except Exception as e:
    print('something went wrong:', e)

print('program end')
