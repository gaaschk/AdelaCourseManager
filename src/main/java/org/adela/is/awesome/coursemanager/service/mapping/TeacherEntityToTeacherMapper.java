package org.adela.is.awesome.coursemanager.service.mapping;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import org.adela.is.awesome.coursemanager.persistence.entity.TeacherEntity;
import org.adela.is.awesome.coursemanager.service.resource.Teacher;

@Mapper
public interface TeacherEntityToTeacherMapper {
	TeacherEntityToTeacherMapper INSTANCE = Mappers.getMapper(TeacherEntityToTeacherMapper.class);

	@Mapping(source="teacherEntityId", target="teacherId")
	Teacher teacherEntityToTeacher(TeacherEntity source);

	@Mapping(source="teacherId", target="teacherEntityId")
	void teacherToTeacherEntity(Teacher source, @MappingTarget TeacherEntity target);
}
