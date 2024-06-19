package com.example.shimakiti.service;

import com.example.shimakiti.repository.CitiesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ユーザー登録画面Service
 * 
 * @author ys-fj
 *
 */
@Service
@RequiredArgsConstructor
public class BookmarkService implements ICitiesService {

	private final CitiesRepository cityRepository;

}
