package com.ruler;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


//注意自定义lb策略不能放在被ComponentScan(SpringBootApplication)注释的同级及子级包下
@Configuration
public class MyRuler {
    @Bean
    public IRule myRule() {
        return new RandomRule();//定义为随机
    }
}
