package zyf.task;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @Author zyf
 * @CreateAt 2018/1/2 下午6:10
 */
@Component
@EnableScheduling
public class TestTask {

    @Scheduled(cron = "0 * * * * ?")
    public void test(){
        System.out.println("zyf is the best");
        for(int i = 0; i < 10; i++){
            System.out.println(i);
        }
    }
}
