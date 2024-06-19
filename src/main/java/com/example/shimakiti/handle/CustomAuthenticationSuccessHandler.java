//package com.example.shimakiti.handle;
//
//import com.example.shimakiti.entity.User;
//import com.example.shimakiti.repository.IUserRepository;
//import jakarta.servlet.ServletException;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
//import org.springframework.stereotype.Component;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import jakarta.servlet.http.HttpSession;
//
//import java.io.IOException;
//
//@Component
//public class CustomAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
//
//    @Autowired
//    private IUserRepository userRepository;
//
//    @Override
//    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
//                                        Authentication authentication) throws IOException,ServletException {
//        String loginId = authentication.getName();
//        User user = userRepository.findByLoginId(loginId);
//        HttpSession session = request.getSession();
//        session.setAttribute("user", user);
//
//        setDefaultTargetUrl("/menu");
//        super.onAuthenticationSuccess(request, response, authentication);
//    }
//}