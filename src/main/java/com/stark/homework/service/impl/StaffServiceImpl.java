package com.stark.homework.service.impl;

import com.stark.homework.entity.Staff;
import com.stark.homework.mapper.StaffMapper;
import com.stark.homework.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffServiceImpl implements StaffService {

    private final StaffMapper staffMapper;

    @Autowired
    public StaffServiceImpl(StaffMapper staffMapper) {
        this.staffMapper = staffMapper;
    }

    @Override
    public List<Staff> getAll() {
        return staffMapper.selectAll();
    }
}
