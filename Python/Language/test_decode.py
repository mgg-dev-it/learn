f = open('d:\\aaa.txt', 'rt')
txt = f.read()
f.close()
print(len(txt))

tmp = ""
out=""
for letter in txt:
    if letter == " ":
        if tmp != "":
#            print(chr(int(tmp)))
            out += chr(int(tmp))
#            print(int(tmp))
            tmp=""
    else:
        tmp = tmp + letter

out += chr(int(tmp))
print(out)