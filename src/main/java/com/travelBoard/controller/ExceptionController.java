package com.travelBoard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class ExceptionController {
    @ExceptionHandler(NullPointerException.class)
    public String catcher2(Exception ex, Model m) { // 컨트롤러 내부의 공통 catch 블럭과 같다
        m.addAttribute("ex", ex);
        return "error";
    }

    @ExceptionHandler(Exception.class)
    public String catcher(Exception ex, Model m) { // 컨트롤러 내부의 공통 catch 블럭과 같다
//        System.out.println("catcher in ExceptionController.");
        System.out.println("m = " + m); // Model 객체가 가지고 있는 내용이 출력된다.
        m.addAttribute("ex", ex);
        return "error";
    }

    @RequestMapping("/ex")
    public void main(Model m) throws Exception {
        m.addAttribute("msg", "message from ExcepionController.main()");
        throw new Exception("Exception has occured.");
    }

    @RequestMapping("/ex2")
    public void main2() throws Exception {
        throw new NullPointerException("예외가 발생했습니다.");
    }

}
