package com.example.shimakiti.service;

import com.example.shimakiti.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * ユーザー登録画面Service
 * 
 * @author ys-fj
 *
 */
@Service
@RequiredArgsConstructor
public class UserService implements IUserService {

	private final UserRepository userRepository;

}
