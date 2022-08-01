package com.garden.web.member.jpa.entity;

import javafx.scene.NodeBuilder;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name="member")
public class MemberEntity {

  @Builder
  public MemberEntity(String oid,String userId, String userName, String password, String status){
    this.oid = oid;
    this.userId = userId;
    this.userName = userName;
    this.password = password;
    this.status = status;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="oid", length = 255, nullable = false)
  @Size(min=4, max=255)
  private String oid;

  @Column(name="userId", length = 255, nullable = false)
  @Size(min=2, max=255)
  private String userId;

  @Column(name="userName", length = 255, nullable = false)
  @Size(min=2, max=255)
  private String userName;

  @Column(name="status", length = 10)
  @Size(min=1, max=10)
  private String status;

  @Column(name="password", length = 255, nullable = false)
  @Size(min=10, max=255)
  private String password;

  @Column(name="email", length = 255)
  private String email;

  @Column(name="birthdate", length = 255)
  private String birthdate;

  @Column(name="fail_count", length = 10)
  @ColumnDefault("0")
  private String fail_count;

}
