import pandas as pd
import random
dataOrg = pd.read_csv('data.csv',header=None,low_memory=False)

dataGen = {}

for rowIndex, row in dataOrg.iterrows():
    colIndex = 0
    #print(type(row[0])
    for col in row:
        if rowIndex == 0:
            temp = {col : []}
            dataGen.update(temp)

    for _ in range(0,28):
        r1 = random.randint(0, 27)
        col = row[r1]
        if rowIndex != 0:
            try:
                
                newColinc = float(col) + float(col)*0.2
                newColdec = float(col) - float(col)*0.2
                
            except:
                pass
            
            #decrement
            dictIndex = 0
            for key, value in dataGen.items():
                #print(dataGen)
                    
                if(dictIndex == r1):
                    dataGen[key].append(newColdec)

                else:
                    dataGen[key].append(row[dictIndex])
                dictIndex += 1

            #increment
            dictIndex = 0
            for key, value in dataGen.items():
                #print(dataGen)
                if(dictIndex == r1):
                    dataGen[key].append(newColinc)

                else:
                    dataGen[key].append(row[dictIndex])
                dictIndex += 1
                    
        colIndex += 1
    

#print(dataGen)

df = pd.DataFrame.from_dict(dataGen)
df.to_csv("data.csv")