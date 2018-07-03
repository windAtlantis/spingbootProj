[TOC]

# spingboot
> 简化spring开发的整合框架
> J2EE一站式解决方案

### starter启动器
分应用场景选择启动器
在pom中引入

### 配置注解化，约定化
- @Configuration(原spring)
@SpringBootConfiguration(springboot)

- @EnableAutoConfiguration(自动配置)
@AutoConfigurationPackage(自动配置注解所在包)

#### 自动配置原理
1. springboot会加载大量的自动配置类
2. 寻找与需要的功能相关的自动配置类
3. 查看自动配置类中配置了哪些组件
4. 组件会从properties文件中获取配置值，部分配置可以根据需要修改

### 配置文件
1. 来自启动参数
2. 来自application-{profile}的配置
3. 来自application的配置文件
4. 使用@configration注解
tips:高优先覆盖低优先，高低互补

# 微服务
> 原独立服务拆分成独立功能单元