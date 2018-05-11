package com.cjs.boot.service.impl;

import com.cjs.boot.service.ActivityService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ActivityServiceImpl implements ActivityService {
    @Transactional
    @Override
    public void save() {
        int a = 1 / 0;
    }
}
