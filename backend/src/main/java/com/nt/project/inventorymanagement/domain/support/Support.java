package com.nt.project.inventorymanagement.domain.support;
import javax.persistence.MappedSuperclass;
/**
 * @author Sejal Jain
 *
 */
@MappedSuperclass
public class Support {
    /**
     * createdAt.
     */
    private long createdAt = System.currentTimeMillis();
    /**
     * updatedAt.
     */
    private long updatedAt = System.currentTimeMillis();
    /**
     * deletedAt.
     */
    private long deletedAt;
    /**
     * isDeleted.
     */
    private boolean isDeleted = false;
    /**
     * @param createdAt : created.
     * @param updatedAt : updated.
     * @param deletedAt : deleted.
     * @param isDeleted : isDeleted.
     */
    public Support(final long createdAt, final long updatedAt, final long deletedAt, final boolean isDeleted) {
        super();
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deletedAt = deletedAt;
        this.isDeleted = isDeleted;
    }
    /**
     * @return boolean.
     */
    public final boolean isDeleted() {
        return isDeleted;
    }
    /**
     * @param isDeleted : isDeleted.
     */
    public final void setDeleted(final boolean isDeleted) {
        this.isDeleted = isDeleted;
    }
    /**
     * @return createdAt.
     */
    public final long getCreatedAt() {
        return createdAt;
    }
    /**
     * @param createdAt : createdAt.
     */
    public final void setCreatedAt(final long createdAt) {
        this.createdAt = createdAt;
    }
    /**
     * @return updatedAt.
     */
    public final  long getUpdatedAt() {
        return updatedAt;
    }
    /**
     * @param updatedAt : updatedAt.
     */
    public final  void setUpdatedAt(final long updatedAt) {
        this.updatedAt = updatedAt;
    }
    /**
     * @return deletedAt.
     */
    public final long getDeletedAt() {
        return deletedAt;
    }
    /**
     * @param deletedAt : deletedAt.
     */
    public final  void setDeletedAt(final long deletedAt) {
        this.deletedAt = deletedAt;
    }
    /**
     * @param createdAt : createdAt.
     * @param updatedAt : updatedAt.
     * @param deletedAt : deletedAt.
     */
    public Support(final long createdAt, final long updatedAt, final long deletedAt) {
        super();
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deletedAt = deletedAt;
    }
    /**
     * super class constructor.
     */
    public Support() {
        super();
    }
}
