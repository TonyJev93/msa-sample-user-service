# 의존성

- Spring Cloud Discovery
    - Eureka Discovery Client

# 설정

- UserServiceApplication
    - @EnableDiscoveryClient 설정 필요
  ```java
  @SpringBootApplication
  @EnableDiscoveryClient // @EnableEurekaClient 로 해도 됨
  public class UserServiceApplication {
      // ...
  }
  ```

- application.yml
    ```yaml
    spring:
      application:
        name: user-service
    
    eureka:
      instance:
        instance-id: ${spring.cloud.client.hostname}:${spring.application.instance_id:${random.value}}
      client:
        register-with-eureka: true # Eureka 서버에 등록
        fetch-registry: true  # Eureka 서버로부터 인스턴스 정보를 주기적으로 가져올 것인지 설정
        service-url:
          defaultZone: http://127.0.0.1:8761/eureka # Eureka 서버 위치
    ``` 
  - instance-id: ${spring.cloud.client.hostname}:${spring.application.instance_id:${random.value}}
    - `${spring.application.instance_id:${random.value}}` = spring.application.instance_id 를 ${random.value} 로 하겠다는 의미.

# 메이븐 통한 Port 변경 실행 방법

```bash
$ mvn spring-boot:run -Dspring-boot.run.jvmArguments='-Dserver.port=9003'
```

- eureka.instance.instance-id: ${spring.cloud.client.hostname}:${spring.application.instance_id:${random.value}}