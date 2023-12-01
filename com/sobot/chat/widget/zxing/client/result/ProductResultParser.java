package com.sobot.chat.widget.zxing.client.result;

import com.sobot.chat.widget.zxing.BarcodeFormat;
import com.sobot.chat.widget.zxing.Result;
import com.sobot.chat.widget.zxing.oned.UPCEReader;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/zxing/client/result/ProductResultParser.class */
public final class ProductResultParser extends ResultParser {
    @Override // com.sobot.chat.widget.zxing.client.result.ResultParser
    public ProductParsedResult parse(Result result) {
        BarcodeFormat barcodeFormat = result.getBarcodeFormat();
        if (barcodeFormat == BarcodeFormat.UPC_A || barcodeFormat == BarcodeFormat.UPC_E || barcodeFormat == BarcodeFormat.EAN_8 || barcodeFormat == BarcodeFormat.EAN_13) {
            String massagedText = getMassagedText(result);
            if (isStringOfDigits(massagedText, massagedText.length())) {
                return new ProductParsedResult(massagedText, (barcodeFormat == BarcodeFormat.UPC_E && massagedText.length() == 8) ? UPCEReader.convertUPCEtoUPCA(massagedText) : massagedText);
            }
            return null;
        }
        return null;
    }
}
