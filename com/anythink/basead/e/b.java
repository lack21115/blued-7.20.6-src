package com.anythink.basead.e;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/e/b.class */
public class b {
    public static final String a = b.class.getSimpleName();
    private Map<String, InterfaceC0039b> b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/e/b$a.class */
    public static final class a {
        private static final b a = new b((byte) 0);

        private a() {
        }
    }

    /* renamed from: com.anythink.basead.e.b$b  reason: collision with other inner class name */
    /* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/e/b$b.class */
    public interface InterfaceC0039b extends Serializable {
        void a();

        void a(int i);

        void a(com.anythink.basead.c.e eVar);

        void a(boolean z);

        void b();

        void c();

        void d();

        void e();
    }

    private b() {
        this.b = new HashMap(2);
    }

    /* synthetic */ b(byte b) {
        this();
    }

    public static b a() {
        return a.a;
    }

    public final InterfaceC0039b a(String str) {
        return this.b.get(str);
    }

    public final void a(String str, InterfaceC0039b interfaceC0039b) {
        this.b.put(str, interfaceC0039b);
    }

    public final void b(String str) {
        this.b.remove(str);
    }
}
