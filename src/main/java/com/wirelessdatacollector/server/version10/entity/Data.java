package com.wirelessdatacollector.server.version10.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "data", schema = "wdc", catalog = "")
public class DataEntity {
    private int dataId;
    private String data1;
    private String data2;
    private String data3;
    private String data4;
    private Integer validated;
    private Integer disabled;
    private Timestamp savedDateTime;

    @Id
    @Column(name = "dataId")
    public int getDataId() {
        return dataId;
    }

    public void setDataId(int dataId) {
        this.dataId = dataId;
    }

    @Basic
    @Column(name = "data1")
    public String getData1() {
        return data1;
    }

    public void setData1(String data1) {
        this.data1 = data1;
    }

    @Basic
    @Column(name = "data2")
    public String getData2() {
        return data2;
    }

    public void setData2(String data2) {
        this.data2 = data2;
    }

    @Basic
    @Column(name = "data3")
    public String getData3() {
        return data3;
    }

    public void setData3(String data3) {
        this.data3 = data3;
    }

    @Basic
    @Column(name = "data4")
    public String getData4() {
        return data4;
    }

    public void setData4(String data4) {
        this.data4 = data4;
    }

    @Basic
    @Column(name = "validated")
    public Integer getValidated() {
        return validated;
    }

    public void setValidated(Integer validated) {
        this.validated = validated;
    }

    @Basic
    @Column(name = "disabled")
    public Integer getDisabled() {
        return disabled;
    }

    public void setDisabled(Integer disabled) {
        this.disabled = disabled;
    }

    @Basic
    @Column(name = "savedDateTime")
    public Timestamp getSavedDateTime() {
        return savedDateTime;
    }

    public void setSavedDateTime(Timestamp savedDateTime) {
        this.savedDateTime = savedDateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DataEntity that = (DataEntity) o;

        if (dataId != that.dataId) return false;
        if (data1 != null ? !data1.equals(that.data1) : that.data1 != null) return false;
        if (data2 != null ? !data2.equals(that.data2) : that.data2 != null) return false;
        if (data3 != null ? !data3.equals(that.data3) : that.data3 != null) return false;
        if (data4 != null ? !data4.equals(that.data4) : that.data4 != null) return false;
        if (validated != null ? !validated.equals(that.validated) : that.validated != null) return false;
        if (disabled != null ? !disabled.equals(that.disabled) : that.disabled != null) return false;
        if (savedDateTime != null ? !savedDateTime.equals(that.savedDateTime) : that.savedDateTime != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = dataId;
        result = 31 * result + (data1 != null ? data1.hashCode() : 0);
        result = 31 * result + (data2 != null ? data2.hashCode() : 0);
        result = 31 * result + (data3 != null ? data3.hashCode() : 0);
        result = 31 * result + (data4 != null ? data4.hashCode() : 0);
        result = 31 * result + (validated != null ? validated.hashCode() : 0);
        result = 31 * result + (disabled != null ? disabled.hashCode() : 0);
        result = 31 * result + (savedDateTime != null ? savedDateTime.hashCode() : 0);
        return result;
    }
}
