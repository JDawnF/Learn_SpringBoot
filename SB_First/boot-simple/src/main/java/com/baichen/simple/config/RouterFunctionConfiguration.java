package com.baichen.simple.config;

import com.baichen.simple.domain.User;
import com.baichen.simple.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.*;
import reactor.core.publisher.Flux;

import java.util.Collection;
/**
 * @Date: 2019-09-08 22:36
 * @Author: baichen
 * @Description: 基于WebFlux实现,路由器函数配置，配置映射
 */
@Configuration
public class RouterFunctionConfiguration {

    /**
     * Servlet 规范：
     * 请求接口：ServletRequest 或者 HttpServletRequest
     * 响应接口：ServletResponse 或者 HttpServletResponse
     *
     * Spring 5.0 重新定义了服务请求的响应接口:
     * 请求接口：ServerRequest
     * 响应接口：ServerResponse
     * 即可支持 Servlet 规范，也可以支持自定义，比如 Netty （Web Server）
     * 以本例
     * 定义 GET 请求，并且放回所有的用户对象 URI：/person/find/all
     * Flux 是 0 - N 个对象集合
     * Mono 是 0 - 1 个对象集合
     * Reactive 中的 Flux 或者 Mono 是异步处理（非阻塞）
     * 集合对象基本上是同步处理（阻塞）
     * Flux 或者 Mono 都是 Publisher
     */
    @Bean
    @Autowired
    public RouterFunction<ServerResponse> personFindAll(UserRepository userRepository){
        Collection<User> users = userRepository.findAll();//获取所有用户对象
        return RouterFunctions.route(RequestPredicates.GET("/person/find/all"),//  /person/find/all获取的URI
                request -> {// request是rout方法中HandlerFunction类型参数入参
                    Flux<User> userFlux = Flux.fromIterable(users);
                    return ServerResponse.ok().body(userFlux,User.class);//集合参数和结果
                });
    }
}
