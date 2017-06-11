fi = open("square.in")
fo = open("square.out", "w+")
stuff = fi.read().split("\n")
r1 = stuff[0].split(" ")
r2 = stuff[1].split(" ")
r1 = [int(x) for x in r1]
r2 = [int(x) for x in r2]
maxX = int(max(r1[0], r1[2], r2[0], r2[2]))
minX = int(min(r1[0], r1[2], r2[0], r2[2]))
maxY = int(max(r1[1], r1[3], r2[1], r2[3])) 
minY = int(min(r1[1], r1[3], r2[1], r2[3]))
maxDist = max(abs(maxX-minX), abs(maxY-minY))
area = pow(maxDist,2)
print >>fo, area
fi.close()
fo.close()