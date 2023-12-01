package org.json.alipay;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;

/* loaded from: source-3503164-dex2jar.jar:org/json/alipay/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private ArrayList f44094a;

    public a() {
        this.f44094a = new ArrayList();
    }

    public a(Object obj) {
        this();
        if (!obj.getClass().isArray()) {
            throw new JSONException("JSONArray initial value should be a string or collection or array.");
        }
        int length = Array.getLength(obj);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            this.f44094a.add(Array.get(obj, i2));
            i = i2 + 1;
        }
    }

    public a(String str) {
        this(new c(str));
    }

    public a(Collection collection) {
        this.f44094a = collection == null ? new ArrayList() : new ArrayList(collection);
    }

    public a(c cVar) {
        this();
        char c2;
        ArrayList arrayList;
        Object d;
        char c3 = cVar.c();
        if (c3 == '[') {
            c2 = ']';
        } else if (c3 != '(') {
            throw cVar.a("A JSONArray text must start with '['");
        } else {
            c2 = ')';
        }
        if (cVar.c() == ']') {
            return;
        }
        do {
            cVar.a();
            char c4 = cVar.c();
            cVar.a();
            if (c4 == ',') {
                arrayList = this.f44094a;
                d = null;
            } else {
                arrayList = this.f44094a;
                d = cVar.d();
            }
            arrayList.add(d);
            char c5 = cVar.c();
            if (c5 != ')') {
                if (c5 != ',' && c5 != ';') {
                    if (c5 != ']') {
                        throw cVar.a("Expected a ',' or ']'");
                    }
                }
            }
            if (c2 == c5) {
                return;
            }
            throw cVar.a("Expected a '" + new Character(c2) + "'");
        } while (cVar.c() != ']');
    }

    private String a(String str) {
        int size = this.f44094a.size();
        StringBuffer stringBuffer = new StringBuffer();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return stringBuffer.toString();
            }
            if (i2 > 0) {
                stringBuffer.append(str);
            }
            stringBuffer.append(b.a(this.f44094a.get(i2)));
            i = i2 + 1;
        }
    }

    public final int a() {
        return this.f44094a.size();
    }

    public final Object a(int i) {
        Object obj = (i < 0 || i >= this.f44094a.size()) ? null : this.f44094a.get(i);
        if (obj != null) {
            return obj;
        }
        throw new JSONException("JSONArray[" + i + "] not found.");
    }

    public String toString() {
        try {
            return "[" + a(",") + ']';
        } catch (Exception e) {
            return null;
        }
    }
}
