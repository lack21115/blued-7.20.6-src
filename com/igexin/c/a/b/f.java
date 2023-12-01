package com.igexin.c.a.b;

import com.blued.android.module.common.web.jsbridge.BridgeUtil;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/c/a/b/f.class */
public abstract class f extends com.igexin.c.a.d.f {
    protected static final int e = -2048;
    public String b;

    /* renamed from: c  reason: collision with root package name */
    public d f23247c;
    public Object d;

    private f(int i, d dVar) {
        this(i, null, dVar);
    }

    public f(int i, String str, d dVar) {
        super(i);
        if (str != null) {
            String[] a2 = g.a(str);
            StringBuilder sb = new StringBuilder();
            if (!a2[0].equals("")) {
                sb.append(a2[0]);
                sb.append("://");
            }
            if (!a2[1].equals("")) {
                sb.append(a2[1]);
            }
            if (!a2[2].equals("")) {
                sb.append(':');
                sb.append(a2[2]);
            }
            if (!a2[3].equals("")) {
                sb.append(a2[3]);
                if (!a2[3].equals(BridgeUtil.SPLIT_MARK)) {
                    sb.append('/');
                }
            }
            if (!a2[4].equals("")) {
                sb.append(a2[4]);
            }
            if (!a2[5].equals("")) {
                sb.append('?');
                sb.append(a2[5]);
            }
            this.b = sb.toString();
        }
        this.f23247c = dVar;
    }

    public f(String str, d dVar) {
        this(0, str, dVar);
    }

    private static String a(String str) {
        String[] a2 = g.a(str);
        StringBuilder sb = new StringBuilder();
        if (!a2[0].equals("")) {
            sb.append(a2[0]);
            sb.append("://");
        }
        if (!a2[1].equals("")) {
            sb.append(a2[1]);
        }
        if (!a2[2].equals("")) {
            sb.append(':');
            sb.append(a2[2]);
        }
        if (!a2[3].equals("")) {
            sb.append(a2[3]);
            if (!a2[3].equals(BridgeUtil.SPLIT_MARK)) {
                sb.append('/');
            }
        }
        if (!a2[4].equals("")) {
            sb.append(a2[4]);
        }
        if (!a2[5].equals("")) {
            sb.append('?');
            sb.append(a2[5]);
        }
        return sb.toString();
    }

    private void a(f fVar) {
        super.a((com.igexin.c.a.d.f) fVar);
        this.b = fVar.b;
        this.f23247c = fVar.f23247c;
    }

    @Override // com.igexin.c.a.d.f, com.igexin.c.a.d.a.a
    public void a() {
        d dVar = this.f23247c;
        if (dVar != null) {
            dVar.b();
        }
        super.a();
    }
}
