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

    @GetMapping("greeting")
    public static String createMessage(@RequestParam String name, @RequestParam String language){
        switch(language){
            case "english":
                return "Hello " + name + "!";
            case "spanish":
                return "Hola " + name + "!";
            case "japanese":
                return "こんにちは " + name + "!";
        }
        return null;
    }

    @RequestMapping("form")
    public String helloForm(){
        return "<html>" +
                    "<body>" +
                        "<form action='greeting' method='get'>" +
                            "<input type='text' name='name'>" +
                            "<select name='language' id='language'>" +
                                "<option value='english'>English</option>" +
                                "<option value='spanish'>Spanish</option>" +
                                "<option value='japanese'>Japanese</option>" +
                            "</select>" +
                            "<input type='submit' value='Greet Me!'>" +
                        "</form>" +
                    "</body>" +
                "</html>";

    }
}
