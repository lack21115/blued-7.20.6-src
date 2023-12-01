package com.ss.android.downloadad.api.mb;

import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.model.DeepLink;
import com.ss.android.downloadad.api.download.AdDownloadController;
import com.ss.android.downloadad.api.download.AdDownloadEventConfig;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.downloadlib.addownload.x;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/downloadad/api/mb/ox.class */
public class ox implements mb {

    /* renamed from: a  reason: collision with root package name */
    private int f21194a;
    private String al;
    public final AtomicBoolean b;
    private boolean bv;
    private long cd;
    private JSONObject df;
    private String e;
    private String ep;
    private long fb;
    private int fu;
    private long g;
    private long ge;
    private boolean gm;
    private long h;
    private boolean he;
    public final AtomicBoolean hj;
    private int i;

    /* renamed from: io  reason: collision with root package name */
    private int f21195io;
    private String jb;
    private String je;
    private int jq;
    private boolean kg;
    private boolean kk;
    private boolean km;
    private String ko;
    private String l;
    private int lc;
    private String lz;
    private String m;
    protected boolean mb;
    private boolean n;
    private int nf;
    private long ng;
    private int nk;
    private boolean nq;
    private int o;
    private boolean on;
    private long ot;
    protected boolean ox;
    private boolean pa;
    private boolean q;
    private String qa;
    private int r;
    private boolean s;
    private boolean sa;
    private boolean sr;
    private boolean sw;
    private boolean tl;
    private long u;
    private transient boolean up;
    private String vy;
    private boolean w;
    private String wn;
    private int ww;
    private String x;
    private long xa;
    private boolean yr;
    private int z;

    private ox() {
        this.ww = 1;
        this.gm = true;
        this.on = false;
        this.jq = 0;
        this.f21194a = 0;
        this.sw = false;
        this.q = false;
        this.bv = true;
        this.w = true;
        this.mb = true;
        this.ox = true;
        this.b = new AtomicBoolean(false);
        this.hj = new AtomicBoolean(false);
        this.i = 1;
        this.sa = true;
        this.cd = -1L;
    }

    public ox(DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController) {
        this(downloadModel, downloadEventConfig, downloadController, 0);
    }

    public ox(DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController, int i) {
        this.ww = 1;
        this.gm = true;
        this.on = false;
        this.jq = 0;
        this.f21194a = 0;
        this.sw = false;
        this.q = false;
        this.bv = true;
        this.w = true;
        this.mb = true;
        this.ox = true;
        this.b = new AtomicBoolean(false);
        this.hj = new AtomicBoolean(false);
        this.i = 1;
        this.sa = true;
        this.cd = -1L;
        this.h = downloadModel.getId();
        this.u = downloadModel.getExtraValue();
        this.ko = downloadModel.getLogExtra();
        this.lz = downloadModel.getPackageName();
        this.df = downloadModel.getExtra();
        this.gm = downloadModel.isAd();
        this.f21195io = downloadModel.getVersionCode();
        this.e = downloadModel.getVersionName();
        this.x = downloadModel.getDownloadUrl();
        if (downloadModel.getDeepLink() != null) {
            this.jb = downloadModel.getDeepLink().getOpenUrl();
            this.je = downloadModel.getDeepLink().getWebUrl();
        }
        this.nk = downloadModel.getModelType();
        this.l = downloadModel.getName();
        this.m = downloadModel.getAppIcon();
        this.wn = downloadModel.getMimeType();
        this.al = downloadEventConfig.getClickButtonTag();
        this.vy = downloadEventConfig.getRefer();
        this.pa = downloadEventConfig.isEnableV3Event();
        this.on = downloadController.isEnableBackDialog();
        this.o = downloadController.getLinkMode();
        this.lc = downloadController.getDownloadMode();
        this.sa = downloadController.enableShowComplianceDialog();
        this.sr = downloadController.isAutoDownloadOnCardShow();
        this.bv = downloadController.enableNewActivity();
        this.mb = downloadController.enableAH();
        this.ox = downloadController.enableAM();
        this.r = i;
        long currentTimeMillis = System.currentTimeMillis();
        this.g = currentTimeMillis;
        this.ng = currentTimeMillis;
        this.q = downloadModel.shouldDownloadWithPatchApply();
    }

