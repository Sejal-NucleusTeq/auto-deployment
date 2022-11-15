package com.nt.project.inventorymanagement.dto;

import java.util.Objects;

/**
 * @author Sejal Jain.
 *
 */
public final class AssetAssignInDto {
    /**
     * id.
     */
    private int id;
    /**
     * employeeId.
     */
    private String employeeId;
    /**
     * assetNo.
     */
    private String assetNo;
    /**
     * assetName.
     */
    private String assetName;
    /**
     * dateOfAssigned.
     */
    private String dateOfAssigned;
    /**
     * assetReceivedBy.
     */
    private String assetReceivedBy;
    /**
     * assetTableId.
     */
    private String assetTableId;
    /**
     * employeeTableId.
     */
    private int employeeTableId;
    /**
     * @return the id.
     */
    public int getId() {
        return id;
    }
    /**
     * @param id : id.
     */
    public void setId(final int id) {
        this.id = id;
    }
    /**
     * @return the employeeId.
     */
    public String getEmployeeId() {
        return employeeId;
    }
    /**
     * @param employeeId : employeeId..
     */
    public void setEmployeeId(final String employeeId) {
        this.employeeId = employeeId;
    }
    /**
     * @return the assetNo.
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
     * @return the assetName
     */
    public String getAssetName() {
        return assetName;
    }
    /**
     * @param assetName : assetName.
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
     * @param dateOfAssigned : dateOfAssigned.
     */
    public void setDateOfAssigned(final String dateOfAssigned) {
        this.dateOfAssigned = dateOfAssigned;
    }
    /**
     * @return assetReceivedBy.
     */
    public String getAssetReceivedBy() {
        return assetReceivedBy;
    }
    /**
     * @param assetReceivedBy : assetReceivedBy.
     */
    public void setAssetReceivedBy(final String assetReceivedBy) {
        this.assetReceivedBy = assetReceivedBy;
    }
    /**
     * @return assetTableId.
     */
    public String getAssetTableId() {
        return assetTableId;
    }
    /**
     * @param assetTableId : assetTableId.
     */
    public void setAssetTableId(final String assetTableId) {
        this.assetTableId = assetTableId;
    }
    /**
     * @return employeeTableId.
     */
    public int getEmployeeTableId() {
        return employeeTableId;
    }
    /**
     * @param employeeTableId :  employeeTableId.
     */
    public void setEmployeeTableId(final int employeeTableId) {
        this.employeeTableId = employeeTableId;
    }
    /**
     * @param id : id.
     * @param employeeId : employeeId.
     * @param assetNo : assetNo.
     * @param assetName : assetName.
     * @param dateOfAssigned : dateOfAssigned.
     * @param assetReceivedBy : assetReceivedBy.
     * @param assetTableId : assetTableId.
     * @param employeeTableId : employeeTableId.
     */
    public AssetAssignInDto(final int id, final String employeeId, final String assetNo, final String assetName, final String dateOfAssigned,
            final String assetReceivedBy, final  String assetTableId, final int employeeTableId) {
        super();
        this.id = id;
        this.employeeId = employeeId;
        this.assetNo = assetNo;
        this.assetName = assetName;
        this.dateOfAssigned = dateOfAssigned;
        this.assetReceivedBy = assetReceivedBy;
        this.assetTableId = assetTableId;
        this.employeeTableId = employeeTableId;
    }
    /**
     * super.
     */
    public AssetAssignInDto() {
        super();
        // TODO Auto-generated constructor stub
    }
    /**
     * hashcode.
     */
    @Override
    public int hashCode() {
        return Objects.hash(assetName, assetNo, assetReceivedBy, assetTableId, dateOfAssigned, employeeId,
                employeeTableId, id);
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
        AssetAssignInDto other = (AssetAssignInDto) obj;
        return Objects.equals(assetName, other.assetName) && Objects.equals(assetNo, other.assetNo)
                && Objects.equals(assetReceivedBy, other.assetReceivedBy)
                && Objects.equals(assetTableId, other.assetTableId)
                && Objects.equals(dateOfAssigned, other.dateOfAssigned) && Objects.equals(employeeId, other.employeeId)
                && employeeTableId == other.employeeTableId && id == other.id;
    }
}
