# Restful service of wordladder ��Դռ�÷���

## ����

* Postman�����ڷ���http����
* ApacheBench������web������ѹ������
* Prometheus�����ڼ��CPU��memory�ȵ��������

## ���������

1. ��postman�� http://localhost:8080/login post�û��������룬���JSESSIONID��
2. ��apachebench����ͬ�������������͵� http://localhost:8080/greeting?begin=data&&end=code ���������£�
`ab.exe -c 100 -n 1000 -H "Cookie: JSESSIONID=6FD02B21DFA9F28581527BBCB1529044" http://localhost:8080/greeting?begin=data&&end=code`
3. ��prometheus��ʹ�� `process_cpu_usage` �� `jvm_memory_used_bytes` �ֱ���CPU���ڴ��ʹ�����
4. �������

* ����CPU���ֱ�ȡcuncurrentΪ0,10,20,50,100ʱCPU���ϱ����ģ������ĸ��ں˵�ʱ��һ�������������ʹ�õ�����ķ�֮һ��CPU��ʹ���ĸ��������������ϻ�ռ��ȫ����CPU�����Ҳ������ˡ�
* �����ڴ棺cuncurrentһ��ʱ�����������������������ڴ�ʹ����Ҳ��������ÿ��һ���׶������ռ������Զ��ռ������ڴ棬�������仯ʱû�����Ե��ڴ�仯��