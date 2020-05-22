package com.lgy.po;

/**
 * @Description 学生PO
 * @Author LGy
 * @Date 2020/5/16 11:56
 **/
public class Stud {

    private Integer id;
    private String gco;
    private String gna;
    private Integer age;
    private String mail;
    private String pgco;

    public String getGco() {
        return gco;
    }

    public void setGco(String gco) {
        this.gco = gco;
    }

    public String getGna() {
        return gna;
    }

    public void setGna(String gna) {
        this.gna = gna;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPgco() {
        return pgco;
    }

    public void setPgco(String pgco) {
        this.pgco = pgco;
    }
}
