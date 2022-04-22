import requests
from bs4 import BeautifulSoup
import json
import pymysql
import time
import datetime

url = 'https://ncov.dxy.cn/ncovh5/view/pneumonia?from=timeline&isappinstalled=0'  #请求地址
headers = {'user-agent':'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.131 Safari/537.36'}#创建头部信息
response =  requests.get(url,headers = headers)  #发送网络请求
#print(response.content.decode('utf-8'))#以字节流形式打印网页源码
content = response.content.decode('utf-8')

soup = BeautifulSoup(content, 'html.parser')
listB = soup.find_all(name='script',attrs={"id":"getListByCountryTypeService2true"})
world_messages = str(listB)[95:-21]
world_messages_json = json.loads(world_messages)
print(listB)
print(world_messages)



worldList = []
for k in range(len(world_messages_json)):
    worldvalue = (world_messages_json[k].get('id'),time.strftime('%Y-%m-%d %H:%M:%S',time.localtime(time.time())),
             world_messages_json[k].get('continents'),world_messages_json[k].get('provinceName'),
             world_messages_json[k].get('cityName'),world_messages_json[k].get('confirmedCount'),
             world_messages_json[k].get('suspectedCount'),world_messages_json[k].get('curedCount'),world_messages_json[k].get('deadCount'),world_messages_json[k].get('locationId'),
             world_messages_json[k].get('countryShortCode'),)
    worldList.append(worldvalue)
db = pymysql.connect(host="localhost", user="root", password="root", database="yiqing", charset='utf8')
# db = pymysql.connect(host="1.15.91.39", user="root", password="root", database="yiqing", charset='utf8')
cursor = db.cursor()
#sql_clean_world = "TRUNCATE TABLE world_map"
sql_world = "INSERT INTO world_map values (%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s)"
worldTuple = tuple(worldList)
print(worldTuple)


try:
    cursor.executemany(sql_world,worldTuple)
    db.commit()
except:
    print('执行失败，进入回调3')
    db.rollback()


#更新每天的全球患者人数总和
time=datetime.datetime.now().strftime('%Y-%m-%d')
print(time)
world_data=[]

sql_selworld = "select * from world_map where Date like '{0}'".format(time+"%")
try:
    cursor.execute(sql_selworld)
    # 获取所有记录列表
    results = cursor.fetchall()
    confirmed=0
    suspected=0
    cured=0
    dead=0
    date='Null'
    for row in results:
        date = row[1]
        confirmed =confirmed+int(row[5])
        suspected =suspected+int(row[6])
        cured =cured+int( row[7])
        dead=dead+int(row[8])
    simpledata=(str(date),str(confirmed),str(suspected),str(cured),str(dead))
    world_data.append(simpledata)

except:
    print("Error: unable to fecth data")


sql_insert = "INSERT INTO sum_world values (%s,%s,%s,%s,%s)"

cursor.executemany(sql_insert,world_data)
db.commit()


#更新各大洲数量
world_zhou=[]


sql_zhou = "select * from world_map where Date like '{0}'".format(time+"%")
try:
    cursor.execute(sql_zhou)
    # 获取所有记录列表
    results = cursor.fetchall()
    yzconfirmed=0
    bmz=0
    oz=0
    dyz=0
    qita=0
    continents=''
    date='Null'
    for row in results:
        date = row[1]
        continents = row[2]
        if continents=='亚洲':
            yzconfirmed =yzconfirmed+int(row[5])
        elif continents=='欧洲':
            oz=oz+int(row[5])
        elif continents=='大洋洲':
            dyz=dyz+int(row[5])
        elif continents=='北美洲':
            bmz=bmz+int(row[5])
        else:
            qita=qita+int(row[5])
    simpledata=(str(date),str(yzconfirmed),str(bmz),str(oz),str(dyz),str(qita))
    world_zhou.append(simpledata)

except:
    print("Error: unable to fecth data")


sql_zhouinsert = "INSERT INTO local_world values (%s,%s,%s,%s,%s,%s)"

cursor.executemany(sql_zhouinsert,world_zhou)
db.commit()


db.close()
