# https://requests.kennethreitz.org/en/master/
# $ python -m pip install requests
import requests

r = requests.get('http://httpbin.org')
# r = requests.post('https://httpbin.org/post', data = {'key':'value'})

# r = requests.get('https://api.github.com/events')
print ("--------------------------------------------------------------")
print ("--------------------------------------------------------------")
print ("--------------------------------------------------------------")
print (r.status_code)
print (r.encoding)
print (r.headers)
print (r.text)
