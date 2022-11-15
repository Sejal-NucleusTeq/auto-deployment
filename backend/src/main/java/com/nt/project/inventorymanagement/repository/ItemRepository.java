package com.nt.project.inventorymanagement.repository;
import org.springframework.stereotype.Repository;
import com.nt.project.inventorymanagement.domain.Item;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 * @author Sejal Jain
 *
 */
@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {
    /**
     * @return List<Item>.
     */
    List<Item> findAll();
    /**
     * @param assetNo : assetNumber.
     * @return Item.
     */
    Optional<Item> findByAssetNo(String assetNo);
    /**
     * @param assignStatus : assignStatus.
     * @return List.
     */
    List<Item> findAllByassignStatus(boolean assignStatus);
}
