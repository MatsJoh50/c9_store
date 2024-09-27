import java.time.DayOfWeek;
import java.time.LocalDate;

public class FridayDiscount extends BaseDiscount{

    protected FridayDiscount(Discount nextDiscount) {
        super(nextDiscount);
        this.description = "10% Discount on Friday's!";
    }


    @Override
    protected boolean isApplicable(Product product) {
        return LocalDate.now().getDayOfWeek().equals(DayOfWeek.FRIDAY);
//        return true;
    }

    @Override
    protected double calculateDiscount(Product product) {
        double discountValue = 0.1; //Adds 10% discount
        return product.quantity() * product.price() * discountValue;

    }
}
