package com.zk_oaction.adengine.lk_expression;

import com.google.android.material.timepicker.TimeModel;
import com.zk_oaction.adengine.lk_expression.a;
import com.zk_oaction.adengine.lk_expression.c;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_expression/b.class */
public class b implements a.w, c.b {

    /* renamed from: a  reason: collision with root package name */
    private com.zk_oaction.adengine.lk_sdk.c f28229a;
    private c.b b;

    /* renamed from: c  reason: collision with root package name */
    private ArrayList<String> f28230c;
    private ArrayList<Object> d;
    private boolean e = true;

    public b(com.zk_oaction.adengine.lk_sdk.c cVar, String str, String str2, c.b bVar) {
        this.f28229a = cVar;
        this.b = bVar;
        this.f28230c = b(str);
        this.d = c(str2);
        a();
    }

    private void a() {
        String str;
        if (this.e) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("");
            Iterator<String> it = this.f28230c.iterator();
            int i = 0;
            while (it.hasNext()) {
                String next = it.next();
                if (next.equals(TimeModel.NUMBER_FORMAT)) {
                    a aVar = (a) this.d.get(i);
                    int a2 = (int) aVar.a();
                    String str2 = aVar.b;
                    if (str2 == null || (!(str2.equals("#sms_unread_count") || aVar.b.equals("#call_missed_count")) || a2 < 100)) {
                        stringBuffer.append(a2);
                        i++;
                    } else {
                        str = "99+";
                    }
                } else if (next.equals("%s")) {
                    str = ((c) this.d.get(i)).a();
                } else {
                    stringBuffer.append(next);
                }
                stringBuffer.append(str);
                i++;
            }
            this.b.h_(stringBuffer.toString());
        }
    }

    private static ArrayList<String> b(String str) {
        String str2;
        String str3;
        ArrayList<String> arrayList = new ArrayList<>();
        int length = str.length();
        String str4 = "";
        int i = 0;
        boolean z = false;
        while (i < length) {
            char charAt = str.charAt(i);
            if (!z && charAt != '%') {
                str3 = str4 + charAt;
            } else if (z || charAt != '%') {
                if (charAt == 'd') {
                    str2 = TimeModel.NUMBER_FORMAT;
                } else if (charAt == '%') {
                    str2 = "%";
                } else {
                    if (charAt == 's') {
                        str2 = "%s";
                    }
                    z = false;
                    str3 = str4;
                }
                arrayList.add(str2);
                z = false;
                str3 = str4;
            } else {
                arrayList.add(str4);
                z = true;
                str3 = "";
            }
            i++;
            str4 = str3;
        }
        if (!str4.equals("")) {
            arrayList.add(str4);
        }
        return arrayList;
    }

    private ArrayList<Object> c(String str) {
        ArrayList<Object> arrayList = new ArrayList<>();
        if (str != null) {
            Iterator<String> it = a.a(str).iterator();
            while (it.hasNext()) {
                String next = it.next();
                arrayList.add(next.contains("@") ? new c(this.f28229a, next, this) : new a(this.f28229a, null, next, 0.0f, this, false));
            }
        }
        return arrayList;
    }

    @Override // com.zk_oaction.adengine.lk_expression.a.w
    public void a(String str, float f) {
        a();
    }

    @Override // com.zk_oaction.adengine.lk_expression.c.b
    public void h_(String str) {
        a();
    }
}
