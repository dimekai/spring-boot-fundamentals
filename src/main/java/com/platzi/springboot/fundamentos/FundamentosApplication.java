package com.platzi.springboot.fundamentos;

import com.platzi.springboot.fundamentos.bean.MyBean;
import com.platzi.springboot.fundamentos.bean.MyBeanWithDependency;
import com.platzi.springboot.fundamentos.bean.MyBeanWithProperties;
import com.platzi.springboot.fundamentos.bean.MyOwnBeanWithDependency;
import com.platzi.springboot.fundamentos.component.ComponentDependency;
import com.platzi.springboot.fundamentos.pojo.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner{

    private ComponentDependency componentDependency;
    private MyBean myBean;
    private MyBeanWithDependency myBeanWithDependency;
    private MyOwnBeanWithDependency myOwnBeanWithDependency;
    private MyBeanWithProperties myBeanWithProperties;
    private User user;

    public FundamentosApplication(@Qualifier("componentTwoImplement") ComponentDependency componentDependency,
                                  MyBean myBean,
                                  MyBeanWithDependency myBeanWithDependency,
                                  MyOwnBeanWithDependency myOwnBeanWithDependency,
                                  MyBeanWithProperties myBeanWithProperties,
                                  User user) {
        this.componentDependency = componentDependency;
        this.myBean = myBean;
        this.myBeanWithDependency = myBeanWithDependency;
        this.myOwnBeanWithDependency = myOwnBeanWithDependency;
        this.myBeanWithProperties = myBeanWithProperties;
        this.user = user;
    }

    public static void main(String[] args) {
        SpringApplication.run(FundamentosApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        this.componentDependency.saludar();
        this.myBean.print();
        this.myBeanWithDependency.printWithDependency();
        this.myOwnBeanWithDependency.displayElements();
        System.out.println(this.myBeanWithProperties.funcStr());
        System.out.println(this.user.getEmail() + "/" + this.user.getPassword());
    }
}
