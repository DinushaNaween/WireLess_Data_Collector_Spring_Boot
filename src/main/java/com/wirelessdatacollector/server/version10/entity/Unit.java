package com.wirelessdatacollector.server.version10.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "unit", schema = "wdc", catalog = "")
public class Unit {
    private int unitId;
    private String unitName;
    private String unitLocation;
    private Integer noOfParentNodes;
    private Integer collectionId;
    private Integer disabled;
    private String lastModifiedUser;
    private Timestamp lastModifiedDateTime;

    @Id
    @Column(name = "unitid")
    public int getUnitId() {
        return unitId;
    }

    public void setUnitId(int unitId) {
        this.unitId = unitId;
    }

    @Basic
    @Column(name = "unitname")
    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    @Basic
    @Column(name = "unitlocation")
    public String getUnitLocation() {
        return unitLocation;
    }

    public void setUnitLocation(String unitLocation) {
        this.unitLocation = unitLocation;
    }

    @Basic
    @Column(name = "noofparentnodes")
    public Integer getNoOfParentNodes() {
        return noOfParentNodes;
    }

    public void setNoOfParentNodes(Integer noOfParentNodes) {
        this.noOfParentNodes = noOfParentNodes;
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
    @Column(name = "lastmodifieduser")
    public String getLastModifiedUser() {
        return lastModifiedUser;
    }

    public void setLastModifiedUser(String lastModifiedUser) {
        this.lastModifiedUser = lastModifiedUser;
    }

    @Basic
    @Column(name = "lastmodifieddatetime")
    public Timestamp getLastModifiedDateTime() {
        return lastModifiedDateTime;
    }

    public void setLastModifiedDateTime(Timestamp lastModifiedDateTime) {
        this.lastModifiedDateTime = lastModifiedDateTime;
    }

    @ManyToOne
    @JoinColumn(name = "collectionId")
    private Collection collection;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Unit that = (Unit) o;

        if (unitId != that.unitId) return false;
        if (unitName != null ? !unitName.equals(that.unitName) : that.unitName != null) return false;
        if (unitLocation != null ? !unitLocation.equals(that.unitLocation) : that.unitLocation != null) return false;
        if (noOfParentNodes != null ? !noOfParentNodes.equals(that.noOfParentNodes) : that.noOfParentNodes != null)
            return false;
        if (disabled != null ? !disabled.equals(that.disabled) : that.disabled != null) return false;
        if (lastModifiedUser != null ? !lastModifiedUser.equals(that.lastModifiedUser) : that.lastModifiedUser != null)
            return false;
        if (lastModifiedDateTime != null ? !lastModifiedDateTime.equals(that.lastModifiedDateTime) : that.lastModifiedDateTime != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = unitId;
        result = 31 * result + (unitName != null ? unitName.hashCode() : 0);
        result = 31 * result + (unitLocation != null ? unitLocation.hashCode() : 0);
        result = 31 * result + (noOfParentNodes != null ? noOfParentNodes.hashCode() : 0);
        result = 31 * result + (disabled != null ? disabled.hashCode() : 0);
        result = 31 * result + (lastModifiedUser != null ? lastModifiedUser.hashCode() : 0);
        result = 31 * result + (lastModifiedDateTime != null ? lastModifiedDateTime.hashCode() : 0);
        return result;
    }

    public Unit(String unitName, String unitLocation, Integer noOfParentNodes, Integer collectionId, Integer disabled, String lastModifiedUser, Timestamp lastModifiedDateTime, Collection collection) {
        this.unitName = unitName;
        this.unitLocation = unitLocation;
        this.noOfParentNodes = noOfParentNodes;
        this.collectionId = collectionId;
        this.disabled = disabled;
        this.lastModifiedUser = lastModifiedUser;
        this.lastModifiedDateTime = lastModifiedDateTime;
        this.collection = collection;
    }
}
