package com.tencent.cloud.huiyansdkface.facelight.api;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/facelight/api/FaceVerifyConfig.class */
public class FaceVerifyConfig {

    /* renamed from: a  reason: collision with root package name */
    private boolean f21829a;

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/facelight/api/FaceVerifyConfig$a.class */
    static class a {

        /* renamed from: a  reason: collision with root package name */
        private static final FaceVerifyConfig f21830a = new FaceVerifyConfig();
    }

    private FaceVerifyConfig() {
        this.f21829a = false;
    }

    public static FaceVerifyConfig getInstance() {
        return a.f21830a;
    }

    public boolean displayInfoInUI() {
        return this.f21829a;
    }

    public void enableDisplayInfoInUI() {
        this.f21829a = true;
    }
}
