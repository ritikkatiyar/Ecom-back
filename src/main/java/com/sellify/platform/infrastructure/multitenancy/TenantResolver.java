package com.sellify.platform.infrastructure.multitenancy;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;

@Component
public class TenantResolver {
    public static final String TENANT_HEADER="X-Tenant-Id";
    public String resolveTenant(HttpServletRequest request){
        String tenantId=request.getHeader(TENANT_HEADER);
        if(tenantId==null || tenantId.isBlank()){
            throw new TenantNotFoundException("Tenant not found in request");
        }
        return tenantId;
    }
}
