# https://requests.kennethreitz.org/en/master/
# $ python -m pip install requests
import requests
import json

url = "http://httpbin.org"
filename = "httpbin_org.html"
r = requests.get(url)
# r = requests.post('https://httpbin.org/post', data = {'key':'value'})

# r = requests.get('https://api.github.com/events')
# print ("--------------------------------------------------------------")
# print ("--------------------------------------------------------------")
# print ("--------------------------------------------------------------")
# print (r.status_code)
# print (r.encoding)
# print (r.headers)
# print ( type (r.headers))
# print (r.text)

# d = dict(r.headers)

# print (json.dumps(d, indent=1))

fout = open(filename, 'wt', encoding='utf-8')
print(r.status_code, file=fout)
print("--------", file=fout)
print(r.encoding, file=fout)
print("--------", file=fout)
print(json.dumps(dict(r.headers), indent = 4), file = fout)
print("--------", file=fout)
s=r.text
print(s, file=fout)
fout.close()

