from random import random
from frame import progress

sizes = [
    10,
    #300,
    #800,
    #2000
]
for size in sizes:
    with open("A%d.txt" % size, "w") as file:
        file.write("%d %d\n" % (size, size + 1))
        print(size)
        for row in range(size):
            progress(row / size)
            for col in range(size + 1):
                file.write("%.2f " % (random() * 1000))
            file.write("\n")
        progress(1)
        print()
    with open("B%d.txt" % size, "w") as file:
        file.write("%d\n" % size)
        for index in range(size):
            file.write("%.2f " % (random() * 1000))