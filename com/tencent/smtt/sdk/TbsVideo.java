package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/smtt/sdk/TbsVideo.class */
public class TbsVideo {
    public static boolean canUseTbsPlayer(Context context) {
        return r.a(context).a();
    }

    public static boolean canUseYunbo(Context context) {
        return r.a(context).a() && QbSdk.canUseVideoFeatrue(context, 1);
    }

    public static void openVideo(Context context, String str) {
        openVideo(context, str, null);
    }

    public static void openVideo(Context context, String str, Bundle bundle) {
        if (TextUtils.isEmpty(str)) {
            Log.e("TbsVideo", "videoUrl is empty!");
            return;
        }
        Bundle bundle2 = bundle;
        if (bundle == null) {
            bundle2 = new Bundle();
        }
        bundle2.putString("videoUrl", str);
        Intent intent = new Intent("com.tencent.smtt.tbs.video.PLAY");
        intent.setFlags(268435456);
        intent.setPackage(context.getPackageName());
        intent.putExtra("extraData", bundle2);
        context.startActivity(intent);
    }

    public static boolean openYunboVideo(Context context, String str, Bundle bundle, com.tencent.tbs.video.interfaces.a aVar) {
        if (canUseYunbo(context)) {
            return r.a(context).a(str, bundle, aVar);
        }
        return false;
    }
}
