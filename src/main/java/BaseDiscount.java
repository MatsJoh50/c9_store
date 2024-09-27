import java.util.ArrayList;
import java.util.List;

public abstract class BaseDiscount implements Discount {
    private final Discount nextDiscount;

    public BaseDiscount(Discount nextDiscount) {
        this.nextDiscount = nextDiscount;
    };

//    public abstract String getDescription();

    protected abstract boolean isApplicable(Product product);
    protected abstract double calculateDiscount(Product product);

    @Override
    public double apply(Product product) {
        double totalDiscountValue = 0.0;

        if(isApplicable(product)) {
            totalDiscountValue = calculateDiscount(product);
        }

        if (nextDiscount != null) {
           totalDiscountValue += nextDiscount.apply(product);
        }
//        System.out.printf(totalDiscountValue + " ");
        return totalDiscountValue;
    };

    @Override
    public String getDescription(Product product) {
        List<String> listOfDescriptions = new ArrayList<>();

        if(isApplicable(product)) {
            listOfDescriptions.add(getDescription(product));
        }
        if (this.nextDiscount != null) {
             nextDiscount.getDescription(product);
        }
        return String.join("\n", listOfDescriptions);
    };


}

