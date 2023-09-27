package com.techcourse.controller;

import context.org.springframework.stereotype.Controller;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import web.org.springframework.web.bind.annotation.RequestMapping;
import web.org.springframework.web.bind.annotation.RequestMethod;
import webmvc.org.springframework.web.servlet.ModelAndView;
import webmvc.org.springframework.web.servlet.view.JspView;

@Controller
public class HomeController {

    private static final JspView INDEX_PAGE_VIEW = new JspView("/index.jsp");

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView home(final HttpServletRequest request, final HttpServletResponse response) {
        return new ModelAndView(INDEX_PAGE_VIEW);
    }
}
