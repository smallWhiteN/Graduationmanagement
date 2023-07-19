package com.myh.vo;

import java.util.HashMap;
import java.util.Map;

public class RateVO {
    private Integer total;

    private Integer totalOfQueryVO;
    private Map<String, Integer> Count;
    private Map<String, Double> Rate;
    private Integer countOfDFC;
    private Integer countOfNDFC;
    private Integer countOfCE;
    private Integer countOfNCE;
    private Map<String, Integer> countByCompanyType;

    public Integer getCountOfDFC() {
        return countOfDFC;
    }

    public void setCountOfDFC(Integer countOfDFC) {
        this.countOfDFC = countOfDFC;
    }

    public Integer getCountOfNDFC() {
        return countOfNDFC;
    }

    public void setCountOfNDFC(Integer countOfNDFC) {
        this.countOfNDFC = countOfNDFC;
    }

    public Integer getCountOfCE() {
        return countOfCE;
    }

    public void setCountOfCE(Integer countOfCE) {
        this.countOfCE = countOfCE;
    }

    public Integer getCountOfNCE() {
        return countOfNCE;
    }

    public void setCountOfNCE(Integer countOfNCE) {
        this.countOfNCE = countOfNCE;
    }

    public Map<String, Integer> getCountByCompanyType() {
        return countByCompanyType;
    }

    public void setCountByCompanyType(Map<String, Integer> countByCompanyType) {
        this.countByCompanyType = countByCompanyType;
    }

    public Integer getTotalOfQueryVO() {
        return totalOfQueryVO;
    }

    public void setTotalOfQueryVO(Integer totalOfQueryVO) {
        this.totalOfQueryVO = totalOfQueryVO;
    }

    @Override
    public String toString() {
        return "RateVO{" +
                "total=" + total +
                ", totalOfQueryVO=" + totalOfQueryVO +
                ", Count=" + Count +
                ", Rate=" + Rate +
                '}';
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Map<String, Integer> getCount() {
        return Count;
    }

    public void setCount(Map<String, Integer> count) {
        Count = count;
    }

    public Map<String, Double> getRate() {
        return Rate;
    }

    public void setRate(Map<String, Double> rate) {
        Rate = rate;
    }
}
