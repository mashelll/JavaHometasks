package hometask2;

public class IR_SWAP implements TradeType {
    int price;

    public IR_SWAP(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "type={IR_SWAP}, " +
                "price={" + price +
                '}';
    }
}