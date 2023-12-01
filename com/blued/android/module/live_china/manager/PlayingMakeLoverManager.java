package com.blued.android.module.live_china.manager;

import android.content.Context;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.blued.android.chat.data.JoinLiveResult;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageFileLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.StatusBarHelper;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.common.utils.AvatarUtils;
import com.blued.android.module.live_china.fragment.PlayingOnliveFragment;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.model.LiveMakeLoverFansModel;
import com.blued.android.module.live_china.msg.LiveMsgSendManager;
import com.blued.android.module.live_china.observer.LiveSetDataObserver;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.das.live.LiveProtos;
import java.util.List;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/manager/PlayingMakeLoverManager.class */
public class PlayingMakeLoverManager extends MakeLoverBaseManager {
    public static int b = 0;

    /* renamed from: c  reason: collision with root package name */
    public static int f13681c = 0;
    public static int d = 0;
    public static int e = 0;
    public static double f = 1.0d;
    public String i;
    public int k;
    private Context l;
    private PlayingOnliveFragment m;
    private int o;
    public boolean g = false;
    public int h = 0;
    private boolean n = false;
    Object j = new Object();

    public PlayingMakeLoverManager(PlayingOnliveFragment playingOnliveFragment) {
        this.i = "";
        this.m = playingOnliveFragment;
        Context context = playingOnliveFragment.getContext();
        this.l = context;
        this.o = DensityUtils.a(context, 1.0f);
        int i = AppInfo.l / 3;
        b = i;
        f13681c = (int) (i * f);
        d = DensityUtils.a(this.l, 148);
        e = StatusBarHelper.a() ? d - StatusBarHelper.a((Context) playingOnliveFragment.getActivity()) : d;
        this.i = AvatarUtils.a(0, LiveRoomInfo.a().e());
    }

