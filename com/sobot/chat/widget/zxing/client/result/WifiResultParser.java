package com.sobot.chat.widget.zxing.client.result;

import com.sobot.chat.widget.zxing.Result;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/zxing/client/result/WifiResultParser.class */
public final class WifiResultParser extends ResultParser {
    @Override // com.sobot.chat.widget.zxing.client.result.ResultParser
    public WifiParsedResult parse(Result result) {
        String substring;
        String matchSinglePrefixedField;
        String massagedText = getMassagedText(result);
        if (!massagedText.startsWith("WIFI:") || (matchSinglePrefixedField = matchSinglePrefixedField("S:", (substring = massagedText.substring(5)), ';', false)) == null || matchSinglePrefixedField.isEmpty()) {
            return null;
        }
        String matchSinglePrefixedField2 = matchSinglePrefixedField("P:", substring, ';', false);
        String matchSinglePrefixedField3 = matchSinglePrefixedField("T:", substring, ';', false);
        String str = matchSinglePrefixedField3;
        if (matchSinglePrefixedField3 == null) {
            str = "nopass";
        }
        return new WifiParsedResult(str, matchSinglePrefixedField, matchSinglePrefixedField2, Boolean.parseBoolean(matchSinglePrefixedField("H:", substring, ';', false)), matchSinglePrefixedField("I:", substring, ';', false), matchSinglePrefixedField("A:", substring, ';', false), matchSinglePrefixedField("E:", substring, ';', false), matchSinglePrefixedField("H:", substring, ';', false));
    }
}
