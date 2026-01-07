package com.sellify.platform.infrastructure.multitenancy;

public class TenantNotFoundException extends RuntimeException{
    public TenantNotFoundException(String message){
        super(message);
    }
}
