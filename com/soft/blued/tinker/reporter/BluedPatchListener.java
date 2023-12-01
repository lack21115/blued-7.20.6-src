package com.soft.blued.tinker.reporter;

import android.app.ActivityManager;
import android.content.Context;
import com.tencent.tinker.lib.listener.DefaultPatchListener;
import com.tencent.tinker.lib.util.TinkerLog;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/tinker/reporter/BluedPatchListener.class */
public class BluedPatchListener extends DefaultPatchListener {

    /* renamed from: a  reason: collision with root package name */
    private final int f29780a;

    public BluedPatchListener(Context context) {
        super(context);
        this.f29780a = ((ActivityManager) context.getSystemService("activity")).getMemoryClass();
        TinkerLog.i("Tinker.BluedPatchListener", "application maxMemory:" + this.f29780a, new Object[0]);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x00b4, code lost:
        if (r0.equals(com.soft.blued.tinker.app.BuildInfo.f) == false) goto L13;
     */
    @Override // com.tencent.tinker.lib.listener.DefaultPatchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int patchCheck(java.lang.String r9, java.lang.String r10) {
        /*
            Method dump skipped, instructions count: 200
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.soft.blued.tinker.reporter.BluedPatchListener.patchCheck(java.lang.String, java.lang.String):int");
    }
}
