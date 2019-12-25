import pandas
from keras.models import Sequential
from keras.layers import Dense
from keras.wrappers.scikit_learn import KerasClassifier
from keras.utils import np_utils
from sklearn.model_selection import cross_val_score
from sklearn.model_selection import KFold
from sklearn.preprocessing import LabelEncoder
from sklearn.pipeline import Pipeline
import keras
import sys
import json
import requests


# define baseline model
def baseline_model():
	# create model
    model = Sequential()
    model.add(Dense(56, input_dim=28, activation='relu'))
    model.add(Dense(112, input_dim=56, activation='relu'))
    model.add(Dense(7, activation='softmax'))
	# Compile model
    model.compile(loss='categorical_crossentropy', optimizer='adam', metrics=['accuracy'])
    return model

model = baseline_model()

model.load_weights("model1.h5")
# data = sys.argv[1]
data = '{"pH min":5.7,"pH max":7,"nitrogen min":109,"nitrogen max":146,"phosphorus min":20,"phosphorus max":30,"potasium min":78,"potasium max":115,"calcium min":270,"calcium max":990,"magnesium min":46,"magnesium max":96,"sulphur min":10,"sulphur max":10,"iron min":44,"iron max":46,"zinc min":3.87,"zinc max":5.87,"manganese min":4.81,"manganese max":4.81,"copper min":21,"copper max":26,"boron min":1.25,"boron max":2.25,"temperature min":25,"temperature max":35,"precipitation min":50,"precipitation max":60,"irrigation":"yes ","region":"barshi"}'

data = json.loads(data)

dataframe = pandas.DataFrame(data,index=[0])
dataset = dataframe.values
X = dataset[:,0:28].astype(float)

op = model.predict_classes(X)
print(op)
