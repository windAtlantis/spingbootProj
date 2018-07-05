[TOC]

# spingboot
> 简化spring开发的整合框架
> J2EE一站式解决方案

### starter启动器
分应用场景选择启动器

在pom中引入

### 配置注解化，约定化
- @Configuration(原spring)
  - @SpringBootConfiguration(springboot)

- @EnableAutoConfiguration(自动配置)
  - @AutoConfigurationPackage(自动配置注解所在包)

#### 自动配置原理
1. springboot会加载大量的自动配置类
2. 寻找与需要的功能相关的自动配置类
3. 查看自动配置类中配置了哪些组件
4. 组件会从properties文件中获取配置值，部分配置可以根据需要修改

```
xxxAutoConfiguration 自动配置，包括：自动设置配置文件，在容器中添加实例
xxxConfigurationProperties 将默认配置文件转换为配置类
```

### 配置文件
1. 来自启动参数
2. 来自application-{profile}的配置
3. 来自application的配置文件
4. 使用@configration注解

tips:高优先覆盖低优先，高低互补

### 日志系统
> springboot使用的日志系统：slf4j+logback

日志抽象类 | 日志实现
------------ | -------------
slf4j | commons-logging log4j log4j2 logback

```
推荐使用{}-spring.xml的日志配置
配合<springProfile name="">
指定环境输出
spring.profiles.active
```

#### 日志框架切换
排除适配器包，引入目标日志框架包，引入相应适配包

### 静态资源
``` java
@Override
public void addResourceHandlers(ResourceHandlerRegistry registry) {
    if (!this.resourceProperties.isAddMappings()) {
        logger.debug("Default resource handling disabled");
        return;
    }
    Duration cachePeriod = this.resourceProperties.getCache().getPeriod();
    CacheControl cacheControl = this.resourceProperties.getCache()
            .getCachecontrol().toHttpCacheControl();
    if (!registry.hasMappingForPattern("/webjars/**")) {
        customizeResourceHandlerRegistration(registry
                .addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/")
                .setCachePeriod(getSeconds(cachePeriod))
                .setCacheControl(cacheControl));
    }
    String staticPathPattern = this.mvcProperties.getStaticPathPattern();
    if (!registry.hasMappingForPattern(staticPathPattern)) {
        customizeResourceHandlerRegistration(
                registry.addResourceHandler(staticPathPattern)
                        .addResourceLocations(getResourceLocations(
                                this.resourceProperties.getStaticLocations()))
                        .setCachePeriod(getSeconds(cachePeriod))
                        .setCacheControl(cacheControl));
    }
}
```

#### 公有资源
> /webjars 将资源以jar的形式引入

例如：http://localhost:8080/webjars/jquery/3.3.1/jquery.js

[webjars官网](https://www.webjars.org/)
    
#### 项目资源
```
classpath:/META-INF/resource/
classpath:/resource/
classpath:/static/
classpath:/public/
```

#### 欢迎页
index.html
```
@Bean
public WelcomePageHandlerMapping welcomePageHandlerMapping(
        ApplicationContext applicationContext) {
    return new WelcomePageHandlerMapping(
            new TemplateAvailabilityProviders(applicationContext),
            applicationContext, getWelcomePage(),
            this.mvcProperties.getStaticPathPattern());
}
```

### 模板引擎
Thymeleaf

``` xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-thymeleaf</artifactId>
</dependency>
```

# 微服务
> 原独立服务拆分成独立功能单元