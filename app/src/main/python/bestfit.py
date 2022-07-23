
def main(n,blockS,processS):

    processSize= (processS).split(",")
    blockSize= (blockS).split(",")
    m = len(blockSize)
    for i in range(n):
        processSize[i]=int(processSize[i])
    for i in range(m):
        blockSize[i] =int(blockSize[i])
        
    allocation = [-1] * n
    for i in range(n):
        bestIdx = -1
        for j in range(m):
            if blockSize[j] >= processSize[i]:
                if bestIdx == -1:
                    bestIdx = j
                elif(blockSize[bestIdx] > blockSize[j]):
                    bestIdx = j
            if bestIdx != -1:
                allocation[i] = bestIdx
                blockSize[bestIdx] -= processSize[i]
                
    ans=list()
    for i in range(n):
        if allocation[i] != -1:
            ans.append(allocation[i] + 1)
        else:
            ans.append(0)
    
    s=''
    for i in ans:
        s=s+str(i)+','
    return s

# Driver code
# blockSize = '100, 500, 200, 300, 600'
# processSize = '212, 417, 112, 426'
# n=4

# print(main(n,blockSize,processSize))
	
# This code is contributed by PranchalK
