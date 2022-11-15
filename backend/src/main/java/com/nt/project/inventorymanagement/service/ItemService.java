package com.nt.project.inventorymanagement.service;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import com.nt.project.inventorymanagement.dto.AssetAssignInDto;

/**
 * @author Sejal Jain
 *
 */
public interface ItemService {
    /**
     * @param employeeId : employeeI.
     * @return Map.
     */
    Map<String, Object> getAssignedAssets(String employeeId);

     /**
     * @param assetAssignInDto : assetAssignInDto.
     * @return boolean.
     */
    boolean setItems(@Valid List<AssetAssignInDto> assetAssignInDto);

     /**
     * @param valueOf : valueOf.
     */
    void deleteAssignedItem(Integer valueOf);

     /**
     * @return List.
     */
    Object getAllItems();

     /**
     * @return List.
     */
    Object getAllUnassignedItems();

}
