package com.wantupai.app.model.bean;

import java.io.Serializable;
import java.util.List;

/**
 * @author luxuchang
 * @date 2019/5/9 0009
 * @description
 */
public class TabBean implements Serializable{

    /**
     * code : 1
     * msg : 获取成功
     * data : [{"id":1,"name":"推荐"},{"id":3,"name":"植物"},{"id":2,"name":"萌宠"},{"id":8,"name":"电商"},{"id":9,"name":"汽车"},{"id":6,"name":"旅拍"}]
     */

    private int code;
    private String msg;
    private List<DataBean> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "TabBean{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }

    public static class DataBean {
        /**
         * id : 1
         * name : 推荐
         */

        private int id;
        private String name;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}
