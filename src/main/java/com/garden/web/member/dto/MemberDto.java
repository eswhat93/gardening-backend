package com.garden.web.member.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class MemberDto {

  private String id;

  private String userId;

  private String userName;

  private String status;

  private String password;

  private String email;

  private String birthdate;

  private String fail_count;

}
