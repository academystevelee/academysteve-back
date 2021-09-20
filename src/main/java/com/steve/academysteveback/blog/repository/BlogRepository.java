package com.steve.academysteveback.blog.repository;


import com.steve.academysteveback.blog.entity.BlogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface BlogRepository extends JpaRepository<BlogEntity, Long> {

  //BlogEntity findByClassNo(String classNo);

    @Modifying
    @Query("update BLOG b set b.delYn = 'Y' where b.seq = ?1")
    int updateDelY(Long seq);

    @Modifying
    @Query("update BLOG b set b.delYn = 'N' where b.seq = ?1")
    int updateDelN(Long seq);
}
