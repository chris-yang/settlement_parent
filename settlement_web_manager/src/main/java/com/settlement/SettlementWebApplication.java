package com.settlement;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication  //(scanBasePackages = {"com.settlement"})
@MapperScan("com.settlement.mapper")
@EnableScheduling
public class SettlementWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(SettlementWebApplication.class,args);
    }
}
