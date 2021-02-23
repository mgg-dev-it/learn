# https://requests.kennethreitz.org/en/master/
# $ python -m pip install requests
# $ python -m pip install requests --trusted-host pypi.org --trusted-host files.pythonhosted.org
# $ python -m pip install requests  config --global http.sslVerify false
# $ pip install --upgrade pip --trusted-host pypi.org --trusted-host files.pythonhosted.org
# $ pip install --upgrade pip --tr  config --global http.sslVerify falseusted-host pypi.org --trusted-host files.pythonhosted.org
# $ e:\Users\MG\prog\python-3_9_2\python.exe -m pip install --upgrade pip
# $ e:\Users\MG\prog\python-3_9_2\python.exe -m pip install --upgrade pip --trusted-host pypi.org --trusted-host files.pythonhosted.org
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

