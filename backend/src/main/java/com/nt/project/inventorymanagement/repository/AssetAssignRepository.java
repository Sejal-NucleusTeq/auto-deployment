package com.nt.project.inventorymanagement.repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nt.project.inventorymanagement.domain.AssetAssign;
import com.nt.project.inventorymanagement.domain.User;
/**
 * @author Sejal Jain
 *
 */
@Repository
public interface AssetAssignRepository extends JpaRepository<AssetAssign, Integer> {
    /**
     * @param employeeId : employeeId.
     * @return List.
     */
    List<AssetAssign> findByEmployeeId(String employeeId);

    /**
     * @param assetNo : assetNo.
     * @return assetAssign.
     */
    AssetAssign findByAssetNo(String assetNo);

    /**
     * @param itemtableId :itemtableId.
     * @return User.
     */
    Optional<User> findByassetTableId(Integer itemtableId);
}
