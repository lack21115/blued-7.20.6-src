package com.tencent.cloud.huiyansdkface.a.c.a;

import android.hardware.Camera;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/a/c/a/a.class */
public class a implements com.tencent.cloud.huiyansdkface.a.c.d {

    /* renamed from: a  reason: collision with root package name */
    private Camera f21757a;
    private com.tencent.cloud.huiyansdkface.a.a.a.a b;

    /* renamed from: c  reason: collision with root package name */
    private int f21758c;
    private int d;
    private Camera.CameraInfo e;
    private com.tencent.cloud.huiyansdkface.a.a.d f;

    public a a(int i) {
        this.f21758c = i;
        return this;
    }

    public a a(Camera.CameraInfo cameraInfo) {
        this.e = cameraInfo;
        return this;
    }

    public a a(Camera camera) {
        this.f21757a = camera;
        return this;
    }

    public a a(com.tencent.cloud.huiyansdkface.a.a.a.a aVar) {
        this.b = aVar;
        return this;
    }

    public a a(com.tencent.cloud.huiyansdkface.a.a.d dVar) {
        this.f = dVar;
        return this;
    }

    @Override // com.tencent.cloud.huiyansdkface.a.c.d
    public com.tencent.cloud.huiyansdkface.a.a.d b() {
        return this.f;
    }

    public a b(int i) {
        this.d = i;
        return this;
    }

    @Override // com.tencent.cloud.huiyansdkface.a.c.d
    /* renamed from: c */
    public Camera a() {
        return this.f21757a;
    }

    public com.tencent.cloud.huiyansdkface.a.a.a.a d() {
        return this.b;
    }

    public int e() {
        return this.f21758c;
    }

    public int f() {
        return this.d;
    }

    public String toString() {
        return "CameraV1{mCameraFacing=" + this.b + ", mOrientation=" + this.f21758c + ", mCameraId=" + this.d + '}';
    }
}
