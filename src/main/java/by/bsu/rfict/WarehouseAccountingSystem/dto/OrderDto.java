package by.bsu.rfict.WarehouseAccountingSystem.dto;

import by.bsu.rfict.WarehouseAccountingSystem.entity.Item;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderDto {
    private List<ItemDto> itemDtoList;
    private Double cost;
    private String description;
}
