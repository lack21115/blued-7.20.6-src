package com.wrapper_oaction;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.zk_oaction.adengine.lk_sdkwrapper.e;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/wrapper_oaction/ZkViewSDK.class */
public class ZkViewSDK {

    /* renamed from: a  reason: collision with root package name */
    private static ZkViewSDK f27473a;
    private Context b;

    /* renamed from: c  reason: collision with root package name */
    private e f27474c;
    private b d;

    /* loaded from: source-8829756-dex2jar.jar:com/wrapper_oaction/ZkViewSDK$Event.class */
    public static class Event {
        public MotionEvent downEvent;
        public long downTime;
        public int downX;
        public int downY;
        public MotionEvent upEvent;
        public long upTime;
        public int upX;
        public int upY;
    }

    /* loaded from: source-8829756-dex2jar.jar:com/wrapper_oaction/ZkViewSDK$KEY.class */
    public enum KEY {
        KEY_AD_TITLE(c.F, c.A),
        KEY_AD_DESC(c.G, c.A),
        KEY_AD_IMAGE(c.H, c.z),
        KEY_AD_ICON(c.I, c.z),
        KEY_AD_LOGO(c.J, c.z),
        KEY_AD_ACTION(c.K, c.A),
        KEY_SHOW_HOT_AREA(c.L, c.B),
        KEY_HOT_ZONE_DESC(c.M, c.A),
        KEY_TURNTABLE_IMAGE(c.N, c.z),
        KEY_ADIMAGE_FILE_NAME(c.O, c.z),
        KEY_ROTATE_ANGLE(c.P, c.B),
        KEY_SHAKE_DESC(c.Q, c.A),
        KEY_SKIP_TIME(c.R, c.B),
        KEY_VIDEO_PROGRESS_STEP(c.S, c.B),
        KEY_SHAKE_ENABLE(c.T, c.B),
        KEY_SHAKE_RANGE(c.U, c.B),
        KEY_SHAKE_WAIT(c.V, c.B),
        KEY_AD_IMAGE_LIST(c.W, c.D),
        KEY_INVERSE_FEEDBACK(c.X, c.A),
        KEY_REWARD_DESC(c.Y, c.A),
        KEY_APP_INFO(c.f27476a, c.A),
        KEY_APP_DEVELOPER(c.b, c.A),
        KEY_APP_VERSION(c.f27477c, c.A),
        KEY_VIDEO_EXTERNAL(c.d, c.E),
        KEY_APP_DOWNLOAD_COUNT(c.e, c.A),
        KEY_APP_SIZE(c.f, c.A),
        KEY_VIP_INFO(c.g, c.A),
        KEY_REWARD_TIME(c.h, c.B),
        KEY_ROTATE_ANGLE_MULTI(c.i, c.B),
        KEY_TT_AUTO_SKIP_TIME(c.j, c.B),
        KEY_SHOW_SKIP_TIME(c.k, c.B),
        KEY_AD_VIEW(c.l, c.C),
        KEY_ADRES_ID(c.m, c.B),
        KEY_ADRES_NAME(c.n, c.A),
        KEY_ACTION(c.o, c.A),
        KEY_SHOW_TIME(c.p, c.B),
        KEY_TOTAL_TIME(c.q, c.B),
        KEY_TYPE_CODE(c.r, c.A),
        KEY_TARGET_URL(c.s, c.A),
        KEY_DEEPLINK(c.t, c.A),
        KEY_INSTANTAPP_URL(c.u, c.A),
        KEY_WXAPPLET_ID(c.v, c.A),
        KEY_WXAPPLET_PATH(c.w, c.A),
        KEY_AD_ID(c.x, c.A),
        KEY_USER_ID(c.y, c.A);
        
        public String key;
        public int keyType;

