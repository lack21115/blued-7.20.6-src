package android.telephony;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.location.Country;
import android.location.CountryDetector;
import android.net.Uri;
import android.net.wifi.WifiEnterpriseConfig;
import android.os.SystemProperties;
import android.provider.Contacts;
import android.provider.ContactsContract;
import android.telecom.PhoneAccount;
import android.text.Editable;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.TtsSpan;
import android.util.SparseArray;
import android.util.SparseIntArray;
import com.android.i18n.phonenumbers.NumberParseException;
import com.android.i18n.phonenumbers.PhoneNumberUtil;
import com.android.i18n.phonenumbers.Phonenumber;
import com.android.i18n.phonenumbers.ShortNumberUtil;
import com.opos.acs.st.STManager;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: source-9557208-dex2jar.jar:android/telephony/PhoneNumberUtils.class */
public class PhoneNumberUtils {
    private static final int CCC_LENGTH = 0;
    private static final String CLIR_OFF = "#31#";
    private static final String CLIR_ON = "*31#";
    private static final boolean[] COUNTRY_CALLING_CALL = null;
    private static final boolean DBG = false;
    public static final int FORMAT_JAPAN = 2;
    public static final int FORMAT_NANP = 1;
    public static final int FORMAT_UNKNOWN = 0;
    private static final SparseIntArray KEYPAD_MAP = null;
    static final String LOG_TAG = "PhoneNumberUtils";
    static final int MIN_MATCH = 0;
    private static final String[] NANP_COUNTRIES = null;
    private static final String NANP_IDP_STRING = "011";
    private static final int NANP_LENGTH = 10;
    private static final int NANP_STATE_DASH = 4;
    private static final int NANP_STATE_DIGIT = 1;
    private static final int NANP_STATE_ONE = 3;
    private static final int NANP_STATE_PLUS = 2;
    public static final char PAUSE = ',';
    private static final char PLUS_SIGN_CHAR = '+';
    private static final String PLUS_SIGN_STRING = "+";
    public static final int TOA_International = 145;
    public static final int TOA_Unknown = 129;
    public static final char WAIT = ';';
    public static final char WILD = 'N';
    private static Pattern sCdmaLocalRewritePattern;
    private static Country sCountryDetector = null;
    private static final Pattern GLOBAL_PHONE_NUMBER_PATTERN = Pattern.compile("[\\+]?[0-9.-]+");
    private static SparseArray<RewriteRule> sCdmaLocalRewriteWhitelist = new SparseArray<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/telephony/PhoneNumberUtils$CountryCallingCodeAndNewIndex.class */
    public static class CountryCallingCodeAndNewIndex {
        public final int countryCallingCode;
        public final int newIndex;

