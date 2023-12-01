package com.sobot.chat.widget.zxing.client.result;

import com.sobot.chat.widget.zxing.Result;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/zxing/client/result/SMSTOMMSTOResultParser.class */
public final class SMSTOMMSTOResultParser extends ResultParser {
    @Override // com.sobot.chat.widget.zxing.client.result.ResultParser
    public SMSParsedResult parse(Result result) {
        String str;
        String massagedText = getMassagedText(result);
        if (massagedText.startsWith("smsto:") || massagedText.startsWith("SMSTO:") || massagedText.startsWith("mmsto:") || massagedText.startsWith("MMSTO:")) {
            String substring = massagedText.substring(6);
            int indexOf = substring.indexOf(58);
            if (indexOf >= 0) {
                str = substring.substring(indexOf + 1);
                substring = substring.substring(0, indexOf);
            } else {
                str = null;
            }
            return new SMSParsedResult(substring, (String) null, (String) null, str);
        }
        return null;
    }
}
