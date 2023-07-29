package com.app.pillars.configure.audit;

import com.app.pillars.dto.UserInfo;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

public class Auditor implements AuditorAware<Integer> {

    @Override
    public Optional<Integer> getCurrentAuditor() {
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();
        UserInfo principal =(UserInfo)authentication.getPrincipal();
        Integer id = principal.getId();
        return authentication != null ? Optional.of((Integer) id) : Optional.of(0);
    }
}
