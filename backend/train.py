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


# load dataset
dataframe = pandas.read_csv("data.csv", header=0)
dataset = dataframe.values
X = dataset[:,0:24].astype(float)
Y = dataset[:,24]

one_hot_labels = keras.utils.to_categorical(Y, num_classes=7)

# define baseline model
def baseline_model():
	# create model
    model = Sequential()
    model.add(Dense(48, input_dim=24, activation='relu'))
    model.add(Dense(96, input_dim=48, activation='relu'))
    model.add(Dense(7, activation='softmax'))
	# Compile model
    model.compile(loss='categorical_crossentropy', optimizer='adam', metrics=['accuracy'])
    return model

model = baseline_model()
model.fit(X, one_hot_labels, epochs=10, batch_size=1)
model.save_weights("model1.h5")