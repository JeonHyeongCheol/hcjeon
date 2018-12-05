'''
Created on 2018. 12. 5.

분류 알고리즘 : 나이브 베이즈 - 조건부 확률
'''

import numpy as np
from sklearn.naive_bayes import GaussianNB
from sklearn import metrics

x = np.array([
    [1, 0, 0, 0, 0],
    [1, 1, 0, 0, 0],
    [1, 1, 1, 0, 0],
    [1, 1, 1, 1, 0],
    [1, 1, 1, 1, 1]
])

y = np.array([1, 2, 3, 4, 5])

model = GaussianNB().fit(x, y) # 모델만듬.
print(model)
pred = model.predict(x)
print(pred)
ac = metrics.accuracy_score(y, pred)
print("정확률 : ", ac)

# 새로운 X 값으로 분류
#my_data = [[0,1,5,0,0]]
my_data =[[1,6,5,8,0]]
new_pred = model.predict(my_data)
print(new_pred)

print('**' * 50)

from sklearn import datasets
from sklearn.model_selection import train_test_split
from sklearn.preprocessing import StandardScaler
from sklearn.metrics import accuracy_score

iris = datasets.load_iris() # dataset에서 여러가지 데이터를 가져와서 사용 할 수 있음.
x = iris.data[:, [2,3]] # petal.length, petal.width
y = iris.target

print(type(x))

# 학습용 / 검정용 자료로 분리.
x_train, x_test, y_train, y_test = train_test_split(x, y, test_size = 0.3, random_state = 0) # test_szie : 분석할 데이터와 테스트데이터를 분리(0.3 : 0.7), random_state : 난수 고정 값.

# 표준화(Scaling) - 전처리 : 안정성, 수렴속도를 향상. 오버플로, 언더플로 방지 효과.
sc = StandardScaler()
sc.fit(x_train)
x_train_std = sc.transform(x_train)
x_test_std = sc.transform(x_test)

ml = GaussianNB() # svm2_iris에서 가져온 값에서 GaussianNB으로만 바꿈.(모델만 바꿔서 사용함). 같은곳에 만들어서..ㅎ
 
result = ml.fit(x_train_std, y_train) # 학습자료로 모델 실행.
print(result)

y_pred = ml.predict(x_test_std) # 학습모델을 검정
print('실제값 : ', y_test)
print('추정값 : ', y_pred)

print('총 검정 수 %d, 오류 수 %d'%(len(y_test), (y_test != y_pred).sum()))

# 정확도 구하기 1
print('분류 정확도 : %.3f'%accuracy_score(y_test, y_pred))

# 정확도 구하기 2
import pandas as pd
con_mat = pd.crosstab(y_test, y_pred, rownames=['예측값'], colnames=['관측값'])
print(con_mat)
print((con_mat[0][0] + con_mat[1][1] + con_mat[2][2]) / len(y_test)) # 정확도

# 새로운 petal.length, petal.width 자료로 꽃 종류 예측(분류)
#print(x_test_std) #[[0.70793846  1.51006688]..]
new_data = np.array([[0.7,1.5],[5.7,5.5],[3.1,1.2]])
new_data_std = sc.transform(new_data) # 표준화.
print(new_data)
new_pred = ml.predict(new_data_std)
print('꽃 종류 예측 결과 : ', new_pred)