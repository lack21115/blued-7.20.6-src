package com.google.zxing.client.result;

import com.google.zxing.Result;

/* loaded from: source-7994992-dex2jar.jar:com/google/zxing/client/result/SMTPResultParser.class */
public final class SMTPResultParser extends ResultParser {
    @Override // com.google.zxing.client.result.ResultParser
    public EmailAddressParsedResult parse(Result result) {
        String str;
        String str2;
        String massagedText = getMassagedText(result);
        if (massagedText.startsWith("smtp:") || massagedText.startsWith("SMTP:")) {
            String substring = massagedText.substring(5);
            int indexOf = substring.indexOf(58);
            if (indexOf >= 0) {
                str = substring.substring(indexOf + 1);
                substring = substring.substring(0, indexOf);
                int indexOf2 = str.indexOf(58);
                if (indexOf2 >= 0) {
                    str2 = str.substring(indexOf2 + 1);
                    str = str.substring(0, indexOf2);
                } else {
                    str2 = null;
                }
            } else {
                str = null;
                str2 = null;
            }
            return new EmailAddressParsedResult(new String[]{substring}, null, null, str, str2);
        }
        return null;
    }
}
