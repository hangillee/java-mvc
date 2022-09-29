package com.techcourse.controller;

import static nextstep.web.support.RequestMethod.GET;
import static nextstep.web.support.RequestMethod.POST;

import com.techcourse.domain.User;
import com.techcourse.repository.InMemoryUserRepository;
import com.techcourse.repository.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import nextstep.mvc.view.JspView;
import nextstep.mvc.view.ModelAndView;
import nextstep.web.annotation.Controller;
import nextstep.web.annotation.RequestMapping;

@Controller
public class RegisterController {

    private final UserRepository userRepository;

    public RegisterController() {
        this.userRepository = new InMemoryUserRepository();
    }

    public RegisterController(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping(value = "/register", method = POST)
    public ModelAndView save(final HttpServletRequest req, final HttpServletResponse res) {
        User user = new User(2,
                req.getParameter("account"),
                req.getParameter("password"),
                req.getParameter("email"));
        userRepository.save(user);

        return new ModelAndView(new JspView("redirect:/index.jsp"));
    }

    @RequestMapping(value = "/register", method = GET)
    public ModelAndView show(final HttpServletRequest req, final HttpServletResponse res) {
        return new ModelAndView(new JspView("/register.jsp"));
    }
}