    public static ox ox(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        ox oxVar = new ox();
        try {
            oxVar.hj(com.ss.android.download.api.b.ox.mb(jSONObject, "mId"));
            oxVar.h(com.ss.android.download.api.b.ox.mb(jSONObject, "mExtValue"));
            oxVar.b(jSONObject.optString("mLogExtra"));
            oxVar.h(jSONObject.optInt("mDownloadStatus"));
            oxVar.ox(jSONObject.optString("mPackageName"));
            oxVar.mb(jSONObject.optBoolean("mIsAd", true));
            oxVar.u(com.ss.android.download.api.b.ox.mb(jSONObject, "mTimeStamp"));
            oxVar.u(jSONObject.optInt("mVersionCode"));
            oxVar.hj(jSONObject.optString("mVersionName"));
            oxVar.ko(jSONObject.optInt("mDownloadId"));
            oxVar.ox(jSONObject.optBoolean("mIsV3Event"));
            oxVar.ww(jSONObject.optInt("mScene"));
            oxVar.u(jSONObject.optString("mEventTag"));
            oxVar.ko(jSONObject.optString("mEventRefer"));
            oxVar.ww(jSONObject.optString("mDownloadUrl"));
            oxVar.b(jSONObject.optBoolean("mEnableBackDialog"));
            oxVar.b.set(jSONObject.optBoolean("hasSendInstallFinish"));
            oxVar.hj.set(jSONObject.optBoolean("hasSendDownloadFailedFinally"));
            oxVar.hj(jSONObject.optInt("mLastFailedErrCode"));
            oxVar.mb(jSONObject.optString("mLastFailedErrMsg"));
            oxVar.lz(jSONObject.optString("mOpenUrl"));
            oxVar.x(jSONObject.optInt("mLinkMode"));
            oxVar.jb(jSONObject.optInt("mDownloadMode"));
            oxVar.je(jSONObject.optInt("mModelType"));
            oxVar.x(jSONObject.optString("mAppName"));
            oxVar.jb(jSONObject.optString("mAppIcon"));
            oxVar.mb(jSONObject.optInt("mDownloadFailedTimes", 0));
            oxVar.mb(com.ss.android.download.api.b.ox.mb(jSONObject, "mRecentDownloadResumeTime"));
            oxVar.ox(jSONObject.optInt("mClickPauseTimes"));
            oxVar.ox(com.ss.android.download.api.b.ox.mb(jSONObject, "mJumpInstallTime"));
            oxVar.b(com.ss.android.download.api.b.ox.mb(jSONObject, "mCancelInstallTime"));
            oxVar.b(jSONObject.optInt("mLastFailedResumeCount"));
            oxVar.je(jSONObject.optString("downloadFinishReason"));
            oxVar.lz(jSONObject.optLong("clickDownloadSize"));
            oxVar.ww(jSONObject.optLong("clickDownloadTime"));
            oxVar.ww(jSONObject.optBoolean("mIsUpdateDownload"));
            oxVar.nk(jSONObject.optString("mOriginMimeType"));
            oxVar.lz(jSONObject.optBoolean("mIsPatchApplyHandled"));
            oxVar.u(jSONObject.optBoolean("installAfterCleanSpace"));
            oxVar.lz(jSONObject.optInt("funnelType", 1));
            oxVar.h(jSONObject.optString("webUrl"));
            oxVar.io(jSONObject.optBoolean("enableShowComplianceDialog", true));
            oxVar.e(jSONObject.optBoolean("isAutoDownloadOnCardShow"));
            oxVar.l(jSONObject.optInt("enable_new_activity", 1) == 1);
            oxVar.m(jSONObject.optInt("enable_pause", 1) == 1);
            oxVar.gm(jSONObject.optInt("enable_ah", 1) == 1);
            oxVar.g(jSONObject.optInt("enable_am", 1) == 1);
            oxVar.mb(jSONObject.optJSONObject("mExtras"));
            return oxVar;
        } catch (Exception e) {
            x.m().mb(e, "NativeDownloadModel fromJson");
            return oxVar;
        }
    }

