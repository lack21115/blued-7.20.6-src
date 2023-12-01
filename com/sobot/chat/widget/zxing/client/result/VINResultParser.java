package com.sobot.chat.widget.zxing.client.result;

import com.opos.acs.st.STManager;
import com.sobot.chat.widget.zxing.BarcodeFormat;
import com.sobot.chat.widget.zxing.Result;
import java.util.regex.Pattern;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/zxing/client/result/VINResultParser.class */
public final class VINResultParser extends ResultParser {
    private static final Pattern IOQ = Pattern.compile("[IOQ]");
    private static final Pattern AZ09 = Pattern.compile("[A-Z0-9]{17}");

    private static char checkChar(int i) {
        if (i < 10) {
            return (char) (i + 48);
        }
        if (i == 10) {
            return 'X';
        }
        throw new IllegalArgumentException();
    }

    private static boolean checkChecksum(CharSequence charSequence) {
        boolean z = false;
        int i = 0;
        int i2 = 0;
        while (i < charSequence.length()) {
            int i3 = i + 1;
            i2 += vinPositionWeight(i3) * vinCharValue(charSequence.charAt(i));
            i = i3;
        }
        if (charSequence.charAt(8) == checkChar(i2 % 11)) {
            z = true;
        }
        return z;
    }

    private static String countryCode(CharSequence charSequence) {
        char charAt = charSequence.charAt(0);
        char charAt2 = charSequence.charAt(1);
        if (charAt == '9') {
            if (charAt2 < 'A' || charAt2 > 'E') {
                if (charAt2 < '3' || charAt2 > '9') {
                    return null;
                }
                return "BR";
            }
            return "BR";
        } else if (charAt == 'S') {
            if (charAt2 < 'A' || charAt2 > 'M') {
                if (charAt2 < 'N' || charAt2 > 'T') {
                    return null;
                }
                return "DE";
            }
            return "UK";
        } else if (charAt == 'Z') {
            if (charAt2 < 'A' || charAt2 > 'R') {
                return null;
            }
            return "IT";
        } else {
            switch (charAt) {
                case '1':
                case '4':
                case '5':
                    return "US";
                case '2':
                    return "CA";
                case '3':
                    if (charAt2 < 'A' || charAt2 > 'W') {
                        return null;
                    }
                    return "MX";
                default:
                    switch (charAt) {
                        case 'J':
                            if (charAt2 < 'A' || charAt2 > 'T') {
                                return null;
                            }
                            return "JP";
                        case 'K':
                            if (charAt2 < 'L' || charAt2 > 'R') {
                                return null;
                            }
                            return "KO";
                        case 'L':
                            return "CN";
                        case 'M':
                            if (charAt2 < 'A' || charAt2 > 'E') {
                                return null;
                            }
                            return STManager.REGION_OF_IN;
                        default:
                            switch (charAt) {
                                case 'V':
                                    if (charAt2 < 'F' || charAt2 > 'R') {
                                        if (charAt2 < 'S' || charAt2 > 'W') {
                                            return null;
                                        }
                                        return "ES";
                                    }
                                    return "FR";
                                case 'W':
                                    return "DE";
                                case 'X':
                                    if (charAt2 != '0') {
                                        if (charAt2 < '3' || charAt2 > '9') {
                                            return null;
                                        }
                                        return "RU";
                                    }
                                    return "RU";
                                default:
                                    return null;
                            }
                    }
            }
        }
    }

    private static int modelYear(char c2) {
        if (c2 < 'E' || c2 > 'H') {
            if (c2 < 'J' || c2 > 'N') {
                if (c2 == 'P') {
                    return 1993;
                }
                if (c2 < 'R' || c2 > 'T') {
                    if (c2 < 'V' || c2 > 'Y') {
                        if (c2 < '1' || c2 > '9') {
                            if (c2 < 'A' || c2 > 'D') {
                                throw new IllegalArgumentException();
                            }
                            return (c2 - 'A') + 2010;
                        }
                        return (c2 - '1') + 2001;
                    }
                    return (c2 - 'V') + 1997;
                }
                return (c2 - 'R') + 1994;
            }
            return (c2 - 'J') + 1988;
        }
        return (c2 - 'E') + 1984;
    }

    private static int vinCharValue(char c2) {
        if (c2 < 'A' || c2 > 'I') {
            if (c2 < 'J' || c2 > 'R') {
                if (c2 < 'S' || c2 > 'Z') {
                    if (c2 < '0' || c2 > '9') {
                        throw new IllegalArgumentException();
                    }
                    return c2 - '0';
                }
                return (c2 - 'S') + 2;
            }
            return (c2 - 'J') + 1;
        }
        return (c2 - 'A') + 1;
    }

    private static int vinPositionWeight(int i) {
        if (i < 1 || i > 7) {
            if (i == 8) {
                return 10;
            }
            if (i == 9) {
                return 0;
            }
            if (i < 10 || i > 17) {
                throw new IllegalArgumentException();
            }
            return 19 - i;
        }
        return 9 - i;
    }

    @Override // com.sobot.chat.widget.zxing.client.result.ResultParser
    public VINParsedResult parse(Result result) {
        if (result.getBarcodeFormat() != BarcodeFormat.CODE_39) {
            return null;
        }
        String trim = IOQ.matcher(result.getText()).replaceAll("").trim();
        if (AZ09.matcher(trim).matches()) {
            try {
                if (checkChecksum(trim)) {
                    String substring = trim.substring(0, 3);
                    return new VINParsedResult(trim, substring, trim.substring(3, 9), trim.substring(9, 17), countryCode(substring), trim.substring(3, 8), modelYear(trim.charAt(9)), trim.charAt(10), trim.substring(11));
                }
                return null;
            } catch (IllegalArgumentException e) {
                return null;
            }
        }
        return null;
    }
}
