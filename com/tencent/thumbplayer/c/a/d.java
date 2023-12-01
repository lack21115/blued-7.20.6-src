package com.tencent.thumbplayer.c.a;

import android.os.Looper;
import com.tencent.thumbplayer.api.resourceloader.ITPAssetResourceLoadingRequest;
import com.tencent.thumbplayer.api.resourceloader.TPAssetResourceLoadingContentInformationRequest;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/c/a/d.class */
public class d implements ITPAssetResourceLoadingRequest {

    /* renamed from: a  reason: collision with root package name */
    private int f39244a;
    private c b;

    /* renamed from: c  reason: collision with root package name */
    private TPAssetResourceLoadingContentInformationRequest f39245c;
    private boolean d = false;
    private boolean e = false;

    public d(long j, long j2, int i, boolean z) {
        this.f39244a = 0;
        this.f39244a = i;
        c cVar = new c(j, j2, z);
        this.b = cVar;
        cVar.a(i);
    }

    public int a(long j) {
        return this.b.a(j);
    }

    @Override // com.tencent.thumbplayer.api.resourceloader.ITPAssetResourceLoadingRequest
    /* renamed from: a */
    public c getLoadingDataRequest() {
        return this.b;
    }

    public void a(Looper looper) {
        this.b.a(looper);
    }

    public void a(TPAssetResourceLoadingContentInformationRequest tPAssetResourceLoadingContentInformationRequest) {
        this.f39245c = tPAssetResourceLoadingContentInformationRequest;
    }

    public void a(String str) {
        this.b.a(str);
    }

    public void b() {
        synchronized (this) {
            this.d = true;
            this.b.b();
        }
    }

    @Override // com.tencent.thumbplayer.api.resourceloader.ITPAssetResourceLoadingRequest
    public void finishLoading() {
        synchronized (this) {
            this.e = true;
        }
    }

    @Override // com.tencent.thumbplayer.api.resourceloader.ITPAssetResourceLoadingRequest
    public TPAssetResourceLoadingContentInformationRequest getContentInformation() {
        return this.f39245c;
    }

    @Override // com.tencent.thumbplayer.api.resourceloader.ITPAssetResourceLoadingRequest
    public boolean isCancelled() {
        boolean z;
        synchronized (this) {
            z = this.d;
        }
        return z;
    }

    @Override // com.tencent.thumbplayer.api.resourceloader.ITPAssetResourceLoadingRequest
    public boolean isFinished() {
        boolean z;
        synchronized (this) {
            z = this.e;
        }
        return z;
    }
}
