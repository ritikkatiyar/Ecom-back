CREATE TABLE tenant (
    tenant_id      UUID PRIMARY KEY,
    business_name  VARCHAR(255) NOT NULL,
    primary_domain VARCHAR(255) UNIQUE,
    status         VARCHAR(30) NOT NULL,
    created_at     TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP
);



CREATE TABLE users (
    user_id        UUID PRIMARY KEY,
    tenant_id      UUID NOT NULL,
    email          VARCHAR(255) NOT NULL,
    password_hash  VARCHAR(255) NOT NULL,
    active         BOOLEAN DEFAULT TRUE,
    created_at     TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT uq_tenant_email UNIQUE (tenant_id, email),
    CONSTRAINT fk_user_tenant FOREIGN KEY (tenant_id) REFERENCES tenant(tenant_id)
);

