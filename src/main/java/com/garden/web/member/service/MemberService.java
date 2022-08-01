package com.garden.web.member.service;

import com.garden.web.member.constant.ErrorCode;
import com.garden.web.member.dto.MemberDto;
import com.garden.web.member.jpa.entity.MemberEntity;
import com.garden.web.member.jpa.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.Map;

@Service("memberService")
public class MemberService {

  @Autowired
  protected MemberRepository memberRepository;

  @Transactional
  public void add(MemberDto dto) throws Exception {
    try {

      // 동일한 아이디 있는지 확인
      Boolean isUser = memberRepository.getByUserIdAndStatus(dto.getUserId(),"Y");

      if(isUser == null){
        MemberEntity entity = MemberEntity.builder()
          .userId(dto.getUserId())
          .userName(dto.getUserName())
          .password(dto.getPassword())
          .status("Y")
          .build();
        memberRepository.save(entity);
      }

    }catch (Exception e){
      throw new Exception(ErrorCode.USER_ALREADY_EXISTED.getCode());
    }
  }

  public void isUSer(MemberDto dto) throws Exception{
  try{
      // 동일한 아이디 있는지 확인
      String userId = dto.getUserId();
      String password = dto.getPassword();

      // 나중에 status추가
    MemberEntity entity = memberRepository.findByUserIdAndPassword(userId, password);

      if(entity == null || "".equals(entity)) {
        throw new Exception(ErrorCode.USER_NOT_FOUND.getCode());
      }
    }catch (Exception e){
      throw e;
    }
  }

}
