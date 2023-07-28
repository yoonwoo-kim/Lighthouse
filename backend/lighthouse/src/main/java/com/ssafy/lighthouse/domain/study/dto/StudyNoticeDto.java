package com.ssafy.lighthouse.domain.study.dto;

import com.ssafy.lighthouse.domain.study.entity.StudyNotice;
import com.ssafy.lighthouse.domain.study.entity.StudyNoticeCheck;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class StudyNoticeDto {
	@Getter
	@NoArgsConstructor(access = AccessLevel.PROTECTED)
	public static class StudyNoticeReq {
		private Long id;
		private int isValid;
		private Long studyId;
		private String content;

		@Builder
		public StudyNoticeReq(Long studyId, String content) {
			this.studyId = studyId;
			this.content = content;
		}

		public StudyNotice toEntity() {
			return StudyNotice.builder()
					.id(id)
					.isValid(isValid)
					.studyId(studyId)
					.content(content)
					.build();
		}
	}

	@Getter
	@NoArgsConstructor(access = AccessLevel.PROTECTED)
	public static class StudyNoticeRes {
		private Long id;
		private int isValid;
		private String createdAt;
		private Long studyId;
		private String content;

		public StudyNoticeRes(StudyNotice studyNotice) {
			this.id = studyNotice.getId();
			this.isValid = studyNotice.getIsValid();
			this.createdAt = studyNotice.getCreatedAt();
			this.studyId = studyNotice.getStudyId();
			this.content = studyNotice.getContent();
		}

		public boolean isValid() {
			return this.isValid == 1;
		}
	}

	@Getter
	@NoArgsConstructor(access = AccessLevel.PROTECTED)
	public static class StudyNoticeCheckReq {
		private Long id;
		private int isValid;
		private Long userId;
		private Long studyNoticeId;

		@Builder
		public StudyNoticeCheckReq(Long userId, Long studyNoticeId) {
			this.userId = userId;
			this.studyNoticeId = studyNoticeId;
		}

		public StudyNoticeCheck toEntity() {
			return StudyNoticeCheck.builder()
					.id(id)
					.isValid(isValid)
				.userId(userId)
				.studyNoticeId(studyNoticeId)
				.build();
		}
	}

	@Getter
	@NoArgsConstructor(access = AccessLevel.PROTECTED)
	public static class StudyNoticeCheckRes {
		private Long id;
		private String createdAt;
		private Long userId;
		private Long studyNoticeId;

		public StudyNoticeCheckRes(StudyNoticeCheck studyNoticeCheck) {
			this.id = studyNoticeCheck.getId();
			this.createdAt = studyNoticeCheck.getCreatedAt();
			this.userId = studyNoticeCheck.getUserId();
			this.studyNoticeId = studyNoticeCheck.getStudyNoticeId();
		}
	}
}
