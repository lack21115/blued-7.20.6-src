package com.opos.mobad.model.d;

import android.text.TextUtils;
import com.opos.mobad.b.a.x;
import com.opos.mobad.b.a.y;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/model/d/r.class */
public class r {

    /* renamed from: a  reason: collision with root package name */
    private Map<String, Integer> f26444a;
    private Integer[] b;

    /* renamed from: c  reason: collision with root package name */
    private String f26445c;
    private Map<String, Integer> d;
    private Integer[] e;
    private String f;
    private Map<String, Integer> g;
    private Integer[] h;
    private HashMap<String, Integer> i;
    private Integer[] j;
    private HashMap<String, Integer> k;
    private Integer[] l;
    private JSONObject m;

    public r(y yVar, x xVar) {
        c(yVar.V);
        d(yVar.S);
        a(yVar.ba);
        a(xVar);
        if (yVar.aH != null) {
            b(yVar.aH.d);
            e(yVar.aH.g);
            b(yVar.aH.h);
        }
        this.m = new JSONObject();
    }

    private static final StringBuilder a(Integer[] numArr) {
        StringBuilder sb = new StringBuilder();
        if (numArr != null) {
            if (numArr.length > 0) {
                int length = numArr.length;
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= length) {
                        break;
                    }
                    Integer num = numArr[i2];
                    if (num == null) {
                        sb.append(0);
                    } else {
                        sb.append(num);
                    }
                    i = i2 + 1;
                }
            } else {
                return sb;
            }
        }
        return sb;
    }

    private void a(x xVar) {
        if (xVar == null || TextUtils.isEmpty(xVar.d)) {
            return;
        }
        this.f26445c = xVar.d;
    }

    private void a(String str, String str2) {
        try {
            this.m.put(str, str2);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.b("", "append fail", e);
        }
    }

    private void a(List<x> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        this.i = new HashMap<>();
        this.j = new Integer[list.size()];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                return;
            }
            x xVar = list.get(i2);
            if (xVar != null && !TextUtils.isEmpty(xVar.d)) {
                this.i.put(xVar.d, Integer.valueOf(i2));
            }
            i = i2 + 1;
        }
    }

    private void b(x xVar) {
        if (xVar == null || TextUtils.isEmpty(xVar.d)) {
            return;
        }
        this.f = xVar.d;
    }

    private void b(String str, int i) {
        try {
            this.m.put(str, i);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.b("", "append fail", e);
        }
    }

    private void b(List<x> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        this.k = new HashMap<>();
        this.l = new Integer[list.size()];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                return;
            }
            x xVar = list.get(i2);
            if (xVar != null && !TextUtils.isEmpty(xVar.d)) {
                this.k.put(xVar.d, Integer.valueOf(i2));
            }
            i = i2 + 1;
        }
    }

    private void c(List<x> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        this.f26444a = new HashMap();
        this.b = new Integer[list.size()];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                return;
            }
            x xVar = list.get(i2);
            if (xVar != null && !TextUtils.isEmpty(xVar.d)) {
                this.f26444a.put(xVar.d, Integer.valueOf(i2));
            }
            i = i2 + 1;
        }
    }

    private void d(List<x> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        this.d = new HashMap();
        this.e = new Integer[list.size()];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                return;
            }
            x xVar = list.get(i2);
            if (xVar != null && !TextUtils.isEmpty(xVar.d)) {
                this.d.put(xVar.d, Integer.valueOf(i2));
            }
            i = i2 + 1;
        }
    }

    private void e(List<x> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        this.g = new HashMap();
        this.h = new Integer[list.size()];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                return;
            }
            x xVar = list.get(i2);
            if (xVar != null && !TextUtils.isEmpty(xVar.d)) {
                this.g.put(xVar.d, Integer.valueOf(i2));
            }
            i = i2 + 1;
        }
    }

    public String a() {
        StringBuilder a2 = a(this.b);
        if (a2.length() > 0) {
            a("icL", a2.toString());
        }
        StringBuilder a3 = a(this.e);
        if (a3.length() > 0) {
            a("iL", a3.toString());
        }
        StringBuilder a4 = a(this.h);
        if (a4.length() > 0) {
            a("fiL", a4.toString());
        }
        StringBuilder a5 = a(this.j);
        if (a5.length() > 0) {
            a("itrL", a5.toString());
        }
        StringBuilder a6 = a(this.l);
        if (a6.length() > 0) {
            a("fitrL", a6.toString());
        }
        return this.m.toString();
    }

    public void a(String str, int i) {
        Integer num;
        Integer num2;
        Integer num3;
        Integer num4;
        String str2;
        try {
            if (str.equals(this.f26445c)) {
                str2 = "l";
            } else if (!str.equals(this.f)) {
                if (this.d != null && (num4 = this.d.get(str)) != null && num4.intValue() < this.e.length) {
                    this.e[num4.intValue()] = Integer.valueOf(i);
                    return;
                } else if (this.f26444a != null && (num3 = this.f26444a.get(str)) != null && num3.intValue() < this.b.length) {
                    this.b[num3.intValue()] = Integer.valueOf(i);
                    return;
                } else if (this.i != null && (num2 = this.i.get(str)) != null && num2.intValue() < this.j.length) {
                    this.j[num2.intValue()] = Integer.valueOf(i);
                    return;
                } else if (this.k != null && (num = this.k.get(str)) != null && num.intValue() < this.l.length) {
                    this.l[num.intValue()] = Integer.valueOf(i);
                    return;
                } else if (this.g != null) {
                    Integer num5 = this.g.get(str);
                    if (num5 != null && num5.intValue() < this.h.length) {
                        this.h[num5.intValue()] = Integer.valueOf(i);
                        return;
                    }
                    com.opos.cmn.an.f.a.b("", "unknow url:" + str);
                    return;
                } else {
                    return;
                }
            } else {
                str2 = "fi";
            }
            b(str2, i);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.b("", "mark url fail", e);
        }
    }
}
