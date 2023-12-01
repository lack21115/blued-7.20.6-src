package com.baidu.mobads.sdk.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8756600-dex2jar.jar:com/baidu/mobads/sdk/internal/aa.class */
public class aa implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ z f9296a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(z zVar) {
        this.f9296a = zVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f9296a.a("加载dex超过5秒");
    }
}
