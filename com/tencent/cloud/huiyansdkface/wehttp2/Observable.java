package com.tencent.cloud.huiyansdkface.wehttp2;

import com.tencent.cloud.huiyansdkface.wehttp2.WeReq;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/wehttp2/Observable.class */
public abstract class Observable<T> {

    /* renamed from: a  reason: collision with root package name */
    private WeReq f36096a;

    public Observable() {
    }

    public Observable(WeReq weReq) {
        this.f36096a = weReq;
    }

    public static <T> Observable<T> error(final int i, final String str) {
        return new Observable<T>() { // from class: com.tencent.cloud.huiyansdkface.wehttp2.Observable.1
            @Override // com.tencent.cloud.huiyansdkface.wehttp2.Observable
            public void subscribe(WeReq.Callback<T> callback) {
                callback.onFailed(null, WeReq.ErrType.LOCAL, i, str, null);
            }
        };
    }

    public void cancel() {
        WeReq weReq = this.f36096a;
        if (weReq != null) {
            weReq.cancel();
        }
    }

    public abstract void subscribe(WeReq.Callback<T> callback);
}
