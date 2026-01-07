package com.sellify.platform.infrastructure.multitenancy;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class TenantFilter extends OncePerRequestFilter {
    private final TenantResolver tenantResolver;

    public TenantFilter(TenantResolver tenantResolver){
        this.tenantResolver=tenantResolver;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        try{
            String tenantId=tenantResolver.resolveTenant(request);
            TenantContext.setTenantId(tenantId);
            filterChain.doFilter(request,response);
        }finally {
            TenantContext.clear();
        }

    }
}
