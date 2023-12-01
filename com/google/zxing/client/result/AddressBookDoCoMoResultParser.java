package com.google.zxing.client.result;

import com.google.zxing.Result;

/* loaded from: source-7994992-dex2jar.jar:com/google/zxing/client/result/AddressBookDoCoMoResultParser.class */
public final class AddressBookDoCoMoResultParser extends AbstractDoCoMoResultParser {
    private static String parseName(String str) {
        int indexOf;
        String str2 = str;
        if (str.indexOf(44) >= 0) {
            str2 = str.substring(indexOf + 1) + ' ' + str.substring(0, indexOf);
        }
        return str2;
    }

    @Override // com.google.zxing.client.result.ResultParser
    public AddressBookParsedResult parse(Result result) {
        String[] matchDoCoMoPrefixedField;
        String massagedText = getMassagedText(result);
        if (massagedText.startsWith("MECARD:") && (matchDoCoMoPrefixedField = matchDoCoMoPrefixedField("N:", massagedText, true)) != null) {
            String parseName = parseName(matchDoCoMoPrefixedField[0]);
            String matchSingleDoCoMoPrefixedField = matchSingleDoCoMoPrefixedField("SOUND:", massagedText, true);
            String[] matchDoCoMoPrefixedField2 = matchDoCoMoPrefixedField("TEL:", massagedText, true);
            String[] matchDoCoMoPrefixedField3 = matchDoCoMoPrefixedField("EMAIL:", massagedText, true);
            String matchSingleDoCoMoPrefixedField2 = matchSingleDoCoMoPrefixedField("NOTE:", massagedText, false);
            String[] matchDoCoMoPrefixedField4 = matchDoCoMoPrefixedField("ADR:", massagedText, true);
            String matchSingleDoCoMoPrefixedField3 = matchSingleDoCoMoPrefixedField("BDAY:", massagedText, true);
            if (!isStringOfDigits(matchSingleDoCoMoPrefixedField3, 8)) {
                matchSingleDoCoMoPrefixedField3 = null;
            }
            return new AddressBookParsedResult(maybeWrap(parseName), null, matchSingleDoCoMoPrefixedField, matchDoCoMoPrefixedField2, null, matchDoCoMoPrefixedField3, null, null, matchSingleDoCoMoPrefixedField2, matchDoCoMoPrefixedField4, null, matchSingleDoCoMoPrefixedField("ORG:", massagedText, true), matchSingleDoCoMoPrefixedField3, null, matchDoCoMoPrefixedField("URL:", massagedText, true), null);
        }
        return null;
    }
}
