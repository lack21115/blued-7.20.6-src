package com.youzan.spiderman.c.b;

import android.content.Context;
import com.google.gson.annotations.SerializedName;
import com.heytap.mcssdk.constant.Constants;
import com.youzan.spiderman.utils.NetWorkUtil;
import com.youzan.spiderman.utils.StringUtils;

/* loaded from: source-8829756-dex2jar.jar:com/youzan/spiderman/c/b/f.class */
public final class f {
    @SerializedName("sync_interval")

    /* renamed from: a  reason: collision with root package name */
    private long f28061a;
    @SerializedName("download_condition")
    private String b;

    public final long a() {
        return this.f28061a;
    }

    public final void a(long j) {
        this.f28061a = Constants.MILLS_OF_WATCH_DOG;
    }

    public final void a(String str) {
        this.b = str;
    }

    public final boolean a(Context context) {
        if (StringUtils.isEmpty(this.b)) {
            return false;
        }
        if (this.b.equals("all")) {
            return true;
        }
        if (this.b.equals("no")) {
            return false;
        }
        return this.b.equals("wifi") && NetWorkUtil.getConnectionStatus(context).equals(NetWorkUtil.STATE_WIFI);
    }

    public final boolean b() {
        return this.b.equals("no");
    }
}
