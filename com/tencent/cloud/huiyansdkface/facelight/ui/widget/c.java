package com.tencent.cloud.huiyansdkface.facelight.ui.widget;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.cloud.huiyansdkface.normal.tools.WLogger;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/facelight/ui/widget/c.class */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private Context f22095a;
    private IntentFilter b = new IntentFilter(Intent.ACTION_CLOSE_SYSTEM_DIALOGS);

    /* renamed from: c  reason: collision with root package name */
    private b f22096c;
    private a d;

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/facelight/ui/widget/c$a.class */
    class a extends BroadcastReceiver {

        /* renamed from: a  reason: collision with root package name */
        final String f22097a = "reason";
        final String b = "globalactions";

        /* renamed from: c  reason: collision with root package name */
        final String f22098c = "recentapps";
        final String d = "homekey";

        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String stringExtra;
            String action = intent.getAction();
            if (!action.equals(Intent.ACTION_CLOSE_SYSTEM_DIALOGS) || (stringExtra = intent.getStringExtra("reason")) == null) {
                return;
            }
            WLogger.i("HomeWatcher", "action: " + action + ",reason: " + stringExtra);
            if (c.this.f22096c != null) {
                if (stringExtra.equals("homekey")) {
                    c.this.f22096c.a();
                } else if (stringExtra.equals("recentapps")) {
                    c.this.f22096c.b();
                }
            }
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/facelight/ui/widget/c$b.class */
    public interface b {
        void a();

        void b();
    }

    public c(Context context) {
        this.f22095a = context;
    }

    public void a() {
        a aVar = this.d;
        if (aVar != null) {
            this.f22095a.registerReceiver(aVar, this.b, null, null);
        }
    }

    public void a(b bVar) {
        this.f22096c = bVar;
        this.d = new a();
    }

    public void b() {
        a aVar = this.d;
        if (aVar != null) {
            this.f22095a.unregisterReceiver(aVar);
        }
    }
}
