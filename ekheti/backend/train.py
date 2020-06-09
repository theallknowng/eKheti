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
from keras.utils.vis_utils import plot_model


# load dataset
dataframe = pandas.read_csv("sdata.csv", header=0)
dataset = dataframe.values
X = dataset[:,0:28].astype(float)
Y = dataset[:,28]

one_hot_labels = keras.utils.to_categorical(Y, num_classes=7)

# define baseline model
def baseline_model():
	# create model
    model = Sequential()
    model.add(Dense(56, input_dim=28, activation='relu'))
    model.add(Dense(112, input_dim=56, activation='relu'))
    model.add(Dense(7, activation='softmax'))
    plot_model(model, to_file='model_plot.png', show_shapes=True, show_layer_names=True)
	# Compile model
    model.compile(loss='categorical_crossentropy', optimizer='adam', metrics=['accuracy'])
    print(model.summary())
    return model

model = baseline_model()
model.fit(X, one_hot_labels, epochs=10, batch_size=1)
model.save_weights("model1.h5")
