package com.ss.android.socialbase.appdownloader;

import android.app.Activity;
import android.content.Context;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.ss.android.socialbase.downloader.constants.EnqueueType;
import com.ss.android.socialbase.downloader.depend.IDownloadCompleteHandler;
import com.ss.android.socialbase.downloader.depend.IDownloadDepend;
import com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceHandler;
import com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.IDownloadMonitorDepend;
import com.ss.android.socialbase.downloader.depend.INotificationClickCallback;
import com.ss.android.socialbase.downloader.downloader.IChunkAdjustCalculator;
import com.ss.android.socialbase.downloader.downloader.IChunkCntCalculator;
import com.ss.android.socialbase.downloader.downloader.IRetryDelayTimeCalculator;
import com.ss.android.socialbase.downloader.model.HttpHeader;
import com.ss.android.socialbase.downloader.notification.AbsNotificationItem;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/socialbase/appdownloader/u.class */
public class u {

    /* renamed from: a  reason: collision with root package name */
    private long f34890a;
    private int al;
    private String b;
    private long cd;
    private boolean df;
    private boolean e;
    private boolean fb;
    private String fu;
    private AbsNotificationItem g;
    private IRetryDelayTimeCalculator gm;
    private String h;
    private int[] he;
    private List<String> hj;
    private IDownloadFileUriProvider i;
    private String jq;
    private String km;
    private String ko;
    private IChunkAdjustCalculator l;
    private String lc;
    private IChunkCntCalculator m;
    private Activity mb;
    private boolean nf;
    private boolean ng;
    private IDownloadListener nk;
    private boolean nq;
    private IDownloadListener o;
    private String on;
    private IDownloadDiskSpaceHandler ot;
    private Context ox;
    private IDownloadMonitorDepend pa;
    private boolean q;
    private JSONObject qa;
    private boolean r;
    private int s;
    private INotificationClickCallback sa;
    private boolean sr;
    private boolean sw;
    private String tl;
    private String u;
    private int up;
    private boolean wn;
    private List<HttpHeader> ww;
    private int xa;
    private IDownloadDepend yr;
    private com.ss.android.socialbase.appdownloader.b.h z;
    private boolean lz = true;
    private boolean x = false;
    private boolean jb = true;
    private boolean je = false;

    /* renamed from: io  reason: collision with root package name */
    private String f34891io = AdBaseConstants.MIME_APK;
    private int ge = 5;
    private boolean ep = true;
    private EnqueueType bv = EnqueueType.ENQUEUE_NONE;
    private int w = 150;
    private boolean vy = true;
    private List<IDownloadCompleteHandler> n = new ArrayList();
    private boolean kk = true;
    private boolean kg = true;

    public u(Context context, String str) {
        this.ox = context.getApplicationContext();
        this.b = str;
    }

    public String a() {
        return this.fu;
    }

    public String al() {
        return this.u;
    }

    public u b(int i) {
        this.xa = i;
        return this;
    }

    public u b(String str) {
        this.ko = str;
        return this;
    }

    public u b(boolean z) {
        this.je = z;
        return this;
    }

    public String b() {
        return this.ko;
    }

    public EnqueueType bv() {
        return this.bv;
    }

    public boolean cd() {
        return this.kk;
    }

    public long df() {
        return this.f34890a;
    }

    public boolean e() {
        return this.df;
    }

    public boolean ep() {
        return this.wn;
    }

    public boolean fb() {
        return this.sr;
    }

    public int fu() {
        return this.al;
    }

    public String g() {
        return this.jq;
    }

    public boolean ge() {
        return this.sw;
    }

    public Activity getActivity() {
        return this.mb;
    }

    public Context getContext() {
        return this.ox;
    }

    public String gm() {
        return this.on;
    }

    public u h(int i) {
        this.al = i;
        return this;
    }

    public u h(String str) {
        this.f34891io = str;
        return this;
    }

    public u h(boolean z) {
        this.df = z;
        return this;
    }

    public boolean h() {
        return this.lz;
    }

    public u hj(int i) {
        this.w = i;
        return this;
    }

    public u hj(String str) {
        this.lc = str;
        return this;
    }

    public u hj(boolean z) {
        this.e = z;
        return this;
    }

    public List<HttpHeader> hj() {
        return this.ww;
    }

    public INotificationClickCallback i() {
        return this.sa;
    }

    public u io(boolean z) {
        this.kk = z;
        return this;
    }

    public IChunkAdjustCalculator io() {
        return this.l;
    }

    public u jb(boolean z) {
        this.wn = z;
        return this;
    }

    public String jb() {
        return this.lc;
    }

    public u je(boolean z) {
        this.q = z;
        return this;
    }

    public String je() {
        return this.f34891io;
    }

