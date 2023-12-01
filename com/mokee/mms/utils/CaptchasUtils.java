package com.mokee.mms.utils;

import com.mokee.volley.VolleyError;
import java.util.regex.Pattern;

/* loaded from: source-4181928-dex2jar.jar:com/mokee/mms/utils/CaptchasUtils.class */
public class CaptchasUtils {

    /* renamed from: a  reason: collision with root package name */
    private static final String[] f24220a = null;
    public static int b;

    /* renamed from: c  reason: collision with root package name */
    private static String[] f24221c;
    private static String[] d;
    private static String[] e;
    private static String[] f;
    private static String[] g;

    static {
        String[] strArr = new String[14];
        throw new VerifyError("bad dex opcode");
    }

    private static int a(String str) {
        if (str.matches(f24220a[8])) {
            return 2;
        }
        return str.matches(f24220a[7]) ? 0 : 1;
    }

    private static String a(String str, String str2, String str3) {
        if (str3.equals(f24220a[1])) {
            str = f24220a[6];
        }
        if (str3.equals(f24220a[2])) {
            str = f24220a[5];
        }
        if (str3.equals(f24220a[3])) {
            str = f24220a[4];
        }
        return str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x006e, code lost:
        r0 = r0[r13];
        r0 = r7.substring(r11, r12);
        r17 = r11;
        r16 = r12;
        r15 = r13;
        r23 = r21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0096, code lost:
        if (r0.contains(r0) == false) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0099, code lost:
        r14 = true;
        r16 = true;
        r0 = com.mokee.mms.utils.CaptchasUtils.f24221c.length;
        r15 = 0;
        r17 = 0;
        r8 = r11;
        r9 = r12;
        r10 = r13;
        r22 = r21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x00bf, code lost:
        if (r0 == 0) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x00c2, code lost:
        r14 = r16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x00e1, code lost:
        if (r0.contains(java.lang.String.valueOf(r0[r17]) + r6) == false) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x00e4, code lost:
        r14 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x00e7, code lost:
        r15 = r17 + 1;
        r22 = r21;
        r10 = r13;
        r9 = r12;
        r8 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x00fb, code lost:
        r11 = r8;
        r12 = r9;
        r13 = r10;
        r21 = r22;
        r17 = r15;
        r16 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0115, code lost:
        if (r15 < r0) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0118, code lost:
        r17 = r8;
        r16 = r9;
        r15 = r10;
        r23 = r22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0128, code lost:
        if (r14 == false) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x012b, code lost:
        r0 = com.mokee.mms.utils.CaptchasUtils.e.length;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0137, code lost:
        if (r0 == 0) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x013a, code lost:
        r15 = 0;
        r11 = r9;
        r12 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0143, code lost:
        r21 = r22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0166, code lost:
        if (r0.contains(java.lang.String.valueOf(r6) + r0[r15]) != false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0169, code lost:
        r8 = r12;
        r9 = r11;
        r13 = r10;
        r21 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x017f, code lost:
        if (r0 == 0) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0182, code lost:
        r21 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0186, code lost:
        r14 = r15 + 1;
        r13 = r10;
        r9 = r11;
        r8 = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0196, code lost:
        r12 = r8;
        r11 = r9;
        r10 = r13;
        r15 = r14;
        r22 = r21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x01ac, code lost:
        if (r14 < r0) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x01af, code lost:
        r10 = r13 + 1;
        r22 = r21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x01b9, code lost:
        r11 = r8;
        r12 = r9;
        r13 = r10;
        r21 = r22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x01cb, code lost:
        if (r10 < r0) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x01d3, code lost:
        return r22.booleanValue();
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x01d4, code lost:
        r21 = r22;
        r14 = 0;
        r13 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x01e2, code lost:
        r21 = r23;
        r8 = r17;
        r9 = r16;
        r13 = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x006b, code lost:
        if (r0 != 0) goto L9;
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0115 -> B:14:0x00c2). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x01ac -> B:25:0x0143). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x01cb -> B:10:0x006e). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean a(java.lang.String r6, java.lang.String r7) {
        /*
            Method dump skipped, instructions count: 499
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mokee.mms.utils.CaptchasUtils.a(java.lang.String, java.lang.String):boolean");
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:56)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:30)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:18)
        */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00b0  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x00ad -> B:11:0x006b). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean b(java.lang.String r4, java.lang.String r5) {
        /*
            Method dump skipped, instructions count: 190
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mokee.mms.utils.CaptchasUtils.b(java.lang.String, java.lang.String):boolean");
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:56)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:30)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:18)
        */
    /* JADX WARN: Removed duplicated region for block: B:13:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0114  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x00ec -> B:16:0x008b). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x0102 -> B:11:0x005a). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean c(java.lang.String r4, java.lang.String r5) {
        /*
            Method dump skipped, instructions count: 297
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mokee.mms.utils.CaptchasUtils.c(java.lang.String, java.lang.String):boolean");
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:56)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:30)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:18)
        */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0053  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0050 -> B:8:0x0023). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x008e -> B:19:0x0066). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x00cc -> B:29:0x00a4). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String getCaptchaProvider(java.lang.String r4, java.lang.String r5) {
        /*
            int r0 = com.mokee.mms.utils.CaptchasUtils.b
            r6 = r0
            java.lang.String[] r0 = com.mokee.mms.utils.CaptchasUtils.f24220a
            r1 = 10
            r0 = r0[r1]
            java.util.regex.Pattern r0 = java.util.regex.Pattern.compile(r0)
            r1 = r4
            java.util.regex.Matcher r0 = r0.matcher(r1)
            r8 = r0
            r0 = r6
            if (r0 == 0) goto L4b
            boolean r0 = com.mokee.volley.VolleyError.b
            if (r0 == 0) goto L46
            r0 = 0
            r7 = r0
        L1f:
            r0 = r7
            com.mokee.volley.VolleyError.b = r0
        L23:
            r0 = r8
            r1 = 1
            java.lang.String r0 = r0.group(r1)
            if (r0 == 0) goto L4b
            r0 = r8
            r1 = 1
            java.lang.String r0 = r0.group(r1)
            int r0 = r0.length()
            r1 = 10
            if (r0 >= r1) goto L4b
            r0 = r8
            r1 = 1
            java.lang.String r0 = r0.group(r1)
            r1 = r4
            r2 = r5
            java.lang.String r0 = a(r0, r1, r2)
            return r0
        L46:
            r0 = 1
            r7 = r0
            goto L1f
        L4b:
            r0 = r8
            boolean r0 = r0.find()
            if (r0 != 0) goto L23
            java.lang.String[] r0 = com.mokee.mms.utils.CaptchasUtils.f24220a
            r1 = 11
            r0 = r0[r1]
            java.util.regex.Pattern r0 = java.util.regex.Pattern.compile(r0)
            r1 = r4
            java.util.regex.Matcher r0 = r0.matcher(r1)
            r8 = r0
            r0 = r6
            if (r0 == 0) goto L89
        L66:
            r0 = r8
            r1 = 1
            java.lang.String r0 = r0.group(r1)
            if (r0 == 0) goto L89
            r0 = r8
            r1 = 1
            java.lang.String r0 = r0.group(r1)
            int r0 = r0.length()
            r1 = 10
            if (r0 >= r1) goto L89
            r0 = r8
            r1 = 1
            java.lang.String r0 = r0.group(r1)
            r1 = r4
            r2 = r5
            java.lang.String r0 = a(r0, r1, r2)
            return r0
        L89:
            r0 = r8
            boolean r0 = r0.find()
            if (r0 != 0) goto L66
            java.lang.String[] r0 = com.mokee.mms.utils.CaptchasUtils.f24220a
            r1 = 12
            r0 = r0[r1]
            java.util.regex.Pattern r0 = java.util.regex.Pattern.compile(r0)
            r1 = r4
            java.util.regex.Matcher r0 = r0.matcher(r1)
            r8 = r0
            r0 = r6
            if (r0 == 0) goto Lc7
        La4:
            r0 = r8
            r1 = 1
            java.lang.String r0 = r0.group(r1)
            if (r0 == 0) goto Lc7
            r0 = r8
            r1 = 1
            java.lang.String r0 = r0.group(r1)
            int r0 = r0.length()
            r1 = 10
            if (r0 >= r1) goto Lc7
            r0 = r8
            r1 = 1
            java.lang.String r0 = r0.group(r1)
            r1 = r4
            r2 = r5
            java.lang.String r0 = a(r0, r1, r2)
            return r0
        Lc7:
            r0 = r8
            boolean r0 = r0.find()
            if (r0 != 0) goto La4
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mokee.mms.utils.CaptchasUtils.getCaptchaProvider(java.lang.String, java.lang.String):java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x004a, code lost:
        if (r5 < r0) goto L3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x004d, code lost:
        r10 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0056, code lost:
        return r10.booleanValue();
     */
    /* JADX WARN: Code restructure failed: missing block: B:3:0x001d, code lost:
        if (r0 != 0) goto L3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x0020, code lost:
        r9 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x002c, code lost:
        if (r4.contains(r0[r6]) == false) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x002f, code lost:
        r9 = true;
        r10 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x003a, code lost:
        if (r0 == 0) goto L7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x003d, code lost:
        r5 = r6 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0041, code lost:
        r6 = r5;
        r10 = r9;
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x004a -> B:4:0x0020). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean isCaptchasEnMessage(java.lang.String r4) {
        /*
            r0 = 0
            r5 = r0
            r0 = 0
            r6 = r0
            int r0 = com.mokee.mms.utils.CaptchasUtils.b
            r7 = r0
            r0 = 0
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            r10 = r0
            java.lang.String[] r0 = com.mokee.mms.utils.CaptchasUtils.d
            r11 = r0
            r0 = r11
            int r0 = r0.length
            r8 = r0
            r0 = r10
            r9 = r0
            r0 = r7
            if (r0 == 0) goto L41
        L20:
            r0 = r10
            r9 = r0
            r0 = r4
            r1 = r11
            r2 = r6
            r1 = r1[r2]
            boolean r0 = r0.contains(r1)
            if (r0 == 0) goto L3d
            r0 = 1
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            r9 = r0
            r0 = r9
            r10 = r0
            r0 = r7
            if (r0 == 0) goto L51
        L3d:
            r0 = r6
            r1 = 1
            int r0 = r0 + r1
            r5 = r0
        L41:
            r0 = r5
            r6 = r0
            r0 = r9
            r10 = r0
            r0 = r5
            r1 = r8
            if (r0 < r1) goto L20
            r0 = r9
            r10 = r0
        L51:
            r0 = r10
            boolean r0 = r0.booleanValue()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mokee.mms.utils.CaptchasUtils.isCaptchasEnMessage(java.lang.String):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x004a, code lost:
        if (r5 < r0) goto L3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x004d, code lost:
        r10 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0056, code lost:
        return r10.booleanValue();
     */
    /* JADX WARN: Code restructure failed: missing block: B:3:0x001d, code lost:
        if (r0 != 0) goto L3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x0020, code lost:
        r9 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x002c, code lost:
        if (r4.contains(r0[r6]) == false) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x002f, code lost:
        r9 = true;
        r10 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x003a, code lost:
        if (r0 == 0) goto L7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x003d, code lost:
        r5 = r6 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0041, code lost:
        r6 = r5;
        r10 = r9;
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x004a -> B:4:0x0020). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean isCaptchasMessage(java.lang.String r4) {
        /*
            r0 = 0
            r5 = r0
            r0 = 0
            r6 = r0
            int r0 = com.mokee.mms.utils.CaptchasUtils.b
            r7 = r0
            r0 = 0
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            r10 = r0
            java.lang.String[] r0 = com.mokee.mms.utils.CaptchasUtils.g
            r11 = r0
            r0 = r11
            int r0 = r0.length
            r8 = r0
            r0 = r10
            r9 = r0
            r0 = r7
            if (r0 == 0) goto L41
        L20:
            r0 = r10
            r9 = r0
            r0 = r4
            r1 = r11
            r2 = r6
            r1 = r1[r2]
            boolean r0 = r0.contains(r1)
            if (r0 == 0) goto L3d
            r0 = 1
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            r9 = r0
            r0 = r9
            r10 = r0
            r0 = r7
            if (r0 == 0) goto L51
        L3d:
            r0 = r6
            r1 = 1
            int r0 = r0 + r1
            r5 = r0
        L41:
            r0 = r5
            r6 = r0
            r0 = r9
            r10 = r0
            r0 = r5
            r1 = r8
            if (r0 < r1) goto L20
            r0 = r9
            r10 = r0
        L51:
            r0 = r10
            boolean r0 = r0.booleanValue()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mokee.mms.utils.CaptchasUtils.isCaptchasMessage(java.lang.String):boolean");
    }

    public static boolean isChineseContains(String str) {
        int i = b;
        if ((Pattern.compile(f24220a[13]).matcher(str).find()) || str.contains("【") || str.contains("】") || str.contains("。")) {
            if (VolleyError.b) {
                b = i + 1;
                return true;
            }
            return true;
        }
        return false;
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:56)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:30)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:18)
        */
    /* JADX WARN: Removed duplicated region for block: B:17:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0028  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0080 -> B:5:0x001c). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String tryToGetCnCaptchas(java.lang.String r3) {
        /*
            int r0 = com.mokee.mms.utils.CaptchasUtils.b
            r4 = r0
            java.lang.String[] r0 = com.mokee.mms.utils.CaptchasUtils.f24220a
            r1 = 9
            r0 = r0[r1]
            java.util.regex.Pattern r0 = java.util.regex.Pattern.compile(r0)
            r1 = r3
            java.util.regex.Matcher r0 = r0.matcher(r1)
            r7 = r0
            java.lang.String r0 = ""
            r6 = r0
            r0 = r4
            if (r0 == 0) goto L8b
            r0 = -1
            r4 = r0
        L1c:
            r0 = r7
            java.lang.String r0 = r0.group()
            int r0 = r0.length()
            r1 = 3
            if (r0 <= r1) goto L85
            r0 = r7
            java.lang.String r0 = r0.group()
            int r0 = r0.length()
            r1 = 8
            if (r0 >= r1) goto L85
            r0 = r7
            java.lang.String r0 = r0.group()
            java.lang.String r1 = "."
            boolean r0 = r0.contains(r1)
            if (r0 != 0) goto L85
            r0 = r7
            java.lang.String r0 = r0.group()
            r1 = r3
            boolean r0 = a(r0, r1)
            if (r0 != 0) goto L5a
            r0 = r7
            java.lang.String r0 = r0.group()
            r1 = r3
            boolean r0 = c(r0, r1)
            if (r0 == 0) goto L85
        L5a:
            r0 = r4
            r1 = -1
            if (r0 != r1) goto L65
            r0 = r7
            java.lang.String r0 = r0.group()
            r6 = r0
        L65:
            r0 = r7
            java.lang.String r0 = r0.group()
            int r0 = a(r0)
            r5 = r0
            r0 = r5
            r1 = r4
            if (r0 <= r1) goto L79
            r0 = r7
            java.lang.String r0 = r0.group()
            r6 = r0
        L79:
            r0 = r5
            r4 = r0
        L7b:
            r0 = r7
            boolean r0 = r0.find()
            if (r0 != 0) goto L88
            r0 = r6
            return r0
        L85:
            goto L7b
        L88:
            goto L1c
        L8b:
            java.lang.String r0 = ""
            r6 = r0
            r0 = -1
            r4 = r0
            goto L7b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mokee.mms.utils.CaptchasUtils.tryToGetCnCaptchas(java.lang.String):java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0040, code lost:
        if (b(r0.group(), r3) == false) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0047, code lost:
        return r0.group();
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x004c, code lost:
        if (r0.find() != false) goto L3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x004f, code lost:
        return "";
     */
    /* JADX WARN: Code restructure failed: missing block: B:3:0x0012, code lost:
        if (r0 != 0) goto L3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x001d, code lost:
        if (r0.group().length() <= 3) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0029, code lost:
        if (r0.group().length() >= 8) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0035, code lost:
        if (r0.group().contains(".") != false) goto L14;
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x004c -> B:4:0x0015). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String tryToGetEnCaptchas(java.lang.String r3) {
        /*
            int r0 = com.mokee.mms.utils.CaptchasUtils.b
            r4 = r0
            java.lang.String[] r0 = com.mokee.mms.utils.CaptchasUtils.f24220a
            r1 = 0
            r0 = r0[r1]
            java.util.regex.Pattern r0 = java.util.regex.Pattern.compile(r0)
            r1 = r3
            java.util.regex.Matcher r0 = r0.matcher(r1)
            r5 = r0
            r0 = r4
            if (r0 == 0) goto L48
        L15:
            r0 = r5
            java.lang.String r0 = r0.group()
            int r0 = r0.length()
            r1 = 3
            if (r0 <= r1) goto L48
            r0 = r5
            java.lang.String r0 = r0.group()
            int r0 = r0.length()
            r1 = 8
            if (r0 >= r1) goto L48
            r0 = r5
            java.lang.String r0 = r0.group()
            java.lang.String r1 = "."
            boolean r0 = r0.contains(r1)
            if (r0 != 0) goto L48
            r0 = r5
            java.lang.String r0 = r0.group()
            r1 = r3
            boolean r0 = b(r0, r1)
            if (r0 == 0) goto L48
            r0 = r5
            java.lang.String r0 = r0.group()
            return r0
        L48:
            r0 = r5
            boolean r0 = r0.find()
            if (r0 != 0) goto L15
            java.lang.String r0 = ""
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mokee.mms.utils.CaptchasUtils.tryToGetEnCaptchas(java.lang.String):java.lang.String");
    }
}
