package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.clientreport.processor.IEventProcessor;
import com.xiaomi.clientreport.processor.IPerfProcessor;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/bq.class */
public class bq implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private Context f27598a;

    /* renamed from: a  reason: collision with other field name */
    private com.xiaomi.clientreport.processor.c f178a;

    public void a(Context context) {
        this.f27598a = context;
    }

    public void a(com.xiaomi.clientreport.processor.c cVar) {
        this.f178a = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (this.f178a != null) {
                this.f178a.a();
            }
            com.xiaomi.channel.commonutils.logger.b.c("begin read and send perf / event");
            if (this.f178a instanceof IEventProcessor) {
                bu.a(this.f27598a).m8504a("sp_client_report_status", "event_last_upload_time", System.currentTimeMillis());
            } else if (this.f178a instanceof IPerfProcessor) {
                bu.a(this.f27598a).m8504a("sp_client_report_status", "perf_last_upload_time", System.currentTimeMillis());
            }
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
        }
    }
}
