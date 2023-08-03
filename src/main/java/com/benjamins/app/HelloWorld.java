package com.mycompany.app;

import org.apache.commons.lang3.StringUtils;
import com.google.common.base.Preconditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloWorld {
    private static final Logger LOGGER = 
LoggerFactory.getLogger(HelloWorld.class);
    
    public static void main(String[] args) {
        String greeting = "Hello, World!";
        
        Preconditions.checkArgument(StringUtils.isNotBlank(greeting), 
"Greeting cannot be blank");
        
        LOGGER.info(greeting);
    }
}

