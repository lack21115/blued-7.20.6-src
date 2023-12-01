package com.igexin.push.core.e;

import android.database.sqlite.SQLiteDatabase;
import com.igexin.push.f.p;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/push/core/e/b.class */
public final class b implements a {
    private static b b;

    /* renamed from: a  reason: collision with root package name */
    private Map<String, byte[]> f23498a = new HashMap();

    private b() {
    }

    private static b a() {
        if (b == null) {
            b = new b();
        }
        return b;
    }

    private String a(byte[] bArr) {
        String a2;
        do {
            a2 = p.a();
        } while (this.f23498a.containsKey(a2));
        this.f23498a.put(a2, bArr);
        return a2;
    }

    private byte[] a(String str) {
        byte[] bArr;
        synchronized (this) {
            bArr = this.f23498a.get(str);
            if (bArr != null) {
                this.f23498a.remove(str);
            }
        }
        return bArr;
    }

    @Override // com.igexin.push.core.e.a
    public final void a(SQLiteDatabase sQLiteDatabase) {
    }

    @Override // com.igexin.push.core.e.a
    public final void b(SQLiteDatabase sQLiteDatabase) {
    }

    @Override // com.igexin.push.core.e.a
    public final void c(SQLiteDatabase sQLiteDatabase) {
    }
}
