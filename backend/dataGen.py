import pandas as pd
dataOrg = pd.read_csv('data.csv',header=0)
ds = dataOrg.sample(frac=1)
ds.to_csv('sdata.csv')
