public class Main {
    public static void main(String[] args) {


        Product chicken = new Product("chicken", 50, 5);
        Product corn = new Product("corn", 10, 5);
        Product milk = new Product("milk", 100, 1);

        System.out.println(runProduct(chicken));
        System.out.println(runProduct(milk));
        System.out.println(runProduct(corn));


    }

    private static String runProduct(Product product) {
        return "Actual price of " + product.name() + ": " + totalDiscountPrice(product)
                + "(Full price:" + sumOfPrices(product) + ")\n"
                + "Discounts used:" + "\n" + totalDiscountDescription(product)
                + "\n####";
    }

    private static double totalDiscountPrice(Product product) {
        return product.quantity() * product.price() - getDiscountLink().apply(product);
    }

    private static String totalDiscountDescription(Product product) {
        return getDiscountLink().getDescription(product);
    }

    private static Discount getDiscountLink() {
        FridayDiscount fridayDiscount = new FridayDiscount(null);
        MilkDiscount milkDiscount = new MilkDiscount(fridayDiscount);
        return new QuantityDiscount(milkDiscount);
    }

    private static double sumOfPrices(Product product) {
        return product.price() * product.quantity();
    }
}