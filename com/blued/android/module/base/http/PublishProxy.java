package com.blued.android.module.base.http;

import android.content.Context;
import com.blued.android.module.base.base.BaseProxy;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/base/http/PublishProxy.class */
public class PublishProxy extends BaseProxy<IPublish> implements IPublish {
    private static PublishProxy b;

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/base/http/PublishProxy$ILiveApplyListener.class */
    public interface ILiveApplyListener {
        void a();

        void a(int i, String str);
    }

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/base/http/PublishProxy$IUploadAuthVideoListener.class */
    public interface IUploadAuthVideoListener {
        void a(int i, String str);

        void a(String str, double d);

        boolean a();

        void b();
    }

    private PublishProxy() {
    }

    public static PublishProxy a() {
        if (b == null) {
            synchronized (PublishProxy.class) {
                try {
                    if (b == null) {
                        b = new PublishProxy();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return b;
    }

    @Override // com.blued.android.module.base.http.IPublish
    public void a(Context context, int i, ILiveApplyListener iLiveApplyListener) {
        if (this.a != 0) {
            ((IPublish) this.a).a(context, i, iLiveApplyListener);
        }
    }

    @Override // com.blued.android.module.base.http.IPublish
    public void a(Context context, String str, int i, IUploadAuthVideoListener iUploadAuthVideoListener) {
        if (this.a != 0) {
            ((IPublish) this.a).a(context, str, i, iUploadAuthVideoListener);
        }
    }
}
