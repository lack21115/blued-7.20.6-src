package com.google.zxing.client.result;

import com.google.zxing.Result;
import com.tencent.qcloud.core.util.IOUtils;
import java.util.ArrayList;

/* loaded from: source-7994992-dex2jar.jar:com/google/zxing/client/result/AddressBookAUResultParser.class */
public final class AddressBookAUResultParser extends ResultParser {
    private static String[] matchMultipleValuePrefix(String str, int i, String str2, boolean z) {
        ArrayList arrayList;
        int i2 = 1;
        ArrayList arrayList2 = null;
        while (true) {
            arrayList = arrayList2;
            if (i2 > i) {
                break;
            }
            String matchSinglePrefixedField = matchSinglePrefixedField(str + i2 + ':', str2, '\r', z);
            if (matchSinglePrefixedField == null) {
                break;
            }
            ArrayList arrayList3 = arrayList;
            if (arrayList == null) {
                arrayList3 = new ArrayList(i);
            }
            arrayList3.add(matchSinglePrefixedField);
            i2++;
            arrayList2 = arrayList3;
        }
        if (arrayList == null) {
            return null;
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    @Override // com.google.zxing.client.result.ResultParser
    public AddressBookParsedResult parse(Result result) {
        String massagedText = getMassagedText(result);
        String[] strArr = null;
        if (massagedText.contains("MEMORY") && massagedText.contains(IOUtils.LINE_SEPARATOR_WINDOWS)) {
            String matchSinglePrefixedField = matchSinglePrefixedField("NAME1:", massagedText, '\r', true);
            String matchSinglePrefixedField2 = matchSinglePrefixedField("NAME2:", massagedText, '\r', true);
            String[] matchMultipleValuePrefix = matchMultipleValuePrefix("TEL", 3, massagedText, true);
            String[] matchMultipleValuePrefix2 = matchMultipleValuePrefix("MAIL", 3, massagedText, true);
            String matchSinglePrefixedField3 = matchSinglePrefixedField("MEMORY:", massagedText, '\r', false);
            String matchSinglePrefixedField4 = matchSinglePrefixedField("ADD:", massagedText, '\r', true);
            if (matchSinglePrefixedField4 != null) {
                strArr = new String[]{matchSinglePrefixedField4};
            }
            return new AddressBookParsedResult(maybeWrap(matchSinglePrefixedField), null, matchSinglePrefixedField2, matchMultipleValuePrefix, null, matchMultipleValuePrefix2, null, null, matchSinglePrefixedField3, strArr, null, null, null, null, null, null);
        }
        return null;
    }
}
