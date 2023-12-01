package com.huawei.hms.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.huawei.openalliance.ad.beans.server.AppConfigRsp;
import com.huawei.openalliance.ad.utils.aa;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/fk.class */
public class fk {
    private static final String A = "swipeDesc";
    private static final String B = "location_collected_switch";
    private static final String C = "splash_show_time";
    private static final String Code = "SpHandler";
    private static final String D = "slogan_show_time";
    private static final String E = "swipeDp";
    private static final String F = "splash_skip_area";
    private static final String G = "twistDesc";
    private static final String H = "twistDegree";
    private static final String I = "location_expire_time";
    private static final String J = "twistAcc";
    private static final String K = "proHeight";
    private static final String L = "cache_slogan_show_time_def";
    private static final String M = "proBotMargin";
    private static final String N = "proTextSize";
    private static final String O = "proRadius";
    private static final String P = "preRequest";
    private static final String Q = "clctCtxIntvl";
    private static final String R = "clctCtxMap";
    private static final String S = "splash_show_mode";
    private static final int T = 60;
    private static final String U = "clctCtxSize";
    private static final String V = "HiAdSharedPreferences";
    private static final int W = 200;
    private static final String X = "clctCtx";
    private static final String Y = "ads_core_selection";
    private static final String Z = "location_refresh_interval_time";

    /* renamed from: a  reason: collision with root package name */
    private static final String f8875a = "smart_screen_slogan_time";
    private static final String aA = "shield_other_splash_fashion";
    private static final String aB = "splashInteractCloseEffectiveTime";
    private static final int aC = 85;
    private static final int aD = 119;
    private static final String aE = "notification_app_list";
    private static final String aF = "singleInstanceLSModelList";
    private static final String aG = "sha256";
    private static final String aa = "test_country_code";
    private static final String ab = "exsplash_slogan_start_time";
    private static final String ac = "exsplash_slogan_show_time";
    private static final String ad = "linked_content_id";
    private static final String ae = "exsplash_redundancy_time";
    private static final String af = "third_country_code";
    private static final String ag = "default_splash_mode";
    private static final String ah = "full_screen_notify";
    private static final String ai = "activate_notify_style";
    private static final String aj = "allow_ad_skip_time";
    private static final int ak = 0;
    private static final String al = "auto_open_forbidden";
    private static final String am = "has_restore_config";
    private static final int an = 30;
    private static final String ao = "config_map";
    private static final String ap = "remindAgain";
    private static fk as;
    private static final byte[] au = new byte[0];
    private static final String ay = "trust_app_list";
    private static final String az = "oaid_report_on_npa";
    private static final String b = "clct_ctx_time";

    /* renamed from: c  reason: collision with root package name */
    private static final String f8876c = "slogan_real_min_show_time";
    private static final String d = "splash_app_day_impfc";
    private static final String e = "today_show_times";
    private static final String f = "today_date";
    private static final String g = "config_refresh_interval";
    private static final String h = "config_refresh_last_time";
    private static final String i = "enable_user_info";
    private static final String j = "enable_share_pd";
    private static final String k = "no_show_ad_time";
    private static final String l = "img_size_upper_limit";
    private static final String m = "global_switch";
    private static final String n = "def_broswer_pkg_list";
    private static final String o = "ad_preload_interval";
    private static final String p = "preload_splash_req_time_interval";
    private static final String q = "min_banner_interval";
    private static final String r = "max_banner_interval";
    private static final String s = "default_banner_interval";
    private static final String t = "country_code";
    private static final String u = "gif_time_lower_limit_frame";
    private static final String v = "limit_of_container_aspect_ratio";
    private static final String w = "testDeviceConfigRefreshInterval";
    private static final String x = "splashInteractCfg";
    private static final String y = "clickDesc";
    private static final String z = "clickExtraArea";
    private final SharedPreferences aq;

    /* renamed from: ar  reason: collision with root package name */
    private SharedPreferences f8877ar;
    private Map<String, String> at;
    private final byte[] av = new byte[0];
    private String aw;
    private Context ax;

