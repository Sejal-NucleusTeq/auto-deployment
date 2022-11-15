package com.nt.project.inventorymanagement.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.project.inventorymanagement.domain.AssetAssign;
import com.nt.project.inventorymanagement.domain.Item;
import com.nt.project.inventorymanagement.domain.User;
import com.nt.project.inventorymanagement.dto.AssetAssignInDto;
import com.nt.project.inventorymanagement.repository.AssetAssignRepository;
import com.nt.project.inventorymanagement.repository.ItemRepository;
import com.nt.project.inventorymanagement.repository.UserRepository;
import com.nt.project.inventorymanagement.service.ItemService;
/**
 * @author Sejal Jain
 *
 */
@Service
public class ItemServiceImpl implements ItemService {
    /**
     * modelMapper.
     */
    private  ModelMapper modelMapper = new ModelMapper();
        /**
         * userRepository.
         */
        @Autowired private UserRepository userRepository;
        /**
         * assetAssignRepository.
         */
        @Autowired private AssetAssignRepository assetAssignRepository;
        /**
         * itemRepository.
         */
        @Autowired private ItemRepository itemRepository;
        /**
         *@param employeeId : employeeId.
         */
        @Override
        public final Map<String, Object> getAssignedAssets(final String employeeId) {
            Optional<User> user = userRepository.findByEmployeeId(employeeId);
            Map<String, Object> map = new HashMap<>();
            if (user.isPresent()) {
                map.put("employeeData", user.get());
                map.put("assignedAssets", assetAssignRepository.findByEmployeeId(employeeId));
            } else {
                map.put("error", "Employee with this id: " + employeeId + " not exist");
            }
            return map;
        }
        /**
         *@param assetAssignInDto : assetAssignInDto.
         */
        @Override
        public final boolean setItems(final List<AssetAssignInDto> assetAssignInDto) {
            for (AssetAssignInDto asset:assetAssignInDto) {
                try {
                    Item item = itemRepository.findByAssetNo(asset.getAssetNo()).get();
                    item.setassignStatus(true);
                    itemRepository.save(item);
                    asset.setAssetReceivedBy("Office");
                    asset.setAssetTableId(String.valueOf(item.getItemId()));
                    User user = userRepository.findByEmployeeId(asset.getEmployeeId()).get();
                    asset.setEmployeeTableId(user.getuserId());
                    AssetAssign assetAssign = new AssetAssign();
                    assetAssign = modelMapper.map(asset, AssetAssign.class);
                    assetAssignRepository.save(assetAssign);
                } catch (Exception e) {
                    System.out.println(e.getLocalizedMessage());
                    return false;
                }
            }
            return true;
        }
        /**
         *@param id : id.
         */
        @Override
        public final void deleteAssignedItem(final Integer id) {
            AssetAssign asset = assetAssignRepository.findById(id).get();
            Item item = itemRepository.findById(Integer.valueOf(asset.getAssetTableId())).get();
            item.setassignStatus(false);
            itemRepository.save(item);
            assetAssignRepository.deleteById(id);
        }
        /**
         * @return List.
         */
        @Override
        public final List<Item> getAllItems() {
            List<Item> items = itemRepository.findAll();
            for (Item item:items) {
                if (item.isassignStatus()) {
                    item.setEmployeeId(assetAssignRepository.findByAssetNo(item.getAssetNo()).getEmployeeId());
                } else {
                    item.setEmployeeId("-");
                }
            }
            return items;
        }
        /**
         * @return List.
         */
        @Override
        public  final Object getAllUnassignedItems() {
            // TODO Auto-generated method stub
            return itemRepository.findAllByassignStatus(false);
        }
}
