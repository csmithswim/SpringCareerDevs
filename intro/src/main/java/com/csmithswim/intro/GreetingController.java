package com.csmithswim.intro;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    //We do not use =/equals instead we use methods
    //This is used with concurrency
        private final AtomicLong counter = new AtomicLong();
        private final static String template = "Hello %s";

        //root route (/)
        @GetMapping("/")
        public String getHello(){
            return "Hello world";
        }

        //dummy data route | introduction to endpoint (sayHello endpoint)
        @GetMapping("/sayHello")
        public Greeting sayHello(){return new Greeting(32L,"HELLLOOOO\nCAREEEER DEVSS!!!");}


        //query parameters. localhost:8080/greeting?{value}={data}
        @GetMapping("/greeting")
        public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name){
            return new Greeting(counter.incrementAndGet(),String.format(template, name));
        }

        //URL parameters, Pulling data from the URL, a dynamic URL
        //Catching a path variable, similar to Javascript's 'template literals'
        @GetMapping("/hello/{name")
        public Greeting hello(@PathVariable String name){
            return new Greeting(counter.incrementAndGet(),String.format(template, name));
        }

}

