package com.platzi.springboot.fundamentos.bean;

public class MyBeanWithDependencyImplement implements MyBeanWithDependency{

    private MyOperation myOperation;

    public MyBeanWithDependencyImplement(MyOperation myOperation) {
        this.myOperation = myOperation;
    }

    @Override
    public void printWithDependency() {
        int number = 44;
        System.out.println("Llamamos myOperationImplementation");
        System.out.println(this.myOperation.suma(number));
        System.out.println("Hola desde la implementacion de un bean con dependencia");
    }
}
