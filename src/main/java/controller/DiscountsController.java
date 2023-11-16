package controller;

import dto.DiscountApplicationResult;
import model.Discount;
import model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import repository.DiscountRepository;
import service.DiscountService;

import java.util.List;

@RestController
@RequestMapping("/amazing/discounts")
class DiscountController {

    @Autowired
    private DiscountService discountService;

    @Autowired
    private DiscountRepository discountRepository;

    @PostMapping("/calculate")
    public ResponseEntity<DiscountApplicationResult> calculateDiscount(@RequestBody List<Item> items) {
        return ResponseEntity.ok(discountService.calculateBestDiscount(items));
    }

    @PostMapping
    public ResponseEntity<String> addDiscount(@RequestBody Discount discount) {
        discountRepository.save(discount);
        return ResponseEntity.ok("Discount added");
    }

    @DeleteMapping("/{code}")
    public ResponseEntity<String> removeDiscount(@PathVariable String code) {
        discountRepository.deleteById(code);
        return ResponseEntity.ok("Discount removed");
    }
}

