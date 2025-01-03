package com.rest;

public class MethodChanging {
    public static void main(String[] args){
        a1().
        a2().
        a3();

    }
    public static MethodChanging a1(){
        System.out.println("this is a1 method");
        return new MethodChanging();
    }
    public MethodChanging a2(){
        System.out.println("this is a2 method");
        return this;
    }
    public MethodChanging a3(){
        System.out.println("this is a3 method");
        return this;
    }
}
