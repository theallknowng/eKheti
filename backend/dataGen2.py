import pandas as pd
dataOrg = pd.read_csv('idealConditions - Sheet1.csv',header=None)

dataGen = {}

for rowIndex, row in dataOrg.iterrows():
    colIndex = 0
    #print(type(row[0])
    for col in row:
        if rowIndex == 0:
            temp = {col : []}
            dataGen.update(temp)
    
    for col in row[:-2]:
        if rowIndex != 0:
            try:
                newColinc = float(col) + float(col)*0.05
                newColdec = float(col) - float(col)*0.05

            except:
                pass
            
            #decrement
            dictIndex = 0
            for key, value in dataGen.items():
               # print(dataGen)
                if(dictIndex == colIndex):
                    dataGen[key].append(newColdec)

                else:
                    dataGen[key].append(row[dictIndex])
                dictIndex += 1

            #increment
            dictIndex = 0
            for key, value in dataGen.items():
               # print(dataGen)
                if(dictIndex == colIndex):
                    dataGen[key].append(newColinc)

                else:
                    dataGen[key].append(row[dictIndex])
                dictIndex += 1
                   
        colIndex += 1
    

#print(dataGen)

df = pd.DataFrame.from_dict(dataGen)
df.to_csv("data.csv")