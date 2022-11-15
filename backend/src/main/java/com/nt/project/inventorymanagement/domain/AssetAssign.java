package com.nt.project.inventorymanagement.domain;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import com.nt.project.inventorymanagement.domain.support.Support;
/**
 * @author Sejal Jain
 *
 */
@Entity
@Table(name = "assigned_item_details")
public final class AssetAssign extends Support {
    /**
     *
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    /**
     *
     */
    @Column(name = "employee_table_id")
    private int employeeTableId;
    /**
     *
     */
    @Column(name = "employee_id")
    private String employeeId;
    /**
     *
     */
    @Column(name = "asset_table_id")
    private String assetTableId;
    /**
     *
     */
    @Column(name = "asset_no")
    private String assetNo;
    /**
     *
     */
    @Column(name = "asset_name")
    private String assetName;
    /**
     *
     */
    @Column(name = "date_of_assigned")
    private String dateOfAssigned;
    /**
     *
     */
    @Column(name = "asset_received_BY")
    private String assetReceivedBy;
    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }
    /**
     * @param id the id to set
     */
    public void setId(final Integer id) {
        this.id = id;
    }
    /**
     * @return the employeeTableId
     */
    public int getEmployeeTableId() {
        return employeeTableId;
    }
    /**
     * @param employeeTableId the employeeTableId to set
     */
    public void setEmployeeTableId(final int employeeTableId) {
        this.employeeTableId = employeeTableId;
    }
    /**
     * @return the employeeId
     */
    public String getEmployeeId() {
        return employeeId;
    }
    /**
     * @param employeeId the employeeId to set
     */
    public void setEmployeeId(final String employeeId) {
        this.employeeId = employeeId;
    }
    /**
     * @return the assetTableId
     */
    public String getAssetTableId() {
        return assetTableId;
    }
    /**
     * @param assetTableId the assetTableId to set
     */
    public void setAssetTableId(final String assetTableId) {
        this.assetTableId = assetTableId;
    }
    /**
     * @return the assetNo
     */
    public String getAssetNo() {
        return assetNo;
    }
    /**
     * @param assetNo the assetNo to set
     */
    public void setAssetNo(final String assetNo) {
        this.assetNo = assetNo;
    }
    /**
     * @return the assetName
     */
    public String getAssetName() {
        return assetName;
    }
    /**
     * @param assetName the assetName to set
     */
    public void setAssetName(final String assetName) {
        this.assetName = assetName;
    }
    /**
     * @return the dateOfAssigned
     */
    public String getDateOfAssigned() {
        return dateOfAssigned;
    }
    /**
     * @param dateOfAssigned the dateOfAssigned to set
     */
    public void setDateOfAssigned(final String dateOfAssigned) {
        this.dateOfAssigned = dateOfAssigned;
    }
    /**
     * @return the assetReceivedBy
     */
    public String getAssetReceivedBy() {
        return assetReceivedBy;
    }
    /**
     * @param assetReceivedBy the assetReceivedBy to set
     */
    public void setAssetReceivedBy(final String assetReceivedBy) {
        this.assetReceivedBy = assetReceivedBy;
    }
    /**
     * toString.
     */
    @Override
    public String toString() {
        return "AssetAssign [id=" + id + ", employeeTableId=" + employeeTableId + ", employeeId=" + employeeId
                + ", assetTableId=" + assetTableId + ", assetNo=" + assetNo + ", assetName=" + assetName
                + ", dateOfAssigned=" + dateOfAssigned + ", assetReceivedBy=" + assetReceivedBy + "]";
    }
    @Override
    public int hashCode() {
        return Objects.hash(assetName, assetNo, assetReceivedBy, assetTableId, dateOfAssigned, employeeId,
                employeeTableId, id);
    }
    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        AssetAssign other = (AssetAssign) obj;
        return Objects.equals(assetName, other.assetName) && Objects.equals(assetNo, other.assetNo)
                && Objects.equals(assetReceivedBy, other.assetReceivedBy)
                && Objects.equals(assetTableId, other.assetTableId)
                && Objects.equals(dateOfAssigned, other.dateOfAssigned) && Objects.equals(employeeId, other.employeeId)
                && employeeTableId == other.employeeTableId && Objects.equals(id, other.id);
    }
}
