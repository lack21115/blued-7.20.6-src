package com.huawei.hms.hatool;

import com.xiaomi.mipush.sdk.Constants;
import java.util.Calendar;
import java.util.UUID;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/hatool/g0.class */
public class g0 {

    /* renamed from: a  reason: collision with root package name */
    public long f9135a = 1800000;
    public volatile boolean b = false;

    /* renamed from: c  reason: collision with root package name */
    public a f9136c = null;

    /* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/hatool/g0$a.class */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        public String f9137a = UUID.randomUUID().toString().replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, "");
        public boolean b = true;

        /* renamed from: c  reason: collision with root package name */
        public long f9138c;

        public a(long j) {
            this.f9137a += "_" + j;
            this.f9138c = j;
            g0.this.b = false;
        }

        public void a(long j) {
            if (g0.this.b) {
                g0.this.b = false;
                b(j);
            } else if (b(this.f9138c, j) || a(this.f9138c, j)) {
                b(j);
            } else {
                this.f9138c = j;
                this.b = false;
            }
        }

        public final boolean a(long j, long j2) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(j);
            Calendar calendar2 = Calendar.getInstance();
            calendar2.setTimeInMillis(j2);
            boolean z = true;
            if (calendar.get(1) == calendar2.get(1)) {
                if (calendar.get(6) != calendar2.get(6)) {
                    return true;
                }
                z = false;
            }
            return z;
        }

        public final void b(long j) {
            z.c("hmsSdk", "getNewSession() session is flush!");
            String uuid = UUID.randomUUID().toString();
            this.f9137a = uuid;
            this.f9137a = uuid.replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, "");
            this.f9137a += "_" + j;
            this.f9138c = j;
            this.b = true;
        }

        public final boolean b(long j, long j2) {
            return j2 - j >= g0.this.f9135a;
        }
    }

    public String a() {
        a aVar = this.f9136c;
        if (aVar == null) {
            z.f("hmsSdk", "getSessionName(): session not prepared. onEvent() must be called first.");
            return "";
        }
        return aVar.f9137a;
    }

    public void a(long j) {
        a aVar = this.f9136c;
        if (aVar != null) {
            aVar.a(j);
            return;
        }
        z.c("hmsSdk", "Session is first flush");
        this.f9136c = new a(j);
    }

    public boolean b() {
        a aVar = this.f9136c;
        if (aVar == null) {
            z.f("hmsSdk", "isFirstEvent(): session not prepared. onEvent() must be called first.");
            return false;
        }
        return aVar.b;
    }
}
