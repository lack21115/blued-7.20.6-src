package com.xiaomi.push;

import android.app.Notification;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RemoteViews;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/eo.class */
public class eo extends Notification.Builder {

    /* renamed from: a  reason: collision with root package name */
    private Context f41378a;

    public eo(Context context) {
        super(context);
        this.f41378a = context;
    }

    public int a(Resources resources, String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        return resources.getIdentifier(str, str2, str3);
    }

    public final int a(String str) {
        return a(a().getResources(), str, "id", a().getPackageName());
    }

    protected Context a() {
        return this.f41378a;
    }

    @Override // android.app.Notification.Builder
    /* renamed from: a */
    public eo addExtras(Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 20) {
            super.addExtras(bundle);
        }
        return this;
    }

    /* renamed from: a */
    public eo setCustomContentView(RemoteViews remoteViews) {
        if (Build.VERSION.SDK_INT >= 24) {
            super.setCustomContentView(remoteViews);
            return this;
        }
        super.setContent(remoteViews);
        return this;
    }

    /* renamed from: a  reason: collision with other method in class */
    public eo mo11720a(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                bi.a((Object) this, "setColor", Integer.valueOf(Color.parseColor(str)));
                return this;
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.d("fail to set color. ".concat(String.valueOf(e)));
            }
        }
        return this;
    }

    public eo a(Map<String, String> map) {
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void mo11718a() {
    }

    @Override // android.app.Notification.Builder
    public Notification build() {
        mo11718a();
        return super.build();
    }
}
