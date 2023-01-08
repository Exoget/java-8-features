package com.examples.knowledge;

public class HeritageMultiple {


    public interface A {

        default void method1(){
            System.out.println("A");
        }

    }

    public interface B {

        default void method1(){
            System.out.println("B");
        }

    }

    class AB implements A,B{

        public void hello(){
            method1();
        }


        @Override
        public void method1() {
            A.super.method1();
            //B.super.method1();
        }
    }
}