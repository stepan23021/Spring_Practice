package com.example.dmitrii.spring_practice;

import com.example.dmitrii.spring_practice.rockets.Apollo;
import com.example.hibernate_practice.MainHibernate;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class Launch {
    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(Launch.class, args);
        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        String launches[] = {"apollo", "gemini"};
        for (String launch : launches) {
            Object obj = context.getBean(launch);
            if (obj instanceof Apollo) {
                Apollo apollo = (Apollo) obj;
                apollo.launch();
                if (launch.equals("apollo"))
                    apollo.moonLanding();
                //NEW VERY USELESS COMMENT
            }
        }
        Object bean = context.getBean("hibernateBean");
        if (bean instanceof MainHibernate) {
            MainHibernate hibernate = (MainHibernate) bean;
            hibernate.main();
        }
        int exitCode = SpringApplication.exit(context, (ExitCodeGenerator) () -> {
            // return the error code
            return 0;
        });
        System.exit(exitCode);
    }
}
