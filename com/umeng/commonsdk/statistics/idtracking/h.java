package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import android.content.SharedPreferences;
import com.umeng.analytics.pro.at;
import com.umeng.commonsdk.config.FieldManager;

/* loaded from: source-8829756-dex2jar.jar:com/umeng/commonsdk/statistics/idtracking/h.class */
public class h extends a {

    /* renamed from: a  reason: collision with root package name */
    public static final String f40924a = at.b().b(at.l);
    public static final String b = "key_umeng_sp_oaid";

    /* renamed from: c  reason: collision with root package name */
    public static final String f40925c = "key_umeng_sp_oaid_required_time";
    private static final String d = "oaid";
    private Context e;

    public h(Context context) {
        super("oaid");
        this.e = context;
    }

    @Override // com.umeng.commonsdk.statistics.idtracking.a
    public String f() {
        String str = null;
        if (FieldManager.allow(com.umeng.commonsdk.utils.d.G)) {
            try {
                SharedPreferences sharedPreferences = this.e.getSharedPreferences(f40924a, 0);
                str = null;
                if (sharedPreferences != null) {
                    str = sharedPreferences.getString(b, "");
                }
            } catch (Throwable th) {
                return null;
            }
        }
        return str;
    }
}
