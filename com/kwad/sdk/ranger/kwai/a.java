package com.kwad.sdk.ranger.kwai;

import android.text.TextUtils;
import android.util.Log;
import com.kwad.sdk.utils.s;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/ranger/kwai/a.class */
public class a extends com.kwad.sdk.core.response.kwai.a {
    public static final String TAG = "Ranger_" + a.class.getSimpleName();
    public Object ayn;
    public String ayo;
    public String ayp;
    public boolean ayq;
    public String ayr;
    public b ays;
    public a ayt;

    /* renamed from: com.kwad.sdk.ranger.kwai.a$a  reason: collision with other inner class name */
    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/ranger/kwai/a$a.class */
    public static class C0577a extends com.kwad.sdk.core.response.kwai.a {
        public List<Object> ayA;
        public String ayu;
        public String ayv;
        public String ayw;
        public List<String> ayx;
        public List<C0577a> ayy = new ArrayList();
        public Object ayz;
        public String className;
        public String fieldName;

        private Object Cs() {
            Object obj;
            Object obj2 = null;
            try {
            } catch (Exception e) {
                com.kwad.sdk.core.d.b.d(a.TAG, Log.getStackTraceString(e));
                obj = obj2;
            }
            if (TextUtils.isEmpty(this.className)) {
                com.kwad.sdk.core.d.b.w(a.TAG, "SpecialParam className is null");
                return null;
            }
            Object eA = s.eA(this.className);
            String str = a.TAG;
            StringBuilder sb = new StringBuilder("Class.forName(className):");
            sb.append(this.className);
            sb.append(" value:");
            sb.append(eA);
            com.kwad.sdk.core.d.b.d(str, sb.toString());
            obj = eA;
            if (this.ayy != null) {
                obj = eA;
                if (!this.ayy.isEmpty()) {
                    Iterator<C0577a> it = this.ayy.iterator();
                    while (true) {
                        obj = eA;
                        if (!it.hasNext()) {
                            break;
                        }
                        C0577a next = it.next();
                        next.ayz = eA;
                        String str2 = a.TAG;
                        StringBuilder sb2 = new StringBuilder("param.ob:");
                        sb2.append(next.ayz);
                        obj2 = eA;
                        com.kwad.sdk.core.d.b.d(str2, sb2.toString());
                        try {
                            obj2 = next.getValue();
                            s.a(next.ayz, next.fieldName, obj2);
                        } catch (Exception e2) {
                            com.kwad.sdk.core.d.b.d(a.TAG, Log.getStackTraceString(e2));
                        }
                    }
                }
            }
            com.kwad.sdk.core.d.b.d(a.TAG, "return value in special:" + obj);
            return obj;
        }

        private Object Ct() {
            if (TextUtils.isEmpty(this.ayw)) {
                return Y(this.ayu, this.ayv);
            }
            this.ayA = new ArrayList();
            for (String str : this.ayx) {
                Object Y = Y(this.ayw, str);
                if (Y != null) {
                    this.ayA.add(Y);
                }
            }
            return this.ayA;
        }

        private static Object Y(String str, String str2) {
            try {
                Class<?> cls = Class.forName(str);
                if (cls == Integer.class) {
                    return Integer.valueOf(Integer.parseInt(str2));
                }
                if (cls == Long.class) {
                    return Long.valueOf(Long.parseLong(str2));
                }
                if (cls == Float.class) {
                    return Float.valueOf(Float.parseFloat(str2));
                }
                if (cls == Boolean.class) {
                    return Boolean.valueOf(Boolean.parseBoolean(str2));
                }
                if (cls == Double.class) {
                    return Double.valueOf(Double.parseDouble(str2));
                }
                if (cls != String.class) {
                    str2 = null;
                }
                return str2;
            } catch (Exception e) {
                com.kwad.sdk.core.d.b.w(a.TAG, Log.getStackTraceString(e));
                return null;
            }
        }

        public final Object getValue() {
            return (TextUtils.isEmpty(this.ayu) && TextUtils.isEmpty(this.ayw)) ? Cs() : Ct();
        }
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/ranger/kwai/a$b.class */
    public static class b extends com.kwad.sdk.core.response.kwai.a {
        public boolean ayB;
        public List<C0577a> ayC;
        public Object[] ayD;
        public String name;

        public final boolean Cr() {
            return TextUtils.isEmpty(this.name) && this.ayC == null && this.ayD == null;
        }

        public final Object[] Cu() {
            List<C0577a> list = this.ayC;
            if (list == null || list.isEmpty()) {
                return null;
            }
            Object[] objArr = new Object[this.ayC.size()];
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.ayC.size()) {
                    return objArr;
                }
                objArr[i2] = this.ayC.get(i2).getValue();
                i = i2 + 1;
            }
        }
    }

    public final boolean Cr() {
        if (this.ayn == null && TextUtils.isEmpty(this.ayo) && TextUtils.isEmpty(this.ayp) && TextUtils.isEmpty(this.ayr)) {
            b bVar = this.ays;
            if (bVar == null || bVar.Cr()) {
                a aVar = this.ayt;
                return aVar == null || aVar.Cr();
            }
            return false;
        }
        return false;
    }
}
