package com.ssafy.lighthouse.domain.study.controller;

import javax.servlet.http.HttpServlet;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.lighthouse.domain.common.util.S3Utils;
import com.ssafy.lighthouse.domain.study.dto.StudyMaterialDto;
import com.ssafy.lighthouse.domain.study.service.StudyMaterialService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("study-material")
@AllArgsConstructor
public class StudyMaterialController extends HttpServlet {
	private static final String SUCCESS= "success";

	private StudyMaterialService studyMaterialService;
	private final S3Utils s3Utils;

	@PostMapping(consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
	public ResponseEntity<String> createMaterial(@ModelAttribute StudyMaterialDto.Req dto) {
		System.out.println(dto.toString());
		System.out.println(dto.getFile().getName());
		studyMaterialService.createMaterial(dto, dto.getFile());
		return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
	}

	@PutMapping("/{study-material-id}")
	public ResponseEntity<String> updateMaterial(@PathVariable("study-material-id") final Long id,
												@RequestPart(value = "studymaterial") StudyMaterialDto.Req dto,
												@RequestPart MultipartFile file) {
		studyMaterialService.updateMaterialFromId(id, dto, file);
		return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
	}

	@DeleteMapping("/{study-material-id}")
	public ResponseEntity<String> removeMaterial(@PathVariable("study-material-id") final Long id) {
		studyMaterialService.removeMaterial(id);
		return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
	}
}
