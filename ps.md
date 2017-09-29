### 注意
* 设置多数据源的时候, 要有一个数据源连接设置位<em>PRIMARY</em>
* spring依赖注入的原理解释

### 错误记录
#### Q1:
* ERROR 6940 --- [nio-8080-exec-1] com.alibaba.druid.pool.DruidDataSource   : testWhileIdle is true, validationQuery not set
#### K1:


### @Controller / @RestController
如果使用Controller, 发现是404的话, 原因如下
没有使用模版。即@Controller 用来响应页面，@Controller必须配合模版来使用。spring-boot 支持多种模版引擎包括： 
* FreeMarker 
* Groovy 
* Thymeleaf （Spring 官网使用这个） 
* Velocity 
* JSP （貌似Spring Boot官方不推荐，STS创建的项目会在src/main/resources 下有个templates 目录，这里就是让我们放模版文件的，然后并没有生成诸如 SpringMVC中的webapp目录）

