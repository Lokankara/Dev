package com.luxoft.tutor.module08.defaultmethods;

public interface Bar {
	
	default void someMethod(){
		System.out.println("Bar#someMethod");
	}
	
}
