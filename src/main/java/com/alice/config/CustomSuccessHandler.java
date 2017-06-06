package com.alice.config;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by User on 006 06.05.17.
 */
@Component
public class CustomSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Override
    protected void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
       String targetUrl = determineTargetUrl(authentication);

       if(response.isCommitted()){
           System.out.println("Can't redirect");
           return;
       }

       redirectStrategy.sendRedirect(request, response, targetUrl);
    }

    //берем роли из текущего пользователя и отдаем соответствующую ссылку
    public String determineTargetUrl(Authentication authentication) {
        String url;
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        List<String> roles = new ArrayList<String>();

        for (GrantedAuthority authority : authorities) {
            roles.add(authority.getAuthority());
        }

        if (isAdmin(roles)) {
            url = "/admin/main";
        } else if (isUser(roles)) {
            url = "/user/index";
        } else {
            url = "/user/main";
        }
        return url;
    }

    public boolean isUser(List<String> roles) {
        return roles.contains("USER");
    }

    public boolean isAdmin(List<String> roles) {
       return roles.contains("ADMIN");
    }

    @Override
    public RedirectStrategy getRedirectStrategy() {
        return redirectStrategy;
    }

    @Override
    public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
        this.redirectStrategy = redirectStrategy;
    }
}
