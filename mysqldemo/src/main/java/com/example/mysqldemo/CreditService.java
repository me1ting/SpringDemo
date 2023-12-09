package com.example.mysqldemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CreditService {
    @Autowired
    private LogRepository logDao;
    @Autowired
    private UserRepository userDao;

    //select,in-place update,insert
    @Transactional
    public void updateCredit1() {
        var userId = 1;
        var user = userDao.findById(userId);
        var cost = 1;
        user.setCredit(user.getCredit() - cost);
        userDao.updateCreditWithCost(user, cost);
        logDao.addOne(new Log(null, user.getId(), (long) cost, user.getCredit()));
    }

    //in-place update, select, insert
    @Transactional
    public void updateCredit2() {
        var userId = 1;
        var cost = 1;

        var user = new User();
        user.setId((long) userId);
        userDao.updateCreditWithCost(user, cost);
        user = userDao.findById(userId);
        logDao.addOne(new Log(null, user.getId(), (long) cost, user.getCredit()));
    }

    //select for update, update, insert
    @Transactional
    public void updateCredit3() {
        var userId = 1;
        var cost = 1;

        var user = userDao.findOneForUpdate(userId);
        user.setCredit(user.getCredit() - cost);
        userDao.updateCredit(user);
        logDao.addOne(new Log(null, user.getId(), (long) cost, user.getCredit()));
    }

    // 测试事务是否工作
    @Transactional
    public void transTest() {
        var user = userDao.findById(1);
        logDao.addOne(new Log(null, user.getId(), (long) 999, user.getCredit()));
        throw new RuntimeException("error");
    }
}
