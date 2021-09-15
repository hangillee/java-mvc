package com.techcourse.controller;

import com.techcourse.domain.User;
import com.techcourse.repository.InMemoryUserRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import nextstep.mvc.view.JspView;
import nextstep.mvc.view.ModelAndView;
import nextstep.web.annotation.Controller;
import nextstep.web.annotation.RequestMapping;
import nextstep.web.support.RequestMethod;


@Controller
public class RegisterController {

    private static final String REDIRECT_REGISTER = "/register.jsp";
    private static final String REDIRECT_INDEX = "/index.jsp";

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView show(HttpServletRequest request, HttpServletResponse response) {
        return new ModelAndView(new JspView(REDIRECT_REGISTER));
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView save(HttpServletRequest request, HttpServletResponse response) {
        User user = new User(InMemoryUserRepository.getId(),
            request.getParameter("account"), request.getParameter("password"),
            request.getParameter("email"));
        InMemoryUserRepository.save(user);

        return new ModelAndView(new JspView(REDIRECT_INDEX));
    }
}
