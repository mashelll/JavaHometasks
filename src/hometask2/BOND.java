package hometask2;

public class BOND implements TradeType {
    int price;

    public BOND(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "type={BOND}, " +
                "price={" + price +
                '}';
    }
}
