package com.softtek.backend.src.infrastructure.mapper;

import com.softtek.backend.shared.infrastructure.database.entity.SpringDataBusinessEmail;
import com.softtek.backend.shared.infrastructure.database.entity.SpringDataCheckIn;
import com.softtek.backend.shared.infrastructure.database.entity.SpringDataFeeling;
import com.softtek.backend.shared.infrastructure.database.entity.SpringDataRating;
import com.softtek.backend.shared.infrastructure.database.entity.SpringDataRatingAnswer;
import com.softtek.backend.shared.infrastructure.database.entity.SpringDataUser;
import com.softtek.backend.src.domain.entity.BusinessEmail;
import com.softtek.backend.src.domain.entity.CheckIn;
import com.softtek.backend.src.domain.entity.Feeling;
import com.softtek.backend.src.domain.entity.Rating;
import com.softtek.backend.src.domain.entity.RatingAnswer;
import com.softtek.backend.src.domain.entity.User;

public class InfrastructureMapper {
    public static User toDomain(SpringDataUser sDataUser) {
        User user = new User(
            sDataUser.getId(), 
            sDataUser.getUsername(),
            sDataUser.getPassword(), 
            sDataUser.getRole(),
            sDataUser.isActive()
        );
        
        return user;
    }

    public static Rating toDomain(SpringDataRating sDataRating) {
        Rating rating = new Rating(
            sDataRating.getId(), 
            sDataRating.getName(), 
            sDataRating.getQuestions(),
            sDataRating.getMaxScore()
        );

        return rating;
    }

    public static BusinessEmail toDomain(SpringDataBusinessEmail sDataBusinessEmail) {
        BusinessEmail businessEmail = new BusinessEmail(
            sDataBusinessEmail.getId(), 
            sDataBusinessEmail.getEmail(), 
            sDataBusinessEmail.isUsed()
        );

        return businessEmail;
    }

    public static RatingAnswer toDomain(SpringDataRatingAnswer sDataRatingAnswer) {
        RatingAnswer ratingAnswer = new RatingAnswer(
            sDataRatingAnswer.getId(), 
            sDataRatingAnswer.getUserId(), 
            sDataRatingAnswer.getRatingId(), 
            sDataRatingAnswer.getAnswers(), 
            sDataRatingAnswer.getTotalScore(), 
            sDataRatingAnswer.getRiskLevel(),
            sDataRatingAnswer.getProgress()
        );

        return ratingAnswer;
    }

    public static CheckIn toDomain(SpringDataCheckIn sDataCheckIn) {
        CheckIn checkIn = new CheckIn(
            sDataCheckIn.getId(), 
            sDataCheckIn.getUserId(), 
            sDataCheckIn.getFeelingId(), 
            sDataCheckIn.getCheckInAt()
        );

        return checkIn;
    }

    public static Feeling toDomain(SpringDataFeeling sDataFeeling) {
        Feeling feeling = new Feeling(
            sDataFeeling.getId(),
            sDataFeeling.getName()
        );

        return feeling;
    }
    
    public static SpringDataUser toData(User user) {
        SpringDataUser dataUser = new SpringDataUser(
            user.getId(), 
            user.getUsername(), 
            user.getPassword(),
            user.getRole(),
            user.getActive()
        );
        
        return dataUser;
    }

    public static SpringDataRating toData(Rating rating) {
        SpringDataRating dataRating = new SpringDataRating(
            rating.getId(),
            rating.getName(),
            rating.getQuestions(),
            rating.getMaxScore()
        );

        return dataRating;
    }

    public static SpringDataBusinessEmail toData(BusinessEmail email) {
        SpringDataBusinessEmail dataBusinessEmail = new SpringDataBusinessEmail(
            email.getId(),
            email.getEmail(),
            email.getIsUsed()
        );

        return dataBusinessEmail;
    }

    public static SpringDataRatingAnswer toData(RatingAnswer ratingAnswer) {
        SpringDataRatingAnswer dataRatingAnswer = new SpringDataRatingAnswer(
            ratingAnswer.getId(),
            ratingAnswer.getUserId(),
            ratingAnswer.getRatingId(),
            ratingAnswer.getAnswers(),
            ratingAnswer.getTotalScore(),
            ratingAnswer.getRiskLevel(),
            ratingAnswer.getProgress()
        );

        return dataRatingAnswer;
    }

    public static SpringDataCheckIn toData(CheckIn checkIn) {
        SpringDataCheckIn dataCheckIn = new SpringDataCheckIn(
            checkIn.getId(), 
            checkIn.getUserId(), 
            checkIn.getFeelingId(), 
            checkIn.getCheckInAt()
        );

        return dataCheckIn;
    }

    public static SpringDataFeeling toData(Feeling feeling) {
        SpringDataFeeling dataFeeling = new SpringDataFeeling(
            feeling.getId(), 
            feeling.getName()
        );

        return dataFeeling;
    }
}