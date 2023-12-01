package com.tencent.thumbplayer.utils;

import android.content.Context;
import android.text.TextUtils;
import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/utils/c.class */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private a f39426a;
    private a b;

    /* renamed from: c  reason: collision with root package name */
    private ArrayList<String> f39427c;
    private String d;

    public c(Context context, String str) {
        this.f39426a = null;
        this.b = null;
        this.f39427c = null;
        this.d = null;
        this.f39426a = a.a(context, str);
        String str2 = str + "_key";
        this.d = str2;
        a a2 = a.a(context, str2);
        this.b = a2;
        ArrayList<String> arrayList = (ArrayList) a2.b(this.d);
        this.f39427c = arrayList;
        if (arrayList == null) {
            this.f39427c = new ArrayList<>();
        }
    }

    public Object a() {
        synchronized (this) {
            ArrayList arrayList = (ArrayList) this.b.b(this.d);
            ArrayList arrayList2 = null;
            if (arrayList != null && arrayList.size() > 0) {
                int i = 0;
                while (i < arrayList.size()) {
                    String str = (String) arrayList.get(i);
                    ArrayList arrayList3 = arrayList2;
                    if (!TextUtils.isEmpty(str)) {
                        Object b = this.f39426a.b(str);
                        arrayList3 = arrayList2;
                        if (b != null) {
                            arrayList3 = arrayList2;
                            if (arrayList2 == null) {
                                arrayList3 = new ArrayList();
                            }
                            arrayList3.add(b);
                        }
                    }
                    i++;
                    arrayList2 = arrayList3;
                }
                this.f39426a.a();
                this.b.a();
                this.f39427c.clear();
                return arrayList2;
            }
            return null;
        }
    }

    public void a(String str) {
        synchronized (this) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.f39426a.c(str);
            this.f39427c.remove(str);
            this.b.c(this.d);
            if (!this.f39427c.isEmpty()) {
                this.b.a(this.d, this.f39427c);
            }
        }
    }

    public void a(String str, Serializable serializable) {
        synchronized (this) {
            if (serializable != null) {
                if (!TextUtils.isEmpty(str)) {
                    this.f39426a.c(str);
                    this.f39426a.a(str, serializable);
                    this.f39427c.remove(str);
                    this.f39427c.add(str);
                    this.b.c(this.d);
                    this.b.a(this.d, this.f39427c);
                }
            }
        }
    }

    public Object b(String str) {
        Object b;
        synchronized (this) {
            b = this.f39426a.b(str);
        }
        return b;
    }

    public ArrayList<String> b() {
        ArrayList<String> arrayList;
        synchronized (this) {
            arrayList = (ArrayList) this.f39427c.clone();
        }
        return arrayList;
    }

    public void c() {
        synchronized (this) {
            this.f39426a.a();
            this.b.a();
            this.f39427c.clear();
        }
    }
}
