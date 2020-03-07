package com.wirelessdatacollector.server.version10.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "parentnode", schema = "wdc", catalog = "")
public class ParentNode {
    private int parentNodeId;
    private String parentNodeName;
    private String parentNodeLocation;
    private int noOfNodes;
    private Integer disabled;
    private String lastModifiedUser;
    private Timestamp lastModifiedDateTime;

    @Id
    @Column(name = "parentnodeid")
    public int getParentNodeId() {
        return parentNodeId;
    }

    public void setParentNodeId(int parentNodeId) {
        this.parentNodeId = parentNodeId;
    }

    @Basic
    @Column(name = "parentnodename")
    public String getParentNodeName() {
        return parentNodeName;
    }

    public void setParentNodeName(String parentNodeName) {
        this.parentNodeName = parentNodeName;
    }

    @Basic
    @Column(name = "parentnodelocation")
    public String getParentNodeLocation() {
        return parentNodeLocation;
    }

    public void setParentNodeLocation(String parentNodeLocation) {
        this.parentNodeLocation = parentNodeLocation;
    }

    @Basic
    @Column(name = "noofnodes")
    public int getNoOfNodes() {
        return noOfNodes;
    }

    public void setNoOfNodes(int noOfNodes) {
        this.noOfNodes = noOfNodes;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ParentNode that = (ParentNode) o;

        if (parentNodeId != that.parentNodeId) return false;
        if (noOfNodes != that.noOfNodes) return false;
        if (parentNodeName != null ? !parentNodeName.equals(that.parentNodeName) : that.parentNodeName != null)
            return false;
        if (parentNodeLocation != null ? !parentNodeLocation.equals(that.parentNodeLocation) : that.parentNodeLocation != null)
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
        int result = parentNodeId;
        result = 31 * result + (parentNodeName != null ? parentNodeName.hashCode() : 0);
        result = 31 * result + (parentNodeLocation != null ? parentNodeLocation.hashCode() : 0);
        result = 31 * result + noOfNodes;
        result = 31 * result + (disabled != null ? disabled.hashCode() : 0);
        result = 31 * result + (lastModifiedUser != null ? lastModifiedUser.hashCode() : 0);
        result = 31 * result + (lastModifiedDateTime != null ? lastModifiedDateTime.hashCode() : 0);
        return result;
    }
}
