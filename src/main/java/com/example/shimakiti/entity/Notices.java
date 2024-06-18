//Notice
package com.example.shimakiti.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.Locale;

@Entity
@Data
public class Notices {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String detail;
    private String title;

    @OneToOne
    private NoticeCategory category;
    private Date createdAt;
}
