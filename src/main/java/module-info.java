open module org.sterzhen.ypmtool {

    requires transitive com.fasterxml.classmate;
    requires transitive com.fasterxml.jackson.databind;
    requires transitive net.bytebuddy;
    requires transitive java.instrument;

    requires spring.boot.autoconfigure;
    requires spring.boot;
    requires spring.beans;
    requires spring.web;
    requires spring.context;
    requires spring.data.commons;
    requires spring.data.jpa;
    requires spring.core;
    requires java.persistence;
    requires java.annotation;
}