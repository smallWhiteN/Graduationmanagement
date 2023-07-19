package com.myh.vo;

/**
 * 多条件查询地实体类
 */
public class QueryVO {
    private String stuno;
    private String stuname;
    private Integer grade;
    private Integer college;
    private Integer major;
    private Integer direction;
    private Integer isInProvince;

    private Integer isDFC;
    private Integer isCrossExam;
    private Integer companyType;

    public Integer getIsDFC() {
        return isDFC;
    }

    public void setIsDFC(Integer isDFC) {
        this.isDFC = isDFC;
    }

    public Integer getIsCrossExam() {
        return isCrossExam;
    }

    public void setIsCrossExam(Integer isCrossExam) {
        this.isCrossExam = isCrossExam;
    }

    public Integer getCompanyType() {
        return companyType;
    }

    public void setCompanyType(Integer companyType) {
        this.companyType = companyType;
    }

    public Integer getIsInProvince() {
        return isInProvince;
    }

    public void setIsInProvince(Integer isInProvince) {
        this.isInProvince = isInProvince;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }


    public String getStuno() {
        return stuno;
    }

    public void setStuno(String stuno) {
        this.stuno = stuno;
    }

    public String getStuname() {
        return stuname;
    }

    public void setStuname(String stuname) {
        this.stuname = stuname;
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
}
