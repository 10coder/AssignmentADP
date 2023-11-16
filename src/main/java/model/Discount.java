package model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;



import java.math.BigDecimal;

@Entity
@Data
public class Discount {
    @Id
    private String code;
    private String type;
    private BigDecimal threshold; // cost threshold or count
    private BigDecimal percentage;

}

