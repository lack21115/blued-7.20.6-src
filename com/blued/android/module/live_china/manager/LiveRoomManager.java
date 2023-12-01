package com.blued.android.module.live_china.manager;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.blued.android.chat.data.ProfileData;
import com.blued.android.core.AppInfo;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.module.common.utils.ReflectionUtils;
import com.blued.android.module.live.base.manager.LiveDataManager;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.model.FirstChargeGift;
import com.blued.android.module.live_china.model.LiveActivityItemModel;
import com.blued.android.module.live_china.model.LiveBubbleBgModel;
import com.blued.android.module.live_china.model.LiveChattingModel;
import com.blued.android.module.live_china.model.LiveFansInfoModel;
import com.blued.android.module.live_china.model.LiveGiftModel;
import com.blued.android.module.live_china.model.LiveJoinRoomExtraModel;
import com.blued.android.module.live_china.model.LiveLiangModel;
import com.blued.android.module.live_china.model.LiveNobleModel;
import com.blued.android.module.live_china.model.LivePopItemModel;
import com.blued.android.module.live_china.model.LiveRoomData;
import com.blued.android.module.live_china.model.LiveRoomExtra;
import com.blued.android.module.live_china.model.LiveRoomFunctionModel;
import com.blued.android.module.live_china.model.LiveRoomViewerModel;
import com.blued.android.module.live_china.model.LiveSettingModel;
import com.blued.android.module.live_china.model.LiveZanExtraModel;
import com.blued.android.module.live_china.model.MultiDialogModel;
import com.blued.android.module.live_china.model.MuteLiveAudioModel;
import com.blued.android.module.live_china.model.ReChargeGift;
import com.blued.android.module.live_china.msg.LiveEventBusUtil;
import com.blued.android.module.live_china.observer.LiveRefreshUIObserver;
import com.blued.android.module.live_china.observer.LiveSetDataObserver;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.blued.android.module.live_china.utils.LiveRoomPreferences;
import com.jeremyliao.liveeventbus.LiveEventBus;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/manager/LiveRoomManager.class */
public class LiveRoomManager {
    private static List<LiveGiftModel> M;
    private static volatile LiveRoomManager e;

    /* renamed from: a  reason: collision with root package name */
    public LiveRoomData f13670a;
    public LiveJoinRoomExtraModel d;
    private LiveFansInfoModel h;
    private LiveLiangModel i;
    private MultiDialogModel j;
    private int l;
    private int p;
    private int u;
    private FirstChargeGift v;
    private ReChargeGift w;
    private LiveBubbleBgModel y;
    private final LiveRoomData f = new LiveRoomData();
    private final LiveRoomExtra g = new LiveRoomExtra();
    private short k = 4;
    private List<String> m = new ArrayList();
    private final List<ProfileData> n = new ArrayList();
    private final List<ProfileData> o = new ArrayList();
    private final List<LiveChattingModel> q = new ArrayList();
    private final List<LiveChattingModel> r = new ArrayList();
    private final List<LiveChattingModel> s = new ArrayList();
    private boolean t = false;
    private boolean x = false;
    private LiveNobleModel z = new LiveNobleModel();
    private boolean A = false;
    private final List<LiveRoomData> B = new ArrayList();
    private final List<MuteLiveAudioModel> C = new ArrayList();
    private final List<LiveRoomFunctionModel> D = new ArrayList();
    private final List<LiveRoomFunctionModel> E = new ArrayList();
    private final List<LivePopItemModel> F = new ArrayList();
    private LiveZanExtraModel G = null;
    private boolean H = true;
    private boolean I = true;
    private boolean J = true;
    private String K = null;
    public int b = 0;

