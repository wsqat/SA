### API

#### 获得当前所有的线上的客户端

```
url: http://{deployUrl}:10641/clients
method: GET
response:
            [
                {
                    "ip": "192.168.8.74",
                    "name": "0WHH33JV",
                    "online": true
                }
            ]
```

#### 获得某个线上客户端的状态

```
url: http://{deployUrl}:10641/client?name={name}&{starttime}=0&end={endtime}
method: GET
param:
        name: 第一个 api 中获得的 name 字段
        starttime: 起始时间戳（毫秒单位）
        endtime: 结束时间戳(毫秒单位)
response:
            [
                {
                    "avgload": 3.81982421875,
                    "cpunum": 8,
                    "id": 60,
                    "name": "0WHH33JV",
                    "os": "x86_64Mac OS X10.13.2",
                    "timestamp": 1512906686670
                },
                {
                    "avgload": 3.81982421875,
                    "cpunum": 8,
                    "id": 59,
                    "name": "0WHH33JV",
                    "os": "x86_64Mac OS X10.13.2",
                    "timestamp": 1512906685666
                }
            ]
```

#### 获取掉线的客户端

```
url: http://{deployUrl}:10641/alert
method: GET
response:
            [
                {
                    "ip": "192.168.8.74",
                    "name": "0WHH33JV",
                    "online": false
                }
            ]
```

#### 删除客户端

```
url: http://{deployUrl}:10641/client?name={name}
method: DELETE
param:
        name: 第一个 api 中获得的 name 字段
response: {}
```
