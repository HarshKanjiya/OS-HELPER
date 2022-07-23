
def main(n,blockS,processS):
	
    processSize= (processS).split(",")
    blockSize= (blockS).split(",")
    m = len(blockSize)
    for i in range(n):
        processSize[i]=int(processSize[i])
    for i in range(m):
        blockSize[i] =int(blockSize[i])
    

    allocation = [-1] * n

	# Initially no block is assigned to any process

	# pick each process and find suitable blocks
	# according to its size ad assign to it
    for i in range(n):
        for j in range(m):
            if int(blockSize[j]) >= processSize[i] :
                allocation[i] = j
                blockSize[j]-= processSize[i]
                break
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
# block = '100,500,200,300,600'
# proces = '212,417,112,426'
# n=4

# print(main(n,block,proces))
	
