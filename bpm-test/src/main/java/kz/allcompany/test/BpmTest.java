package kz.allcompany.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

/**
 * Created By Kairat Zhiger
 * at 24.12.2022
 */
@SpringBootApplication
public class BpmTest {

    @PostConstruct
    void test(){

    }
    public static void main(String[] args) {

        SpringApplication.run(BpmTest.class,args);
    }
}
