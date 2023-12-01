package com.anythink.expressad.video.signal.factory;

import com.anythink.expressad.video.signal.a.d;
import com.anythink.expressad.video.signal.a.f;
import com.anythink.expressad.video.signal.c;
import com.anythink.expressad.video.signal.e;
import com.anythink.expressad.video.signal.g;
import com.anythink.expressad.video.signal.i;
import com.anythink.expressad.video.signal.j;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/video/signal/factory/a.class */
public class a implements IJSFactory {

    /* renamed from: a  reason: collision with root package name */
    protected com.anythink.expressad.video.signal.a f8714a;
    protected c b;

    /* renamed from: c  reason: collision with root package name */
    protected j f8715c;
    protected g d;
    protected e e;
    protected i f;
    protected com.anythink.expressad.video.signal.b g;

    @Override // com.anythink.expressad.video.signal.factory.IJSFactory
    public com.anythink.expressad.video.signal.a getActivityProxy() {
        if (this.f8714a == null) {
            this.f8714a = new com.anythink.expressad.video.signal.a.a();
        }
        return this.f8714a;
    }

    @Override // com.anythink.expressad.video.signal.factory.IJSFactory
    public i getIJSRewardVideoV1() {
        if (this.f == null) {
            this.f = new f();
        }
        return this.f;
    }

    @Override // com.anythink.expressad.video.signal.factory.IJSFactory
    public com.anythink.expressad.video.signal.b getJSBTModule() {
        if (this.g == null) {
            this.g = new com.anythink.expressad.video.signal.a.b();
        }
        return this.g;
    }

    @Override // com.anythink.expressad.video.signal.factory.IJSFactory
    public c getJSCommon() {
        if (this.b == null) {
            this.b = new com.anythink.expressad.video.signal.a.c();
        }
        return this.b;
    }

    @Override // com.anythink.expressad.video.signal.factory.IJSFactory
    public e getJSContainerModule() {
        if (this.e == null) {
            this.e = new d();
        }
        return this.e;
    }

    @Override // com.anythink.expressad.video.signal.factory.IJSFactory
    public g getJSNotifyProxy() {
        if (this.d == null) {
            this.d = new com.anythink.expressad.video.signal.a.e();
        }
        return this.d;
    }

    @Override // com.anythink.expressad.video.signal.factory.IJSFactory
    public j getJSVideoModule() {
        if (this.f8715c == null) {
            this.f8715c = new com.anythink.expressad.video.signal.a.g();
        }
        return this.f8715c;
    }
}
