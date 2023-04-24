package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("hello")
public class HelloController {

//    @GetMapping("hello")
//    @ResponseBody
//    public String hello(){
//        return "Hello Spring";
//    }

    @GetMapping("goodbye")
    public String goodbye(){
        return "Goodbye Spring";
    }

    //handles request of form /hello?name=LaunchCode
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value="hello")
    public String helloWIthQueryParam(@RequestParam String name){
        return "Hello " + name + "!";
    }

    //handles requests of the form /hello/LaunchCode
    @GetMapping("hello/{name}")
    public String helloWithPath(@PathVariable String name){
        return "Hello " + name + "!";
    }

    @RequestMapping("form")
    public String helloForm(){
        return "<html>" +
                "<body>" +
                "<form action='hello' method='post'>" +
                "<input type='text' name='coder'>" +
                "<input type='submit' value='Greet Me!'>" +
                "</form>" +
                "</body>" +
                "</html>";

    }
}
