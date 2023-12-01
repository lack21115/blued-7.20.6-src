package com.soft.blued.sdk;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import androidx.core.util.Pair;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.HttpResponseHandler;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedHttpUtils;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.sdk.a.a;
import com.blued.android.sdk.a.b;
import com.soft.blued.http.PayHttpUtils;
import com.soft.blued.sdk.model.SDKAuthModel;
import com.soft.blued.sdk.ui.SDKWebAuthFragment;
import com.soft.blued.utils.Logger;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/sdk/SDKAuthAction.class */
public class SDKAuthAction extends SDKBaseAction {
    private SDKActionCallback f;

    public SDKAuthAction(Intent intent) {
        super(intent);
    }

    private void a(final Context context, String str, String str2) {
        PayHttpUtils.a((HttpResponseHandler) new BluedUIHttpResponse<BluedEntityA<SDKAuthModel>>() { // from class: com.soft.blued.sdk.SDKAuthAction.1

            /* renamed from: c  reason: collision with root package name */
            private SDKAuthModel f29748c;
            private int d = 0;
            private String e = null;

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<SDKAuthModel> bluedEntityA) {
                if (bluedEntityA.data == null || bluedEntityA.data.size() <= 0) {
                    return;
                }
                this.f29748c = bluedEntityA.data.get(0);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse, com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.http.AbstractHttpResponseHandler
            public void onFailure(Throwable th, int i, String str3) {
                super.onFailure(th, i, str3);
                Pair<Integer, String> a2 = BluedHttpUtils.a(th, i, str3);
                if (a2 != null) {
                    this.d = a2.first.intValue();
                    this.e = a2.second;
                }
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                super.onUIFinish();
                SDKAuthModel sDKAuthModel = this.f29748c;
                if (sDKAuthModel != null) {
                    SDKAuthAction.this.a(context, 0, 0, this.e, sDKAuthModel.access_token, this.f29748c.expire, this.f29748c.package_name);
                } else {
                    SDKAuthAction.this.a(context, 1, this.d, this.e, null, 0, null);
                }
            }
        }, (IRequestHost) null, str);
    }

    private void b(Context context, String str, String str2) {
        SDKWebAuthFragment.a(context, str, str2, this.f29749a);
    }

    private Intent d() {
        Intent intent = new Intent(b.d, (Uri) null);
        intent.addCategory(Intent.CATEGORY_DEFAULT);
        intent.setPackage(this.e);
        intent.setFlags(67108864);
        return intent;
    }

    @Override // com.soft.blued.sdk.SDKBaseAction
    protected void a(Context context) {
        String packageName = AppInfo.d().getPackageName();
        if (TextUtils.isEmpty(this.e) || !this.e.equals(packageName)) {
            b(context, this.f29750c, this.d);
        } else {
            a(context, this.f29750c, this.d);
        }
    }

    public void a(Context context, int i, int i2, String str, String str2, int i3, String str3) {
        Logger.a("SDKAction", "authFinish, result:", Integer.valueOf(i), ", errorCode:", Integer.valueOf(i2), ", errorMsg:", str, ", token:", str2, ", expireTime:", Integer.valueOf(i3), ", pkgName:", str3);
        if (c()) {
            return;
        }
        int i4 = i;
        int i5 = i2;
        String str4 = str;
        if (i == 0) {
            i4 = i;
            i5 = i2;
            str4 = str;
            if (!this.e.equals(str3)) {
                i4 = i;
                i5 = i2;
                str4 = str;
                if (!"com.blued".equals(str3)) {
                    i5 = 101;
                    str4 = "包名不匹配";
                    i4 = 1;
                }
            }
        }
        SDKActionCallback sDKActionCallback = this.f;
        if (sDKActionCallback == null) {
            Intent d = d();
            d.putExtra(a.f18649a, i4);
            if (i4 == 1) {
                d.putExtra(a.b, i5);
            } else if (i4 == 0) {
                d.putExtra(b.e, str2);
                d.putExtra(b.f, i3);
            }
            if (AppMethods.a(d)) {
                context.startActivity(d);
            }
        } else if (i4 == 0) {
            SDKAuthModel sDKAuthModel = new SDKAuthModel();
            sDKAuthModel.access_token = str2;
            sDKAuthModel.expire = i3;
            sDKAuthModel.package_name = str3;
            this.f.a(sDKAuthModel);
        } else {
            sDKActionCallback.a(i5, str4);
        }
        b();
    }

    @Override // com.soft.blued.sdk.SDKBaseAction
    protected void b(Context context) {
        a(context, 2, 0, null, null, 0, null);
    }
}