        public CountryCallingCodeAndNewIndex(int i, int i2) {
            this.countryCallingCode = i;
            this.newIndex = i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/telephony/PhoneNumberUtils$RewriteRule.class */
    public static class RewriteRule {
        public int countryCodePrefix;
        public String isoCountryCode;
        public String replacement;

        public RewriteRule(int i, String str, String str2) {
            this.countryCodePrefix = i;
            this.isoCountryCode = str;
            this.replacement = str2;
        }

        public String apply(String str) {
            return str.replaceFirst("[+]" + this.countryCodePrefix, this.replacement);
        }
    }

    static {
        addRewriteRule(62, STManager.REGION_OF_ID, "0");
        addRewriteRule(380, "UA", "0");
        new StringBuffer();
        throw new VerifyError("bad dex opcode");
    }

    private static void addRewriteRule(int i, String str, String str2) {
        sCdmaLocalRewriteWhitelist.put(i, new RewriteRule(i, str, str2));
    }

    private static String appendPwCharBackToOrigDialStr(int i, String str, String str2) {
        return i == 1 ? str + str2.charAt(0) : str.concat(str2.substring(0, i));
    }

    private static char bcdToChar(byte b) {
        if (b < 10) {
            return (char) (b + 48);
        }
        switch (b) {
            case 10:
                return '*';
            case 11:
                return '#';
            case 12:
                return ',';
            case 13:
                return 'N';
            default:
                return (char) 0;
        }
    }

    public static String calledPartyBCDFragmentToString(byte[] bArr, int i, int i2) {
        StringBuilder sb = new StringBuilder(i2 * 2);
        internalCalledPartyBCDFragmentToString(sb, bArr, i, i2);
        return sb.toString();
    }

    public static String calledPartyBCDToString(byte[] bArr, int i, int i2) {
        boolean z = false;
        StringBuilder sb = new StringBuilder((i2 * 2) + 1);
        if (i2 < 2) {
            return "";
        }
        if ((bArr[i] & 240) == 144) {
            z = true;
        }
        internalCalledPartyBCDFragmentToString(sb, bArr, i + 1, i2 - 1);
        if (z && sb.length() == 0) {
            return "";
        }
        StringBuilder sb2 = sb;
        if (z) {
            String sb3 = sb.toString();
            Matcher matcher = Pattern.compile("(^[#*])(.*)([#*])(.*)(#)$").matcher(sb3);
            if (!matcher.matches()) {
                Matcher matcher2 = Pattern.compile("(^[#*])(.*)([#*])(.*)").matcher(sb3);
                if (matcher2.matches()) {
                    sb2 = new StringBuilder();
                    sb2.append(matcher2.group(1));
                    sb2.append(matcher2.group(2));
                    sb2.append(matcher2.group(3));
                    sb2.append(PLUS_SIGN_STRING);
                    sb2.append(matcher2.group(4));
                } else {
                    sb2 = new StringBuilder();
                    sb2.append('+');
                    sb2.append(sb3);
                }
            } else if ("".equals(matcher.group(2))) {
                sb2 = new StringBuilder();
                sb2.append(matcher.group(1));
                sb2.append(matcher.group(3));
                sb2.append(matcher.group(4));
                sb2.append(matcher.group(5));
                sb2.append(PLUS_SIGN_STRING);
            } else {
                sb2 = new StringBuilder();
                sb2.append(matcher.group(1));
                sb2.append(matcher.group(2));
                sb2.append(matcher.group(3));
                sb2.append(PLUS_SIGN_STRING);
                sb2.append(matcher.group(4));
                sb2.append(matcher.group(5));
            }
        }
        return sb2.toString();
    }

    public static String cdmaCheckAndProcessPlusCode(String str) {
        String str2 = str;
        if (!TextUtils.isEmpty(str)) {
            str2 = str;
            if (isReallyDialable(str.charAt(0))) {
                str2 = str;
                if (isNonSeparator(str)) {
                    String networkCountryIso = TelephonyManager.getDefault().getNetworkCountryIso();
                    String simCountryIso = TelephonyManager.getDefault().getSimCountryIso();
                    str2 = str;
                    if (!TextUtils.isEmpty(networkCountryIso)) {
                        str2 = str;
                        if (!TextUtils.isEmpty(simCountryIso)) {
                            str2 = cdmaCheckAndProcessPlusCodeByNumberFormat(str, getFormatTypeFromCountryCode(networkCountryIso), getFormatTypeFromCountryCode(simCountryIso));
                        }
                    }
                }
            }
        }
        return str2;
    }

    public static String cdmaCheckAndProcessPlusCodeByNumberFormat(String str, int i, int i2) {
        boolean z = i == i2 && i == 1;
        String str2 = str;
        if (str != null) {
            str2 = str;
            if (str.lastIndexOf(PLUS_SIGN_STRING) != -1) {
                String str3 = str;
                String str4 = null;
                while (true) {
                    String processPlusCode = processPlusCode(z ? extractNetworkPortion(str3) : extractNetworkPortionAlt(str3), z);
                    if (!TextUtils.isEmpty(processPlusCode)) {
                        String concat = str4 == null ? processPlusCode : str4.concat(processPlusCode);
                        String extractPostDialPortion = extractPostDialPortion(str3);
                        String str5 = extractPostDialPortion;
                        String str6 = concat;
                        String str7 = str3;
                        if (!TextUtils.isEmpty(extractPostDialPortion)) {
                            int findDialableIndexFromPostDialStr = findDialableIndexFromPostDialStr(extractPostDialPortion);
                            if (findDialableIndexFromPostDialStr >= 1) {
                                str6 = appendPwCharBackToOrigDialStr(findDialableIndexFromPostDialStr, concat, extractPostDialPortion);
                                str7 = extractPostDialPortion.substring(findDialableIndexFromPostDialStr);
                                str5 = extractPostDialPortion;
                            } else {
                                String str8 = extractPostDialPortion;
                                if (findDialableIndexFromPostDialStr < 0) {
                                    str8 = "";
                                }
                                Rlog.e("wrong postDialStr=", str8);
                                str5 = str8;
                                str6 = concat;
                                str7 = str3;
                            }
                        }
                        str2 = str6;
                        if (!TextUtils.isEmpty(str5)) {
                            str4 = str6;
                            str3 = str7;
                            if (TextUtils.isEmpty(str7)) {
                                str2 = str6;
                                break;
                            }
                        } else {
                            break;
                        }
                    } else {
                        Rlog.e("checkAndProcessPlusCode: null newDialStr", processPlusCode);
                        return str;
                    }
                }
            }
        }
        return str2;
    }

    public static String cdmaCheckAndProcessPlusCodeForSms(String str) {
        String str2 = str;
        if (!TextUtils.isEmpty(str)) {
            str2 = str;
            if (isReallyDialable(str.charAt(0))) {
                str2 = str;
                if (isNonSeparator(str)) {
                    String simCountryIso = TelephonyManager.getDefault().getSimCountryIso();
                    str2 = str;
                    if (!TextUtils.isEmpty(simCountryIso)) {
                        int formatTypeFromCountryCode = getFormatTypeFromCountryCode(simCountryIso);
                        str2 = cdmaCheckAndProcessPlusCodeByNumberFormat(str, formatTypeFromCountryCode, formatTypeFromCountryCode);
                    }
                }
            }
        }
        return str2;
    }

    private static int charToBCD(char c2) {
        if (c2 < '0' || c2 > '9') {
            if (c2 == '*') {
                return 10;
            }
            if (c2 == '#') {
                return 11;
            }
            if (c2 == ',') {
                return 12;
            }
            if (c2 == 'N') {
                return 13;
            }
            if (c2 == ';') {
                return 14;
            }
            throw new RuntimeException("invalid char for BCD " + c2);
        }
        return c2 - '0';
    }

    private static boolean checkPrefixIsIgnorable(String str, int i, int i2) {
        boolean z = false;
        while (i2 >= i) {
            if (tryGetISODigit(str.charAt(i2)) >= 0) {
                if (z) {
                    return false;
                }
                z = true;
            } else if (isDialable(str.charAt(i2))) {
                return false;
            }
            i2--;
        }
        return true;
    }

    public static boolean compare(Context context, String str, String str2) {
        return compare(str, str2, context.getResources().getBoolean(17956926));
    }

    public static boolean compare(String str, String str2) {
        return compare(str, str2, false);
    }

    public static boolean compare(String str, String str2, boolean z) {
        return z ? compareStrictly(str, str2) : compareLoosely(str, str2);
    }

    public static boolean compareLoosely(String str, String str2) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5 = 0;
        int i6 = 0;
        if (str == null || str2 == null) {
            return str == str2;
        } else if (str.length() == 0 || str2.length() == 0) {
            return false;
        } else {
            int indexOfLastNetworkChar = indexOfLastNetworkChar(str);
            int indexOfLastNetworkChar2 = indexOfLastNetworkChar(str2);
            int i7 = 0;
            while (true) {
                i = indexOfLastNetworkChar;
                i2 = indexOfLastNetworkChar2;
                i3 = i5;
                i4 = i6;
                if (indexOfLastNetworkChar < 0) {
                    break;
                }
                i = indexOfLastNetworkChar;
                i2 = indexOfLastNetworkChar2;
                i3 = i5;
                i4 = i6;
                if (indexOfLastNetworkChar2 < 0) {
                    break;
                }
                boolean z = false;
                char charAt = str.charAt(indexOfLastNetworkChar);
                i = indexOfLastNetworkChar;
                i3 = i5;
                if (!isDialable(charAt)) {
                    i = indexOfLastNetworkChar - 1;
                    z = true;
                    i3 = i5 + 1;
                }
                char charAt2 = str2.charAt(indexOfLastNetworkChar2);
                i2 = indexOfLastNetworkChar2;
                i4 = i6;
                if (!isDialable(charAt2)) {
                    i2 = indexOfLastNetworkChar2 - 1;
                    z = true;
                    i4 = i6 + 1;
                }
                indexOfLastNetworkChar = i;
                indexOfLastNetworkChar2 = i2;
                i5 = i3;
                i6 = i4;
                if (!z) {
                    if (charAt2 != charAt && charAt != 'N' && charAt2 != 'N') {
                        break;
                    }
                    indexOfLastNetworkChar = i - 1;
                    indexOfLastNetworkChar2 = i2 - 1;
                    i7++;
                    i5 = i3;
                    i6 = i4;
                }
            }
            if (i7 < MIN_MATCH) {
                int length = str.length() - i3;
                return length == str2.length() - i4 && length == i7;
            } else if (i7 < MIN_MATCH || (i >= 0 && i2 >= 0)) {
                if (matchIntlPrefix(str, i + 1) && matchIntlPrefix(str2, i2 + 1)) {
                    return true;
                }
                if (matchTrunkPrefix(str, i + 1) && matchIntlPrefixAndCC(str2, i2 + 1)) {
                    return true;
                }
                return matchTrunkPrefix(str2, i2 + 1) && matchIntlPrefixAndCC(str, i + 1);
            } else {
                return true;
            }
        }
    }

