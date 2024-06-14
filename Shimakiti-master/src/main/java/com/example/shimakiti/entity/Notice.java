package com.example.shimakiti.entity;

import lombok.Getter;

import java.util.Date;


public record Notice(int id, int category, String detail, String title, Date created_at, Date updated_at ) {
}
