package com.kwai.sodler.lib.ext;

import com.kwai.sodler.lib.a.a;
import com.kwai.sodler.lib.a.f;
import com.kwai.sodler.lib.h;

/* loaded from: source-7994992-dex2jar.jar:com/kwai/sodler/lib/ext/b.class */
public interface b<P extends com.kwai.sodler.lib.a.a, R extends f<P>> {

    /* loaded from: source-7994992-dex2jar.jar:com/kwai/sodler/lib/ext/b$a.class */
    public static class a extends C0425b<com.kwai.sodler.lib.kwai.a, com.kwai.sodler.lib.b.a> {
    }

    /* renamed from: com.kwai.sodler.lib.ext.b$b  reason: collision with other inner class name */
    /* loaded from: source-7994992-dex2jar.jar:com/kwai/sodler/lib/ext/b$b.class */
    public static class C0425b<P extends com.kwai.sodler.lib.a.a, R extends f<P>> implements b<P, R> {
        @Override // com.kwai.sodler.lib.ext.b
        public void a(R r) {
        }

        @Override // com.kwai.sodler.lib.ext.b
        public void a(R r, P p) {
        }

        @Override // com.kwai.sodler.lib.ext.b
        public void a(R r, PluginError pluginError) {
        }

        @Override // com.kwai.sodler.lib.ext.b
        public void b(R r) {
        }

        @Override // com.kwai.sodler.lib.ext.b
        public void c(R r) {
        }
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwai/sodler/lib/ext/b$c.class */
    public static class c extends C0425b<h, com.kwai.sodler.lib.b.c> {
    }

    void a(R r);

    void a(R r, P p);

    void a(R r, PluginError pluginError);

    void b(R r);

    void c(R r);
}
