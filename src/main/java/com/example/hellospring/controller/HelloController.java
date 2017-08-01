package com.example.hellospring.controller;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @RequestMapping(value = "")
    @ResponseBody
    public String index(HttpServletRequest request){
        String name = request.getParameter("name");

        if (name == null) {
            name = "World";
        }

        return "Hello " + name;
    }

    @RequestMapping(value = "hello", method = RequestMethod.GET)
    @ResponseBody
    public String helloForm(){
        String html = "<center><form method='post'>" +
                "<input type='text' name='name' />" +
                "<select name='langs' >" +
                "<option value='eg'>English</option>" +
                "<option value='fr'>French</option>" +
                "<option value='jp'>Japanese</option>" +
                "<option value='sp'>Spanish</option>" +
                "<option value='mc'>Morse Code</option>" +
                "<option value='ar'>Armenian</option>" +
                "</select>" +
                "<input type='submit' value='Greet Me!'/>" +
                "</form></center>";
        return html;
    }

    @RequestMapping(value = "hello", method = RequestMethod.POST)
    @ResponseBody
    public String createMessage(HttpServletRequest request){
        String name = request.getParameter("name");
        String lang = request.getParameter("langs");

        if (lang.equals("fr")) {
            return "Bonjour " + name + "!";
        }
        if (lang.equals("jp")) {
            return "Konnichiwa " + name + "!";
        }
        if (lang.equals("sp")) {
            return "Hola " + name + "!";
        }
        if (lang.equals("mc")) {
            return ".... . .-.. .-.. --- " + name + "!";
        }
        if (lang.equals("ar")) {
            return "Barev " + name + "!";
        }
        if (lang.equals("eg")) {
            return "Hello " + name + "!";
        }
        return name;
    }

    @RequestMapping(value = "hello/{name}")
    @ResponseBody
    public String helloUrlSegment(@PathVariable String name){
        return "Hello " + name;
    }

    @RequestMapping(value="goodbye")
    public String goodbye(){
        return "redirect:/";
    }
}
