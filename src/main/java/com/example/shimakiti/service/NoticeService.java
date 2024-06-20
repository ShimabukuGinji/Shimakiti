package com.example.shimakiti.service;

import com.example.shimakiti.repository.NoticeRepository;
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
public class NoticeService implements INoticeService {

	private final NoticeRepository noticeRepository;

}
