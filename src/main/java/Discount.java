public interface Discount {
    String getDescription(Product product);
    double apply(Product product);

}
