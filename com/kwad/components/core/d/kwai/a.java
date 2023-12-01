package com.kwad.components.core.d.kwai;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/d/kwai/a.class */
public final class a {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kwad.components.core.d.kwai.a$a  reason: collision with other inner class name */
    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/d/kwai/a$a.class */
    public static final class C0520a {
        private static final c Is = c.a(new int[]{7, 8, 4, 2, 0, 3, 6, 9, 1, 8});
    }

    public static long am(String str) {
        return mB().an(str);
    }

    private static c mB() {
        return C0520a.Is;
    }

    public static String o(long j) {
        String p = mB().p(j);
        String str = p;
        if (p.endsWith("=")) {
            str = p.replace("=", "");
        }
        return str;
    }
}
