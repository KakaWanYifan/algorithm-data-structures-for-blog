import heapq

q = []
heapq.heappush(q, 3)
heapq.heappush(q, 1)
heapq.heappush(q, 4)
heapq.heappush(q, 1)
heapq.heappush(q, 5)
heapq.heappush(q, 9)
heapq.heappush(q, 2)
heapq.heappush(q, 6)

print(heapq.heappop(q))
print(heapq.heappop(q))
print(heapq.heappop(q))
print(heapq.heappop(q))




