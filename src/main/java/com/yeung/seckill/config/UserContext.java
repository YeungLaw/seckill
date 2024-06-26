package com.yeung.seckill.config;


import com.yeung.seckill.pojo.User;

/**
 * @author Yeung Law~
 * @version 1.0
 *
 * 定义一个ThreadLocal，用于数据共享，保证线程共享
 */
public class UserContext {

    //每个线程都有自己的ThreadLocal, 把共享数据存放到这里，保证线程安全
    private static ThreadLocal<User> userHolder = new ThreadLocal<>();

    public static void setUser(User user) {
        userHolder.set(user);
    }

    public static User getUser() {
        return userHolder.get();
    }
}
