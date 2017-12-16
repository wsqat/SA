# 前端部分

## 组件说明
- Spring boot 实现路由控制
- Thymeleaf 模板引擎作为视图
- Bootsrtap 后台管理UI模板
- Echarts 实现图表展示
- Ajax 实现数据心跳以及实时更新数据

## 功能说明
1. 控制命令传输，基于标准Http协议，实现控制命令发送
2. 机器状态接收，基于标准Http协议，实现门禁状态信息的接收
3. 管理配置，实现IP地址、同步信息的更新频率等各种设置信息的远程配置
4. 数据查询，实现各种状态数据的查询汇总等
5. 报表，实现以EXCEL、PDF等格式保存打印报表等
6. 浏览器信息推送，有状态变化时向浏览器发送状态改变的信息
7. 浏览器界面，采用JavaScript实现富客户端界面，如站点树、圆饼图、菜单等
8. 心跳，接收基站控制器心跳数据信息，确保其是否在线

## Demo展示

> 1. 登录：管理员登录页面。

![login.png](http://upload-images.jianshu.io/upload_images/688387-f98b2a09ee1f6564.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

> 2. 首页：简单的系统说明。

![index.png](http://upload-images.jianshu.io/upload_images/688387-e387d33b496b5112.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)


> 3. 管理配置：新建客户端节点。

![config.png](http://upload-images.jianshu.io/upload_images/688387-290434f6cba1ebb1.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)


> 4. 客户端节点实时状态：通过ajax动态请求，实时显示当前机器的状态，以及相应的操作。

![record.png](http://upload-images.jianshu.io/upload_images/688387-a5a71f7b7ab4dbab.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

- 右侧“x”,点击删除客户端机器，实现功能1
- 通过ajax动态请求，实时更新机器状态，实现功能2，6，7，8
- 客户端节点，实现功能4
- 点击“打印报表”，实现功能5

> 5. 打印报表

![print.png](http://upload-images.jianshu.io/upload_images/688387-6a8fa45b604e1039.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

> 6. 心跳图：通过ajax请求结合Echars，平滑左移，实现动态更新机器状态的心跳图。

![dynamic.png](http://upload-images.jianshu.io/upload_images/688387-417abb011a4f8cae.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

![dynamic_total.png](http://upload-images.jianshu.io/upload_images/688387-c89a8329d6723827.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)


> 7. 历史数据显示：通过ajax请求结合Echars，显示历史数据折线图。

![history.png](http://upload-images.jianshu.io/upload_images/688387-234e11f696997cd4.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

![history_total.png](http://upload-images.jianshu.io/upload_images/688387-0b78e41dd5f29a10.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
