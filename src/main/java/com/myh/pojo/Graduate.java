package com.myh.pojo;

import java.util.Date;

public class Graduate {
    private String stuno;

    private Integer grade;

    private String password;

    private String stuname;

    private Integer sex;

    private String idNumber;

    private Integer college;

    private Integer major;

    private Integer direction;

    private String place;

    private String url;

    private String note;

    private Date lastSaveTime;

    private Integer isInProvince;

    private Integer isCrossExam;

    private Integer isDFC;

    private Integer companyId;
    private College c;
    private Major m;
    private Direction d;

    @Override
    public String toString() {
        return "Graduate{" +
                "stuno='" + stuno + '\'' +
                ", grade=" + grade +
                ", password='" + password + '\'' +
                ", stuname='" + stuname + '\'' +
                ", sex=" + sex +
                ", idNumber='" + idNumber + '\'' +
                ", college=" + college +
                ", major=" + major +
                ", direction=" + direction +
                ", place='" + place + '\'' +
                ", url='" + url + '\'' +
                ", note='" + note + '\'' +
                ", lastSaveTime=" + lastSaveTime +
                ", isInProvince=" + isInProvince +
                ", isCrossExam=" + isCrossExam +
                ", isDFC=" + isDFC +
                ", companyId=" + companyId +
                ", c=" + c +
                ", m=" + m +
                ", d=" + d +
                '}';
    }

    public Graduate() {
    }

    public Graduate(String stuno, Integer grade, String password, String stuname, Integer sex, String idNumber, Integer college, Integer major, Integer direction, String place, String url, String note, Date lastSaveTime, Integer isInProvince, Integer isCrossExam, Integer isDFC, Integer companyId, College c, Major m, Direction d) {
        this.stuno = stuno;
        this.grade = grade;
        this.password = password;
        this.stuname = stuname;
        this.sex = sex;
        this.idNumber = idNumber;
        this.college = college;
        this.major = major;
        this.direction = direction;
        this.place = place;
        this.url = url;
        this.note = note;
        this.lastSaveTime = lastSaveTime;
        this.isInProvince = isInProvince;
        this.isCrossExam = isCrossExam;
        this.isDFC = isDFC;
        this.companyId = companyId;
        this.c = c;
        this.m = m;
        this.d = d;
    }

    public College getC() {
        return c;
    }

    public void setC(College c) {
        this.c = c;
    }

    public Major getM() {
        return m;
    }

    public void setM(Major m) {
        this.m = m;
    }

    public Direction getD() {
        return d;
    }

    public void setD(Direction d) {
        this.d = d;
    }

    public String getStuno() {
        return stuno;
    }

    public void setStuno(String stuno) {
        this.stuno = stuno == null ? null : stuno.trim();
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getStuname() {
        return stuname;
    }

    public void setStuname(String stuname) {
        this.stuname = stuname == null ? null : stuname.trim();
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber == null ? null : idNumber.trim();
    }

    public Integer getCollege() {
        return college;
    }

    public void setCollege(Integer college) {
        this.college = college;
    }

    public Integer getMajor() {
        return major;
    }

    public void setMajor(Integer major) {
        this.major = major;
    }

    public Integer getDirection() {
        return direction;
    }

    public void setDirection(Integer direction) {
        this.direction = direction;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place == null ? null : place.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    public Date getLastSaveTime() {
        return lastSaveTime;
    }

    public void setLastSaveTime(Date lastSaveTime) {
        this.lastSaveTime = lastSaveTime;
    }

    public Integer getIsInProvince() {
        return isInProvince;
    }

    public void setIsInProvince(Integer isInProvince) {
        this.isInProvince = isInProvince;
    }

    public Integer getIsCrossExam() {
        return isCrossExam;
    }

    public void setIsCrossExam(Integer isCrossExam) {
        this.isCrossExam = isCrossExam;
    }

    public Integer getIsDFC() {
        return isDFC;
    }

    public void setIsDFC(Integer isDFC) {
        this.isDFC = isDFC;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }
}