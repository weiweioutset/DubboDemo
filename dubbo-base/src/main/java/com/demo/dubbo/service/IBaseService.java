package com.demo.dubbo.service;

/**
 * @author weiwei
 * @version 1.0
 * @date 2022/3/1 下午4:19
 * @desc
 */
public interface IBaseService<T> {
    /**
     * 新增
     */
    int add(T data);

    /**
     * 删除
     */
    int delete(Object id);

    /**
     * 更新
     */
    int update(T data);

    /**
     * 查找
     */
    T get(Object id);
}
