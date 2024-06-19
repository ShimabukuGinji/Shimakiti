package com.example.shimakiti.provider;

import com.example.shimakiti.entity.User;
import com.example.shimakiti.service.ShimaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Component;


@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private ShimaService loginUserService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        // ブラウザから入力したユーザ名・パスワードを取得
        String username = authentication.getName();
        String password = (String) authentication.getCredentials();

        User loginUser = loginUserService.findByIdUser(username);
        if (loginUser != null && password.equals(loginUser.getPassword())) {
            // 認証成功時は、認証トークン(ユーザ名、パスワード、権限)を作成
            return new UsernamePasswordAuthenticationToken(username, password,
                    AuthorityUtils.createAuthorityList(String.valueOf(loginUser.getRole())));
        } else {
            // 認証失敗は、エラーを返す
            throw new BadCredentialsException("Authentication failed");
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

}