package com.tencent.cloud.huiyansdkface.facelight.ui.widget;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.cloud.huiyansdkface.normal.tools.WLogger;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/facelight/ui/widget/c.class */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private Context f35786a;
    private IntentFilter b = new IntentFilter(Intent.ACTION_CLOSE_SYSTEM_DIALOGS);

    /* renamed from: c  reason: collision with root package name */
    private b f35787c;
    private a d;

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/facelight/ui/widget/c$a.class */
    class a extends BroadcastReceiver {

        /* renamed from: a  reason: collision with root package name */
        final String f35788a = "reason";
        final String b = "globalactions";

        /* renamed from: c  reason: collision with root package name */
        final String f35789c = "recentapps";
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
            if (c.this.f35787c != null) {
                if (stringExtra.equals("homekey")) {
                    c.this.f35787c.a();
                } else if (stringExtra.equals("recentapps")) {
                    c.this.f35787c.b();
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
        this.f35786a = context;
    }

    public void a() {
        a aVar = this.d;
        if (aVar != null) {
            this.f35786a.registerReceiver(aVar, this.b, null, null);
        }
    }

    public void a(b bVar) {
        this.f35787c = bVar;
        this.d = new a();
    }

    public void b() {
        a aVar = this.d;
        if (aVar != null) {
            this.f35786a.unregisterReceiver(aVar);
        }
    }
}
