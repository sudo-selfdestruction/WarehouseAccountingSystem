package by.bsu.rfict.WarehouseAccountingSystem.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ItemDto {
    private String name;
    private String description;
    private String manufacturingCountry;
    private int cost;
    private double weight;

}
