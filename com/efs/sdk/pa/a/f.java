package com.efs.sdk.pa.a;

import android.util.Log;
import com.efs.sdk.pa.PAMsgListener;
import java.io.BufferedOutputStream;

/* loaded from: source-8110460-dex2jar.jar:com/efs/sdk/pa/a/f.class */
final class f implements d {

    /* renamed from: a  reason: collision with root package name */
    PAMsgListener f21861a;
    boolean b;

    /* renamed from: c  reason: collision with root package name */
    String f21862c;
    BufferedOutputStream d;

    /* JADX WARN: Removed duplicated region for block: B:50:0x0100  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.efs.sdk.pa.b b(java.lang.String r4, long r5, long r7) {
        /*
            Method dump skipped, instructions count: 361
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.efs.sdk.pa.a.f.b(java.lang.String, long, long):com.efs.sdk.pa.b");
    }

    @Override // com.efs.sdk.pa.a.d
    public final void a(String str, long j, long j2) {
        com.efs.sdk.pa.b b = b(str, j, j2);
        if (b != null) {
            if (this.b) {
                Log.e("PerformanceAnalyze", b.toString());
            }
            if (this.f21862c != null) {
                try {
                    BufferedOutputStream bufferedOutputStream = this.d;
                    bufferedOutputStream.write((b.toString() + "\n").getBytes());
                } catch (Exception e) {
                }
            }
            this.f21861a.msg(b);
        }
    }
}
