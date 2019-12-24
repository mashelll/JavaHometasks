package hometask2;

public enum TradeTypeEnum {
    FX_SPOT {
        public TradeType createTrade(String trade, int price) {
            TradeType tradeType = new FX_SPOT(price);
            return tradeType;
        }
    },
    BOND {
        public TradeType createTrade(String trade, int price) {
            TradeType tradeType = new BOND(price);
            return tradeType;
        }
    },
    COMMODITY_SPOT {
        public TradeType createTrade(String trade, int price) {
            TradeType tradeType = new COMMODITY_SPOT(price);
            return tradeType;
        }
    },
    IR_SWAP {
        public TradeType createTrade(String trade, int price) {
            TradeType tradeType = new BOND(price);
            return tradeType;
        }
    };

    public abstract TradeType createTrade(String trade, int price);

}
