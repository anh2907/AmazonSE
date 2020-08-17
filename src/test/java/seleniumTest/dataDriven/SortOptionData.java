package seleniumTest.dataDriven;

public enum SortOptionData {
    OptionPriceLowToHigh("Price: Low to High"),
    OptionPriceHighToLow("Price: High to Low"),
    OptionAvgCustomerReview("Avg. Customer Review");
    private String sortOption;
    SortOptionData(String sortOption) {
        this.sortOption = sortOption;
    }
    public String getSortOption(){
        return this.sortOption;
    }
}