    public void a(LiveMakeLoverFansModel liveMakeLoverFansModel) {
        if (this.m.aD()) {
            return;
        }
        Log.i("==makelover==", "joinMakeLover");
        this.m.d_(9);
        this.m.bX.setVisibility(8);
        LiveSetDataObserver.a().a(liveMakeLoverFansModel);
        LiveFloatManager.a().b.setVisibility(8);
        LiveFloatManager.a().h();
        this.m.aQ = true;
        this.m.aU.setRTCModel(this.m.aQ);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, f13681c * 2);
        layoutParams.setMargins(0, d, 0, 0);
        this.m.aN.setLayoutParams(layoutParams);
        b(liveMakeLoverFansModel.index);
        this.k = liveMakeLoverFansModel.index;
        i();
        this.m.a(JoinLiveResult.SUCCESS, liveMakeLoverFansModel.conference_id, "", liveMakeLoverFansModel.stream, "", liveMakeLoverFansModel.index);
    }

    public void a(String str, String str2, String str3) {
        Log.i("==makelover==", "updatePhotoPushUrl:" + str + " netUrl:" + str2 + "  photo:" + str3);
        a(str, str2);
        if (this.m.L != null) {
            this.m.L.b(str3);
        }
    }

    public void a(final boolean z) {
        LiveRoomHttpUtils.c(String.valueOf(this.m.t), new BluedUIHttpResponse(this.m.getFragmentActive()) { // from class: com.blued.android.module.live_china.manager.PlayingMakeLoverManager.1
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity bluedEntity) {
                if (!z) {
                    PlayingMakeLoverManager.this.m.aa();
                    return;
                }
                LiveFloatManager.a().b(false);
                LiveFloatManager.a().n();
                PlayingMakeLoverManager.this.m.T();
            }
        });
    }

    public void a(boolean z, int i) {
        Log.i("==makelover==", "onMakeLoverWindowClick isHost:" + z + " index:" + i);
        if (z) {
            EventTrackLive.d(LiveProtos.Event.USER_MIKE_USER_PHOTO_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g(), LiveRoomManager.a().g());
            if (LiveRoomManager.a().t()) {
                return;
            }
            LiveSetDataObserver.a().e(LiveRoomManager.a().g());
        } else if (this.f13675a.size() > i) {
            LiveMakeLoverFansModel liveMakeLoverFansModel = this.f13675a.get(i);
            if (liveMakeLoverFansModel != null && !liveMakeLoverFansModel.isEmpty()) {
                EventTrackLive.d(LiveProtos.Event.USER_MIKE_USER_PHOTO_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g(), liveMakeLoverFansModel.uid);
                this.m.bW.a(i);
                LiveSetDataObserver.a().e(liveMakeLoverFansModel.uid);
                return;
            }
            LiveMsgSendManager a2 = LiveMsgSendManager.a();
            a2.d("点击空白小窗，当前状态为：" + this.m.M_());
            if (this.m.aD()) {
                return;
            }
            this.m.bX.performClick();
        }
    }

    public void b(int i) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(b, f13681c);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(b, f13681c);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(b, f13681c);
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(b, f13681c);
        FrameLayout.LayoutParams layoutParams5 = new FrameLayout.LayoutParams(b, f13681c);
        if (i == 1) {
            layoutParams5.leftMargin = b;
            layoutParams5.topMargin = d;
            layoutParams.leftMargin = b * 2;
            layoutParams2.topMargin = f13681c;
            layoutParams3.leftMargin = b;
            layoutParams3.topMargin = f13681c;
            layoutParams4.leftMargin = b * 2;
            layoutParams4.topMargin = f13681c;
            this.m.bW.g.setVisibility(8);
        } else if (i == 2) {
            layoutParams5.topMargin = d;
            layoutParams5.leftMargin = b * 2;
            layoutParams.leftMargin = b;
            layoutParams2.topMargin = f13681c;
            layoutParams3.leftMargin = b;
            layoutParams3.topMargin = f13681c;
            layoutParams4.leftMargin = b * 2;
            layoutParams4.topMargin = f13681c;
            this.m.bW.h.setVisibility(8);
        } else if (i == 3) {
            layoutParams5.topMargin = d + f13681c;
            layoutParams.leftMargin = b;
            layoutParams2.leftMargin = b * 2;
            layoutParams3.leftMargin = b;
            layoutParams3.topMargin = f13681c;
            layoutParams4.leftMargin = b * 2;
            layoutParams4.topMargin = f13681c;
            this.m.bW.i.setVisibility(8);
        } else if (i == 4) {
            layoutParams5.topMargin = d + f13681c;
            layoutParams5.leftMargin = b;
            layoutParams.leftMargin = b;
            layoutParams2.leftMargin = b * 2;
            layoutParams3.topMargin = f13681c;
            layoutParams4.leftMargin = b * 2;
            layoutParams4.topMargin = f13681c;
            this.m.bW.j.setVisibility(8);
        } else if (i == 5) {
            layoutParams5.topMargin = d + f13681c;
            layoutParams5.leftMargin = b * 2;
            layoutParams.leftMargin = b;
            layoutParams2.leftMargin = b * 2;
            layoutParams3.topMargin = f13681c;
            layoutParams4.leftMargin = b;
            layoutParams4.topMargin = f13681c;
            this.m.bW.k.setVisibility(8);
        }
        this.m.ag.setLayoutParams(layoutParams5);
        this.m.bB.setLayoutParams(layoutParams);
        this.m.bC.setLayoutParams(layoutParams2);
        this.m.bD.setLayoutParams(layoutParams3);
        this.m.bE.setLayoutParams(layoutParams4);
        this.m.bA.setVisibility(0);
        this.m.bB.setVisibility(0);
        this.m.bC.setVisibility(0);
        this.m.bD.setVisibility(0);
        this.m.bE.setVisibility(0);
        this.m.ag.setVisibility(0);
    }

    public void b(List<LiveMakeLoverFansModel> list) {
        if (list == null) {
            return;
        }
        a(list);
        h();
    }

    public void d(String str) {
        b(str);
        h();
    }

    public void f() {
        if (this.m.aC()) {
            return;
        }
        Log.i("==makelover==", "startMakeLover");
        this.m.d_(8);
        LiveMakeLoverManager.a(1);
        this.m.O.setVisibility(0);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, d + (f13681c * 2), 0, 0);
        this.m.bX.setLayoutParams(layoutParams);
        this.m.bX.setVisibility(0);
        LiveSetDataObserver.a().f();
        this.m.bd.g();
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, f13681c * 2);
        layoutParams2.setMargins(0, d, 0, 0);
        this.m.aN.setLayoutParams(layoutParams2);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -1);
        layoutParams3.setMargins(0, d, 0, 0);
        this.m.bW.f14566a.setLayoutParams(layoutParams3);
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(b, f13681c);
        this.m.bA.setLayoutParams(layoutParams4);
        this.m.aj.setLayoutParams(layoutParams4);
        this.m.ak.setLayoutParams(layoutParams4);
        this.m.al.setLayoutParams(layoutParams4);
        this.m.am.setLayoutParams(layoutParams4);
        this.m.an.setLayoutParams(layoutParams4);
        this.m.ai.setLayoutParams(layoutParams4);
        FrameLayout.LayoutParams layoutParams5 = new FrameLayout.LayoutParams(b, f13681c);
        layoutParams5.leftMargin = b - this.o;
        FrameLayout.LayoutParams layoutParams6 = new FrameLayout.LayoutParams(b, f13681c);
        layoutParams6.leftMargin = (b * 2) - this.o;
        FrameLayout.LayoutParams layoutParams7 = new FrameLayout.LayoutParams(b, f13681c);
        layoutParams7.topMargin = f13681c;
        FrameLayout.LayoutParams layoutParams8 = new FrameLayout.LayoutParams(b, f13681c);
        layoutParams8.topMargin = f13681c - this.o;
        layoutParams8.leftMargin = b;
        FrameLayout.LayoutParams layoutParams9 = new FrameLayout.LayoutParams(b, f13681c);
        layoutParams9.leftMargin = (b * 2) - this.o;
        layoutParams9.topMargin = f13681c;
        this.m.bW.b.setLayoutParams(layoutParams5);
        this.m.bW.f14567c.setLayoutParams(layoutParams6);
        this.m.bW.d.setLayoutParams(layoutParams7);
        this.m.bW.e.setLayoutParams(layoutParams8);
        this.m.bW.f.setLayoutParams(layoutParams9);
        this.m.bW.f14566a.setVisibility(0);
        this.m.bW.g.setVisibility(0);
        this.m.bW.h.setVisibility(0);
        this.m.bW.i.setVisibility(0);
        this.m.bW.j.setVisibility(0);
        this.m.bW.k.setVisibility(0);
        this.m.bW.l.setVisibility(8);
        this.m.bW.m.setVisibility(8);
        this.m.bW.n.setVisibility(8);
        this.m.bW.o.setVisibility(8);
        this.m.bW.p.setVisibility(8);
        this.m.bW.v.setVisibility(8);
        this.m.bW.w.setVisibility(8);
        this.m.bW.x.setVisibility(8);
        this.m.bW.y.setVisibility(8);
        this.m.bW.z.setVisibility(8);
        this.m.bW.F.setVisibility(8);
        this.m.bW.G.setVisibility(8);
        this.m.bW.H.setVisibility(8);
        this.m.bW.I.setVisibility(8);
        this.m.bW.J.setVisibility(8);
        ImageFileLoader.a((IRequestHost) null).a(this.i).a();
        if (LiveRoomManager.a().p().matchmaking == null || LiveRoomManager.a().p().matchmaking.fans == null) {
            return;
        }
        b(LiveRoomManager.a().p().matchmaking.fans);
    }

    public void g() {
        if (this.m.aD()) {
            Log.i("==makelover==", "exitMakeLover");
            this.m.d_(8);
            this.m.bX.setVisibility(0);
            if (this.m.L != null) {
                this.m.L.h();
            }
            LiveSetDataObserver.a().g();
            this.m.V();
            this.m.bA.setVisibility(8);
            this.m.bB.setVisibility(8);
            this.m.bC.setVisibility(8);
            this.m.bD.setVisibility(8);
            this.m.bE.setVisibility(8);
            LiveMakeLoverManager.a(1);
        }
    }

    public void h() {
        if (this.f13675a != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.f13675a.size()) {
                    break;
                }
                LiveMakeLoverFansModel liveMakeLoverFansModel = this.f13675a.get(i2);
                if (i2 == 0) {
                    if (!liveMakeLoverFansModel.isEmpty()) {
                        this.m.bW.g.setVisibility(8);
                    } else if (this.m.bW.g.getVisibility() == 8) {
                        this.m.bW.g.setVisibility(0);
                    }
                }
                if (i2 == 1) {
                    if (!liveMakeLoverFansModel.isEmpty()) {
                        this.m.bW.h.setVisibility(8);
                    } else if (this.m.bW.h.getVisibility() == 8) {
                        this.m.bW.h.setVisibility(0);
                    }
                }
                if (i2 == 2) {
                    if (!liveMakeLoverFansModel.isEmpty()) {
                        this.m.bW.i.setVisibility(8);
                    } else if (this.m.bW.i.getVisibility() == 8) {
                        this.m.bW.i.setVisibility(0);
                    }
                }
                if (i2 == 3) {
                    if (!liveMakeLoverFansModel.isEmpty()) {
                        this.m.bW.j.setVisibility(8);
                    } else if (this.m.bW.j.getVisibility() == 8) {
                        this.m.bW.j.setVisibility(0);
                    }
                }
                if (i2 == 4) {
                    if (!liveMakeLoverFansModel.isEmpty()) {
                        this.m.bW.k.setVisibility(8);
                    } else if (this.m.bW.k.getVisibility() == 8) {
                        this.m.bW.k.setVisibility(0);
                    }
                }
                i = i2 + 1;
            }
        }
        this.m.bW.a();
    }

    public void i() {
    }

    public void j() {
        if (LiveMakeLoverManager.b()) {
            LiveRoomHttpUtils.w((BluedUIHttpResponse) null, String.valueOf(this.m.t));
        }
        if (this.m.aD()) {
            a(false);
        }
    }

    public void k() {
        Log.i("==makelover==", "make lover manager destroy");
        this.n = true;
        this.g = false;
    }

    public void l() {
        if (this.n) {
            Log.i("==record==", "startSpeaking hasDestroy");
            return;
        }
        this.g = true;
        this.h++;
        if (this.m.L != null) {
            this.m.L.a(this.g, this.h);
        }
    }

    public void m() {
        if (!this.n && this.g) {
            Log.i("==record", "stopSpeaking");
            this.g = false;
            this.h = 0;
            if (this.m.L != null) {
                this.m.L.a(this.g, this.h);
            }
        }
    }
}
