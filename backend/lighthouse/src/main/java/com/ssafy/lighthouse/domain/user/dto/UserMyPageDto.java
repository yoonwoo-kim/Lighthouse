package com.ssafy.lighthouse.domain.user.dto;

import java.util.ArrayList;
import java.util.List;

<<<<<<< HEAD
import com.ssafy.lighthouse.domain.common.BaseEntity;
import com.ssafy.lighthouse.domain.common.dto.GugunDto;
import com.ssafy.lighthouse.domain.common.dto.SidoDto;
import com.ssafy.lighthouse.domain.user.entity.User;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;
=======
import com.ssafy.lighthouse.domain.user.entity.User;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
>>>>>>> parent of 80b7f2b (feat: study, user -> Tag, Sido, Gugun 타입 entity, dto 반영)

@Getter
@Setter
@NoArgsConstructor
@ToString
public class UserMyPageDto {
	private Long id;
	private String password;
	private String name;
	private String email;
	private String nickname;

	private String profileImgUrl;
	private int age;
	private Long sidoId;
	private Long gugunId;
	private String phoneNumber;
	private String description;
	List<Long> userTagList;

	@Builder
	public UserMyPageDto(Long id, String password, String name, String email, String nickname, String profileImgUrl,
		int age,
		Long sidoId, Long gugunId, String phoneNumber, String description, List<Long> userTagList) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.email = email;
		this.nickname = nickname;
		this.profileImgUrl = profileImgUrl;
		this.age = age;
		this.sidoId = sidoId;
		this.gugunId = gugunId;
		this.phoneNumber = phoneNumber;
		this.description = description;
		this.userTagList = userTagList;
	}

	public static UserMyPageDto from(User user) {
		return UserMyPageDto.builder()
			.id(user.getId())
			.name(user.getName())
			.email(user.getEmail())
			.nickname(user.getNickname())
			.profileImgUrl(user.getProfileImgUrl())
			.age(user.getAge())
			.sidoId(user.getSidoId())
			.gugunId(user.getGugunId())
			.phoneNumber(user.getPhoneNumber())
			.description(user.getDescription())
			.userTagList(new ArrayList<>())
			.build();
	}
}
