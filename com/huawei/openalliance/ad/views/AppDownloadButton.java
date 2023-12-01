package com.huawei.openalliance.ad.views;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Toast;
import com.huawei.hms.ads.dp;
import com.huawei.hms.ads.es;
import com.huawei.hms.ads.et;
import com.huawei.hms.ads.ew;
import com.huawei.hms.ads.fy;
import com.huawei.hms.ads.ge;
import com.huawei.hms.ads.km;
import com.huawei.hms.ads.ko;
import com.huawei.hms.ads.kz;
import com.huawei.hms.ads.lf;
import com.huawei.hms.ads.lt;
import com.huawei.hms.ads.nativead.R;
import com.huawei.openalliance.ad.beans.metadata.MetaData;
import com.huawei.openalliance.ad.beans.metadata.TextState;
import com.huawei.openalliance.ad.constant.ac;
import com.huawei.openalliance.ad.constant.s;
import com.huawei.openalliance.ad.download.app.AppDownloadTask;
import com.huawei.openalliance.ad.download.app.PPSAppDownloadManager;
import com.huawei.openalliance.ad.download.app.j;
import com.huawei.openalliance.ad.download.app.k;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.data.AppInfo;
import com.huawei.openalliance.ad.inter.data.m;
import com.huawei.openalliance.ad.inter.data.n;
import com.huawei.openalliance.ad.utils.aa;
import com.huawei.openalliance.ad.utils.ai;
import com.huawei.openalliance.ad.utils.au;
import com.huawei.openalliance.ad.utils.ay;
import com.huawei.openalliance.ad.utils.ba;
import com.huawei.openalliance.ad.utils.t;
import com.huawei.openalliance.ad.utils.v;
import com.huawei.openalliance.ad.views.a;
import java.text.NumberFormat;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/views/AppDownloadButton.class */
public class AppDownloadButton extends ProgressButton implements kz, com.huawei.openalliance.ad.download.g {
    private n C;
    private boolean D;
    private com.huawei.openalliance.ad.views.a F;
    private b L;
    private AppInfo S;

    /* renamed from: a  reason: collision with root package name */
    private c f23000a;
    private a b;

