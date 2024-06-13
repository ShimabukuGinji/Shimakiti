package com.example.shimakiti.entity;

public record User(int id, String username, String password, String email, String role, String profile_picture, String bio, String created_at, String updated_at) {
}
