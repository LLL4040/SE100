# Homework 3

> 将REST service拆分成两个微服务并上传到dockerhub

## User guideline

* 分别使用`$ docker pull lyl4040/function`和`$ docker pull lyl4040/login`拉取两个镜像

* 使用`$ docker run -itd -p 8080:8080 --name=function lyl4040/function`和`$ docker run -itd -p 8088:8088 --link=function --name=login lyl4040/login`创建container

* 访问`localhost:8088`即可看到首页，在前端点击对应按钮可以进行交互

* 补充：我用的是windows系统里的linux虚拟机，运行`$ docker-machine ip default`可以得到默认ip是192.168.99.100，所以在前端form提交的action里写的是绝对路径，使用了这个ip