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
# print (type (r.html.links))
# r.html.render
# print (r.html.text)

r.html.render()

fout = open('a.html', 'wt', encoding='utf-8')
print(r.html.raw_html, file=fout)
# print(r.html.text, file=fout)
# print(r.html.full_text, file=fout)
fout.close()
