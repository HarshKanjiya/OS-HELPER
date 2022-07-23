def main(n,at_str,bt_str):
    
    #initialization
    at= (at_str).split(",")
    bt= (bt_str).split(",")
    for i in range(n):
        at[i]=int(at[i])
        bt[i]=int(bt[i])
    ct=list()
    tat=list()
    wt=list()
    min_value = 0-min(at)
    min_value = abs(min_value)
    print(min_value)
    sum=0
    index=list()
    for i in range(n):
        index.append(i+1)
    zipped = sorted(zip(at,bt,index))
    sum = zipped[0][1]
    ct.append(zipped[0][1])
    
    #calculation of ct
    
    
                
    # for i in range(1,n):
    #     if(zipped[i][0]<sum):
    #         ct.append(ct[i-1]+zipped[i][1]+min_value)
    #         sum=sum + zipped[i][1]
    #     else:
    #         diff = (zipped[i][0]-sum)
    #         ct.append(ct[i-1]+zipped[i][1]+diff+min_value)
    #         sum=sum + zipped[i][1]
    
    
    #calculating tat,wt from ct        
    for i in range(n):
        tat.append(ct[i] - zipped[i][0])
        
    for i in range(n):
        wt.append(tat[i] - zipped[i][1])
        
    #indexing and printing
    ans=list()
    for i in range(n):
        ans.append([zipped[i][2],ct[i],tat[i],wt[i]])
        
    ans=sorted(ans)

    s=''
    for i in range(n):
        s=s+str(ans[i][1])+','
    
    for i in range(n):
        s=s+str(ans[i][2])+','
    
    for i in range(n):
        s=s+str(ans[i][3])+','
    
    return s

a='2,3,4,5'
b='4,2,6,4'
print(main(4,a,b))