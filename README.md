# springcloud-demo-on-k8s

### Prepare
* Java 1.8
* Spring boot 2.0.3 RELEASE
* Spring cloud Finchley.RELEASE
* Maven-docker-plugin 1.0.0
* Kubernetes 1.13
* Kube-dns
* Docker 18.06.1-ce


### Service

+ eureka-server
+ service-zuul
+ service-api
+ service-tp
+ config-server

### Build and Docker

`mvn clean package docker:build`

```docker push xxxxx```


### Deploy

#### run rabbitmq
`sudo docker run -d --name rabbitmq -p 5671:5671 -p 5672:5672 -p 4369:4369 -p 25672:25672 -p 15671:15671 -p 15672:15672 rabbitmq:management`
### run eureka
`kubectl create/apply -f deploy-file/deploy-eurekaserver.yaml`

#### 查询注册的服务
`curl http://192.168.140.126:30719/eureka/apps`

### run config server
`kubectl create/apply -f deploy-file/config-server.yaml`

### run service-api
`kubectl create/apply -f deploy-file/service-api.yaml`

### run service-tp
`kubectl create/apply -f deploy-file/service-tp.yaml`

### others

`kubectl get/delete deploy,pod,svc --all-namespaces/-n default`

`kubectl describe pod POD_ID`

`kubectl logs -f POD_ID`

	kubectl exec -it busybox sh
    nslookup eureka-server
   
#### refresh config on config server
`curl -X POST http://localhost:8765/actuator/bus-refresh`

`-- localhost：此处是登录到config-server的pod中执行的curl命令，故而ip地址为localhost`

`-- 8765：config server的端口`

### Test

Check the other services whether join in eureka-server and make sure the config-server runs well. 

	eureka-server portal test : http://IP:Port
	
	config-server and client test : http://IP:Port/custom-config/dev




