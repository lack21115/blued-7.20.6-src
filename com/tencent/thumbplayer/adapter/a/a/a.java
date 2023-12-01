package com.tencent.thumbplayer.adapter.a.a;

import com.tencent.thumbplayer.api.TPSubtitleRenderModel;
import com.tencent.thumbplayer.core.common.TPSubtitleFrame;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/adapter/a/a/a.class */
public interface a {

    /* renamed from: com.tencent.thumbplayer.adapter.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/adapter/a/a/a$a.class */
    public interface InterfaceC1010a {
        void a(e eVar);

        void a(TPSubtitleFrame tPSubtitleFrame);

        void a(String str);
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/adapter/a/a/a$b.class */
    public interface b {
        void a(int i, int i2);
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/adapter/a/a/a$c.class */
    public interface c {
        void a(int i, long j);

        void a(long j);
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/adapter/a/a/a$d.class */
    public interface d {
        long a();
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/adapter/a/a/a$e.class */
    public static class e {

        /* renamed from: a  reason: collision with root package name */
        String f39136a;

        public e(String str) {
            this.f39136a = str;
        }
    }

    void a();

    void a(int i);

    void a(InterfaceC1010a interfaceC1010a);

    void a(b bVar);

    void a(c cVar);

    void a(d dVar);

    void a(TPSubtitleRenderModel tPSubtitleRenderModel);

    void a(String str, Map<String, String> map, long j);

    void b();

    void c();

    void d();

    void e();

    void f();
}
