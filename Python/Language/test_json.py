# https://docs.python.org/3/library/json.html
# https://www.w3schools.com/python/python_json.asp
# https://realpython.com/python-json/

import json

print (json.dumps(['foo', {'bar': ('baz', None, 1.0, 2)}]))

print (json.dumps(['foo', {'bar': ('baz', None, 1.0, 2)}], sort_keys=True, indent=4))

print(json.dumps({'4': 5, '6': 7}, sort_keys=True, indent=4))

o = json.loads('["foo", {"bar":["baz", null, 1.0, 2]}]')

print (type (o))

print (o)

print (json.loads ('{    "4": 5,    "6": 7}'))

#---

data = {
    "president": {
        "name": "Zaphod Beeblebrox",
        "species": "Betelgeusian"
    }
}
print (json.dumps (data))
print (json.dumps (data, indent=4))

#---

json_string = """
{
    "researcher": {
        "name": "Ford Prefect",
        "species": "Betelgeusian",
        "relatives": [
            {
                "name": "Zaphod Beeblebrox",
                "species": "Betelgeusian"
            }
        ]
    }
}
"""
data = json.loads(json_string)
print (data)
