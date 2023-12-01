package com.blued.android.module.live_china.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.fragment.RecordingOnliveFragment;
import com.blued.android.module.live_china.model.LiveFriendModel;
import com.blued.android.module.live_china.model.LiveGroupPkUserModel;
import com.blued.android.module.live_china.model.LiveInviteUserModel;
import com.blued.android.module.live_china.model.LivePKPlayerModel;
import com.blued.android.module.live_china.utils.log.InstantLog;
import java.util.List;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LiveConnectionView.class */
public class LiveConnectionView extends FrameLayout implements ILiveConnectionStateListener {

    /* renamed from: a  reason: collision with root package name */
    public RecordingOnliveFragment f14428a;
    private Context b;

    /* renamed from: c  reason: collision with root package name */
    private LayoutInflater f14429c;
    private LivePKCenterView d;
    private LivePKFriendListView e;
    private LivePKInviteView f;
    private LivePKWholeView g;
    private LiveConnectInviteMoreView h;
    private LiveConnectPKView i;
    private LivePKExitView j;

    public LiveConnectionView(Context context) {
        this(context, null);
    }

    public LiveConnectionView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LiveConnectionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = context;
        w();
    }

    private void w() {
        LayoutInflater from = LayoutInflater.from(this.b);
        this.f14429c = from;
        View inflate = from.inflate(R.layout.live_connection_view, this);
        this.d = (LivePKCenterView) inflate.findViewById(R.id.live_pk_center_view);
        this.e = (LivePKFriendListView) inflate.findViewById(R.id.live_pk_friend_list_view);
        this.f = (LivePKInviteView) inflate.findViewById(R.id.live_pk_invite_view);
        this.g = (LivePKWholeView) inflate.findViewById(R.id.live_pk_whole_view);
        this.h = (LiveConnectInviteMoreView) inflate.findViewById(R.id.live_invite_more);
        this.i = (LiveConnectPKView) inflate.findViewById(R.id.live_connect_pk);
        this.j = (LivePKExitView) inflate.findViewById(R.id.live_pk_exit);
    }

    private void x() {
        this.d.a(this);
        this.e.a(this);
        this.f.a(this);
        this.g.a(this);
        this.h.a(this);
        this.i.a(this);
    }

    @Override // com.blued.android.module.live_china.view.ILiveConnectionStateListener
    public void a() {
        this.f14428a.O();
    }

    public void a(int i, int i2, String str, List<LiveInviteUserModel> list) {
        this.i.a(i, i2, str, list);
    }

    public void a(int i, int i2, String str, List<LiveInviteUserModel> list, List<LiveGroupPkUserModel> list2) {
        this.i.a(i, i2, str, list, list2);
    }

    public void a(RecordingOnliveFragment recordingOnliveFragment) {
        this.f14428a = recordingOnliveFragment;
        x();
    }

    public void a(LiveFriendModel liveFriendModel, boolean z, int i) {
        this.f.a(liveFriendModel, z, i);
    }

    public void a(List<LiveInviteUserModel> list) {
        this.h.a(list);
    }

    public void a(List<LiveInviteUserModel> list, LiveInviteUserModel liveInviteUserModel) {
        this.i.a(list, liveInviteUserModel);
    }

    public void a(boolean z) {
        LivePKInviteView livePKInviteView = this.f;
        if (livePKInviteView != null && livePKInviteView.b()) {
            this.f.c();
            return;
        }
        LivePKCenterView livePKCenterView = this.d;
        if (livePKCenterView != null) {
            livePKCenterView.a(z);
            InstantLog.a("live_interact_btn_click");
        }
    }

    public void a(boolean z, int i) {
        this.e.a(z, i);
    }

    @Override // com.blued.android.module.live_china.view.ILiveConnectionStateListener
    public void b() {
        this.f14428a.P();
    }

    public void b(List<LiveInviteUserModel> list) {
        this.i.a(list);
    }

    public void c() {
        this.g.a();
    }

    public void c(List<LivePKPlayerModel> list) {
        this.j.a(list);
    }

    public void d() {
        this.g.i();
        this.g.j();
        this.g.g();
    }

    public void e() {
        this.f.a((ILiveConnectionAnimListener) null);
    }

    public void f() {
        this.d.e();
    }

    public void g() {
        this.e.k();
    }

    public void h() {
        this.h.a((ILiveConnectionAnimListener) null);
    }

    public void i() {
        this.i.a((ILiveConnectionAnimListener) null);
    }

    public void j() {
        this.i.a();
    }

    public void k() {
        this.i.g();
    }

    public void l() {
        this.h.g();
    }

    public void m() {
        this.i.h();
    }

    public boolean n() {
        return this.g.f();
    }

    public void o() {
        this.g.j();
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0061, code lost:
        if (r2.j.b() != false) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean p() {
        /*
            r2 = this;
            r0 = r2
            com.blued.android.module.live_china.view.LivePKCenterView r0 = r0.d
            r5 = r0
            r0 = 0
            r4 = r0
            r0 = r4
            r3 = r0
            r0 = r5
            if (r0 == 0) goto L66
            r0 = r4
            r3 = r0
            r0 = r2
            com.blued.android.module.live_china.view.LivePKFriendListView r0 = r0.e
            if (r0 == 0) goto L66
            r0 = r2
            com.blued.android.module.live_china.view.LivePKWholeView r0 = r0.g
            if (r0 != 0) goto L1f
            r0 = 0
            return r0
        L1f:
            r0 = r5
            boolean r0 = r0.a()
            if (r0 != 0) goto L64
            r0 = r2
            com.blued.android.module.live_china.view.LivePKFriendListView r0 = r0.e
            boolean r0 = r0.e()
            if (r0 != 0) goto L64
            r0 = r2
            com.blued.android.module.live_china.view.LivePKInviteView r0 = r0.f
            boolean r0 = r0.b()
            if (r0 != 0) goto L64
            r0 = r2
            com.blued.android.module.live_china.view.LivePKWholeView r0 = r0.g
            boolean r0 = r0.f()
            if (r0 != 0) goto L64
            r0 = r2
            com.blued.android.module.live_china.view.LiveConnectInviteMoreView r0 = r0.h
            boolean r0 = r0.b()
            if (r0 != 0) goto L64
            r0 = r2
            com.blued.android.module.live_china.view.LiveConnectPKView r0 = r0.i
            boolean r0 = r0.c()
            if (r0 != 0) goto L64
            r0 = r4
            r3 = r0
            r0 = r2
            com.blued.android.module.live_china.view.LivePKExitView r0 = r0.j
            boolean r0 = r0.b()
            if (r0 == 0) goto L66
        L64:
            r0 = 1
            r3 = r0
        L66:
            r0 = r3
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.live_china.view.LiveConnectionView.p():boolean");
    }

    public void q() {
        LivePKCenterView livePKCenterView = this.d;
        if (livePKCenterView != null && livePKCenterView.a()) {
            this.d.b();
        }
        LivePKFriendListView livePKFriendListView = this.e;
        if (livePKFriendListView != null && livePKFriendListView.e()) {
            this.e.f();
        }
        LivePKInviteView livePKInviteView = this.f;
        if (livePKInviteView != null && livePKInviteView.b()) {
            this.f.a();
        }
        LivePKWholeView livePKWholeView = this.g;
        if (livePKWholeView != null && livePKWholeView.f()) {
            this.g.e();
        }
        LiveConnectInviteMoreView liveConnectInviteMoreView = this.h;
        if (liveConnectInviteMoreView != null && liveConnectInviteMoreView.b()) {
            this.h.a();
        }
        LiveConnectPKView liveConnectPKView = this.i;
        if (liveConnectPKView != null && liveConnectPKView.c()) {
            this.i.f();
        }
        LivePKExitView livePKExitView = this.j;
        if (livePKExitView == null || !livePKExitView.b()) {
            return;
        }
        this.j.a();
    }

    public boolean r() {
        LivePKWholeView livePKWholeView = this.g;
        if (livePKWholeView == null || !(livePKWholeView.f14839a == 4 || this.g.f14839a == 2 || this.g.f14839a == 1)) {
            LivePKInviteView livePKInviteView = this.f;
            if (livePKInviteView != null) {
                return livePKInviteView.b();
            }
            return false;
        }
        return true;
    }

    public void s() {
        this.f.f();
        this.g.d();
    }

    public void setPKCurrentModel(int i) {
        this.g.setCurrentModel(i);
    }

    public void t() {
        RecordingOnliveFragment recordingOnliveFragment = this.f14428a;
        if (recordingOnliveFragment == null || recordingOnliveFragment.ad == null) {
            return;
        }
        this.f14428a.ad.j();
    }

    public void u() {
        RecordingOnliveFragment recordingOnliveFragment = this.f14428a;
        if (recordingOnliveFragment != null && (recordingOnliveFragment.r() || this.f14428a.aR())) {
            this.f14428a.bO.a(0);
        }
        RecordingOnliveFragment recordingOnliveFragment2 = this.f14428a;
        if (recordingOnliveFragment2 != null && recordingOnliveFragment2.aW()) {
            this.h.e();
        }
        RecordingOnliveFragment recordingOnliveFragment3 = this.f14428a;
        if (recordingOnliveFragment3 != null && recordingOnliveFragment3.aX()) {
            this.h.f();
        }
        RecordingOnliveFragment recordingOnliveFragment4 = this.f14428a;
        if (recordingOnliveFragment4 != null && recordingOnliveFragment4.aY()) {
            this.i.b();
        }
        LivePKWholeView livePKWholeView = this.g;
        if (livePKWholeView != null && livePKWholeView.f14839a == 1) {
            this.g.b();
        }
        LivePKInviteView livePKInviteView = this.f;
        if (livePKInviteView != null && livePKInviteView.b()) {
            this.f.d();
        }
        LivePKInviteView livePKInviteView2 = this.f;
        if (livePKInviteView2 != null) {
            livePKInviteView2.f();
        }
        LivePKWholeView livePKWholeView2 = this.g;
        if (livePKWholeView2 != null) {
            livePKWholeView2.d();
        }
    }

    public void v() {
        this.e.j();
    }
}
