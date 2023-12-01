package com.getui.gtc;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.text.TextUtils;
import android.util.Base64;
import com.getui.gtc.api.GtcIdCallback;
import com.getui.gtc.api.GtcManager;
import com.getui.gtc.api.SdkInfo;
import com.getui.gtc.b.b;
import com.getui.gtc.base.util.ScheduleQueue;
import com.getui.gtc.i.c.a;

@Deprecated
/* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/GtcService.class */
public class GtcService extends Service {
    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        a.a("GtcService onBind");
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        a.a("GtcService onCreated");
        super.onCreate();
    }

    @Override // android.app.Service
    public void onDestroy() {
        a.a("GtcService onDestroy");
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(final Intent intent, int i, int i2) {
        try {
            ScheduleQueue.getInstance().addSchedule(new Runnable() { // from class: com.getui.gtc.GtcService.1
                @Override // java.lang.Runnable
                public final void run() {
                    final Context applicationContext = GtcService.this.getApplicationContext();
                    Intent intent2 = intent;
                    if (intent2 == null || !intent2.hasExtra("10010")) {
                        return;
                    }
                    String str = new String(Base64.decode(intent2.getByteArrayExtra("10010"), 0));
                    final int b = b.b(str);
                    final String a2 = b.a(str);
                    final String c2 = b.c(str);
                    com.getui.gtc.api.GtcManager.getInstance().init(applicationContext, new GtcIdCallback.Stub() { // from class: com.getui.gtc.b.b.1
                        @Override // com.getui.gtc.api.GtcIdCallback
                        public final void onFailure(String str2) {
                        }

                        @Override // com.getui.gtc.api.GtcIdCallback
                        public final void onSuccess(String str2) {
                            Context context = applicationContext;
                            try {
                                if (TextUtils.isEmpty(str2)) {
                                    com.getui.gtc.i.c.a.a("send cid broadcast fail,cid is null");
                                } else {
                                    Intent intent3 = new Intent();
                                    intent3.setAction(context.getPackageName());
                                    intent3.putExtra("gicid", str2);
                                    context.sendBroadcast(intent3);
                                }
                            } catch (Exception e) {
                                com.getui.gtc.i.c.a.c(e);
                            }
                            Context context2 = applicationContext;
                            String str3 = a2;
                            try {
                                if (TextUtils.isEmpty(str2)) {
                                    com.getui.gtc.i.c.a.a("send gicid broadcast fail,cid is null");
                                } else {
                                    Intent intent4 = new Intent();
                                    intent4.setPackage(context2.getPackageName());
                                    intent4.setAction(str3);
                                    intent4.putExtra("gicid", str2);
                                    context2.sendBroadcast(intent4);
                                }
                            } catch (Exception e2) {
                                com.getui.gtc.i.c.a.c(e2);
                            }
                            GtcManager gtcManager = GtcManager.getInstance();
                            SdkInfo.Builder builder = new SdkInfo.Builder();
                            gtcManager.loadSdk(builder.moduleName("SDKID:" + b).appid(c2).version(a2).cid(str2).build());
                        }
                    });
                }
            });
            return 2;
        } catch (Throwable th) {
            a.a(th);
            return 2;
        }
    }
}
