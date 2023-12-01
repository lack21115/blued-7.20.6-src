package com.blued.android.module.live_china.manager;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.blued.android.chat.data.JoinLiveResult;
import com.blued.android.core.AppInfo;
import com.blued.android.core.ui.StatusBarHelper;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.live_china.fragment.PlayingOnliveFragment;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.model.LiveFriendModel;
import com.blued.android.module.live_china.msg.LiveMsgSendManager;
import com.blued.android.module.live_china.observer.LiveSetDataObserver;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/manager/PlayingMakeFriendManager.class */
public class PlayingMakeFriendManager {

    /* renamed from: a  reason: collision with root package name */
    public static int f13678a = 0;
    public static int b = 0;

    /* renamed from: c  reason: collision with root package name */
    public static int f13679c = 0;
    public static double d = 0.9d;
    public int h;
    private Context i;
    private PlayingOnliveFragment j;
    private int k;
    public boolean e = false;
    public int f = 0;
    private boolean l = false;
    public List<LiveFriendModel> g = new ArrayList();

    public PlayingMakeFriendManager(PlayingOnliveFragment playingOnliveFragment) {
        this.j = playingOnliveFragment;
        this.i = playingOnliveFragment.getContext();
        int i = AppInfo.l / 2;
        this.k = i;
        f13678a = (int) (i * d);
        b = DensityUtils.a(this.i, 148.0f);
        f13679c = StatusBarHelper.a() ? b - StatusBarHelper.a((Context) playingOnliveFragment.getActivity()) : b;
    }

