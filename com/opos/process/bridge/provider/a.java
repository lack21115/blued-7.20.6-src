package com.opos.process.bridge.provider;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import com.opos.process.bridge.annotation.IBridgeTargetIdentify;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: source-8303388-dex2jar.jar:com/opos/process/bridge/provider/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    protected Context f13739a;
    protected IBridgeTargetIdentify b;

    /* renamed from: c  reason: collision with root package name */
    private AtomicInteger f13740c = new AtomicInteger(-1);

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0011, code lost:
        if (r0 == 1) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean a(android.content.Context r5, android.net.Uri r6) {
        /*
            r4 = this;
            r0 = r4
            java.util.concurrent.atomic.AtomicInteger r0 = r0.f13740c
            int r0 = r0.get()
            r7 = r0
            r0 = 0
            r8 = r0
            r0 = r7
            if (r0 < 0) goto L17
            r0 = r7
            r1 = 1
            if (r0 != r1) goto L61
            goto L5e
        L17:
            r0 = r5
            android.content.Context r0 = r0.getApplicationContext()     // Catch: java.lang.Exception -> L64
            java.lang.String r0 = com.opos.cmn.an.h.a.a.c(r0)     // Catch: java.lang.Exception -> L64
            r9 = r0
            r0 = r5
            android.content.Context r0 = r0.getApplicationContext()     // Catch: java.lang.Exception -> L64
            android.content.pm.PackageManager r0 = r0.getPackageManager()     // Catch: java.lang.Exception -> L64
            r1 = r6
            java.lang.String r1 = r1.getAuthority()     // Catch: java.lang.Exception -> L64
            r2 = 128(0x80, float:1.794E-43)
            android.content.pm.ProviderInfo r0 = r0.resolveContentProvider(r1, r2)     // Catch: java.lang.Exception -> L64
            r5 = r0
            r0 = r5
            java.lang.String r0 = r0.processName     // Catch: java.lang.Exception -> L64
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Exception -> L64
            if (r0 != 0) goto L54
            r0 = r5
            java.lang.String r0 = r0.processName     // Catch: java.lang.Exception -> L64
            r1 = r9
            boolean r0 = r0.equals(r1)     // Catch: java.lang.Exception -> L64
            if (r0 == 0) goto L54
            r0 = r4
            java.util.concurrent.atomic.AtomicInteger r0 = r0.f13740c     // Catch: java.lang.Exception -> L64
            r1 = -1
            r2 = 0
            boolean r0 = r0.compareAndSet(r1, r2)     // Catch: java.lang.Exception -> L64
            r0 = 0
            return r0
        L54:
            r0 = r4
            java.util.concurrent.atomic.AtomicInteger r0 = r0.f13740c
            r1 = -1
            r2 = 1
            boolean r0 = r0.compareAndSet(r1, r2)
        L5e:
            r0 = 1
            r8 = r0
        L61:
            r0 = r8
            return r0
        L64:
            r5 = move-exception
            goto L54
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.process.bridge.provider.a.a(android.content.Context, android.net.Uri):boolean");
    }

    private Bundle c(Context context, String str, IBridgeTargetIdentify iBridgeTargetIdentify, int i, Object... objArr) {
        Uri a2 = a(context);
        if (a(context, a2)) {
            Bundle bundle = new Bundle();
            bundle.setClassLoader(getClass().getClassLoader());
            bundle.putString(ProcessBridgeProvider.KEY_TARGET_CLASS, str);
            if (iBridgeTargetIdentify != null) {
                Parcel obtain = Parcel.obtain();
                obtain.writeParcelable(iBridgeTargetIdentify, 0);
                bundle.putByteArray(ProcessBridgeProvider.KEY_TARGET_IDENTIFY, obtain.marshall());
                obtain.recycle();
            }
            bundle.putInt(ProcessBridgeProvider.KEY_METHOD_ID, i);
            Object[] objArr2 = objArr;
            if (objArr == null) {
                objArr2 = new Object[0];
            }
            Parcel obtain2 = Parcel.obtain();
            obtain2.writeArray(objArr2);
            bundle.putByteArray(ProcessBridgeProvider.KEY_ARGS, obtain2.marshall());
            obtain2.recycle();
            return context.getContentResolver().call(a2, ProcessBridgeProvider.DISPATCH_METHOD, "", bundle);
        }
        return ProcessBridgeProvider.dispatch(context, str, iBridgeTargetIdentify, i, objArr);
    }

    protected Uri a(Context context) {
        return ProcessBridgeProvider.getUri(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final <T> T a(Context context, String str, IBridgeTargetIdentify iBridgeTargetIdentify, int i, Object... objArr) throws b, c {
        Bundle c2 = c(context, str, iBridgeTargetIdentify, i, objArr);
        c2.setClassLoader(getClass().getClassLoader());
        int i2 = c2.getInt(ProcessBridgeProvider.KEY_RESULT_CODE);
        if (i2 == 0) {
            return (T) c2.get(ProcessBridgeProvider.KEY_RESULT_DATA);
        }
        if (i2 == 2) {
            throw new c((Exception) c2.getSerializable(ProcessBridgeProvider.KEY_RESULT_EXCEPTION));
        }
        String string = c2.getString(ProcessBridgeProvider.KEY_RESULT_MSG);
        throw new b("code:" + i2 + ",msg:" + string);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(Context context, String str, IBridgeTargetIdentify iBridgeTargetIdentify, int i, Object... objArr) throws b, c {
        Bundle c2 = c(context, str, iBridgeTargetIdentify, i, objArr);
        int i2 = c2.getInt(ProcessBridgeProvider.KEY_RESULT_CODE);
        if (i2 == 0) {
            return;
        }
        if (i2 == 2) {
            throw new c((Exception) c2.getSerializable(ProcessBridgeProvider.KEY_RESULT_EXCEPTION));
        }
        String string = c2.getString(ProcessBridgeProvider.KEY_RESULT_MSG);
        throw new b("code:" + i2 + ",msg:" + string);
    }
}
