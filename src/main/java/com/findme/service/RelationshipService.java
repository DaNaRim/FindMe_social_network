package com.findme.service;

import com.findme.exception.BadRequestException;
import com.findme.exception.InternalServerException;
import com.findme.exception.NotFoundException;
import com.findme.model.Relationship;
import com.findme.model.RelationshipStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RelationshipService {

    Relationship getOurRelationshipToUser(long userFromId, long userToId) throws InternalServerException;

    Relationship addRelationship(long userFromId, long userToId)
            throws InternalServerException, NotFoundException, BadRequestException;

    Relationship updateRelationShip(long userFromId, long userToId, RelationshipStatus status)
            throws InternalServerException, NotFoundException, BadRequestException;

    List<Relationship> getIncomeRequests(long userId) throws InternalServerException, NotFoundException;

    List<Relationship> getOutcomeRequests(long userId) throws InternalServerException, NotFoundException;

    boolean areUsersNotFriends(long userFromId, long userToId) throws InternalServerException;

}