    public void a() {
        this.j.d_(5);
        this.j.O.setVisibility(0);
        this.j.bd.f();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, f13678a * 2);
        layoutParams.setMargins(0, b, 0, 0);
        this.j.aN.setLayoutParams(layoutParams);
        this.j.cc.setLayoutParams(layoutParams);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(this.k, f13678a);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(this.k, f13678a);
        layoutParams3.leftMargin = this.k;
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(this.k, f13678a);
        layoutParams4.topMargin = f13678a;
        FrameLayout.LayoutParams layoutParams5 = new FrameLayout.LayoutParams(this.k, f13678a);
        layoutParams5.leftMargin = this.k;
        layoutParams5.topMargin = f13678a;
        this.j.bz.setLayoutParams(layoutParams5);
        this.j.bA.setLayoutParams(layoutParams2);
        this.j.bB.setLayoutParams(layoutParams3);
        this.j.bC.setLayoutParams(layoutParams4);
        this.j.aj.setLayoutParams(layoutParams2);
        this.j.ak.setLayoutParams(layoutParams2);
        this.j.al.setLayoutParams(layoutParams2);
        this.j.bR.setLayoutParams(layoutParams3);
        this.j.bS.setLayoutParams(layoutParams4);
        this.j.bQ.setLayoutParams(layoutParams5);
        this.j.bR.setVisibility(0);
        this.j.bS.setVisibility(0);
        this.j.bQ.setVisibility(0);
        this.j.cc.setVisibility(0);
        this.j.bF.setVisibility(0);
        this.j.bK.setVisibility(0);
        this.j.bL.setVisibility(0);
        this.j.bM.setVisibility(0);
        this.j.bO.setVisibility(8);
        this.j.bP.setVisibility(8);
        this.j.bN.setVisibility(8);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams6.setMargins(0, b + (f13678a * 2), 0, 0);
        this.j.k.setLayoutParams(layoutParams6);
        d();
    }

    public void a(int i) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.k, f13678a);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(this.k, f13678a);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(this.k, f13678a);
        if (i == 1) {
            layoutParams3.leftMargin = this.k;
            layoutParams3.topMargin = b;
            layoutParams.topMargin = f13678a;
            layoutParams2.topMargin = f13678a;
            layoutParams2.leftMargin = this.k;
            this.j.bL.setVisibility(8);
        } else if (i == 2) {
            layoutParams3.topMargin = f13678a + b;
            layoutParams.leftMargin = this.k;
            layoutParams2.topMargin = f13678a;
            layoutParams2.leftMargin = this.k;
            this.j.bM.setVisibility(8);
        } else if (i == 3) {
            layoutParams3.topMargin = f13678a + b;
            layoutParams3.leftMargin = this.k;
            layoutParams.leftMargin = this.k;
            layoutParams2.topMargin = f13678a;
            this.j.bK.setVisibility(8);
        }
        this.j.ag.setLayoutParams(layoutParams3);
        this.j.bB.setLayoutParams(layoutParams);
        this.j.bC.setLayoutParams(layoutParams2);
        this.j.bA.setVisibility(0);
        this.j.bB.setVisibility(0);
        this.j.bC.setVisibility(0);
        this.j.ag.setVisibility(0);
    }

    public void a(LiveFriendModel liveFriendModel) {
        this.j.d_(6);
        LiveFloatManager.a().b.setVisibility(8);
        LiveFloatManager.a().h();
        this.j.aQ = true;
        this.j.aU.setRTCModel(this.j.aQ);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, f13678a * 2);
        layoutParams.setMargins(0, b, 0, 0);
        this.j.aN.setLayoutParams(layoutParams);
        a(liveFriendModel.index);
        this.h = liveFriendModel.index;
        e();
        d();
        this.j.k.a(3);
        this.j.a(JoinLiveResult.SUCCESS, liveFriendModel.conference_id, liveFriendModel.conference_token, liveFriendModel.stream, liveFriendModel.target_stream, liveFriendModel.index);
    }

    public void a(List<LiveFriendModel> list) {
        this.g = list;
        if (list == null) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.g.size()) {
                return;
            }
            LiveFriendModel liveFriendModel = this.g.get(i2);
            if (i2 == 0) {
                if (TextUtils.isEmpty(liveFriendModel.uid)) {
                    this.j.bU.setVisibility(8);
                    if (this.j.bL.getVisibility() == 8) {
                        this.j.bL.setVisibility(0);
                    }
                } else {
                    this.j.bU.setVisibility(0);
                    this.j.bU.setText(liveFriendModel.name);
                    this.j.bL.setVisibility(8);
                }
            }
            if (i2 == 1) {
                if (TextUtils.isEmpty(liveFriendModel.uid)) {
                    this.j.bV.setVisibility(8);
                    if (this.j.bM.getVisibility() == 8) {
                        this.j.bM.setVisibility(0);
                    }
                } else {
                    this.j.bV.setVisibility(0);
                    this.j.bV.setText(liveFriendModel.name);
                    this.j.bM.setVisibility(8);
                }
            }
            if (i2 == 2) {
                if (TextUtils.isEmpty(liveFriendModel.uid)) {
                    this.j.bT.setVisibility(8);
                    if (this.j.bK.getVisibility() == 8) {
                        this.j.bK.setVisibility(0);
                    }
                } else {
                    this.j.bT.setVisibility(0);
                    this.j.bT.setText(liveFriendModel.name);
                    this.j.bK.setVisibility(8);
                }
            }
            i = i2 + 1;
        }
    }

    public void a(boolean z, int i) {
        if (z) {
            if (LiveRoomManager.a().t()) {
                return;
            }
            LiveSetDataObserver.a().e(LiveRoomManager.a().g());
        } else if (this.g.size() > i) {
            LiveFriendModel liveFriendModel = this.g.get(i);
            if (TextUtils.isEmpty(liveFriendModel.uid)) {
                LiveMsgSendManager a2 = LiveMsgSendManager.a();
                a2.d("点击空白小窗，当前状态为：" + this.j.M_());
                if (this.j.aB()) {
                    return;
                }
                this.j.k.performClick();
            } else if (TextUtils.equals(liveFriendModel.uid, LiveRoomInfo.a().f())) {
                this.j.ca.a(1);
                this.j.ca.e();
            } else {
                ArrayList arrayList = new ArrayList();
                for (LiveFriendModel liveFriendModel2 : this.g) {
                    arrayList.add(liveFriendModel2.uid);
                }
                LiveRoomManager.a().a(arrayList);
                LiveSetDataObserver.a().e(liveFriendModel.uid);
            }
        }
    }

    public void b() {
        if (this.j.aB()) {
            if (this.j.L != null) {
                this.j.L.h();
            }
            this.j.V();
        }
        if (!this.j.ca.a()) {
            this.j.aY();
        }
        this.j.O.setVisibility(8);
        this.j.d_(0);
        this.j.aN.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        LiveFloatManager.a().a(AppInfo.l, this.j.bc());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.j.N.setLayoutParams(layoutParams);
        this.j.bz.setVisibility(8);
        this.j.bA.setVisibility(8);
        this.j.bB.setVisibility(8);
        this.j.bC.setVisibility(8);
        this.j.bF.setVisibility(8);
        this.j.bK.setVisibility(8);
        this.j.bL.setVisibility(8);
        this.j.bM.setVisibility(8);
        this.j.cc.setVisibility(8);
        this.g.clear();
    }

    public void c() {
        if (!this.j.ca.a()) {
            this.j.aY();
        }
        if (this.j.L != null) {
            this.j.L.h();
        }
        this.j.d_(5);
        this.j.V();
        this.j.bz.setVisibility(8);
        this.j.bA.setVisibility(8);
        this.j.bB.setVisibility(8);
        this.j.bC.setVisibility(8);
        this.j.bI.setVisibility(8);
        this.j.bJ.setVisibility(8);
        this.j.bG.setVisibility(8);
        this.j.k.a(1);
        this.j.cb.setState(0);
    }

    public void d() {
        LiveSetDataObserver.a().b();
    }

    public void e() {
    }

    public void f() {
        BluedUIHttpResponse bluedUIHttpResponse = new BluedUIHttpResponse(this.j.getFragmentActive()) { // from class: com.blued.android.module.live_china.manager.PlayingMakeFriendManager.1
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity bluedEntity) {
                PlayingMakeFriendManager.this.j.X();
            }
        };
        LiveRoomHttpUtils.b(bluedUIHttpResponse, this.j.t + "", "");
    }

    public void g() {
        if (this.j.aB()) {
            f();
        }
    }

    public void h() {
        int i = this.h;
        if (i == 1) {
            this.j.bO.setVisibility(8);
        } else if (i == 2) {
            this.j.bP.setVisibility(8);
        } else if (i != 3) {
        } else {
            this.j.bN.setVisibility(8);
        }
    }

    public void i() {
    }

    public void j() {
        Log.i("==mic", "make friend manager destroy");
        this.l = true;
        this.e = false;
    }

    public void k() {
        if (this.l) {
            Log.i("==mic", "startSpeaking hasDestroy");
            return;
        }
        this.e = true;
        this.f++;
        if (this.j.L != null) {
            this.j.L.b(this.e, this.f);
        }
    }

    public void l() {
        if (this.l) {
            Log.i("==mic", "stopSpeaking hasDestroy");
        } else if (this.e) {
            Log.i("==mic", "stopSpeaking");
            this.e = false;
            this.f = 0;
            if (this.j.L != null) {
                this.j.L.b(this.e, this.f);
            }
        }
    }
}
