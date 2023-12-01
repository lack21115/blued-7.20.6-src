package com.anythink.basead.e;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/e/b.class */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final String f5981a = b.class.getSimpleName();
    private Map<String, InterfaceC0079b> b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/e/b$a.class */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private static final b f5982a = new b((byte) 0);

        private a() {
        }
    }

    /* renamed from: com.anythink.basead.e.b$b  reason: collision with other inner class name */
    /* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/e/b$b.class */
    public interface InterfaceC0079b extends Serializable {
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
        return a.f5982a;
    }

    public final InterfaceC0079b a(String str) {
        return this.b.get(str);
    }

    public final void a(String str, InterfaceC0079b interfaceC0079b) {
        this.b.put(str, interfaceC0079b);
    }

    public final void b(String str) {
        this.b.remove(str);
    }
}
