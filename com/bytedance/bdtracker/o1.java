package com.bytedance.bdtracker;

import android.media.TtmlUtils;
import com.bytedance.applog.profile.UserProfileCallback;
import com.umeng.analytics.pro.bh;
import org.json.JSONObject;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/o1.class */
public class o1 {

    /* renamed from: a  reason: collision with root package name */
    public static final String[] f7668a = {"aid", TtmlUtils.TAG_REGION, bh.x, "package", "app_version", "sdk_version", "os_version", "device_model", "resolution", "language", "timezone", bh.Q, "display_name", "channel", bh.P, "app_language", "app_region", "tz_name", "tz_offset", "install_id", "openudid", "mcc_mnc", "rom", "manifest_version_code", bh.H, "clientudid", "sig_hash", "display_density", "os_api", "update_version_code", "density_dpi", "version_code", "sim_serial_number", "release_build", "udid", "cpu_abi", "google_aid"};
    public static final String[] b = {"setOnce", "synchronize"};

    /* renamed from: c  reason: collision with root package name */
    public static final int[] f7669c = {-1, -1};
    public static final long[] d = {-1, -1};

    /* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/o1$a.class */
    public static final class a implements UserProfileCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f7670a;
        public final /* synthetic */ JSONObject b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ UserProfileCallback f7671c;

        public a(int i, JSONObject jSONObject, UserProfileCallback userProfileCallback) {
            this.f7670a = i;
            this.b = jSONObject;
            this.f7671c = userProfileCallback;
        }

        @Override // com.bytedance.applog.profile.UserProfileCallback
        public void onFail(int i) {
            this.f7671c.onFail(i);
        }

        @Override // com.bytedance.applog.profile.UserProfileCallback
        public void onSuccess() {
            o1.f7669c[this.f7670a] = this.b.toString().hashCode();
            o1.d[this.f7670a] = System.currentTimeMillis();
            this.f7671c.onSuccess();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x0187 A[Catch: JSONException -> 0x01c1, TRY_ENTER, TryCatch #0 {JSONException -> 0x01c1, blocks: (B:36:0x0168, B:37:0x0179, B:38:0x017c, B:40:0x0187, B:42:0x01b6, B:33:0x0155, B:34:0x015d, B:31:0x011e), top: B:63:0x011b, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x01f4  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x01fc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(com.bytedance.bdtracker.v r9, int r10, org.json.JSONObject r11, com.bytedance.applog.profile.UserProfileCallback r12, android.os.Handler r13, boolean r14) {
        /*
            Method dump skipped, instructions count: 554
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.bdtracker.o1.a(com.bytedance.bdtracker.v, int, org.json.JSONObject, com.bytedance.applog.profile.UserProfileCallback, android.os.Handler, boolean):void");
    }
}