    public int a() {
        return this.f21194a;
    }

    public boolean al() {
        return this.on;
    }

    public void b(int i) {
        this.nf = i;
    }

    public void b(long j) {
        this.xa = j;
    }

    public void b(String str) {
        this.ko = str;
    }

    public void b(boolean z) {
        this.on = z;
    }

    @Override // com.ss.android.downloadad.api.mb.mb
    public boolean b() {
        return this.gm;
    }

    public String bv() {
        return this.e;
    }

    public boolean cd() {
        return this.nq;
    }

    @Override // com.ss.android.downloadad.api.mb.mb
    public DownloadEventConfig df() {
        return y();
    }

    public void e(boolean z) {
        this.sr = z;
    }

    @Override // com.ss.android.downloadad.api.mb.mb
    public boolean e() {
        return this.bv;
    }

    public String ep() {
        return this.ep;
    }

    public boolean fb() {
        return this.s;
    }

    public int fu() {
        return this.fu;
    }

    @Override // com.ss.android.downloadad.api.mb.mb
    public DownloadModel g() {
        return he();
    }

    public void g(boolean z) {
        this.ox = z;
    }

    public long ge() {
        long j = this.ng;
        long j2 = j;
        if (j == 0) {
            j2 = this.g;
        }
        return j2;
    }

    @Override // com.ss.android.downloadad.api.mb.mb
    public int gm() {
        return -1;
    }

    public void gm(boolean z) {
        this.mb = z;
    }

    @Override // com.ss.android.downloadad.api.mb.mb
    public String h() {
        return this.lz;
    }

    public void h(int i) {
        this.ww = i;
    }

    public void h(long j) {
        this.u = j;
    }

    public void h(String str) {
        this.je = str;
    }

    public void h(boolean z) {
        this.n = z;
    }

    public AdDownloadModel he() {
        return new AdDownloadModel.Builder().setAdId(this.h).setExtraValue(this.u).setLogExtra(this.ko).setPackageName(this.lz).setExtra(this.df).setIsAd(this.gm).setVersionCode(this.f21195io).setVersionName(this.e).setDownloadUrl(this.x).setModelType(this.nk).setMimeType(this.wn).setAppName(this.l).setAppIcon(this.m).setDeepLink(new DeepLink(this.jb, this.je, null)).build();
    }

    @Override // com.ss.android.downloadad.api.mb.mb
    public String hj() {
        return this.ko;
    }

    public void hj(int i) {
        this.fu = i;
    }

    public void hj(long j) {
        this.h = j;
    }

    public void hj(String str) {
        this.e = str;
    }

    public void hj(boolean z) {
        this.tl = z;
    }

    public boolean i() {
        return this.n;
    }

    @Override // com.ss.android.downloadad.api.mb.mb
    public JSONObject io() {
        return null;
    }

    public void io(boolean z) {
        this.sa = z;
    }

    @Override // com.ss.android.downloadad.api.mb.mb
    public JSONObject jb() {
        return null;
    }

    public void jb(int i) {
        this.lc = i;
    }

    public void jb(String str) {
        this.m = str;
    }

    public void jb(boolean z) {
        this.nq = z;
    }

    @Override // com.ss.android.downloadad.api.mb.mb
    public long je() {
        return this.u;
    }

    public void je(int i) {
        this.nk = i;
    }

    public void je(String str) {
        this.qa = str;
    }

    public void je(boolean z) {
        this.kg = z;
    }

    public AdDownloadController jm() {
        return new AdDownloadController.Builder().setIsEnableBackDialog(this.on).setLinkMode(this.o).setDownloadMode(this.lc).setEnableShowComplianceDialog(this.sa).setEnableAH(this.mb).setEnableAM(this.ox).build();
    }

