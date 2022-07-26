package com.garden.web.member.jpa.repository;

import com.garden.web.member.dto.MemberDto;
import com.garden.web.member.jpa.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<MemberEntity, String> {

  MemberEntity findByUserIdAndPassword(String userId, String password);

  Boolean getByUserIdAndStatus(String userId,String status);
}
