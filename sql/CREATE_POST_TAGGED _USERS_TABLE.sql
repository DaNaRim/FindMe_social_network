CREATE TABLE POST_TAGGED_USERS
(
    POST_ID        INT REFERENCES POST (ID),
    TAGGED_USER_ID INT REFERENCES USERS (ID),
    CONSTRAINT POST_USER_TAGGED_PK PRIMARY KEY (POST_ID, TAGGED_USER_ID)
);
