package com.tencent.thumbplayer.utils;

import android.content.Context;
import android.text.TextUtils;
import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/utils/c.class */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private a f25735a;
    private a b;

    /* renamed from: c  reason: collision with root package name */
    private ArrayList<String> f25736c;
    private String d;

    public c(Context context, String str) {
        this.f25735a = null;
        this.b = null;
        this.f25736c = null;
        this.d = null;
        this.f25735a = a.a(context, str);
        String str2 = str + "_key";
        this.d = str2;
        a a2 = a.a(context, str2);
        this.b = a2;
        ArrayList<String> arrayList = (ArrayList) a2.b(this.d);
        this.f25736c = arrayList;
        if (arrayList == null) {
            this.f25736c = new ArrayList<>();
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
                        Object b = this.f25735a.b(str);
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
                this.f25735a.a();
                this.b.a();
                this.f25736c.clear();
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
            this.f25735a.c(str);
            this.f25736c.remove(str);
            this.b.c(this.d);
            if (!this.f25736c.isEmpty()) {
                this.b.a(this.d, this.f25736c);
            }
        }
    }

    public void a(String str, Serializable serializable) {
        synchronized (this) {
            if (serializable != null) {
                if (!TextUtils.isEmpty(str)) {
                    this.f25735a.c(str);
                    this.f25735a.a(str, serializable);
                    this.f25736c.remove(str);
                    this.f25736c.add(str);
                    this.b.c(this.d);
                    this.b.a(this.d, this.f25736c);
                }
            }
        }
    }

    public Object b(String str) {
        Object b;
        synchronized (this) {
            b = this.f25735a.b(str);
        }
        return b;
    }

    public ArrayList<String> b() {
        ArrayList<String> arrayList;
        synchronized (this) {
            arrayList = (ArrayList) this.f25736c.clone();
        }
        return arrayList;
    }

    public void c() {
        synchronized (this) {
            this.f25735a.a();
            this.b.a();
            this.f25736c.clear();
        }
    }
}
