# Homework 3

> 将REST service拆分成两个微服务并上传到dockerhub

## User guideline

* 分别使用以下命令拉取镜像

```bash
$ docker pull lyl4040/function
$ docker pull lyl4040/login
```

* 依次输入以下命令创建docker容器

```bash
$ docker network create net
$ docker run --network net --name host -p 8080:8080 lyl4040/function
$ docker run --network net --name checkhost -p 9090:9090 lyl4040/login
```

* 打开浏览器输入以下url进行测试
    1. 首次输入<http://localhost:8080/wordladder/search?begin=data&end=code>会因为未登录页面会显示“未登录请先登录”
    2. 输入<http://localhost:8080/wordladder/login?username=user&password=123>会显示登录成功“true”
    3. 再次输入<http://localhost:8080/wordladder/search?begin=data&end=code>会显示wordladder的结果

* 补充：
    1. 使用windows系统里的linux虚拟机时，运行`$ docker-machine ip default`可以得到默认ip是192.168.99.100，所以测试的时候要把localhost换成上述linux虚拟机的ip
    2. 两个Dockerfile分别在Wordladder和login目录下的docker文件夹里