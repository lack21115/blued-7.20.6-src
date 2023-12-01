package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.commonsdk.config.FieldManager;

/* loaded from: source-8829756-dex2jar.jar:com/umeng/commonsdk/statistics/idtracking/j.class */
public class j extends a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f40927a = "utdid";
    private Context b;

    public j(Context context) {
        super("utdid");
        this.b = context;
    }

    private String g() {
        try {
            return this.b.getSharedPreferences("Alvin2", 0).getString("UTDID2", null);
        } catch (Throwable th) {
            return null;
        }
    }

    private String h() {
        try {
            return this.b.getSharedPreferences("um_push_ut", 0).getString("d_id", null);
        } catch (Throwable th) {
            return null;
        }
    }

    @Override // com.umeng.commonsdk.statistics.idtracking.a
    public String f() {
        try {
            if (FieldManager.allow(com.umeng.commonsdk.utils.d.u)) {
                String h = h();
                String str = h;
                if (TextUtils.isEmpty(h)) {
                    str = g();
                }
                return str;
            }
            return null;
        } catch (Throwable th) {
            return null;
        }
    }
}
