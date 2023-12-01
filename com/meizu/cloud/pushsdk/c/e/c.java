package com.meizu.cloud.pushsdk.c.e;

import com.baidu.mobads.sdk.internal.bw;
import com.meizu.cloud.pushsdk.c.a.e;
import com.meizu.cloud.pushsdk.c.c.k;

/* loaded from: source-7994992-dex2jar.jar:com/meizu/cloud/pushsdk/c/e/c.class */
public final class c {
    public static <T> com.meizu.cloud.pushsdk.c.a.c<T> a(com.meizu.cloud.pushsdk.c.a.b bVar) {
        int g = bVar.g();
        return g != 0 ? g != 1 ? g != 2 ? new com.meizu.cloud.pushsdk.c.a.c<>(new com.meizu.cloud.pushsdk.c.b.a()) : d(bVar) : c(bVar) : b(bVar);
    }

    private static <T> com.meizu.cloud.pushsdk.c.a.c<T> b(com.meizu.cloud.pushsdk.c.a.b bVar) {
        try {
            try {
                try {
                    k a2 = a.a(bVar);
                    if (a2 == null) {
                        com.meizu.cloud.pushsdk.c.a.c<T> cVar = new com.meizu.cloud.pushsdk.c.a.c<>(com.meizu.cloud.pushsdk.c.h.b.a(new com.meizu.cloud.pushsdk.c.b.a()));
                        com.meizu.cloud.pushsdk.c.h.a.a(a2, bVar);
                        return cVar;
                    } else if (bVar.f() == e.OK_HTTP_RESPONSE) {
                        com.meizu.cloud.pushsdk.c.a.c<T> cVar2 = new com.meizu.cloud.pushsdk.c.a.c<>(a2);
                        cVar2.a(a2);
                        com.meizu.cloud.pushsdk.c.h.a.a(a2, bVar);
                        return cVar2;
                    } else if (a2.a() >= 400) {
                        com.meizu.cloud.pushsdk.c.a.c<T> cVar3 = new com.meizu.cloud.pushsdk.c.a.c<>(com.meizu.cloud.pushsdk.c.h.b.a(new com.meizu.cloud.pushsdk.c.b.a(a2), bVar, a2.a()));
                        cVar3.a(a2);
                        com.meizu.cloud.pushsdk.c.h.a.a(a2, bVar);
                        return cVar3;
                    } else {
                        com.meizu.cloud.pushsdk.c.a.c<T> a3 = bVar.a(a2);
                        a3.a(a2);
                        com.meizu.cloud.pushsdk.c.h.a.a(a2, bVar);
                        return a3;
                    }
                } catch (Exception e) {
                    com.meizu.cloud.pushsdk.c.a.c<T> cVar4 = new com.meizu.cloud.pushsdk.c.a.c<>(com.meizu.cloud.pushsdk.c.h.b.a(e));
                    com.meizu.cloud.pushsdk.c.h.a.a(null, bVar);
                    return cVar4;
                }
            } catch (com.meizu.cloud.pushsdk.c.b.a e2) {
                com.meizu.cloud.pushsdk.c.a.c<T> cVar5 = new com.meizu.cloud.pushsdk.c.a.c<>(com.meizu.cloud.pushsdk.c.h.b.a(new com.meizu.cloud.pushsdk.c.b.a(e2)));
                com.meizu.cloud.pushsdk.c.h.a.a(null, bVar);
                return cVar5;
            }
        } catch (Throwable th) {
            com.meizu.cloud.pushsdk.c.h.a.a(null, bVar);
            throw th;
        }
    }

    private static <T> com.meizu.cloud.pushsdk.c.a.c<T> c(com.meizu.cloud.pushsdk.c.a.b bVar) {
        try {
            k b = a.b(bVar);
            if (b == null) {
                return new com.meizu.cloud.pushsdk.c.a.c<>(com.meizu.cloud.pushsdk.c.h.b.a(new com.meizu.cloud.pushsdk.c.b.a()));
            }
            if (b.a() >= 400) {
                com.meizu.cloud.pushsdk.c.a.c<T> cVar = new com.meizu.cloud.pushsdk.c.a.c<>(com.meizu.cloud.pushsdk.c.h.b.a(new com.meizu.cloud.pushsdk.c.b.a(b), bVar, b.a()));
                cVar.a(b);
                return cVar;
            }
            com.meizu.cloud.pushsdk.c.a.c<T> cVar2 = new com.meizu.cloud.pushsdk.c.a.c<>(bw.o);
            cVar2.a(b);
            return cVar2;
        } catch (com.meizu.cloud.pushsdk.c.b.a e) {
            return new com.meizu.cloud.pushsdk.c.a.c<>(com.meizu.cloud.pushsdk.c.h.b.a(new com.meizu.cloud.pushsdk.c.b.a(e)));
        } catch (Exception e2) {
            return new com.meizu.cloud.pushsdk.c.a.c<>(com.meizu.cloud.pushsdk.c.h.b.a(e2));
        }
    }

    private static <T> com.meizu.cloud.pushsdk.c.a.c<T> d(com.meizu.cloud.pushsdk.c.a.b bVar) {
        try {
            try {
                try {
                    k c2 = a.c(bVar);
                    if (c2 == null) {
                        com.meizu.cloud.pushsdk.c.a.c<T> cVar = new com.meizu.cloud.pushsdk.c.a.c<>(com.meizu.cloud.pushsdk.c.h.b.a(new com.meizu.cloud.pushsdk.c.b.a()));
                        com.meizu.cloud.pushsdk.c.h.a.a(c2, bVar);
                        return cVar;
                    } else if (bVar.f() == e.OK_HTTP_RESPONSE) {
                        com.meizu.cloud.pushsdk.c.a.c<T> cVar2 = new com.meizu.cloud.pushsdk.c.a.c<>(c2);
                        cVar2.a(c2);
                        com.meizu.cloud.pushsdk.c.h.a.a(c2, bVar);
                        return cVar2;
                    } else if (c2.a() >= 400) {
                        com.meizu.cloud.pushsdk.c.a.c<T> cVar3 = new com.meizu.cloud.pushsdk.c.a.c<>(com.meizu.cloud.pushsdk.c.h.b.a(new com.meizu.cloud.pushsdk.c.b.a(c2), bVar, c2.a()));
                        cVar3.a(c2);
                        com.meizu.cloud.pushsdk.c.h.a.a(c2, bVar);
                        return cVar3;
                    } else {
                        com.meizu.cloud.pushsdk.c.a.c<T> a2 = bVar.a(c2);
                        a2.a(c2);
                        com.meizu.cloud.pushsdk.c.h.a.a(c2, bVar);
                        return a2;
                    }
                } catch (Exception e) {
                    com.meizu.cloud.pushsdk.c.a.c<T> cVar4 = new com.meizu.cloud.pushsdk.c.a.c<>(com.meizu.cloud.pushsdk.c.h.b.a(e));
                    com.meizu.cloud.pushsdk.c.h.a.a(null, bVar);
                    return cVar4;
                }
            } catch (com.meizu.cloud.pushsdk.c.b.a e2) {
                com.meizu.cloud.pushsdk.c.a.c<T> cVar5 = new com.meizu.cloud.pushsdk.c.a.c<>(com.meizu.cloud.pushsdk.c.h.b.a(e2));
                com.meizu.cloud.pushsdk.c.h.a.a(null, bVar);
                return cVar5;
            }
        } catch (Throwable th) {
            com.meizu.cloud.pushsdk.c.h.a.a(null, bVar);
            throw th;
        }
    }
}
