# Restful service of wordladder 资源占用分析

## 工具

* Postman：用于发送http请求
* ApacheBench：用于web服务器压力测试
* Prometheus：用于监控CPU、memory等的消耗情况

## 操作及结果

1. 用postman向 http://localhost:8080/login post用户名和密码，获得JSESSIONID。
2. 用apachebench将不同并发量的请求发送到 http://localhost:8080/greeting?begin=data&&end=code ，命令如下：
`ab.exe -c 100 -n 1000 -H "Cookie: JSESSIONID=6FD02B21DFA9F28581527BBCB1529044" http://localhost:8080/greeting?begin=data&&end=code`
3. 在prometheus中使用 `process_cpu_usage` 和 `jvm_memory_used_bytes` 分别监控CPU和内存的使用情况
4. 结果分析

* 对于CPU：分别取cuncurrent为0,10,20,50,100时CPU不断被消耗，在有四个内核的时候一个并发请求可以使用到大概四分之一的CPU，使用四个并发请求理论上会占用全部的CPU，结果也大致如此。
* 对于内存：cuncurrent一定时，随着请求数量的增长，内存使用量也会增长，每到一个阶段垃圾收集器会自动收集已用内存，并发数变化时没有明显的内存变化。