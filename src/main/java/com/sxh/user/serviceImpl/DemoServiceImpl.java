package com.sxh.user.serviceImpl;

import com.sxh.user.mapper.UserMapper;
import com.sxh.user.model.User;
import com.sxh.user.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yang.shang
 * @create 2019-07-01 17:19
 **/
@Service
public class DemoServiceImpl implements DemoService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User demoMethod(Integer id) {
        return userMapper.selectById(id);
    }
}
