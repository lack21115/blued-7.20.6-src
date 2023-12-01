package com.anythink.core.common.res.image;

import com.anythink.core.common.b.n;
import com.anythink.core.common.k.f;
import com.anythink.core.common.res.d;
import com.anythink.core.common.res.e;
import java.io.InputStream;
import java.util.Map;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/res/image/a.class */
public final class a extends b {

    /* renamed from: a  reason: collision with root package name */
    e f6911a;
    InterfaceC0109a b;

    /* renamed from: com.anythink.core.common.res.image.a$a  reason: collision with other inner class name */
    /* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/res/image/a$a.class */
    public interface InterfaceC0109a {
        void a(e eVar);

        void a(e eVar, String str);
    }

    public a(e eVar) {
        super(eVar.f);
        this.f6911a = eVar;
    }

    @Override // com.anythink.core.common.res.image.b
    protected final Map<String, String> a() {
        return null;
    }

    @Override // com.anythink.core.common.res.image.b
    protected final void a(com.anythink.core.common.k.b.b bVar) {
        com.anythink.core.common.k.b.a.a().a(bVar, 5);
    }

    public final void a(InterfaceC0109a interfaceC0109a) {
        this.b = interfaceC0109a;
    }

    @Override // com.anythink.core.common.res.image.b
    protected final void a(String str, String str2) {
        InterfaceC0109a interfaceC0109a = this.b;
        if (interfaceC0109a != null) {
            interfaceC0109a.a(this.f6911a, str2);
        }
    }

    @Override // com.anythink.core.common.res.image.b
    protected final boolean a(InputStream inputStream) {
        return d.a(n.a().g()).a(this.f6911a.e, f.a(this.f6911a.f), inputStream);
    }

    @Override // com.anythink.core.common.res.image.b
    protected final void b() {
    }

    @Override // com.anythink.core.common.res.image.b
    protected final void c() {
        InterfaceC0109a interfaceC0109a = this.b;
        if (interfaceC0109a != null) {
            interfaceC0109a.a(this.f6911a);
        }
    }
}
