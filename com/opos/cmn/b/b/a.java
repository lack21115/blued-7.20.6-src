package com.opos.cmn.b.b;

import java.lang.reflect.Field;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/b/b/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private Class<?> f24599a;

    public a(Class<?> cls) {
        this.f24599a = cls;
    }

    public Field a(String str) {
        try {
            if (this.f24599a == null || com.opos.cmn.an.c.a.a(str)) {
                return null;
            }
            return this.f24599a.getDeclaredField(str);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("ReflectEngine", "getDeclareField", e);
            return null;
        }
    }

    public void a(Field field, Object obj, Object obj2) {
        try {
            if (this.f24599a == null || field == null || obj == null) {
                return;
            }
            field.setAccessible(true);
            field.set(obj, obj2);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("ReflectEngine", "setFieldValue", e);
        }
    }
}
