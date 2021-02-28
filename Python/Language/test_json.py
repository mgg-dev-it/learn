# https://docs.python.org/3/library/json.html
# https://www.w3schools.com/python/python_json.asp
# https://realpython.com/python-json/

import json

print(json.dumps(['foo', {'bar': ('baz', None, 1.0, 2)}]))

print(json.dumps(
    ['foo', {'bar': ('baz', None, 1.0, 2)}], sort_keys=True, indent=4))

print(json.dumps({'4': 5, '6': 7}, sort_keys=True, indent=4))

o = json.loads('["foo", {"bar":["baz", null, 1.0, 2]}]')

print(type(o))

print(o)

print(json.loads('{    "4": 5,    "6": 7}'))

# ---

data = {
    "president": {
        "name": "Zaphod Beeblebrox",
        "species": "Betelgeusian"
    }
}
print(json.dumps(data))
print(json.dumps(data, indent=4))

# ---

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
print(data)

# ---

menu = {
    "breakfast": {
        "hours": "7-11",
        "items": {
            "breakfast burritos": "$6.00",
            "pancakes": "$4.00"
        }
    },
    "lunch": {
        "hours": "11-3",
        "items": {
            "hamburger": "$5.00"
        }
    },
    "dinner": {
        "hours": "3-10",
        "items": {
            "spaghetti": "$8.00"
        }
    }
}
print (type(menu))
print (menu)
menu_json = json.dumps(menu)
#print(menu_json)
menu2 = json.loads(menu_json)
print (type(menu2))
print (menu2)

