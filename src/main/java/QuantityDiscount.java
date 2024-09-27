public class QuantityDiscount extends BaseDiscount {

    public QuantityDiscount(Discount discount) {
        super(discount);
        this.description = "5% Discount on products with quantity of 5 or more!";
    }



    @Override
    protected boolean isApplicable(Product product) {
        //Added rule of minumum price to not make free prurchases
        return product.quantity() >= 5 && product.price() >= 20;
    }

    @Override
    protected double calculateDiscount(Product product) {
        //10kr / produkt om över 5
        double discountValue = 10;
        return product.quantity() * discountValue;
    }
}
