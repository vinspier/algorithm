package com.vinspier.work.polling;

/**
 * 大鱼网络科技有限公司 版权所有 © Copyright 2018<br>
 *
 * @Description: <br>
 * @Project: <br>
 * @CreateDate: Created in 2020/8/6 10:05 <br>
 * @Author: <a href="fanxb@haibaobaoxian.cn">fxb</a>
 */
public class Node {

    // 标识
    private Integer id;
    // 是否可用 0 不可用 1 可用
    private Integer work;

    public Node(Integer id, Integer work) {
        this.id = id;
        this.work = work;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getWork() {
        return work;
    }

    public void setWork(Integer work) {
        this.work = work;
    }

    @Override
    public String toString() {
        return "Node{" +
                "id=" + id +
                ", work=" + work +
                '}';
    }
}
