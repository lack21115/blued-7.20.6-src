package com.efs.sdk.base.core.util.a;

import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.http.HttpEnv;
import com.efs.sdk.base.http.HttpResponse;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.io.File;
import java.util.Map;

/* loaded from: source-7206380-dex2jar.jar:com/efs/sdk/base/core/util/a/b.class */
public final class b implements com.efs.sdk.base.core.util.concurrent.c<HttpResponse> {

    /* renamed from: a  reason: collision with root package name */
    String f8182a;
    Map<String, String> b;

    /* renamed from: c  reason: collision with root package name */
    public byte[] f8183c;
    public File d;
    public String e;
    public Map<String, String> f;
    public boolean g = false;

    @Override // com.efs.sdk.base.core.util.concurrent.c
    public final /* synthetic */ HttpResponse a() {
        boolean z;
        String str = this.e;
        int hashCode = str.hashCode();
        if (hashCode != 102230) {
            if (hashCode == 3446944 && str.equals("post")) {
                z = true;
            }
            z = true;
        } else {
            if (str.equals(MonitorConstants.CONNECT_TYPE_GET)) {
                z = false;
            }
            z = true;
        }
        if (z) {
            if (z) {
                byte[] bArr = this.f8183c;
                return (bArr == null || bArr.length <= 0) ? HttpEnv.getInstance().getHttpUtil().post(this.f8182a, this.b, this.d) : this.g ? HttpEnv.getInstance().getHttpUtil().postAsFile(this.f8182a, this.b, this.f8183c) : HttpEnv.getInstance().getHttpUtil().post(this.f8182a, this.b, this.f8183c);
            }
            Log.e("efs.util.http", "request not support method '" + this.e + "'");
            return null;
        }
        return HttpEnv.getInstance().getHttpUtil().get(this.f8182a, this.b);
    }
}
