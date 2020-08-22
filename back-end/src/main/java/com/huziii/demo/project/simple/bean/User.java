package com.huziii.demo.project.simple.bean;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name = "simple_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "user_name", unique = true, nullable = false)
    private String name;

    @Column(name = "user_password", nullable = false)
    private String password;

    @Column(name = "user_type", nullable = false)
    private String type;

    @Column(name = "user_phone", nullable = false)
    private String phone;

    @Column(name = "user_birthday")
    private Date birthday;

    @Column(name = "user_gender")
    private Boolean gender;

    @Column(name = "user_email")
    private String email;

    @Column(name = "user_avatar_path")
    private String avatarPath;

}
