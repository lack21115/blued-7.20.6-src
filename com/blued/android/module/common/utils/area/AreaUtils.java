package com.blued.android.module.common.utils.area;

import android.text.TextUtils;
import androidx.collection.ArrayMap;
import com.blued.android.core.AppInfo;
import com.blued.android.core.BlueAppLocal;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.module.common.R;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Pattern;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/utils/area/AreaUtils.class */
public class AreaUtils {
    public static Map<String, String> areasCode = new ArrayMap();
    public static Map<String, String> areasName = new ArrayMap();
    public static Map<String, String> areasCodeIn3 = new ArrayMap();
    public static Map<String, String> areasCodeIn2 = new ArrayMap();
    public static Map<String, String> areasCodeIn1 = new ArrayMap();
    public static String localeLanguage = "";
    public static String localeCountry = "";

    public static String getAreaCode(List<AreaCode> list) {
        String country = BlueAppLocal.c().getCountry();
        for (AreaCode areaCode : list) {
            if (areaCode.getAbbr() != null && country.toUpperCase().equals(areaCode.getAbbr().toUpperCase())) {
                return areaCode.getCode();
            }
        }
        return "";
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x0103 A[Catch: IOException -> 0x0118, TRY_ENTER, TRY_LEAVE, TryCatch #0 {IOException -> 0x0118, blocks: (B:53:0x00f8, B:56:0x0103), top: B:66:0x00f8 }] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00f8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.List<com.blued.android.module.common.utils.area.AreaCode> getAreaCodeList() {
        /*
            Method dump skipped, instructions count: 284
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.common.utils.area.AreaUtils.getAreaCodeList():java.util.List");
    }

    public static List<Country> getAreaSubList(String str) {
        ArrayList arrayList = new ArrayList();
        if (!StringUtils.b(str)) {
            String replace = str.replace("\\s", "").replace("\n", "");
            if (areasCode.isEmpty() || !BlueAppLocal.c().getLanguage().equals(localeLanguage) || !BlueAppLocal.c().getCountry().equals(localeCountry)) {
                initArea();
            }
            String str2 = "";
            for (Map.Entry<String, String> entry : areasCode.entrySet()) {
                String obj = entry.getKey().toString();
                String obj2 = entry.getValue().toString();
                if (obj.indexOf(replace) == 0) {
                    if (!obj.equals(replace + "0000")) {
                        if (replace.split(BridgeUtil.UNDERLINE_STR).length == 2) {
                            if (obj2.contains(BridgeUtil.UNDERLINE_STR) && obj2.split(BridgeUtil.UNDERLINE_STR).length >= 3) {
                                String str3 = obj2.split(BridgeUtil.UNDERLINE_STR)[2];
                                Country country = new Country(str3, obj, "", "", "", 0);
                                if ("0000".equals(obj.substring(obj.length() - 4))) {
                                    country.has_child = "0";
                                    country.nation_code = obj;
                                } else {
                                    country.has_child = "1";
                                    country.nation_code = obj.substring(0, 8);
                                }
                                if (str2.contains(str3)) {
                                    for (int i = 0; i < arrayList.size(); i++) {
                                        if (((Country) arrayList.get(i)).nation.equals(str3) && ((Country) arrayList.get(i)).has_child.equals("0") && country.has_child.equals("1")) {
                                            ((Country) arrayList.get(i)).has_child = country.has_child;
                                            ((Country) arrayList.get(i)).nation_code = country.nation_code;
                                        }
                                    }
                                } else {
                                    str2 = str2 + ";" + str3;
                                    arrayList.add(country);
                                }
                            }
                        } else if (obj2.split(BridgeUtil.UNDERLINE_STR).length == 4) {
                            String str4 = obj2.split(BridgeUtil.UNDERLINE_STR)[3];
                            str2 = str2 + ";" + str4;
                            arrayList.add(new Country(str4, obj, "", "", "", 0));
                        } else if (obj2.split(BridgeUtil.UNDERLINE_STR).length == 3) {
                            String str5 = obj2.split(BridgeUtil.UNDERLINE_STR)[2];
                            str2 = str2 + ";" + str5;
                            arrayList.add(new Country(str5, obj, "", "", "", 0));
                        }
                    }
                }
            }
        }
        Collections.sort(arrayList, new Comparator<Country>() { // from class: com.blued.android.module.common.utils.area.AreaUtils.1
            @Override // java.util.Comparator
            public int compare(Country country2, Country country3) {
                return country2.nation_code.compareTo(country3.nation_code);
            }
        });
        return arrayList;
    }

    public static String getAreaTxt(String str, Locale locale) {
        return getAreaTxt(str, locale, false);
    }

    public static String getAreaTxt(String str, Locale locale, boolean z) {
        String str2;
        if (StringUtils.b(str)) {
            return AppInfo.d().getResources().getString(R.string.unknown_area);
        }
        String str3 = str;
        if (str.contains("999_000000")) {
            str3 = "1_999_000000";
        }
        String replace = str3.replace("\\s", "").replace("\n", "");
        if (areasCode.size() <= 0 || !TextUtils.equals(locale.getLanguage(), localeLanguage) || !TextUtils.equals(locale.getCountry(), localeCountry)) {
            initArea();
        }
        if (!Pattern.compile("^[0-9]{1}_[0-9]{3}_[0-9a-zA-Z]{6}$").matcher(replace).matches()) {
            return replace;
        }
        String string = AppInfo.d().getResources().getString(R.string.unknown_area);
        if (areasCode.containsKey(replace)) {
            str2 = areasCode.get(replace);
        } else if (replace.length() >= 8 && areasCodeIn3.containsKey(replace.substring(0, 8))) {
            str2 = areasCodeIn3.get(replace.substring(0, 8));
        } else if (replace.length() < 5 || !areasCodeIn2.containsKey(replace.substring(0, 5))) {
            str2 = string;
            if (replace.length() >= 1) {
                str2 = string;
                if (areasCodeIn1.containsKey(replace.substring(0, 1))) {
                    str2 = areasCodeIn1.get(replace.substring(0, 1));
                }
            }
        } else {
            str2 = areasCodeIn2.get(replace.substring(0, 5));
        }
        if (!str2.contains(BridgeUtil.UNDERLINE_STR)) {
            return str2;
        }
        String[] split = str2.split(BridgeUtil.UNDERLINE_STR);
        if (split.length == 2) {
            return split[1];
        }
        if (split.length < 3) {
            return split[0];
        }
        if (UserInfo.getInstance() != null && UserInfo.getInstance().getLoginUserInfo() != null && judgeSameCountry(replace, UserInfo.getInstance().getLoginUserInfo().getCity_settled())) {
            if ("en".equals(BlueAppLocal.c().getLanguage())) {
                return split[split.length - 1] + " " + split[split.length - 2];
            }
            return split[split.length - 2] + " " + split[split.length - 1];
        } else if (!"en".equals(BlueAppLocal.c().getLanguage())) {
            if (!z) {
                return split[1] + " " + split[2];
            }
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 1; i < split.length; i++) {
                stringBuffer.append(" " + split[i]);
            }
            return stringBuffer.toString();
        } else if (!z) {
            return split[2] + " " + split[1];
        } else {
            StringBuffer stringBuffer2 = new StringBuffer();
            int length = split.length;
            while (true) {
                int i2 = length - 1;
                if (i2 < 1) {
                    return stringBuffer2.toString();
                }
                stringBuffer2.append(" " + split[i2]);
                length = i2;
            }
        }
    }

    public static String getCityTxt(String str, Locale locale) {
        String str2;
        if (StringUtils.b(str)) {
            return null;
        }
        String str3 = str;
        if (str.contains("999_000000")) {
            str3 = "1_999_000000";
        }
        String replace = str3.replace("\\s", "").replace("\n", "");
        Map<String, String> zhAreasCode = getZhAreasCode();
        if (Pattern.compile("^[0-9]{1}_[0-9]{3}_[0-9a-zA-Z]{6}$").matcher(replace).matches()) {
            String string = AppInfo.d().getResources().getString(R.string.unknown_area);
            if (zhAreasCode.containsKey(replace)) {
                str2 = zhAreasCode.get(replace);
            } else if (replace.length() >= 8 && areasCodeIn3.containsKey(replace.substring(0, 8))) {
                str2 = areasCodeIn3.get(replace.substring(0, 8));
            } else if (replace.length() < 5 || !areasCodeIn2.containsKey(replace.substring(0, 5))) {
                str2 = string;
                if (replace.length() >= 1) {
                    str2 = string;
                    if (areasCodeIn1.containsKey(replace.substring(0, 1))) {
                        str2 = areasCodeIn1.get(replace.substring(0, 1));
                    }
                }
            } else {
                str2 = areasCodeIn2.get(replace.substring(0, 5));
            }
            if (str2.contains(BridgeUtil.UNDERLINE_STR)) {
                String[] split = str2.split(BridgeUtil.UNDERLINE_STR);
                return split.length == 2 ? split[1] : split.length >= 3 ? split[split.length - 1] : split[0];
            }
            return null;
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x010d A[Catch: IOException -> 0x0122, TRY_ENTER, TRY_LEAVE, TryCatch #6 {IOException -> 0x0122, blocks: (B:53:0x0102, B:56:0x010d), top: B:70:0x0102 }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0102 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.List<com.blued.android.module.common.utils.area.Country> getCountryCodeList() {
        /*
            Method dump skipped, instructions count: 294
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.common.utils.area.AreaUtils.getCountryCodeList():java.util.List");
    }

    /* JADX WARN: Removed duplicated region for block: B:64:0x0183 A[Catch: IOException -> 0x01be, TRY_ENTER, TRY_LEAVE, TryCatch #10 {IOException -> 0x01be, blocks: (B:61:0x0178, B:64:0x0183), top: B:92:0x0178 }] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0178 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.util.Map<java.lang.String, java.lang.String> getZhAreasCode() {
        /*
            Method dump skipped, instructions count: 454
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.common.utils.area.AreaUtils.getZhAreasCode():java.util.Map");
    }

    /* JADX WARN: Removed duplicated region for block: B:111:0x03ae A[Catch: IOException -> 0x0406, TRY_ENTER, TRY_LEAVE, TryCatch #3 {IOException -> 0x0406, blocks: (B:108:0x03a2, B:111:0x03ae), top: B:142:0x03a2 }] */
    /* JADX WARN: Removed duplicated region for block: B:142:0x03a2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void initArea() {
        /*
            Method dump skipped, instructions count: 1038
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.common.utils.area.AreaUtils.initArea():void");
    }

    private static boolean judgeSameCountry(String str, String str2) {
        return !StringUtils.b(str) && !StringUtils.b(str2) && str.length() >= 5 && str2.length() >= 5 && str.substring(0, 5).equals(str2.substring(0, 5));
    }
}
