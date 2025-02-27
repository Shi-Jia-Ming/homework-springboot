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
    public List<Staff> getHeadTeacher() {
        return staffMapper.selectHeadTeacher();
    }

    @Override
    public int searchMaleCount() {
        return staffMapper.searchMaleCount();
    }

    @Override
    public int searchFemaleCount() {
        return staffMapper.searchFemaleCount();
    }

    @Override
    public int searchJobCount(int job) {
        return staffMapper.searchJobCount(job);
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
    public boolean isExist(int id) {
        Staff staff = staffMapper.selectById(id);
        return !(staff == null);
    }

    @Override
    public int create(Staff staff) {
        staffMapper.insert(staff);
        return staff.getId();
    }

    @Override
    public void update(Staff staff) {
        staffMapper.update(staff);
    }

    @Override
    public void delete(Staff staff) {
        staffMapper.delete(staff);
    }
}
