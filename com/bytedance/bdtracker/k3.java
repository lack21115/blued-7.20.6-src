package com.bytedance.bdtracker;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.SystemClock;
import com.bytedance.applog.IOaidObserver;
import com.bytedance.bdtracker.z2;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/k3.class */
public final class k3 {

    /* renamed from: a  reason: collision with root package name */
    public static f3<r3> f21244a = new a();

    /* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/k3$a.class */
    public static final class a extends f3<r3> {
        @Override // com.bytedance.bdtracker.f3
        public r3 a(Object[] objArr) {
            return new r3((Context) objArr[0]);
        }
    }

    public static /* synthetic */ String a(long j) {
        StringBuilder a2 = com.bytedance.bdtracker.a.a("TrackerDr# getCdid takes ");
        a2.append(SystemClock.elapsedRealtime() - j);
        a2.append(" ms");
        return a2.toString();
    }

    public static String a(SharedPreferences sharedPreferences) {
        final long elapsedRealtime = SystemClock.elapsedRealtime();
        String b = h3.f21226a.b(sharedPreferences);
        z2.a(new z2.a() { // from class: com.bytedance.bdtracker.-$$Lambda$NHBYLfu7Wh_rQ0FnNO63xQ_yB_I
            @Override // com.bytedance.bdtracker.z2.a
            public final String a() {
                return k3.a(elapsedRealtime);
            }
        });
        return b;
    }

    public static String a(JSONObject jSONObject) {
        String str = null;
        if (jSONObject != null) {
            str = jSONObject.optString("id", null);
        }
        return str;
    }

    public static Map a(Context context) {
        final long elapsedRealtime = SystemClock.elapsedRealtime();
        Map<String, String> a2 = f21244a.b(context).a(100L);
        z2.a(new z2.a() { // from class: com.bytedance.bdtracker.-$$Lambda$6Vm_crAzKeFrWNxGkfjy3JQTtfk
            @Override // com.bytedance.bdtracker.z2.a
            public final String a() {
                return k3.b(elapsedRealtime);
            }
        });
        return a2;
    }

    public static void a(IOaidObserver iOaidObserver) {
        r3.a(iOaidObserver);
    }

    public static /* synthetic */ String b(long j) {
        StringBuilder a2 = com.bytedance.bdtracker.a.a("TrackerDr# getOaid takes ");
        a2.append(SystemClock.elapsedRealtime() - j);
        a2.append(" ms");
        return a2.toString();
    }

    public static void b(IOaidObserver iOaidObserver) {
        r3.b(iOaidObserver);
    }
}
