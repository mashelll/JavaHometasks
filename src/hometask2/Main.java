package hometask2;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    static ArrayList<String> text = new ArrayList<String>();

    public static void main(String[] args) {
        HashMap tradeInfo = new HashMap();
        text = read();
        tradeInfo = parce(text);
        System.out.println(getTradeSwitch(tradeInfo));
        System.out.println(getTradeEnum(tradeInfo));
    }

    public static ArrayList<String> read() {
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.next();
        try (FileReader tradeFile = new FileReader(fileName)) {
            Scanner fileScanner = new Scanner(tradeFile).useDelimiter("\\}|\\{");
            while (fileScanner.hasNext()) {
                text.add(fileScanner.next().replaceAll("\\s+", ""));
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return text;
    }

    public static HashMap parce(ArrayList<String> text) {
        HashMap tradeInfo = new HashMap();
        String type = null;
        int price = 0;

        for (int i = 0; i < text.size(); i++) {
            if (text.get(i).equals("type=")) {
                i++;
                type = text.get(i);
            }
            if (text.get(i).equals("price=")) {
                i++;
                price = Integer.parseInt(text.get(i));
            }
        }
        tradeInfo.put("type", type);
        tradeInfo.put("price", price);

        return tradeInfo;
    }

    public static TradeType getTradeSwitch(HashMap tradeInfo) {
        String type = (String) tradeInfo.get("type");
        int price = (int) tradeInfo.get("price");
        TradeType trade = null;
        switch (type) {
            case "BOND":
                trade = new BOND(price);
                break;
            case "COMMODITY_SPOT":
                trade = new COMMODITY_SPOT(price);
                break;
            case "FX_SPOT":
                trade = new FX_SPOT(price);
                break;
            case "IR_SWAP":
                trade = new IR_SWAP(price);
                break;
        }
        return trade;
    }

    public static TradeType getTradeEnum(HashMap tradeInfo) {
        String type = (String) tradeInfo.get("type");
        int price = (int) tradeInfo.get("price");
        return TradeTypeEnum.valueOf(type).createTrade(type, price);
    }

}
