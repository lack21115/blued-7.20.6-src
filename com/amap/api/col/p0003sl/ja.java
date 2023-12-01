package com.amap.api.col.p0003sl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.amap.api.col.3sl.ja  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/ja.class */
public final class ja {
    private static Map<Class<? extends iz>, iz> d = new HashMap();

    /* renamed from: a  reason: collision with root package name */
    private jd f5200a;
    private SQLiteDatabase b;

    /* renamed from: c  reason: collision with root package name */
    private iz f5201c;

    public ja(Context context, iz izVar) {
        try {
            this.f5200a = new jd(context.getApplicationContext(), izVar.b(), izVar.c(), izVar);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.f5201c = izVar;
    }

    private static ContentValues a(Object obj, jb jbVar) {
        ContentValues contentValues = new ContentValues();
        Field[] a2 = a(obj.getClass(), jbVar.b());
        int length = a2.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return contentValues;
            }
            Field field = a2[i2];
            field.setAccessible(true);
            a(obj, field, contentValues);
            i = i2 + 1;
        }
    }

    private SQLiteDatabase a() {
        try {
            if (this.b == null) {
                this.b = this.f5200a.getReadableDatabase();
            }
        } catch (Throwable th) {
            it.a(th, "dbs", "grd");
        }
        return this.b;
    }

    public static iz a(Class<? extends iz> cls) throws IllegalAccessException, InstantiationException {
        iz izVar;
        synchronized (ja.class) {
            try {
                if (d.get(cls) == null) {
                    d.put(cls, cls.newInstance());
                }
                izVar = d.get(cls);
            } catch (Throwable th) {
                throw th;
            }
        }
        return izVar;
    }

    private static <T> T a(Cursor cursor, Class<T> cls, jb jbVar) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Field[] a2 = a((Class<?>) cls, jbVar.b());
        Constructor<T> declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
        declaredConstructor.setAccessible(true);
        T newInstance = declaredConstructor.newInstance(new Object[0]);
        for (Field field : a2) {
            field.setAccessible(true);
            Annotation annotation = field.getAnnotation(jc.class);
            if (annotation != null) {
                jc jcVar = (jc) annotation;
                int b = jcVar.b();
                int columnIndex = cursor.getColumnIndex(jcVar.a());
                switch (b) {
                    case 1:
                        field.set(newInstance, Short.valueOf(cursor.getShort(columnIndex)));
                        continue;
                    case 2:
                        field.set(newInstance, Integer.valueOf(cursor.getInt(columnIndex)));
                        continue;
                    case 3:
                        field.set(newInstance, Float.valueOf(cursor.getFloat(columnIndex)));
                        continue;
                    case 4:
                        field.set(newInstance, Double.valueOf(cursor.getDouble(columnIndex)));
                        continue;
                    case 5:
                        field.set(newInstance, Long.valueOf(cursor.getLong(columnIndex)));
                        continue;
                    case 6:
                        field.set(newInstance, cursor.getString(columnIndex));
                        continue;
                    case 7:
                        field.set(newInstance, cursor.getBlob(columnIndex));
                        continue;
                }
            }
        }
        return newInstance;
    }

    private static <T> String a(jb jbVar) {
        if (jbVar == null) {
            return null;
        }
        return jbVar.a();
    }

    private static <T> void a(SQLiteDatabase sQLiteDatabase, T t) {
        jb b = b((Class) t.getClass());
        String a2 = a(b);
        if (TextUtils.isEmpty(a2) || t == null || sQLiteDatabase == null) {
            return;
        }
        sQLiteDatabase.insert(a2, null, a(t, b));
    }

    private <T> void a(T t) {
        b((ja) t);
    }

    private static void a(Object obj, Field field, ContentValues contentValues) {
        Annotation annotation = field.getAnnotation(jc.class);
        if (annotation == null) {
            return;
        }
        jc jcVar = (jc) annotation;
        try {
            switch (jcVar.b()) {
                case 1:
                    contentValues.put(jcVar.a(), Short.valueOf(field.getShort(obj)));
                    return;
                case 2:
                    contentValues.put(jcVar.a(), Integer.valueOf(field.getInt(obj)));
                    return;
                case 3:
                    contentValues.put(jcVar.a(), Float.valueOf(field.getFloat(obj)));
                    return;
                case 4:
                    contentValues.put(jcVar.a(), Double.valueOf(field.getDouble(obj)));
                    return;
                case 5:
                    contentValues.put(jcVar.a(), Long.valueOf(field.getLong(obj)));
                    return;
                case 6:
                    contentValues.put(jcVar.a(), (String) field.get(obj));
                    return;
                case 7:
                    contentValues.put(jcVar.a(), (byte[]) field.get(obj));
                    return;
                default:
                    return;
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private <T> void a(String str, Object obj) {
        synchronized (this.f5201c) {
            if (obj == null) {
                return;
            }
            jb b = b((Class) obj.getClass());
            String a2 = a(b);
            if (TextUtils.isEmpty(a2)) {
                return;
            }
            ContentValues a3 = a(obj, b);
            SQLiteDatabase b2 = b();
            this.b = b2;
            if (b2 == null) {
                return;
            }
            b2.update(a2, a3, str, null);
            if (this.b != null) {
                this.b.close();
                this.b = null;
            }
        }
    }

    private static Field[] a(Class<?> cls, boolean z) {
        if (cls == null) {
            return null;
        }
        return z ? cls.getSuperclass().getDeclaredFields() : cls.getDeclaredFields();
    }

    private SQLiteDatabase b() {
        try {
            if (this.b == null || this.b.isReadOnly()) {
                if (this.b != null) {
                    this.b.close();
                }
                this.b = this.f5200a.getWritableDatabase();
            }
        } catch (Throwable th) {
            it.a(th, "dbs", "gwd");
        }
        return this.b;
    }

    private static <T> jb b(Class<T> cls) {
        Annotation annotation = cls.getAnnotation(jb.class);
        if (annotation != null) {
            return (jb) annotation;
        }
        return null;
    }

    private <T> void b(T t) {
        synchronized (this.f5201c) {
            SQLiteDatabase b = b();
            this.b = b;
            if (b == null) {
                return;
            }
            a(b, t);
            if (this.b != null) {
                this.b.close();
                this.b = null;
            }
        }
    }

    private <T> void b(String str, Object obj) {
        a(str, obj);
    }

    private <T> List<T> c(String str, Class<T> cls) {
        Cursor cursor;
        synchronized (this.f5201c) {
            ArrayList arrayList = new ArrayList();
            jb b = b((Class) cls);
            String a2 = a(b);
            if (this.b == null) {
                this.b = a();
            }
            if (this.b == null || TextUtils.isEmpty(a2) || str == null) {
                return arrayList;
            }
            try {
                cursor = this.b.query(a2, null, str, null, null, null, null);
            } catch (Throwable th) {
                th = th;
                cursor = null;
            }
            try {
            } catch (Throwable th2) {
                th = th2;
                it.a(th, "dbs", "sld");
                if (cursor != null) {
                    cursor.close();
                }
                try {
                    if (this.b != null) {
                        this.b.close();
                        this.b = null;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    it.a(th, "dbs", "sld");
                    return arrayList;
                }
                return arrayList;
            }
            if (cursor == null) {
                this.b.close();
                this.b = null;
                if (cursor != null) {
                    cursor.close();
                }
                if (this.b != null) {
                    this.b.close();
                    this.b = null;
                }
                return arrayList;
            }
            while (cursor.moveToNext()) {
                arrayList.add(a(cursor, cls, b));
            }
            if (cursor != null) {
                cursor.close();
            }
            try {
                if (this.b != null) {
                    this.b.close();
                    this.b = null;
                }
            } catch (Throwable th4) {
                th = th4;
                it.a(th, "dbs", "sld");
                return arrayList;
            }
            return arrayList;
        }
    }

    public final void a(Object obj, String str) {
        synchronized (this.f5201c) {
            List b = b(str, (Class) obj.getClass());
            if (b != null && b.size() != 0) {
                b(str, obj);
            }
            a((ja) obj);
        }
    }

    public final <T> void a(String str, Class<T> cls) {
        synchronized (this.f5201c) {
            String a2 = a(b((Class) cls));
            if (TextUtils.isEmpty(a2)) {
                return;
            }
            SQLiteDatabase b = b();
            this.b = b;
            if (b == null) {
                return;
            }
            b.delete(a2, str, null);
            if (this.b != null) {
                this.b.close();
                this.b = null;
            }
        }
    }

    public final <T> void a(List<T> list) {
        synchronized (this.f5201c) {
            if (list.size() == 0) {
                return;
            }
            SQLiteDatabase b = b();
            this.b = b;
            if (b == null) {
                return;
            }
            b.beginTransaction();
            for (T t : list) {
                a(this.b, t);
            }
            this.b.setTransactionSuccessful();
            if (this.b.inTransaction()) {
                this.b.endTransaction();
            }
            try {
                this.b.close();
                this.b = null;
            } catch (Throwable th) {
                it.a(th, "dbs", "ild");
            }
        }
    }

    public final <T> List<T> b(String str, Class<T> cls) {
        return c(str, cls);
    }
}
