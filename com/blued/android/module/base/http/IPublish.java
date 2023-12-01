package com.blued.android.module.base.http;

import android.content.Context;
import com.blued.android.module.base.base.IBaseInterface;
import com.blued.android.module.base.http.PublishProxy;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/base/http/IPublish.class */
public interface IPublish extends IBaseInterface {
    void a(Context context, int i, PublishProxy.ILiveApplyListener iLiveApplyListener);

    void a(Context context, String str, int i, PublishProxy.IUploadAuthVideoListener iUploadAuthVideoListener);
}
