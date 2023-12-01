package com.sobot.chat.widget.zxing.client.result;

import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.sobot.chat.widget.zxing.BarcodeFormat;
import com.sobot.chat.widget.zxing.Result;
import java.util.HashMap;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/zxing/client/result/ExpandedProductResultParser.class */
public final class ExpandedProductResultParser extends ResultParser {
    private static String findAIvalue(int i, String str) {
        char charAt;
        if (str.charAt(i) != '(') {
            return null;
        }
        String substring = str.substring(i + 1);
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < substring.length() && (charAt = substring.charAt(i3)) != ')') {
                if (charAt < '0' || charAt > '9') {
                    return null;
                }
                sb.append(charAt);
                i2 = i3 + 1;
            }
            return sb.toString();
        }
    }

    private static String findValue(int i, String str) {
        StringBuilder sb = new StringBuilder();
        String substring = str.substring(i);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= substring.length()) {
                break;
            }
            char charAt = substring.charAt(i3);
            if (charAt != '(') {
                sb.append(charAt);
            } else if (findAIvalue(i3, substring) != null) {
                break;
            } else {
                sb.append('(');
            }
            i2 = i3 + 1;
        }
        return sb.toString();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.sobot.chat.widget.zxing.client.result.ResultParser
    public ExpandedProductParsedResult parse(Result result) {
        boolean z;
        String str;
        String str2;
        String str3;
        String substring;
        if (result.getBarcodeFormat() != BarcodeFormat.RSS_EXPANDED) {
            return null;
        }
        String massagedText = getMassagedText(result);
        HashMap hashMap = new HashMap();
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        String str8 = null;
        String str9 = null;
        String str10 = null;
        String str11 = null;
        String str12 = null;
        String str13 = null;
        int i = 0;
        String str14 = null;
        String str15 = null;
        String str16 = null;
        while (i < massagedText.length()) {
            String findAIvalue = findAIvalue(i, massagedText);
            if (findAIvalue == null) {
                return null;
            }
            int length = i + findAIvalue.length() + 2;
            String findValue = findValue(length, massagedText);
            int length2 = findValue.length();
            int hashCode = findAIvalue.hashCode();
            if (hashCode == 1536) {
                if (findAIvalue.equals("00")) {
                    z = false;
                }
                z = true;
            } else if (hashCode == 1537) {
                if (findAIvalue.equals(HiAnalyticsConstant.KeyAndValue.NUMBER_01)) {
                    z = true;
                }
                z = true;
            } else if (hashCode == 1567) {
                if (findAIvalue.equals("10")) {
                    z = true;
                }
                z = true;
            } else if (hashCode == 1568) {
                if (findAIvalue.equals("11")) {
                    z = true;
                }
                z = true;
            } else if (hashCode == 1570) {
                if (findAIvalue.equals("13")) {
                    z = true;
                }
                z = true;
            } else if (hashCode == 1572) {
                if (findAIvalue.equals("15")) {
                    z = true;
                }
                z = true;
            } else if (hashCode != 1574) {
                switch (hashCode) {
                    case 1567966:
                        if (findAIvalue.equals("3100")) {
                            z = true;
                            break;
                        }
                        z = true;
                        break;
                    case 1567967:
                        if (findAIvalue.equals("3101")) {
                            z = true;
                            break;
                        }
                        z = true;
                        break;
                    case 1567968:
                        if (findAIvalue.equals("3102")) {
                            z = true;
                            break;
                        }
                        z = true;
                        break;
                    case 1567969:
                        if (findAIvalue.equals("3103")) {
                            z = true;
                            break;
                        }
                        z = true;
                        break;
                    case 1567970:
                        if (findAIvalue.equals("3104")) {
                            z = true;
                            break;
                        }
                        z = true;
                        break;
                    case 1567971:
                        if (findAIvalue.equals("3105")) {
                            z = true;
                            break;
                        }
                        z = true;
                        break;
                    case 1567972:
                        if (findAIvalue.equals("3106")) {
                            z = true;
                            break;
                        }
                        z = true;
                        break;
                    case 1567973:
                        if (findAIvalue.equals("3107")) {
                            z = true;
                            break;
                        }
                        z = true;
                        break;
                    case 1567974:
                        if (findAIvalue.equals("3108")) {
                            z = true;
                            break;
                        }
                        z = true;
                        break;
                    case 1567975:
                        if (findAIvalue.equals("3109")) {
                            z = true;
                            break;
                        }
                        z = true;
                        break;
                    default:
                        switch (hashCode) {
                            case 1568927:
                                if (findAIvalue.equals("3200")) {
                                    z = true;
                                    break;
                                }
                                z = true;
                                break;
                            case 1568928:
                                if (findAIvalue.equals("3201")) {
                                    z = true;
                                    break;
                                }
                                z = true;
                                break;
                            case 1568929:
                                if (findAIvalue.equals("3202")) {
                                    z = true;
                                    break;
                                }
                                z = true;
                                break;
                            case 1568930:
                                if (findAIvalue.equals("3203")) {
                                    z = true;
                                    break;
                                }
                                z = true;
                                break;
                            case 1568931:
                                if (findAIvalue.equals("3204")) {
                                    z = true;
                                    break;
                                }
                                z = true;
                                break;
                            case 1568932:
                                if (findAIvalue.equals("3205")) {
                                    z = true;
                                    break;
                                }
                                z = true;
                                break;
                            case 1568933:
                                if (findAIvalue.equals("3206")) {
                                    z = true;
                                    break;
                                }
                                z = true;
                                break;
                            case 1568934:
                                if (findAIvalue.equals("3207")) {
                                    z = true;
                                    break;
                                }
                                z = true;
                                break;
                            case 1568935:
                                if (findAIvalue.equals("3208")) {
                                    z = true;
                                    break;
                                }
                                z = true;
                                break;
                            case 1568936:
                                if (findAIvalue.equals("3209")) {
                                    z = true;
                                    break;
                                }
                                z = true;
                                break;
                            default:
                                switch (hashCode) {
                                    case 1575716:
                                        if (findAIvalue.equals("3920")) {
                                            z = true;
                                            break;
                                        }
                                        z = true;
                                        break;
                                    case 1575717:
                                        if (findAIvalue.equals("3921")) {
                                            z = true;
                                            break;
                                        }
                                        z = true;
                                        break;
                                    case 1575718:
                                        if (findAIvalue.equals("3922")) {
                                            z = true;
                                            break;
                                        }
                                        z = true;
                                        break;
                                    case 1575719:
                                        if (findAIvalue.equals("3923")) {
                                            z = true;
                                            break;
                                        }
                                        z = true;
                                        break;
                                    default:
                                        switch (hashCode) {
                                            case 1575747:
                                                if (findAIvalue.equals("3930")) {
                                                    z = true;
                                                    break;
                                                }
                                                z = true;
                                                break;
                                            case 1575748:
                                                if (findAIvalue.equals("3931")) {
                                                    z = true;
                                                    break;
                                                }
                                                z = true;
                                                break;
                                            case 1575749:
                                                if (findAIvalue.equals("3932")) {
                                                    z = true;
                                                    break;
                                                }
                                                z = true;
                                                break;
                                            case 1575750:
                                                if (findAIvalue.equals("3933")) {
                                                    z = true;
                                                    break;
                                                }
                                                z = true;
                                                break;
                                            default:
                                                z = true;
                                                break;
                                        }
                                }
                        }
                }
            } else {
                if (findAIvalue.equals("17")) {
                    z = true;
                }
                z = true;
            }
            switch (z) {
                case false:
                    str = str9;
                    str4 = findValue;
                    findValue = str11;
                    substring = str12;
                    str3 = str;
                    str12 = substring;
                    str2 = str14;
                    str9 = str3;
                    i = length + length2;
                    str14 = str2;
                    str11 = findValue;
                case true:
                    str16 = findValue;
                    str = str9;
                    findValue = str11;
                    substring = str12;
                    str3 = str;
                    str12 = substring;
                    str2 = str14;
                    str9 = str3;
                    i = length + length2;
                    str14 = str2;
                    str11 = findValue;
                case true:
                    str5 = findValue;
                    str = str9;
                    findValue = str11;
                    substring = str12;
                    str3 = str;
                    str12 = substring;
                    str2 = str14;
                    str9 = str3;
                    i = length + length2;
                    str14 = str2;
                    str11 = findValue;
                case true:
                    str6 = findValue;
                    str = str9;
                    findValue = str11;
                    substring = str12;
                    str3 = str;
                    str12 = substring;
                    str2 = str14;
                    str9 = str3;
                    i = length + length2;
                    str14 = str2;
                    str11 = findValue;
                case true:
                    str7 = findValue;
                    str = str9;
                    findValue = str11;
                    substring = str12;
                    str3 = str;
                    str12 = substring;
                    str2 = str14;
                    str9 = str3;
                    i = length + length2;
                    str14 = str2;
                    str11 = findValue;
                case true:
                    str8 = findValue;
                    str = str9;
                    findValue = str11;
                    substring = str12;
                    str3 = str;
                    str12 = substring;
                    str2 = str14;
                    str9 = str3;
                    i = length + length2;
                    str14 = str2;
                    str11 = findValue;
                case true:
                    str = findValue;
                    findValue = str11;
                    substring = str12;
                    str3 = str;
                    str12 = substring;
                    str2 = str14;
                    str9 = str3;
                    i = length + length2;
                    str14 = str2;
                    str11 = findValue;
                case true:
                case true:
                case true:
                case true:
                case true:
                case true:
                case true:
                case true:
                case true:
                case true:
                    str10 = findAIvalue.substring(3);
                    str2 = "KG";
                    str15 = findValue;
                    findValue = str11;
                    i = length + length2;
                    str14 = str2;
                    str11 = findValue;
                case true:
                case true:
                case true:
                case true:
                case true:
                case true:
                case true:
                case true:
                case true:
                case true:
                    str10 = findAIvalue.substring(3);
                    str2 = "LB";
                    str15 = findValue;
                    findValue = str11;
                    i = length + length2;
                    str14 = str2;
                    str11 = findValue;
                case true:
                case true:
                case true:
                case true:
                    str3 = str9;
                    substring = findAIvalue.substring(3);
                    str12 = substring;
                    str2 = str14;
                    str9 = str3;
                    i = length + length2;
                    str14 = str2;
                    str11 = findValue;
                case true:
                case true:
                case true:
                case true:
                    if (findValue.length() < 4) {
                        return null;
                    }
                    String substring2 = findValue.substring(3);
                    str13 = findValue.substring(0, 3);
                    str3 = str9;
                    findValue = substring2;
                    substring = findAIvalue.substring(3);
                    str12 = substring;
                    str2 = str14;
                    str9 = str3;
                    i = length + length2;
                    str14 = str2;
                    str11 = findValue;
                default:
                    hashMap.put(findAIvalue, findValue);
                    str = str9;
                    findValue = str11;
                    substring = str12;
                    str3 = str;
                    str12 = substring;
                    str2 = str14;
                    str9 = str3;
                    i = length + length2;
                    str14 = str2;
                    str11 = findValue;
            }
        }
        return new ExpandedProductParsedResult(massagedText, str16, str4, str5, str6, str7, str8, str9, str15, str14, str10, str11, str12, str13, hashMap);
    }
}
