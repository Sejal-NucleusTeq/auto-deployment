package com.nt.project.inventorymanagement.domain;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.nt.project.inventorymanagement.domain.support.Support;
/**
 * @author Sejal Jain.
 *
 */
@Entity
@Table(name = "asset")
public final class Item extends Support {
    /**
     * itemId.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_iD")
    private Integer itemId;
    /**
     * Asset Name.
     */
    @Column(name = "asset_name")
    private String assetName;
    /**
     * Asset No.
     */
    @Column(name = "asset_no", unique = true)
    private String assetNo;
    /**
     * Asset Type.
     */
    @Column(name = "asset_type")
    private String assetType;
    /**
     * DAte Of Purchase.
     */
    @Column(name = "date_of_purchase")
    private String dateOfPurchase;
    /**
     * Warranty period.
     */
    @Column(name = "warranty_period")
    private String warrantyPeriod;
    /**
     * Asset Location.
     */
    @Column(name = "asset_location")
    private String assetLocation;
    /**
     * Assign Status.
     */
    @Column(name = "assign_status")
    private boolean assignStatus;
    /**
     * Working Status.
     */
    @Column(name = "working_status")
    private String workingStatus;
    /**
     * Incidents If ANY.
     */
    @Column(name = "incidents")
    private String incidents;
     /**
     * @return employeeId.
     */
    @Transient
    private String employeeId;
    /**
     * @return employeeId.
     */
    public String getEmployeeId() {
        return employeeId;
    }
    /**
     * @param employeeId : employeeId.
     */
    public void setEmployeeId(final String employeeId) {
        this.employeeId = employeeId;
    }
    /**
     * @return itemId.
     */
    public Integer getItemId() {
        return itemId;
    }
    /**
     * @param itemId : itemId.
     */
    public void setItemId(final Integer itemId) {
        this.itemId = itemId;
    }
    /**
     * @return assetname.
     */
    public String getAssetName() {
        return assetName;
    }
    /**
     * @param assetName : assetname.
     */
    public void setAssetName(final String assetName) {
        this.assetName = assetName;
    }
    /**
     * @return assetNo.
     */
    public String getAssetNo() {
        return assetNo;
    }
    /**
     * @param assetNo : assetNo.
     */
    public void setAssetNo(final String assetNo) {
        this.assetNo = assetNo;
    }
    /**
     * @return assetType.
     */
    public String getAssetType() {
        return assetType;
    }
    /**
     * @param assetType : assetType.
     */
    public void setAssetType(final String assetType) {
        this.assetType = assetType;
    }
    /**
     * @return dateOfPurchase.
     */
    public String getdateOfPurchase() {
        return dateOfPurchase;
    }
    /**
     * @param dateOfPurchase : dateOfPurchase.
     */
    public void setdateOfPurchase(final String dateOfPurchase) {
        this.dateOfPurchase = dateOfPurchase;
    }
    /**
     * @return warrantyPeriod.
     */
    public String getWarrantyPeriod() {
        return warrantyPeriod;
    }
    /**
     * @param warrantyPeriod : warrantyPeriod.
     */
    public void setWarrantyPeriod(final String warrantyPeriod) {
        this.warrantyPeriod = warrantyPeriod;
    }
    /**
     * @return assetLocation.
     */
    public String getAssetLocation() {
        return assetLocation;
    }
    /**
     * @param assetLocation : assetLocation.
     */
    public void setAssetLocation(final String assetLocation) {
        this.assetLocation = assetLocation;
    }
    /**
     * @return assignStatus.
     */
    public boolean isassignStatus() {
        return assignStatus;
    }
    /**
     * @param assignStatus : assignStatus.
     */
    public void setassignStatus(final boolean assignStatus) {
        this.assignStatus = assignStatus;
    }
    /**
     * @return workingStatus.
     */
    public String getWorkingStatus() {
        return workingStatus;
    }
    /**
     * @param workingStatus : workingStatus.
     */
    public void setWorkingStatus(final String workingStatus) {
        this.workingStatus = workingStatus;
    }
    /**
     * @return incidents.
     */
    public String getIncidents() {
        return incidents;
    }
    /**
     * @param incidents : incidents.
     */
    public void setIncidents(final String incidents) {
        this.incidents = incidents;
    }
    /**
     * toString.
     */
    @Override
    public String toString() {
        return "Item [itemId=" + itemId + ", assetName=" + assetName + ", assetNo=" + assetNo + ", assetType="
                + assetType + ", dateOfPurchase=" + dateOfPurchase + ", warrantyPeriod=" + warrantyPeriod
                + ", assetLocation=" + assetLocation + ", assignStatus=" + assignStatus + ", workingStatus="
                + workingStatus + ", incidents=" + incidents +  "]";
    }
    /**
     * hashcode.
     */
    @Override
    public int hashCode() {
        return Objects.hash(assetLocation, assetName, assetNo, assetType, assignStatus,  dateOfPurchase,
                incidents, itemId, warrantyPeriod, workingStatus);
    }
    /**
     * equals.
     */
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
        Item other = (Item) obj;
        return Objects.equals(assetLocation, other.assetLocation) && Objects.equals(assetName, other.assetName)
                && Objects.equals(assetNo, other.assetNo) && Objects.equals(assetType, other.assetType)
                && assignStatus == other.assignStatus && Objects.equals(dateOfPurchase, other.dateOfPurchase)
                && Objects.equals(incidents, other.incidents) && Objects.equals(itemId, other.itemId)
                && Objects.equals(warrantyPeriod, other.warrantyPeriod) && workingStatus == other.workingStatus;
    }
}
