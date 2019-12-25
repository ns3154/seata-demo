package com.example.seata.controller;
import java.math.BigDecimal;

import com.example.seata.dao.order.OrderMapper;
import com.example.seata.dao.user.UserMapper;
import com.example.seata.entity.po.Order;
import com.example.seata.entity.po.User;
import io.seata.spring.annotation.GlobalTransactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <pre>
 *
 * </pre>
 * @author 杨帮东
 * @since 1.0
 * @date 2019/12/25 14:52
 **/
@RestController
public class TestController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private UserMapper userMapper;

    @Resource
    private OrderMapper orderMapper;

    @GetMapping("create")
    public void createUser() {
        User user = new User();
        user.setUserName("张三");
        user.setSex(1);
        user.setBalance(0.0D);
        int i = userMapper.insertSelective(user);
        logger.info("**** user 执行成功:{}", i);
    }

    @GetMapping("user")
    public User user(Long userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    @GetMapping("crateUserByErrorTransaction")
    @Transactional(rollbackFor = Exception.class)
    public void crateUserByErrorTransaction() throws Exception {
        User user = new User();
        user.setUserName("张三");
        user.setSex(1);
        user.setBalance(0.0D);
        int i = userMapper.insertSelective(user);
        logger.info("**** user 执行成功:{}", i);
        throw new Exception("手动抛异常");
    }

    @GetMapping("createUserAndOrder")
    public void createUserAndOrder() {
        User user = new User();
        user.setUserName("张三");
        user.setSex(1);
        user.setBalance(0.0D);
        int userCount = userMapper.insertSelective(user);

        Order order = new Order();
        order.setUserId(2L);
        order.setPrice(new BigDecimal("0"));
        order.setProductName("张三");
        order.setStatus(0);
        order.setCreateTime(System.currentTimeMillis());
        order.setUpdateTime(System.currentTimeMillis());
        int orderCount = orderMapper.insertSelective(order);

        logger.info("** 插入数据, user:{}, order:{} **", userCount, orderCount);
    }

    @GetMapping("createUserAndOrderByErrorTransaction")
    @GlobalTransactional(rollbackFor = Exception.class)
//    @Transactional(rollbackFor = Exception.class)
    public void createUserAndOrderByErrorTransaction() throws Exception {
        User user = new User();
        user.setUserName("张三");
        user.setSex(1);
        user.setBalance(0.0D);
        int userCount = userMapper.insertSelective(user);

        Order order = new Order();
        order.setUserId(2L);
        order.setPrice(new BigDecimal("0"));
        order.setProductName("张三");
        order.setStatus(0);
        order.setCreateTime(System.currentTimeMillis());
        order.setUpdateTime(System.currentTimeMillis());
        int orderCount = orderMapper.insertSelective(order);

        logger.info("** 插入数据, user:{}, order:{} **", userCount, orderCount);
        throw new Exception("手动抛异常");

    }




}
