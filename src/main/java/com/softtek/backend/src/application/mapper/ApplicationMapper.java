package com.softtek.backend.src.application.mapper;

import java.util.Map;
import java.util.stream.Collectors;

import com.softtek.backend.src.application.dto.CreateFeelingDto;
import com.softtek.backend.src.application.dto.CreateRatingDto;
import com.softtek.backend.src.application.dto.EmailBEmailDto;
import com.softtek.backend.src.application.dto.SafeQuestion;
import com.softtek.backend.src.application.dto.SafeRating;
import com.softtek.backend.src.application.dto.SafeUser;
import com.softtek.backend.src.domain.entity.BusinessEmail;
import com.softtek.backend.src.domain.entity.Feeling;
import com.softtek.backend.src.domain.entity.Rating;
import com.softtek.backend.src.domain.entity.User;
import com.softtek.backend.src.domain.type.AnswerOption;
import com.softtek.backend.src.domain.type.Question;
import com.softtek.backend.src.domain.type.Role;
import com.softtek.backend.src.presentation.dto.CreateUserDto;

public class ApplicationMapper {

	public static SafeUser toSafe(User user) {
	    SafeUser safeUser = new SafeUser(user.getUsername(), user.getPassword());
					
		return safeUser;
	}

	public static SafeRating toSafe(Rating rating) {
		Map<String, SafeQuestion> safeQuestions = rating.getQuestions()
			.entrySet()
			.stream()
			.collect(Collectors.toMap(
				Map.Entry::getKey, 
				entry -> {               
					Question q = entry.getValue();

					Map<String, String> safeAlts = q.getAlternatives()
						.entrySet()
						.stream()
						.collect(Collectors.toMap(
							Map.Entry::getKey,
							e -> e.getValue().getOptionText()
						));

					return new SafeQuestion(
						q.getKey(),
						q.getText(),
						safeAlts
					);
				})
			);

		SafeRating safeRating = new SafeRating(
			rating.getId(), 
			rating.getName(),
			safeQuestions
		);

		return safeRating;
	}
	
	public static User toDomain(CreateUserDto dto) {
	    User user = new User(null, dto.username, dto.password, Role.USER, false);
					
		return user;
	}

	public static BusinessEmail toDomain(EmailBEmailDto dto) {
		BusinessEmail businessEmail = new BusinessEmail(
			null,
			dto.email, 
			false
		);

		return businessEmail;
	}

	public static Rating toDomain(CreateRatingDto dto) {
		Map<String, Question> questions = dto.questions
				.entrySet()
				.stream()
				.collect(Collectors.toMap(
					Map.Entry::getKey, entry -> new Question(
						entry.getKey(), 
						entry.getValue().text,
						entry.getValue().alternatives.entrySet().stream()
							.collect(Collectors.toMap(
								Map.Entry::getKey, 
								e -> new AnswerOption(e.getValue().getOptionText(), e.getValue().getPoints())
							))
					))
				);
		
		Rating rating = new Rating(
			null, 
			dto.name, 
			questions,
			0
			);

		return rating;
	}

	public static Feeling toDomain(CreateFeelingDto dto) {
		Feeling feeling = new Feeling(
			null, 
			dto.name
		);

		return feeling;
	}
} 