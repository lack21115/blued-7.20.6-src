package com.efs.sdk.pa.a;

import android.app.Application;
import android.content.Context;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import com.efs.sdk.base.integrationtesting.IntegrationTestingUtil;
import com.efs.sdk.pa.PA;
import com.efs.sdk.pa.PAANRListener;
import com.efs.sdk.pa.PAMsgListener;
import com.efs.sdk.pa.a.b;
import com.efs.sdk.pa.a.g;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

/* loaded from: source-8110460-dex2jar.jar:com/efs/sdk/pa/a/c.class */
public final class c implements PA {

    /* renamed from: a  reason: collision with root package name */
    private boolean f21857a;

    /* renamed from: c  reason: collision with root package name */
    private e f21858c;
    private f d;
    private a e;
    private boolean h;
    private boolean i;
    private Looper b = Looper.myLooper();
    private b f = new b();
    private g g = new g();

    public c(boolean z) {
        this.i = z;
    }

    @Override // com.efs.sdk.pa.PA
    public final void enableDumpToFile(String str) {
        FileOutputStream fileOutputStream;
        f fVar = this.d;
        if (fVar == null || str == null || str.trim().length() == 0) {
            return;
        }
        fVar.f21862c = str;
        if (fVar.d == null) {
            try {
                fileOutputStream = new FileOutputStream(str);
            } catch (Exception e) {
                fileOutputStream = null;
            }
            try {
                fVar.d = new BufferedOutputStream(fileOutputStream);
            } catch (Exception e2) {
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (Exception e3) {
                    }
                }
            }
        }
    }

    @Override // com.efs.sdk.pa.PA
    public final void enableLog(boolean z) {
        this.f21857a = z;
        this.f.b = z;
        this.g.b = z;
        f fVar = this.d;
        if (fVar != null) {
            fVar.b = z;
        }
    }

    @Override // com.efs.sdk.pa.PA
    public final int endCalFPS(String str) {
        b.a aVar;
        if (this.h) {
            b bVar = this.f;
            int i = 0;
            int i2 = 0;
            if (str != null) {
                if (str.trim().length() == 0 || (aVar = bVar.f21853a.get(str)) == null) {
                    return 0;
                }
                if (aVar.d != null && aVar.f21855c != null) {
                    aVar.d.getViewTreeObserver().removeOnPreDrawListener(aVar.f21855c);
                }
                bVar.f21853a.remove(str);
                int currentTimeMillis = (int) (((float) aVar.b) / (((float) (System.currentTimeMillis() - aVar.f21854a)) / 1000.0f));
                if (currentTimeMillis > 0) {
                    i2 = currentTimeMillis;
                }
                i = i2;
                if (bVar.b) {
                    Log.e("PerformanceAnalyze", "key=" + str + ",fps=" + i2);
                    i = i2;
                }
            }
            return i;
        }
        return -1;
    }

    @Override // com.efs.sdk.pa.PA
    public final long endCalTime(String str) {
        g.a aVar;
        if (this.h) {
            g gVar = this.g;
            long j = 0;
            if (str != null) {
                if (str.trim().length() == 0 || (aVar = gVar.f21863a.get(str)) == null) {
                    return 0L;
                }
                gVar.f21863a.remove(str);
                long currentTimeMillis = System.currentTimeMillis() - aVar.f21864a;
                j = currentTimeMillis;
                if (gVar.b) {
                    Log.e("PerformanceAnalyze", "key=" + str + ",consumeTime=" + currentTimeMillis);
                    j = currentTimeMillis;
                }
            }
            return j;
        }
        return -1L;
    }

    @Override // com.efs.sdk.pa.PA
    public final void registerPAANRListener(Context context, PAANRListener pAANRListener) {
        registerPAANRListener(context, pAANRListener, 2000L);
    }

    @Override // com.efs.sdk.pa.PA
    public final void registerPAANRListener(Context context, PAANRListener pAANRListener, long j) {
        registerPAANRListener(context, pAANRListener, j, Looper.getMainLooper().getThread());
    }

    @Override // com.efs.sdk.pa.PA
    public final void registerPAANRListener(Context context, PAANRListener pAANRListener, long j, Thread thread) {
        if (this.e == null) {
            if (thread != null) {
                this.e = new a((Application) context.getApplicationContext(), j);
            } else {
                this.e = new a((Application) context.getApplicationContext(), j, false);
            }
        }
        this.e.h = pAANRListener;
    }

    @Override // com.efs.sdk.pa.PA
    public final void registerPAMsgListener(PAMsgListener pAMsgListener) {
        if (this.f21858c == null) {
            this.f21858c = new e();
        }
        this.b.setMessageLogging(this.f21858c);
        if (this.d == null) {
            this.d = new f();
        }
        this.d.b = this.f21857a;
        this.d.f21861a = pAMsgListener;
        e eVar = this.f21858c;
        eVar.f21859a.add(this.d);
    }

    @Override // com.efs.sdk.pa.PA
    public final void start() {
        if (this.i || IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
            this.h = true;
            e eVar = this.f21858c;
            if (eVar != null) {
                this.b.setMessageLogging(eVar);
            }
            a aVar = this.e;
            if (aVar == null || !aVar.f) {
                return;
            }
            aVar.f = false;
            aVar.g.post(aVar.m);
            aVar.j = SystemClock.uptimeMillis();
        }
    }

    @Override // com.efs.sdk.pa.PA
    public final void startCalFPS(String str, View view) {
        if (this.h) {
            b bVar = this.f;
            if (str == null || str.trim().length() == 0 || view == null || bVar.f21853a.get(str) != null) {
                return;
            }
            final b.a aVar = new b.a((byte) 0);
            if (view != null) {
                aVar.d = view;
                ViewTreeObserver.OnPreDrawListener onPreDrawListener = new ViewTreeObserver.OnPreDrawListener() { // from class: com.efs.sdk.pa.a.b.a.1
                    @Override // android.view.ViewTreeObserver.OnPreDrawListener
                    public final boolean onPreDraw() {
                        aVar.b++;
                        return true;
                    }
                };
                aVar.f21855c = onPreDrawListener;
                aVar.d.getViewTreeObserver().addOnPreDrawListener(onPreDrawListener);
                aVar.f21854a = System.currentTimeMillis();
            }
            bVar.f21853a.put(str, aVar);
        }
    }

    @Override // com.efs.sdk.pa.PA
    public final void startCalTime(String str) {
        if (this.h) {
            g gVar = this.g;
            if (str == null || str.trim().length() == 0 || gVar.f21863a.get(str) != null) {
                return;
            }
            g.a aVar = new g.a((byte) 0);
            aVar.f21864a = System.currentTimeMillis();
            gVar.f21863a.put(str, aVar);
        }
    }

    @Override // com.efs.sdk.pa.PA
    public final void stop() {
        this.h = false;
        this.b.setMessageLogging(null);
        a aVar = this.e;
        if (aVar != null) {
            aVar.f = true;
            aVar.g.removeCallbacksAndMessages(null);
            aVar.f21849a = true;
        }
    }

    @Override // com.efs.sdk.pa.PA
    public final void unRegisterPAMsgListener() {
        f fVar = this.d;
        if (fVar != null) {
            fVar.f21861a = null;
        }
        e eVar = this.f21858c;
        if (eVar != null) {
            eVar.f21859a.remove(this.d);
        }
    }

    @Override // com.efs.sdk.pa.PA
    public final void unregisterPAANRListener() {
    }
}
