### Deploy

0. 通过 ide 使用 maven 项目导入 overwatch 项目
1. 创建 overwatch 数据库（name 为 overwatch）
1. 修改 overwatch-server resource 目录下的 application.properties 文件，将数据库修改为本地数据库
2. 运行 overwatch-register 的 MainRegister 等待 10 秒左右(终端无输出)
3. 运行 overwatch-server 的 MainServer 等待 10 秒左右(终端无输出)
4. 运行 overwatch-client 的 MainClient 等待 10 秒左右(终端无输出)


**PS:**
+ 通过 API.md 中的连接进行访问测试，其中 MainClient 可以启动多实例模拟分布式环境
+ 也可以通过数据库软件查看数据变化



