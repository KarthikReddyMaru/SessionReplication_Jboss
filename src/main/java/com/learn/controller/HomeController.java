package com.learn.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @GetMapping("/home")
    ModelAndView home(@ModelAttribute("message") String message, HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (session.getAttribute("hitCount") == null)
            session.setAttribute("hitCount", 0);
        int hitCount = Integer.parseInt(session.getAttribute("hitCount").toString());
        session.setAttribute("hitCount", hitCount + 1);
        ModelAndView mv = new ModelAndView();
        mv.addObject("sessionId", session.getId());
        mv.addObject("hitCount", hitCount);
        mv.setViewName("index");
        return mv;
    }

}