    /* renamed from: c  reason: collision with root package name */
    private k f23001c;
    private k d;
    private int e;
    private AdContentData f;
    private boolean g;
    private int h;
    private final int i;
    private List<TextState> j;
    private lf k;
    private final boolean l;
    private boolean m;
    private boolean n;
    private boolean o;
    private lt p;
    private boolean q;
    private int r;
    private m s;
    private boolean t;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.huawei.openalliance.ad.views.AppDownloadButton$4  reason: invalid class name */
    /* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/views/AppDownloadButton$4.class */
    public static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] Code;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x004d -> B:37:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0051 -> B:33:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0055 -> B:31:0x002a). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0059 -> B:27:0x0035). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x005d -> B:35:0x0040). Please submit an issue!!! */
        static {
            int[] iArr = new int[k.values().length];
            Code = iArr;
            try {
                iArr[k.DOWNLOAD.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                Code[k.PAUSE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                Code[k.DOWNLOADING.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                Code[k.INSTALLED.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                Code[k.INSTALL.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                Code[k.INSTALLING.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
        }
    }

    /* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/views/AppDownloadButton$a.class */
    public interface a {
        CharSequence Code(CharSequence charSequence, k kVar);
    }

    /* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/views/AppDownloadButton$b.class */
    public interface b {
        void Code(k kVar);
    }

    /* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/views/AppDownloadButton$c.class */
    public interface c {
        boolean Code(AppInfo appInfo, long j);
    }

    public AppDownloadButton(Context context) {
        super(context);
        this.e = -1;
        this.g = true;
        this.h = 1;
        this.i = 2;
        this.l = true;
        this.n = true;
        this.o = false;
        this.q = true;
        this.r = -1;
        this.t = false;
        Code(context, null, -1, -1);
    }

    public AppDownloadButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.e = -1;
        this.g = true;
        this.h = 1;
        this.i = 2;
        this.l = true;
        this.n = true;
        this.o = false;
        this.q = true;
        this.r = -1;
        this.t = false;
        Code(context, attributeSet, -1, -1);
    }

    public AppDownloadButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.e = -1;
        this.g = true;
        this.h = 1;
        this.i = 2;
        this.l = true;
        this.n = true;
        this.o = false;
        this.q = true;
        this.r = -1;
        this.t = false;
        Code(context, attributeSet, i, -1);
    }

    public AppDownloadButton(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.e = -1;
        this.g = true;
        this.h = 1;
        this.i = 2;
        this.l = true;
        this.n = true;
        this.o = false;
        this.q = true;
        this.r = -1;
        this.t = false;
        Code(context, attributeSet, i, i2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0089, code lost:
        if (r0 > 0) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x00ba, code lost:
        if (r0 <= 0) goto L3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.huawei.openalliance.ad.download.app.k Code(com.huawei.openalliance.ad.download.app.AppDownloadTask r8, java.lang.String r9, boolean r10) {
        /*
            r7 = this;
            r0 = r8
            int r0 = r0.B()
            r11 = r0
            java.lang.String r0 = "AppDownBtn"
            java.lang.String r1 = "refreshStatus, dwnStatus:%s, pkg:%s"
            r2 = 2
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r3 = r2
            r4 = 0
            r5 = r11
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r3[r4] = r5
            r3 = r2
            r4 = 1
            r5 = r9
            r3[r4] = r5
            com.huawei.hms.ads.ge.Code(r0, r1, r2)
            r0 = r11
            switch(r0) {
                case 0: goto La1;
                case 1: goto L93;
                case 2: goto L93;
                case 3: goto L8f;
                case 4: goto L7b;
                case 5: goto L74;
                case 6: goto L4c;
                default: goto L48;
            }
        L48:
            com.huawei.openalliance.ad.download.app.k r0 = com.huawei.openalliance.ad.download.app.k.DOWNLOAD
            return r0
        L4c:
            r0 = r10
            if (r0 != 0) goto L70
            com.huawei.openalliance.ad.download.app.k r0 = com.huawei.openalliance.ad.download.app.k.DOWNLOAD
            r9 = r0
            java.lang.String r0 = "AppDownBtn"
            java.lang.String r1 = " hasInstalled=%s"
            r2 = 1
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r3 = r2
            r4 = 0
            r5 = r10
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r5)
            r3[r4] = r5
            com.huawei.hms.ads.ge.Code(r0, r1, r2)
            com.huawei.openalliance.ad.download.app.g r0 = com.huawei.openalliance.ad.download.app.g.I()
            r1 = r8
            boolean r0 = r0.I(r1)
            r0 = r9
            return r0
        L70:
            com.huawei.openalliance.ad.download.app.k r0 = com.huawei.openalliance.ad.download.app.k.INSTALLED
            return r0
        L74:
            com.huawei.openalliance.ad.download.app.k r0 = com.huawei.openalliance.ad.download.app.k.INSTALLING
            r9 = r0
            goto L97
        L7b:
            r0 = r8
            int r0 = r0.S()
            r11 = r0
            r0 = r7
            r1 = r11
            r0.e = r1
            r0 = r11
            if (r0 <= 0) goto L48
            goto Lbd
        L8f:
            com.huawei.openalliance.ad.download.app.k r0 = com.huawei.openalliance.ad.download.app.k.INSTALL
            return r0
        L93:
            com.huawei.openalliance.ad.download.app.k r0 = com.huawei.openalliance.ad.download.app.k.DOWNLOADING
            r9 = r0
        L97:
            r0 = r7
            r1 = r8
            int r1 = r1.S()
            r0.e = r1
            r0 = r9
            return r0
        La1:
            r0 = r8
            int r0 = r0.D()
            r11 = r0
            r0 = r8
            int r0 = r0.S()
            r12 = r0
            r0 = r7
            r1 = r12
            r0.e = r1
            r0 = r11
            if (r0 != 0) goto Lbd
            r0 = r12
            if (r0 <= 0) goto L48
        Lbd:
            com.huawei.openalliance.ad.download.app.k r0 = com.huawei.openalliance.ad.download.app.k.PAUSE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.openalliance.ad.views.AppDownloadButton.Code(com.huawei.openalliance.ad.download.app.AppDownloadTask, java.lang.String, boolean):com.huawei.openalliance.ad.download.app.k");
    }

    private String Code(int i, k kVar) {
        String str;
        if (aa.Code(this.j)) {
            return null;
        }
        int i2 = 1 == i ? 2 : 1;
        int Code = TextState.Code(kVar);
        String V = com.huawei.openalliance.ad.utils.c.V();
        Iterator<TextState> it = this.j.iterator();
        String str2 = null;
        String str3 = null;
        while (true) {
            str = null;
            if (!it.hasNext()) {
                break;
            }
            TextState next = it.next();
            if (next != null && i2 == next.Code()) {
                String str4 = str2;
                if (Code == next.V()) {
                    if (V.equalsIgnoreCase(new Locale(next.I()).getLanguage())) {
                        str = next.Z();
                        break;
                    }
                    str4 = str2;
                    if (1 == next.B()) {
                        str4 = next.Z();
                    }
                }
                str2 = str4;
                if (next.V() == 0) {
                    str3 = next.Z();
                    str2 = str4;
                }
            }
        }
        if (!TextUtils.isEmpty(str)) {
            str2 = str;
        }
        if (!TextUtils.isEmpty(str2)) {
            str3 = str2;
        }
        return au.V(str3);
    }

    private String Code(Context context, k kVar) {
        int i;
        if (context == null || kVar == null) {
            return "";
        }
        switch (AnonymousClass4.Code[kVar.ordinal()]) {
            case 1:
                return dp.Code(context, this.S);
            case 2:
                i = R.string.hiad_download_resume;
                break;
            case 3:
                return NumberFormat.getPercentInstance().format((this.e * 1.0f) / 100.0f);
            case 4:
                return dp.Code(context, this.S, this.r);
            case 5:
                i = R.string.hiad_download_install;
                break;
            case 6:
                i = R.string.hiad_download_installing;
                break;
            default:
                return null;
        }
        return context.getString(i);
    }

    private void Code(Context context) {
        Code(context, this.h, k.INSTALLED);
    }

    private void Code(Context context, int i, k kVar) {
        String Code = Code(i, kVar);
        if (TextUtils.isEmpty(Code)) {
            Code((CharSequence) Code(context, kVar), true, kVar);
            return;
        }
        String str = Code;
        if (this.t) {
            str = Code;
            if (i == 1) {
                str = Code;
                if (kVar == k.DOWNLOADING) {
                    double d = (this.e * 1.0f) / 100.0f;
                    str = Code + NumberFormat.getPercentInstance().format(d);
                }
            }
        }
        Code((CharSequence) str, false, kVar);
    }

    private void Code(AppDownloadTask appDownloadTask, Context context) {
        if (appDownloadTask != null) {
            Code(context, this.h, k.INSTALL);
        }
    }

    private void Code(k kVar) {
        a.C0442a Code = this.F.Code(getContext(), kVar);
        setTextColor(Code.V);
        setProgressDrawable(Code.Code);
        Code(getContext(), this.h, kVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(boolean z) {
        ge.V("AppDownBtn", "processDownload, needShowPermissionDialog = %s", Boolean.valueOf(z));
        if (!ai.Z(getContext())) {
            Toast.makeText(getContext(), R.string.hiad_network_no_available, 0).show();
        } else if (this.S.n() && this.g && z) {
            com.huawei.openalliance.ad.download.app.j.Code(getContext(), this.S, new j.a() { // from class: com.huawei.openalliance.ad.views.AppDownloadButton.7
                @Override // com.huawei.openalliance.ad.download.app.j.a
                public void Code() {
                    AppDownloadButton.this.setNeedShowConfirmDialog(false);
                    AppDownloadButton.this.Code(false);
                }
            });
        } else {
            if (!ai.I(getContext())) {
                long leftSize = getLeftSize();
                c cVar = this.f23000a;
                if (cVar == null) {
                    V();
                    return;
                } else if (!cVar.Code(this.S, leftSize)) {
                    return;
                }
            }
            I();
        }
    }

    private boolean Code(Context context, String str) {
        boolean Code = com.huawei.openalliance.ad.utils.e.Code(context, str, this.S.D());
        int i = 1;
        if (Code) {
            PPSAppDownloadManager.Code(context, this.S);
            l();
            ko.Code(context, this.f, "intentSuccess", (Integer) 1, (Integer) null);
            ko.Code(context, this.f, 0, 0, "app", this.h, this.s, com.huawei.openalliance.ad.utils.b.Code(getContext()), ay.Code((View) this));
            this.s = null;
            m();
            return Code;
        }
        ge.V("AppDownBtn", "handClick, openAppIntent fail");
        if (com.huawei.openalliance.ad.utils.e.Code(context, str)) {
            i = 2;
        }
        ko.Code(getContext(), this.f, ac.D, (Integer) 1, Integer.valueOf(i));
        boolean I = com.huawei.openalliance.ad.utils.e.I(context, str);
        if (I) {
            l();
            ko.Code(context, this.C.l(), (Integer) 1);
            PPSAppDownloadManager.Code(context, this.S);
            ko.Code(context, this.f, 0, 0, "app", this.h, this.s, com.huawei.openalliance.ad.utils.b.Code(getContext()), ay.Code((View) this));
            this.s = null;
            m();
        } else {
            ge.V("AppDownBtn", "handClick, openAppMainPage fail");
        }
        return I;
    }

    private boolean D() {
        if (this.S == null) {
            h();
            ge.V("AppDownBtn", "appInfo is empty");
            return false;
        } else if (this.f23001c == k.INSTALLED || this.S.o()) {
            return true;
        } else {
            String r = this.S.r();
            if (!TextUtils.isEmpty(r)) {
                if (r.equals("7") && !TextUtils.isEmpty(this.S.h())) {
                    return true;
                }
                if (r.equals("9") && !TextUtils.isEmpty(this.S.Code()) && !TextUtils.isEmpty(this.S.s())) {
                    return true;
                }
            }
            if (TextUtils.isEmpty(this.S.Z())) {
                h();
                return false;
            }
            return true;
        }
    }

    private boolean F() {
        AppInfo appInfo = this.S;
        if (appInfo == null) {
            return false;
        }
        String r = appInfo.r();
        boolean z = false;
        if (!TextUtils.isEmpty(r)) {
            z = false;
            if (!TextUtils.isEmpty(this.S.Code())) {
                z = false;
                if (r.equals("6")) {
                    z = true;
                }
            }
        }
        return z;
    }

    private void I(AppDownloadTask appDownloadTask) {
        int i;
        k kVar;
        if (ge.Code()) {
            k kVar2 = this.f23001c;
            k kVar3 = this.d;
            AppInfo appInfo = this.S;
            ge.Code("AppDownBtn", "processStatus, status:%s, preStatus:%s, packageName:%s", kVar2, kVar3, appInfo == null ? null : appInfo.Code());
        }
        if (F() && this.f23001c != k.INSTALLED) {
            Code(k.DOWNLOAD);
            return;
        }
        Context context = getContext();
        a.C0442a Code = this.F.Code(getContext(), this.f23001c);
        setTextColor(Code.V);
        if (this.q) {
            int i2 = this.e;
            Drawable drawable = Code.Code;
            if (i2 != -1) {
                Code(drawable, this.e);
            } else {
                setProgressDrawable(drawable);
            }
        }
        switch (AnonymousClass4.Code[this.f23001c.ordinal()]) {
            case 1:
                Code(context, this.h, k.DOWNLOAD);
                return;
            case 2:
                i = this.h;
                kVar = k.PAUSE;
                break;
            case 3:
                i = this.h;
                kVar = k.DOWNLOADING;
                break;
            case 4:
                Code(context);
                return;
            case 5:
                Code(appDownloadTask, context);
                return;
            case 6:
                V(appDownloadTask, context);
                return;
            default:
                return;
        }
        Code(context, i, kVar);
        setProgress(this.e);
    }

    private boolean L() {
        String r = this.S.r();
        if (TextUtils.isEmpty(r) || TextUtils.isEmpty(this.S.h()) || !r.equals("7")) {
            return false;
        }
        if (!new com.huawei.openalliance.ad.uriaction.b(getContext(), this.f).Code()) {
            h();
            return false;
        }
        V(s.Code, this.h);
        j();
        return true;
    }

    private void V(AppDownloadTask appDownloadTask, Context context) {
        if (appDownloadTask != null) {
            Code(context, this.h, k.INSTALLING);
        }
    }

    private boolean V(Context context) {
        boolean Code = new com.huawei.openalliance.ad.uriaction.g(context, this.f).Code();
        if (Code) {
            PPSAppDownloadManager.Code(context, this.S);
            l();
            ko.Code(context, this.f, 0, 0, s.Z, this.h, this.s, com.huawei.openalliance.ad.utils.b.Code(getContext()), ay.Code((View) this));
            this.s = null;
            m();
        }
        return Code;
    }

    private void Z(AppDownloadTask appDownloadTask) {
        if (this.S == null || this.f == null) {
            ge.I("AppDownBtn", "installApk, appinfo or content record is null");
        } else {
            com.huawei.openalliance.ad.download.app.g.I().Code(appDownloadTask);
        }
    }

    private boolean a() {
        if (!"9".equals(this.S.r()) || TextUtils.isEmpty(this.S.Code()) || TextUtils.isEmpty(this.S.s())) {
            return false;
        }
        com.huawei.openalliance.ad.uriaction.h hVar = new com.huawei.openalliance.ad.uriaction.h(getContext(), this.f);
        if (!hVar.Code()) {
            h();
            return false;
        }
        V(hVar.I(), this.h);
        j();
        return true;
    }

    private boolean b() {
        String r = this.S.r();
        if (TextUtils.isEmpty(r) || TextUtils.isEmpty(this.S.Code()) || !r.equals("6")) {
            return false;
        }
        com.huawei.openalliance.ad.uriaction.m mVar = new com.huawei.openalliance.ad.uriaction.m(getContext(), this.f);
        mVar.Code(this.h);
        mVar.Code();
        V(s.F, this.h);
        j();
        return true;
    }

    private boolean c() {
        List<Integer> t;
        if (this.S != null && v.B(getContext()) && (t = this.S.t()) != null && t.contains(14)) {
            fy.Code(getContext()).Code();
            if (!com.huawei.openalliance.ad.uriaction.d.Code(getContext(), this.f, this.C.ae(), t).Code()) {
                h();
                return false;
            }
            V(s.B, this.h);
            j();
            return true;
        }
        return false;
    }

    private void d() {
        AppDownloadTask task;
        ge.Code("AppDownBtn", "doClickAction, status:" + this.f23001c);
        int i = AnonymousClass4.Code[this.f23001c.ordinal()];
        if (i == 1) {
            if (!com.huawei.openalliance.ad.utils.e.Code() && k()) {
                ge.V("AppDownBtn", "not allowed");
                return;
            }
            Code(true);
            V("download", this.h);
        } else if (i == 2) {
            Code(false);
        } else if (i == 3) {
            AppDownloadTask task2 = getTask();
            if (task2 != null) {
                com.huawei.openalliance.ad.download.app.g.I().V(task2);
            }
        } else if (i == 4) {
            e();
        } else if (i == 5 && (task = getTask()) != null) {
            Z(task);
        }
    }

    private void e() {
        if (!g() || this.r == 1) {
            k();
            return;
        }
        f();
        ba.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.AppDownloadButton.6
            @Override // java.lang.Runnable
            public void run() {
                AppDownloadButton.this.k();
            }
        }, 600L);
    }

    private void f() {
        Context context = getContext();
        AppDownloadTask o = o();
        if (context == null || o == null) {
            return;
        }
        com.huawei.openalliance.ad.download.app.b.Code(context).Code(o);
    }

    private boolean g() {
        return km.b(this.f.r()) && dp.Code(this.S);
    }

    private long getLeftSize() {
        if (this.S == null) {
            return 0L;
        }
        AppDownloadTask task = getTask();
        long B = this.S.B();
        long j = B;
        if (task != null) {
            j = this.S.B() - task.Z();
            if (j <= 0) {
                return B;
            }
        }
        return j;
    }

    private AppDownloadTask getTask() {
        AdContentData adContentData;
        AppDownloadTask V = com.huawei.openalliance.ad.download.app.g.I().V(this.S);
        if (V != null && (adContentData = this.f) != null) {
            V.Z(adContentData.C());
            V.B(this.f.s());
            V.C(this.f.S());
            V.I(this.f.B());
            V.S(this.f.ao());
            V.F(this.f.ap());
            V.D(this.f.E());
            V.C(this.f.aA());
            V.a(this.f.az());
        }
        return V;
    }

    private void h() {
        lt ltVar = this.p;
        if (ltVar != null) {
            ltVar.Code(this);
        }
    }

    private void i() {
        lt ltVar = this.p;
        if (ltVar != null) {
            ltVar.V(this);
        }
    }

    private void j() {
        lt ltVar = this.p;
        if (ltVar != null) {
            ltVar.I(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean k() {
        boolean z = false;
        if (this.f == null) {
            return false;
        }
        Context context = getContext();
        String Code = this.S.Code();
        if (t.Code(context, Code)) {
            z = V(context);
        }
        boolean z2 = z;
        if (!z) {
            z2 = Code(context, Code);
        }
        return z2;
    }

    private void l() {
        lf lfVar = this.k;
        if (lfVar != null) {
            lfVar.Code(2, true);
        }
    }

    private void m() {
        lf lfVar = this.k;
        if (lfVar != null) {
            lfVar.D();
        }
    }

    private boolean n() {
        AppInfo appInfo = this.S;
        return appInfo != null && appInfo.o() && com.huawei.openalliance.ad.utils.e.Z(getContext(), com.huawei.openalliance.ad.constant.t.W) >= 100300300;
    }

    private AppDownloadTask o() {
        AppDownloadTask Code = new AppDownloadTask.a().Code(this.D).Code(this.S).Code();
        if (Code == null) {
            return null;
        }
        Code.Code(Integer.valueOf(this.h));
        Code.I((Integer) 2);
        Code.Code(this.f);
        AdContentData adContentData = this.f;
        if (adContentData != null) {
            Code.B(adContentData.s());
            Code.Z(this.f.C());
            Code.C(this.f.S());
            Code.I(this.f.B());
            Code.S(this.f.ao());
            Code.F(this.f.ap());
            Code.D(this.f.E());
            Code.a(this.f.az());
            Code.C(this.f.aA());
        }
        return Code;
    }

    public void B() {
        if (ge.Code()) {
            ge.Code("AppDownBtn", "downloadApp, status:%s", this.f23001c);
        }
        if ((this.f23001c == k.DOWNLOAD || this.f23001c == k.PAUSE) && this.S != null) {
            AppDownloadTask task = getTask();
            if (task == null) {
                com.huawei.openalliance.ad.download.app.g.I().Code(o());
                return;
            }
            task.Code(Integer.valueOf(this.h));
            task.I((Integer) 2);
            task.Code(this.D);
            com.huawei.openalliance.ad.download.app.g.I().I(task);
        }
    }

    public k Code() {
        k Code;
        k kVar = k.DOWNLOAD;
        AppInfo appInfo = this.S;
        String str = null;
        AppDownloadTask appDownloadTask = null;
        if (appInfo == null) {
            this.d = this.f23001c;
            this.f23001c = kVar;
        } else {
            String Code2 = appInfo.Code();
            if (com.huawei.openalliance.ad.utils.e.V(getContext(), this.S.Code()) != null) {
                Code = k.INSTALLED;
            } else {
                appDownloadTask = getTask();
                Code = appDownloadTask != null ? Code(appDownloadTask, Code2, false) : k.DOWNLOAD;
            }
            this.d = this.f23001c;
            this.f23001c = Code;
            I(appDownloadTask);
            str = Code2;
        }
        ge.Code("AppDownBtn", "refreshStatus, status:%s, pkg:%s", this.f23001c, str);
        return this.f23001c;
    }

    @Override // com.huawei.hms.ads.kz
    public void Code(long j) {
        AdContentData adContentData = this.f;
        if (adContentData != null) {
            adContentData.Z(j);
        }
    }

    protected void Code(Context context, AttributeSet attributeSet, int i, int i2) {
        this.F = new com.huawei.openalliance.ad.views.a(context);
        setOnClickListener(this);
    }

    @Override // com.huawei.openalliance.ad.download.g
    public void Code(AppDownloadTask appDownloadTask) {
        AppInfo appInfo = this.S;
        if (appInfo == null || !appInfo.Code().equals(appDownloadTask.F())) {
            return;
        }
        ba.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.AppDownloadButton.12
            @Override // java.lang.Runnable
            public void run() {
                AppDownloadButton.this.Code();
                if (AppDownloadButton.this.L == null || AppDownloadButton.this.d == AppDownloadButton.this.f23001c) {
                    return;
                }
                AppDownloadButton.this.L.Code(AppDownloadButton.this.f23001c);
            }
        });
    }

    public void Code(CharSequence charSequence, boolean z, k kVar) {
        a aVar = this.b;
        CharSequence charSequence2 = charSequence;
        if (aVar != null) {
            charSequence2 = charSequence;
            if (z) {
                charSequence2 = aVar.Code(charSequence, kVar);
            }
        }
        super.setText(charSequence2);
    }

    @Override // com.huawei.openalliance.ad.download.g
    public void Code(String str) {
        if (ge.Code()) {
            AppInfo appInfo = this.S;
            ge.Code("AppDownBtn", "onStatusChanged, packageName:%s, packageName %s", str, appInfo == null ? null : appInfo.Code());
        }
        AppInfo appInfo2 = this.S;
        if (appInfo2 == null || !appInfo2.Code().equals(str)) {
            return;
        }
        ba.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.AppDownloadButton.11
            @Override // java.lang.Runnable
            public void run() {
                AppDownloadButton.this.Code();
                if (AppDownloadButton.this.L == null || AppDownloadButton.this.d == AppDownloadButton.this.f23001c) {
                    return;
                }
                AppDownloadButton.this.L.Code(AppDownloadButton.this.f23001c);
            }
        });
    }

    @Override // com.huawei.openalliance.ad.download.f
    public void Code(String str, final int i) {
        if (ge.Code()) {
            ge.Code("AppDownBtn", "status %s, packageName:%s", Integer.valueOf(i), str);
        }
        if (dp.Code(this.S)) {
            ba.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.AppDownloadButton.3
                @Override // java.lang.Runnable
                public void run() {
                    AppDownloadButton.this.r = i;
                    AppDownloadButton.this.Code();
                }
            });
        }
    }

    @Override // com.huawei.hms.ads.kz
    public boolean Code(com.huawei.openalliance.ad.inter.data.g gVar) {
        if (gVar == null) {
            setAppInfo(null);
            this.f = null;
            this.C = null;
            return false;
        }
        if (gVar instanceof n) {
            this.C = (n) gVar;
        }
        try {
            this.h = 1;
            this.f = this.C.l();
            AppInfo v = gVar.v();
            setAppInfo(v);
            if (this.C != null) {
                MetaData k = this.C.k();
                if (k != null) {
                    this.j = k.f();
                }
                this.m = km.B(this.C.z());
            }
            if (v != null) {
                setShowPermissionDialog(v.c());
                return true;
            }
            return false;
        } catch (RuntimeException | Exception e) {
            ge.Z("AppDownBtn", "setNativeAd ex");
            return false;
        }
    }

    public void I() {
        Context context = getContext();
        if (!(context instanceof Activity) || getStatus() != k.DOWNLOAD || !this.m || !this.n) {
            B();
            return;
        }
        et etVar = new et(context);
        etVar.Code(new es.a() { // from class: com.huawei.openalliance.ad.views.AppDownloadButton.9
            @Override // com.huawei.hms.ads.es.a
            public void Code(AppInfo appInfo) {
                AppDownloadButton.this.setNeedShowConfirmDialog(false);
                AppDownloadButton.this.B();
            }

            @Override // com.huawei.hms.ads.es.a
            public void V(AppInfo appInfo) {
            }
        });
        this.o = true;
        etVar.Code(this.S, this.f, getLeftSize());
    }

    @Override // com.huawei.openalliance.ad.download.g
    public void I(String str) {
        V(str);
    }

    public void V() {
        ge.Code("AppDownBtn", "downloadInMobileData");
        if (n()) {
            I();
            return;
        }
        ge.Code("AppDownBtn", "not useAgMobileDataTipsDialog");
        ew ewVar = new ew(getContext());
        ewVar.Code(new es.a() { // from class: com.huawei.openalliance.ad.views.AppDownloadButton.8
            @Override // com.huawei.hms.ads.es.a
            public void Code(AppInfo appInfo) {
                AppDownloadButton.this.setAllowedNonWifiNetwork(true);
                AppDownloadButton.this.setNeedShowConfirmDialog(false);
                AppDownloadButton.this.I();
            }

            @Override // com.huawei.hms.ads.es.a
            public void V(AppInfo appInfo) {
            }
        });
        ewVar.Code(this.S, this.f, getLeftSize());
    }

    @Override // com.huawei.openalliance.ad.download.g
    public void V(AppDownloadTask appDownloadTask) {
        StringBuilder sb = new StringBuilder();
        sb.append("onStatusChanged, taskId:");
        sb.append(appDownloadTask.F());
        sb.append(", packageName");
        AppInfo appInfo = this.S;
        sb.append(appInfo == null ? null : appInfo.Code());
        sb.append(", status:");
        sb.append(appDownloadTask.B());
        ge.V("AppDownBtn", sb.toString());
        AppInfo appInfo2 = this.S;
        if (appInfo2 == null || !appInfo2.Code().equals(appDownloadTask.F())) {
            return;
        }
        ba.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.AppDownloadButton.10
            @Override // java.lang.Runnable
            public void run() {
                AppDownloadButton.this.Code();
                if (AppDownloadButton.this.L != null) {
                    AppDownloadButton.this.L.Code(AppDownloadButton.this.f23001c);
                }
            }
        });
    }

    @Override // com.huawei.openalliance.ad.download.g
    public void V(String str) {
        AppInfo appInfo = this.S;
        if (appInfo == null || str == null || !str.equals(appInfo.Code())) {
            return;
        }
        ba.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.AppDownloadButton.2
            @Override // java.lang.Runnable
            public void run() {
                AppDownloadButton.this.Code();
                if (AppDownloadButton.this.L != null) {
                    AppDownloadButton.this.L.Code(AppDownloadButton.this.f23001c);
                }
            }
        });
    }

    public void V(String str, int i) {
        if (this.f != null) {
            l();
            if (i == 1 || this.f.Code() == 7 || this.f.Code() == 12) {
                ko.Code(getContext(), this.f, 0, 0, str, i, this.s, com.huawei.openalliance.ad.utils.b.Code(getContext()), ay.Code((View) this));
                this.s = null;
                m();
            }
        }
    }

    @Override // com.huawei.hms.ads.kz
    public void Z(String str) {
        AdContentData adContentData = this.f;
        if (adContentData != null) {
            adContentData.V(str);
        }
    }

    public void cancel() {
        com.huawei.openalliance.ad.download.app.g.I().Code(this.S);
        Code();
        setOnNonWifiDownloadListener(null);
        setNeedShowConfirmDialog(true);
    }

    public void continueDownload() {
        String str;
        if (D()) {
            i();
            if (a()) {
                str = "open harmony service";
            } else if (this.f23001c == k.INSTALLED) {
                d();
                return;
            } else if (L()) {
                str = "open Ag detail";
            } else if (b()) {
                str = "open Ag mini detail";
            } else if (!c()) {
                B();
                return;
            } else {
                str = "open Gp detail";
            }
        } else {
            str = "click action invalid.";
        }
        ge.V("AppDownBtn", str);
    }

    public lt getClickActionListener() {
        return this.p;
    }

    public k getStatus() {
        return this.f23001c;
    }

    public com.huawei.openalliance.ad.views.a getStyle() {
        return this.F;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        try {
            if (ge.Code()) {
                ge.Code("AppDownBtn", "attach, pkg:%s", this.S == null ? null : this.S.Code());
            } else {
                ge.V("AppDownBtn", "attach appinfo is " + au.V(this.S));
            }
            com.huawei.openalliance.ad.download.app.g.I().Code(this.S, this);
            ba.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.AppDownloadButton.1
                @Override // java.lang.Runnable
                public void run() {
                    AppDownloadButton.this.Code();
                }
            });
        } catch (RuntimeException | Exception e) {
            ge.I("AppDownBtn", "attach ex");
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        ge.V("AppDownBtn", "onClick");
        if (S()) {
            str = "fast click";
        } else if (D()) {
            i();
            if (a()) {
                str = "open harmony service";
            } else if (this.f23001c == k.INSTALLED) {
                d();
                return;
            } else if (L()) {
                str = "open Ag detail";
            } else if (b()) {
                str = "open Ag mini detail";
            } else if (!c()) {
                d();
                return;
            } else {
                str = "open Gp detail";
            }
        } else {
            str = "click action invalid.";
        }
        ge.V("AppDownBtn", str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            if (ge.Code()) {
                ge.Code("AppDownBtn", "detach, pkg:%s", this.S == null ? null : this.S.Code());
            } else {
                ge.V("AppDownBtn", "detach appinfo is " + au.V(this.S));
            }
            com.huawei.openalliance.ad.download.app.g.I().V(this.S, this);
            fy.Code(getContext()).V();
        } catch (RuntimeException | Exception e) {
            ge.I("AppDownBtn", "detach ex");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onVisibilityChanged(View view, int i) {
        ge.V("AppDownBtn", "onVisibilityChanged, status:" + this.f23001c);
        super.onVisibilityChanged(view, i);
        ba.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.AppDownloadButton.5
            @Override // java.lang.Runnable
            public void run() {
                AppDownloadButton.this.Code();
            }
        });
    }

    public void setAfDlBtnText(String str) {
        if (this.S == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.S.S(str);
    }

    public void setAllowedNonWifiNetwork(boolean z) {
        this.D = z;
    }

    public void setAppDownloadButtonStyle(com.huawei.openalliance.ad.views.a aVar) {
        this.F = aVar;
    }

    public void setAppInfo(AppInfo appInfo) {
        ge.V("AppDownBtn", "setAppInfo appInfo is " + au.V(appInfo));
        this.S = appInfo;
        if (appInfo != null) {
            com.huawei.openalliance.ad.download.app.g.I().Code(appInfo, this);
        }
    }

    public void setButtonTextWatcher(a aVar) {
        this.b = aVar;
    }

    @Override // com.huawei.hms.ads.kz
    public void setClickActionListener(lt ltVar) {
        this.p = ltVar;
    }

    public void setClickInfo(m mVar) {
        this.s = mVar;
    }

    public void setIsSetProgressDrawable(boolean z) {
        this.q = z;
    }

    public void setNeedAppendProgress(boolean z) {
        this.t = z;
    }

    public void setNeedShowConfirmDialog(boolean z) {
        this.n = z;
    }

    public void setOnDownloadStatusChangedListener(b bVar) {
        this.L = bVar;
    }

    public void setOnNonWifiDownloadListener(c cVar) {
        this.f23000a = cVar;
    }

    @Override // com.huawei.hms.ads.kz
    public void setPpsNativeView(lf lfVar) {
        this.k = lfVar;
    }

    public void setShowPermissionDialog(boolean z) {
        this.g = z;
    }
}
