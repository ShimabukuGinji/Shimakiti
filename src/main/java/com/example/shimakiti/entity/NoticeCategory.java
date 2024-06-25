//NoticeCategory
package com.example.shimakiti.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class NoticeCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String priority;
}