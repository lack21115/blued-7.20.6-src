package com.sobot.chat.widget.zxing.client.result;

import com.sobot.chat.widget.zxing.Result;
import com.tencent.smtt.sdk.WebView;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/zxing/client/result/TelResultParser.class */
public final class TelResultParser extends ResultParser {
    @Override // com.sobot.chat.widget.zxing.client.result.ResultParser
    public TelParsedResult parse(Result result) {
        String str;
        String massagedText = getMassagedText(result);
        if (massagedText.startsWith(WebView.SCHEME_TEL) || massagedText.startsWith("TEL:")) {
            if (massagedText.startsWith("TEL:")) {
                str = WebView.SCHEME_TEL + massagedText.substring(4);
            } else {
                str = massagedText;
            }
            int indexOf = massagedText.indexOf(63, 4);
            return new TelParsedResult(indexOf < 0 ? massagedText.substring(4) : massagedText.substring(4, indexOf), str, null);
        }
        return null;
    }
}
