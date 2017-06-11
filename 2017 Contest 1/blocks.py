def getNum(ch):
	return ord(ch)-97

let = [0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]
fi = open("blocks.in")
fo = open("blocks.out", "w+")
stuff = fi.read().split("\n")
stuff.pop(0)
for x in stuff:
	w1 = list(x.split(" ")[0])
	w2 = list(x.split(" ")[1])
	tempLet = [0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]
	for i in w1:
		tempLet[getNum(i)] = tempLet[getNum(i)] + 1
	w1 = tempLet
	tempLet = [0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]
	for i in w2:
		tempLet[getNum(i)] = tempLet[getNum(i)] + 1
	w2 = tempLet
	w2 = [a-b for a,b in zip(w2,w1)]
	w2 = [i if i >= 0 else 0 for i in w2]
	combined = [a+b for a,b in zip(w1, w2)]
	let = [a+b for a,b in zip(let, combined)]
for x in let:
	print >>fo, x
fi.close()
fo.close()