package com.garden.web.member.jpa.repository;

import com.garden.web.member.jpa.entity.MemberEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MemberRepositoryTest {

  @Autowired
  MemberRepository memberRepository;

  @Test
  void test() {
    MemberEntity entity = MemberEntity.builder()
      .userId("les")
      .userName("ennsol")
      .password("1234")
      .build();
    memberRepository.save(entity);

  }
}
