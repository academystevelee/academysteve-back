package com.steve.academysteveback.manage.service;

import com.steve.academysteveback.manage.repository.UserAuthRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ManageService {

    private final UserAuthRepository userAuthRepository;

    public void reqPromotionService(List<String> data) {
    }
}