    public static boolean compareStrictly(String str, String str2) {
        return compareStrictly(str, str2, true);
    }

    public static boolean compareStrictly(String str, String str2, boolean z) {
        boolean z2;
        boolean z3;
        if (str == null || str2 == null) {
            return str == str2;
        } else if (str.length() == 0 && str2.length() == 0) {
            return false;
        } else {
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            CountryCallingCodeAndNewIndex tryGetCountryCallingCodeAndNewIndex = tryGetCountryCallingCodeAndNewIndex(str, z);
            CountryCallingCodeAndNewIndex tryGetCountryCallingCodeAndNewIndex2 = tryGetCountryCallingCodeAndNewIndex(str2, z);
            boolean z4 = false;
            boolean z5 = false;
            boolean z6 = false;
            if (tryGetCountryCallingCodeAndNewIndex == null || tryGetCountryCallingCodeAndNewIndex2 == null) {
                if (tryGetCountryCallingCodeAndNewIndex == null && tryGetCountryCallingCodeAndNewIndex2 == null) {
                    z3 = false;
                    z2 = false;
                } else {
                    if (tryGetCountryCallingCodeAndNewIndex != null) {
                        i = tryGetCountryCallingCodeAndNewIndex.newIndex;
                    } else {
                        int tryGetTrunkPrefixOmittedIndex = tryGetTrunkPrefixOmittedIndex(str2, 0);
                        if (tryGetTrunkPrefixOmittedIndex >= 0) {
                            i = tryGetTrunkPrefixOmittedIndex;
                            z4 = true;
                        }
                    }
                    if (tryGetCountryCallingCodeAndNewIndex2 != null) {
                        i3 = tryGetCountryCallingCodeAndNewIndex2.newIndex;
                        z2 = false;
                        i2 = i;
                        z3 = true;
                        z5 = z4;
                    } else {
                        int tryGetTrunkPrefixOmittedIndex2 = tryGetTrunkPrefixOmittedIndex(str2, 0);
                        z2 = false;
                        i2 = i;
                        z3 = true;
                        z5 = z4;
                        if (tryGetTrunkPrefixOmittedIndex2 >= 0) {
                            i3 = tryGetTrunkPrefixOmittedIndex2;
                            z6 = true;
                            z2 = false;
                            i2 = i;
                            z3 = true;
                            z5 = z4;
                        }
                    }
                }
            } else if (tryGetCountryCallingCodeAndNewIndex.countryCallingCode != tryGetCountryCallingCodeAndNewIndex2.countryCallingCode) {
                return false;
            } else {
                z3 = false;
                z2 = true;
                i2 = tryGetCountryCallingCodeAndNewIndex.newIndex;
                i3 = tryGetCountryCallingCodeAndNewIndex2.newIndex;
            }
            int length = str.length() - 1;
            int length2 = str2.length() - 1;
            while (length >= i2 && length2 >= i3) {
                boolean z7 = false;
                char charAt = str.charAt(length);
                char charAt2 = str2.charAt(length2);
                int i4 = length;
                if (isSeparator(charAt)) {
                    i4 = length - 1;
                    z7 = true;
                }
                int i5 = length2;
                if (isSeparator(charAt2)) {
                    i5 = length2 - 1;
                    z7 = true;
                }
                length = i4;
                length2 = i5;
                if (!z7) {
                    if (charAt != charAt2) {
                        return false;
                    }
                    length = i4 - 1;
                    length2 = i5 - 1;
                }
            }
            if (z3) {
                if ((z5 && i2 <= length) || !checkPrefixIsIgnorable(str, i2, length)) {
                    if (z) {
                        return compare(str, str2, false);
                    }
                    return false;
                } else if ((!z6 || i3 > length2) && checkPrefixIsIgnorable(str2, i2, length2)) {
                    return true;
                } else {
                    if (z) {
                        return compare(str, str2, false);
                    }
                    return false;
                }
            }
            boolean z8 = !z2;
            while (true) {
                boolean z9 = z8;
                int i6 = length2;
                boolean z10 = z9;
                if (length < i2) {
                    while (i6 >= i3) {
                        char charAt3 = str2.charAt(i6);
                        boolean z11 = z10;
                        if (isDialable(charAt3)) {
                            if (!z10 || tryGetISODigit(charAt3) != 1) {
                                return false;
                            }
                            z11 = false;
                        }
                        i6--;
                        z10 = z11;
                    }
                    return true;
                }
                char charAt4 = str.charAt(length);
                boolean z12 = z9;
                if (isDialable(charAt4)) {
                    if (!z9 || tryGetISODigit(charAt4) != 1) {
                        return false;
                    }
                    z12 = false;
                }
                length--;
                z8 = z12;
            }
        }
    }

    public static String convertAndStrip(String str) {
        return stripSeparators(convertKeypadLettersToDigits(str));
    }

