package com.mokee.google;

import android.content.Context;
import android.location.Country;
import android.location.CountryDetector;
import android.location.CountryListener;
import android.os.Looper;
import com.android.i18n.phonenumbers.NumberParseException;
import com.android.i18n.phonenumbers.PhoneNumberUtil;
import com.android.i18n.phonenumbers.Phonenumber;
import com.android.i18n.phonenumbers.geocoding.PhoneNumberOfflineGeocoder;
import com.mokee.volley.VolleyError;
import java.util.Locale;

/* loaded from: source-4181928-dex2jar.jar:com/mokee/google/OfflineNumber.class */
public class OfflineNumber {
    private static PhoneNumberOfflineGeocoder a;
    private static String b;
    private static PhoneNumberUtil c;
    public static int d;
    private static final String e;

    /* loaded from: source-4181928-dex2jar.jar:com/mokee/google/OfflineNumber$a.class */
    class a implements CountryListener {
        a() {
        }

        public void onCountryDetected(Country country) {
            OfflineNumber.b = country.getCountryIso();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x005c, code lost:
        r0 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0061, code lost:
        r7 = r6;
        r11 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0067, code lost:
        r10 = r11;
        r6 = r7;
        r5 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0071, code lost:
        if (r7 > r8) goto L3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0074, code lost:
        com.mokee.google.OfflineNumber.e = new java.lang.String(r11).intern();
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0083, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0084, code lost:
        r5 = 17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x008a, code lost:
        r5 = 'X';
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0090, code lost:
        r5 = '^';
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0096, code lost:
        r5 = 'H';
     */
    /* JADX WARN: Code restructure failed: missing block: B:3:0x0017, code lost:
        if (r6 <= 1) goto L3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x001a, code lost:
        r8 = r5;
        r0 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x001e, code lost:
        r7 = r0;
        r0 = r10;
        r0 = r0[r7];
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x002b, code lost:
        switch((r8 % 5)) {
            case 0: goto L12;
            case 1: goto L13;
            case 2: goto L14;
            case 3: goto L15;
            default: goto L6;
        };
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0048, code lost:
        r5 = 'D';
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x004b, code lost:
        r0[r7] = (char) (r5 ^ r0);
        r8 = r8 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0059, code lost:
        if (r6 != 0) goto L10;
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x0071 -> B:4:0x001a). Please submit an issue!!! */
    static {
        /*
            java.lang.String r0 = "r7+&0c!\u0001,!e==<+c"
            char[] r0 = r0.toCharArray()
            r10 = r0
            r0 = r10
            int r0 = r0.length
            r6 = r0
            r0 = 0
            r8 = r0
            r0 = 0
            r5 = r0
            r0 = r10
            r11 = r0
            r0 = r6
            r7 = r0
            r0 = r6
            r1 = 1
            if (r0 > r1) goto L67
        L1a:
            r0 = r5
            r8 = r0
            r0 = r5
            r7 = r0
        L1e:
            r0 = r10
            r11 = r0
            r0 = r11
            r1 = r7
            char r0 = r0[r1]
            r9 = r0
            r0 = r8
            r1 = 5
            int r0 = r0 % r1
            switch(r0) {
                case 0: goto L84;
                case 1: goto L8a;
                case 2: goto L90;
                case 3: goto L96;
                default: goto L48;
            }
        L48:
            r0 = 68
            r5 = r0
        L4b:
            r0 = r11
            r1 = r7
            r2 = r5
            r3 = r9
            r2 = r2 ^ r3
            char r2 = (char) r2
            r0[r1] = r2
            r0 = r8
            r1 = 1
            int r0 = r0 + r1
            r8 = r0
            r0 = r6
            if (r0 != 0) goto L61
            r0 = r6
            r7 = r0
            goto L1e
        L61:
            r0 = r6
            r7 = r0
            r0 = r10
            r11 = r0
        L67:
            r0 = r11
            r10 = r0
            r0 = r7
            r6 = r0
            r0 = r8
            r5 = r0
            r0 = r7
            r1 = r8
            if (r0 > r1) goto L1a
            java.lang.String r0 = new java.lang.String
            r1 = r0
            r2 = r11
            r1.<init>(r2)
            java.lang.String r0 = r0.intern()
            com.mokee.google.OfflineNumber.e = r0
            return
        L84:
            r0 = 17
            r5 = r0
            goto L4b
        L8a:
            r0 = 88
            r5 = r0
            goto L4b
        L90:
            r0 = 94
            r5 = r0
            goto L4b
        L96:
            r0 = 72
            r5 = r0
            goto L4b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mokee.google.OfflineNumber.m11269clinit():void");
    }

    private static Phonenumber.PhoneNumber a(String str, String str2) {
        try {
            return b().parse(str, str2);
        } catch (NumberParseException e2) {
            return null;
        }
    }

    private static PhoneNumberOfflineGeocoder a() {
        PhoneNumberOfflineGeocoder phoneNumberOfflineGeocoder;
        synchronized (OfflineNumber.class) {
            try {
                if (a == null) {
                    a = PhoneNumberOfflineGeocoder.getInstance();
                }
                phoneNumberOfflineGeocoder = a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return phoneNumberOfflineGeocoder;
    }

    private static PhoneNumberUtil b() {
        PhoneNumberUtil phoneNumberUtil;
        synchronized (OfflineNumber.class) {
            try {
                if (c == null) {
                    c = PhoneNumberUtil.getInstance();
                }
                phoneNumberUtil = c;
            } catch (Throwable th) {
                throw th;
            }
        }
        return phoneNumberUtil;
    }

    public static String getCurrentCountryIso(Context context) {
        String str;
        synchronized (OfflineNumber.class) {
            try {
                int i = d;
                CountryDetector countryDetector = (CountryDetector) context.getSystemService(e);
                Country country = null;
                if (countryDetector != null) {
                    country = countryDetector.detectCountry();
                }
                if (country == null) {
                    str = Locale.getDefault().getCountry();
                } else {
                    b = country.getCountryIso();
                    countryDetector.addCountryListener(new a(), Looper.getMainLooper());
                    String str2 = b;
                    str = str2;
                    if (i != 0) {
                        VolleyError.b = !VolleyError.b;
                        str = str2;
                    }
                }
            } finally {
            }
        }
        return str;
    }

    public static String getGeocodedLocationFor(String str, String str2, Locale locale) {
        String str3;
        int i = d;
        Phonenumber.PhoneNumber a2 = a(str, str2);
        if (a2 != null) {
            str3 = a().getDescriptionForNumber(a2, locale);
        } else {
            str3 = null;
            if (VolleyError.b) {
                d = i + 1;
                return null;
            }
        }
        return str3;
    }
}
