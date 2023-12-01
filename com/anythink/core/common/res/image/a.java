package com.anythink.core.common.res.image;

import com.anythink.core.common.b.n;
import com.anythink.core.common.k.f;
import com.anythink.core.common.res.d;
import com.anythink.core.common.res.e;
import java.io.InputStream;
import java.util.Map;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/res/image/a.class */
public final class a extends b {
    e a;
    InterfaceC0069a b;

    /* renamed from: com.anythink.core.common.res.image.a$a  reason: collision with other inner class name */
    /* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/res/image/a$a.class */
    public interface InterfaceC0069a {
        void a(e eVar);

        void a(e eVar, String str);
    }

    public a(e eVar) {
        super(eVar.f);
        this.a = eVar;
    }

    @Override // com.anythink.core.common.res.image.b
    protected final Map<String, String> a() {
        return null;
    }

    @Override // com.anythink.core.common.res.image.b
    protected final void a(com.anythink.core.common.k.b.b bVar) {
        com.anythink.core.common.k.b.a.a().a(bVar, 5);
    }

    public final void a(InterfaceC0069a interfaceC0069a) {
        this.b = interfaceC0069a;
    }

    @Override // com.anythink.core.common.res.image.b
    protected final void a(String str, String str2) {
        InterfaceC0069a interfaceC0069a = this.b;
        if (interfaceC0069a != null) {
            interfaceC0069a.a(this.a, str2);
        }
    }

    @Override // com.anythink.core.common.res.image.b
    protected final boolean a(InputStream inputStream) {
        return d.a(n.a().g()).a(this.a.e, f.a(this.a.f), inputStream);
    }

    @Override // com.anythink.core.common.res.image.b
    protected final void b() {
    }

    @Override // com.anythink.core.common.res.image.b
    protected final void c() {
        InterfaceC0069a interfaceC0069a = this.b;
        if (interfaceC0069a != null) {
            interfaceC0069a.a(this.a);
        }
    }
}
