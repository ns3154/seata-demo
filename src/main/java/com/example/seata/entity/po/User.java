package com.example.seata.entity.po;

public class User {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_user.id
     *
     * @mbg.generated Wed Dec 25 14:59:04 CST 2019
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_user.user_name
     *
     * @mbg.generated Wed Dec 25 14:59:04 CST 2019
     */
    private String userName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_user.sex
     *
     * @mbg.generated Wed Dec 25 14:59:04 CST 2019
     */
    private Integer sex;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_user.balance
     *
     * @mbg.generated Wed Dec 25 14:59:04 CST 2019
     */
    private Double balance;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_user.id
     *
     * @return the value of tb_user.id
     *
     * @mbg.generated Wed Dec 25 14:59:04 CST 2019
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_user.id
     *
     * @param id the value for tb_user.id
     *
     * @mbg.generated Wed Dec 25 14:59:04 CST 2019
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_user.user_name
     *
     * @return the value of tb_user.user_name
     *
     * @mbg.generated Wed Dec 25 14:59:04 CST 2019
     */
    public String getUserName() {
        return userName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_user.user_name
     *
     * @param userName the value for tb_user.user_name
     *
     * @mbg.generated Wed Dec 25 14:59:04 CST 2019
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_user.sex
     *
     * @return the value of tb_user.sex
     *
     * @mbg.generated Wed Dec 25 14:59:04 CST 2019
     */
    public Integer getSex() {
        return sex;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_user.sex
     *
     * @param sex the value for tb_user.sex
     *
     * @mbg.generated Wed Dec 25 14:59:04 CST 2019
     */
    public void setSex(Integer sex) {
        this.sex = sex;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_user.balance
     *
     * @return the value of tb_user.balance
     *
     * @mbg.generated Wed Dec 25 14:59:04 CST 2019
     */
    public Double getBalance() {
        return balance;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_user.balance
     *
     * @param balance the value for tb_user.balance
     *
     * @mbg.generated Wed Dec 25 14:59:04 CST 2019
     */
    public void setBalance(Double balance) {
        this.balance = balance;
    }
}