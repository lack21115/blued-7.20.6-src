package com.huawei.hms.adapter;

import android.content.Context;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/adapter/OuterBinderAdapter.class */
public class OuterBinderAdapter extends BinderAdapter {
    private static final Object j = new Object();
    private static BinderAdapter k;
    private static String l;
    private static String m;

    private OuterBinderAdapter(Context context, String str, String str2) {
        super(context, str, str2);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0048 A[Catch: all -> 0x0073, TRY_ENTER, TryCatch #0 {, blocks: (B:4:0x000f, B:6:0x0015, B:15:0x006a, B:15:0x006a, B:17:0x0070, B:7:0x002d, B:9:0x0037, B:14:0x0048), top: B:27:0x000f }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.huawei.hms.adapter.BinderAdapter getInstance(android.content.Context r6, java.lang.String r7, java.lang.String r8) {
        /*
            java.lang.String r0 = "OuterBinderAdapter"
            java.lang.String r1 = "OuterBinderAdapter getInstance."
            com.huawei.hms.support.log.HMSLog.i(r0, r1)
            java.lang.Object r0 = com.huawei.hms.adapter.OuterBinderAdapter.j
            r10 = r0
            r0 = r10
            monitor-enter(r0)
            com.huawei.hms.adapter.BinderAdapter r0 = com.huawei.hms.adapter.OuterBinderAdapter.k     // Catch: java.lang.Throwable -> L73
            if (r0 != 0) goto L2d
            r0 = r7
            com.huawei.hms.adapter.OuterBinderAdapter.l = r0     // Catch: java.lang.Throwable -> L73
            r0 = r8
            com.huawei.hms.adapter.OuterBinderAdapter.m = r0     // Catch: java.lang.Throwable -> L73
            com.huawei.hms.adapter.OuterBinderAdapter r0 = new com.huawei.hms.adapter.OuterBinderAdapter     // Catch: java.lang.Throwable -> L73
            r1 = r0
            r2 = r6
            r3 = r7
            r4 = r8
            r1.<init>(r2, r3, r4)     // Catch: java.lang.Throwable -> L73
            com.huawei.hms.adapter.OuterBinderAdapter.k = r0     // Catch: java.lang.Throwable -> L73
            goto L6a
        L2d:
            java.lang.String r0 = com.huawei.hms.adapter.OuterBinderAdapter.l     // Catch: java.lang.Throwable -> L73
            r1 = r7
            boolean r0 = com.huawei.hms.common.internal.Objects.equal(r0, r1)     // Catch: java.lang.Throwable -> L73
            if (r0 == 0) goto L7e
            java.lang.String r0 = com.huawei.hms.adapter.OuterBinderAdapter.m     // Catch: java.lang.Throwable -> L73
            r1 = r8
            boolean r0 = com.huawei.hms.common.internal.Objects.equal(r0, r1)     // Catch: java.lang.Throwable -> L73
            if (r0 != 0) goto L79
            goto L7e
        L44:
            r0 = r9
            if (r0 == 0) goto L6a
            java.lang.String r0 = "OuterBinderAdapter"
            java.lang.String r1 = "OuterBinderAdapter getInstance refresh adapter"
            com.huawei.hms.support.log.HMSLog.i(r0, r1)     // Catch: java.lang.Throwable -> L73
            r0 = r7
            com.huawei.hms.adapter.OuterBinderAdapter.l = r0     // Catch: java.lang.Throwable -> L73
            r0 = r8
            com.huawei.hms.adapter.OuterBinderAdapter.m = r0     // Catch: java.lang.Throwable -> L73
            com.huawei.hms.adapter.BinderAdapter r0 = com.huawei.hms.adapter.OuterBinderAdapter.k     // Catch: java.lang.Throwable -> L73
            r0.unBind()     // Catch: java.lang.Throwable -> L73
            com.huawei.hms.adapter.OuterBinderAdapter r0 = new com.huawei.hms.adapter.OuterBinderAdapter     // Catch: java.lang.Throwable -> L73
            r1 = r0
            r2 = r6
            r3 = r7
            r4 = r8
            r1.<init>(r2, r3, r4)     // Catch: java.lang.Throwable -> L73
            com.huawei.hms.adapter.OuterBinderAdapter.k = r0     // Catch: java.lang.Throwable -> L73
        L6a:
            com.huawei.hms.adapter.BinderAdapter r0 = com.huawei.hms.adapter.OuterBinderAdapter.k     // Catch: java.lang.Throwable -> L73 java.lang.Throwable -> L73
            r6 = r0
            r0 = r10
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L73
            r0 = r6
            return r0
        L73:
            r6 = move-exception
            r0 = r10
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L73
            r0 = r6
            throw r0
        L79:
            r0 = 0
            r9 = r0
            goto L44
        L7e:
            r0 = 1
            r9 = r0
            goto L44
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.adapter.OuterBinderAdapter.getInstance(android.content.Context, java.lang.String, java.lang.String):com.huawei.hms.adapter.BinderAdapter");
    }

    @Override // com.huawei.hms.adapter.BinderAdapter
    protected int a() {
        return 1001;
    }

    @Override // com.huawei.hms.adapter.BinderAdapter
    protected int b() {
        return 1002;
    }
}