        KEY(String str, int i) {
            this.key = str;
            this.keyType = i;
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/wrapper_oaction/ZkViewSDK$a.class */
    public interface a {
        void a(Map map, String str, int i, int i2, int i3, Map map2);

        void a(Map map, String str, int i, int i2, Map map2);

        void a(Map map, String str, int i, String str2, Map map2);

        void a(Map map, String str, int i, Map map2);

        void a(Map map, String str, Event event, int i, String str2, int i2, Map map2);

        void a(Map map, String str, Event event, int i, Map map2);

        void a(Map map, String str, Event event, String str2, int i, Map map2);

        void a(Map map, String str, String str2, int i, Map map2);

        void a(Map map, String str, Map map2);

        void a(Map map, Map map2);

        void b(Map map, String str, int i, int i2, int i3, Map map2);

        void c(Map map, String str, int i, int i2, int i3, Map map2);
    }

    /* loaded from: source-8829756-dex2jar.jar:com/wrapper_oaction/ZkViewSDK$b.class */
    public interface b {
        void a(Map map, String str);
    }

    /* loaded from: source-8829756-dex2jar.jar:com/wrapper_oaction/ZkViewSDK$c.class */
    public static class c {
        public static int A = 1;
        public static int B = 2;
        public static int C = 3;
        public static int D = 4;
        public static int E = 5;
        public static String F = "ad_title";
        public static String G = "ad_description";
        public static String H = "ad_image";
        public static String I = "ad_icon";
        public static String J = "ad_logo";
        public static String K = "ad_action";
        public static String L = "show_hot_zone";
        public static String M = "hot_zone_desc";
        public static String N = "turntalbe_image";
        public static String O = "adimage_file_name";
        public static String P = "rotate_angle";
        public static String Q = "shake_desc";
        public static String R = "skip_time";
        public static String S = "video_progress_step";
        public static String T = "shake_enable";
        public static String U = "shake_range";
        public static String V = "shake_wait";
        public static String W = "ad_imagelist";
        public static String X = "inverse_feedback";
        public static String Y = "reward_desc";

        /* renamed from: a  reason: collision with root package name */
        public static String f27476a = "app_info";
        public static String b = "app_developer";

        /* renamed from: c  reason: collision with root package name */
        public static String f27477c = "app_version";
        public static String d = "video_external";
        public static String e = "app_download_count";
        public static String f = "app_size";
        public static String g = "vip_info";
        public static String h = "reward_desc";
        public static String i = "rotate_angle_multi";
        public static String j = "tt_skip_time";
        public static String k = "show_skip_time";
        public static String l = "ad_view";
        public static String m = "ad_res_id";
        public static String n = "ad_res_name";
        public static String o = "ad_action";
        public static String p = "show_time";
        public static String q = "total_time";
        public static String r = "typeCode";
        public static String s = "targetUrl";
        public static String t = "deeplink";
        public static String u = "instantAppUrl";
        public static String v = "wxAppletId";
        public static String w = "wxAppletPath";
        public static String x = "ad_id";
        public static String y = "user_id";
        public static int z;
    }

    public static ZkViewSDK a() {
        ZkViewSDK zkViewSDK;
        synchronized (ZkViewSDK.class) {
            try {
                if (f27473a == null) {
                    f27473a = new ZkViewSDK();
                }
                zkViewSDK = f27473a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return zkViewSDK;
    }

    private void a(Context context) {
        try {
            if (this.b != null) {
                return;
            }
            this.b = context;
            if (context.getApplicationContext() != null) {
                this.b = context.getApplicationContext();
            }
            e eVar = new e();
            this.f27474c = eVar;
            eVar.a(this.b);
        } catch (Throwable th) {
        }
    }

    public View a(Context context, String str, boolean z, HashMap<KEY, Object> hashMap, Map map, a aVar) {
        try {
            a(context);
            if (this.f27474c != null) {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append("/fullscreen_match");
                return new File(sb.toString()).exists() ? this.f27474c.b(str, 0, 0, z, hashMap, aVar, -1, map, 2) : this.f27474c.a(str, 0, 0, z, hashMap, aVar, -1, map, 1);
            }
            return null;
        } catch (Throwable th) {
            if (aVar != null) {
                aVar.a(map, "" + th.getMessage(), null);
                return null;
            }
            return null;
        }
    }

    public void a(View view) {
        e eVar = this.f27474c;
        if (eVar != null) {
            eVar.a(view);
        }
    }

    public void a(View view, HashMap<KEY, Object> hashMap) {
        e eVar = this.f27474c;
        if (eVar != null) {
            eVar.a(view, hashMap);
        }
    }

    public void a(View view, boolean z) {
        e eVar = this.f27474c;
        if (eVar != null) {
            eVar.a(view, z);
        }
    }

    public void a(Map map, String str) {
        b bVar = this.d;
        if (bVar != null) {
            bVar.a(map, str);
        }
    }

    public View b(Context context, String str, boolean z, HashMap<KEY, Object> hashMap, Map map, a aVar) {
        try {
            a(context);
        } catch (Throwable th) {
            th = th;
        }
        try {
            e eVar = this.f27474c;
            if (eVar != null) {
                return eVar.b(str, 0, 0, z, hashMap, aVar, -1, map, 2);
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
            if (aVar != null) {
                aVar.a(map, "" + th.getMessage(), null);
                return null;
            }
            return null;
        }
    }

    public void b(View view) {
        e eVar = this.f27474c;
        if (eVar != null) {
            eVar.b(view);
        }
    }

    public void c(View view) {
        e eVar = this.f27474c;
        if (eVar != null) {
            eVar.c(view);
        }
    }
}
