package com.kuaishou.weapon.p0;

/* loaded from: source-7994992-dex2jar.jar:com/kuaishou/weapon/p0/al.class */
public class al {
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0016, code lost:
        if (android.provider.Settings.Secure.getInt(r12.getContentResolver(), android.provider.Settings.Secure.ALLOW_MOCK_LOCATION, 0) != 0) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean a(android.content.Context r12) {
        /*
            r0 = 0
            r14 = r0
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L85
            r1 = 22
            if (r0 > r1) goto L1c
            r0 = r12
            android.content.ContentResolver r0 = r0.getContentResolver()     // Catch: java.lang.Throwable -> L85
            java.lang.String r1 = "mock_location"
            r2 = 0
            int r0 = android.provider.Settings.Secure.getInt(r0, r1, r2)     // Catch: java.lang.Throwable -> L85
            r13 = r0
            r0 = r13
            if (r0 == 0) goto L83
            goto L81
        L1c:
            r0 = r12
            java.lang.String r1 = "location"
            java.lang.Object r0 = r0.getSystemService(r1)
            android.location.LocationManager r0 = (android.location.LocationManager) r0
            r12 = r0
            r0 = r12
            java.lang.String r1 = "gps"
            android.location.LocationProvider r0 = r0.getProvider(r1)
            r15 = r0
            r0 = r15
            if (r0 == 0) goto L60
            r0 = r12
            r1 = r15
            java.lang.String r1 = r1.getName()
            r2 = r15
            boolean r2 = r2.requiresNetwork()
            r3 = r15
            boolean r3 = r3.requiresSatellite()
            r4 = r15
            boolean r4 = r4.requiresCell()
            r5 = r15
            boolean r5 = r5.hasMonetaryCost()
            r6 = r15
            boolean r6 = r6.supportsAltitude()
            r7 = r15
            boolean r7 = r7.supportsSpeed()
            r8 = r15
            boolean r8 = r8.supportsBearing()
            r9 = r15
            int r9 = r9.getPowerRequirement()
            r10 = r15
            int r10 = r10.getAccuracy()
            r0.addTestProvider(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            goto L6f
        L60:
            r0 = r12
            java.lang.String r1 = "gps"
            r2 = 1
            r3 = 1
            r4 = 0
            r5 = 0
            r6 = 1
            r7 = 1
            r8 = 1
            r9 = 3
            r10 = 1
            r0.addTestProvider(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> L85
        L6f:
            r0 = r12
            java.lang.String r1 = "gps"
            r2 = 1
            r0.setTestProviderEnabled(r1, r2)
            r0 = r12
            java.lang.String r1 = "gps"
            r2 = 2
            r3 = 0
            long r4 = java.lang.System.currentTimeMillis()
            r0.setTestProviderStatus(r1, r2, r3, r4)
        L81:
            r0 = 1
            r14 = r0
        L83:
            r0 = r14
            return r0
        L85:
            r12 = move-exception
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kuaishou.weapon.p0.al.a(android.content.Context):boolean");
    }
}
