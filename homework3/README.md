# Homework 3

> ��REST service��ֳ�����΢�����ϴ���dockerhub

## User guideline

* �ֱ�ʹ������������ȡ����

```bash
$ docker pull lyl4040/function
$ docker pull lyl4040/login
```

* �����������������docker����

```bash
$ docker network create net
$ docker run --network net --name host -p 8080:8080 lyl4040/function
$ docker run --network net --name checkhost -p 9090:9090 lyl4040/login
```

* ���������������url���в���
    1. �״�����<http://localhost:8080/wordladder/search?begin=data&end=code>����Ϊδ��¼ҳ�����ʾ��δ��¼���ȵ�¼��
    2. ����<http://localhost:8080/wordladder/login?username=user&password=123>����ʾ��¼�ɹ���true��
    3. �ٴ�����<http://localhost:8080/wordladder/search?begin=data&end=code>����ʾwordladder�Ľ��

* ���䣺
    1. ʹ��windowsϵͳ���linux�����ʱ������`$ docker-machine ip default`���Եõ�Ĭ��ip��192.168.99.100�����Բ��Ե�ʱ��Ҫ��localhost��������linux�������ip
    2. ����Dockerfile�ֱ���Wordladder��loginĿ¼�µ�docker�ļ�����