package com.xiaomi.push;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.j256.ormlite.stmt.query.SimpleComparison;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/gi.class */
public class gi implements gm {

    /* renamed from: a  reason: collision with root package name */
    private String f27745a;

    /* renamed from: a  reason: collision with other field name */
    private List<gi> f463a;

    /* renamed from: a  reason: collision with other field name */
    private String[] f464a;
    private String b;

    /* renamed from: b  reason: collision with other field name */
    private String[] f465b;

    /* renamed from: c  reason: collision with root package name */
    private String f27746c;

    public gi(String str, String str2, String[] strArr, String[] strArr2) {
        this.f464a = null;
        this.f465b = null;
        this.f463a = null;
        this.f27745a = str;
        this.b = str2;
        this.f464a = strArr;
        this.f465b = strArr2;
    }

    public gi(String str, String str2, String[] strArr, String[] strArr2, String str3, List<gi> list) {
        this.f464a = null;
        this.f465b = null;
        this.f463a = null;
        this.f27745a = str;
        this.b = str2;
        this.f464a = strArr;
        this.f465b = strArr2;
        this.f27746c = str3;
        this.f463a = list;
    }

    public static gi a(Bundle bundle) {
        ArrayList arrayList;
        String string = bundle.getString("ext_ele_name");
        String string2 = bundle.getString("ext_ns");
        String string3 = bundle.getString("ext_text");
        Bundle bundle2 = bundle.getBundle("attributes");
        Set<String> keySet = bundle2.keySet();
        String[] strArr = new String[keySet.size()];
        String[] strArr2 = new String[keySet.size()];
        Iterator<String> it = keySet.iterator();
        int i = 0;
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                break;
            }
            String next = it.next();
            strArr[i2] = next;
            strArr2[i2] = bundle2.getString(next);
            i = i2 + 1;
        }
        if (bundle.containsKey("children")) {
            Parcelable[] parcelableArray = bundle.getParcelableArray("children");
            arrayList = new ArrayList(parcelableArray.length);
            int length = parcelableArray.length;
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= length) {
                    break;
                }
                arrayList.add(a((Bundle) parcelableArray[i4]));
                i3 = i4 + 1;
            }
        } else {
            arrayList = null;
        }
        return new gi(string, string2, strArr, strArr2, string3, arrayList);
    }

    public static Parcelable[] a(List<gi> list) {
        return a((gi[]) list.toArray(new gi[list.size()]));
    }

    public static Parcelable[] a(gi[] giVarArr) {
        if (giVarArr == null) {
            return null;
        }
        Parcelable[] parcelableArr = new Parcelable[giVarArr.length];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= giVarArr.length) {
                return parcelableArr;
            }
            parcelableArr[i2] = giVarArr[i2].m8760a();
            i = i2 + 1;
        }
    }

    public Bundle a() {
        Bundle bundle = new Bundle();
        bundle.putString("ext_ele_name", this.f27745a);
        bundle.putString("ext_ns", this.b);
        bundle.putString("ext_text", this.f27746c);
        Bundle bundle2 = new Bundle();
        String[] strArr = this.f464a;
        if (strArr != null && strArr.length > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                String[] strArr2 = this.f464a;
                if (i2 >= strArr2.length) {
                    break;
                }
                bundle2.putString(strArr2[i2], this.f465b[i2]);
                i = i2 + 1;
            }
        }
        bundle.putBundle("attributes", bundle2);
        List<gi> list = this.f463a;
        if (list != null && list.size() > 0) {
            bundle.putParcelableArray("children", a(this.f463a));
        }
        return bundle;
    }

    /* renamed from: a  reason: collision with other method in class */
    public Parcelable m8760a() {
        return a();
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m8761a() {
        return this.f27745a;
    }

    public String a(String str) {
        if (str == null) {
            throw new IllegalArgumentException();
        }
        if (this.f464a == null) {
            return null;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            String[] strArr = this.f464a;
            if (i2 >= strArr.length) {
                return null;
            }
            if (str.equals(strArr[i2])) {
                return this.f465b[i2];
            }
            i = i2 + 1;
        }
    }

    public void a(gi giVar) {
        if (this.f463a == null) {
            this.f463a = new ArrayList();
        }
        if (this.f463a.contains(giVar)) {
            return;
        }
        this.f463a.add(giVar);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m8762a(String str) {
        if (TextUtils.isEmpty(str)) {
            this.f27746c = str;
        } else {
            this.f27746c = gw.a(str);
        }
    }

    public String b() {
        return this.b;
    }

    public String c() {
        return !TextUtils.isEmpty(this.f27746c) ? gw.b(this.f27746c) : this.f27746c;
    }

    @Override // com.xiaomi.push.gm
    public String d() {
        StringBuilder sb = new StringBuilder();
        sb.append(SimpleComparison.LESS_THAN_OPERATION);
        sb.append(this.f27745a);
        if (!TextUtils.isEmpty(this.b)) {
            sb.append(" xmlns=\"");
            sb.append(this.b);
            sb.append("\"");
        }
        String[] strArr = this.f464a;
        if (strArr != null && strArr.length > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.f464a.length) {
                    break;
                }
                if (!TextUtils.isEmpty(this.f465b[i2])) {
                    sb.append(" ");
                    sb.append(this.f464a[i2]);
                    sb.append("=\"");
                    sb.append(gw.a(this.f465b[i2]));
                    sb.append("\"");
                }
                i = i2 + 1;
            }
        }
        if (TextUtils.isEmpty(this.f27746c)) {
            List<gi> list = this.f463a;
            if (list == null || list.size() <= 0) {
                sb.append("/>");
                return sb.toString();
            }
            sb.append(SimpleComparison.GREATER_THAN_OPERATION);
            for (gi giVar : this.f463a) {
                sb.append(giVar.d());
            }
        } else {
            sb.append(SimpleComparison.GREATER_THAN_OPERATION);
            sb.append(this.f27746c);
        }
        sb.append("</");
        sb.append(this.f27745a);
        sb.append(SimpleComparison.GREATER_THAN_OPERATION);
        return sb.toString();
    }

    public String toString() {
        return d();
    }
}
