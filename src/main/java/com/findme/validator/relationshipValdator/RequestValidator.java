package com.findme.validator.relationshipValdator;

import com.findme.exception.BadRequestException;

import static com.findme.model.RelationshipStatus.FRIENDS;
import static com.findme.model.RelationshipStatus.REJECTED;
import static com.findme.model.RelationshipStatus.REQUESTED;

public class RequestValidator extends RelationshipValidator {

    @Override
    public void checkParams(RelationshipValidatorParams params) throws BadRequestException {

        if (params.getNewStatus() == REQUESTED) {

            if (params.getCurrentStatus() == REQUESTED
                    && !params.getNewActionUserId().equals(params.getOldActionUserId())) {

                throw new BadRequestException("Cant sent request to user that sent request to you");

            } else if (params.getCurrentStatus() == REQUESTED) {
                throw new BadRequestException("You already sent request");

            } else if (params.getCurrentStatus() == FRIENDS) {
                throw new BadRequestException("You already friends");

            } else if (params.getCurrentStatus() == REJECTED
                    && !params.getNewActionUserId().equals(params.getOldActionUserId())) {

                throw new BadRequestException("Can`t send friend request again because user has rejected your request");

            } else if (params.getOutcomeRequests() > 10) {
                throw new BadRequestException("To many outcome requests");

            } else if (params.getFriends() > 99) {
                throw new BadRequestException("You must have less that 100 friends");
            }
        }
    }
}
