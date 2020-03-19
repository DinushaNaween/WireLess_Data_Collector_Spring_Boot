package com.wirelessdatacollector.server.version10.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "roleprivileges", schema = "wdc", catalog = "")
public class RolePrivilege implements Serializable {
    private int privilegeId;
    private String privilegeDescription;
    private Integer disabled;
    private String lastModifiedUser;
    private Timestamp lastModifiedDateTime;

    @Id
    @Column(name = "privilegeid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getPrivilegeId() {
        return privilegeId;
    }

    public void setPrivilegeId(int privilegeId) {
        this.privilegeId = privilegeId;
    }

    @Basic
    @Column(name = "privilegedescription")
    public String getPrivilegeDescription() {
        return privilegeDescription;
    }

    public void setPrivilegeDescription(String privilegeDescription) { this.privilegeDescription = privilegeDescription; }

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

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "roleId")
    private Role roleId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RolePrivilege that = (RolePrivilege) o;

        if (privilegeId != that.privilegeId) return false;
        if (privilegeDescription != null ? !privilegeDescription.equals(that.privilegeDescription) : that.privilegeDescription != null)
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
        int result = privilegeId;
        result = 31 * result + (privilegeDescription != null ? privilegeDescription.hashCode() : 0);
        result = 31 * result + (disabled != null ? disabled.hashCode() : 0);
        result = 31 * result + (lastModifiedUser != null ? lastModifiedUser.hashCode() : 0);
        result = 31 * result + (lastModifiedDateTime != null ? lastModifiedDateTime.hashCode() : 0);
        return result;
    }
}