    public boolean jq() {
        return this.nf;
    }

    public JSONObject kg() {
        return this.qa;
    }

    public IDownloadDiskSpaceHandler kk() {
        return this.ot;
    }

    public u ko(String str) {
        this.jq = str;
        return this;
    }

    public u ko(boolean z) {
        this.nf = z;
        return this;
    }

    public boolean ko() {
        return this.jb;
    }

    public boolean l() {
        return this.r;
    }

    public u lc(boolean z) {
        this.nq = z;
        return this;
    }

    public IChunkCntCalculator lc() {
        return this.m;
    }

    public u lz(String str) {
        this.km = str;
        return this;
    }

    public u lz(boolean z) {
        this.ep = z;
        return this;
    }

    public IDownloadListener lz() {
        return this.nk;
    }

    public int m() {
        return this.up;
    }

    public u mb(long j) {
        this.f34890a = j;
        return this;
    }

    public u mb(EnqueueType enqueueType) {
        this.bv = enqueueType;
        return this;
    }

    public u mb(IDownloadCompleteHandler iDownloadCompleteHandler) {
        synchronized (this.n) {
            if (iDownloadCompleteHandler != null) {
                if (!this.n.contains(iDownloadCompleteHandler)) {
                    this.n.add(iDownloadCompleteHandler);
                    return this;
                }
            }
            return this;
        }
    }

    public u mb(IDownloadDiskSpaceHandler iDownloadDiskSpaceHandler) {
        this.ot = iDownloadDiskSpaceHandler;
        return this;
    }

    public u mb(IDownloadFileUriProvider iDownloadFileUriProvider) {
        this.i = iDownloadFileUriProvider;
        return this;
    }

    public u mb(IDownloadListener iDownloadListener) {
        this.nk = iDownloadListener;
        return this;
    }

    public u mb(String str) {
        this.h = str;
        return this;
    }

    public u mb(List<HttpHeader> list) {
        this.ww = list;
        return this;
    }

    public u mb(JSONObject jSONObject) {
        this.qa = jSONObject;
        return this;
    }

    public u mb(boolean z) {
        this.lz = z;
        return this;
    }

    public String mb() {
        return this.b;
    }

    public void mb(int i) {
        this.up = i;
    }

    public int[] n() {
        return this.he;
    }

    public int nf() {
        return this.w;
    }

    public boolean ng() {
        return this.ep;
    }

    public u nk(boolean z) {
        this.vy = z;
        return this;
    }

    public boolean nk() {
        return this.e;
    }

    public List<String> nq() {
        return this.hj;
    }

    public u o(boolean z) {
        this.ng = z;
        return this;
    }

    public AbsNotificationItem o() {
        return this.g;
    }

    public int on() {
        return this.xa;
    }

    public List<IDownloadCompleteHandler> ot() {
        return this.n;
    }

    public u ox(int i) {
        this.ge = i;
        return this;
    }

    public u ox(String str) {
        this.u = str;
        return this;
    }

    public u ox(List<String> list) {
        this.hj = list;
        return this;
    }

    public u ox(boolean z) {
        this.x = z;
        return this;
    }

    public String ox() {
        return this.h;
    }

    public IDownloadDepend pa() {
        return this.yr;
    }

    public boolean q() {
        return this.fb;
    }

    public boolean qa() {
        return this.kg;
    }

    public int r() {
        return this.ge;
    }

    public boolean s() {
        return this.nq;
    }

    public int sa() {
        return this.s;
    }

    public long sr() {
        return this.cd;
    }

    public boolean sw() {
        return this.q;
    }

    public String tl() {
        return this.km;
    }

    public u u(int i) {
        this.s = i;
        return this;
    }

    public u u(String str) {
        this.on = str;
        return this;
    }

    public u u(boolean z) {
        this.r = z;
        return this;
    }

    public boolean u() {
        return this.x;
    }

    public String up() {
        return this.tl;
    }

    public IDownloadMonitorDepend vy() {
        return this.pa;
    }

    public boolean w() {
        return this.ng;
    }

    public boolean wn() {
        return this.vy;
    }

    public u ww(String str) {
        this.fu = str;
        return this;
    }

    public u ww(boolean z) {
        this.fb = z;
        return this;
    }

    public boolean ww() {
        return this.je;
    }

    public u x(String str) {
        this.tl = str;
        return this;
    }

    public u x(boolean z) {
        this.sw = z;
        return this;
    }

    public IDownloadListener x() {
        return this.o;
    }

    public IRetryDelayTimeCalculator xa() {
        return this.gm;
    }

    public com.ss.android.socialbase.appdownloader.b.h yr() {
        return this.z;
    }

    public IDownloadFileUriProvider z() {
        return this.i;
    }
}
