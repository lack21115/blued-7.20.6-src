package com.blued.android.module.live_china.liveForMsg;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import com.anythink.core.common.g.g;
import com.blued.android.core.AppInfo;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.module.common.utils.freedom.FreedomAdapter;
import com.blued.android.module.live_china.fitem.msgcontent.FitemMsgBase;
import com.blued.android.module.live_china.fitem.msgcontent.FitemMsgChickenWin;
import com.blued.android.module.live_china.fitem.msgcontent.FitemMsgDefault;
import com.blued.android.module.live_china.fitem.msgcontent.FitemMsgGetWelfare;
import com.blued.android.module.live_china.fitem.msgcontent.FitemMsgGift;
import com.blued.android.module.live_china.fitem.msgcontent.FitemMsgGuide;
import com.blued.android.module.live_china.fitem.msgcontent.FitemMsgGuideMarketingCampaignNotice;
import com.blued.android.module.live_china.fitem.msgcontent.FitemMsgGuideOfficialSafetyNotice;
import com.blued.android.module.live_china.fitem.msgcontent.FitemMsgNobleUpgrade;
import com.blued.android.module.live_china.fitem.msgcontent.FitemMsgPKDaredEgg;
import com.blued.android.module.live_china.fitem.msgcontent.FitemMsgPromotion;
import com.blued.android.module.live_china.fitem.msgcontent.FitemMsgRemind;
import com.blued.android.module.live_china.fitem.msgcontent.FitemMsgText;
import com.blued.android.module.live_china.fitem.msgcontent.FitemMsgTextBattlePass;
import com.blued.android.module.live_china.fitem.msgcontent.FitemMsgTextCommon;
import com.blued.android.module.live_china.fitem.msgcontent.FitemMsgTextConstellation;
import com.blued.android.module.live_china.fitem.msgcontent.FitemMsgTextNotification;
import com.blued.android.module.live_china.fitem.msgcontent.FitemMsgTextPlanet;
import com.blued.android.module.live_china.fitem.msgcontent.FitemMsgTextWishing;
import com.blued.android.module.live_china.liveForMsg.ui.MsgItemAnimator;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.manager.LiveFloatManager;
import com.blued.android.module.live_china.model.LiveChattingModel;
import com.blued.android.module.live_china.model.LiveGuideType;
import com.blued.android.module.live_china.view.LiveMsgLayoutManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/liveForMsg/LiveMsgContentManager.class */
public final class LiveMsgContentManager {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f13470a = new Companion(null);
    public static int b = -1;
    private long g;
    private long h;
    private boolean i;
    private Runnable j;
    private boolean k;
    private Context l;
    private BaseFragment m;
    private IRequestHost n;
    private RecyclerView o;
    private LiveMsgLayoutManager p;
    private FreedomAdapter q;
    private Timer u;
    private boolean v;

    /* renamed from: c  reason: collision with root package name */
    private final int f13471c = 150;
    private final int d = 15;
    private final int e = 35;
    private final long f = 60;
    private final MsgItemAnimator r = new MsgItemAnimator();
    private final ArrayList<FitemMsgBase> s = new ArrayList<>();
    private final ArrayList<Runnable> t = new ArrayList<>();

