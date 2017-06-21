package com.example.demo.model;

/**
 * Created by thomasliao on 2017/6/21.
 */
public class NewCategory {

    private String cataname;
//    private String catatype;
//    private String cataurl;
    private String parentid;
    private String ptime;
    private String sign;

    @Override
    public String toString() {
        return "NewCategory{" +
                "cataname='" + cataname + '\'' +
                ", parentid='" + parentid + '\'' +
                ", ptime='" + ptime + '\'' +
                ", sign='" + sign + '\'' +
                '}';
    }

    public String getCataname() {
        return cataname;
    }

    public void setCataname(String cataname) {
        this.cataname = cataname;
    }

    public String getParentid() {
        return parentid;
    }

    public void setParentid(String parentid) {
        this.parentid = parentid;
    }

    public String getPtime() {
        return ptime;
    }

    public void setPtime(String ptime) {
        this.ptime = ptime;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }
}
