package com.other.pac;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;
import java.util.*;
import domain.raj.user.com.flagtest.StaticMethodOver;

public final class C extends StaticMethodOver {
    Map<String,String> on=new TreeMap<>();
    Set<String> d=new HashSet<>();
    List<Integer> s=new ArrayList<>();
    Queue ds=new PriorityQueue();
   void  show(){
        s.add(2);
    }

    class Parent { }
    class Child extends Parent { }
    public class TestPoly {

    }

    @Override
    protected Number showMe() {
        return super.showMe();
    }

    private final class DD extends StaticMethodOver{
        @Override
        protected void defaulttest() {
            super.defaulttest();
        }
    }
    void MeNo(){
        int ff=protectedL;
    }

    @Override
    protected void defaulttest() {
        super.defaulttest();
    }
    public static void main(String[] args) {
        Parent[] myArray = new Child[3]; // yes
    }
}
