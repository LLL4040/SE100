# Chrome的F12简单介绍及对上海交通大学教学信息服务网新旧版的对比分析(PC端)

## 开发者工具的功能结构及介绍

![功能条](https://github.com/LLL4040/images/blob/master/content.png?raw=true)

* `Elements`（元素面板）：使用元素面板可以通过自由操纵DOM和CSS来重演您网站的布局和设计。
* `Console`（控制台面板）：在开发期间，可以使用控制台面板记录诊断信息，或者使用它作为 shell，在页面上与JavaScript交互
* `Sources`（源代码面板）：在源代码面板中设置断点来调试 JavaScript ，或者通过Workspaces（工作区）连接本地文件来使用开发者工具的实时编辑器
* `Network`（网络面板）：从发起网页页面请求Request后得到的各个请求资源信息（包括状态、资源类型、大小、所用时间等），并可以根据这个进行网络性能优化
* `Performance`（性能面板）：使用时间轴面板，可以通过记录和查看网站生命周期内发生的各种事件来提高页面运行时的性能
* `Memory`（内存面板）：分析web应用或者页面的执行时间以及内存使用情况
* `Application`（应用面板）：记录网站加载的所有资源信息，包括存储数据（LocalStorage、Session Storage、-IndexedDB、Web SQL、Cookies）、缓存数据、字体、图片、脚本、样式表等
* `Security`（安全面板）：使用安全面板调试混合内容问题，证书问题等等
* `Audits`（审核面板）：对当前网页进行网络利用情况、网页性能方面的诊断，并给出一些优化建议。比如列出所有没有用到的CSS文件等

## 对新旧版教学信息服务网的对比分析(PC端)

### 响应速度

> 使用`performance`注意事项  
> 1.禁用浏览器缓存：`Network Tab`下的`disable cache`  
> 2.关闭Chrome扩展或者启用隐身模式  
> 3.根据使用场景，模拟真实的网络加载情况：`Network Tab`下的`throttling`下拉按钮

* 打开主页时：
  * 旧版 loading : 18.4ms
    ![图old1.png](https://github.com/LLL4040/images/blob/master/old1.png?raw=true)
  * 新版 loading : 47.3ms
    ![图new1.png](https://github.com/LLL4040/images/blob/master/new1.png?raw=true)
  * 新版的加载时间比旧版长，而且其中script占比较大
* 点击用JAccount登录时：
  * 旧版 load : 10.0ms
    ![图old2.png](https://github.com/LLL4040/images/blob/master/old2.png?raw=true)
  * 新版 load : 10.8ms
    ![图new2.png](https://github.com/LLL4040/images/blob/master/new2.png?raw=true)
  * 新旧版响应速度差不多

### Sources和Element分析

* 新版可以看到的资源文件较多
  ![图new3.png](https://github.com/LLL4040/images/blob/master/new3.png?raw=true)
* 旧版可以看到的资源文件较少
  ![图old3.png](https://github.com/LLL4040/images/blob/master/old3.png?raw=true)
* 在跳转登录页面的时候，新版使用的是`href="/jaccountlogin"`
  ![图new4.png](https://github.com/LLL4040/images/blob/master/new4.png?raw=true)
  旧版使用的是`href="login.aspx"`
  ![图old4.png](https://github.com/LLL4040/images/blob/master/old4.png?raw=true)

### 登录之后的主页分析

* 旧版页面内容丰富，而且缩放时对页面美观性的影响不大
  ![图old5.jpg](https://github.com/LLL4040/images/blob/master/old5.jpg?raw=true)
  采用`frameset`框架
  ![图old6.jpg](https://github.com/LLL4040/images/blob/master/old6.jpg?raw=true)
* 新版页面比较简洁，不过缩放时美观性影响较大，有的组件会被挤走消失
  ![图new5.png](https://github.com/LLL4040/images/blob/master/new5.png?raw=true)  
  采用`bootstrap`布局

### 优化建议

* 页面布局可以再优化一下，比如避免组件消失或者课程表溢出来这样的情况

## 参考资料

* [【day 5】Chrome浏览器F12讲解](https://www.jianshu.com/p/d01eb74bf06c)
* [Chrome开发者工具不完全指南（一、基础功能篇）](https://cloud.tencent.com/developer/article/1343645?client=tim&ADUIN=2293114926&ADSESSION=1553948086&ADTAG=CLIENT.QQ.5603_.0&ADPUBNO=26882)
* [Chrome F12 之 Timeline页面性能分析](https://blog.csdn.net/zhenzigis/article/details/50556440)
* [Google优化工具Timeline的使用（Chrome 57已经改为performance（性能模板））](https://blog.csdn.net/qq_26878975/article/details/74638018)
