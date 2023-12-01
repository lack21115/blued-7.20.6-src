package com.google.zxing.client.result;

import com.google.zxing.Result;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/google/zxing/client/result/VEventResultParser.class */
public final class VEventResultParser extends ResultParser {
    private static String matchSingleVCardPrefixedField(CharSequence charSequence, String str, boolean z) {
        List<String> matchSingleVCardPrefixedField = VCardResultParser.matchSingleVCardPrefixedField(charSequence, str, z, false);
        if (matchSingleVCardPrefixedField == null || matchSingleVCardPrefixedField.isEmpty()) {
            return null;
        }
        return matchSingleVCardPrefixedField.get(0);
    }

    private static String[] matchVCardPrefixedField(CharSequence charSequence, String str, boolean z) {
        List<List<String>> matchVCardPrefixedField = VCardResultParser.matchVCardPrefixedField(charSequence, str, z, false);
        if (matchVCardPrefixedField == null || matchVCardPrefixedField.isEmpty()) {
            return null;
        }
        int size = matchVCardPrefixedField.size();
        String[] strArr = new String[size];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return strArr;
            }
            strArr[i2] = matchVCardPrefixedField.get(i2).get(0);
            i = i2 + 1;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0017, code lost:
        if (r3.startsWith("MAILTO:") != false) goto L7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String stripMailto(java.lang.String r3) {
        /*
            r0 = r3
            r4 = r0
            r0 = r3
            if (r0 == 0) goto L21
            r0 = r3
            java.lang.String r1 = "mailto:"
            boolean r0 = r0.startsWith(r1)
            if (r0 != 0) goto L1a
            r0 = r3
            r4 = r0
            r0 = r3
            java.lang.String r1 = "MAILTO:"
            boolean r0 = r0.startsWith(r1)
            if (r0 == 0) goto L21
        L1a:
            r0 = r3
            r1 = 7
            java.lang.String r0 = r0.substring(r1)
            r4 = r0
        L21:
            r0 = r4
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.client.result.VEventResultParser.stripMailto(java.lang.String):java.lang.String");
    }

    @Override // com.google.zxing.client.result.ResultParser
    public CalendarParsedResult parse(Result result) {
        double parseDouble;
        String massagedText = getMassagedText(result);
        if (massagedText.indexOf("BEGIN:VEVENT") < 0) {
            return null;
        }
        String matchSingleVCardPrefixedField = matchSingleVCardPrefixedField("SUMMARY", massagedText, true);
        String matchSingleVCardPrefixedField2 = matchSingleVCardPrefixedField("DTSTART", massagedText, true);
        if (matchSingleVCardPrefixedField2 == null) {
            return null;
        }
        String matchSingleVCardPrefixedField3 = matchSingleVCardPrefixedField("DTEND", massagedText, true);
        String matchSingleVCardPrefixedField4 = matchSingleVCardPrefixedField("DURATION", massagedText, true);
        String matchSingleVCardPrefixedField5 = matchSingleVCardPrefixedField("LOCATION", massagedText, true);
        String stripMailto = stripMailto(matchSingleVCardPrefixedField("ORGANIZER", massagedText, true));
        String[] matchVCardPrefixedField = matchVCardPrefixedField("ATTENDEE", massagedText, true);
        if (matchVCardPrefixedField != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= matchVCardPrefixedField.length) {
                    break;
                }
                matchVCardPrefixedField[i2] = stripMailto(matchVCardPrefixedField[i2]);
                i = i2 + 1;
            }
        }
        String matchSingleVCardPrefixedField6 = matchSingleVCardPrefixedField("DESCRIPTION", massagedText, true);
        String matchSingleVCardPrefixedField7 = matchSingleVCardPrefixedField("GEO", massagedText, true);
        double d = Double.NaN;
        if (matchSingleVCardPrefixedField7 == null) {
            parseDouble = Double.NaN;
        } else {
            int indexOf = matchSingleVCardPrefixedField7.indexOf(59);
            if (indexOf < 0) {
                return null;
            }
            d = Double.parseDouble(matchSingleVCardPrefixedField7.substring(0, indexOf));
            parseDouble = Double.parseDouble(matchSingleVCardPrefixedField7.substring(indexOf + 1));
        }
        try {
            return new CalendarParsedResult(matchSingleVCardPrefixedField, matchSingleVCardPrefixedField2, matchSingleVCardPrefixedField3, matchSingleVCardPrefixedField4, matchSingleVCardPrefixedField5, stripMailto, matchVCardPrefixedField, matchSingleVCardPrefixedField6, d, parseDouble);
        } catch (NumberFormatException | IllegalArgumentException e) {
            return null;
        }
    }
}
