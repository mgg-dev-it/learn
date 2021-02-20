# https://requests-html.kennethreitz.org/
# $ pipenv install requests-html
# $ python -m pip install requests-html

import requests_html

from requests_html import HTMLSession

session = HTMLSession()

r = session.get('https://python.org/')

print ("--------------------------------------------------------------")
print ("--------------------------------------------------------------")
print ("--------------------------------------------------------------")
# print (r.html.links)
# print (r.html.absolute_links)
print (type (r.html.links))
