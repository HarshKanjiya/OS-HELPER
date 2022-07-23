from urllib import request


def main(n,allocations,requests):
    finish=[]
    allocation =[]
    request=[]
    work=[0,0,0]
    no=n

    allo= str(allocations).split(",")
    req= str(requests).split(",")
    for i in range(n):
        allo[i]=int(allo[i])
        req[i]=int(req[i])
        
    for i in range(n):
        p = str(all[i]).split('')
        q = str(req[i]).split('')
        allocation.append(p)
        request.append(q)
            
            
    
    for i in range(no):
        finish.append('f')
    
    print('finish arry :',finish)

    for i in range(no):
        for i in range(no):
            if finish[i]=='f' :
                if (request[i]<=work):
                    for j in range(3):
                        work[j]=work[j]+allocation[i][j]
                    finish[i]='t'
                    print('work :',work)
        print('\n\nfinish :',finish)
        if('f' not in finish):
            break

    if('f' in finish):
        print('\n\nDEADLOCK FOUND !!!\n\n')


    if('f' not in finish):
        print('\n\nNO DEADLOCK HERE !!!\n\n')


    print('allocation :',allocation)
    print('request :',request)

a='710,200,303,201,002'
b='000,202,000,100,002'
main(5,a,b)