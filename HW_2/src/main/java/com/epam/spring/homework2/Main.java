package com.epam.spring.homework2;

import com.epam.spring.homework2.beans.GeneralBean;
import com.epam.spring.homework2.beans.Rating;
import com.epam.spring.homework2.config.Config1;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(Config1.class);

        System.out.println("___Order of creation beans: D-> B-> C_Other__");
        context.getBean(GeneralBean.class).printOrderedBeans();

        System.out.println("___List of all beans___");
        String[] beanNames = context.getBeanDefinitionNames();
        for (String beanName : beanNames) {
            System.out.println(beanName);
        }

        System.out.println("---Configuration of all beans---");
        for (String beanName2 : beanNames) {
            System.out.println(context.getBeanDefinition(beanName2));
            if (context.getBean(beanName2) instanceof Rating) {
                System.out.println(((Rating) context.getBean(beanName2)).getName());
                System.out.println(((Rating) context.getBean(beanName2)).getValue());
            }
        }
        context.close();
    }

}
