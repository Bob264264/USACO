fi = open("hps.in")
fo = open("hps.out", "w+")
data = fi.read().split('\n')
data.pop(0)
data = [x.split(" ") for x in data]
# [data.remove(x) for x in data if x[0] == x[1]]
games = [0, 0]
for i in data:
	if (int(i[0]) + 1) % 3 == int(i[1]) % 3:
		games[0] += 1
	elif (int(i[0]) + 2) % 3 == int(i[1]) % 3:
		games[1] += 1
fo.write(str(max(games)))
fi.close()
fo.close()