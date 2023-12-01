package com.kuaishou.weapon.p0;

import android.app.Application;
import android.content.Context;
import android.content.IntentFilter;
import android.text.TextUtils;
import android.util.Log;
import com.kuaishou.weapon.p0.receiver.WeaponRECE;
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kuaishou/weapon/p0/WeaponHI.class */
public class WeaponHI {
    public static boolean as = false;
    public static String cookieData = "";
    public static String encryENV = "";
    public static String hostVersionName = "";
    public static int ii = 0;
    public static List<Integer> isList;
    public static Context mContext;
    public static IWeaponInitParams mParams;
    public static String sChannel = "";
    public static String sKDeviceId = "";
    public static String sKSAppkey = "";
    public static String sKSSdkver = "";
    public static String sKSSecKey = "";
    public static String sUserId = "";
    public static String skProductName = "";

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x0086 -> B:17:0x003b). Please submit an issue!!! */
    public static void iD() {
        try {
            iP(mContext);
            WeaponRECE weaponRECE = new WeaponRECE();
            Application application = null;
            if (mContext instanceof Application) {
                application = (Application) mContext;
            }
            if (application != null) {
                IntentFilter intentFilter = new IntentFilter(bp.f);
                intentFilter.addDataScheme(com.umeng.analytics.pro.at.f26942a);
                application.registerReceiver(weaponRECE, intentFilter);
            }
        } catch (Throwable th) {
        }
        try {
            da.a(mContext).a(100);
            cw.a(mContext).a(100);
            db.a(mContext).a(100);
            cz.a(mContext).a(100, 0);
            cx.a(mContext).a(100);
            cy.a(mContext).a();
            dc.a(mContext).a();
        } catch (Exception e) {
        }
    }

    public static void iP(Context context) {
        try {
            long b = de.a(context).b();
            long currentTimeMillis = System.currentTimeMillis();
            long c2 = h.a(context, "re_po_rt").c(de.h, 12);
            if (b < 1 || (currentTimeMillis - b) - (c2 * 3600000) > 0) {
                n.a().a(new cv(context));
            }
        } catch (Throwable th) {
        }
    }

    public static void init(Context context, final IWeaponInitParams iWeaponInitParams) {
        try {
            Context applicationContext = context.getApplicationContext();
            mContext = applicationContext;
            if (applicationContext instanceof Application) {
                n.a().a(new Runnable() { // from class: com.kuaishou.weapon.p0.WeaponHI.2
                    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0123 -> B:11:0x010e). Please submit an issue!!! */
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            WeaponHI.mParams = IWeaponInitParams.this;
                            WeaponHI.sKSAppkey = IWeaponInitParams.this.getAppKey();
                            WeaponHI.sKSSecKey = IWeaponInitParams.this.getSecKey();
                            WeaponHI.sKSSdkver = "5.0.9";
                            WeaponHI.hostVersionName = bg.q(WeaponHI.mContext);
                            WeaponHI.sKDeviceId = IWeaponInitParams.this.getDeviceId();
                            WeaponHI.skProductName = IWeaponInitParams.this.getProductName();
                            WeaponHI.sUserId = IWeaponInitParams.this.getUserId();
                            WeaponHI.sChannel = IWeaponInitParams.this.getChannel();
                            WeaponHI.as = IWeaponInitParams.this.getAPPLISTSwitch();
                            WeaponHI.cookieData = bg.B(WeaponHI.mContext);
                            try {
                                h a2 = h.a(WeaponHI.mContext, "re_po_rt");
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put("k", cl.m());
                                jSONObject.put("d", cl.b(WeaponHI.mContext));
                                jSONObject.put("a", bg.q(WeaponHI.mContext));
                                jSONObject.put("p", bg.s(WeaponHI.mContext));
                                jSONObject.put("s", "5.0.9");
                                jSONObject.put("n", TextUtils.isEmpty(a2.a(de.g)) ? 1 : 0);
                                WeaponHI.encryENV = new bm(WeaponHI.mContext).c(jSONObject.toString());
                                String a3 = a2.a(de.s);
                                if (!TextUtils.isEmpty(a3)) {
                                    WeaponHI.isList = Arrays.asList(a3.split("\\|"));
                                    WeaponHI.ii = a2.c(de.t, 5);
                                }
                            } catch (Throwable th) {
                            }
                            WeaponHI.init(WeaponHI.sKSAppkey, WeaponHI.sKSSecKey, IWeaponInitParams.this.getPrivacySwitch());
                        } catch (Throwable th2) {
                        }
                    }
                });
            } else {
                Log.e("Risk", "context  is not application！！！");
            }
        } catch (Throwable th) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:6:0x0031 -> B:3:0x0023). Please submit an issue!!! */
    public static void init(String str, String str2, boolean z) {
        try {
            h.a(mContext, "re_po_rt").a("a1_p_s_p_s", Boolean.valueOf(z));
            n.a();
            bs.a(mContext);
            br.a(mContext);
        } catch (Exception e) {
        }
        n.a().a(new Runnable() { // from class: com.kuaishou.weapon.p0.WeaponHI.3
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    q a2 = q.a(WeaponHI.mContext);
                    if (a2 == null) {
                        return;
                    }
                    a2.a();
                } catch (Exception e2) {
                }
            }
        });
    }

    public static void setPS(final boolean z) {
        try {
            n.a().a(new Runnable() { // from class: com.kuaishou.weapon.p0.WeaponHI.1
                @Override // java.lang.Runnable
                public final void run() {
                    if (WeaponHI.mContext != null) {
                        h a2 = h.a(WeaponHI.mContext, "re_po_rt");
                        boolean z2 = z;
                        if (!z2) {
                            a2.a("a1_p_s_p_s_c_b", Boolean.valueOf(z2));
                        } else if (a2.e("a1_p_s_p_s_c_b")) {
                        } else {
                            a2.a("a1_p_s_p_s_c_b", Boolean.valueOf(z));
                            try {
                                if (a2.c(de.bi, 1) == 1) {
                                    da.a(WeaponHI.mContext).a(103);
                                    db.a(WeaponHI.mContext).a(103);
                                    cz.a(WeaponHI.mContext).a(103, 0);
                                    cx.a(WeaponHI.mContext).a(103);
                                }
                            } catch (Throwable th) {
                            }
                        }
                    }
                }
            });
        } catch (Exception e) {
        }
    }
}
