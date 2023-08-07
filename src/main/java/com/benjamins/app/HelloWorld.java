package com.mycompany.app;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;
import com.google.common.base.Preconditions;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloWorld {
    private static final Logger LOGGER = LoggerFactory.getLogger(HelloWorld.class);
    
    public static void main(String[] args) {
        String greeting = "Hello, World!";
        
        Preconditions.checkArgument(StringUtils.isNotBlank(greeting), "Greeting cannot be blank");
        
        // Use Jackson to convert a simple object to JSON
        ObjectMapper mapper = new ObjectMapper();
        String json = "{}";
        try {
            json = mapper.writeValueAsString(new Greeting(greeting));
        } catch (Exception e) {
            LOGGER.error("Error converting object to JSON", e);
        }
        
        LOGGER.info("Greeting as JSON: " + json);
        
        // Use Joda-Time to display the current date-time in a custom format
        DateTime dateTime = new DateTime();
        DateTimeFormatter fmt = DateTimeFormat.forPattern("dd-MM-yyyy HH:mm:ss");
        LOGGER.info("Current Date-Time: " + dateTime.toString(fmt));
    }
}

// Additional class to represent a greeting which we'll convert to JSON
class Greeting {
    private String greeting;
    
    public Greeting(String greeting) {
        this.greeting = greeting;
    }

    public String getGreeting() {
        return greeting;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }
}
