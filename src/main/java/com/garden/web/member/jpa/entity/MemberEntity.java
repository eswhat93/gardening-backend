package com.garden.web.member.jpa.entity;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Getter
@Setter
@Entity
@Table(name="member")
public class MemberEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="id", length = 255, nullable = false)
  @Size(min=4, max=255)
  private Long id;

  @Column(name="name", length = 255, nullable = false)
  @Size(min=2, max=255)
  private String name;

  @Column(name="status", length = 10)
  @Size(min=1, max=10)
  private String status;

  @Column(name="password", length = 255, nullable = false)
  @Size(min=10, max=255)
  private String password;

  @Column(name="email", length = 255)
  private String email;

  @Column(name="birthdate", length = 255, nullable = false)
  private String birthdate;

  @Column(name="fail_count", length = 10, nullable = false)
  private String fail_count;

}
