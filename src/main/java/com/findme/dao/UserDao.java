package com.findme.dao;

import com.findme.exception.InternalServerException;
import com.findme.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {

    User save(User user) throws InternalServerException;

    User findById(long id) throws InternalServerException;

    User update(User user) throws InternalServerException;

    User findByUsername(String username);

//    User findByMail(String mail) throws InternalServerException;

    boolean isUserMissing(long id) throws InternalServerException;

    boolean areUsersMissing(List<Long> usersIds) throws InternalServerException;

    void updateDateLastActive(long userId) throws InternalServerException;


    boolean arePhoneAndMailBusy(String phone, String mail) throws InternalServerException;

    boolean isPhoneBusy(String phone) throws InternalServerException;

    boolean isMailBusy(String mail) throws InternalServerException;

    String findPhone(long id) throws InternalServerException;

    String findMail(long id) throws InternalServerException;
}
