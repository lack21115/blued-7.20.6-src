package com.mokee.cloud.calendar;

import com.mokee.volley.VolleyError;

/* loaded from: source-4181928-dex2jar.jar:com/mokee/cloud/calendar/SolarFestival.class */
public class SolarFestival {

    /* renamed from: a  reason: collision with root package name */
    private static final String[] f24203a = null;
    public static int b;

    static {
        String[] strArr = new String[2];
        throw new VerifyError("bad dex opcode");
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x007c A[RETURN] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x0079 -> B:9:0x0055). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String getSolarFestivalInfo(int r9, int r10) {
        /*
            int r0 = com.mokee.cloud.calendar.SolarFestival.b
            r12 = r0
            boolean r0 = com.mokee.cloud.misc.CloudUtils.hasAccessPermission()
            if (r0 != 0) goto Lc
            r0 = 0
            return r0
        Lc:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            java.lang.String[] r2 = com.mokee.cloud.calendar.SolarFestival.f24203a
            r3 = 1
            r2 = r2[r3]
            r3 = 1
            java.lang.Object[] r3 = new java.lang.Object[r3]
            r4 = r3
            r5 = 0
            r6 = r9
            r7 = 1
            int r6 = r6 + r7
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            r4[r5] = r6
            java.lang.String r2 = java.lang.String.format(r2, r3)
            java.lang.String r2 = java.lang.String.valueOf(r2)
            r1.<init>(r2)
            java.lang.String[] r1 = com.mokee.cloud.calendar.SolarFestival.f24203a
            r2 = 0
            r1 = r1[r2]
            r2 = 1
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r3 = r2
            r4 = 0
            r5 = r10
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r3[r4] = r5
            java.lang.String r1 = java.lang.String.format(r1, r2)
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = r0.toString()
            r13 = r0
            java.lang.String[] r0 = android.mokee.calendar.FestivalInfo.getFestivalInfo()
            r14 = r0
            r0 = r14
            int r0 = r0.length
            r11 = r0
            r0 = r12
            if (r0 == 0) goto L7e
            r0 = 0
            r10 = r0
        L55:
            r0 = r14
            r1 = r10
            r0 = r0[r1]
            java.lang.String r1 = " "
            java.lang.String[] r0 = r0.split(r1)
            r15 = r0
            r0 = r15
            r1 = 0
            r0 = r0[r1]
            r1 = r13
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L71
            r0 = r15
            r1 = 1
            r0 = r0[r1]
            return r0
        L71:
            r0 = r10
            r1 = 1
            int r0 = r0 + r1
            r9 = r0
        L75:
            r0 = r9
            r10 = r0
            r0 = r9
            r1 = r11
            if (r0 < r1) goto L55
            r0 = 0
            return r0
        L7e:
            r0 = 0
            r9 = r0
            goto L75
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mokee.cloud.calendar.SolarFestival.getSolarFestivalInfo(int, int):java.lang.String");
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:56)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:30)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:18)
        */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0066 A[RETURN] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0063 -> B:9:0x001d). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String getSpecificSolarFestivalInfo(int r3, int r4, int r5) {
        /*
            int r0 = com.mokee.cloud.calendar.SolarFestival.b
            r6 = r0
            boolean r0 = com.mokee.cloud.misc.CloudUtils.hasAccessPermission()
            if (r0 != 0) goto Lc
            r0 = 0
            return r0
        Lc:
            java.lang.String[] r0 = android.mokee.calendar.FestivalInfo.getSpecificInfo()
            r9 = r0
            r0 = r9
            int r0 = r0.length
            r8 = r0
            r0 = r6
            if (r0 == 0) goto L68
            r0 = 0
            r7 = r0
        L1d:
            r0 = r9
            r1 = r7
            r0 = r0[r1]
            java.lang.String r1 = " "
            java.lang.String[] r0 = r0.split(r1)
            r10 = r0
            r0 = r10
            r1 = 0
            r0 = r0[r1]
            r1 = r3
            java.lang.String r1 = java.lang.String.valueOf(r1)
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L58
            r0 = r10
            r1 = 1
            r0 = r0[r1]
            r1 = r4
            java.lang.String r1 = java.lang.String.valueOf(r1)
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L58
            r0 = r10
            r1 = 2
            r0 = r0[r1]
            r1 = r5
            java.lang.String r1 = java.lang.String.valueOf(r1)
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L58
            r0 = r10
            r1 = 3
            r0 = r0[r1]
            return r0
        L58:
            r0 = r7
            r1 = 1
            int r0 = r0 + r1
            r6 = r0
        L5d:
            r0 = r6
            r7 = r0
            r0 = r6
            r1 = r8
            if (r0 < r1) goto L1d
            r0 = 0
            return r0
        L68:
            r0 = 0
            r6 = r0
            goto L5d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mokee.cloud.calendar.SolarFestival.getSpecificSolarFestivalInfo(int, int, int):java.lang.String");
    }

    public static boolean isEaster(int i, int i2, int i3) {
        boolean z = true;
        int i4 = b;
        int i5 = i % 19;
        int i6 = i / 100;
        int i7 = i % 100;
        int i8 = ((((i6 + (i5 * 19)) - (i6 / 4)) - (((i6 - ((i6 + 8) / 25)) + 1) / 3)) + 15) % 30;
        int i9 = (((((i7 / 4) * 2) + (((i6 % 4) * 2) + 32)) - i8) - (i7 % 4)) % 7;
        int i10 = ((i5 + (i8 * 11)) + (i9 * 22)) / 451;
        if (i2 == (((i8 + i9) - (i10 * 7)) + 114) / 31 && i3 == ((((i8 + i9) - (i10 * 7)) + 114) % 31) + 1) {
            return true;
        }
        if (i4 != 0) {
            if (VolleyError.b) {
                z = false;
            }
            VolleyError.b = z;
            return false;
        }
        return false;
    }
}
