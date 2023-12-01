package com.sobot.chat.widget.zxing.client.result;

import com.sobot.chat.widget.zxing.Result;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/zxing/client/result/URLTOResultParser.class */
public final class URLTOResultParser extends ResultParser {
    @Override // com.sobot.chat.widget.zxing.client.result.ResultParser
    public URIParsedResult parse(Result result) {
        int indexOf;
        String massagedText = getMassagedText(result);
        String str = null;
        if ((massagedText.startsWith("urlto:") || massagedText.startsWith("URLTO:")) && (indexOf = massagedText.indexOf(58, 6)) >= 0) {
            if (indexOf > 6) {
                str = massagedText.substring(6, indexOf);
            }
            return new URIParsedResult(massagedText.substring(indexOf + 1), str);
        }
        return null;
    }
}
