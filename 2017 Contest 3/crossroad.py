fi = open("crossroad.in")
fo = open("crossroad.out", "w+")
data = fi.read().split('\n')
data.pop(0)
data = [x.split(' ') for x in data]
count = 0
cows = [-1] * 10

for i in data:
	if cows[int(i[0])] == -1:
		cows[int(i[0])] = int(i[1])
	elif cows[int(i[0])] != int(i[1]):
		count += 1
		cows[int(i[0])] = int(i[1])
print >>fo, count
fi.close()
fo.close()