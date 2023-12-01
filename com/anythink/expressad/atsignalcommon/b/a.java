package com.anythink.expressad.atsignalcommon.b;

import com.anythink.expressad.atsignalcommon.b.c;
import com.huawei.openalliance.ad.constant.t;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/atsignalcommon/b/a.class */
public final class a extends Exception {

    /* renamed from: a  reason: collision with root package name */
    private static final long f4220a = 1;
    private List<c.b.a> b;

    private a(String str) {
        super(str);
        this.b = new ArrayList();
    }

    private static a a(a aVar, a aVar2) {
        if (aVar == null) {
            return aVar2;
        }
        if (aVar2 == null) {
            return aVar;
        }
        a aVar3 = new a(aVar.getMessage() + t.aE + aVar2.getMessage());
        aVar3.a(aVar.b);
        aVar3.a(aVar2.b);
        return aVar3;
    }

    private List<c.b.a> a() {
        return this.b;
    }

    private void a(c.b.a aVar) {
        this.b.add(aVar);
    }

    private void a(List<c.b.a> list) {
        this.b.addAll(list);
    }

    @Override // java.lang.Throwable
    public final String toString() {
        StringBuilder sb = new StringBuilder();
        for (c.b.a aVar : this.b) {
            sb.append(aVar.toString());
            sb.append(t.aE);
            try {
                if (aVar.getCause() instanceof NoSuchFieldException) {
                    Field[] declaredFields = aVar.a().getDeclaredFields();
                    sb.append(aVar.a().getName());
                    sb.append(".");
                    sb.append(aVar.c());
                    sb.append(t.aE);
                    for (Field field : declaredFields) {
                        sb.append(field.getName());
                        sb.append("/");
                    }
                } else if (aVar.getCause() instanceof NoSuchMethodException) {
                    Method[] declaredMethods = aVar.a().getDeclaredMethods();
                    sb.append(aVar.a().getName());
                    sb.append("->");
                    sb.append(aVar.b());
                    sb.append(t.aE);
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < declaredMethods.length) {
                            if (aVar.b().equals(declaredMethods[i2].getName())) {
                                sb.append(declaredMethods[i2].toGenericString());
                                sb.append("/");
                            }
                            i = i2 + 1;
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            sb.append("@@@@");
        }
        return sb.toString();
    }
}
