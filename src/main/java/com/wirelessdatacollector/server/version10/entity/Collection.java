package com.wirelessdatacollector.server.version10.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "collection", schema = "wdc", catalog = "")
public class Collection {
    private int collectionId;
    private String collectionName;
    private String collectionLocation;
    private Integer noOfUnits;
    private Integer disabled;
    private String lastModifiedUser;
    private Timestamp lastModifiedDateTime;

    @Id
    @Column(name = "collectionid")
    public int getCollectionId() {
        return collectionId;
    }

    public void setCollectionId(int collectionId) {
        this.collectionId = collectionId;
    }

    @Basic
    @Column(name = "collectionname")
    public String getCollectionName() {
        return collectionName;
    }

    public void setCollectionName(String collectionName) {
        this.collectionName = collectionName;
    }

    @Basic
    @Column(name = "collectionlocation")
    public String getCollectionLocation() {
        return collectionLocation;
    }

    public void setCollectionLocation(String collectionLocation) {
        this.collectionLocation = collectionLocation;
    }

    @Basic
    @Column(name = "noofunits")
    public Integer getNoOfUnits() {
        return noOfUnits;
    }

    public void setNoOfUnits(Integer noOfUnits) {
        this.noOfUnits = noOfUnits;
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

    @OneToMany(mappedBy = "collection", cascade = CascadeType.ALL)
    Set unit = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Collection that = (Collection) o;

        if (collectionId != that.collectionId) return false;
        if (collectionName != null ? !collectionName.equals(that.collectionName) : that.collectionName != null)
            return false;
        if (collectionLocation != null ? !collectionLocation.equals(that.collectionLocation) : that.collectionLocation != null)
            return false;
        if (noOfUnits != null ? !noOfUnits.equals(that.noOfUnits) : that.noOfUnits != null) return false;
        if (disabled != null ? !disabled.equals(that.disabled) : that.disabled != null) return false;
        if (lastModifiedUser != null ? !lastModifiedUser.equals(that.lastModifiedUser) : that.lastModifiedUser != null)
            return false;
        if (lastModifiedDateTime != null ? !lastModifiedDateTime.equals(that.lastModifiedDateTime) : that.lastModifiedDateTime != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = collectionId;
        result = 31 * result + (collectionName != null ? collectionName.hashCode() : 0);
        result = 31 * result + (collectionLocation != null ? collectionLocation.hashCode() : 0);
        result = 31 * result + (noOfUnits != null ? noOfUnits.hashCode() : 0);
        result = 31 * result + (disabled != null ? disabled.hashCode() : 0);
        result = 31 * result + (lastModifiedUser != null ? lastModifiedUser.hashCode() : 0);
        result = 31 * result + (lastModifiedDateTime != null ? lastModifiedDateTime.hashCode() : 0);
        return result;
    }
}
