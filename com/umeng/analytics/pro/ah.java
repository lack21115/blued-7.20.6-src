package com.umeng.analytics.pro;

import android.text.TextUtils;
import java.util.ArrayList;

/* loaded from: source-8829756-dex2jar.jar:com/umeng/analytics/pro/ah.class */
public class ah {

    /* renamed from: a  reason: collision with root package name */
    private String f26926a;
    private ArrayList<ai> b = new ArrayList<>();

    public ah(String str) {
        this.f26926a = "";
        this.f26926a = str;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        a();
    }

    private void a() {
        try {
            if (!this.f26926a.contains(",")) {
                String str = this.f26926a;
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                String trim = str.trim();
                if (this.b != null) {
                    this.b.add(new ai(trim));
                    return;
                }
                return;
            }
            String[] split = this.f26926a.split(",");
            int length = split.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    return;
                }
                String str2 = split[i2];
                if (!TextUtils.isEmpty(str2)) {
                    String trim2 = str2.trim();
                    if (this.b != null) {
                        this.b.add(new ai(trim2));
                    }
                }
                i = i2 + 1;
            }
        } catch (Throwable th) {
        }
    }

    public boolean a(int i) {
        try {
            if (this.b == null) {
                return false;
            }
            int size = this.b.size();
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= size) {
                    return false;
                }
                ai aiVar = this.b.get(i3);
                if (aiVar != null && aiVar.a(i)) {
                    return true;
                }
                i2 = i3 + 1;
            }
        } catch (Throwable th) {
            return false;
        }
    }
}
