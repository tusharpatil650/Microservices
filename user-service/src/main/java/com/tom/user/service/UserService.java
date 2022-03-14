package com.tom.user.service;

import com.tom.user.entity.User;
import com.tom.user.repository.UserRepository;
import com.tom.user.vo.Department;
import com.tom.user.vo.ResponseTemplateVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    public User saveUser(User user) {
        log.info("Inside saveuser method of UserService");
        return userRepository.save(user);
    }

    public ResponseTemplateVo getUserWithDepartment(Long userId) {
        ResponseTemplateVo vo = new ResponseTemplateVo();
        User user = userRepository.findByUserId(userId);

        Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/" + user.getDepartmentId(), Department.class);
        vo.setDepartment(department);
        vo.setUser(user);
        return vo;
    }
}
