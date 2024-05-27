package ru.gustaff.teacher_rerister.service;

import ru.gustaff.teacher_rerister.dto.SchoolSubjectDto;
import ru.gustaff.teacher_rerister.repository.SchoolSubjectJdbcRepository;

import java.util.List;

import static ru.gustaff.teacher_rerister.service.converters.SchoolSubjectDtoJsonConverter.SCHOOL_SUBJECT_DTO_JSON_CONVERTER;

public class SchoolSubjectService {

    private final SchoolSubjectJdbcRepository schoolSubjectJdbcRepository;

    public SchoolSubjectService() {
        schoolSubjectJdbcRepository = SchoolSubjectJdbcRepository.SCHOOL_SUBJECT_JDBC_REPOSITORY;
    }

    public void save(SchoolSubjectDto schoolSubjectDto, int hoursPerWeek) {
        schoolSubjectJdbcRepository.save(SCHOOL_SUBJECT_DTO_JSON_CONVERTER.createDao(schoolSubjectDto, hoursPerWeek));
    }

    public boolean delete(int id) {
        return schoolSubjectJdbcRepository.delete(id);
    }

    public SchoolSubjectDto get(int id) {
        return SCHOOL_SUBJECT_DTO_JSON_CONVERTER.createDto(schoolSubjectJdbcRepository.get(id));
    }

    public List<SchoolSubjectDto> getAll() {
        return schoolSubjectJdbcRepository.getAll().stream()
                .map(SCHOOL_SUBJECT_DTO_JSON_CONVERTER::createDto)
                .toList();
    }
}
