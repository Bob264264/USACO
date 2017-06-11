fi = open("cowsignal.in")
fo = open("cowsignal.out", "w+")
stuff = fi.read().split("\n")
mag = int(stuff[0].split(" ")[2])
stuff.pop(0)
for x in range(len(stuff)):
	stuff[x] = "".join([i*mag for i in stuff[x]])
for x in stuff:
	for i in range(mag):
			print >>fo, x
fi.close()
fo.close()