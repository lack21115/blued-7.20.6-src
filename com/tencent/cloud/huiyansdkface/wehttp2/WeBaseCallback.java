package com.tencent.cloud.huiyansdkface.wehttp2;

import com.tencent.cloud.huiyansdkface.wehttp2.WeReq;
import java.io.IOException;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/wehttp2/WeBaseCallback.class */
public abstract class WeBaseCallback<T> extends BaseCallback<Resp<T>> {

    /* renamed from: a  reason: collision with root package name */
    private static int f36110a;
    private int b = f36110a;

    public static void successCodeGlobal(int i) {
        f36110a = i;
    }

    public abstract void failed(WeReq weReq, WeReq.ErrType errType, int i, String str, IOException iOException);

    @Override // com.tencent.cloud.huiyansdkface.wehttp2.WeReq.Callback, com.tencent.cloud.huiyansdkface.wehttp2.WeReq.InnerCallback
    public void onFailed(WeReq weReq, WeReq.ErrType errType, int i, String str, IOException iOException) {
        failed(weReq, errType, i, str, iOException);
    }

    public void onSuccess(WeReq weReq, Resp<T> resp) {
        if (resp == null || resp.getCode() != this.b) {
            failed(weReq, WeReq.ErrType.SERVER, resp.getCode(), resp.getMsg(), null);
        } else {
            success(weReq, resp.getResult());
        }
    }

    @Override // com.tencent.cloud.huiyansdkface.wehttp2.WeReq.Callback, com.tencent.cloud.huiyansdkface.wehttp2.WeReq.InnerCallback
    public /* bridge */ /* synthetic */ void onSuccess(WeReq weReq, Object obj) {
        onSuccess(weReq, (Resp) ((Resp) obj));
    }

    public abstract void success(WeReq weReq, T t);

    public WeBaseCallback<T> successCode(int i) {
        this.b = i;
        return this;
    }
}
