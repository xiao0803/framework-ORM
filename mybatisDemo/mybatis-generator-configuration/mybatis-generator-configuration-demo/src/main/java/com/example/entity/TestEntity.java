package com.example.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "test")
public class TestEntity {
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    private String name;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    private Long number;

    private String lifecycle;

    private Double dekes;

    private String description;

    public TestEntity(Integer id, String name, Date createTime, Date updateTime, Long number, String lifecycle, Double dekes, String description) {
        this.id = id;
        this.name = name;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.number = number;
        this.lifecycle = lifecycle;
        this.dekes = dekes;
        this.description = description;
    }

    public TestEntity() {
        super();
    }

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return update_time
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * @return number
     */
    public Long getNumber() {
        return number;
    }

    /**
     * @param number
     */
    public void setNumber(Long number) {
        this.number = number;
    }

    /**
     * @return lifecycle
     */
    public String getLifecycle() {
        return lifecycle;
    }

    /**
     * @param lifecycle
     */
    public void setLifecycle(String lifecycle) {
        this.lifecycle = lifecycle == null ? null : lifecycle.trim();
    }

    /**
     * @return dekes
     */
    public Double getDekes() {
        return dekes;
    }

    /**
     * @param dekes
     */
    public void setDekes(Double dekes) {
        this.dekes = dekes;
    }

    /**
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}