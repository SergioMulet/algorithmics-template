# -*- coding: utf-8 -*-
"""
PythonLoop4
"""
from time import time
def loop4(n):
    cont = 0
    for i in range(1, n + 1):  # n
        for j in range(1, i + 1):  # n
            for k in range(1, j + 1):  # n
                cont += 1
    return cont

if __name__ == "__main__":
    n_times = int(input("Enter the number of repetitions: "))
    print("n\ttime\trepetitions\tcounter")
    n = 100
    while n <= 819200:
        start_time = time()
        for _ in range(n_times):
            c = loop4(n)
        end_time = time()
        print(f"{n}\t{(end_time - start_time) * 1000}\t{n_times}\t\t{c}")
        n *= 2