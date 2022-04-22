import requests
from bs4 import BeautifulSoup
import json
import pymysql
import time

url = 'https://ncov.dxy.cn/ncovh5/view/pneumonia?from=timeline&isappinstalled=0'  #请求地址
headers = {'user-agent':'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.131 Safari/537.36'}#创建头部信息
response =  requests.get(url,headers = headers)  #发送网络请求
#print(response.content.decode('utf-8'))#以字节流形式打印网页源码
content = response.content.decode('utf-8')

soup = BeautifulSoup(content, 'html.parser')
listB = soup.find_all(name='script',attrs={"id":"getAreaStat"})
china_messages = str(listB)[53:-21]
china_messages_json = json.loads(china_messages)

db = pymysql.connect(host="localhost", user="root", password="root", database="yiqing", charset='utf8')
cursor = db.cursor()

china_list=[]
city_list=[]

for k in range(len(china_messages_json)):
    chinavalue=(time.strftime('%Y-%m-%d %H:%M:%S',time.localtime(time.time())),china_messages_json[k].get('provinceShortName'),"Null",china_messages_json[k].get('currentConfirmedCount'),
                china_messages_json[k].get('confirmedCount'),china_messages_json[k].get('suspectedCount'),
                china_messages_json[k].get('curedCount'),china_messages_json[k].get('deadCount'),china_messages_json[k].get('locationId'))
    china_list.append(chinavalue)
    # cnt+=1
    provinceName=china_messages_json[k].get('provinceShortName')
    city_json=china_messages_json[k].get('cities')
    for p in range(len(city_json)):
        cityvalue=(time.strftime('%Y-%m-%d %H:%M:%S',time.localtime(time.time())),provinceName,city_json[p].get('cityName'),city_json[p].get('currentConfirmedCount'),city_json[p].get('confirmedCount'),city_json[p].get('suspectedCount'),city_json[p].get('curedCount'),city_json[p].get('deadCount'),city_json[p].get('locationId'))
        china_list.append(cityvalue)
        # cnt+=1
print(china_list)

sql_world = "INSERT INTO china values (%s,%s,%s,%s,%s,%s,%s,%s,%s)"
worldTuple = tuple(china_list)

try:
    cursor.executemany(sql_world,worldTuple)
    db.commit()
except:
    print('执行失败，进入回调3')
    db.rollback()

db.close()
