# Implement a container in Java

## 源文件介绍及使用

源文件在`task4/src`目录下，有以下四个类

* `Main.java`
* `Producer.java`
* `Consumer.java`
* `Container.java`

调整`main`中的各个参数点击运行即可使用，各个参数含义如下：

* `producers`：生产者数目
* `responseInterval`：响应间隔
* `consumers`：消费者数目
* `requestInterval`：请求间隔
* `requestPerConsumer`：每个消费者发送请求数
* `threshold`：container改变策略的阈值
* `timeout`：请求的最大储存时间，超时将被移除不再处理

## 测试代码运行结果

各参数值分别为

* `producers`：10
* `responseInterval`：10
* `consumers`：5
* `requestInterval`：2
* `requestPerConsumer`：10
* `threshold`：20
* `timeout`：30

```java
Consumer 0 sends request 1.
Consumer 1 sends request 2.
Consumer 2 sends request 3.
Consumer 3 sends request 4.
Consumer 4 sends request 5.
Producer 0 receive request 1.
Producer 1 receive request 2.
Producer 2 receive request 3.
Producer 3 receive request 4.
Producer 4 receive request 5.
Consumer 0 sends request 6.
Consumer 1 sends request 7.
Consumer 2 sends request 8.
Consumer 3 sends request 9.
Consumer 4 sends request 10.
Producer 5 receive request 6.
Producer 6 receive request 7.
Producer 7 receive request 8.
Producer 8 receive request 9.
Producer 9 receive request 10.
Consumer 0 sends request 11.
Consumer 1 sends request 12.
Consumer 2 sends request 13.
Consumer 3 sends request 14.
Consumer 4 sends request 15.
Consumer 0 sends request 16.
Consumer 1 sends request 17.
Consumer 2 sends request 18.
Consumer 3 sends request 19.
Consumer 4 sends request 20.
Consumer 0 sends request 21.
Consumer 1 sends request 22.
Consumer 2 sends request 23.
Consumer 3 sends request 24.
Consumer 4 sends request 25.
Producer 0 respond.
Producer 1 respond.
Producer 2 respond.
Producer 3 respond.
Producer 4 respond.
Consumer 0 sends request 26.
Consumer 1 sends request 27.
Consumer 2 sends request 28.
Consumer 3 sends request 29.
Consumer 4 sends request 30.
Switch to stack mode.
Producer 0 receive request 26.
Producer 1 receive request 27.
Producer 2 receive request 28.
Producer 3 receive request 29.
Producer 4 receive request 30.
Producer 5 respond.
Producer 6 respond.
Producer 7 respond.
Producer 8 respond.
Producer 9 respond.
Consumer 0 sends request 31.
Switch to queue mode.
Consumer 1 sends request 32.
Consumer 2 sends request 33.
Consumer 3 sends request 34.
Consumer 4 sends request 35.
Switch to stack mode.
Producer 5 receive request 31.
Producer 6 receive request 32.
Producer 7 receive request 33.
Producer 8 receive request 34.
Producer 9 receive request 35.
Consumer 0 sends request 36.
Switch to queue mode.
Consumer 1 sends request 37.
Consumer 2 sends request 38.
Consumer 3 sends request 39.
Consumer 4 sends request 40.
Switch to stack mode.
Consumer 0 sends request 41.
Consumer 1 sends request 42.
Consumer 2 sends request 43.
Consumer 3 sends request 44.
Consumer 4 sends request 45.
Consumer 0 sends request 46.
Consumer 1 sends request 47.
Consumer 2 sends request 48.
Consumer 3 sends request 49.
Consumer 4 sends request 50.
Producer 0 respond.
Producer 1 respond.
Producer 2 respond.
Producer 3 respond.
Producer 4 respond.
Consumer 0 sends request 51.
Consumer 1 sends request 52.
Consumer 2 sends request 53.
Consumer 3 sends request 54.
Consumer 4 sends request 55.
Producer 0 receive request 51.
Producer 1 receive request 52.
Producer 2 receive request 53.
Producer 3 receive request 54.
Producer 4 receive request 55.
Producer 5 respond.
Producer 6 respond.
Producer 7 respond.
Producer 8 respond.
Producer 9 respond.
Consumer 0 sends request 56.
Consumer 1 sends request 57.
Consumer 2 sends request 58.
Consumer 3 sends request 59.
Consumer 4 sends request 60.
Producer 5 receive request 56.
Producer 6 receive request 57.
Producer 7 receive request 58.
Producer 8 receive request 59.
Producer 9 receive request 60.
Consumer 0 sends request 61.
Consumer 1 sends request 62.
Consumer 2 sends request 63.
Consumer 3 sends request 64.
Consumer 4 sends request 65.
Consumer 0 sends request 66.
Consumer 1 sends request 67.
Consumer 2 sends request 68.
Consumer 3 sends request 69.
Consumer 4 sends request 70.
Consumer 0 sends request 71.
Consumer 1 sends request 72.
Consumer 2 sends request 73.
Consumer 3 sends request 74.
Consumer 4 sends request 75.
Producer 0 respond.
Producer 1 respond.
Producer 2 respond.
Producer 3 respond.
Producer 4 respond.
Consumer 0 sends request 76.
Consumer 1 sends request 77.
Consumer 2 sends request 78.
Consumer 3 sends request 79.
Consumer 4 sends request 80.
Producer 0 receive request 76.
Producer 1 receive request 77.
Producer 2 receive request 78.
Producer 3 receive request 79.
Producer 4 receive request 80.
Producer 5 respond.
Producer 6 respond.
Producer 7 respond.
Producer 8 respond.
Producer 9 respond.
Consumer 0 sends request 81.
Consumer 1 sends request 82.
Consumer 2 sends request 83.
Consumer 3 sends request 84.
Consumer 4 sends request 85.
Producer 5 receive request 81.
Producer 6 receive request 82.
Producer 7 receive request 83.
Producer 8 receive request 84.
Producer 9 receive request 85.
Request 11 timed out
Request 12 timed out
Request 13 timed out
Request 14 timed out
Request 15 timed out
Consumer 0 sends request 86.
Consumer 1 sends request 87.
Consumer 2 sends request 88.
Consumer 3 sends request 89.
Consumer 4 sends request 90.
Request 16 timed out
Request 17 timed out
Request 18 timed out
Request 19 timed out
Request 20 timed out
Consumer 0 sends request 91.
Consumer 1 sends request 92.
Consumer 2 sends request 93.
Consumer 3 sends request 94.
Consumer 4 sends request 95.
Request 21 timed out
Request 22 timed out
Request 23 timed out
Request 24 timed out
Request 25 timed out
Consumer 0 sends request 96.
Consumer 1 sends request 97.
Consumer 2 sends request 98.
Consumer 3 sends request 99.
Consumer 4 sends request 100.
Producer 0 respond.
Producer 1 respond.
Producer 2 respond.
Producer 3 respond.
Producer 4 respond.
Consumer 0 sends request 101.
Consumer 1 sends request 102.
Consumer 2 sends request 103.
Consumer 3 sends request 104.
Consumer 4 sends request 105.
Producer 0 receive request 101.
Producer 1 receive request 102.
Producer 2 receive request 103.
Producer 3 receive request 104.
Producer 4 receive request 105.
All of the requests are finished. Handled 35, Time out 15.
```