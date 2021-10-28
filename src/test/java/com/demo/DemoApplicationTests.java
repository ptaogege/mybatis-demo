package com.demo;

import cn.hutool.core.util.RandomUtil;
import com.demo.entity.UserDo;
import com.demo.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@SpringBootTest
class DemoApplicationTests {
    @Resource
    private UserMapper userMapper;

    @Test
    public void insert() {
        for (int i = 0; i < 5; i++) {
            UserDo userDo = new UserDo();
            userDo.setUsername(RandomUtil.randomString("qazxswedcvfrtgb",5));
            userDo.setPassword(UUID.randomUUID().toString());
            userDo.setCreateTime(new Date());
            userMapper.insertInfo(userDo);
        }
    }

    @Test
    public void delete() {
        userMapper.deleteUser(9);
    }

    /**
     * set，if 元素
     */
    @Test
    public void update() {
        UserDo userDo = new UserDo();
        userDo.setId(11);
        userDo.setUsername("dada");
        userDo.setCreateTime(new Date());
        userMapper.updateInfo(userDo);
    }

    /**
     * 字符串替换
     */
    @Test
    public void select() {
        UserDo userInfo = userMapper.selectByColumn("id", "15");

        System.out.println(userInfo.getUsername());
    }

    /**
     * foreach 元素
     */
    @Test
    public void selectByIds() {
        List<UserDo> doList = userMapper.selectByIds(Arrays.asList(8,10));
        for (UserDo aDo : doList) {
            System.out.println(aDo.getUsername());
        }
    }

    /**
     * where,choose 元素
     */
    @Test
    public void findActiveUser() {
        UserDo userDo = new UserDo();
        userDo.setId(11);
        List<UserDo> doList = userMapper.findActiveUser(userDo);
        for (UserDo aDo : doList) {
            System.out.println(aDo.getUsername());
        }
    }
}
