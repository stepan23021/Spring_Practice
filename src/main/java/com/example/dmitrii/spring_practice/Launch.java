package com.example.dmitrii.spring_practice;

import com.example.dmitrii.spring_practice.gemini.GeminiFirstStage;
import com.example.dmitrii.spring_practice.gemini.GeminiFuelType;
import com.example.dmitrii.spring_practice.gemini.GeminiThirdStage;
import com.example.dmitrii.spring_practice.rockets.Apollo;
import com.example.dmitrii.spring_practice.saturn.SaturnSecondStage;
import com.example.hibernate_practice.MainHibernate;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.*;

@SpringBootApplication
public class Launch implements Serializable {
    public static void main(String[] args) throws InterruptedException, IOException, ClassNotFoundException {
        SpringApplication.run(Launch.class, args);
        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        String launches[] = {"apollo", "gemini"};
        for (String launch : launches) {
            Object obj = context.getBean(launch);
            if (obj instanceof Apollo) {
//                FileOutputStream fileOutputStream = new FileOutputStream("/home/dmitriistepcenco/Desktop/temp.out");
//                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
//                Apollo apollo1 = new Apollo();
////                apollo1.setCamouflage("BLACK");
////                apollo1.setFirstStage(new GeminiFirstStage());
////                apollo1.setFuelType(new GeminiFuelType());
//                apollo1.setHustonWeHaveAProblem(false);
////                apollo1.setSecondStage(new SaturnSecondStage());
////                apollo1.setThirdStage(new GeminiThirdStage());
//                objectOutputStream.writeObject(apollo1);
//                objectOutputStream.flush();
//                objectOutputStream.close();
//                FileInputStream fileInputStream = new FileInputStream("/home/dmitriistepcenco/Desktop/temp.out");
//                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
//                Apollo apollo2 = (Apollo) objectInputStream.readObject();
//                System.out.println(apollo2.getCamouflage());
                Apollo apollo = (Apollo) obj;
                apollo.launch();
                if (launch.equals("apollo"))
                    apollo.moonLanding();
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
