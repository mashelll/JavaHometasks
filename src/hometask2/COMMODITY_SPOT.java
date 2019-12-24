package hometask2;

public class COMMODITY_SPOT implements TradeType {
    int price;

    public COMMODITY_SPOT(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "type={COMMODITY_SPOT}, " +
                "price={" + price +
                '}';
    }
}
