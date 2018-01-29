--配置hosts
127.0.0.1 slf.test.center

--安装redis服务。


--启动单台应用端口为9009
java -Xdebug -Xrunjdwp:server=y,transport=dt_socket,address=8009,suspend=n -jar springSessionDataRedis-0.0.1.jar

--启动多个实例
java -jar springSessionDataRedis-0.0.1.jar --spring.profiles.active=9008
java -jar springSessionDataRedis-0.0.1.jar--spring.profiles.active=9007

http://slf.test.center:9009/springSession/index/zhangsan




