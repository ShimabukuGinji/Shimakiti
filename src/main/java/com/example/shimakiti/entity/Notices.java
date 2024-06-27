//Notice
package com.example.shimakiti.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.util.Date;
import java.util.Locale;

@Entity
@Data
public class Notices {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "詳細が空白になっています。")
    private String detail;

    @NotEmpty(message = "タイトルが空白になっています。")
    private String title;

    @OneToOne
    private NoticeCategory category;

    private Date createdAt;

    private Date updatedAt;
}