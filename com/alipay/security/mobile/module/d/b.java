package com.alipay.security.mobile.module.d;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import org.json.JSONObject;

/* loaded from: source-6737240-dex2jar.jar:com/alipay/security/mobile/module/d/b.class */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private File f4710a;
    private com.alipay.security.mobile.module.http.v2.a b;

    public b(String str, com.alipay.security.mobile.module.http.v2.a aVar) {
        this.f4710a = null;
        this.b = null;
        this.f4710a = new File(str);
        this.b = aVar;
    }

    private static String a(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", "id");
            jSONObject.put("error", str);
            return jSONObject.toString();
        } catch (Exception e) {
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        synchronized (this) {
            if (this.f4710a == null) {
                return;
            }
            if (this.f4710a.exists() && this.f4710a.isDirectory() && this.f4710a.list().length != 0) {
                ArrayList arrayList = new ArrayList();
                String[] list = this.f4710a.list();
                int length = list.length;
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= length) {
                        break;
                    }
                    arrayList.add(list[i2]);
                    i = i2 + 1;
                }
                Collections.sort(arrayList);
                String str = (String) arrayList.get(arrayList.size() - 1);
                int size = arrayList.size();
                String str2 = str;
                int i3 = size;
                if (str.equals(new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime()) + com.anythink.china.common.a.a.f)) {
                    if (arrayList.size() < 2) {
                        return;
                    }
                    str2 = (String) arrayList.get(arrayList.size() - 2);
                    i3 = size - 1;
                }
                int i4 = i3;
                int i5 = 0;
                if (!this.b.a(a(com.alipay.security.mobile.module.a.b.a(this.f4710a.getAbsolutePath(), str2)))) {
                    i4 = i3 - 1;
                    i5 = 0;
                }
                while (i5 < i4) {
                    new File(this.f4710a, (String) arrayList.get(i5)).delete();
                    i5++;
                }
            }
        }
    }

    public final void a() {
        new Thread(new c(this)).start();
    }
}
