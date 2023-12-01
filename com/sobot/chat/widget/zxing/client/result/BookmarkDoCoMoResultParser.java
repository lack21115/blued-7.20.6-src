package com.sobot.chat.widget.zxing.client.result;

import com.sobot.chat.widget.zxing.Result;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/zxing/client/result/BookmarkDoCoMoResultParser.class */
public final class BookmarkDoCoMoResultParser extends AbstractDoCoMoResultParser {
    @Override // com.sobot.chat.widget.zxing.client.result.ResultParser
    public URIParsedResult parse(Result result) {
        String text = result.getText();
        URIParsedResult uRIParsedResult = null;
        if (text.startsWith("MEBKM:")) {
            String matchSingleDoCoMoPrefixedField = matchSingleDoCoMoPrefixedField("TITLE:", text, true);
            String[] matchDoCoMoPrefixedField = matchDoCoMoPrefixedField("URL:", text, true);
            if (matchDoCoMoPrefixedField == null) {
                return null;
            }
            String str = matchDoCoMoPrefixedField[0];
            if (URIResultParser.isBasicallyValidURI(str)) {
                uRIParsedResult = new URIParsedResult(str, matchSingleDoCoMoPrefixedField);
            }
            return uRIParsedResult;
        }
        return null;
    }
}
