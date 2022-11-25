package com.travelBoard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class ExceptionController {
    @ExceptionHandler(NullPointerException.class)
    public String catcher2(Exception ex, Model m) { // ��Ʈ�ѷ� ������ ���� catch ���� ����
        m.addAttribute("ex", ex);
        return "error";
    }

    @ExceptionHandler(Exception.class)
    public String catcher(Exception ex, Model m) { // ��Ʈ�ѷ� ������ ���� catch ���� ����
//        System.out.println("catcher in ExceptionController.");
        System.out.println("m = " + m); // Model ��ü�� ������ �ִ� ������ ��µȴ�.
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
        throw new NullPointerException("���ܰ� �߻��߽��ϴ�.");
    }

}
