package com.fh.taolijie.domain;

public class DictSchoolModel {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dict_school.id
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dict_school.full_name
     *
     * @mbggenerated
     */
    private String fullName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dict_school.short_name
     *
     * @mbggenerated
     */
    private String shortName;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dict_school.id
     *
     * @return the value of dict_school.id
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dict_school.id
     *
     * @param id the value for dict_school.id
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dict_school.full_name
     *
     * @return the value of dict_school.full_name
     *
     * @mbggenerated
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dict_school.full_name
     *
     * @param fullName the value for dict_school.full_name
     *
     * @mbggenerated
     */
    public void setFullName(String fullName) {
        this.fullName = fullName == null ? null : fullName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dict_school.short_name
     *
     * @return the value of dict_school.short_name
     *
     * @mbggenerated
     */
    public String getShortName() {
        return shortName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dict_school.short_name
     *
     * @param shortName the value for dict_school.short_name
     *
     * @mbggenerated
     */
    public void setShortName(String shortName) {
        this.shortName = shortName == null ? null : shortName.trim();
    }
}