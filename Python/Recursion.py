import sys
sys.setrecursionlimit(10**6)
set = {}
def count_blocks_recursive(not_visited):
    if len(not_visited) & 1:
        return 0
    if not not_visited:
        return 1
    if not_visited not in set:
        i, j = min(not_visited)
        set[not_visited] = count_blocks_recursive(not_visited - {(i, j), (i, j + 1)}) + count_blocks_recursive(not_visited - {(i, j), (i + 1, j)})
    return set[not_visited]

def count_blocks(m, n):
    return count_blocks_recursive(frozenset((i, j) for i in range(max(m, n)) for j in range(min(m, n))))

def BlocksGame(N):
    return count_blocks(3,N)
    
print(BlocksGame(1000))