    private fk(Context context) {
        this.at = new HashMap();
        Context L2 = com.huawei.openalliance.ad.utils.l.L(context.getApplicationContext());
        this.ax = L2;
        this.aq = L2.getSharedPreferences(V, 0);
        try {
            this.f8877ar = context.getSharedPreferences(V, 0);
        } catch (Throwable th) {
            this.f8877ar = null;
            ge.I(Code, "create sp error.");
        }
        al();
        this.aw = new com.huawei.openalliance.ad.utils.j(this.ax).Code();
        this.at = (Map) com.huawei.openalliance.ad.utils.z.V(an(), Map.class, new Class[0]);
    }

    private void B(boolean z2) {
        synchronized (this.av) {
            this.aq.edit().putBoolean(am, z2).commit();
        }
    }

    public static fk Code(Context context) {
        return I(context);
    }

    private void Code(SharedPreferences.Editor editor, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("trustAppList", jSONObject);
            Code(editor, ay, jSONObject2.toString());
        } catch (JSONException e2) {
            ge.Z(Code, "putTrustAppList JSONException");
        }
    }

    private void Code(SharedPreferences.Editor editor, String str, Integer num) {
        if (num != null) {
            editor.putInt(str, num.intValue());
        }
    }

    private void Code(SharedPreferences.Editor editor, String str, Integer num, int i2) {
        if (num != null) {
            editor.putInt(str, num.intValue());
        } else {
            editor.putInt(str, i2);
        }
    }

    private void Code(SharedPreferences.Editor editor, String str, Long l2) {
        if (l2 != null) {
            editor.putLong(str, l2.longValue());
        }
    }

    private void Code(SharedPreferences.Editor editor, String str, String str2) {
        if (str2 != null) {
            editor.putString(str, str2);
        }
    }

    private void Code(Map.Entry<String, ?> entry, SharedPreferences.Editor editor) {
        if (entry == null || editor == null) {
            return;
        }
        Object value = entry.getValue();
        String key = entry.getKey();
        if (value instanceof Integer) {
            editor.putInt(key, ((Integer) value).intValue());
        } else if (value instanceof Boolean) {
            editor.putBoolean(key, ((Boolean) value).booleanValue());
        } else if (value instanceof Long) {
            editor.putLong(key, ((Long) value).longValue());
        } else if (value instanceof Float) {
            editor.putFloat(key, ((Float) value).floatValue());
        } else if (value instanceof String) {
            editor.putString(key, (String) value);
        } else if (value instanceof Set) {
            editor.putStringSet(key, new HashSet((Set) value));
        }
    }

    private static fk I(Context context) {
        fk fkVar;
        synchronized (au) {
            if (as == null) {
                as = new fk(context);
            }
            fkVar = as;
        }
        return fkVar;
    }

    private void V(SharedPreferences.Editor editor, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            editor.putString(ao, jSONObject.toString());
            this.at = (Map) com.huawei.openalliance.ad.utils.z.V(jSONObject.toString(), Map.class, new Class[0]);
        } catch (JSONException e2) {
            ge.Z(Code, "putConfigMap JSONException");
        }
    }

    private void al() {
        if (am()) {
            return;
        }
        try {
            if (this.f8877ar == null) {
                if (ge.Code()) {
                    ge.Code(Code, "there is no old config file");
                    return;
                }
                return;
            }
            Map<String, ?> all = this.f8877ar.getAll();
            if (all != null && !all.isEmpty()) {
                Set<Map.Entry<String, ?>> entrySet = all.entrySet();
                if (entrySet != null && !entrySet.isEmpty()) {
                    SharedPreferences.Editor edit = this.aq.edit();
                    for (Map.Entry<String, ?> entry : entrySet) {
                        Code(entry, edit);
                    }
                    edit.commit();
                }
                B(true);
                return;
            }
            if (ge.Code()) {
                ge.Code(Code, "there is no old config file");
            }
        } catch (Throwable th) {
            ge.I(Code, "restore config error:" + th.getClass().getSimpleName());
        }
    }

    private boolean am() {
        boolean z2;
        synchronized (this.av) {
            z2 = this.aq.getBoolean(am, false);
        }
        return z2;
    }

    private String an() {
        String string;
        synchronized (this.av) {
            string = this.aq.getString(ao, "");
        }
        return string;
    }

    private String ao() {
        String string;
        synchronized (this.av) {
            string = this.aq.getString(m, "");
        }
        return string;
    }

    private int ap() {
        int i2;
        synchronized (this.av) {
            i2 = this.aq.getInt(ag, 2);
        }
        return i2;
    }

    public int A() {
        int i2;
        synchronized (this.av) {
            Integer num = null;
            if (this.at != null) {
                num = com.huawei.openalliance.ad.utils.au.F(this.at.get(E));
            }
            if (num != null && num.intValue() > 0) {
                i2 = num.intValue();
            }
            i2 = 100;
        }
        return i2;
    }

    public void B(int i2) {
        synchronized (this.av) {
            if (i2 > 0) {
                this.aq.edit().putInt(ae, i2).commit();
            }
        }
    }

    public void B(String str) {
        synchronized (this.av) {
            this.aq.edit().putString(aA, str).commit();
        }
    }

    public boolean B() {
        synchronized (this.av) {
            return Integer.valueOf(this.aq.getInt(B, 0)).intValue() == 1;
        }
    }

    public long C() {
        long j2;
        synchronized (this.av) {
            j2 = this.aq.getLong(I, 1800000L);
        }
        return j2;
    }

    public void C(int i2) {
        synchronized (this.av) {
            this.aq.edit().putInt("splash_skip_area", i2).commit();
        }
    }

    public void C(String str) {
        synchronized (this.av) {
            this.aq.edit().putString("sha256", str).commit();
        }
    }

    public String Code() {
        String string;
        synchronized (this.av) {
            string = this.aq.getString(ay, "");
        }
        return string;
    }

    public void Code(int i2) {
        synchronized (this.av) {
            this.aq.edit().putInt(L, i2).commit();
        }
    }

    public void Code(long j2) {
        synchronized (this.av) {
            this.aq.edit().putLong(h, j2).commit();
        }
    }

    public void Code(AppConfigRsp appConfigRsp) {
        synchronized (this.av) {
            SharedPreferences.Editor edit = this.aq.edit();
            edit.putLong(I, appConfigRsp.e().longValue());
            edit.putLong(Z, appConfigRsp.g().longValue());
            edit.putInt(B, appConfigRsp.f());
            edit.putInt(C, appConfigRsp.C());
            Code(edit, S, appConfigRsp.S());
            edit.putInt("splash_skip_area", appConfigRsp.F());
            if (com.huawei.openalliance.ad.utils.l.V(this.ax)) {
                Code(edit, D, appConfigRsp.B());
            } else {
                Code(edit, D, appConfigRsp.B(), 2000);
            }
            edit.putLong(f8876c, appConfigRsp.Z());
            edit.putInt(d, appConfigRsp.I());
            Code(edit, g, appConfigRsp.D());
            edit.putLong(h, System.currentTimeMillis());
            edit.putString(m, appConfigRsp.L());
            edit.putLong(p, appConfigRsp.b());
            edit.putFloat(v, (float) appConfigRsp.h());
            Code(edit, q, appConfigRsp.c());
            Code(edit, r, appConfigRsp.d());
            Code(edit, Y, appConfigRsp.i());
            edit.putString(aa, appConfigRsp.j());
            V(edit, appConfigRsp.k());
            Code(edit, s, appConfigRsp.l());
            Code(edit, appConfigRsp.V());
            Code(edit, az, appConfigRsp.m());
            Code(edit, aj, appConfigRsp.n());
            Code(edit, aB, appConfigRsp.o());
            Code(appConfigRsp.p());
            Code(edit, "sha256", appConfigRsp.q());
            List<String> a2 = appConfigRsp.a();
            if (!aa.Code(a2)) {
                edit.putStringSet(n, new HashSet(a2));
            }
            edit.commit();
        }
    }

    public void Code(String str) {
        synchronized (this.av) {
            if (!TextUtils.isEmpty(str)) {
                this.aq.edit().putString("country_code", str).commit();
            }
        }
    }

    public void Code(List<String> list) {
        synchronized (this.av) {
            if (!aa.Code(list)) {
                this.aq.edit().putStringSet(aF, aa.Code(list, true)).commit();
            }
        }
    }

    public void Code(Set<String> set) {
        synchronized (this.av) {
            SharedPreferences.Editor edit = this.aq.edit();
            if (aa.Code(set)) {
                edit.putStringSet(aE, null);
            } else {
                edit.putStringSet(aE, set);
            }
            edit.commit();
        }
    }

    public void Code(boolean z2) {
        synchronized (this.av) {
            this.aq.edit().putBoolean(i, z2).commit();
        }
    }

    public int D() {
        int i2;
        synchronized (this.av) {
            i2 = this.aq.getInt(L, 0);
        }
        return i2;
    }

    public String E() {
        String str;
        synchronized (this.av) {
            str = null;
            if (this.at != null) {
                str = com.huawei.openalliance.ad.utils.au.V(this.at.get(G));
            }
        }
        return str;
    }

    public int F() {
        int i2;
        synchronized (this.av) {
            i2 = this.aq.getInt("splash_skip_area", 0);
        }
        return i2;
    }

    public void F(int i2) {
        synchronized (this.av) {
            this.aq.edit().putInt(ai, i2).commit();
        }
    }

    public int G() {
        int i2;
        synchronized (this.av) {
            Integer num = null;
            if (this.at != null) {
                num = com.huawei.openalliance.ad.utils.au.F(this.at.get(H));
            }
            if (num != null && num.intValue() > 0) {
                i2 = num.intValue();
            }
            i2 = 15;
        }
        return i2;
    }

    public int H() {
        int i2;
        synchronized (this.av) {
            Integer num = null;
            if (this.at != null) {
                num = com.huawei.openalliance.ad.utils.au.F(this.at.get(J));
            }
            if (num != null && num.intValue() > 0) {
                i2 = num.intValue();
            }
            i2 = 5;
        }
        return i2;
    }

    public int I() {
        int i2;
        synchronized (this.av) {
            i2 = this.aq.getInt(S, ap());
        }
        return i2;
    }

    public void I(int i2) {
        synchronized (this.av) {
            SharedPreferences.Editor edit = this.aq.edit();
            edit.putInt(o, i2);
            edit.commit();
        }
    }

    public void I(long j2) {
        synchronized (this.av) {
            this.aq.edit().putLong(b, j2).commit();
        }
    }

    public void I(String str) {
        synchronized (this.av) {
            if (!TextUtils.isEmpty(str)) {
                this.aq.edit().putString(m, str).commit();
            }
        }
    }

    public void I(boolean z2) {
        synchronized (this.av) {
            this.aq.edit().putBoolean("full_screen_notify", z2).commit();
        }
    }

    public int J() {
        int i2;
        synchronized (this.av) {
            Integer num = null;
            if (this.at != null) {
                num = com.huawei.openalliance.ad.utils.au.F(this.at.get(K));
            }
            if (num != null && num.intValue() > 0) {
                i2 = num.intValue();
            }
            i2 = 56;
        }
        return i2;
    }

    public int K() {
        int i2;
        synchronized (this.av) {
            Integer num = null;
            if (this.at != null) {
                num = com.huawei.openalliance.ad.utils.au.F(this.at.get(N));
            }
            if (num != null && num.intValue() > 0) {
                i2 = num.intValue();
            }
            i2 = 16;
        }
        return i2;
    }

    public int L() {
        int i2;
        synchronized (this.av) {
            i2 = this.aq.getInt(f8875a, 2000);
        }
        return i2;
    }

    public int M() {
        int i2;
        synchronized (this.av) {
            Integer num = null;
            if (this.at != null) {
                num = com.huawei.openalliance.ad.utils.au.F(this.at.get(O));
            }
            if (num != null && num.intValue() > 0) {
                i2 = num.intValue();
            }
            i2 = 36;
        }
        return i2;
    }

    public int N() {
        int i2;
        synchronized (this.av) {
            Integer num = null;
            synchronized (this.av) {
                if (this.at != null) {
                    num = com.huawei.openalliance.ad.utils.au.F(this.at.get(Q));
                }
                if (num != null && num.intValue() >= 0) {
                    i2 = num.intValue();
                }
                i2 = 60;
            }
        }
        return i2;
    }

    public int O() {
        int i2;
        synchronized (this.av) {
            Integer num = null;
            synchronized (this.av) {
                if (this.at != null) {
                    num = com.huawei.openalliance.ad.utils.au.F(this.at.get(U));
                }
                if (num != null && num.intValue() > 0) {
                    i2 = num.intValue();
                }
                i2 = 200;
            }
        }
        return i2;
    }

    public Map<String, String> P() {
        Map<String, String> map;
        synchronized (this.av) {
            map = null;
            synchronized (this.av) {
                if (this.at != null) {
                    map = (Map) com.huawei.openalliance.ad.utils.z.V(this.at.get(R), Map.class, new Class[0]);
                }
            }
        }
        return map;
    }

    public Long Q() {
        long j2;
        synchronized (this.av) {
            j2 = this.aq.getLong(ab, 0L);
        }
        return Long.valueOf(j2);
    }

    public int R() {
        int i2;
        synchronized (this.av) {
            i2 = this.aq.getInt(ac, 0);
        }
        return i2;
    }

    public long S() {
        long max;
        synchronized (this.av) {
            max = Math.max(this.aq.getLong(Z, 1800000L), 300000L);
        }
        return max;
    }

    public void S(int i2) {
        synchronized (this.av) {
            this.aq.edit().putInt(ag, i2).commit();
        }
    }

    public String T() {
        String string;
        synchronized (this.av) {
            string = this.aq.getString(ad, null);
        }
        return string;
    }

    public int U() {
        int i2;
        synchronized (this.av) {
            i2 = this.aq.getInt(ae, 100);
        }
        return i2;
    }

    public int V() {
        int i2;
        synchronized (this.av) {
            i2 = this.aq.getInt(C, 3000);
        }
        return i2;
    }

    public int V(Context context) {
        int i2;
        synchronized (this.av) {
            boolean f2 = com.huawei.openalliance.ad.utils.v.f(context);
            int i3 = f2 ? 98 : 64;
            int i4 = f2 ? 119 : 85;
            Integer num = null;
            if (this.at != null) {
                num = com.huawei.openalliance.ad.utils.au.F(this.at.get(M));
            }
            i2 = i3;
            if (num != null) {
                i2 = i3;
                if (num.intValue() > 0) {
                    i2 = num.intValue() > i4 ? i3 : num.intValue();
                }
            }
        }
        return i2;
    }

    public void V(int i2) {
        synchronized (this.av) {
            this.aq.edit().putInt(f8875a, i2).commit();
        }
    }

    public void V(long j2) {
        synchronized (this.av) {
            if (j2 > 0) {
                this.aq.edit().putLong(ab, j2).commit();
            }
        }
    }

    public void V(String str) {
        synchronized (this.av) {
            if (!TextUtils.isEmpty(str)) {
                this.aq.edit().putString(ad, str).commit();
            }
        }
    }

    public void V(boolean z2) {
        synchronized (this.av) {
            this.aq.edit().putBoolean(j, z2).commit();
        }
    }

    public String W() {
        String string;
        synchronized (this.av) {
            string = this.aq.getString(af, this.aw);
        }
        return string;
    }

    public boolean X() {
        boolean z2;
        synchronized (this.av) {
            z2 = this.aq.getBoolean("full_screen_notify", true);
        }
        return z2;
    }

    public int Y() {
        int i2;
        synchronized (this.av) {
            i2 = this.aq.getInt(ai, 0);
        }
        return i2;
    }

    public int Z() {
        int i2;
        synchronized (this.av) {
            int i3 = this.aq.getInt(S, 0);
            i2 = i3;
            if (i3 == 0) {
                i2 = ap();
                if (i2 == 1) {
                    i2 = 0;
                }
            }
        }
        return i2;
    }

    public void Z(int i2) {
        synchronized (this.av) {
            if (i2 > 0) {
                this.aq.edit().putInt(ac, i2).commit();
            }
        }
    }

    public void Z(String str) {
        synchronized (this.av) {
            if (!com.huawei.openalliance.ad.utils.au.Code(str)) {
                this.aq.edit().putString(af, str).commit();
            }
        }
    }

    public void Z(boolean z2) {
        synchronized (this.av) {
            this.aq.edit().putBoolean(al, z2).commit();
        }
    }

    public int a() {
        int i2;
        synchronized (this.av) {
            int i3 = 2000;
            if (1 == I()) {
                i3 = D();
            }
            if (com.huawei.openalliance.ad.utils.l.V(this.ax)) {
                i3 = L();
            }
            i2 = this.aq.getInt(D, i3);
        }
        return i2;
    }

    public int aa() {
        synchronized (this.av) {
            if (dt.Code(this.ax).V()) {
                return this.aq.getInt(az, 0);
            }
            return 0;
        }
    }

    public int ab() {
        int i2;
        synchronized (this.av) {
            i2 = this.aq.getInt(aj, 0);
        }
        return i2 * 1000;
    }

    public boolean ac() {
        boolean z2;
        synchronized (this.av) {
            z2 = this.aq.getBoolean(al, false);
        }
        return z2;
    }

    public int ad() {
        synchronized (this.av) {
            Integer num = null;
            if (!com.huawei.openalliance.ad.utils.af.Code(this.at)) {
                num = com.huawei.openalliance.ad.utils.au.F(this.at.get("preRequest"));
            }
            if (num == null) {
                return 0;
            }
            return num.intValue();
        }
    }

    public boolean ae() {
        boolean z2;
        synchronized (this.av) {
            Integer num = null;
            if (this.at != null) {
                num = com.huawei.openalliance.ad.utils.au.F(this.at.get(X));
            }
            z2 = true;
            if (num == null || num.intValue() != 1) {
                z2 = false;
            }
        }
        return z2;
    }

    public long af() {
        long j2;
        synchronized (this.av) {
            j2 = this.aq.getLong(b, 0L);
        }
        return j2;
    }

    public int ag() {
        int i2;
        synchronized (this.av) {
            i2 = this.aq.getInt(aB, 30);
        }
        return i2;
    }

    public String ah() {
        String string;
        synchronized (this.av) {
            string = this.aq.getString(aA, "");
        }
        return string;
    }

    public Set<String> ai() {
        Set<String> stringSet;
        synchronized (this.av) {
            stringSet = this.aq.getStringSet(aE, new HashSet());
        }
        return stringSet;
    }

    public boolean aj() {
        synchronized (this.av) {
            if (com.huawei.openalliance.ad.utils.l.V(this.ax)) {
                ge.Code(Code, "isSingleMediaPlayerInstance, is tv");
                Set<String> stringSet = this.aq.getStringSet(aF, new HashSet());
                String Code2 = com.huawei.openalliance.ad.utils.l.Code();
                if (!aa.Code(stringSet) && !TextUtils.isEmpty(Code2)) {
                    return com.huawei.openalliance.ad.utils.au.Code(stringSet, Code2.toUpperCase(Locale.ENGLISH));
                }
                return true;
            }
            return false;
        }
    }

    public String ak() {
        String string;
        synchronized (this.av) {
            string = this.aq.getString("sha256", "");
        }
        return string;
    }

    public long b() {
        long j2;
        synchronized (this.av) {
            j2 = this.aq.getLong(f8876c, 300L);
        }
        return j2;
    }

    public int c() {
        int i2;
        synchronized (this.av) {
            i2 = this.aq.getInt(d, 0);
        }
        return i2;
    }

    public int d() {
        int i2;
        synchronized (this.av) {
            i2 = this.aq.getInt(e, 0);
        }
        return i2;
    }

    public String e() {
        String string;
        synchronized (this.av) {
            string = this.aq.getString(f, "");
        }
        return string;
    }

    public boolean f() {
        boolean z2;
        synchronized (this.av) {
            z2 = this.aq.getBoolean(i, false);
        }
        return z2;
    }

    public boolean g() {
        boolean z2;
        synchronized (this.av) {
            z2 = this.aq.getBoolean(j, true);
        }
        return z2;
    }

    public long h() {
        long j2;
        synchronized (this.av) {
            j2 = this.aq.getLong(k, 0L);
        }
        return j2;
    }

    public int i() {
        int i2;
        synchronized (this.av) {
            i2 = this.aq.getInt(g, 360);
        }
        return i2;
    }

    public long j() {
        long j2;
        synchronized (this.av) {
            j2 = this.aq.getLong(h, 0L);
        }
        return j2;
    }

    public boolean k() {
        Integer Code2 = com.huawei.openalliance.ad.utils.av.Code(ao(), 1);
        return Code2 != null && Code2.intValue() == 1;
    }

    public Set<String> l() {
        Set<String> stringSet;
        synchronized (this.av) {
            stringSet = this.aq.getStringSet(n, com.huawei.openalliance.ad.constant.v.Code);
        }
        return stringSet;
    }

    public int m() {
        int i2;
        synchronized (this.av) {
            i2 = this.aq.getInt(o, 0);
        }
        return i2;
    }

    public long n() {
        long j2;
        synchronized (this.av) {
            j2 = this.aq.getLong(q, 30L);
        }
        return j2;
    }

    public long o() {
        long j2;
        synchronized (this.av) {
            j2 = this.aq.getInt(s, 60);
        }
        return j2;
    }

    public long p() {
        long j2;
        synchronized (this.av) {
            j2 = this.aq.getLong(r, 120L);
        }
        return j2;
    }

    public int q() {
        int i2;
        synchronized (this.av) {
            i2 = this.aq.getInt(l, 52428800);
        }
        return i2;
    }

    public String r() {
        String string;
        synchronized (this.av) {
            string = this.aq.getString("country_code", null);
        }
        return string;
    }

    public float s() {
        float f2;
        synchronized (this.av) {
            f2 = this.aq.getFloat(v, 0.05f);
        }
        return f2;
    }

    public int t() {
        int i2;
        try {
            return ((Integer) Class.forName("com.huawei.openalliance.ad.ppskit.utils.SdkSpFunctionWrapper").getMethod("getAdsCoreSelection", new Class[0]).invoke(null, new Object[0])).intValue();
        } catch (Throwable th) {
            ge.V(Code, "function wrapper not found");
            if (dt.V(this.ax) || !dt.Code(this.ax).V()) {
                synchronized (this.av) {
                    String Code2 = com.huawei.openalliance.ad.utils.ay.Code(this.ax, com.huawei.openalliance.ad.constant.t.bE);
                    if (!TextUtils.isEmpty(Code2)) {
                        int i3 = com.huawei.openalliance.ad.constant.d.Z.equalsIgnoreCase(Code2) ? 1 : com.huawei.openalliance.ad.constant.d.B.equalsIgnoreCase(Code2) ? 0 : com.huawei.openalliance.ad.constant.d.C.equalsIgnoreCase(Code2) ? 2 : -1;
                        if (i3 != -1) {
                            return i3;
                        }
                    }
                    if (dt.V(this.ax)) {
                        i2 = 0;
                        if (dt.Code(this.ax).V()) {
                        }
                        return this.aq.getInt(Y, i2);
                    }
                    i2 = 1;
                    return this.aq.getInt(Y, i2);
                }
            }
            return 1;
        }
    }

    public String u() {
        String string;
        synchronized (this.av) {
            string = this.aq.getString(aa, "");
        }
        return string;
    }

    public int v() {
        int i2;
        synchronized (this.av) {
            Integer num = null;
            synchronized (this.av) {
                if (this.at != null) {
                    num = com.huawei.openalliance.ad.utils.au.F(this.at.get(w));
                }
                if (num != null && num.intValue() > 0) {
                    i2 = num.intValue();
                }
                i2 = 10;
            }
        }
        return i2;
    }

    public int w() {
        synchronized (this.av) {
            Integer num = null;
            if (this.at != null) {
                num = com.huawei.openalliance.ad.utils.au.F(this.at.get(x));
            }
            if (num != null && num.intValue() >= 0) {
                if (num == null || num.intValue() > 4) {
                    return 0;
                }
                return num.intValue();
            }
            return 0;
        }
    }

    public String x() {
        String str;
        synchronized (this.av) {
            str = null;
            if (this.at != null) {
                str = com.huawei.openalliance.ad.utils.au.V(this.at.get(y));
            }
        }
        return str;
    }

    public int y() {
        int i2;
        synchronized (this.av) {
            Integer num = null;
            if (this.at != null) {
                num = com.huawei.openalliance.ad.utils.au.F(this.at.get(z));
            }
            if (num != null && num.intValue() >= 0 && num.intValue() <= 24) {
                i2 = num.intValue();
            }
            i2 = 3;
        }
        return i2;
    }

    public String z() {
        String str;
        synchronized (this.av) {
            str = null;
            if (this.at != null) {
                str = com.huawei.openalliance.ad.utils.au.V(this.at.get(A));
            }
        }
        return str;
    }
}
