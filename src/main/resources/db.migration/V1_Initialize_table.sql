-- oauth
create table oauth_client_details
(
    client_id               VARCHAR(256) PRIMARY KEY,
    resource_ids            VARCHAR(256),
    client_secret           VARCHAR(256),
    scope                   VARCHAR(256),
    authorized_grant_types  VARCHAR(256),
    web_server_redirect_uri VARCHAR(256),
    authorities             VARCHAR(256),
    access_token_validity   INTEGER,
    refresh_token_validity  INTEGER,
    additional_information  VARCHAR(4096),
    autoapprove             VARCHAR(256)
);

create table oauth_client_token
(
    token_id          VARCHAR(256),
    token bytea,
    authentication_id VARCHAR(256),
    user_name         VARCHAR(256),
    client_id         VARCHAR(256)
);

create table oauth_access_token
(
    token_id          VARCHAR(256),
    token bytea,
    authentication_id VARCHAR(256),
    user_name         VARCHAR(256),
    client_id         VARCHAR(256),
    authentication bytea,
    refresh_token     VARCHAR(256)
);

create table oauth_refresh_token
(
    token_id VARCHAR(256),
    token bytea,
    authentication bytea
);


INSERT INTO oauth_client_details(client_id, client_secret, scope, access_token_validity, authorized_grant_types)
VALUES ('test', 'test', 'read,write', 3600,
        'client_credentials, authorization_code, implicit, password, refresh_token');

-- custom data
CREATE TABLE public.employee
(
    -- pc 등록
    seq bigserial NOT NULL PRIMARY KEY,
    company_id  character varying(255) NOT NULL,
    employee_id character varying(255) NOT NULL
);
