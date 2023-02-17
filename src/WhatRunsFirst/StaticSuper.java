package WhatRunsFirst;

public class StaticSuper {
    static {
        System.out.println("Super Static Block");
    }

    StaticSuper () {
        System.out.println("Super Constructor");
    }
}
