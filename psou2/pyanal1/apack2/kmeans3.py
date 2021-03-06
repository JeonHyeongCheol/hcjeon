'''
Created on 2018. 12. 7.

비계층적 클러스터링 : k-means 알고리즘 사용
'''
from sklearn.datasets import make_blobs
import matplotlib.pyplot as plt

#print(make_blobs())
x, _ = make_blobs(n_samples = 150, n_features = 2, centers = 3, \
                  cluster_std = 0.5, shuffle = True, random_state = 0) # n_samples : 샘플 갯수.
#print(x)
plt.scatter(x[:,0], x[:,1], c='lightgray', marker='o', s=50)
plt.grid(True)
plt.show()

from sklearn.cluster import KMeans
init_centroid = 'random'
#init_centroid = 'k-means++'

kmodel = KMeans(n_clusters=3, init=init_centroid, random_state=0)
print(kmodel)
pred = kmodel.fit_predict(x)
print('pred : ', pred)

plt.scatter(x[pred==0,0], x[pred==0,1], c='r', marker='o', label = 'cluster1')
plt.scatter(x[pred==1,0], x[pred==1,1], c='g', marker='s', label = 'cluster2')
plt.scatter(x[pred==2,0], x[pred==2,1], c='b', marker='v', label = 'cluster3')
plt.legend()
plt.grid(True)
plt.show()

# KMeans의 n_clusters 수 구하기 방법 1 : elbow
def elbow(x):
    sse = []
    for i in range(1, 11):
        km = KMeans(n_clusters=i, init=init_centroid, random_state=0)
        km.fit(x)
        sse.append(km.inertia_)
    plt.plot(range(1, 11), sse, marker='o')
    plt.xlabel('cluster su')
    plt.ylabel('see')
    plt.show()

elbow(x)

print('**' * 50)

# KMeans의 n_clusters 수 구하기 방법 2 : silhoutte
'''
실루엣(silhouette) 기법
클러스터링의 품질을 정랼적으로 계산해 주는 방법이다.
클러스터의 개수가 최적화되어 있으면 실루엣 계수의 값은 1에 가까운 값이 된다.
실루엣 기법은 k-means 클러스터링 기법 이외에 다른 클러스터링에도 적용이 가능하다
'''
import numpy as np
from sklearn.metrics import silhouette_samples
from matplotlib import cm

# 데이터 X와 X를 임의의 클러스터 개수로 계산한 k-means 결과인 y_km을 인자로 받아 각 클러스터에 속하는 데이터의 실루엣 계수값을 수평 막대 그래프로 그려주는 함수를 작성함.
# y_km의 고유값을 멤버로 하는 numpy 배열을 cluster_labels에 저장. y_km의 고유값 개수는 클러스터의 개수와 동일함.
def plotSilhouette(x, pred):
    cluster_labels = np.unique(pred)
    n_clusters = cluster_labels.shape[0]   # 클러스터 개수를 n_clusters에 저장
    sil_val = silhouette_samples(x, pred, metric='euclidean')  # 실루엣 계수를 계산
    y_ax_lower, y_ax_upper = 0, 0
    yticks = []
    for i, c in enumerate(cluster_labels):
        # 각 클러스터에 속하는 데이터들에 대한 실루엣 값을 수평 막대 그래프로 그려주기
        c_sil_value = sil_val[pred == c]
        c_sil_value.sort()
        y_ax_upper += len(c_sil_value)
       
        plt.barh(range(y_ax_lower, y_ax_upper), c_sil_value, height=1.0, edgecolor='none')
        yticks.append((y_ax_lower + y_ax_upper) / 2)
        y_ax_lower += len(c_sil_value)
   
    sil_avg = np.mean(sil_val)         # 평균 저장
    plt.axvline(sil_avg, color='red', linestyle='--')   # 계산된 실루엣 계수의 평균값을 빨간 점선으로 표시함
    plt.yticks(yticks, cluster_labels + 1)
    plt.ylabel('클러스터')
    plt.xlabel('실루엣 개수')
    plt.show() 
'''
그래프를 보면 클러스터 1~3 에 속하는 데이터들의 실루엣 계수가 0으로 된 값이 아무것도 없으며, 실루엣 계수의 평균이 0.7 보다 크므로 잘 분류된 결과라 볼 수 있다.
'''
X, y = make_blobs(n_samples=150, n_features=2, centers=3, cluster_std=0.5,
                   shuffle=True, random_state=0)
km = KMeans(n_clusters=3, random_state=0) 
y_km = km.fit_predict(X)

plotSilhouette(X, y_km)

