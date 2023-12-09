# Mysql Demo

本demo是一个基于Spring Boot，使用Spring Framework对mysql进行访问的应用。

## 依赖说明

```java
implementation("org.springframework.boot:spring-boot-starter-jdbc")// spring boot自动配置jdbc的触发包
compileOnly("org.projectlombok:lombok")//lombok插件
developmentOnly("org.springframework.boot:spring-boot-devtools")//spring boot devtools 在本项目中作用不大，可以删除
runtimeOnly("com.mysql:mysql-connector-j")//msyql jdbc库
annotationProcessor("org.projectlombok:lombok")//lombok插件
testImplementation("org.springframework.boot:spring-boot-starter-test")//Spring Boot测试插件，框架自带，本项目没有用到其功能
```

## spring boot jdbc自动配置

默认情况下，Spring Boot为我们配置了`DataSource`（基于连接池，默认hikari）,`JDBCTemplate`,`TransactionManager`等。