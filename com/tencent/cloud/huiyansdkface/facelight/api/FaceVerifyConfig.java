package com.tencent.cloud.huiyansdkface.facelight.api;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/facelight/api/FaceVerifyConfig.class */
public class FaceVerifyConfig {

    /* renamed from: a  reason: collision with root package name */
    private boolean f35520a;

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/facelight/api/FaceVerifyConfig$a.class */
    static class a {

        /* renamed from: a  reason: collision with root package name */
        private static final FaceVerifyConfig f35521a = new FaceVerifyConfig();
    }

    private FaceVerifyConfig() {
        this.f35520a = false;
    }

    public static FaceVerifyConfig getInstance() {
        return a.f35521a;
    }

    public boolean displayInfoInUI() {
        return this.f35520a;
    }

    public void enableDisplayInfoInUI() {
        this.f35520a = true;
    }
}
