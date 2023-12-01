package com.sobot.chat.widget.zxing.client.result;

import java.util.Map;
import java.util.Objects;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/zxing/client/result/ExpandedProductParsedResult.class */
public final class ExpandedProductParsedResult extends ParsedResult {
    public static final String KILOGRAM = "KG";
    public static final String POUND = "LB";
    private final String bestBeforeDate;
    private final String expirationDate;
    private final String lotNumber;
    private final String packagingDate;
    private final String price;
    private final String priceCurrency;
    private final String priceIncrement;
    private final String productID;
    private final String productionDate;
    private final String rawText;
    private final String sscc;
    private final Map<String, String> uncommonAIs;
    private final String weight;
    private final String weightIncrement;
    private final String weightType;

    public ExpandedProductParsedResult(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, Map<String, String> map) {
        super(ParsedResultType.PRODUCT);
        this.rawText = str;
        this.productID = str2;
        this.sscc = str3;
        this.lotNumber = str4;
        this.productionDate = str5;
        this.packagingDate = str6;
        this.bestBeforeDate = str7;
        this.expirationDate = str8;
        this.weight = str9;
        this.weightType = str10;
        this.weightIncrement = str11;
        this.price = str12;
        this.priceIncrement = str13;
        this.priceCurrency = str14;
        this.uncommonAIs = map;
    }

    public boolean equals(Object obj) {
        if (obj instanceof ExpandedProductParsedResult) {
            ExpandedProductParsedResult expandedProductParsedResult = (ExpandedProductParsedResult) obj;
            boolean z = false;
            if (Objects.equals(this.productID, expandedProductParsedResult.productID)) {
                z = false;
                if (Objects.equals(this.sscc, expandedProductParsedResult.sscc)) {
                    z = false;
                    if (Objects.equals(this.lotNumber, expandedProductParsedResult.lotNumber)) {
                        z = false;
                        if (Objects.equals(this.productionDate, expandedProductParsedResult.productionDate)) {
                            z = false;
                            if (Objects.equals(this.bestBeforeDate, expandedProductParsedResult.bestBeforeDate)) {
                                z = false;
                                if (Objects.equals(this.expirationDate, expandedProductParsedResult.expirationDate)) {
                                    z = false;
                                    if (Objects.equals(this.weight, expandedProductParsedResult.weight)) {
                                        z = false;
                                        if (Objects.equals(this.weightType, expandedProductParsedResult.weightType)) {
                                            z = false;
                                            if (Objects.equals(this.weightIncrement, expandedProductParsedResult.weightIncrement)) {
                                                z = false;
                                                if (Objects.equals(this.price, expandedProductParsedResult.price)) {
                                                    z = false;
                                                    if (Objects.equals(this.priceIncrement, expandedProductParsedResult.priceIncrement)) {
                                                        z = false;
                                                        if (Objects.equals(this.priceCurrency, expandedProductParsedResult.priceCurrency)) {
                                                            z = false;
                                                            if (Objects.equals(this.uncommonAIs, expandedProductParsedResult.uncommonAIs)) {
                                                                z = true;
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return z;
        }
        return false;
    }

    public String getBestBeforeDate() {
        return this.bestBeforeDate;
    }

    @Override // com.sobot.chat.widget.zxing.client.result.ParsedResult
    public String getDisplayResult() {
        return String.valueOf(this.rawText);
    }

    public String getExpirationDate() {
        return this.expirationDate;
    }

    public String getLotNumber() {
        return this.lotNumber;
    }

    public String getPackagingDate() {
        return this.packagingDate;
    }

    public String getPrice() {
        return this.price;
    }

    public String getPriceCurrency() {
        return this.priceCurrency;
    }

    public String getPriceIncrement() {
        return this.priceIncrement;
    }

    public String getProductID() {
        return this.productID;
    }

    public String getProductionDate() {
        return this.productionDate;
    }

    public String getRawText() {
        return this.rawText;
    }

    public String getSscc() {
        return this.sscc;
    }

    public Map<String, String> getUncommonAIs() {
        return this.uncommonAIs;
    }

    public String getWeight() {
        return this.weight;
    }

    public String getWeightIncrement() {
        return this.weightIncrement;
    }

    public String getWeightType() {
        return this.weightType;
    }

    public int hashCode() {
        return (((((((((((Objects.hashCode(this.productID) ^ Objects.hashCode(this.sscc)) ^ Objects.hashCode(this.lotNumber)) ^ Objects.hashCode(this.productionDate)) ^ Objects.hashCode(this.bestBeforeDate)) ^ Objects.hashCode(this.expirationDate)) ^ Objects.hashCode(this.weight)) ^ Objects.hashCode(this.weightType)) ^ Objects.hashCode(this.weightIncrement)) ^ Objects.hashCode(this.price)) ^ Objects.hashCode(this.priceIncrement)) ^ Objects.hashCode(this.priceCurrency)) ^ Objects.hashCode(this.uncommonAIs);
    }
}
