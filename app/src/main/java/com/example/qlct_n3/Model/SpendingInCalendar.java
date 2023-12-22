package com.example.qlct_n3.Model;

public class SpendingInCalendar {
    private Integer avtSpending;
    private Integer idDirectory;
    private Integer idGiaoDich;
    private Long money;

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    private String note;
    private Boolean check;

    public SpendingInCalendar(Integer avtSpending, Integer idDirectory, Integer idGiaoDich, Long money,String note, Boolean check) {
        this.avtSpending = avtSpending;
        this.idDirectory = idDirectory;
        this.idGiaoDich = idGiaoDich;
        this.money = money;
        this.note = note;
        this.check = check;
    }

    public Integer getAvtSpending() {
        return avtSpending;
    }

    public void setAvtSpending(Integer avtSpending) {
        this.avtSpending = avtSpending;
    }

    public Integer getIdDirectory() {
        return idDirectory;
    }

    public void setIdDirectory(Integer idDirectory) {
        this.idDirectory = idDirectory;
    }

    public Integer getIdGiaoDich() {
        return idGiaoDich;
    }

    public void setIdGiaoDich(Integer idGiaoDich) {
        this.idGiaoDich = idGiaoDich;
    }

    public Long getMoney() {
        return money;
    }

    public void setMoney(Long money) {
        this.money = money;
    }

    public Boolean getCheck() {
        return check;
    }

    public void setCheck(Boolean check) {
        this.check = check;
    }
}


