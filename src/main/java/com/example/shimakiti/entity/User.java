package com.example.shimakiti.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name="users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @NotEmpty( message = "※ログインID（メールアドレス）を入力してください")
    @Size( max = 50 ,message = "50文字以内で入力してください")
    @Column(name="username")
    private String username;

    @NotEmpty( message = "※パスワードを入力してください")
    @Size( max = 255 ,message = "255文字以内で入力してください")
    @Column(name = "password")
    private String password;

    @NotEmpty( message = "※氏名を入力してください")
    @Size( max = 50 ,message = "50文字以内で入力してください")
    @Column(name="name")
    private String name;

    private int role;

    @Column(name="profile_picture")
    private UUID profile_uuid;

    @Size( max = 300 ,message = "300文字以内で入力してください")
    @Column(name = "bio")
    private String bio;

    @Column(name="created_at")
    private Date created_at;

    @Column(name = "updated_at")
    private Date updated_at;

}