public class QuantityDiscount extends BaseDiscount {

    public QuantityDiscount(Discount discount) {
        super(discount);
    }


    @Override
    public String getDescription(Product product)
    {
        return "5% Discount on products with quantity of 5 or more!";
    }

    @Override
    protected boolean isApplicable(Product product) {
        return product.quantity() >= 5;
    }

    @Override
    protected double calculateDiscount(Product product) {
        //10kr / produkt om över 5
        double discountValue = 10;
        return product.quantity() * 10;
    }
}
