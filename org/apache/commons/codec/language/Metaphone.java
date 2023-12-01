package org.apache.commons.codec.language;

import java.util.Locale;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringEncoder;

/* loaded from: source-3503164-dex2jar.jar:org/apache/commons/codec/language/Metaphone.class */
public class Metaphone implements StringEncoder {
    private static final String FRONTV = "EIY";
    private static final String VARSON = "CSPTG";
    private static final String VOWELS = "AEIOU";
    private int maxCodeLen = 4;

    private boolean isLastChar(int i, int i2) {
        return i2 + 1 == i;
    }

    private boolean isNextChar(StringBuffer stringBuffer, int i, char c) {
        boolean z = false;
        if (i >= 0) {
            z = false;
            if (i < stringBuffer.length() - 1) {
                z = false;
                if (stringBuffer.charAt(i + 1) == c) {
                    z = true;
                }
            }
        }
        return z;
    }

    private boolean isPreviousChar(StringBuffer stringBuffer, int i, char c) {
        boolean z = false;
        if (i > 0) {
            z = false;
            if (i < stringBuffer.length()) {
                z = false;
                if (stringBuffer.charAt(i - 1) == c) {
                    z = true;
                }
            }
        }
        return z;
    }

    private boolean isVowel(StringBuffer stringBuffer, int i) {
        return VOWELS.indexOf(stringBuffer.charAt(i)) >= 0;
    }

    private boolean regionMatch(StringBuffer stringBuffer, int i, String str) {
        if (i < 0 || (str.length() + i) - 1 >= stringBuffer.length()) {
            return false;
        }
        return stringBuffer.substring(i, str.length() + i).equals(str);
    }

    @Override // org.apache.commons.codec.Encoder
    public Object encode(Object obj) throws EncoderException {
        if (obj instanceof String) {
            return metaphone((String) obj);
        }
        throw new EncoderException("Parameter supplied to Metaphone encode is not of type java.lang.String");
    }

    @Override // org.apache.commons.codec.StringEncoder
    public String encode(String str) {
        return metaphone(str);
    }

    public int getMaxCodeLen() {
        return this.maxCodeLen;
    }

    public boolean isMetaphoneEqual(String str, String str2) {
        return metaphone(str).equals(metaphone(str2));
    }

