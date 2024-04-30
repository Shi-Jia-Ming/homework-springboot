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

    @Override
    public List<Staff> search(Staff staff) {
        return staffMapper.selectWithLike(staff);
    }

    @Override
    public boolean isExist(String username) {
        Staff staff = staffMapper.selectByUsername(username);
        return !(staff == null);
    }

    @Override
    public int create(Staff staff) {
        staffMapper.insert(staff);
        return staff.getId();
    }
}
