package com.steve.academysteveback.lecture.repository;


import com.steve.academysteveback.lecture.entity.ClassEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassRepository extends JpaRepository<ClassEntity, String> {

  ClassEntity findByClassNo(String classNo);

  // SQL 객체 파라미터 쿼리
  @Query(value = "update class SET hit= :#{#classEntity.hit} WHERE seq = :#{#classEntity.seq}", nativeQuery = true)
  public void updateBySeq(@Param(value = "classEntity") ClassEntity classEntity);
}
