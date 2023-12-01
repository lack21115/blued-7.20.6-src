package com.blued.android.module.live_china.manager;

import android.content.Context;
import android.text.TextUtils;
import android.widget.FrameLayout;
import com.blued.android.core.AppInfo;
import com.blued.android.core.ui.StatusBarHelper;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.common.utils.ToastUtils;
import com.blued.android.module.live_china.fragment.PlayingOnliveFragment;
import com.blued.android.module.live_china.model.LiveInviteUserModel;
import com.blued.android.module.live_china.model.RelationInfo;
import com.blued.android.module.live_china.observer.LiveSetDataObserver;
import com.jeremyliao.liveeventbus.LiveEventBus;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/manager/PlayingMultiConnectionManager.class */
public class PlayingMultiConnectionManager {

    /* renamed from: a  reason: collision with root package name */
    public static int f13685a = 0;
    public static double b = 0.85d;

    /* renamed from: c  reason: collision with root package name */
    public static int f13686c;
    public static int e;
    public static int f;
    public static int g;
    List<LiveInviteUserModel> d = new ArrayList();
    private Context h;
    private PlayingOnliveFragment i;

    public PlayingMultiConnectionManager(PlayingOnliveFragment playingOnliveFragment) {
        this.i = playingOnliveFragment;
        this.h = playingOnliveFragment.getContext();
        e = AppInfo.l / 2;
        int i = (int) (AppInfo.l * b);
        f = i;
        g = i / 2;
        f13685a = DensityUtils.a(this.h, 148);
        f13686c = StatusBarHelper.a() ? f13685a - StatusBarHelper.a((Context) playingOnliveFragment.getActivity()) : f13685a;
    }

    private void e(List<LiveInviteUserModel> list) {
        if (list != null) {
            this.d.clear();
            this.d.addAll(list);
        } else {
            this.d.clear();
        }
        int i = 0;
        if (this.d.size() > 4) {
            ArrayList arrayList = new ArrayList();
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= 4) {
                    break;
                }
                arrayList.add(this.d.get(i3));
                i2 = i3 + 1;
            }
            this.d.clear();
            this.d.addAll(arrayList);
            i = 0;
        }
        while (i < this.d.size()) {
            if (this.d.get(i) == null) {
                this.d.set(i, new LiveInviteUserModel());
            }
            i++;
        }
    }

    public void a() {
        this.i.d_(0);
        this.i.aN.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.i.bf.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        LiveFloatManager.a().a(AppInfo.l, this.i.bc());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.i.N.setLayoutParams(layoutParams);
    }

    public void a(LiveInviteUserModel liveInviteUserModel) {
        int i;
        int i2;
        ToastUtils.a("退出多人PK\n" + System.currentTimeMillis());
        if (this.d == null || liveInviteUserModel == null) {
            return;
        }
        int i3 = 0;
        if (liveInviteUserModel.is_multi_pk_end == 0) {
            if (TextUtils.equals(liveInviteUserModel.uid, LiveRoomManager.a().g())) {
                this.i.Y();
                return;
            }
            while (true) {
                i2 = -1;
                if (i3 >= this.d.size()) {
                    break;
                } else if (TextUtils.equals(this.d.get(i3).uid, liveInviteUserModel.uid)) {
                    i2 = i3;
                    break;
                } else {
                    i3++;
                }
            }
            if (i2 >= 0) {
                this.d.remove(i2);
            }
            LiveSetDataObserver.a().a(this.d);
        } else if (liveInviteUserModel.is_multi_pk_end == 1) {
            this.i.Y();
        } else if (liveInviteUserModel.is_multi_pk_end != 2) {
        } else {
            if (TextUtils.equals(liveInviteUserModel.uid, LiveRoomManager.a().g())) {
                this.i.Y();
                return;
            }
            int i4 = 0;
            while (true) {
                int i5 = i4;
                i = -1;
                if (i5 >= this.d.size()) {
                    break;
                } else if (TextUtils.equals(this.d.get(i5).uid, liveInviteUserModel.uid)) {
                    i = i5;
                    break;
                } else {
                    i4 = i5 + 1;
                }
            }
            if (i >= 0) {
                this.d.remove(i);
            }
            int i6 = 0;
            while (true) {
                int i7 = i6;
                if (i7 >= this.d.size()) {
                    LiveSetDataObserver.a().a(this.d);
                    LiveEventBus.get("live_multi_pk_stop").post(true);
                    return;
                }
                if (this.d.get(i7) != null) {
                    this.d.get(i7).status = 0;
                }
                i6 = i7 + 1;
            }
        }
    }

    public void a(RelationInfo relationInfo) {
        LiveSetDataObserver.a().a(relationInfo);
    }

    public void a(List<LiveInviteUserModel> list) {
        e(list);
        if (this.d.size() < 2) {
            return;
        }
        this.i.d_(10);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(AppInfo.l, f);
        layoutParams.setMargins(0, f13685a, 0, 0);
        this.i.aN.setLayoutParams(layoutParams);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams2.setMargins(0, f13685a, 0, 0);
        this.i.bf.setLayoutParams(layoutParams2);
        LiveFloatManager.a().a(AppInfo.l, f);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(AppInfo.l, f);
        layoutParams3.topMargin = PlayingMakeFriendManager.b;
        this.i.N.setLayoutParams(layoutParams3);
    }

    public void a(List<LiveInviteUserModel> list, LiveInviteUserModel liveInviteUserModel) {
        e(list);
    }

    public void b() {
        this.d = RecordingMultiConnectionManager.e(this.d);
        this.i.d_(10);
        LiveRoomManager.a().p().link_type = 5;
        LiveSetDataObserver.a().d();
    }

    public void b(List<LiveInviteUserModel> list) {
        List<LiveInviteUserModel> a2 = RecordingMultiConnectionManager.a(list, this.d);
        this.d = a2;
        if (a2 == null || a2.size() <= 0 || !this.d.get(0).isGroup()) {
            this.i.d_(12);
        } else {
            this.i.d_(13);
        }
        LiveRoomManager.a().p().link_type = 7;
        LiveSetDataObserver.a().b(this.d);
    }

    public void c(List<LiveInviteUserModel> list) {
        this.d = RecordingMultiConnectionManager.b(list, this.d);
        LiveSetDataObserver.a().c(this.d);
    }

    public void d(List<LiveInviteUserModel> list) {
        this.d = RecordingMultiConnectionManager.c(list, this.d);
        LiveSetDataObserver.a().d(this.d);
    }
}
