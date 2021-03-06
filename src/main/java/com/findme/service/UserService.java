package com.findme.service;

import com.findme.exception.BadRequestException;
import com.findme.exception.InternalServerException;
import com.findme.exception.NotFoundException;
import com.findme.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService extends UserDetailsService {

    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;

    User findById(long id) throws NotFoundException, InternalServerException;

    boolean isUserMissing(long id) throws InternalServerException;

    boolean isUsersMissing(List<Long> usersIds) throws InternalServerException;

    User registerUser(User user) throws BadRequestException, InternalServerException;

    User updateUser(User user) throws BadRequestException, InternalServerException;

//    User login(String mail, String password) throws BadRequestException, InternalServerException;

    void updateDateLastActive(long userId) throws InternalServerException;
}
