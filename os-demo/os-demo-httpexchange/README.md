## WebClient模块
#### webflux避坑汇总 (未来拆分成两个示例模块)
1. pom中因为rpc客户端使用.block()方法，所以要导入同步包，或者不使用.block()方法。
```
异常信息：block()/blockFirst()/blockLast() are blocking, which is not supported in thread reactor-http-nio-1
```
```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
```
2. webmvc与webflux不能并存，如果引用1中提到的web依赖。在application中开启webflux的注解报异常，只有webflux模式下才能使用
```
异常信息：
The bean 'requestMappingHandlerAdapter', defined in class path resource [org/springframework/boot/autoconfigure/web/servlet/WebMvcAutoConfiguration$EnableWebMvcConfiguration.class], could not be registered. A bean with that name has already been defined in org.springframework.web.reactive.config.DelegatingWebFluxConfiguration and overriding is disabled.

Action:
Consider renaming one of the beans or enabling overriding by setting spring.main.allow-bean-definition-overriding=true
```
```
@EnableWebFlux
```
3. 响应式编程必须在application中开启webflux的注解
```
@EnableWebFlux
```