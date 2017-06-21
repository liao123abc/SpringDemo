package com.example.demo.model;

/**
 * Created by thomasliao on 2017/6/21.
 */
public class InfoPa {
    private String sign;
    private String ptime;
    private String vids;

    public void setSign(String sign) {
        this.sign = sign;
    }

    public void setPtime(String ptime) {
        this.ptime = ptime;
    }

    public void setVids(String vids) {
        this.vids = vids;
    }

    @Override
    public String toString() {
        return "InfoPa{" +
                "sign='" + sign + '\'' +
                ", ptime='" + ptime + '\'' +
                ", vids='" + vids + '\'' +
                '}';
    }
}