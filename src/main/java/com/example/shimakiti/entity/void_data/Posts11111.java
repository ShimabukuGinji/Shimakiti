package com.example.shimakiti.entity.void_data;

import java.util.Date;

public record Posts11111(int id,
                         int user_id,
                         int category_id,
                         int cities_id,
                         String title,
                         String image1,
                         String image2,
                         String image3,
                         String image4,
                         String image5,
                         String summary,
                         String detail,
                         String address,
                         long map_longitude,
                         long map_latitude,
                         String link,
                         Date created_at,
                         Date update_at) { }