    @Metadata
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/liveForMsg/LiveMsgContentManager$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean a(LiveChattingModel msg) {
            Intrinsics.e(msg, "msg");
            if (msg.msgType == 1 && msg.msgMapExtra != null && msg.msgMapExtra.containsKey("TRANSITION_MSG_TAG") && msg.msgMapExtra.get("TRANSITION_MSG_TAG") != null && (msg.msgMapExtra.get("TRANSITION_MSG_TAG") instanceof Boolean)) {
                Object obj = msg.msgMapExtra.get("TRANSITION_MSG_TAG");
                if (obj != null) {
                    return ((Boolean) obj).booleanValue();
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(int i, LiveMsgContentManager this$0) {
        Intrinsics.e(this$0, "this$0");
        if (i < 0 || i >= this$0.s.size()) {
            return;
        }
        this$0.s.remove(i);
        if (i >= 0) {
            FreedomAdapter freedomAdapter = this$0.q;
            FreedomAdapter freedomAdapter2 = freedomAdapter;
            if (freedomAdapter == null) {
                Intrinsics.c("adapter");
                freedomAdapter2 = null;
            }
            if (i <= freedomAdapter2.getItemCount()) {
                FreedomAdapter freedomAdapter3 = this$0.q;
                if (freedomAdapter3 == null) {
                    Intrinsics.c("adapter");
                    freedomAdapter3 = null;
                }
                freedomAdapter3.notifyItemRemoved(i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LiveMsgContentManager this$0, int i) {
        Intrinsics.e(this$0, "this$0");
        int size = this$0.s.size() - 1;
        if (size < 0) {
            return;
        }
        while (true) {
            int i2 = size - 1;
            FitemMsgBase fitemMsgBase = (FitemMsgBase) CollectionsKt.c((List<? extends Object>) this$0.s, size);
            if (fitemMsgBase != null && fitemMsgBase.e().msgType == i) {
                this$0.s.remove(size);
                if (size >= 0) {
                    FreedomAdapter freedomAdapter = this$0.q;
                    FreedomAdapter freedomAdapter2 = freedomAdapter;
                    if (freedomAdapter == null) {
                        Intrinsics.c("adapter");
                        freedomAdapter2 = null;
                    }
                    if (size <= freedomAdapter2.getItemCount()) {
                        FreedomAdapter freedomAdapter3 = this$0.q;
                        if (freedomAdapter3 == null) {
                            Intrinsics.c("adapter");
                            freedomAdapter3 = null;
                        }
                        freedomAdapter3.notifyItemRemoved(size);
                    }
                }
            }
            if (i2 < 0) {
                return;
            }
            size = i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LiveMsgContentManager this$0, LiveChattingModel liveChattingModel) {
        Intrinsics.e(this$0, "this$0");
        this$0.b(liveChattingModel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LiveMsgContentManager this$0, ArrayList list) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(list, "$list");
        try {
            this$0.s.removeAll(list);
            FreedomAdapter freedomAdapter = this$0.q;
            FreedomAdapter freedomAdapter2 = freedomAdapter;
            if (freedomAdapter == null) {
                Intrinsics.c("adapter");
                freedomAdapter2 = null;
            }
            freedomAdapter2.notifyDataSetChanged();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(final LiveMsgContentManager this$0, final int i) {
        Intrinsics.e(this$0, "this$0");
        if (this$0.v) {
            return;
        }
        RecyclerView recyclerView = this$0.o;
        RecyclerView recyclerView2 = recyclerView;
        if (recyclerView == null) {
            Intrinsics.c("rvList");
            recyclerView2 = null;
        }
        recyclerView2.post(new Runnable() { // from class: com.blued.android.module.live_china.liveForMsg.-$$Lambda$LiveMsgContentManager$RrHOQrAEcpE0T1uf_WptcWvKIrs
            @Override // java.lang.Runnable
            public final void run() {
                LiveMsgContentManager.a(LiveMsgContentManager.this, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(LiveMsgContentManager this$0, LiveChattingModel liveChattingModel) {
        Intrinsics.e(this$0, "this$0");
        this$0.b(liveChattingModel);
    }

    private final void b(final LiveChattingModel liveChattingModel) {
        if (this.v) {
            return;
        }
        RecyclerView recyclerView = this.o;
        RecyclerView recyclerView2 = recyclerView;
        if (recyclerView == null) {
            Intrinsics.c("rvList");
            recyclerView2 = null;
        }
        if (recyclerView2.isComputingLayout()) {
            c(liveChattingModel);
            return;
        }
        RecyclerView recyclerView3 = this.o;
        if (recyclerView3 == null) {
            Intrinsics.c("rvList");
            recyclerView3 = null;
        }
        recyclerView3.post(new Runnable() { // from class: com.blued.android.module.live_china.liveForMsg.-$$Lambda$LiveMsgContentManager$kC2AANV9vxxm4j6BGNAjPotUhaE
            @Override // java.lang.Runnable
            public final void run() {
                LiveMsgContentManager.c(LiveMsgContentManager.this, liveChattingModel);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(LiveMsgContentManager this$0, LiveChattingModel msg) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(msg, "$msg");
        this$0.c(msg);
    }

    private final void c(final LiveChattingModel liveChattingModel) {
        if (this.v) {
            return;
        }
        j();
        k();
        AppInfo.n().postDelayed(new Runnable() { // from class: com.blued.android.module.live_china.liveForMsg.-$$Lambda$LiveMsgContentManager$_99EIGrt3pYbD2gkFAD8cc6E5sY
            @Override // java.lang.Runnable
            public final void run() {
                LiveMsgContentManager.d(LiveMsgContentManager.this, liveChattingModel);
            }
        }, 20L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(LiveMsgContentManager this$0, LiveChattingModel msg) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(msg, "$msg");
        if (this$0.v) {
            return;
        }
        this$0.d(msg);
        if (this$0.f() || msg.fromId == LiveRoomInfo.a().g()) {
            ArrayList<FitemMsgBase> arrayList = this$0.s;
            int b2 = arrayList == null || arrayList.isEmpty() ? 0 : CollectionsKt.b((List) this$0.s);
            RecyclerView recyclerView = this$0.o;
            RecyclerView recyclerView2 = recyclerView;
            if (recyclerView == null) {
                Intrinsics.c("rvList");
                recyclerView2 = null;
            }
            recyclerView2.scrollToPosition(b2);
        }
        if (msg.msgType == -10004) {
            this$0.g = 350L;
        }
    }

    private final void d(LiveChattingModel liveChattingModel) {
        FitemMsgBase fitemMsgTextBattlePass;
        if (this.v) {
            return;
        }
        short s = liveChattingModel.msgType;
        if (s == 275) {
            fitemMsgTextBattlePass = new FitemMsgTextBattlePass(liveChattingModel);
        } else if (s == 276) {
            fitemMsgTextBattlePass = new FitemMsgPromotion(liveChattingModel);
        } else if (s == 286) {
            fitemMsgTextBattlePass = new FitemMsgTextConstellation(liveChattingModel);
        } else if (s != 287) {
            switch (s) {
                case -10007:
                    fitemMsgTextBattlePass = new FitemMsgPKDaredEgg(liveChattingModel);
                    break;
                case -10006:
                    fitemMsgTextBattlePass = new FitemMsgGuide(liveChattingModel);
                    break;
                case -10005:
                    fitemMsgTextBattlePass = new FitemMsgGuideMarketingCampaignNotice(liveChattingModel);
                    break;
                case -10004:
                    fitemMsgTextBattlePass = new FitemMsgGuideOfficialSafetyNotice(liveChattingModel);
                    break;
                case -10003:
                    fitemMsgTextBattlePass = new FitemMsgRemind(liveChattingModel);
                    break;
                case g.k /* -10002 */:
                    fitemMsgTextBattlePass = new FitemMsgRemind(liveChattingModel);
                    break;
                case g.j /* -10001 */:
                    fitemMsgTextBattlePass = new FitemMsgGetWelfare(liveChattingModel);
                    break;
                case -10000:
                    fitemMsgTextBattlePass = new FitemMsgGetWelfare(liveChattingModel);
                    break;
                default:
                    switch (s) {
                        case 1:
                            fitemMsgTextBattlePass = new FitemMsgText(liveChattingModel);
                            break;
                        case 27:
                            fitemMsgTextBattlePass = new FitemMsgText(liveChattingModel);
                            break;
                        case 33:
                            fitemMsgTextBattlePass = new FitemMsgGift(liveChattingModel);
                            break;
                        case 61:
                            fitemMsgTextBattlePass = new FitemMsgGift(liveChattingModel);
                            break;
                        case 155:
                            fitemMsgTextBattlePass = new FitemMsgTextNotification(liveChattingModel);
                            break;
                        case 202:
                            fitemMsgTextBattlePass = new FitemMsgRemind(liveChattingModel);
                            break;
                        case 221:
                            fitemMsgTextBattlePass = new FitemMsgGift(liveChattingModel);
                            break;
                        case 224:
                            fitemMsgTextBattlePass = new FitemMsgRemind(liveChattingModel);
                            break;
                        case 232:
                            fitemMsgTextBattlePass = new FitemMsgTextNotification(liveChattingModel);
                            break;
                        case 245:
                            fitemMsgTextBattlePass = new FitemMsgTextWishing(liveChattingModel);
                            break;
                        case 249:
                            fitemMsgTextBattlePass = new FitemMsgChickenWin(liveChattingModel);
                            break;
                        case 251:
                            fitemMsgTextBattlePass = new FitemMsgTextWishing(liveChattingModel);
                            break;
                        case 267:
                            fitemMsgTextBattlePass = new FitemMsgNobleUpgrade(liveChattingModel);
                            break;
                        case 279:
                            fitemMsgTextBattlePass = new FitemMsgTextPlanet(liveChattingModel);
                            break;
                        default:
                            switch (s) {
                                case 49:
                                    fitemMsgTextBattlePass = new FitemMsgText(liveChattingModel);
                                    break;
                                case 50:
                                    fitemMsgTextBattlePass = new FitemMsgText(liveChattingModel);
                                    break;
                                case 51:
                                    fitemMsgTextBattlePass = new FitemMsgText(liveChattingModel);
                                    break;
                                default:
                                    switch (s) {
                                        case 102:
                                            fitemMsgTextBattlePass = new FitemMsgTextNotification(liveChattingModel);
                                            break;
                                        case 103:
                                            fitemMsgTextBattlePass = new FitemMsgRemind(liveChattingModel);
                                            break;
                                        case 104:
                                            fitemMsgTextBattlePass = new FitemMsgRemind(liveChattingModel);
                                            break;
                                        default:
                                            switch (s) {
                                                case 106:
                                                    fitemMsgTextBattlePass = new FitemMsgTextNotification(liveChattingModel);
                                                    break;
                                                case 107:
                                                    fitemMsgTextBattlePass = new FitemMsgTextNotification(liveChattingModel);
                                                    break;
                                                case 108:
                                                    fitemMsgTextBattlePass = new FitemMsgTextNotification(liveChattingModel);
                                                    break;
                                                case 109:
                                                    fitemMsgTextBattlePass = new FitemMsgTextNotification(liveChattingModel);
                                                    break;
                                                default:
                                                    fitemMsgTextBattlePass = new FitemMsgDefault(liveChattingModel);
                                                    break;
                                            }
                                    }
                            }
                    }
            }
        } else {
            fitemMsgTextBattlePass = new FitemMsgTextCommon(liveChattingModel);
        }
        this.s.add(fitemMsgTextBattlePass);
        int b2 = CollectionsKt.b((List) this.s);
        if (b2 >= 0) {
            FreedomAdapter freedomAdapter = this.q;
            FreedomAdapter freedomAdapter2 = freedomAdapter;
            if (freedomAdapter == null) {
                Intrinsics.c("adapter");
                freedomAdapter2 = null;
            }
            if (b2 <= freedomAdapter2.getItemCount()) {
                FreedomAdapter freedomAdapter3 = this.q;
                if (freedomAdapter3 == null) {
                    Intrinsics.c("adapter");
                    freedomAdapter3 = null;
                }
                freedomAdapter3.notifyItemChanged(b2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(LiveMsgContentManager this$0) {
        Intrinsics.e(this$0, "this$0");
        LiveMsgLayoutManager liveMsgLayoutManager = this$0.p;
        LiveMsgLayoutManager liveMsgLayoutManager2 = liveMsgLayoutManager;
        if (liveMsgLayoutManager == null) {
            Intrinsics.c("layoutManager");
            liveMsgLayoutManager2 = null;
        }
        if (liveMsgLayoutManager2.findLastVisibleItemPosition() < this$0.s.size() - 25) {
            RecyclerView recyclerView = this$0.o;
            RecyclerView recyclerView2 = recyclerView;
            if (recyclerView == null) {
                Intrinsics.c("rvList");
                recyclerView2 = null;
            }
            recyclerView2.scrollToPosition(this$0.s.size() - 25);
        }
        RecyclerView recyclerView3 = this$0.o;
        if (recyclerView3 == null) {
            Intrinsics.c("rvList");
            recyclerView3 = null;
        }
        recyclerView3.smoothScrollToPosition(this$0.s.size() - 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(final LiveMsgContentManager this$0) {
        Intrinsics.e(this$0, "this$0");
        if (this$0.v) {
            return;
        }
        int size = this$0.s.size() - 1;
        if (size < 0) {
            return;
        }
        while (true) {
            int i = size - 1;
            if (size >= 0 && size < this$0.s.size()) {
                FitemMsgBase fitemMsgBase = (FitemMsgBase) CollectionsKt.c((List<? extends Object>) this$0.s, size);
                if (size < this$0.s.size() && (fitemMsgBase instanceof FitemMsgGuide) && Intrinsics.a((Object) ((FitemMsgGuide) fitemMsgBase).f(), (Object) LiveGuideType.GUIDE_TYPE_FIRST_RECHARGE)) {
                    RecyclerView recyclerView = this$0.o;
                    RecyclerView recyclerView2 = recyclerView;
                    if (recyclerView == null) {
                        Intrinsics.c("rvList");
                        recyclerView2 = null;
                    }
                    if (recyclerView2.isComputingLayout()) {
                        this$0.s.remove(size);
                        if (size >= 0) {
                            FreedomAdapter freedomAdapter = this$0.q;
                            FreedomAdapter freedomAdapter2 = freedomAdapter;
                            if (freedomAdapter == null) {
                                Intrinsics.c("adapter");
                                freedomAdapter2 = null;
                            }
                            if (size <= freedomAdapter2.getItemCount()) {
                                FreedomAdapter freedomAdapter3 = this$0.q;
                                if (freedomAdapter3 == null) {
                                    Intrinsics.c("adapter");
                                    freedomAdapter3 = null;
                                }
                                freedomAdapter3.notifyItemRemoved(size);
                            }
                        }
                    } else {
                        RecyclerView recyclerView3 = this$0.o;
                        if (recyclerView3 == null) {
                            Intrinsics.c("rvList");
                            recyclerView3 = null;
                        }
                        final int i2 = size;
                        recyclerView3.post(new Runnable() { // from class: com.blued.android.module.live_china.liveForMsg.-$$Lambda$LiveMsgContentManager$FOezZPPsqS3JV6K4Kp0aqCYi4_s
                            @Override // java.lang.Runnable
                            public final void run() {
                                LiveMsgContentManager.a(i2, this$0);
                            }
                        });
                    }
                }
            }
            if (i < 0) {
                return;
            }
            size = i;
        }
    }

    private final void h() {
        Context context = this.l;
        Context context2 = context;
        if (context == null) {
            Intrinsics.c("context");
            context2 = null;
        }
        LiveMsgLayoutManager liveMsgLayoutManager = new LiveMsgLayoutManager(context2, 1, false);
        this.p = liveMsgLayoutManager;
        LiveMsgLayoutManager liveMsgLayoutManager2 = liveMsgLayoutManager;
        if (liveMsgLayoutManager == null) {
            Intrinsics.c("layoutManager");
            liveMsgLayoutManager2 = null;
        }
        liveMsgLayoutManager2.setStackFromEnd(true);
        RecyclerView recyclerView = this.o;
        RecyclerView recyclerView2 = recyclerView;
        if (recyclerView == null) {
            Intrinsics.c("rvList");
            recyclerView2 = null;
        }
        recyclerView2.setHasFixedSize(true);
        RecyclerView recyclerView3 = this.o;
        RecyclerView recyclerView4 = recyclerView3;
        if (recyclerView3 == null) {
            Intrinsics.c("rvList");
            recyclerView4 = null;
        }
        LiveMsgLayoutManager liveMsgLayoutManager3 = this.p;
        LiveMsgLayoutManager liveMsgLayoutManager4 = liveMsgLayoutManager3;
        if (liveMsgLayoutManager3 == null) {
            Intrinsics.c("layoutManager");
            liveMsgLayoutManager4 = null;
        }
        recyclerView4.setLayoutManager(liveMsgLayoutManager4);
        this.r.setAddDuration(500L);
        MsgItemAnimator msgItemAnimator = this.r;
        msgItemAnimator.setRemoveDuration(msgItemAnimator.getAddDuration());
        this.r.setMoveDuration(500L);
        MsgItemAnimator msgItemAnimator2 = this.r;
        msgItemAnimator2.setChangeDuration(msgItemAnimator2.getMoveDuration());
        RecyclerView recyclerView5 = this.o;
        RecyclerView recyclerView6 = recyclerView5;
        if (recyclerView5 == null) {
            Intrinsics.c("rvList");
            recyclerView6 = null;
        }
        recyclerView6.setItemAnimator(this.r);
        Context context3 = this.l;
        Context context4 = context3;
        if (context3 == null) {
            Intrinsics.c("context");
            context4 = null;
        }
        IRequestHost iRequestHost = this.n;
        IRequestHost iRequestHost2 = iRequestHost;
        if (iRequestHost == null) {
            Intrinsics.c("requestHost");
            iRequestHost2 = null;
        }
        FreedomAdapter freedomAdapter = new FreedomAdapter(context4, iRequestHost2, this.s);
        this.q = freedomAdapter;
        FreedomAdapter freedomAdapter2 = freedomAdapter;
        if (freedomAdapter == null) {
            Intrinsics.c("adapter");
            freedomAdapter2 = null;
        }
        freedomAdapter2.b("isHost", Boolean.valueOf(this.k));
        FreedomAdapter freedomAdapter3 = this.q;
        FreedomAdapter freedomAdapter4 = freedomAdapter3;
        if (freedomAdapter3 == null) {
            Intrinsics.c("adapter");
            freedomAdapter4 = null;
        }
        BaseFragment baseFragment = this.m;
        BaseFragment baseFragment2 = baseFragment;
        if (baseFragment == null) {
            Intrinsics.c("fragment");
            baseFragment2 = null;
        }
        freedomAdapter4.b("BaseFragment", baseFragment2);
        RecyclerView recyclerView7 = this.o;
        RecyclerView recyclerView8 = recyclerView7;
        if (recyclerView7 == null) {
            Intrinsics.c("rvList");
            recyclerView8 = null;
        }
        FreedomAdapter freedomAdapter5 = this.q;
        if (freedomAdapter5 == null) {
            Intrinsics.c("adapter");
            freedomAdapter5 = null;
        }
        recyclerView8.setAdapter(freedomAdapter5);
    }

    private final void i() {
        Timer timer = new Timer();
        this.u = timer;
        if (timer == null) {
            return;
        }
        timer.schedule(new TimerTask() { // from class: com.blued.android.module.live_china.liveForMsg.LiveMsgContentManager$initTimer$1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                boolean z;
                long j;
                long j2;
                long j3;
                long j4;
                ArrayList arrayList;
                long j5;
                ArrayList arrayList2;
                ArrayList arrayList3;
                z = LiveMsgContentManager.this.v;
                if (z || LiveMsgContentManager.this.b()) {
                    return;
                }
                if (LiveMsgContentManager.this.c() == null) {
                    arrayList3 = LiveMsgContentManager.this.t;
                    ArrayList arrayList4 = arrayList3;
                    if (arrayList4 == null || arrayList4.isEmpty()) {
                        return;
                    }
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (LiveMsgContentManager.this.c() != null) {
                    j3 = 0;
                } else {
                    j = LiveMsgContentManager.this.g;
                    if (j > 0) {
                        j4 = LiveMsgContentManager.this.g;
                        j3 = j4;
                    } else {
                        j2 = LiveMsgContentManager.this.f;
                        j3 = j2;
                    }
                }
                if (currentTimeMillis - LiveMsgContentManager.this.a() > j3) {
                    LiveMsgContentManager.this.a(true);
                    if (LiveMsgContentManager.this.c() != null) {
                        Runnable c2 = LiveMsgContentManager.this.c();
                        if (c2 != null) {
                            c2.run();
                        }
                        LiveMsgContentManager.this.a((Runnable) null);
                        LiveMsgContentManager.this.g = 800L;
                    } else {
                        arrayList = LiveMsgContentManager.this.t;
                        Runnable runnable = (Runnable) CollectionsKt.c((List<? extends Object>) arrayList, 0);
                        if (runnable != null) {
                            LiveMsgContentManager liveMsgContentManager = LiveMsgContentManager.this;
                            runnable.run();
                            arrayList2 = liveMsgContentManager.t;
                            arrayList2.remove(runnable);
                        }
                        j5 = LiveMsgContentManager.this.g;
                        if (j5 > 0) {
                            LiveMsgContentManager.this.g = 0L;
                        }
                    }
                    LiveMsgContentManager.this.a(false);
                    LiveMsgContentManager.this.a(System.currentTimeMillis());
                }
            }
        }, 20L, 20L);
    }

    private final void j() {
        int size;
        if (!this.v && (size = this.s.size()) >= this.f13471c) {
            int i = this.d;
            int i2 = this.e;
            final ArrayList arrayList = new ArrayList();
            int i3 = this.d;
            int i4 = i3;
            while (true) {
                int i5 = i4;
                if (i5 >= ((size - i) - i2) + i3) {
                    break;
                }
                FitemMsgBase fitemMsgBase = (FitemMsgBase) CollectionsKt.c((List<? extends Object>) this.s, i5);
                if (fitemMsgBase != null) {
                    arrayList.add(fitemMsgBase);
                }
                i4 = i5 + 1;
            }
            RecyclerView recyclerView = this.o;
            RecyclerView recyclerView2 = recyclerView;
            if (recyclerView == null) {
                Intrinsics.c("rvList");
                recyclerView2 = null;
            }
            if (!recyclerView2.isComputingLayout()) {
                RecyclerView recyclerView3 = this.o;
                if (recyclerView3 == null) {
                    Intrinsics.c("rvList");
                    recyclerView3 = null;
                }
                recyclerView3.post(new Runnable() { // from class: com.blued.android.module.live_china.liveForMsg.-$$Lambda$LiveMsgContentManager$mH8GfdwmKEerGFKAKgPtsdCoFEs
                    @Override // java.lang.Runnable
                    public final void run() {
                        LiveMsgContentManager.a(LiveMsgContentManager.this, arrayList);
                    }
                });
                return;
            }
            try {
                this.s.removeAll(arrayList);
                FreedomAdapter freedomAdapter = this.q;
                if (freedomAdapter == null) {
                    Intrinsics.c("adapter");
                    freedomAdapter = null;
                }
                freedomAdapter.notifyDataSetChanged();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private final boolean k() {
        boolean z;
        FitemMsgBase fitemMsgBase;
        try {
            ArrayList<FitemMsgBase> arrayList = this.s;
            if (arrayList != null && !arrayList.isEmpty()) {
                z = false;
                if (z && (fitemMsgBase = (FitemMsgBase) CollectionsKt.c((List<? extends Object>) this.s, this.s.size() - 1)) != null && fitemMsgBase.j()) {
                    LiveMsgLayoutManager liveMsgLayoutManager = this.p;
                    LiveMsgLayoutManager liveMsgLayoutManager2 = liveMsgLayoutManager;
                    if (liveMsgLayoutManager == null) {
                        Intrinsics.c("layoutManager");
                        liveMsgLayoutManager2 = null;
                    }
                    b = liveMsgLayoutManager2.findFirstCompletelyVisibleItemPosition();
                    this.s.remove(fitemMsgBase);
                    int size = this.s.size();
                    if (size >= 0) {
                        FreedomAdapter freedomAdapter = this.q;
                        FreedomAdapter freedomAdapter2 = freedomAdapter;
                        if (freedomAdapter == null) {
                            Intrinsics.c("adapter");
                            freedomAdapter2 = null;
                        }
                        if (size <= freedomAdapter2.getItemCount()) {
                            FreedomAdapter freedomAdapter3 = this.q;
                            if (freedomAdapter3 == null) {
                                Intrinsics.c("adapter");
                                freedomAdapter3 = null;
                            }
                            freedomAdapter3.notifyItemRemoved(size);
                            return true;
                        }
                        return true;
                    }
                    return true;
                }
                return false;
            }
            z = true;
            return z ? false : false;
        } catch (Exception e) {
            return false;
        }
    }

    public final long a() {
        return this.h;
    }

    public final void a(final int i) {
        this.t.add(new Runnable() { // from class: com.blued.android.module.live_china.liveForMsg.-$$Lambda$LiveMsgContentManager$3EcYvXMgdWI7aKNGWKGKFfY84Xw
            @Override // java.lang.Runnable
            public final void run() {
                LiveMsgContentManager.b(LiveMsgContentManager.this, i);
            }
        });
    }

    public final void a(long j) {
        this.h = j;
    }

    public final void a(Context context, boolean z, BaseFragment fragment, IRequestHost requestHost, RecyclerView rvList) {
        Intrinsics.e(context, "context");
        Intrinsics.e(fragment, "fragment");
        Intrinsics.e(requestHost, "requestHost");
        Intrinsics.e(rvList, "rvList");
        this.l = context;
        this.k = z;
        this.m = fragment;
        this.n = requestHost;
        this.o = rvList;
        h();
        b = -1;
        i();
    }

    public final void a(final LiveChattingModel liveChattingModel) {
        boolean z;
        FitemMsgBase fitemMsgBase;
        synchronized (this) {
            if (!LiveFloatManager.a().x() && !LiveFloatManager.a().C() && !this.v) {
                if (this.o == null) {
                    Intrinsics.c("rvList");
                }
                if (liveChattingModel == null) {
                    return;
                }
                if (f13470a.a(liveChattingModel)) {
                    this.j = new Runnable() { // from class: com.blued.android.module.live_china.liveForMsg.-$$Lambda$LiveMsgContentManager$ym1sQ604bIuRaUUHmWvw9LXPl-A
                        @Override // java.lang.Runnable
                        public final void run() {
                            LiveMsgContentManager.a(LiveMsgContentManager.this, liveChattingModel);
                        }
                    };
                    return;
                }
                ArrayList<FitemMsgBase> arrayList = this.s;
                if (arrayList != null && !arrayList.isEmpty()) {
                    z = false;
                    if (z && (fitemMsgBase = (FitemMsgBase) CollectionsKt.c((List<? extends Object>) this.s, this.s.size() - 1)) != null && (fitemMsgBase instanceof FitemMsgGift) && ((FitemMsgGift) fitemMsgBase).a(liveChattingModel)) {
                        return;
                    }
                    this.t.add(new Runnable() { // from class: com.blued.android.module.live_china.liveForMsg.-$$Lambda$LiveMsgContentManager$e74P1yrNe7gzbohlp7jTWUl1U0g
                        @Override // java.lang.Runnable
                        public final void run() {
                            LiveMsgContentManager.b(LiveMsgContentManager.this, liveChattingModel);
                        }
                    });
                }
                z = true;
                if (z) {
                }
                this.t.add(new Runnable() { // from class: com.blued.android.module.live_china.liveForMsg.-$$Lambda$LiveMsgContentManager$e74P1yrNe7gzbohlp7jTWUl1U0g
                    @Override // java.lang.Runnable
                    public final void run() {
                        LiveMsgContentManager.b(LiveMsgContentManager.this, liveChattingModel);
                    }
                });
            }
        }
    }

    public final void a(Runnable runnable) {
        this.j = runnable;
    }

    public final void a(boolean z) {
        this.i = z;
    }

    public final List<LiveChattingModel> b(int i) {
        FitemMsgBase fitemMsgBase;
        if (this.v || i == 0) {
            return null;
        }
        ArrayList<FitemMsgBase> arrayList = this.s;
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        ArrayList arrayList2 = new ArrayList();
        int size = this.s.size();
        int i2 = 0;
        if (i >= 0) {
            i2 = size <= i ? 0 : size - i;
        }
        while (i2 < size) {
            if (i2 >= 0 && i2 < this.s.size() && (fitemMsgBase = (FitemMsgBase) CollectionsKt.c((List<? extends Object>) this.s, i2)) != null) {
                arrayList2.add(fitemMsgBase.e());
            }
            i2++;
        }
        return arrayList2;
    }

    public final void b(boolean z) {
        if (this.v) {
            return;
        }
        for (FitemMsgBase fitemMsgBase : this.s) {
            if (fitemMsgBase.e().msgType == 103) {
                fitemMsgBase.e().liveChatListFollowed = z;
            }
        }
    }

    public final boolean b() {
        return this.i;
    }

    public final Runnable c() {
        return this.j;
    }

    public final void d() {
        this.v = true;
        Timer timer = this.u;
        if (timer != null) {
            timer.cancel();
        }
        this.u = null;
        ArrayList<Runnable> arrayList = this.t;
        if (arrayList == null) {
            return;
        }
        arrayList.clear();
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0024 A[Catch: Exception -> 0x00f4, TRY_ENTER, TRY_LEAVE, TryCatch #0 {Exception -> 0x00f4, blocks: (B:5:0x0008, B:7:0x0014, B:12:0x0024, B:15:0x0038, B:17:0x003f), top: B:48:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void e() {
        /*
            Method dump skipped, instructions count: 256
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.live_china.liveForMsg.LiveMsgContentManager.e():void");
    }

    public final boolean f() {
        boolean z = true;
        if (!this.v) {
            ArrayList<FitemMsgBase> arrayList = this.s;
            if (arrayList == null || arrayList.isEmpty()) {
                return true;
            }
            LiveMsgLayoutManager liveMsgLayoutManager = this.p;
            LiveMsgLayoutManager liveMsgLayoutManager2 = liveMsgLayoutManager;
            if (liveMsgLayoutManager == null) {
                Intrinsics.c("layoutManager");
                liveMsgLayoutManager2 = null;
            }
            if (liveMsgLayoutManager2.findLastVisibleItemPosition() >= this.s.size() - 2) {
                return true;
            }
            z = false;
        }
        return z;
    }

    public final void g() {
        this.t.add(new Runnable() { // from class: com.blued.android.module.live_china.liveForMsg.-$$Lambda$LiveMsgContentManager$qGHjJF7twDuUwaJ1i_Amdb87Vcw
            @Override // java.lang.Runnable
            public final void run() {
                LiveMsgContentManager.f(LiveMsgContentManager.this);
            }
        });
    }
}