    /* renamed from: c  reason: collision with root package name */
    public int f13671c = 0;
    private Handler L = new Handler(Looper.getMainLooper()) { // from class: com.blued.android.module.live_china.manager.LiveRoomManager.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (LiveRoomManager.this.r.size() != 0) {
                LiveRoomManager.this.ab();
            } else if (LiveRoomManager.this.d() != 0) {
                LiveRefreshUIObserver.a().u();
                LiveRoomManager liveRoomManager = LiveRoomManager.this;
                liveRoomManager.a(liveRoomManager.d());
            }
        }
    };

    private LiveRoomManager() {
    }

    public static LiveRoomManager a() {
        synchronized (LiveRoomManager.class) {
            try {
                if (e == null) {
                    e = new LiveRoomManager();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return e;
    }

    public static void a(String str, BluedUIHttpResponse bluedUIHttpResponse, String str2, String str3, IRequestHost iRequestHost) {
        if ("3".equals(str) || "1".equals(str)) {
            LiveRoomHttpUtils.e(bluedUIHttpResponse, str2, str3, iRequestHost);
        } else {
            LiveRoomHttpUtils.d(bluedUIHttpResponse, str2, str3, iRequestHost);
        }
    }

    private void aa() {
        C();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ab() {
        LiveChattingModel B = B();
        if (B == null) {
            C();
            return;
        }
        if (B.msgMapExtra == null) {
            B.msgMapExtra = new HashMap();
        }
        B.msgMapExtra.put("is_history_data", 1);
        a(true);
        LiveEventBusUtil.a(B);
        C();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(MuteLiveAudioModel muteLiveAudioModel, String str) {
        LiveSetDataObserver.a().a(muteLiveAudioModel, str);
    }

    public boolean A() {
        return this.t;
    }

    public LiveChattingModel B() {
        if (this.r.size() > 0) {
            return this.r.remove(0);
        }
        return null;
    }

    public void C() {
        Handler handler = this.L;
        if (handler != null) {
            handler.sendEmptyMessageDelayed(1, 500L);
        }
    }

    public FirstChargeGift D() {
        return this.v;
    }

    public ReChargeGift E() {
        return this.w;
    }

    public boolean F() {
        return this.H;
    }

    public boolean G() {
        return this.I;
    }

    public boolean H() {
        return this.J;
    }

    public int I() {
        return this.u;
    }

    public boolean J() {
        return this.u == 1;
    }

    public boolean K() {
        return this.x;
    }

    public List<LiveGiftModel> L() {
        if (M == null) {
            M = new ArrayList();
        }
        return M;
    }

    public LiveBubbleBgModel M() {
        return this.y;
    }

    public LiveNobleModel N() {
        if (this.z == null) {
            this.z = new LiveNobleModel();
        }
        return this.z;
    }

    public String O() {
        return this.K;
    }

    public void P() {
        this.C.clear();
    }

    public boolean Q() {
        return this.f.layout_setting == null || this.f.layout_setting.live_list_hot == 1;
    }

    public boolean R() {
        boolean z = true;
        if (this.f.layout_setting == null) {
            return true;
        }
        LogUtils.c("layout_setting:" + AppInfo.f().toJson(this.f.layout_setting) + ", isShowHourRank:" + a().p().isShowHourRank);
        if (this.f.layout_setting.fans_consume_list == 1) {
            if (!S()) {
                if (T()) {
                    return true;
                }
            }
            return z;
        }
        z = false;
        return z;
    }

    public boolean S() {
        return this.f.layout_setting == null || this.f.layout_setting.fans_consume_tab_live == 1;
    }

    public boolean T() {
        return this.f.layout_setting == null || this.f.layout_setting.fans_consume_tabs_month == 1;
    }

    public boolean U() {
        return this.f.layout_setting == null || this.f.layout_setting.fans_list_tab == 1;
    }

    public boolean V() {
        return this.f.layout_setting == null || this.f.layout_setting.pk_help_list == 1;
    }

    public boolean W() {
        return this.f.layout_setting == null || this.f.layout_setting.anchor_made_list == 1;
    }

    public String X() {
        return (this.f.layout_setting == null || TextUtils.isEmpty(this.f.layout_setting.pk_failed_text)) ? AppInfo.d().getResources().getString(R.string.live_pk_punish_time) : this.f.layout_setting.pk_failed_text;
    }

    public boolean Y() {
        boolean z = false;
        boolean z2 = false;
        if (this.f.red_point != null) {
            Log.i("==opop", "value:" + this.f.red_point.toString());
            Iterator<String> it = this.f.red_point.keySet().iterator();
            while (true) {
                z = z2;
                if (!it.hasNext()) {
                    break;
                }
                String next = it.next();
                if (!TextUtils.isEmpty(next)) {
                    long a2 = StringUtils.a(this.f.red_point.get(next), 0L);
                    Log.i("==opop", next + " time:" + a2);
                    long a3 = StringUtils.a(LiveRoomPreferences.B(next), 0L);
                    Log.i("==opop", next + " curTime:" + a3);
                    if (a2 > a3) {
                        z2 = true;
                    }
                }
            }
        }
        return z;
    }

    public LiveZanExtraModel Z() {
        return this.G;
    }

    public int a(LiveActivityItemModel liveActivityItemModel) {
        int i;
        int i2 = -1;
        if (liveActivityItemModel != null) {
            Log.i("==xpmm", "id:" + liveActivityItemModel.id + "  state:" + liveActivityItemModel.status);
            if (this.f.activity == null) {
                this.f.activity = new ArrayList();
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.f.activity);
            if (liveActivityItemModel.status == 0) {
                int i3 = 0;
                while (true) {
                    i2 = i3;
                    i = -1;
                    if (i2 >= arrayList.size()) {
                        break;
                    }
                    LiveActivityItemModel liveActivityItemModel2 = (LiveActivityItemModel) arrayList.get(i2);
                    if (liveActivityItemModel2 == null || liveActivityItemModel2.id == 0 || liveActivityItemModel2.id != liveActivityItemModel.id) {
                        i3 = i2 + 1;
                    } else if (liveActivityItemModel2.isIcon() || liveActivityItemModel2.displayUrlsEqual(liveActivityItemModel)) {
                        i = i2;
                    } else {
                        i = i2;
                    }
                }
                i2 = -1;
                if (i >= 0) {
                    arrayList.set(i, liveActivityItemModel);
                } else {
                    arrayList.add(liveActivityItemModel);
                }
            } else {
                i2 = -1;
                if (liveActivityItemModel.status == 1) {
                    Iterator<E> it = arrayList.iterator();
                    while (true) {
                        i2 = -1;
                        if (!it.hasNext()) {
                            break;
                        }
                        LiveActivityItemModel liveActivityItemModel3 = (LiveActivityItemModel) it.next();
                        if (liveActivityItemModel3 != null && liveActivityItemModel3.id != 0 && liveActivityItemModel3.id == liveActivityItemModel.id) {
                            it.remove();
                        }
                    }
                }
            }
            Collections.sort(arrayList);
            this.f.activity.clear();
            this.f.activity.addAll(arrayList);
        }
        return i2;
    }

    public List<LiveRoomData> a(String str) {
        for (LiveRoomData liveRoomData : this.B) {
            liveRoomData.comeCode = str;
        }
        return this.B;
    }

    public void a(double d) {
        if (d >= 0.0d) {
            this.f.beans_count = d;
        }
    }

    public void a(double d, double d2) {
        a(d);
        b(d2);
        LiveEventBusUtil.a();
    }

    public void a(int i) {
        this.l = i;
    }

    public void a(long j) {
        if (j == d()) {
            a(false);
            if (this.s.size() != 0) {
                for (LiveChattingModel liveChattingModel : this.s) {
                    LiveEventBusUtil.a(liveChattingModel);
                }
            }
        }
    }

    public void a(long j, int i) {
        Iterator<ProfileData> it = this.o.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            ProfileData next = it.next();
            if (next == null) {
                it.remove();
            } else if (next.uid == j) {
                it.remove();
                break;
            }
        }
        this.p = i;
        LiveSetDataObserver.a().q();
        LiveSetDataObserver.a().r();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    public void a(long j, List<LiveRoomViewerModel> list, int i) {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    public void a(ProfileData profileData, int i) {
        if (profileData == null) {
            return;
        }
        Iterator<ProfileData> it = this.o.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            ProfileData next = it.next();
            if (next == null) {
                it.remove();
            } else if (next.uid == profileData.uid) {
                it.remove();
                break;
            }
        }
        this.o.add(0, profileData);
        this.p = i;
        LiveSetDataObserver.a().q();
        LiveSetDataObserver.a().r();
    }

    public void a(FirstChargeGift firstChargeGift) {
        this.v = firstChargeGift;
    }

    public void a(LiveBubbleBgModel liveBubbleBgModel) {
        this.y = liveBubbleBgModel;
    }

    public void a(LiveChattingModel liveChattingModel) {
        if (this.q.size() > 110) {
            int i = 9;
            while (true) {
                int i2 = i;
                if (i2 < 0) {
                    break;
                }
                this.q.remove(i2);
                i = i2 - 1;
            }
        }
        this.q.add(liveChattingModel);
    }

    public void a(LiveFansInfoModel liveFansInfoModel) {
        this.h = liveFansInfoModel;
    }

    public void a(LiveLiangModel liveLiangModel) {
        this.i = liveLiangModel;
    }

    public void a(LiveNobleModel liveNobleModel) {
        this.z.copyModel(liveNobleModel);
    }

    public void a(LiveRoomData liveRoomData) {
        if (liveRoomData != null) {
            LogUtils.c("setLiveRoomData roomId: " + liveRoomData.lid);
            liveRoomData.isShowHourRank = this.f.isShowHourRank;
            liveRoomData.rechargeGiftBagIconShowType = this.f.rechargeGiftBagIconShowType;
            this.f.copyModel(liveRoomData);
            LiveLiangModel liveLiangModel = new LiveLiangModel();
            this.i = liveLiangModel;
            liveLiangModel.liang_type = liveRoomData.liang_type;
            this.i.liang_id = liveRoomData.liang_id;
            LiveDataManager.a().a(liveRoomData.lid);
        }
    }

    public void a(LiveRoomExtra liveRoomExtra) {
        ReflectionUtils.a(liveRoomExtra, this.g);
    }

    public void a(LiveZanExtraModel liveZanExtraModel) {
        this.G = liveZanExtraModel;
    }

    public void a(MultiDialogModel multiDialogModel) {
        this.j = multiDialogModel;
    }

    public void a(final MuteLiveAudioModel muteLiveAudioModel, final String str) {
        if (muteLiveAudioModel == null || muteLiveAudioModel.isEmpty()) {
            return;
        }
        if (this.f.link_type == 7) {
            AppInfo.n().post(new Runnable() { // from class: com.blued.android.module.live_china.manager.-$$Lambda$LiveRoomManager$Ipm7xgUvjmLoWxKs7uguKB9Qw3Q
                @Override // java.lang.Runnable
                public final void run() {
                    LiveRoomManager.b(MuteLiveAudioModel.this, str);
                }
            });
            return;
        }
        int i = 0;
        int i2 = -1;
        while (i < this.C.size()) {
            MuteLiveAudioModel muteLiveAudioModel2 = this.C.get(i);
            int i3 = i;
            if (muteLiveAudioModel.equals(muteLiveAudioModel2)) {
                i2 = muteLiveAudioModel2.target_status;
                if (TextUtils.isEmpty(muteLiveAudioModel.stream) && !TextUtils.isEmpty(muteLiveAudioModel2.stream)) {
                    muteLiveAudioModel.stream = muteLiveAudioModel2.stream;
                }
                this.C.remove(i);
                i3 = i - 1;
            }
            i = i3 + 1;
        }
        if (i2 != -1 || i2 != muteLiveAudioModel.target_status) {
            LiveSetDataObserver.a().a(muteLiveAudioModel, "");
        }
        this.C.add(muteLiveAudioModel);
    }

    public void a(ReChargeGift reChargeGift, boolean z) {
        this.w = reChargeGift;
    }

    public void a(List<String> list) {
        this.m.clear();
        this.m.addAll(list);
    }

    public void a(boolean z) {
        this.t = z;
    }

    public void a(boolean z, List<LiveRoomFunctionModel> list) {
        if (list != null) {
            if (z) {
                this.E.clear();
                this.E.addAll(list);
                return;
            }
            this.D.clear();
            this.D.addAll(list);
        }
    }

    public String b() {
        return this.g.live_submitted_uid;
    }

    public void b(double d) {
        if (d > this.f.beans_current_count) {
            this.f.beans_current_count = d;
        }
    }

    public void b(int i) {
        this.u = i;
    }

    public void b(LiveChattingModel liveChattingModel) {
        this.s.add(liveChattingModel);
    }

    public void b(LiveRoomData liveRoomData) {
        if (liveRoomData == null) {
            this.f13670a = null;
            return;
        }
        LiveRoomData liveRoomData2 = new LiveRoomData();
        this.f13670a = liveRoomData2;
        ReflectionUtils.a(liveRoomData, liveRoomData2);
    }

    public void b(String str) {
        this.K = str;
    }

    public void b(List<ProfileData> list) {
        this.n.clear();
        if (list != null) {
            this.n.addAll(list);
        }
    }

    public void b(boolean z) {
        this.J = z;
    }

    public String c() {
        return this.g.live_submitted_room_id;
    }

    public void c(List<LiveChattingModel> list) {
        if (list == null) {
            return;
        }
        this.r.clear();
        this.r.addAll(list);
        aa();
    }

    public void c(boolean z) {
        this.x = z;
    }

    public long d() {
        return this.f.lid;
    }

    public List<LiveRoomFunctionModel> d(boolean z) {
        return z ? this.E : this.D;
    }

    public void d(List<LiveSettingModel> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        for (LiveSettingModel liveSettingModel : list) {
            int i = liveSettingModel.privilege_type;
            if (i == 3) {
                boolean z = liveSettingModel.privilege_status == 1;
                this.H = z;
                if (z && LiveRoomPreferences.M() == 2) {
                    LiveEventBus.get(LiveEventBusUtil.v).post(true);
                }
            } else if (i == 4) {
                this.I = liveSettingModel.privilege_status == 1;
            } else if (i == 5) {
                LiveDataManager.a().b(liveSettingModel.privilege_status == 1);
            } else if (i == 6) {
                LiveDataManager.a().c(liveSettingModel.privilege_status == 1);
            }
        }
    }

    public String e() {
        return String.valueOf(this.f.lid);
    }

    public void e(List<LiveGiftModel> list) {
        if (M == null) {
            M = new ArrayList();
        }
        M.clear();
        if (list != null) {
            M.addAll(list);
        }
    }

    public long f() {
        if (this.f.profile != null) {
            return this.f.profile.getUid();
        }
        return 0L;
    }

    public void f(List<LiveRoomData> list) {
        this.B.clear();
        if (list != null) {
            this.B.addAll(list);
        }
    }

    public String g() {
        return this.f.profile != null ? this.f.profile.uid : "";
    }

    public void g(List<LivePopItemModel> list) {
        synchronized (this.F) {
            this.F.clear();
            this.F.addAll(list);
        }
    }

    public String h() {
        return this.f.profile != null ? this.f.profile.name : "";
    }

    public String i() {
        return this.f.profile != null ? this.f.profile.avatar : "";
    }

    public short j() {
        return this.k;
    }

    public boolean k() {
        return this.f.lid <= 0 || this.f.profile == null || this.f.profile.getUid() <= 0;
    }

    public boolean l() {
        return (k() || TextUtils.isEmpty(this.f.live_url)) ? false : true;
    }

    public int m() {
        return this.l;
    }

    public List<String> n() {
        return this.m;
    }

    public void o() {
        this.f.reset();
        this.k = (short) 4;
        this.l = 0;
        this.n.clear();
        this.o.clear();
        this.C.clear();
        this.u = 0;
        this.A = false;
        LiveDataManager.a().b();
        z();
        this.K = null;
        this.G = null;
    }

    public LiveRoomData p() {
        return this.f;
    }

    public LiveFansInfoModel q() {
        return this.h;
    }

    public LiveLiangModel r() {
        return this.i;
    }

    public boolean s() {
        return this.f.level >= 5;
    }

    public boolean t() {
        return this.f.profile == null || this.f.profile.getUid() <= 0;
    }

    public double u() {
        return this.f.beans_count;
    }

    public int v() {
        return this.p;
    }

    public List<ProfileData> w() {
        return this.o;
    }

    public List<ProfileData> x() {
        return this.n;
    }

    public LiveRoomData y() {
        return this.f13670a;
    }

    public void z() {
        this.L.removeCallbacksAndMessages(null);
        this.q.clear();
        this.s.clear();
        this.r.clear();
        a(false);
    }
}
