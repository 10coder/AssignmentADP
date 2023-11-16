package service;

import dto.DiscountApplicationResult;
import model.Discount;
import model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.DiscountRepository;

import java.math.BigDecimal;
import java.util.List;

@Service
public class DiscountService {

    @Autowired
    private DiscountRepository discountRepository;

    public DiscountApplicationResult calculateBestDiscount(List<Item> items) {
        List<Discount> discounts = discountRepository.findAll();
        BigDecimal totalCost = items.stream()
                .map(Item::getCost)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        Discount bestDiscount = null;
        BigDecimal maxSavings = BigDecimal.ZERO;
        for (Discount discount : discounts) {
            BigDecimal savings = calculateSavingsForDiscount(discount, items, totalCost);
            if (savings.compareTo(maxSavings) > 0) {
                maxSavings = savings;
                bestDiscount = discount;
            }
        }

        DiscountApplicationResult result = new DiscountApplicationResult();
        result.setTotalCost(totalCost.subtract(maxSavings));
        result.setDiscountCode(bestDiscount != null ? bestDiscount.getCode() : "NO_DISCOUNT");
        return result;
    }

    private BigDecimal calculateSavingsForDiscount(Discount discount, List<Item> items, BigDecimal totalCost) {
        // Implement the logic to calculate savings based on the discount type
        // This will involve iterating over the items and applying the discount logic
        return BigDecimal.ZERO; // Placeholder for actual calculation
    }
}
