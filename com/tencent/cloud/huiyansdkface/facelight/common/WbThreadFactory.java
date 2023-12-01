package com.tencent.cloud.huiyansdkface.facelight.common;

import java.util.concurrent.ThreadFactory;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/facelight/common/WbThreadFactory.class */
public class WbThreadFactory implements ThreadFactory {

    /* renamed from: a  reason: collision with root package name */
    private String f35596a;

    public WbThreadFactory(String str) {
        this.f35596a = str;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        return new Thread(runnable, this.f35596a);
    }
}
