package com.sobot.chat.widget.zxing.client.result;

import com.sobot.chat.widget.zxing.BarcodeFormat;
import com.sobot.chat.widget.zxing.Result;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/zxing/client/result/ISBNResultParser.class */
public final class ISBNResultParser extends ResultParser {
    @Override // com.sobot.chat.widget.zxing.client.result.ResultParser
    public ISBNParsedResult parse(Result result) {
        if (result.getBarcodeFormat() != BarcodeFormat.EAN_13) {
            return null;
        }
        String massagedText = getMassagedText(result);
        if (massagedText.length() != 13) {
            return null;
        }
        if (massagedText.startsWith("978") || massagedText.startsWith("979")) {
            return new ISBNParsedResult(massagedText);
        }
        return null;
    }
}
