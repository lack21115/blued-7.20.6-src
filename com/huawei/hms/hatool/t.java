package com.huawei.hms.hatool;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/hatool/t.class */
public class t {

    /* renamed from: a  reason: collision with root package name */
    public List<q> f22792a;
    public String b;

    /* renamed from: c  reason: collision with root package name */
    public String f22793c;
    public String d;

    public t(List<q> list, String str, String str2, String str3) {
        this.f22792a = list;
        this.b = str;
        this.f22793c = str2;
        this.d = str3;
    }

    public void a() {
        if (!"_default_config_tag".equals(this.f22793c)) {
            a(this.f22792a, this.f22793c, this.b);
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        for (q qVar : this.f22792a) {
            String c2 = qVar.c();
            if (TextUtils.isEmpty(c2) || "oper".equals(c2)) {
                arrayList4.add(qVar);
            } else if ("maint".equals(c2)) {
                arrayList.add(qVar);
            } else if ("preins".equals(c2)) {
                arrayList2.add(qVar);
            } else if ("diffprivacy".equals(c2)) {
                arrayList3.add(qVar);
            }
        }
        a(arrayList4, "oper", "_default_config_tag");
        a(arrayList, "maint", "_default_config_tag");
        a(arrayList2, "preins", "_default_config_tag");
        a(arrayList3, "diffprivacy", "_default_config_tag");
    }

    public final void a(List<q> list, String str, String str2) {
        if (list.isEmpty()) {
            return;
        }
        int size = list.size() / 500;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size + 1) {
                return;
            }
            int i3 = i2 * 500;
            List<q> subList = list.subList(i3, Math.min(list.size(), i3 + 500));
            String replace = UUID.randomUUID().toString().replace("-", "");
            long currentTimeMillis = System.currentTimeMillis();
            long b = c.b(str2, str);
            ArrayList arrayList = new ArrayList();
            for (q qVar : subList) {
                if (!r0.a(qVar.b(), currentTimeMillis, b * 86400000)) {
                    arrayList.add(qVar);
                }
            }
            if (arrayList.size() > 0) {
                new u(str2, str, this.d, arrayList, replace).a();
            } else {
                z.e("hmsSdk", "No data to report handler");
            }
            i = i2 + 1;
        }
    }
}
