package com.nt.project.inventorymanagement.dto;
import java.util.Objects;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
/**
 * @author Sejal Jain.
 *
 */
public  final class ItemInDto {
    /**
     * Id.
     */
    private int itemId;
    /**
     * assetName.
     */
    @NotNull
    private String assetName;
    /**
     * Asset No.
     */
    @NotNull
    @NotEmpty(message = "Item Number Can Not Be Empty!")
    private String assetNo;
    /**
     * Asset Type.
     */
    @NotNull
    private String assetType;
    /**
     * DAte Of Purchase.
     */
    @NotNull
    private String dop;
    /**
     * Warranty period.
     */
    @NotNull
    private String warrantyPeriod;
    /**
     * Asset Location.
     */
    @NotNull
    private String assetLocation;
    /**
     * workingStatus.
     */
    private String workingStatus;
    /**
     * assignStatus.
     */
    private boolean assignStatus;
    /**
     * incidents.
     */
    private String incidents;
    /**
     * get assetName.
     * @return assetname.
     */
    public String getAssetName() {
        return assetName;
    }
    /**
     * @return the itemId
     */
    public int getItemId() {
        return itemId;
    }
    /**
     * @param itemId : itemId.
     */
    public void setItemId(final int itemId) {
        this.itemId = itemId;
    }
    /**
     * set assetname.
     * @param assetName : assetname.
     */
    public void setAssetName(final String assetName) {
        this.assetName = assetName;
    }
    /**
     * get assetNo.
     * @return assetNo.
     */
    public String getAssetNo() {
        return assetNo;
    }
    /**
     * set assetNo.
     * @param assetNo : assetNo.
     */
    public void setAssetNo(final String assetNo) {
        this.assetNo = assetNo;
    }
    /**
     * get assetType.
     * @return assetType.
     */
    public String getAssetType() {
        return assetType;
    }
    /**
     * set assetType.
     * @param assetType : assetType.
     */
    public void setAssetType(final String assetType) {
        this.assetType = assetType;
    }
    /**
     * get dop.
     * @return dop.
     */
    public String getDop() {
        return dop;
    }
    /**
     * set dop.
     * @param dop : dop.
     */
    public void setDop(final String dop) {
        this.dop = dop;
    }
    /**
     * get warrantyPeriod.
     * @return warrantyPeriod.
     */
    public String getWarrantyPeriod() {
        return warrantyPeriod;
    }
    /**
     * set warrantyperiod.
     * @param warrantyPeriod : warrantyPeriod.
     */
    public void setWarrantyPeriod(final String warrantyPeriod) {
        this.warrantyPeriod = warrantyPeriod;
    }
    /**
     * get assetLocation.
     * @return assetLocation.
     */
    public String getAssetLocation() {
        return assetLocation;
    }
    /**
     * set assetLocation.
     * @param assetLocation : assetLocation.
     */
    public void setAssetLocation(final String assetLocation) {
        this.assetLocation = assetLocation;
    }
    /**
     * @return the workingStatus
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
     * @return the assignStatus
     */
    public boolean isAssignStatus() {
        return assignStatus;
    }
    /**
     * @param assignStatus : assignStatus.
     */
    public void setAssignStatus(final boolean assignStatus) {
        this.assignStatus = assignStatus;
    }
    /**
     * @return the incidents
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
     * incidents.
     */
    @Override
    public String toString() {
        return "ItemInDto [itemId=" + itemId + ", assetName=" + assetName + ", assetNo=" + assetNo + ", assetType="
                + assetType + ", dop=" + dop + ", warrantyPeriod=" + warrantyPeriod + ", assetLocation=" + assetLocation
                + ", workingStatus=" + workingStatus + ", assignStatus=" + assignStatus + ", incidents=" + incidents
                + "]";
    }
    /**
     * hashCode.
     */
    @Override
    public int hashCode() {
        return Objects.hash(assetLocation, assetName, assetNo, assetType, assignStatus, dop, incidents, itemId,
                warrantyPeriod, workingStatus);
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
        ItemInDto other = (ItemInDto) obj;
        return Objects.equals(assetLocation, other.assetLocation) && Objects.equals(assetName, other.assetName)
                && Objects.equals(assetNo, other.assetNo) && Objects.equals(assetType, other.assetType)
                && assignStatus == other.assignStatus && Objects.equals(dop, other.dop)
                && Objects.equals(incidents, other.incidents) && itemId == other.itemId
                && Objects.equals(warrantyPeriod, other.warrantyPeriod)
                && Objects.equals(workingStatus, other.workingStatus);
    }
}
