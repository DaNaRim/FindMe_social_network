CREATE TABLE RELATIONSHIP
(
    ID             INT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    USER_FROM      INT REFERENCES USERS                NOT NULL,
    USER_TO        INT REFERENCES USERS                NOT NULL
        CHECK (USER_FROM != USER_TO),
    STATUS         VARCHAR(16)                         NOT NULL
        CHECK (STATUS IN ('DELETED',
                          'REQUESTED',
                          'REJECTED',
                          'FRIENDS')),
    ACTION_USER_ID INT                                 NOT NULL
        CHECK (ACTION_USER_ID IN (USER_FROM, USER_TO)),
    DATE_MODIFY    TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL
);