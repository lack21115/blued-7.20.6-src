package com.anythink.expressad.exoplayer.k;

import android.net.Uri;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/k/ae.class */
public final class ae {

    /* renamed from: a  reason: collision with root package name */
    private static final int f4791a = 4;
    private static final int b = 0;

    /* renamed from: c  reason: collision with root package name */
    private static final int f4792c = 1;
    private static final int d = 2;
    private static final int e = 3;

    private ae() {
    }

    private static Uri a(Uri uri, String str) {
        Uri.Builder buildUpon = uri.buildUpon();
        buildUpon.clearQuery();
        for (String str2 : uri.getQueryParameterNames()) {
            if (!str2.equals(str)) {
                for (String str3 : uri.getQueryParameters(str2)) {
                    buildUpon.appendQueryParameter(str2, str3);
                }
            }
        }
        return buildUpon.build();
    }

    private static Uri a(String str, String str2) {
        String a2;
        StringBuilder sb = new StringBuilder();
        String str3 = str;
        if (str == null) {
            str3 = "";
        }
        String str4 = str2;
        if (str2 == null) {
            str4 = "";
        }
        int[] a3 = a(str4);
        if (a3[0] != -1) {
            sb.append(str4);
            a(sb, a3[1], a3[2]);
            a2 = sb.toString();
        } else {
            int[] a4 = a(str3);
            if (a3[3] == 0) {
                sb.append((CharSequence) str3, 0, a4[3]);
                sb.append(str4);
                a2 = sb.toString();
            } else if (a3[2] == 0) {
                sb.append((CharSequence) str3, 0, a4[2]);
                sb.append(str4);
                a2 = sb.toString();
            } else if (a3[1] != 0) {
                int i = a4[0] + 1;
                sb.append((CharSequence) str3, 0, i);
                sb.append(str4);
                a2 = a(sb, a3[1] + i, i + a3[2]);
            } else if (str4.charAt(a3[1]) == '/') {
                sb.append((CharSequence) str3, 0, a4[1]);
                sb.append(str4);
                a2 = a(sb, a4[1], a4[1] + a3[2]);
            } else if (a4[0] + 2 >= a4[1] || a4[1] != a4[2]) {
                int lastIndexOf = str3.lastIndexOf(47, a4[2] - 1);
                int i2 = lastIndexOf == -1 ? a4[1] : lastIndexOf + 1;
                sb.append((CharSequence) str3, 0, i2);
                sb.append(str4);
                a2 = a(sb, a4[1], i2 + a3[2]);
            } else {
                sb.append((CharSequence) str3, 0, a4[1]);
                sb.append('/');
                sb.append(str4);
                a2 = a(sb, a4[1], a4[1] + a3[2] + 1);
            }
        }
        return Uri.parse(a2);
    }

    private static String a(StringBuilder sb, int i, int i2) {
        int i3;
        int i4;
        if (i >= i2) {
            return sb.toString();
        }
        int i5 = i;
        if (sb.charAt(i) == '/') {
            i5 = i + 1;
        }
        int i6 = i5;
        int i7 = i2;
        int i8 = i6;
        while (i6 <= i7) {
            if (i6 == i7) {
                i3 = i6;
            } else if (sb.charAt(i6) == '/') {
                i3 = i6 + 1;
            } else {
                i6++;
            }
            int i9 = i8 + 1;
            if (i6 == i9 && sb.charAt(i8) == '.') {
                sb.delete(i8, i3);
                i4 = i3 - i8;
            } else if (i6 == i8 + 2 && sb.charAt(i8) == '.' && sb.charAt(i9) == '.') {
                i8 = sb.lastIndexOf("/", i8 - 2) + 1;
                int i10 = i8 > i5 ? i8 : i5;
                sb.delete(i10, i3);
                i4 = i3 - i10;
            } else {
                i8 = i6 + 1;
                i6 = i8;
            }
            i7 -= i4;
            i6 = i8;
        }
        return sb.toString();
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x003a, code lost:
        if (r0 > r7) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0053, code lost:
        if (r0 > r6) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00b1, code lost:
        if (r0 > r6) goto L35;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int[] a(java.lang.String r5) {
        /*
            Method dump skipped, instructions count: 214
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.exoplayer.k.ae.a(java.lang.String):int[]");
    }

    private static String b(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        String str3 = str;
        if (str == null) {
            str3 = "";
        }
        String str4 = str2;
        if (str2 == null) {
            str4 = "";
        }
        int[] a2 = a(str4);
        if (a2[0] != -1) {
            sb.append(str4);
            a(sb, a2[1], a2[2]);
            return sb.toString();
        }
        int[] a3 = a(str3);
        if (a2[3] == 0) {
            sb.append((CharSequence) str3, 0, a3[3]);
            sb.append(str4);
            return sb.toString();
        } else if (a2[2] == 0) {
            sb.append((CharSequence) str3, 0, a3[2]);
            sb.append(str4);
            return sb.toString();
        } else if (a2[1] != 0) {
            int i = a3[0] + 1;
            sb.append((CharSequence) str3, 0, i);
            sb.append(str4);
            return a(sb, a2[1] + i, i + a2[2]);
        } else if (str4.charAt(a2[1]) == '/') {
            sb.append((CharSequence) str3, 0, a3[1]);
            sb.append(str4);
            return a(sb, a3[1], a3[1] + a2[2]);
        } else if (a3[0] + 2 < a3[1] && a3[1] == a3[2]) {
            sb.append((CharSequence) str3, 0, a3[1]);
            sb.append('/');
            sb.append(str4);
            return a(sb, a3[1], a3[1] + a2[2] + 1);
        } else {
            int lastIndexOf = str3.lastIndexOf(47, a3[2] - 1);
            int i2 = lastIndexOf == -1 ? a3[1] : lastIndexOf + 1;
            sb.append((CharSequence) str3, 0, i2);
            sb.append(str4);
            return a(sb, a3[1], i2 + a2[2]);
        }
    }
}
