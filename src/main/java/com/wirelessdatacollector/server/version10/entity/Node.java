package com.wirelessdatacollector.server.version10.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "node", schema = "wdc", catalog = "")
public class Node {
    private int nodeId;
    private Integer disabled;
    private String lastModifiedUser;
    private Timestamp lastModifiedDateTime;

    @Id
    @Column(name = "nodeid")
    public int getNodeId() {
        return nodeId;
    }

    public void setNodeId(int nodeId) {
        this.nodeId = nodeId;
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

        Node that = (Node) o;

        if (nodeId != that.nodeId) return false;
        if (disabled != null ? !disabled.equals(that.disabled) : that.disabled != null) return false;
        if (lastModifiedUser != null ? !lastModifiedUser.equals(that.lastModifiedUser) : that.lastModifiedUser != null)
            return false;
        if (lastModifiedDateTime != null ? !lastModifiedDateTime.equals(that.lastModifiedDateTime) : that.lastModifiedDateTime != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = nodeId;
        result = 31 * result + (disabled != null ? disabled.hashCode() : 0);
        result = 31 * result + (lastModifiedUser != null ? lastModifiedUser.hashCode() : 0);
        result = 31 * result + (lastModifiedDateTime != null ? lastModifiedDateTime.hashCode() : 0);
        return result;
    }
}
