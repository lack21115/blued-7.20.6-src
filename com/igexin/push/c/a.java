package com.igexin.push.c;

import android.content.Context;
import com.igexin.c.a.b.g;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/push/c/a.class */
public final class a implements com.igexin.c.a.d.a.b<String, Integer, com.igexin.c.a.b.d, com.igexin.c.a.b.f> {
    private static final byte b = 1;

    /* renamed from: c  reason: collision with root package name */
    private static final byte f23319c = 2;
    private static final byte d = 3;

    /* renamed from: a  reason: collision with root package name */
    public Context f23320a;

    public a(Context context) {
        this.f23320a = context;
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static com.igexin.c.a.b.f a2(String str, com.igexin.c.a.b.d dVar) {
        if (str.startsWith("socket") && com.igexin.push.core.e.n) {
            return new com.igexin.c.a.b.a.a.f(str, dVar);
        }
        return null;
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static boolean a2(com.igexin.c.a.b.f fVar) {
        return fVar.b.startsWith("socket") || fVar.b.startsWith("submitTcpException");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static byte b2(com.igexin.c.a.b.f fVar) {
        String[] a2 = g.a(fVar.b);
        if (a2[0].equals("socket")) {
            return (byte) 3;
        }
        return a2[0].equals("http") ? (byte) 2 : (byte) 0;
    }

    @Override // com.igexin.c.a.d.a.b
    public final /* synthetic */ byte a(com.igexin.c.a.b.f fVar) {
        String[] a2 = g.a(fVar.b);
        if (a2[0].equals("socket")) {
            return (byte) 3;
        }
        return a2[0].equals("http") ? (byte) 2 : (byte) 0;
    }

    @Override // com.igexin.c.a.d.a.b
    public final /* synthetic */ com.igexin.c.a.b.f a(String str, com.igexin.c.a.b.d dVar) {
        String str2 = str;
        com.igexin.c.a.b.d dVar2 = dVar;
        if (str2.startsWith("socket") && com.igexin.push.core.e.n) {
            return new com.igexin.c.a.b.a.a.f(str2, dVar2);
        }
        return null;
    }

    @Override // com.igexin.c.a.d.a.b
    public final /* synthetic */ boolean b(com.igexin.c.a.b.f fVar) {
        com.igexin.c.a.b.f fVar2 = fVar;
        return fVar2.b.startsWith("socket") || fVar2.b.startsWith("submitTcpException");
    }
}
