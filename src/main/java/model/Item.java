package model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;


import java.math.BigDecimal;

@Entity
@Data
public class Item {
    @Id
    private Long id;
    private BigDecimal cost;
    private String type;
    // getters and setters
}
