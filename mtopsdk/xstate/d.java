package mtopsdk.xstate;

import android.app.Service;
import android.content.Intent;
import android.os.RemoteException;
import mtopsdk.common.util.TBSdkLog;

/* loaded from: source-3503164-dex2jar.jar:mtopsdk/xstate/d.class */
public class d extends Service {

    /* renamed from: a  reason: collision with root package name */
    private mtopsdk.xstate.a.b f43799a = null;
    private Object b = new Object();

    /* JADX WARN: Removed duplicated region for block: B:17:0x003c  */
    @Override // android.app.Service
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.os.IBinder onBind(android.content.Intent r5) {
        /*
            r4 = this;
            r0 = r4
            java.lang.Object r0 = r0.b
            r7 = r0
            r0 = r7
            monitor-enter(r0)
            r0 = r4
            mtopsdk.xstate.a.b r0 = r0.f43799a     // Catch: java.lang.Throwable -> L60
            if (r0 != 0) goto L31
            mtopsdk.xstate.e r0 = new mtopsdk.xstate.e     // Catch: java.lang.Throwable -> L60
            r1 = r0
            r2 = r4
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L60
            r5 = r0
            r0 = r4
            r1 = r5
            r0.f43799a = r1     // Catch: java.lang.Throwable -> L60
            r0 = r5
            r0.a()     // Catch: java.lang.Throwable -> L23 android.os.RemoteException -> L65
            goto L31
        L23:
            r5 = move-exception
            java.lang.String r0 = "[onBind]init() error"
            r6 = r0
        L27:
            java.lang.String r0 = "mtopsdk.XStateService"
            r1 = r6
            r2 = r5
            mtopsdk.common.util.TBSdkLog.b(r0, r1, r2)     // Catch: java.lang.Throwable -> L60
            goto L31
        L31:
            r0 = r7
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L60
            mtopsdk.common.util.TBSdkLog$LogEnable r0 = mtopsdk.common.util.TBSdkLog.LogEnable.InfoEnable     // Catch: java.lang.Throwable -> L60
            boolean r0 = mtopsdk.common.util.TBSdkLog.a(r0)
            if (r0 == 0) goto L5b
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            java.lang.String r2 = "[onBind] XStateService  stub= "
            r1.<init>(r2)
            r5 = r0
            r0 = r5
            r1 = r4
            mtopsdk.xstate.a.b r1 = r1.f43799a
            int r1 = r1.hashCode()
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = "mtopsdk.XStateService"
            r1 = r5
            java.lang.String r1 = r1.toString()
            mtopsdk.common.util.TBSdkLog.b(r0, r1)
        L5b:
            r0 = r4
            mtopsdk.xstate.a.b r0 = r0.f43799a
            return r0
        L60:
            r5 = move-exception
            r0 = r7
            monitor-exit(r0)
            r0 = r5
            throw r0
        L65:
            r5 = move-exception
            java.lang.String r0 = "[onBind]init() exception"
            r6 = r0
            goto L27
        */
        throw new UnsupportedOperationException("Method not decompiled: mtopsdk.xstate.d.onBind(android.content.Intent):android.os.IBinder");
    }

    @Override // android.app.Service
    public void onDestroy() {
        String str;
        super.onDestroy();
        synchronized (this.b) {
            if (this.f43799a != null) {
                try {
                    this.f43799a.b();
                } catch (RemoteException e) {
                    e = e;
                    str = "[onDestroy]unInit() exception";
                    TBSdkLog.b("mtopsdk.XStateService", str, e);
                } catch (Throwable th) {
                    e = th;
                    str = "[onDestroy]unInit() error";
                    TBSdkLog.b("mtopsdk.XStateService", str, e);
                }
            }
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        return 2;
    }
}
