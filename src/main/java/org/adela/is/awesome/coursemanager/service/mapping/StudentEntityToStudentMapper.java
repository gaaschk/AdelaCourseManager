package org.adela.is.awesome.coursemanager.service.mapping;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import org.adela.is.awesome.coursemanager.persistence.entity.StudentEntity;
import org.adela.is.awesome.coursemanager.service.resource.Student;

@Mapper
public interface StudentEntityToStudentMapper {
	StudentEntityToStudentMapper INSTANCE = Mappers.getMapper(StudentEntityToStudentMapper.class);

	@Mapping(source="studentEntityId", target="studentId")
	Student studentEntityToStudent(StudentEntity source);

	@Mapping(source="studentId", target="studentEntityId")
	void studentToStudentEntity(Student source, @MappingTarget StudentEntity target);
}
