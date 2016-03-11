package com.example;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component(value = "family")
public class Family {

    @Value("${family.members}")
    private List<Person> members;

    @Override
    public String toString() {
        return "Family{" +
                "members='" + members + '\'' +
                '}';
    }
}
