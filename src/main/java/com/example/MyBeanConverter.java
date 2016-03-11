package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class MyBeanConverter implements Converter<String, Person> {

    private static Logger LOG = LoggerFactory.getLogger(MyBeanConverter.class);

    private final String pattern = "^firstName:(\\w+)\\|lastName:(\\w+)";
    private final Pattern regexPattern;

    public MyBeanConverter() {
        regexPattern = Pattern.compile(pattern);
    }

    @Override
    public Person convert(String s) {
        Matcher matcher = regexPattern.matcher(s);
        if (matcher.matches()) {
            String foo = matcher.group(1);
            String bar = matcher.group(2);
            return new Person(foo, bar);
        }
        throw new IllegalArgumentException("Wrong format for property");
    }
}
