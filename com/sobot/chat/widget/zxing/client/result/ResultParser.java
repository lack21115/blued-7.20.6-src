package com.sobot.chat.widget.zxing.client.result;

import com.huawei.hms.framework.common.ContainerUtils;
import com.sobot.chat.widget.zxing.Result;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/zxing/client/result/ResultParser.class */
public abstract class ResultParser {
    private static final String BYTE_ORDER_MARK = "\ufeff";
    private static final ResultParser[] PARSERS = {new BookmarkDoCoMoResultParser(), new AddressBookDoCoMoResultParser(), new EmailDoCoMoResultParser(), new AddressBookAUResultParser(), new VCardResultParser(), new BizcardResultParser(), new VEventResultParser(), new EmailAddressResultParser(), new SMTPResultParser(), new TelResultParser(), new SMSMMSResultParser(), new SMSTOMMSTOResultParser(), new GeoResultParser(), new WifiResultParser(), new URLTOResultParser(), new URIResultParser(), new ISBNResultParser(), new ProductResultParser(), new ExpandedProductResultParser(), new VINResultParser()};
    private static final Pattern DIGITS = Pattern.compile("\\d+");
    private static final Pattern AMPERSAND = Pattern.compile(ContainerUtils.FIELD_DELIMITER);
    private static final Pattern EQUALS = Pattern.compile("=");
    static final String[] EMPTY_STR_ARRAY = new String[0];

    private static void appendKeyValue(CharSequence charSequence, Map<String, String> map) {
        String[] split = EQUALS.split(charSequence, 2);
        if (split.length == 2) {
            try {
                map.put(split[0], urlDecode(split[1]));
            } catch (IllegalArgumentException e) {
            }
        }
    }

    private static int countPrecedingBackslashes(CharSequence charSequence, int i) {
        int i2 = 0;
        for (int i3 = i - 1; i3 >= 0 && charSequence.charAt(i3) == '\\'; i3--) {
            i2++;
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String getMassagedText(Result result) {
        String text = result.getText();
        String str = text;
        if (text.startsWith("\ufeff")) {
            str = text.substring(1);
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean isStringOfDigits(CharSequence charSequence, int i) {
        return charSequence != null && i > 0 && i == charSequence.length() && DIGITS.matcher(charSequence).matches();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean isSubstringOfDigits(CharSequence charSequence, int i, int i2) {
        boolean z = false;
        if (charSequence != null) {
            if (i2 <= 0) {
                return false;
            }
            int i3 = i2 + i;
            z = false;
            if (charSequence.length() >= i3) {
                z = false;
                if (DIGITS.matcher(charSequence.subSequence(i, i3)).matches()) {
                    z = true;
                }
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String[] matchPrefixedField(String str, String str2, char c2, boolean z) {
        int indexOf;
        int length = str2.length();
        ArrayList arrayList = null;
        int i = 0;
        while (i < length && (indexOf = str2.indexOf(str, i)) >= 0) {
            int length2 = indexOf + str.length();
            boolean z2 = true;
            i = length2;
            while (z2) {
                int indexOf2 = str2.indexOf(c2, i);
                if (indexOf2 < 0) {
                    i = str2.length();
                } else if (countPrecedingBackslashes(str2, indexOf2) % 2 != 0) {
                    i = indexOf2 + 1;
                } else {
                    ArrayList arrayList2 = arrayList;
                    if (arrayList == null) {
                        arrayList2 = new ArrayList(3);
                    }
                    String unescapeBackslash = unescapeBackslash(str2.substring(length2, indexOf2));
                    String str3 = unescapeBackslash;
                    if (z) {
                        str3 = unescapeBackslash.trim();
                    }
                    if (!str3.isEmpty()) {
                        arrayList2.add(str3);
                    }
                    i = indexOf2 + 1;
                    arrayList = arrayList2;
                }
                z2 = false;
            }
        }
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        return (String[]) arrayList.toArray(EMPTY_STR_ARRAY);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String matchSinglePrefixedField(String str, String str2, char c2, boolean z) {
        String[] matchPrefixedField = matchPrefixedField(str, str2, c2, z);
        if (matchPrefixedField == null) {
            return null;
        }
        return matchPrefixedField[0];
    }

    protected static void maybeAppend(String str, StringBuilder sb) {
        if (str != null) {
            sb.append('\n');
            sb.append(str);
        }
    }

    protected static void maybeAppend(String[] strArr, StringBuilder sb) {
        if (strArr == null) {
            return;
        }
        int length = strArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            String str = strArr[i2];
            sb.append('\n');
            sb.append(str);
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String[] maybeWrap(String str) {
        if (str == null) {
            return null;
        }
        return new String[]{str};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static int parseHexDigit(char c2) {
        if (c2 < '0' || c2 > '9') {
            char c3 = 'a';
            if (c2 < 'a' || c2 > 'f') {
                c3 = 'A';
                if (c2 < 'A' || c2 > 'F') {
                    return -1;
                }
            }
            return (c2 - c3) + 10;
        }
        return c2 - '0';
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Map<String, String> parseNameValuePairs(String str) {
        int indexOf = str.indexOf(63);
        if (indexOf < 0) {
            return null;
        }
        HashMap hashMap = new HashMap(3);
        String[] split = AMPERSAND.split(str.substring(indexOf + 1));
        int length = split.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return hashMap;
            }
            appendKeyValue(split[i2], hashMap);
            i = i2 + 1;
        }
    }

    public static ParsedResult parseResult(Result result) {
        ResultParser[] resultParserArr = PARSERS;
        int length = resultParserArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return new TextParsedResult(result.getText(), null);
            }
            ParsedResult parse = resultParserArr[i2].parse(result);
            if (parse != null) {
                return parse;
            }
            i = i2 + 1;
        }
    }

    protected static String unescapeBackslash(String str) {
        boolean z;
        int indexOf = str.indexOf(92);
        if (indexOf < 0) {
            return str;
        }
        int length = str.length();
        StringBuilder sb = new StringBuilder(length - 1);
        sb.append(str.toCharArray(), 0, indexOf);
        boolean z2 = false;
        while (indexOf < length) {
            char charAt = str.charAt(indexOf);
            if (z2 || charAt != '\\') {
                sb.append(charAt);
                z = false;
            } else {
                z = true;
            }
            z2 = z;
            indexOf++;
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String urlDecode(String str) {
        try {
            return URLDecoder.decode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new IllegalStateException(e);
        }
    }

    public abstract ParsedResult parse(Result result);
}
