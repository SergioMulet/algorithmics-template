#-------------------------------------------------------------------------------
# Name:        PrimTimes2_0
# Purpose:
#
# Author:      uo296503
#
# Created:     14/03/2024
# Copyright:   (c) uo296503 2024
# Licence:     <your licence>
#-------------------------------------------------------------------------------
import Prim2_0 as Prim
import time
import random
import Helper

def main():
    n = 256
    for i in range(0, 7, 1):
        t1 = time.time()
        graph = Helper.triangularMatrixRandomIntegers(n, 100, 999)
        complete_graph = Prim.complete_graph_from_triangular(graph)
        mst_edges = Prim.prim_algorithm(complete_graph)
        t2 = time.time()
        print("size = ", n, "time =", int(1000*(t2-t1)), "milliseconds)")
        n = n*2


if __name__ == '__main__':
    main()