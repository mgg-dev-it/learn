# https://docs.python.org/3/library/configparser.html

import configparser

cfg = configparser.ConfigParser()

# try:
#     cfg.read_file(open('defaults.cfg'))
# except FileNotFoundError as fnfe:
#     print('Handled FileNotFoundError:', fnfe)
# except Exception as e:
#     print('something went wrong:', e)

# a = cfg.read('test.cfg')
# print (a)

# print(cfg['french'])

cfg.read_file(open('test.cfg'))
print(cfg['french'])
