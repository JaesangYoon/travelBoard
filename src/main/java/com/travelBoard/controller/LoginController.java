package com.travelBoard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/login")
public class LoginController {
    @GetMapping("/login")
    public String loginForm() {
        return "loginForm";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        // 1. ���� ����
        session.invalidate();
        // 2. Ȩ���� �̵�
        return "redirect:/";
    }

    @PostMapping("/login")
    public String login(String id, String pwd, String toURL, boolean rememberId, HttpServletRequest request, HttpServletResponse response) {

        // 1. id, pwd�� Ȯ��
        if (!loginCheck(id, pwd)) {
            // 2-1. ��ġ���� ������ loginForm���� �̵�
            return "redirect:/login/login";
        }
        // 2-2. id�� pwd�� ��ġ�ϸ�
        // ���� ��ü�� ������ (���� ����)
        HttpSession session = request.getSession();
        // ���� ��ü�� id�� ����
        session.setAttribute("id", id);

        if (rememberId) {
            // 1. ��Ű�� ����
            Cookie cookie = new Cookie("id", id);
            // 2. ���信 ��Ű ����
            response.addCookie(cookie);
        } else {
            Cookie cookie = new Cookie("id", id);
            cookie.setMaxAge(0);

            response.addCookie(cookie);
        }

        toURL = toURL==null || toURL.equals("") ? "/" : toURL;

        return "redirect:"+toURL; // id, pwd ��ġ�ϸ� Ȩ���� �̵�
    }

    private boolean loginCheck(String id, String pwd) {
        return "asdf".equals(id) && "1234".equals(pwd);
    }
}