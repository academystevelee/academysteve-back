package com.steve.academysteveback.blog.repository;


import com.steve.academysteveback.blog.entity.BlogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends JpaRepository<BlogEntity, Long> {

  //BlogEntity findByClassNo(String classNo);
  BlogEntity findBySeq(Long seq);
}