    public void jq() {
        synchronized (this) {
            this.jq++;
        }
    }

    public boolean kg() {
        return this.he;
    }

    public boolean kk() {
        return this.km;
    }

    public JSONObject km() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("mId", this.h);
            jSONObject.put("mExtValue", this.u);
            jSONObject.put("mLogExtra", this.ko);
            jSONObject.put("mDownloadStatus", this.ww);
            jSONObject.put("mPackageName", this.lz);
            jSONObject.put("mIsAd", this.gm);
            jSONObject.put("mTimeStamp", this.g);
            jSONObject.put("mExtras", this.df);
            jSONObject.put("mVersionCode", this.f21195io);
            jSONObject.put("mVersionName", this.e);
            jSONObject.put("mDownloadId", this.r);
            jSONObject.put("mIsV3Event", this.pa);
            jSONObject.put("mScene", this.z);
            jSONObject.put("mEventTag", this.al);
            jSONObject.put("mEventRefer", this.vy);
            jSONObject.put("mDownloadUrl", this.x);
            jSONObject.put("mEnableBackDialog", this.on);
            jSONObject.put("hasSendInstallFinish", this.b.get());
            jSONObject.put("hasSendDownloadFailedFinally", this.hj.get());
            jSONObject.put("mLastFailedErrCode", this.fu);
            jSONObject.put("mLastFailedErrMsg", this.ep);
            jSONObject.put("mOpenUrl", this.jb);
            jSONObject.put("mLinkMode", this.o);
            jSONObject.put("mDownloadMode", this.lc);
            jSONObject.put("mModelType", this.nk);
            jSONObject.put("mAppName", this.l);
            jSONObject.put("mAppIcon", this.m);
            jSONObject.put("mDownloadFailedTimes", this.jq);
            jSONObject.put("mRecentDownloadResumeTime", this.ng == 0 ? this.g : this.ng);
            jSONObject.put("mClickPauseTimes", this.f21194a);
            jSONObject.put("mJumpInstallTime", this.ge);
            jSONObject.put("mCancelInstallTime", this.xa);
            jSONObject.put("mLastFailedResumeCount", this.nf);
            jSONObject.put("mIsUpdateDownload", this.sw);
            jSONObject.put("mOriginMimeType", this.wn);
            jSONObject.put("mIsPatchApplyHandled", this.q);
            jSONObject.put("downloadFinishReason", this.qa);
            jSONObject.put("clickDownloadTime", this.ot);
            jSONObject.put("clickDownloadSize", this.fb);
            jSONObject.put("installAfterCleanSpace", this.yr);
            jSONObject.put("funnelType", this.i);
            jSONObject.put("webUrl", this.je);
            jSONObject.put("enableShowComplianceDialog", this.sa);
            jSONObject.put("isAutoDownloadOnCardShow", this.sr);
            jSONObject.put("enable_new_activity", this.bv ? 1 : 0);
            jSONObject.put("enable_pause", this.w ? 1 : 0);
            jSONObject.put("enable_ah", this.mb ? 1 : 0);
            jSONObject.put("enable_am", this.ox ? 1 : 0);
            return jSONObject;
        } catch (Exception e) {
            x.m().mb(e, "NativeDownloadModel toJson");
            return jSONObject;
        }
    }

    @Override // com.ss.android.downloadad.api.mb.mb
    public JSONObject ko() {
        return this.df;
    }

    public void ko(int i) {
        this.r = i;
    }

    public void ko(long j) {
        this.cd = j;
    }

    public void ko(String str) {
        this.vy = str;
    }

    public void ko(boolean z) {
        this.s = z;
    }

    @Override // com.ss.android.downloadad.api.mb.mb
    public JSONObject l() {
        return null;
    }

    public void l(boolean z) {
        this.bv = z;
    }

    @Override // com.ss.android.downloadad.api.mb.mb
    public Object lc() {
        return null;
    }

    public void lc(boolean z) {
        this.he = z;
    }

    @Override // com.ss.android.downloadad.api.mb.mb
    public String lz() {
        return this.vy;
    }

    public void lz(int i) {
        this.i = i;
    }

    public void lz(long j) {
        this.fb = j;
    }

    public void lz(String str) {
        this.jb = str;
    }

    public void lz(boolean z) {
        this.q = z;
    }

    @Override // com.ss.android.downloadad.api.mb.mb
    public int m() {
        return this.r;
    }

    public void m(boolean z) {
        this.w = z;
    }

    @Override // com.ss.android.downloadad.api.mb.mb
    public String mb() {
        return this.x;
    }

    public void mb(int i) {
        this.jq = i;
    }

    public void mb(long j) {
        this.ng = j;
    }

    public void mb(String str) {
        this.ep = str;
    }

    public void mb(JSONObject jSONObject) {
        this.df = jSONObject;
    }

    public void mb(boolean z) {
        this.gm = z;
    }

    public boolean n() {
        return this.q;
    }

    public int nf() {
        return this.nf;
    }

    public void ng() {
        synchronized (this) {
            this.f21194a++;
        }
    }

    public void nk(String str) {
        this.wn = str;
    }

    public void nk(boolean z) {
        this.kk = z;
    }

    @Override // com.ss.android.downloadad.api.mb.mb
    public boolean nk() {
        return this.pa;
    }

    public boolean nq() {
        return this.kk;
    }

    @Override // com.ss.android.downloadad.api.mb.mb
    public List<String> o() {
        return null;
    }

    public void o(boolean z) {
        this.km = z;
    }

    public int on() {
        return this.jq;
    }

    public boolean ot() {
        return this.yr;
    }

    @Override // com.ss.android.downloadad.api.mb.mb
    public long ox() {
        return this.h;
    }

    public void ox(int i) {
        this.f21194a = i;
    }

    public void ox(long j) {
        this.ge = j;
    }

    public void ox(String str) {
        this.lz = str;
    }

    public void ox(boolean z) {
        this.pa = z;
    }

    public String pa() {
        return this.l;
    }

    public int q() {
        return this.f21195io;
    }

    public boolean qa() {
        return this.sw;
    }

    @Override // com.ss.android.downloadad.api.mb.mb
    public DownloadController r() {
        return jm();
    }

    public boolean s() {
        return this.up;
    }

    public long sa() {
        return this.ot;
    }

    public long sr() {
        return this.fb;
    }

    public int sw() {
        return this.ww;
    }

    public String tl() {
        return this.wn;
    }

    @Override // com.ss.android.downloadad.api.mb.mb
    public String u() {
        return this.jb;
    }

    public void u(int i) {
        this.f21195io = i;
    }

    public void u(long j) {
        if (j > 0) {
            this.g = j;
        }
    }

    public void u(String str) {
        this.al = str;
    }

    public void u(boolean z) {
        this.yr = z;
    }

    public boolean up() {
        return this.kg;
    }

    public long vy() {
        return this.cd;
    }

    public int w() {
        return this.z;
    }

    public long wn() {
        return this.g;
    }

    @Override // com.ss.android.downloadad.api.mb.mb
    public int ww() {
        return this.i;
    }

    public void ww(int i) {
        this.z = i;
    }

    public void ww(long j) {
        this.ot = j;
    }

    public void ww(String str) {
        this.x = str;
    }

    public void ww(boolean z) {
        this.sw = z;
    }

    @Override // com.ss.android.downloadad.api.mb.mb
    public String x() {
        return this.al;
    }

    public void x(int i) {
        this.o = i;
    }

    public void x(String str) {
        this.l = str;
    }

    public void x(boolean z) {
        this.up = z;
    }

    public long xa() {
        return this.ge;
    }

    public AdDownloadEventConfig y() {
        return new AdDownloadEventConfig.Builder().setClickButtonTag(this.al).setRefer(this.vy).setIsEnableV3Event(this.pa).build();
    }

    public int yr() {
        return this.o;
    }

    public String z() {
        return this.qa;
    }
}
