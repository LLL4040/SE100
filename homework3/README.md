# Homework 3

> ��REST service��ֳ�����΢�����ϴ���dockerhub

## User guideline

* �ֱ�ʹ��`$ docker pull lyl4040/function`��`$ docker pull lyl4040/login`��ȡ��������

* ʹ��`$ docker run -itd -p 8080:8080 --name=function lyl4040/function`��`$ docker run -itd -p 8088:8088 --link=function --name=login lyl4040/login`����container

* ����`localhost:8088`���ɿ�����ҳ����ǰ�˵����Ӧ��ť���Խ��н���

* ���䣺���õ���windowsϵͳ���linux�����������`$ docker-machine ip default`���Եõ�Ĭ��ip��192.168.99.100��������ǰ��form�ύ��action��д���Ǿ���·����ʹ�������ip