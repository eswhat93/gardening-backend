package com.garden.web.member.controller;

import com.garden.web.member.constant.ErrorCode;
import com.garden.web.member.dto.MemberDto;
import com.garden.web.member.jpa.entity.MemberEntity;
import com.garden.web.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.cors.CorsUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
@CrossOrigin(origins="*")
@RestController
@RequestMapping("/api")
public class MemberController {

  @Autowired
  private MemberService memberService;

  @PostMapping(value = "/signup")
  public ResponseEntity<Map<String,Object>> registerMember(HttpServletRequest request, HttpServletResponse response,
                                               @RequestBody MemberDto dto){
    Map<String,Object> result = new HashMap<>();
    try{
        memberService.add(dto);
        result.put("msg","success");
        return new ResponseEntity<>(result, HttpStatus.OK);
      }catch (Exception e){
        result.put("msg", e);
        return new ResponseEntity<>(result, HttpStatus.OK);
      }
  }


  @PostMapping(value = "/login")
  public ResponseEntity<Map<String,Object>> loginMember(HttpServletRequest request, HttpServletResponse response,
                                                  @RequestBody MemberDto dto){
    Map<String,Object> result = new HashMap<>();
    try{
      memberService.isUSer(dto);
      result.put("msg","success");
      result.put("userId", dto.getUserId());
      return new ResponseEntity<>(result, HttpStatus.OK);
    }catch(Exception e){
      result.put("msg", e);
      return new ResponseEntity<>(result, HttpStatus.OK);
    }
  }
}
