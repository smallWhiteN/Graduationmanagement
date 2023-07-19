package com.myh.pojo;

import java.util.ArrayList;
import java.util.List;

public class InformationExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public InformationExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andYearIsNull() {
            addCriterion("year is null");
            return (Criteria) this;
        }

        public Criteria andYearIsNotNull() {
            addCriterion("year is not null");
            return (Criteria) this;
        }

        public Criteria andYearEqualTo(Integer value) {
            addCriterion("year =", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotEqualTo(Integer value) {
            addCriterion("year <>", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearGreaterThan(Integer value) {
            addCriterion("year >", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearGreaterThanOrEqualTo(Integer value) {
            addCriterion("year >=", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearLessThan(Integer value) {
            addCriterion("year <", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearLessThanOrEqualTo(Integer value) {
            addCriterion("year <=", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearIn(List<Integer> values) {
            addCriterion("year in", values, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotIn(List<Integer> values) {
            addCriterion("year not in", values, "year");
            return (Criteria) this;
        }

        public Criteria andYearBetween(Integer value1, Integer value2) {
            addCriterion("year between", value1, value2, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotBetween(Integer value1, Integer value2) {
            addCriterion("year not between", value1, value2, "year");
            return (Criteria) this;
        }

        public Criteria andEmploymentRateIsNull() {
            addCriterion("employmentRate is null");
            return (Criteria) this;
        }

        public Criteria andEmploymentRateIsNotNull() {
            addCriterion("employmentRate is not null");
            return (Criteria) this;
        }

        public Criteria andEmploymentRateEqualTo(Integer value) {
            addCriterion("employmentRate =", value, "employmentRate");
            return (Criteria) this;
        }

        public Criteria andEmploymentRateNotEqualTo(Integer value) {
            addCriterion("employmentRate <>", value, "employmentRate");
            return (Criteria) this;
        }

        public Criteria andEmploymentRateGreaterThan(Integer value) {
            addCriterion("employmentRate >", value, "employmentRate");
            return (Criteria) this;
        }

        public Criteria andEmploymentRateGreaterThanOrEqualTo(Integer value) {
            addCriterion("employmentRate >=", value, "employmentRate");
            return (Criteria) this;
        }

        public Criteria andEmploymentRateLessThan(Integer value) {
            addCriterion("employmentRate <", value, "employmentRate");
            return (Criteria) this;
        }

        public Criteria andEmploymentRateLessThanOrEqualTo(Integer value) {
            addCriterion("employmentRate <=", value, "employmentRate");
            return (Criteria) this;
        }

        public Criteria andEmploymentRateIn(List<Integer> values) {
            addCriterion("employmentRate in", values, "employmentRate");
            return (Criteria) this;
        }

        public Criteria andEmploymentRateNotIn(List<Integer> values) {
            addCriterion("employmentRate not in", values, "employmentRate");
            return (Criteria) this;
        }

        public Criteria andEmploymentRateBetween(Integer value1, Integer value2) {
            addCriterion("employmentRate between", value1, value2, "employmentRate");
            return (Criteria) this;
        }

        public Criteria andEmploymentRateNotBetween(Integer value1, Integer value2) {
            addCriterion("employmentRate not between", value1, value2, "employmentRate");
            return (Criteria) this;
        }

        public Criteria andEnrolmentRateIsNull() {
            addCriterion("enrolmentRate is null");
            return (Criteria) this;
        }

        public Criteria andEnrolmentRateIsNotNull() {
            addCriterion("enrolmentRate is not null");
            return (Criteria) this;
        }

        public Criteria andEnrolmentRateEqualTo(Integer value) {
            addCriterion("enrolmentRate =", value, "enrolmentRate");
            return (Criteria) this;
        }

        public Criteria andEnrolmentRateNotEqualTo(Integer value) {
            addCriterion("enrolmentRate <>", value, "enrolmentRate");
            return (Criteria) this;
        }

        public Criteria andEnrolmentRateGreaterThan(Integer value) {
            addCriterion("enrolmentRate >", value, "enrolmentRate");
            return (Criteria) this;
        }

        public Criteria andEnrolmentRateGreaterThanOrEqualTo(Integer value) {
            addCriterion("enrolmentRate >=", value, "enrolmentRate");
            return (Criteria) this;
        }

        public Criteria andEnrolmentRateLessThan(Integer value) {
            addCriterion("enrolmentRate <", value, "enrolmentRate");
            return (Criteria) this;
        }

        public Criteria andEnrolmentRateLessThanOrEqualTo(Integer value) {
            addCriterion("enrolmentRate <=", value, "enrolmentRate");
            return (Criteria) this;
        }

        public Criteria andEnrolmentRateIn(List<Integer> values) {
            addCriterion("enrolmentRate in", values, "enrolmentRate");
            return (Criteria) this;
        }

        public Criteria andEnrolmentRateNotIn(List<Integer> values) {
            addCriterion("enrolmentRate not in", values, "enrolmentRate");
            return (Criteria) this;
        }

        public Criteria andEnrolmentRateBetween(Integer value1, Integer value2) {
            addCriterion("enrolmentRate between", value1, value2, "enrolmentRate");
            return (Criteria) this;
        }

        public Criteria andEnrolmentRateNotBetween(Integer value1, Integer value2) {
            addCriterion("enrolmentRate not between", value1, value2, "enrolmentRate");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}