    public static String convertKeypadLettersToDigits(String str) {
        int length;
        if (str == null || (length = str.length()) == 0) {
            return str;
        }
        char[] charArray = str.toCharArray();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return new String(charArray);
            }
            char c2 = charArray[i2];
            charArray[i2] = (char) KEYPAD_MAP.get(c2, c2);
            i = i2 + 1;
        }
    }

    public static String convertPreDial(String str) {
        char c2;
        if (str == null) {
            return null;
        }
        int length = str.length();
        StringBuilder sb = new StringBuilder(length);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return sb.toString();
            }
            char charAt = str.charAt(i2);
            if (isPause(charAt)) {
                c2 = ',';
            } else {
                c2 = charAt;
                if (isToneWait(charAt)) {
                    c2 = ';';
                }
            }
            sb.append(c2);
            i = i2 + 1;
        }
    }

    public static String extractNetworkPortion(String str) {
        if (str == null) {
            return null;
        }
        int length = str.length();
        StringBuilder sb = new StringBuilder(length);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                break;
            }
            char charAt = str.charAt(i2);
            int digit = Character.digit(charAt, 10);
            if (digit != -1) {
                sb.append(digit);
            } else if (charAt == '+') {
                String sb2 = sb.toString();
                if (sb2.length() == 0 || sb2.equals(CLIR_ON) || sb2.equals(CLIR_OFF)) {
                    sb.append(charAt);
                }
            } else if (isDialable(charAt)) {
                sb.append(charAt);
            } else if (isStartsPostDial(charAt)) {
                break;
            }
            i = i2 + 1;
        }
        return sb.toString();
    }

    public static String extractNetworkPortionAlt(String str) {
        if (str == null) {
            return null;
        }
        int length = str.length();
        StringBuilder sb = new StringBuilder(length);
        boolean z = false;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                break;
            }
            char charAt = str.charAt(i2);
            boolean z2 = z;
            if (charAt == '+') {
                if (z) {
                    continue;
                    i = i2 + 1;
                } else {
                    z2 = true;
                }
            }
            if (isDialable(charAt)) {
                sb.append(charAt);
                z = z2;
            } else {
                z = z2;
                if (isStartsPostDial(charAt)) {
                    break;
                }
            }
            i = i2 + 1;
        }
        return sb.toString();
    }

    public static String extractPostDialPortion(String str) {
        if (str == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        for (int indexOfLastNetworkChar = indexOfLastNetworkChar(str) + 1; indexOfLastNetworkChar < length; indexOfLastNetworkChar++) {
            char charAt = str.charAt(indexOfLastNetworkChar);
            if (isNonSeparator(charAt)) {
                sb.append(charAt);
            }
        }
        return sb.toString();
    }

    private static int findDialableIndexFromPostDialStr(String str) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= str.length()) {
                return -1;
            }
            if (isReallyDialable(str.charAt(i2))) {
                return i2;
            }
            i = i2 + 1;
        }
    }

    public static void formatJapaneseNumber(Editable editable) {
        JapanesePhoneNumberFormatter.format(editable);
    }

    public static void formatNanpNumber(Editable editable) {
        int length = editable.length();
        if (length > "+1-nnn-nnn-nnnn".length() || length <= 5) {
            return;
        }
        CharSequence subSequence = editable.subSequence(0, length);
        removeDashes(editable);
        int length2 = editable.length();
        int[] iArr = new int[3];
        boolean z = true;
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < length2; i3++) {
            switch (editable.charAt(i3)) {
                case '+':
                    if (i3 != 0) {
                        editable.replace(0, length2, subSequence);
                        return;
                    }
                    z = true;
                    continue;
                case ',':
                case '.':
                case '/':
                default:
                    editable.replace(0, length2, subSequence);
                    return;
                case '-':
                    z = true;
                    continue;
                case '0':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    break;
                case '1':
                    if (i == 0 || z) {
                        z = true;
                        continue;
                    }
                    break;
            }
            if (z) {
                editable.replace(0, length2, subSequence);
                return;
            }
            if (z) {
                iArr[i2] = i3;
                i2++;
            } else if (!z && (i == 3 || i == 6)) {
                iArr[i2] = i3;
                i2++;
            }
            z = true;
            i++;
        }
        if (i == 7) {
            i2--;
        }
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i5 < i2) {
                int i6 = iArr[i5];
                editable.replace(i6 + i5, i6 + i5, Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                i4 = i5 + 1;
            } else {
                int length3 = editable.length();
                while (true) {
                    int i7 = length3;
                    if (i7 <= 0 || editable.charAt(i7 - 1) != '-') {
                        return;
                    }
                    editable.delete(i7 - 1, i7);
                    length3 = i7 - 1;
                }
            }
        }
    }

    public static String formatNumber(String str) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        formatNumber(spannableStringBuilder, getFormatTypeForLocale(Locale.getDefault()));
        return spannableStringBuilder.toString();
    }

    public static String formatNumber(String str, int i) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        formatNumber(spannableStringBuilder, i);
        return spannableStringBuilder.toString();
    }

    public static String formatNumber(String str, String str2) {
        if (str.startsWith("#") || str.startsWith("*")) {
            return str;
        }
        PhoneNumberUtil phoneNumberUtil = PhoneNumberUtil.getInstance();
        try {
            return phoneNumberUtil.formatInOriginalFormat(phoneNumberUtil.parseAndKeepRawInput(str, str2), str2);
        } catch (NumberParseException e) {
            return null;
        }
    }

    public static String formatNumber(String str, String str2, String str3) {
        int length = str.length();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                PhoneNumberUtil phoneNumberUtil = PhoneNumberUtil.getInstance();
                String str4 = str3;
                if (str2 != null) {
                    str4 = str3;
                    if (str2.length() >= 2) {
                        str4 = str3;
                        if (str2.charAt(0) == '+') {
                            try {
                                String regionCodeForNumber = phoneNumberUtil.getRegionCodeForNumber(phoneNumberUtil.parse(str2, "ZZ"));
                                str4 = str3;
                                if (!TextUtils.isEmpty(regionCodeForNumber)) {
                                    str4 = str3;
                                    if (normalizeNumber(str).indexOf(str2.substring(1)) <= 0) {
                                        str4 = regionCodeForNumber;
                                    }
                                }
                            } catch (NumberParseException e) {
                                str4 = str3;
                            }
                        }
                    }
                }
                String formatNumber = formatNumber(str, str4);
                if (formatNumber != null) {
                    str = formatNumber;
                }
                return str;
            } else if (!isDialable(str.charAt(i2))) {
                return str;
            } else {
                i = i2 + 1;
            }
        }
    }

    public static void formatNumber(Editable editable, int i) {
        int i2 = i;
        if (editable.length() > 2) {
            i2 = i;
            if (editable.charAt(0) == '+') {
                i2 = editable.charAt(1) == '1' ? 1 : (editable.length() >= 3 && editable.charAt(1) == '8' && editable.charAt(2) == '1') ? 2 : 0;
            }
        }
        switch (i2) {
            case 0:
                removeDashes(editable);
                return;
            case 1:
                formatNanpNumber(editable);
                return;
            case 2:
                formatJapaneseNumber(editable);
                return;
            default:
                return;
        }
    }

    public static String formatNumberToE164(String str, String str2) {
        PhoneNumberUtil phoneNumberUtil = PhoneNumberUtil.getInstance();
        try {
            Phonenumber.PhoneNumber parse = phoneNumberUtil.parse(str, str2);
            String str3 = null;
            if (phoneNumberUtil.isValidNumber(parse)) {
                str3 = phoneNumberUtil.format(parse, PhoneNumberUtil.PhoneNumberFormat.E164);
            }
            return str3;
        } catch (NumberParseException e) {
            return null;
        }
    }

    private static RewriteRule getCdmaLocalRewriteRule(String str, String str2, String str3) {
        Matcher matcher = sCdmaLocalRewritePattern.matcher(str);
        if (matcher.find()) {
            RewriteRule rewriteRule = sCdmaLocalRewriteWhitelist.get(Integer.valueOf(matcher.group(1)).intValue());
            if (str2.equalsIgnoreCase(str3) && str2.equalsIgnoreCase(rewriteRule.isoCountryCode)) {
                return rewriteRule;
            }
            return null;
        }
        return null;
    }

    private static String getCountryIso(Context context) {
        CountryDetector countryDetector;
        Rlog.w(LOG_TAG, "getCountryIso " + sCountryDetector);
        if (sCountryDetector == null && (countryDetector = (CountryDetector) context.getSystemService(Context.COUNTRY_DETECTOR)) != null) {
            sCountryDetector = countryDetector.detectCountry();
        }
        if (sCountryDetector == null) {
            return null;
        }
        return sCountryDetector.getCountryIso();
    }

    private static String getCurrentIdp(boolean z) {
        return SystemProperties.get("gsm.operator.idpstring", z ? NANP_IDP_STRING : PLUS_SIGN_STRING);
    }

    private static int getDefaultVoiceSubId() {
        return SubscriptionManager.getDefaultVoiceSubId();
    }

    public static int getFormatTypeForLocale(Locale locale) {
        return getFormatTypeFromCountryCode(locale.getCountry());
    }

    private static int getFormatTypeFromCountryCode(String str) {
        int length = NANP_COUNTRIES.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return "jp".compareToIgnoreCase(str) == 0 ? 2 : 0;
            } else if (NANP_COUNTRIES[i2].compareToIgnoreCase(str) == 0) {
                return 1;
            } else {
                i = i2 + 1;
            }
        }
    }

    public static String getNumberFromIntent(Intent intent, Context context) {
        Uri data = intent.getData();
        if (data == null) {
            return null;
        }
        String scheme = data.getScheme();
        if (scheme.equals(PhoneAccount.SCHEME_TEL) || scheme.equals("sip")) {
            return data.getSchemeSpecificPart();
        }
        if (context != null) {
            intent.resolveType(context);
            String str = null;
            String authority = data.getAuthority();
            if (Contacts.AUTHORITY.equals(authority)) {
                str = "number";
            } else if (ContactsContract.AUTHORITY.equals(authority)) {
                str = "data1";
            }
            Cursor query = context.getContentResolver().query(data, new String[]{str}, null, null, null);
            String str2 = null;
            if (query != null) {
                str2 = null;
                try {
                    if (query.moveToFirst()) {
                        str2 = query.getString(query.getColumnIndex(str));
                    }
                } finally {
                    query.close();
                }
            }
            return str2;
        }
        return null;
    }

    public static String getStrippedReversed(String str) {
        String extractNetworkPortionAlt = extractNetworkPortionAlt(str);
        if (extractNetworkPortionAlt == null) {
            return null;
        }
        return internalGetStrippedReversed(extractNetworkPortionAlt, extractNetworkPortionAlt.length());
    }

    public static String getUsernameFromUriNumber(String str) {
        int indexOf = str.indexOf(64);
        int i = indexOf;
        if (indexOf < 0) {
            i = str.indexOf("%40");
        }
        int i2 = i;
        if (i < 0) {
            Rlog.w(LOG_TAG, "getUsernameFromUriNumber: no delimiter found in SIP addr '" + str + "'");
            i2 = str.length();
        }
        return str.substring(0, i2);
    }

    private static int indexOfLastNetworkChar(String str) {
        int length = str.length();
        int minPositive = minPositive(str.indexOf(44), str.indexOf(59));
        return minPositive < 0 ? length - 1 : minPositive - 1;
    }

    private static void internalCalledPartyBCDFragmentToString(StringBuilder sb, byte[] bArr, int i, int i2) {
        char bcdToChar;
        char bcdToChar2;
        int i3 = i;
        while (true) {
            int i4 = i3;
            if (i4 >= i2 + i || (bcdToChar = bcdToChar((byte) (bArr[i4] & 15))) == 0) {
                return;
            }
            sb.append(bcdToChar);
            byte b = (byte) ((bArr[i4] >> 4) & 15);
            if ((b == 15 && i4 + 1 == i2 + i) || (bcdToChar2 = bcdToChar(b)) == 0) {
                return;
            }
            sb.append(bcdToChar2);
            i3 = i4 + 1;
        }
    }

    private static String internalGetStrippedReversed(String str, int i) {
        if (str == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(i);
        int length = str.length();
        int i2 = length;
        while (true) {
            int i3 = i2 - 1;
            if (i3 < 0 || length - i3 > i) {
                break;
            }
            sb.append(str.charAt(i3));
            i2 = i3;
        }
        return sb.toString();
    }

    public static final boolean is12Key(char c2) {
        return (c2 >= '0' && c2 <= '9') || c2 == '*' || c2 == '#';
    }

    private static boolean isCountryCallingCode(int i) {
        return i > 0 && i < CCC_LENGTH && COUNTRY_CALLING_CALL[i];
    }

    public static final boolean isDialable(char c2) {
        return (c2 >= '0' && c2 <= '9') || c2 == '*' || c2 == '#' || c2 == '+' || c2 == 'N';
    }

    private static boolean isDialable(String str) {
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (!isDialable(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isEmergencyNumber(int i, String str) {
        return isEmergencyNumberInternal(i, str, true);
    }

    public static boolean isEmergencyNumber(int i, String str, String str2) {
        return isEmergencyNumberInternal(i, str, str2, true);
    }

    public static boolean isEmergencyNumber(String str) {
        return isEmergencyNumber(getDefaultVoiceSubId(), str);
    }

    public static boolean isEmergencyNumber(String str, String str2) {
        return isEmergencyNumber(getDefaultVoiceSubId(), str, str2);
    }

    private static boolean isEmergencyNumberForCurrentIso(String str, String str2) {
        Rlog.w(LOG_TAG, "isEmergencyNumberForCurrentIso: number=" + str + " country=" + str2);
        boolean z = true;
        if (!STManager.REGION_OF_IN.equalsIgnoreCase(str2)) {
            z = true;
            if (str.equals("101") | str.equals("102")) {
                Rlog.w(LOG_TAG, "Number and Country doesn't match for emergency number");
                z = false;
            }
        }
        return z;
    }

    private static boolean isEmergencyNumberInternal(int i, String str, String str2, boolean z) {
        if (str == null || isUriNumber(str)) {
            return false;
        }
        String extractNetworkPortionAlt = extractNetworkPortionAlt(str);
        Rlog.d(LOG_TAG, "subId:" + i + ", number: " + extractNetworkPortionAlt + ", defaultCountryIso:" + (str2 == null ? WifiEnterpriseConfig.EMPTY_VALUE : str2));
        String str3 = "";
        int slotId = SubscriptionManager.getSlotId(i);
        if (slotId >= 0) {
            str3 = SystemProperties.get(slotId == 0 ? "ril.ecclist" : "ril.ecclist" + slotId, "");
        }
        Rlog.d(LOG_TAG, "slotId:" + slotId + ", emergencyNumbers: " + str3);
        String str4 = str3;
        if (TextUtils.isEmpty(str3)) {
            str4 = SystemProperties.get("ro.ril.ecclist");
        }
        if (TextUtils.isEmpty(str4)) {
            Rlog.d(LOG_TAG, "System property doesn't provide any emergency numbers. Use embedded logic for determining ones.");
            String[] split = (slotId < 0 ? "112,911,000,08,110,118,119,999" : "112,911").split(",");
            int length = split.length;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= length) {
                    if (str2 != null) {
                        ShortNumberUtil shortNumberUtil = new ShortNumberUtil();
                        return z ? shortNumberUtil.isEmergencyNumber(extractNetworkPortionAlt, str2) : shortNumberUtil.connectsToEmergencyNumber(extractNetworkPortionAlt, str2);
                    }
                    return false;
                }
                String str5 = split[i3];
                if (z) {
                    if (extractNetworkPortionAlt.equals(str5)) {
                        return true;
                    }
                } else if (extractNetworkPortionAlt.startsWith(str5)) {
                    return true;
                }
                i2 = i3 + 1;
            }
        } else {
            String[] split2 = str4.split(",");
            int length2 = split2.length;
            int i4 = 0;
            while (true) {
                int i5 = i4;
                if (i5 >= length2) {
                    return false;
                }
                String str6 = split2[i5];
                if (z || "BR".equalsIgnoreCase(str2)) {
                    if (extractNetworkPortionAlt.equals(str6) && isEmergencyNumberForCurrentIso(extractNetworkPortionAlt, str2)) {
                        return true;
                    }
                } else if (extractNetworkPortionAlt.startsWith(str6) && isEmergencyNumberForCurrentIso(extractNetworkPortionAlt, str2)) {
                    return true;
                }
                i4 = i5 + 1;
            }
        }
    }

    private static boolean isEmergencyNumberInternal(int i, String str, boolean z) {
        return isEmergencyNumberInternal(i, str, null, z);
    }

    private static boolean isEmergencyNumberInternal(String str, String str2, boolean z) {
        return isEmergencyNumberInternal(getDefaultVoiceSubId(), str, str2, z);
    }

    private static boolean isEmergencyNumberInternal(String str, boolean z) {
        return isEmergencyNumberInternal(getDefaultVoiceSubId(), str, z);
    }

    public static boolean isGlobalPhoneNumber(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return GLOBAL_PHONE_NUMBER_PATTERN.matcher(str).matches();
    }

    public static boolean isISODigit(char c2) {
        return c2 >= '0' && c2 <= '9';
    }

    public static boolean isLocalEmergencyNumber(Context context, int i, String str) {
        return isLocalEmergencyNumberInternal(i, str, context, true);
    }

    public static boolean isLocalEmergencyNumber(Context context, String str) {
        return isLocalEmergencyNumber(context, getDefaultVoiceSubId(), str);
    }

    private static boolean isLocalEmergencyNumberInternal(int i, String str, Context context, boolean z) {
        String countryIso = getCountryIso(context);
        Rlog.w(LOG_TAG, "isLocalEmergencyNumberInternal" + countryIso);
        String str2 = countryIso;
        if (countryIso == null) {
            str2 = context.getResources().getConfiguration().locale.getCountry();
            Rlog.w(LOG_TAG, "No CountryDetector; falling back to countryIso based on locale: " + str2);
        }
        return isEmergencyNumberInternal(i, str, str2, z);
    }

    private static boolean isLocalEmergencyNumberInternal(String str, Context context, boolean z) {
        return isLocalEmergencyNumberInternal(getDefaultVoiceSubId(), str, context, z);
    }

    public static boolean isNanp(String str) {
        if (str == null) {
            Rlog.e("isNanp: null dialStr passed in", str);
            return false;
        }
        boolean z = false;
        if (str.length() == 10) {
            z = false;
            if (isTwoToNine(str.charAt(0))) {
                z = false;
                if (isTwoToNine(str.charAt(3))) {
                    int i = 1;
                    while (true) {
                        int i2 = i;
                        z = true;
                        if (i2 >= 10) {
                            break;
                        } else if (!isISODigit(str.charAt(i2))) {
                            z = false;
                            break;
                        } else {
                            i = i2 + 1;
                        }
                    }
                }
            }
        }
        return z;
    }

    public static final boolean isNonSeparator(char c2) {
        return (c2 >= '0' && c2 <= '9') || c2 == '*' || c2 == '#' || c2 == '+' || c2 == 'N' || c2 == ';' || c2 == ',';
    }

    private static boolean isNonSeparator(String str) {
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (!isNonSeparator(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private static boolean isOneNanp(String str) {
        if (str == null) {
            Rlog.e("isOneNanp: null dialStr passed in", str);
            return false;
        }
        String substring = str.substring(1);
        boolean z = false;
        if (str.charAt(0) == '1') {
            z = false;
            if (isNanp(substring)) {
                z = true;
            }
        }
        return z;
    }

    private static boolean isPause(char c2) {
        return c2 == 'p' || c2 == 'P';
    }

    public static boolean isPotentialEmergencyNumber(int i, String str) {
        return isEmergencyNumberInternal(i, str, false);
    }

    public static boolean isPotentialEmergencyNumber(int i, String str, String str2) {
        return isEmergencyNumberInternal(i, str, str2, false);
    }

    public static boolean isPotentialEmergencyNumber(String str) {
        return isPotentialEmergencyNumber(getDefaultVoiceSubId(), str);
    }

    public static boolean isPotentialEmergencyNumber(String str, String str2) {
        return isPotentialEmergencyNumber(getDefaultVoiceSubId(), str, str2);
    }

    public static boolean isPotentialLocalEmergencyNumber(Context context, int i, String str) {
        return isLocalEmergencyNumberInternal(i, str, context, false);
    }

    public static boolean isPotentialLocalEmergencyNumber(Context context, String str) {
        return isPotentialLocalEmergencyNumber(context, getDefaultVoiceSubId(), str);
    }

    public static final boolean isReallyDialable(char c2) {
        return (c2 >= '0' && c2 <= '9') || c2 == '*' || c2 == '#' || c2 == '+';
    }

    private static boolean isSeparator(char c2) {
        if (isDialable(c2)) {
            return false;
        }
        if ('a' > c2 || c2 > 'z') {
            return 'A' > c2 || c2 > 'Z';
        }
        return false;
    }

    public static final boolean isStartsPostDial(char c2) {
        return c2 == ',' || c2 == ';';
    }

    private static boolean isToneWait(char c2) {
        return c2 == 'w' || c2 == 'W';
    }

    private static boolean isTwoToNine(char c2) {
        return c2 >= '2' && c2 <= '9';
    }

    public static boolean isUriNumber(String str) {
        if (str != null) {
            return str.contains("@") || str.contains("%40");
        }
        return false;
    }

    public static boolean isVoiceMailNumber(int i, String str) {
        try {
            String voiceMailNumber = TelephonyManager.getDefault().getVoiceMailNumber(i);
            String extractNetworkPortionAlt = extractNetworkPortionAlt(str);
            boolean z = false;
            if (!TextUtils.isEmpty(extractNetworkPortionAlt)) {
                z = false;
                if (compare(extractNetworkPortionAlt, voiceMailNumber)) {
                    z = true;
                }
            }
            return z;
        } catch (SecurityException e) {
            return false;
        }
    }

    public static boolean isVoiceMailNumber(String str) {
        return isVoiceMailNumber(SubscriptionManager.getDefaultSubId(), str);
    }

    public static boolean isWellFormedSmsAddress(String str) {
        String extractNetworkPortion = extractNetworkPortion(str);
        return (extractNetworkPortion.equals(PLUS_SIGN_STRING) || TextUtils.isEmpty(extractNetworkPortion) || !isDialable(extractNetworkPortion)) ? false : true;
    }

    private static void log(String str) {
        Rlog.d(LOG_TAG, str);
    }

    private static boolean matchIntlPrefix(String str, int i) {
        boolean z = false;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= i) {
                return z || z || z;
            }
            char charAt = str.charAt(i3);
            switch (z) {
                case false:
                    if (charAt != '+') {
                        if (charAt != '0') {
                            if (!isNonSeparator(charAt)) {
                                break;
                            } else {
                                return false;
                            }
                        } else {
                            z = true;
                            break;
                        }
                    } else {
                        z = true;
                        break;
                    }
                case true:
                case true:
                default:
                    if (!isNonSeparator(charAt)) {
                        break;
                    } else {
                        return false;
                    }
                case true:
                    if (charAt != '0') {
                        if (charAt != '1') {
                            if (!isNonSeparator(charAt)) {
                                break;
                            } else {
                                return false;
                            }
                        } else {
                            z = true;
                            break;
                        }
                    } else {
                        z = true;
                        break;
                    }
                case true:
                    if (charAt != '1') {
                        if (!isNonSeparator(charAt)) {
                            break;
                        } else {
                            return false;
                        }
                    } else {
                        z = true;
                        break;
                    }
            }
            i2 = i3 + 1;
        }
    }

    private static boolean matchIntlPrefixAndCC(String str, int i) {
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= i) {
                return i2 == 6 || i2 == 7 || i2 == 8;
            }
            char charAt = str.charAt(i4);
            switch (i2) {
                case 0:
                    if (charAt != '+') {
                        if (charAt != '0') {
                            if (!isNonSeparator(charAt)) {
                                break;
                            } else {
                                return false;
                            }
                        } else {
                            i2 = 2;
                            break;
                        }
                    } else {
                        i2 = 1;
                        break;
                    }
                case 1:
                case 3:
                case 5:
                    if (!isISODigit(charAt)) {
                        if (!isNonSeparator(charAt)) {
                            break;
                        } else {
                            return false;
                        }
                    } else {
                        i2 = 6;
                        break;
                    }
                case 2:
                    if (charAt != '0') {
                        if (charAt != '1') {
                            if (!isNonSeparator(charAt)) {
                                break;
                            } else {
                                return false;
                            }
                        } else {
                            i2 = 4;
                            break;
                        }
                    } else {
                        i2 = 3;
                        break;
                    }
                case 4:
                    if (charAt != '1') {
                        if (!isNonSeparator(charAt)) {
                            break;
                        } else {
                            return false;
                        }
                    } else {
                        i2 = 5;
                        break;
                    }
                case 6:
                case 7:
                    if (!isISODigit(charAt)) {
                        if (!isNonSeparator(charAt)) {
                            break;
                        } else {
                            return false;
                        }
                    } else {
                        i2++;
                        break;
                    }
                default:
                    if (!isNonSeparator(charAt)) {
                        break;
                    } else {
                        return false;
                    }
            }
            i3 = i4 + 1;
        }
    }

    private static boolean matchTrunkPrefix(String str, int i) {
        boolean z;
        boolean z2 = false;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            z = z2;
            if (i3 >= i) {
                break;
            }
            char charAt = str.charAt(i3);
            if (charAt == '0' && !z2) {
                z2 = true;
            } else if (isNonSeparator(charAt)) {
                z = false;
                break;
            }
            i2 = i3 + 1;
        }
        return z;
    }

    private static int minPositive(int i, int i2) {
        if (i < 0 || i2 < 0) {
            if (i < 0) {
                if (i2 >= 0) {
                    return i2;
                }
                return -1;
            }
        } else if (i >= i2) {
            return i2;
        }
        return i;
    }

    public static byte[] networkPortionToCalledPartyBCD(String str) {
        return numberToCalledPartyBCDHelper(extractNetworkPortion(str), false);
    }

    public static byte[] networkPortionToCalledPartyBCDWithLength(String str) {
        return numberToCalledPartyBCDHelper(extractNetworkPortion(str), true);
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0079, code lost:
        return normalizeNumber(convertKeypadLettersToDigits(r3));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String normalizeNumber(java.lang.String r3) {
        /*
            r0 = r3
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto La
            java.lang.String r0 = ""
            return r0
        La:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            r1.<init>()
            r8 = r0
            r0 = r3
            int r0 = r0.length()
            r6 = r0
            r0 = 0
            r5 = r0
        L1a:
            r0 = r5
            r1 = r6
            if (r0 >= r1) goto L7a
            r0 = r3
            r1 = r5
            char r0 = r0.charAt(r1)
            r4 = r0
            r0 = r4
            r1 = 10
            int r0 = java.lang.Character.digit(r0, r1)
            r7 = r0
            r0 = r7
            r1 = -1
            if (r0 == r1) goto L42
            r0 = r8
            r1 = r7
            java.lang.StringBuilder r0 = r0.append(r1)
        L3b:
            r0 = r5
            r1 = 1
            int r0 = r0 + r1
            r5 = r0
            goto L1a
        L42:
            r0 = r8
            int r0 = r0.length()
            if (r0 != 0) goto L5a
            r0 = r4
            r1 = 43
            if (r0 != r1) goto L5a
            r0 = r8
            r1 = r4
            java.lang.StringBuilder r0 = r0.append(r1)
            goto L3b
        L5a:
            r0 = r4
            r1 = 97
            if (r0 < r1) goto L66
            r0 = r4
            r1 = 122(0x7a, float:1.71E-43)
            if (r0 <= r1) goto L72
        L66:
            r0 = r4
            r1 = 65
            if (r0 < r1) goto L3b
            r0 = r4
            r1 = 90
            if (r0 > r1) goto L3b
        L72:
            r0 = r3
            java.lang.String r0 = convertKeypadLettersToDigits(r0)
            java.lang.String r0 = normalizeNumber(r0)
            return r0
        L7a:
            r0 = r8
            java.lang.String r0 = r0.toString()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: android.telephony.PhoneNumberUtils.normalizeNumber(java.lang.String):java.lang.String");
    }

    public static byte[] numberToCalledPartyBCD(String str) {
        return numberToCalledPartyBCDHelper(str, false);
    }

    private static byte[] numberToCalledPartyBCDHelper(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int length = str.length();
        boolean z2 = str.indexOf(43) != -1;
        int i = length;
        if (z2) {
            i = length - 1;
        }
        if (i == 0) {
            return null;
        }
        int i2 = (i + 1) / 2;
        int i3 = 1;
        if (z) {
            i3 = 1 + 1;
        }
        int i4 = i2 + i3;
        byte[] bArr = new byte[i4];
        int i5 = 0;
        int i6 = 0;
        while (true) {
            int i7 = i6;
            if (i7 >= length) {
                break;
            }
            char charAt = str.charAt(i7);
            if (charAt != '+') {
                int i8 = (i5 >> 1) + i3;
                bArr[i8] = (byte) (bArr[i8] | ((byte) ((charToBCD(charAt) & 15) << ((i5 & 1) == 1 ? 4 : 0))));
                i5++;
            }
            i6 = i7 + 1;
        }
        if ((i5 & 1) == 1) {
            int i9 = (i5 >> 1) + i3;
            bArr[i9] = (byte) (bArr[i9] | 240);
        }
        int i10 = 0;
        if (z) {
            bArr[0] = (byte) (i4 - 1);
            i10 = 0 + 1;
        }
        bArr[i10] = (byte) (z2 ? 145 : 129);
        return bArr;
    }

    private static String processPlusCode(String str, boolean z) {
        String str2 = str;
        if (str != null) {
            str2 = str;
            if (str.charAt(0) == '+') {
                str2 = str;
                if (str.length() > 1) {
                    str2 = str.substring(1);
                    if (!z || !isOneNanp(str2)) {
                        RewriteRule cdmaLocalRewriteRule = getCdmaLocalRewriteRule(str, TelephonyManager.getDefault().getNetworkCountryIso(), TelephonyManager.getDefault().getSimCountryIso());
                        return cdmaLocalRewriteRule != null ? cdmaLocalRewriteRule.apply(str) : str.replaceFirst("[+]", getCurrentIdp(z));
                    }
                }
            }
        }
        return str2;
    }

    private static void removeDashes(Editable editable) {
        int i = 0;
        while (i < editable.length()) {
            if (editable.charAt(i) == '-') {
                editable.delete(i, i + 1);
            } else {
                i++;
            }
        }
    }

    public static String replaceUnicodeDigits(String str) {
        StringBuilder sb = new StringBuilder(str.length());
        char[] charArray = str.toCharArray();
        int length = charArray.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return sb.toString();
            }
            char c2 = charArray[i2];
            int digit = Character.digit(c2, 10);
            if (digit != -1) {
                sb.append(digit);
            } else {
                sb.append(c2);
            }
            i = i2 + 1;
        }
    }

    public static void resetCountryDetectorInfo() {
        sCountryDetector = null;
    }

    private static String splitAtNonNumerics(CharSequence charSequence) {
        StringBuilder sb = new StringBuilder(charSequence.length());
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= charSequence.length()) {
                return sb.toString().replaceAll(" +", " ").trim();
            }
            sb.append(isISODigit(charSequence.charAt(i2)) ? Character.valueOf(charSequence.charAt(i2)) : " ");
            i = i2 + 1;
        }
    }

    public static String stringFromStringAndTOA(String str, int i) {
        String str2;
        if (str == null) {
            str2 = null;
        } else {
            str2 = str;
            if (i == 145) {
                str2 = str;
                if (str.length() > 0) {
                    str2 = str;
                    if (str.charAt(0) != '+') {
                        return PLUS_SIGN_STRING + str;
                    }
                }
            }
        }
        return str2;
    }

    public static String stripSeparators(String str) {
        if (str == null) {
            return null;
        }
        int length = str.length();
        StringBuilder sb = new StringBuilder(length);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return sb.toString();
            }
            char charAt = str.charAt(i2);
            int digit = Character.digit(charAt, 10);
            if (digit != -1) {
                sb.append(digit);
            } else if (isNonSeparator(charAt)) {
                sb.append(charAt);
            }
            i = i2 + 1;
        }
    }

    public static String toCallerIDMinMatch(String str) {
        return internalGetStrippedReversed(extractNetworkPortionAlt(str), MIN_MATCH);
    }

    public static int toaFromString(String str) {
        return (str == null || str.length() <= 0 || str.charAt(0) != '+') ? 129 : 145;
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x00ef, code lost:
        return new android.telephony.PhoneNumberUtils.CountryCallingCodeAndNewIndex(r11, r10 + 1);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static android.telephony.PhoneNumberUtils.CountryCallingCodeAndNewIndex tryGetCountryCallingCodeAndNewIndex(java.lang.String r6, boolean r7) {
        /*
            Method dump skipped, instructions count: 318
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.telephony.PhoneNumberUtils.tryGetCountryCallingCodeAndNewIndex(java.lang.String, boolean):android.telephony.PhoneNumberUtils$CountryCallingCodeAndNewIndex");
    }

    private static int tryGetISODigit(char c2) {
        if ('0' > c2 || c2 > '9') {
            return -1;
        }
        return c2 - '0';
    }

    private static int tryGetTrunkPrefixOmittedIndex(String str, int i) {
        int i2;
        int length = str.length();
        while (true) {
            i2 = -1;
            if (i >= length) {
                break;
            }
            char charAt = str.charAt(i);
            if (tryGetISODigit(charAt) < 0) {
                i2 = -1;
                if (isDialable(charAt)) {
                    break;
                }
                i++;
            } else {
                i2 = i + 1;
                break;
            }
        }
        return i2;
    }

    public static CharSequence ttsSpanAsPhoneNumber(CharSequence charSequence) {
        if (charSequence == null) {
            return null;
        }
        Spannable newSpannable = Spannable.Factory.getInstance().newSpannable(charSequence);
        ttsSpanAsPhoneNumber(newSpannable, 0, newSpannable.length());
        return newSpannable;
    }

    public static void ttsSpanAsPhoneNumber(Spannable spannable, int i, int i2) {
        spannable.setSpan(new TtsSpan.TelephoneBuilder().setNumberParts(splitAtNonNumerics(spannable.subSequence(i, i2))).build(), i, i2, 33);
    }
}
