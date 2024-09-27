public class MilkDiscount extends BaseDiscount {

    public MilkDiscount(Discount discount) {
        super(discount);
        this.description = "5% Discount on Milk";
    }


    @Override
    protected boolean isApplicable(Product product) {
        return product.name().equalsIgnoreCase("milk");
    }

    @Override
    protected double calculateDiscount(Product product) {
        double discountValue = 0.05; //Adds 5% discount.
        return product.quantity() * product.price() * discountValue;
//        return 0;
    }
}