    public String metaphone(String str) {
        int i;
        int i2;
        if (str == null || str.length() == 0) {
            return "";
        }
        if (str.length() == 1) {
            return str.toUpperCase(Locale.ENGLISH);
        }
        char[] charArray = str.toUpperCase(Locale.ENGLISH).toCharArray();
        StringBuffer stringBuffer = new StringBuffer(40);
        StringBuffer stringBuffer2 = new StringBuffer(10);
        int i3 = 0;
        char c = charArray[0];
        if (c != 'A') {
            if (c == 'G' || c == 'K' || c == 'P') {
                if (charArray[1] == 'N') {
                    stringBuffer.append(charArray, 1, charArray.length - 1);
                } else {
                    stringBuffer.append(charArray);
                }
            } else if (c != 'W') {
                if (c != 'X') {
                    stringBuffer.append(charArray);
                } else {
                    charArray[0] = 'S';
                    stringBuffer.append(charArray);
                }
            } else if (charArray[1] == 'R') {
                stringBuffer.append(charArray, 1, charArray.length - 1);
            } else if (charArray[1] == 'H') {
                stringBuffer.append(charArray, 1, charArray.length - 1);
                stringBuffer.setCharAt(0, 'W');
            } else {
                stringBuffer.append(charArray);
            }
        } else if (charArray[1] == 'E') {
            stringBuffer.append(charArray, 1, charArray.length - 1);
        } else {
            stringBuffer.append(charArray);
        }
        int length = stringBuffer.length();
        while (stringBuffer2.length() < getMaxCodeLen() && i3 < length) {
            char charAt = stringBuffer.charAt(i3);
            if (charAt == 'C' || !isPreviousChar(stringBuffer, i3, charAt)) {
                switch (charAt) {
                    case 'A':
                    case 'E':
                    case 'I':
                    case 'O':
                    case 'U':
                        i = i3;
                        if (i3 == 0) {
                            stringBuffer2.append(charAt);
                            i = i3;
                            break;
                        }
                        break;
                    case 'B':
                        if (!isPreviousChar(stringBuffer, i3, 'M') || !isLastChar(length, i3)) {
                            stringBuffer2.append(charAt);
                            i = i3;
                            break;
                        } else {
                            i = i3;
                            break;
                        }
                        break;
                    case 'C':
                        if (isPreviousChar(stringBuffer, i3, 'S') && !isLastChar(length, i3) && FRONTV.indexOf(stringBuffer.charAt(i3 + 1)) >= 0) {
                            i = i3;
                            break;
                        } else if (!regionMatch(stringBuffer, i3, "CIA")) {
                            if (!isLastChar(length, i3) && FRONTV.indexOf(stringBuffer.charAt(i3 + 1)) >= 0) {
                                stringBuffer2.append('S');
                                i = i3;
                                break;
                            } else if (!isPreviousChar(stringBuffer, i3, 'S') || !isNextChar(stringBuffer, i3, 'H')) {
                                if (!isNextChar(stringBuffer, i3, 'H')) {
                                    stringBuffer2.append('K');
                                    i = i3;
                                    break;
                                } else if (i3 != 0 || length < 3 || !isVowel(stringBuffer, 2)) {
                                    stringBuffer2.append('X');
                                    i = i3;
                                    break;
                                } else {
                                    stringBuffer2.append('K');
                                    i = i3;
                                    break;
                                }
                            } else {
                                stringBuffer2.append('K');
                                i = i3;
                                break;
                            }
                        } else {
                            stringBuffer2.append('X');
                            i = i3;
                            break;
                        }
                        break;
                    case 'D':
                        if (!isLastChar(length, i3 + 1) && isNextChar(stringBuffer, i3, 'G')) {
                            i = i3 + 2;
                            if (FRONTV.indexOf(stringBuffer.charAt(i)) >= 0) {
                                stringBuffer2.append('J');
                                break;
                            }
                        }
                        stringBuffer2.append('T');
                        i = i3;
                        break;
                    case 'F':
                    case 'J':
                    case 'L':
                    case 'M':
                    case 'N':
                    case 'R':
                        stringBuffer2.append(charAt);
                        i = i3;
                        break;
                    case 'G':
                        int i4 = i3 + 1;
                        if (!isLastChar(length, i4) || !isNextChar(stringBuffer, i3, 'H')) {
                            if (!isLastChar(length, i4) && isNextChar(stringBuffer, i3, 'H') && !isVowel(stringBuffer, i3 + 2)) {
                                i = i3;
                                break;
                            } else {
                                if (i3 > 0) {
                                    i = i3;
                                    if (!regionMatch(stringBuffer, i3, "GN")) {
                                        if (regionMatch(stringBuffer, i3, "GNED")) {
                                            i = i3;
                                            break;
                                        }
                                    }
                                }
                                boolean isPreviousChar = isPreviousChar(stringBuffer, i3, 'G');
                                if (!isLastChar(length, i3) && FRONTV.indexOf(stringBuffer.charAt(i4)) >= 0 && !isPreviousChar) {
                                    stringBuffer2.append('J');
                                    i = i3;
                                    break;
                                } else {
                                    stringBuffer2.append('K');
                                    i = i3;
                                    break;
                                }
                            }
                        } else {
                            i = i3;
                            break;
                        }
                        break;
                    case 'H':
                        if (!isLastChar(length, i3)) {
                            if (i3 > 0 && VARSON.indexOf(stringBuffer.charAt(i3 - 1)) >= 0) {
                                i = i3;
                                break;
                            } else {
                                i = i3;
                                if (isVowel(stringBuffer, i3 + 1)) {
                                    stringBuffer2.append('H');
                                    i = i3;
                                    break;
                                }
                            }
                        } else {
                            i = i3;
                            break;
                        }
                        break;
                    case 'K':
                        if (i3 <= 0) {
                            stringBuffer2.append(charAt);
                            i = i3;
                            break;
                        } else {
                            i = i3;
                            if (!isPreviousChar(stringBuffer, i3, 'C')) {
                                stringBuffer2.append(charAt);
                                i = i3;
                                break;
                            }
                        }
                        break;
                    case 'P':
                        if (!isNextChar(stringBuffer, i3, 'H')) {
                            stringBuffer2.append(charAt);
                            i = i3;
                            break;
                        } else {
                            stringBuffer2.append('F');
                            i = i3;
                            break;
                        }
                    case 'Q':
                        stringBuffer2.append('K');
                        i = i3;
                        break;
                    case 'S':
                        if (!regionMatch(stringBuffer, i3, "SH") && !regionMatch(stringBuffer, i3, "SIO") && !regionMatch(stringBuffer, i3, "SIA")) {
                            stringBuffer2.append('S');
                            i = i3;
                            break;
                        } else {
                            stringBuffer2.append('X');
                            i = i3;
                            break;
                        }
                    case 'T':
                        if (!regionMatch(stringBuffer, i3, "TIA") && !regionMatch(stringBuffer, i3, "TIO")) {
                            if (!regionMatch(stringBuffer, i3, "TCH")) {
                                if (!regionMatch(stringBuffer, i3, "TH")) {
                                    stringBuffer2.append('T');
                                    i = i3;
                                    break;
                                } else {
                                    stringBuffer2.append('0');
                                    i = i3;
                                    break;
                                }
                            } else {
                                i = i3;
                                break;
                            }
                        } else {
                            stringBuffer2.append('X');
                            i = i3;
                            break;
                        }
                        break;
                    case 'V':
                        stringBuffer2.append('F');
                        i = i3;
                        break;
                    case 'W':
                    case 'Y':
                        i = i3;
                        if (!isLastChar(length, i3)) {
                            i = i3;
                            if (isVowel(stringBuffer, i3 + 1)) {
                                stringBuffer2.append(charAt);
                                i = i3;
                                break;
                            }
                        }
                        break;
                    case 'X':
                        stringBuffer2.append('K');
                        stringBuffer2.append('S');
                        i = i3;
                        break;
                    case 'Z':
                        stringBuffer2.append('S');
                        i = i3;
                        break;
                    default:
                        i = i3;
                        break;
                }
                i2 = i + 1;
            } else {
                i2 = i3 + 1;
            }
            i3 = i2;
            if (stringBuffer2.length() > getMaxCodeLen()) {
                stringBuffer2.setLength(getMaxCodeLen());
                i3 = i2;
            }
        }
        return stringBuffer2.toString();
    }

    public void setMaxCodeLen(int i) {
        this.maxCodeLen = i;
    }
}
