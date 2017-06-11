fi = open("notlast.in")
fo = open("notlast.out", "w+")
data = fi.read().split('\n')
data.pop(0)
data = [x.split(" ") for x in data]
milk = {}
for i in data:
	if i[0] not in milk.keys():
		milk[i[0]]=int(i[1])
	else:
		milk[i[0]] += int(i[1])
del data
amounts = sorted(milk.values())
if len(amounts) < 2:
	fo.write("Tie\n")
else:
	if len(milk.keys()) < 7:
		amounts.insert(0,0)
	out = []
	target = sorted(list(set(amounts)))[1]
	for i in milk.keys():
		if milk[i]==target:
			out.append(i)
	if len(out) > 1:
		fo.write("Tie\n")
	else:
		fo.write(out[0]+"\n")

fi.close()
fo.close()