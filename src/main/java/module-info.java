open module org.sterzhen.ypmtool {

    requires transitive com.fasterxml.classmate;
    requires transitive com.fasterxml.jackson.databind;
    requires transitive net.bytebuddy;
    requires transitive java.instrument;
    requires transitive java.xml.bind;

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
    requires spring.security.config;
    requires spring.security.core;
    requires spring.security.web;
    requires org.apache.tomcat.embed.core;
    requires jjwt;
}