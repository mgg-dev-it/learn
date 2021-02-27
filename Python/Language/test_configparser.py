# https://docs.python.org/3/library/configparser.html

import configparser

cfg = configparser.ConfigParser()

cfg.read_file(open('defaults.cfg'))

cfg.read('test.cfg')

