
block=[]
pr=[]
temp_frag=[]
total_frag=[]


print("\n\n worst fit \n\n")
n = int(input("enter number of process :"))
for i in range(n):
    pr.append(int(input("enter process size :")))

m = int(input("enter number of block :"))
for i in range(m):
    block.append(int(input("enter block size :")))
    
# for j in range(n):
#     for i in range(len(block)):
#         if(pr[j]<=block[i]):
#             temp_frag.append(block[i]-pr[j])
#             print(temp_frag)
#         maxv=max(temp_frag)
#         for i in range(len(temp_frag)):
#             if (maxv == (block[i]-pr[j])):
#                 total_frag=total_frag+(block[i]-pr[j])
#                 block[i]=0
#     temp_frag=[]
# print(total_frag)

for i in pr:
    for j in block:
        if(i<=j):
            temp_frag.append(int(j-i))
    print(temp_frag)
    maxv=max(temp_frag)
    print("maxv :",maxv)
    temp_frag=[]
        
    for j in range(len(block)):
        if((block[j]-i)==maxv):
            total_frag.append(int(block[j]-i))
            block[j]=0
print("ans")
print("totan fragmantation for each block :",total_frag)

x=0
for i in total_frag:
    x=x+i
print("ans : ",x)