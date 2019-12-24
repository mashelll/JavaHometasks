package hometask2;

public class FX_SPOT implements TradeType {
    int price;

    public FX_SPOT(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "type={FX_SPOT}, " +
                "price={" + price +
                '}';
    }
}