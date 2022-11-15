package com.nt.project.inventorymanagement.dto;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author Sejal Jain.
 *
 */
public final class UpdateItemInDto {

    /**
     * itemId.
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
     * @return dop.
     */
    public String getDop() {
        return dop;
    }
    /**
     * @param dop : dop.
     */
    public void setDop(final String dop) {
        this.dop = dop;
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
     * @return the workingStatus
     */
    public String getWorkingStatus() {
        return workingStatus;
    }
    /**
     * @param workingStatus the workingStatus to set
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
     * @param assignStatus the assignStatus to set
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
     * @param incidents the incidents to set
     */
    public void setIncidents(final String incidents) {
        this.incidents = incidents;
    }
    @Override
    public String toString() {
        return "UpdateItemInDto [itemId=" + itemId + ", assetName=" + assetName + ", assetNo=" + assetNo
                + ", assetType=" + assetType + ", dop=" + dop + ", warrantyPeriod=" + warrantyPeriod
                + ", assetLocation=" + assetLocation + ", workingStatus=" + workingStatus + ", assignStatus="
                + assignStatus + ", incidents=" + incidents + "]";
    }
    /**
     * super.
     */
    public UpdateItemInDto() {
        super();
        // TODO Auto-generated constructor stub
    }
    /**
     * @param itemId : id;
     * @param assetName : name;
     * @param assetNo : no.
     * @param assetType : type.
     * @param dop : dop.
     * @param warrantyPeriod : period.
     * @param assetLocation : assetLocation.
     * @param workingStatus : working status.
     * @param assignStatus : assign.
     * @param incidents : incidents.
     */
    public UpdateItemInDto(final int itemId, final String assetName, final String assetNo, final  String assetType,
            final String dop, final String warrantyPeriod, final String assetLocation, final String workingStatus,
            final boolean assignStatus, final String incidents) {
        super();
        this.itemId = itemId;
        this.assetName = assetName;
        this.assetNo = assetNo;
        this.assetType = assetType;
        this.dop = dop;
        this.warrantyPeriod = warrantyPeriod;
        this.assetLocation = assetLocation;
        this.workingStatus = workingStatus;
        this.assignStatus = assignStatus;
        this.incidents = incidents;
    }
}
