package com.xiaomi.clientreport.manager;

import android.content.Context;
import com.xiaomi.clientreport.data.Config;
import com.xiaomi.clientreport.data.EventClientReport;
import com.xiaomi.clientreport.data.PerfClientReport;
import com.xiaomi.clientreport.processor.IEventProcessor;
import com.xiaomi.clientreport.processor.IPerfProcessor;
import com.xiaomi.push.ai;
import com.xiaomi.push.bn;
import com.xiaomi.push.bo;
import com.xiaomi.push.bp;
import com.xiaomi.push.bq;
import com.xiaomi.push.br;
import com.xiaomi.push.bu;
import com.xiaomi.push.j;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/clientreport/manager/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final int f27481a;

    /* renamed from: a  reason: collision with other field name */
    private static volatile a f46a;

    /* renamed from: a  reason: collision with other field name */
    private Context f47a;

    /* renamed from: a  reason: collision with other field name */
    private Config f48a;

    /* renamed from: a  reason: collision with other field name */
    private IEventProcessor f49a;

    /* renamed from: a  reason: collision with other field name */
    private IPerfProcessor f50a;

    /* renamed from: a  reason: collision with other field name */
    private String f51a;

    /* renamed from: a  reason: collision with other field name */
    private ExecutorService f53a = Executors.newSingleThreadExecutor();

    /* renamed from: a  reason: collision with other field name */
    private HashMap<String, HashMap<String, com.xiaomi.clientreport.data.a>> f52a = new HashMap<>();
    private HashMap<String, ArrayList<com.xiaomi.clientreport.data.a>> b = new HashMap<>();

    static {
        f27481a = j.m8997a() ? 30 : 10;
    }

    private a(Context context) {
        this.f47a = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a() {
        HashMap<String, ArrayList<com.xiaomi.clientreport.data.a>> hashMap = this.b;
        int i = 0;
        if (hashMap != null) {
            Iterator<String> it = hashMap.keySet().iterator();
            int i2 = 0;
            while (true) {
                i = i2;
                if (!it.hasNext()) {
                    break;
                }
                ArrayList<com.xiaomi.clientreport.data.a> arrayList = this.b.get(it.next());
                i2 = i + (arrayList != null ? arrayList.size() : 0);
            }
        }
        return i;
    }

    public static a a(Context context) {
        if (f46a == null) {
            synchronized (a.class) {
                try {
                    if (f46a == null) {
                        f46a = new a(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f46a;
    }

    private void a(ai.a aVar, int i) {
        ai.a(this.f47a).b(aVar, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int b() {
        HashMap<String, HashMap<String, com.xiaomi.clientreport.data.a>> hashMap = this.f52a;
        int i = 0;
        int i2 = 0;
        if (hashMap != null) {
            Iterator<String> it = hashMap.keySet().iterator();
            while (true) {
                i = i2;
                if (!it.hasNext()) {
                    break;
                }
                HashMap<String, com.xiaomi.clientreport.data.a> hashMap2 = this.f52a.get(it.next());
                if (hashMap2 != null) {
                    Iterator<String> it2 = hashMap2.keySet().iterator();
                    int i3 = i2;
                    while (true) {
                        i2 = i3;
                        if (it2.hasNext()) {
                            com.xiaomi.clientreport.data.a aVar = hashMap2.get(it2.next());
                            if (aVar instanceof PerfClientReport) {
                                i3 = (int) (i3 + ((PerfClientReport) aVar).perfCounts);
                            }
                        }
                    }
                }
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(EventClientReport eventClientReport) {
        IEventProcessor iEventProcessor = this.f49a;
        if (iEventProcessor != null) {
            iEventProcessor.mo8353a(eventClientReport);
            if (a() < 10) {
                a(new d(this), f27481a);
                return;
            }
            d();
            ai.a(this.f47a).m8453a("100888");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(PerfClientReport perfClientReport) {
        IPerfProcessor iPerfProcessor = this.f50a;
        if (iPerfProcessor != null) {
            iPerfProcessor.mo8353a(perfClientReport);
            if (b() < 10) {
                a(new f(this), f27481a);
                return;
            }
            e();
            ai.a(this.f47a).m8453a("100889");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        try {
            this.f49a.b();
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.d("we: " + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        try {
            this.f50a.b();
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.d("wp: " + e.getMessage());
        }
    }

    private void f() {
        if (a(this.f47a).m8350a().isEventUploadSwitchOpen()) {
            bo boVar = new bo(this.f47a);
            int eventUploadFrequency = (int) a(this.f47a).m8350a().getEventUploadFrequency();
            int i = eventUploadFrequency;
            if (eventUploadFrequency < 1800) {
                i = 1800;
            }
            if (System.currentTimeMillis() - bu.a(this.f47a).a("sp_client_report_status", "event_last_upload_time", 0L) > i * 1000) {
                ai.a(this.f47a).a(new h(this, boVar), 10);
            }
            synchronized (a.class) {
                try {
                    if (!ai.a(this.f47a).a((ai.a) boVar, i)) {
                        ai.a(this.f47a).m8453a("100886");
                        ai.a(this.f47a).a((ai.a) boVar, i);
                    }
                } finally {
                }
            }
        }
    }

    private void g() {
        if (a(this.f47a).m8350a().isPerfUploadSwitchOpen()) {
            bp bpVar = new bp(this.f47a);
            int perfUploadFrequency = (int) a(this.f47a).m8350a().getPerfUploadFrequency();
            int i = perfUploadFrequency;
            if (perfUploadFrequency < 1800) {
                i = 1800;
            }
            if (System.currentTimeMillis() - bu.a(this.f47a).a("sp_client_report_status", "perf_last_upload_time", 0L) > i * 1000) {
                ai.a(this.f47a).a(new i(this, bpVar), 15);
            }
            synchronized (a.class) {
                try {
                    if (!ai.a(this.f47a).a((ai.a) bpVar, i)) {
                        ai.a(this.f47a).m8453a("100887");
                        ai.a(this.f47a).a((ai.a) bpVar, i);
                    }
                } finally {
                }
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public Config m8350a() {
        Config config;
        synchronized (this) {
            if (this.f48a == null) {
                this.f48a = Config.defaultConfig(this.f47a);
            }
            config = this.f48a;
        }
        return config;
    }

    public EventClientReport a(int i, String str) {
        EventClientReport eventClientReport = new EventClientReport();
        eventClientReport.eventContent = str;
        eventClientReport.eventTime = System.currentTimeMillis();
        eventClientReport.eventType = i;
        eventClientReport.eventId = bn.a(6);
        eventClientReport.production = 1000;
        eventClientReport.reportType = 1001;
        eventClientReport.clientInterfaceId = "E100004";
        eventClientReport.setAppPackageName(this.f47a.getPackageName());
        eventClientReport.setSdkVersion(this.f51a);
        return eventClientReport;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m8351a() {
        a(this.f47a).f();
        a(this.f47a).g();
    }

    public void a(Config config, IEventProcessor iEventProcessor, IPerfProcessor iPerfProcessor) {
        this.f48a = config;
        this.f49a = iEventProcessor;
        this.f50a = iPerfProcessor;
        iEventProcessor.setEventMap(this.b);
        this.f50a.setPerfMap(this.f52a);
    }

    public void a(EventClientReport eventClientReport) {
        if (m8350a().isEventUploadSwitchOpen()) {
            this.f53a.execute(new b(this, eventClientReport));
        }
    }

    public void a(PerfClientReport perfClientReport) {
        if (m8350a().isPerfUploadSwitchOpen()) {
            this.f53a.execute(new c(this, perfClientReport));
        }
    }

    public void a(String str) {
        this.f51a = str;
    }

    public void a(boolean z, boolean z2, long j, long j2) {
        Config config = this.f48a;
        if (config != null) {
            if (z == config.isEventUploadSwitchOpen() && z2 == this.f48a.isPerfUploadSwitchOpen() && j == this.f48a.getEventUploadFrequency() && j2 == this.f48a.getPerfUploadFrequency()) {
                return;
            }
            long eventUploadFrequency = this.f48a.getEventUploadFrequency();
            long perfUploadFrequency = this.f48a.getPerfUploadFrequency();
            Config build = Config.getBuilder().setAESKey(br.a(this.f47a)).setEventEncrypted(this.f48a.isEventEncrypted()).setEventUploadSwitchOpen(z).setEventUploadFrequency(j).setPerfUploadSwitchOpen(z2).setPerfUploadFrequency(j2).build(this.f47a);
            this.f48a = build;
            if (!build.isEventUploadSwitchOpen()) {
                ai.a(this.f47a).m8453a("100886");
            } else if (eventUploadFrequency != build.getEventUploadFrequency()) {
                com.xiaomi.channel.commonutils.logger.b.c(this.f47a.getPackageName() + "reset event job " + build.getEventUploadFrequency());
                f();
            }
            if (!this.f48a.isPerfUploadSwitchOpen()) {
                ai.a(this.f47a).m8453a("100887");
            } else if (perfUploadFrequency != build.getPerfUploadFrequency()) {
                com.xiaomi.channel.commonutils.logger.b.c(this.f47a.getPackageName() + " reset perf job " + build.getPerfUploadFrequency());
                g();
            }
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m8352b() {
        if (m8350a().isEventUploadSwitchOpen()) {
            bq bqVar = new bq();
            bqVar.a(this.f47a);
            bqVar.a(this.f49a);
            this.f53a.execute(bqVar);
        }
    }

    public void c() {
        if (m8350a().isPerfUploadSwitchOpen()) {
            bq bqVar = new bq();
            bqVar.a(this.f50a);
            bqVar.a(this.f47a);
            this.f53a.execute(bqVar);
        }
    }
}
