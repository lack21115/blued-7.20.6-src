package com.amap.api.col.p0003sl;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;
import java.io.IOException;

/* renamed from: com.amap.api.col.3sl.bd  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/bd.class */
public final class bd {
    private Context a;

    public bd(Context context) {
        this.a = context;
    }

    private static boolean a(String str, Context context, String str2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String b = dw.b(context);
        try {
            File file = new File(b + str2 + str + ".dat");
            if (file.exists()) {
                if (!bu.b(file)) {
                    return false;
                }
            }
            try {
                bu.a(b + str2);
                bu.b(str, context);
                return true;
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            } catch (Exception e2) {
                e2.printStackTrace();
                return false;
            }
        } catch (IOException e3) {
            e3.printStackTrace();
            return false;
        } catch (Exception e4) {
            e4.printStackTrace();
            return false;
        }
    }

    private boolean b(aw awVar) {
        if (awVar != null) {
            String pinyin = awVar.getPinyin();
            boolean a = a(pinyin, this.a, "vmap/");
            String str = pinyin;
            if (pinyin.equals("quanguogaiyaotu")) {
                str = "quanguo";
            }
            boolean z = a(str, this.a, "map/") || a;
            boolean z2 = true;
            if (!b(bu.b(awVar.getUrl()), this.a, "map/")) {
                z2 = z;
            }
            if (z2) {
                awVar.i();
                return z2;
            }
            awVar.h();
            return false;
        }
        return false;
    }

    private static boolean b(String str, Context context, String str2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String a = dw.a(context);
        try {
            File file = new File(a + str2 + str);
            if (file.exists()) {
                if (!bu.b(file)) {
                    return false;
                }
            }
            try {
                bu.a(a + str2);
                bu.b(str, context);
                return true;
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            } catch (Exception e2) {
                e2.printStackTrace();
                return false;
            }
        } catch (IOException e3) {
            e3.printStackTrace();
            return false;
        } catch (Exception e4) {
            e4.printStackTrace();
            return false;
        }
    }

    public final void a(aw awVar) {
        b(awVar);
    }
}
