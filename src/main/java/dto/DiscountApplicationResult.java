package dto;

import java.math.BigDecimal;

public class DiscountApplicationResult {
    private String discountCode;
    private BigDecimal totalCost;

    public DiscountApplicationResult() {
    }

    public DiscountApplicationResult(String discountCode, BigDecimal totalCost) {
        this.discountCode = discountCode;
        this.totalCost = totalCost;
    }

    public String getDiscountCode() {
        return discountCode;
    }

    public void setDiscountCode(String discountCode) {
        this.discountCode = discountCode;
    }

    public BigDecimal getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(BigDecimal totalCost) {
        this.totalCost = totalCost;
    }

    @Override
    public String toString() {
        return "DiscountApplicationResult{" +
                "discountCode='" + discountCode + '\'' +
                ", totalCost=" + totalCost +
                '}';
    }
}
