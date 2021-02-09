import heapq

class C:
    def __init__(self, key, value):
        self.k = key
        self.v = value

    def __lt__(self, other):
        if self.v < other.v:
            return False
        else:
            return True

    def p(self):
        print(self.k, self.v)


c1 = C("c1", 3)
c2 = C("c2", 1)
c3 = C("c3", 4)
c4 = C("c4", 5)
c5 = C("c5", 9)

h = []
heapq.heappush(h, c1)
heapq.heappush(h, c2)
heapq.heappush(h, c3)
heapq.heappush(h, c4)
heapq.heappush(h, c5)
heapq.heappop(h).p()
heapq.heappop(h).p()
heapq.heappop(h).p()
heapq.heappop(h).p()
heapq.heappop(h).p()

