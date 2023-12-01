package com.google.zxing.client.result;

import android.media.TtmlUtils;
import com.google.zxing.Result;
import java.util.Map;
import java.util.regex.Pattern;

/* loaded from: source-7994992-dex2jar.jar:com/google/zxing/client/result/EmailAddressResultParser.class */
public final class EmailAddressResultParser extends ResultParser {
    private static final Pattern COMMA = Pattern.compile(",");

    @Override // com.google.zxing.client.result.ResultParser
    public EmailAddressParsedResult parse(Result result) {
        String str;
        String str2;
        String[] strArr;
        String[] strArr2;
        String[] strArr3;
        String massagedText = getMassagedText(result);
        String[] strArr4 = null;
        if (!massagedText.startsWith("mailto:") && !massagedText.startsWith("MAILTO:")) {
            if (EmailDoCoMoResultParser.isBasicallyValidEmailAddress(massagedText)) {
                return new EmailAddressParsedResult(massagedText);
            }
            return null;
        }
        String substring = massagedText.substring(7);
        int indexOf = substring.indexOf(63);
        String str3 = substring;
        if (indexOf >= 0) {
            str3 = substring.substring(0, indexOf);
        }
        try {
            String urlDecode = urlDecode(str3);
            String[] split = !urlDecode.isEmpty() ? COMMA.split(urlDecode) : null;
            Map<String, String> parseNameValuePairs = parseNameValuePairs(massagedText);
            if (parseNameValuePairs != null) {
                String[] strArr5 = split;
                if (split == null) {
                    String str4 = parseNameValuePairs.get("to");
                    strArr5 = split;
                    if (str4 != null) {
                        strArr5 = COMMA.split(str4);
                    }
                }
                String str5 = parseNameValuePairs.get("cc");
                String[] split2 = str5 != null ? COMMA.split(str5) : null;
                String str6 = parseNameValuePairs.get("bcc");
                if (str6 != null) {
                    strArr4 = COMMA.split(str6);
                }
                str2 = parseNameValuePairs.get("subject");
                str = parseNameValuePairs.get(TtmlUtils.TAG_BODY);
                String[] strArr6 = split2;
                strArr3 = strArr5;
                strArr2 = strArr6;
                strArr = strArr4;
            } else {
                str = null;
                str2 = null;
                strArr = null;
                strArr2 = null;
                strArr3 = split;
            }
            return new EmailAddressParsedResult(strArr3, strArr2, strArr, str2, str);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
}
