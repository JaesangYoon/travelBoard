package com.travelBoard;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class RequestTest {

    //    String year, String month, String day
    @RequestMapping("/hello")
//    public String test(String year, String month, String day, Model m) {
    public String test(Date date, Model m) {
        date.year = 2022;
        date.month = 11;
        date.day = 10;

        return "hello";
    }

    @RequestMapping("/hello/result")
    public String result (Date date){
        return "helloResult";
    }
}
