package com.huawei.hms.ads;

import android.app.Activity;
import android.content.Context;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import com.huawei.openalliance.ad.utils.f;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/ac.class */
public interface ac {
    Context Code(Context context);

    f.a Code();

    Object Code(Context context, String str);

    void Code(Activity activity);

    void Code(String str);

    void V(String str);

    void execute(Context context, String str, RemoteCallResultCallback<String> remoteCallResultCallback);
}
