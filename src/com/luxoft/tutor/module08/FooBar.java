package com.luxoft.tutor.module08;

import com.luxoft.tutor.module08.defaultInterfaces.Bar;
import com.luxoft.tutor.module08.defaultInterfaces.Foo;

public class FooBar implements Foo, Bar {
	
	@Override
	public void someMethod(){
		System.out.println("FooBar#someMethod");
	}

	public static void main(String [] args) {
		System.out.println("FooBar#main");
		
		FooBar fooBar = new FooBar();
		fooBar.someMethod();
		fooBar.someOtherMethod();
	}
	
}
