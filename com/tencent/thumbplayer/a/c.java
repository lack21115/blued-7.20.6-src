package com.tencent.thumbplayer.a;

import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import com.tencent.thumbplayer.a.b;
import com.tencent.thumbplayer.api.TPCaptureCallBack;
import com.tencent.thumbplayer.core.imagegenerator.TPImageGeneratorParams;
import java.io.FileDescriptor;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/a/c.class */
public class c implements b.a, com.tencent.thumbplayer.adapter.a.a {

    /* renamed from: a  reason: collision with root package name */
    private Map<Integer, TPCaptureCallBack> f39132a = new HashMap();
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private FileDescriptor f39133c;
    private AssetFileDescriptor d;

    public c(AssetFileDescriptor assetFileDescriptor) {
        this.d = assetFileDescriptor;
    }

    public c(FileDescriptor fileDescriptor) {
        this.f39133c = fileDescriptor;
    }

    public c(String str) {
        this.b = str;
    }

    @Override // com.tencent.thumbplayer.adapter.a.a
    public void a() {
        this.f39132a.clear();
    }

    @Override // com.tencent.thumbplayer.a.b.a
    public void a(int i, int i2) {
        TPCaptureCallBack tPCaptureCallBack = this.f39132a.get(Integer.valueOf(i));
        if (tPCaptureCallBack != null) {
            tPCaptureCallBack.onCaptureVideoFailed(i2);
        }
    }

    @Override // com.tencent.thumbplayer.a.b.a
    public void a(int i, long j, int i2, int i3, Bitmap bitmap, long j2) {
        TPCaptureCallBack tPCaptureCallBack = this.f39132a.get(Integer.valueOf(i));
        if (tPCaptureCallBack != null) {
            tPCaptureCallBack.onCaptureVideoSuccess(bitmap);
        }
    }

    @Override // com.tencent.thumbplayer.adapter.a.a
    public void a(long j, TPImageGeneratorParams tPImageGeneratorParams, TPCaptureCallBack tPCaptureCallBack) {
        b.d dVar = new b.d();
        dVar.f39130a = this.b;
        dVar.b = this.f39133c;
        dVar.f39131c = this.d;
        dVar.d = j;
        dVar.e = tPImageGeneratorParams.width;
        dVar.f = tPImageGeneratorParams.height;
        this.f39132a.put(Integer.valueOf(b.a().a(dVar, this)), tPCaptureCallBack);
    }
}
