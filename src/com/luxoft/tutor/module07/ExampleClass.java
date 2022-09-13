package com.luxoft.tutor.module07;

class ExampleClass {
    @Default("my text")
    private String text;
    @Default("noname")
    public String name;
    private int counter;

    public ExampleClass() {
    }

    public ExampleClass(String text, int counter) {
        super();
        this.text = text;
        this.counter = counter;
    }

    @MyAnnotation(name = "print me!")
    public void printIt() {
        System.out.println("printIt() no param");
    }

    public void printItString(String temp) {
        System.out.println("printIt() with param String : " + temp);
    }

    public void printItInt(int temp) {
        System.out.println("printIt() with param int : " + temp);
    }

    public void setCounter(int counter) {
        this.counter = counter;
        System.out.println("setCounter() set counter to : " + counter);
    }

    public void printCounter() {
        System.out.println("printCounter() : " + this.counter);
    }

}