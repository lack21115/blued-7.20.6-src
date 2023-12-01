package com.blued.android.module.live_china.observer;

import android.widget.EditText;
import com.blued.android.module.live_china.model.FunctionRedPModelJson;
import com.blued.android.module.live_china.model.GrabBoxModel;
import com.blued.android.module.live_china.model.LiveChattingModel;
import com.blued.android.module.live_china.model.LiveGiftModel;
import com.blued.android.module.live_china.model.LiveGiftWallFloatModel;
import com.blued.android.module.live_china.model.LiveHornModelNew;
import com.blued.android.module.live_china.model.LiveInviteUserModel;
import com.blued.android.module.live_china.model.LiveMakeLoverFansModel;
import com.blued.android.module.live_china.model.LiveRewardModel;
import com.blued.android.module.live_china.model.LiveRoomData;
import com.blued.android.module.live_china.model.LiveRoomOperationModel;
import com.blued.android.module.live_china.model.LiveRoomTipsModel;
import com.blued.android.module.live_china.model.LiveRoomUserModel;
import com.blued.android.module.live_china.model.LiveWishItemModel;
import com.blued.android.module.live_china.model.LiveWishingDrawModel;
import com.blued.android.module.live_china.model.MultiDialogModel;
import com.blued.android.module.live_china.model.MuteLiveAudioModel;
import com.blued.android.module.live_china.model.RelationInfo;
import com.blued.android.module.live_china.msg.SendMsgListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/observer/LiveSetDataObserver.class */
public class LiveSetDataObserver {

    /* renamed from: a  reason: collision with root package name */
    private static LiveSetDataObserver f13951a = new LiveSetDataObserver();
    private ArrayList<ILiveSetDataObserver> b = new ArrayList<>();

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/observer/LiveSetDataObserver$ILiveSetDataObserver.class */
    public interface ILiveSetDataObserver {
        void A();

        void B();

        void B_();

        void C();

        void C_();

        void D();

        void D_();

        void E();

        void E_();

        void F_();

        void G_();

        void H();

        void H_();

        void I();

        void J();

        void K();

        void L();

        void M();

        void N();

        void Q();

        void a(int i, int i2);

        void a(int i, int i2, int i3, float f);

        void a(int i, int i2, int i3, int i4);

        void a(long j);

        void a(EditText editText, boolean z, SendMsgListener sendMsgListener);

        void a(FunctionRedPModelJson functionRedPModelJson);

        void a(LiveChattingModel liveChattingModel);

        void a(LiveGiftModel liveGiftModel);

        void a(LiveGiftWallFloatModel liveGiftWallFloatModel);

        void a(LiveHornModelNew liveHornModelNew, boolean z);

        void a(LiveMakeLoverFansModel liveMakeLoverFansModel);

        void a(LiveRewardModel liveRewardModel);

        void a(LiveRoomData liveRoomData);

        void a(LiveRoomOperationModel liveRoomOperationModel);

        void a(LiveRoomTipsModel liveRoomTipsModel);

        void a(LiveRoomUserModel liveRoomUserModel);

        void a(LiveWishItemModel liveWishItemModel);

        void a(LiveWishingDrawModel liveWishingDrawModel);

        void a(MultiDialogModel multiDialogModel);

        void a(MuteLiveAudioModel muteLiveAudioModel, String str);

        void a(RelationInfo relationInfo);

        void a(String str, int i);

        void a(String str, String str2);

        void a(String str, boolean z);

        void a(List<LiveInviteUserModel> list);

        void a(boolean z);

        void a(boolean z, boolean z2);

        void b(int i);

        void b(LiveChattingModel liveChattingModel);

        void b(LiveGiftModel liveGiftModel);

        void b(LiveRoomData liveRoomData);

        void b(String str, int i);

        void b(List<GrabBoxModel> list);

        void b(boolean z);

        void b_(String str);

        void c(int i);

        void c(LiveChattingModel liveChattingModel);

        void c(LiveGiftModel liveGiftModel);

        void c(String str, int i);

        void c(List<LiveInviteUserModel> list);

        void c(boolean z);

        void c_(String str);

        void d(int i);

        void d(List<LiveInviteUserModel> list);

        void e(int i);

        void e(String str);

        void e(List<LiveInviteUserModel> list);

        void f(int i);

        void f(String str);

        void g(int i);

        void g(String str);

        void h(String str);

        void i();

        void j();

        void o();

        void q();

        void v();

        void w();

        void x();

        void y();

        void z();
    }

    private LiveSetDataObserver() {
    }

    public static LiveSetDataObserver a() {
        return f13951a;
    }

    public void A() {
        synchronized (this) {
            Iterator<ILiveSetDataObserver> it = this.b.iterator();
            while (it.hasNext()) {
                ILiveSetDataObserver next = it.next();
                if (next != null) {
                    next.x();
                }
            }
        }
    }

    public void B() {
        synchronized (this) {
            Iterator<ILiveSetDataObserver> it = this.b.iterator();
            while (it.hasNext()) {
                ILiveSetDataObserver next = it.next();
                if (next != null) {
                    next.y();
                }
            }
        }
    }

    public void C() {
        synchronized (this) {
            Iterator<ILiveSetDataObserver> it = this.b.iterator();
            while (it.hasNext()) {
                ILiveSetDataObserver next = it.next();
                if (next != null) {
                    next.z();
                }
            }
        }
    }

    public void D() {
        synchronized (this) {
            Iterator<ILiveSetDataObserver> it = this.b.iterator();
            while (it.hasNext()) {
                ILiveSetDataObserver next = it.next();
                if (next != null) {
                    next.A();
                }
            }
        }
    }

    public void a(int i) {
        synchronized (this) {
            Iterator<ILiveSetDataObserver> it = this.b.iterator();
            while (it.hasNext()) {
                ILiveSetDataObserver next = it.next();
                if (next != null) {
                    next.g(i);
                }
            }
        }
    }

    public void a(int i, int i2) {
        synchronized (this) {
            Iterator<ILiveSetDataObserver> it = this.b.iterator();
            while (it.hasNext()) {
                ILiveSetDataObserver next = it.next();
                if (next != null) {
                    next.a(i, i2);
                }
            }
        }
    }

    public void a(int i, int i2, int i3, float f) {
        synchronized (this) {
            Iterator<ILiveSetDataObserver> it = this.b.iterator();
            while (it.hasNext()) {
                ILiveSetDataObserver next = it.next();
                if (next != null) {
                    next.a(i, i2, i3, f);
                }
            }
        }
    }

    public void a(int i, int i2, int i3, int i4) {
        synchronized (this) {
            Iterator<ILiveSetDataObserver> it = this.b.iterator();
            while (it.hasNext()) {
                ILiveSetDataObserver next = it.next();
                if (next != null) {
                    next.a(i, i2, i3, i4);
                }
            }
        }
    }

    public void a(long j) {
        synchronized (this) {
            Iterator<ILiveSetDataObserver> it = this.b.iterator();
            while (it.hasNext()) {
                ILiveSetDataObserver next = it.next();
                if (next != null) {
                    next.a(j);
                }
            }
        }
    }

    public void a(EditText editText, boolean z, SendMsgListener sendMsgListener) {
        synchronized (this) {
            Iterator<ILiveSetDataObserver> it = this.b.iterator();
            while (it.hasNext()) {
                ILiveSetDataObserver next = it.next();
                if (next != null) {
                    next.a(editText, z, sendMsgListener);
                }
            }
        }
    }

    public void a(FunctionRedPModelJson functionRedPModelJson) {
        synchronized (this) {
            Iterator<ILiveSetDataObserver> it = this.b.iterator();
            while (it.hasNext()) {
                ILiveSetDataObserver next = it.next();
                if (next != null) {
                    next.a(functionRedPModelJson);
                }
            }
        }
    }

    public void a(LiveChattingModel liveChattingModel) {
        synchronized (this) {
            Iterator<ILiveSetDataObserver> it = this.b.iterator();
            while (it.hasNext()) {
                ILiveSetDataObserver next = it.next();
                if (next != null) {
                    next.c(liveChattingModel);
                }
            }
        }
    }

    public void a(LiveGiftModel liveGiftModel) {
        synchronized (this) {
            Iterator<ILiveSetDataObserver> it = this.b.iterator();
            while (it.hasNext()) {
                ILiveSetDataObserver next = it.next();
                if (next != null) {
                    next.c(liveGiftModel);
                }
            }
        }
    }

    public void a(LiveGiftWallFloatModel liveGiftWallFloatModel) {
        synchronized (this) {
            Iterator<ILiveSetDataObserver> it = this.b.iterator();
            while (it.hasNext()) {
                ILiveSetDataObserver next = it.next();
                if (next != null) {
                    next.a(liveGiftWallFloatModel);
                }
            }
        }
    }

    public void a(LiveHornModelNew liveHornModelNew, boolean z) {
        synchronized (this) {
            Iterator<ILiveSetDataObserver> it = this.b.iterator();
            while (it.hasNext()) {
                ILiveSetDataObserver next = it.next();
                if (next != null) {
                    next.a(liveHornModelNew, z);
                }
            }
        }
    }

    public void a(LiveMakeLoverFansModel liveMakeLoverFansModel) {
        synchronized (this) {
            Iterator<ILiveSetDataObserver> it = this.b.iterator();
            while (it.hasNext()) {
                ILiveSetDataObserver next = it.next();
                if (next != null) {
                    next.a(liveMakeLoverFansModel);
                }
            }
        }
    }

    public void a(LiveRewardModel liveRewardModel) {
        synchronized (this) {
            Iterator<ILiveSetDataObserver> it = this.b.iterator();
            while (it.hasNext()) {
                ILiveSetDataObserver next = it.next();
                if (next != null) {
                    next.a(liveRewardModel);
                }
            }
        }
    }

    public void a(LiveRoomData liveRoomData) {
        synchronized (this) {
            Iterator<ILiveSetDataObserver> it = this.b.iterator();
            while (it.hasNext()) {
                ILiveSetDataObserver next = it.next();
                if (next != null) {
                    next.b(liveRoomData);
                }
            }
        }
    }

    public void a(LiveRoomOperationModel liveRoomOperationModel) {
        synchronized (this) {
            Iterator<ILiveSetDataObserver> it = this.b.iterator();
            while (it.hasNext()) {
                ILiveSetDataObserver next = it.next();
                if (next != null) {
                    next.a(liveRoomOperationModel);
                }
            }
        }
    }

    public void a(LiveRoomTipsModel liveRoomTipsModel) {
        synchronized (this) {
            Iterator<ILiveSetDataObserver> it = this.b.iterator();
            while (it.hasNext()) {
                ILiveSetDataObserver next = it.next();
                if (next != null) {
                    next.a(liveRoomTipsModel);
                }
            }
        }
    }

    public void a(LiveRoomUserModel liveRoomUserModel) {
        synchronized (this) {
            Iterator<ILiveSetDataObserver> it = this.b.iterator();
            while (it.hasNext()) {
                ILiveSetDataObserver next = it.next();
                if (next != null) {
                    next.a(liveRoomUserModel);
                }
            }
        }
    }

    public void a(LiveWishItemModel liveWishItemModel) {
        synchronized (this) {
            Iterator<ILiveSetDataObserver> it = this.b.iterator();
            while (it.hasNext()) {
                ILiveSetDataObserver next = it.next();
                if (next != null) {
                    next.a(liveWishItemModel);
                }
            }
        }
    }

    public void a(LiveWishingDrawModel liveWishingDrawModel) {
        synchronized (this) {
            Iterator<ILiveSetDataObserver> it = this.b.iterator();
            while (it.hasNext()) {
                ILiveSetDataObserver next = it.next();
                if (next != null) {
                    next.a(liveWishingDrawModel);
                }
            }
        }
    }

    public void a(MultiDialogModel multiDialogModel) {
        synchronized (this) {
            Iterator<ILiveSetDataObserver> it = this.b.iterator();
            while (it.hasNext()) {
                ILiveSetDataObserver next = it.next();
                if (next != null) {
                    next.a(multiDialogModel);
                }
            }
        }
    }

    public void a(MuteLiveAudioModel muteLiveAudioModel, String str) {
        synchronized (this) {
            Iterator<ILiveSetDataObserver> it = this.b.iterator();
            while (it.hasNext()) {
                ILiveSetDataObserver next = it.next();
                if (next != null) {
                    next.a(muteLiveAudioModel, str);
                }
            }
        }
    }

    public void a(RelationInfo relationInfo) {
        synchronized (this) {
            Iterator<ILiveSetDataObserver> it = this.b.iterator();
            while (it.hasNext()) {
                ILiveSetDataObserver next = it.next();
                if (next != null) {
                    next.a(relationInfo);
                }
            }
        }
    }

    public void a(ILiveSetDataObserver iLiveSetDataObserver) {
        synchronized (this) {
            if (iLiveSetDataObserver != null) {
                this.b.add(iLiveSetDataObserver);
            }
        }
    }

    public void a(String str) {
        synchronized (this) {
            Iterator<ILiveSetDataObserver> it = this.b.iterator();
            while (it.hasNext()) {
                ILiveSetDataObserver next = it.next();
                if (next != null) {
                    next.c_(str);
                }
            }
        }
    }

    public void a(String str, int i) {
        synchronized (this) {
            Iterator<ILiveSetDataObserver> it = this.b.iterator();
            while (it.hasNext()) {
                ILiveSetDataObserver next = it.next();
                if (next != null) {
                    next.c(str, i);
                }
            }
        }
    }

    public void a(String str, String str2) {
        synchronized (this) {
            Iterator<ILiveSetDataObserver> it = this.b.iterator();
            while (it.hasNext()) {
                ILiveSetDataObserver next = it.next();
                if (next != null) {
                    next.a(str, str2);
                }
            }
        }
    }

    public void a(String str, boolean z) {
        synchronized (this) {
            Iterator<ILiveSetDataObserver> it = this.b.iterator();
            while (it.hasNext()) {
                ILiveSetDataObserver next = it.next();
                if (next != null) {
                    next.a(str, z);
                }
            }
        }
    }

    public void a(List<LiveInviteUserModel> list) {
        synchronized (this) {
            Iterator<ILiveSetDataObserver> it = this.b.iterator();
            while (it.hasNext()) {
                ILiveSetDataObserver next = it.next();
                if (next != null) {
                    next.a(list);
                }
            }
        }
    }

    public void a(boolean z) {
        synchronized (this) {
            Iterator<ILiveSetDataObserver> it = this.b.iterator();
            while (it.hasNext()) {
                ILiveSetDataObserver next = it.next();
                if (next != null) {
                    next.c(z);
                }
            }
        }
    }

    public void a(boolean z, boolean z2) {
        synchronized (this) {
            Iterator<ILiveSetDataObserver> it = this.b.iterator();
            while (it.hasNext()) {
                ILiveSetDataObserver next = it.next();
                if (next != null) {
                    next.a(z, z2);
                }
            }
        }
    }

    public void b() {
        synchronized (this) {
            Iterator<ILiveSetDataObserver> it = this.b.iterator();
            while (it.hasNext()) {
                ILiveSetDataObserver next = it.next();
                if (next != null) {
                    next.E_();
                }
            }
        }
    }

    public void b(int i) {
        synchronized (this) {
            Iterator<ILiveSetDataObserver> it = this.b.iterator();
            while (it.hasNext()) {
                ILiveSetDataObserver next = it.next();
                if (next != null) {
                    next.f(i);
                }
            }
        }
    }

    public void b(LiveChattingModel liveChattingModel) {
        synchronized (this) {
            Iterator<ILiveSetDataObserver> it = this.b.iterator();
            while (it.hasNext()) {
                ILiveSetDataObserver next = it.next();
                if (next != null) {
                    next.a(liveChattingModel);
                }
            }
        }
    }

    public void b(LiveGiftModel liveGiftModel) {
        synchronized (this) {
            Iterator<ILiveSetDataObserver> it = this.b.iterator();
            while (it.hasNext()) {
                ILiveSetDataObserver next = it.next();
                if (next != null) {
                    next.b(liveGiftModel);
                }
            }
        }
    }

    public void b(LiveRoomData liveRoomData) {
        synchronized (this) {
            Iterator<ILiveSetDataObserver> it = this.b.iterator();
            while (it.hasNext()) {
                ILiveSetDataObserver next = it.next();
                if (next != null) {
                    next.a(liveRoomData);
                }
            }
        }
    }

    public void b(ILiveSetDataObserver iLiveSetDataObserver) {
        synchronized (this) {
            if (iLiveSetDataObserver != null) {
                this.b.remove(iLiveSetDataObserver);
            }
        }
    }

    public void b(String str) {
        synchronized (this) {
            Iterator<ILiveSetDataObserver> it = this.b.iterator();
            while (it.hasNext()) {
                ILiveSetDataObserver next = it.next();
                if (next != null) {
                    next.h(str);
                }
            }
        }
    }

    public void b(String str, int i) {
        synchronized (this) {
            Iterator<ILiveSetDataObserver> it = this.b.iterator();
            while (it.hasNext()) {
                ILiveSetDataObserver next = it.next();
                if (next != null) {
                    next.a(str, i);
                }
            }
        }
    }

    public void b(List<LiveInviteUserModel> list) {
        synchronized (this) {
            Iterator<ILiveSetDataObserver> it = this.b.iterator();
            while (it.hasNext()) {
                ILiveSetDataObserver next = it.next();
                if (next != null) {
                    next.c(list);
                }
            }
        }
    }

    public void b(boolean z) {
        synchronized (this) {
            Iterator<ILiveSetDataObserver> it = this.b.iterator();
            while (it.hasNext()) {
                ILiveSetDataObserver next = it.next();
                if (next != null) {
                    next.b(z);
                }
            }
        }
    }

    public void c() {
        synchronized (this) {
            Iterator<ILiveSetDataObserver> it = this.b.iterator();
            while (it.hasNext()) {
                ILiveSetDataObserver next = it.next();
                if (next != null) {
                    next.i();
                }
            }
        }
    }

    public void c(int i) {
        synchronized (this) {
            Iterator<ILiveSetDataObserver> it = this.b.iterator();
            while (it.hasNext()) {
                ILiveSetDataObserver next = it.next();
                if (next != null) {
                    next.e(i);
                }
            }
        }
    }

    public void c(LiveChattingModel liveChattingModel) {
        synchronized (this) {
            Iterator<ILiveSetDataObserver> it = this.b.iterator();
            while (it.hasNext()) {
                ILiveSetDataObserver next = it.next();
                if (next != null) {
                    next.b(liveChattingModel);
                }
            }
        }
    }

    public void c(LiveGiftModel liveGiftModel) {
        synchronized (this) {
            Iterator<ILiveSetDataObserver> it = this.b.iterator();
            while (it.hasNext()) {
                ILiveSetDataObserver next = it.next();
                if (next != null) {
                    next.a(liveGiftModel);
                }
            }
        }
    }

    public void c(String str) {
        synchronized (this) {
            Iterator<ILiveSetDataObserver> it = this.b.iterator();
            while (it.hasNext()) {
                ILiveSetDataObserver next = it.next();
                if (next != null) {
                    next.g(str);
                }
            }
        }
    }

    public void c(String str, int i) {
        synchronized (this) {
            Iterator<ILiveSetDataObserver> it = this.b.iterator();
            while (it.hasNext()) {
                ILiveSetDataObserver next = it.next();
                if (next != null) {
                    next.b(str, i);
                }
            }
        }
    }

    public void c(List<LiveInviteUserModel> list) {
        synchronized (this) {
            Iterator<ILiveSetDataObserver> it = this.b.iterator();
            while (it.hasNext()) {
                ILiveSetDataObserver next = it.next();
                if (next != null) {
                    next.d(list);
                }
            }
        }
    }

    public void c(boolean z) {
        synchronized (this) {
            Iterator<ILiveSetDataObserver> it = this.b.iterator();
            while (it.hasNext()) {
                ILiveSetDataObserver next = it.next();
                if (next != null) {
                    next.a(z);
                }
            }
        }
    }

    public void d() {
        synchronized (this) {
            Iterator<ILiveSetDataObserver> it = this.b.iterator();
            while (it.hasNext()) {
                ILiveSetDataObserver next = it.next();
                if (next != null) {
                    next.H_();
                }
            }
        }
    }

    public void d(int i) {
        synchronized (this) {
            Iterator<ILiveSetDataObserver> it = this.b.iterator();
            while (it.hasNext()) {
                ILiveSetDataObserver next = it.next();
                if (next != null) {
                    next.c(i);
                }
            }
        }
    }

    public void d(String str) {
        synchronized (this) {
            Iterator<ILiveSetDataObserver> it = this.b.iterator();
            while (it.hasNext()) {
                ILiveSetDataObserver next = it.next();
                if (next != null) {
                    next.b_(str);
                }
            }
        }
    }

    public void d(List<LiveInviteUserModel> list) {
        synchronized (this) {
            Iterator<ILiveSetDataObserver> it = this.b.iterator();
            while (it.hasNext()) {
                ILiveSetDataObserver next = it.next();
                if (next != null) {
                    next.e(list);
                }
            }
        }
    }

    public void e() {
        synchronized (this) {
            Iterator<ILiveSetDataObserver> it = this.b.iterator();
            while (it.hasNext()) {
                ILiveSetDataObserver next = it.next();
                if (next != null) {
                    next.j();
                }
            }
        }
    }

    public void e(int i) {
        synchronized (this) {
            Iterator<ILiveSetDataObserver> it = this.b.iterator();
            while (it.hasNext()) {
                ILiveSetDataObserver next = it.next();
                if (next != null) {
                    next.b(i);
                }
            }
        }
    }

    public void e(String str) {
        synchronized (this) {
            Iterator<ILiveSetDataObserver> it = this.b.iterator();
            while (it.hasNext()) {
                ILiveSetDataObserver next = it.next();
                if (next != null) {
                    next.c(str, 0);
                }
            }
        }
    }

    public void e(List<GrabBoxModel> list) {
        synchronized (this) {
            Iterator<ILiveSetDataObserver> it = this.b.iterator();
            while (it.hasNext()) {
                ILiveSetDataObserver next = it.next();
                if (next != null) {
                    next.b(list);
                }
            }
        }
    }

    public void f() {
        synchronized (this) {
            Iterator<ILiveSetDataObserver> it = this.b.iterator();
            while (it.hasNext()) {
                ILiveSetDataObserver next = it.next();
                if (next != null) {
                    next.B_();
                }
            }
        }
    }

    public void f(int i) {
        synchronized (this) {
            Iterator<ILiveSetDataObserver> it = this.b.iterator();
            while (it.hasNext()) {
                ILiveSetDataObserver next = it.next();
                if (next != null) {
                    next.d(i);
                }
            }
        }
    }

    public void f(String str) {
        synchronized (this) {
            Iterator<ILiveSetDataObserver> it = this.b.iterator();
            while (it.hasNext()) {
                ILiveSetDataObserver next = it.next();
                if (next != null) {
                    next.e(str);
                }
            }
        }
    }

    public void g() {
        synchronized (this) {
            Iterator<ILiveSetDataObserver> it = this.b.iterator();
            while (it.hasNext()) {
                ILiveSetDataObserver next = it.next();
                if (next != null) {
                    next.C_();
                }
            }
        }
    }

    public void g(String str) {
        synchronized (this) {
            Iterator<ILiveSetDataObserver> it = this.b.iterator();
            while (it.hasNext()) {
                ILiveSetDataObserver next = it.next();
                if (next != null) {
                    next.f(str);
                }
            }
        }
    }

    public void h() {
        synchronized (this) {
            Iterator<ILiveSetDataObserver> it = this.b.iterator();
            while (it.hasNext()) {
                ILiveSetDataObserver next = it.next();
                if (next != null) {
                    next.L();
                }
            }
        }
    }

    public void i() {
        synchronized (this) {
            Iterator<ILiveSetDataObserver> it = this.b.iterator();
            while (it.hasNext()) {
                ILiveSetDataObserver next = it.next();
                if (next != null) {
                    next.M();
                }
            }
        }
    }

    public void j() {
        synchronized (this) {
            Iterator<ILiveSetDataObserver> it = this.b.iterator();
            while (it.hasNext()) {
                ILiveSetDataObserver next = it.next();
                if (next != null) {
                    next.K();
                }
            }
        }
    }

    public void k() {
        synchronized (this) {
            Iterator<ILiveSetDataObserver> it = this.b.iterator();
            while (it.hasNext()) {
                ILiveSetDataObserver next = it.next();
                if (next != null) {
                    next.D_();
                }
            }
        }
    }

    public void l() {
        synchronized (this) {
            Iterator<ILiveSetDataObserver> it = this.b.iterator();
            while (it.hasNext()) {
                ILiveSetDataObserver next = it.next();
                if (next != null) {
                    next.N();
                }
            }
        }
    }

    public void m() {
        synchronized (this) {
            Iterator<ILiveSetDataObserver> it = this.b.iterator();
            while (it.hasNext()) {
                ILiveSetDataObserver next = it.next();
                if (next != null) {
                    next.Q();
                }
            }
        }
    }

    public void n() {
        synchronized (this) {
            Iterator<ILiveSetDataObserver> it = this.b.iterator();
            while (it.hasNext()) {
                ILiveSetDataObserver next = it.next();
                if (next != null) {
                    next.H();
                }
            }
        }
    }

    public void o() {
        synchronized (this) {
            Iterator<ILiveSetDataObserver> it = this.b.iterator();
            while (it.hasNext()) {
                ILiveSetDataObserver next = it.next();
                if (next != null) {
                    next.E();
                }
            }
        }
    }

    public void p() {
        synchronized (this) {
            Iterator<ILiveSetDataObserver> it = this.b.iterator();
            while (it.hasNext()) {
                ILiveSetDataObserver next = it.next();
                if (next != null) {
                    next.D();
                }
            }
        }
    }

    public void q() {
        synchronized (this) {
            Iterator<ILiveSetDataObserver> it = this.b.iterator();
            while (it.hasNext()) {
                ILiveSetDataObserver next = it.next();
                if (next != null) {
                    next.C();
                }
            }
        }
    }

    public void r() {
        synchronized (this) {
            Iterator<ILiveSetDataObserver> it = this.b.iterator();
            while (it.hasNext()) {
                ILiveSetDataObserver next = it.next();
                if (next != null) {
                    next.B();
                }
            }
        }
    }

    public void s() {
        synchronized (this) {
            Iterator<ILiveSetDataObserver> it = this.b.iterator();
            while (it.hasNext()) {
                ILiveSetDataObserver next = it.next();
                if (next != null) {
                    next.q();
                }
            }
        }
    }

    public void t() {
        synchronized (this) {
            Iterator<ILiveSetDataObserver> it = this.b.iterator();
            while (it.hasNext()) {
                ILiveSetDataObserver next = it.next();
                if (next != null) {
                    next.G_();
                }
            }
        }
    }

    public void u() {
        synchronized (this) {
            Iterator<ILiveSetDataObserver> it = this.b.iterator();
            while (it.hasNext()) {
                ILiveSetDataObserver next = it.next();
                if (next != null) {
                    next.F_();
                }
            }
        }
    }

    public void v() {
        synchronized (this) {
            Iterator<ILiveSetDataObserver> it = this.b.iterator();
            while (it.hasNext()) {
                ILiveSetDataObserver next = it.next();
                if (next != null) {
                    next.o();
                }
            }
        }
    }

    public void w() {
        synchronized (this) {
            Iterator<ILiveSetDataObserver> it = this.b.iterator();
            while (it.hasNext()) {
                ILiveSetDataObserver next = it.next();
                if (next != null) {
                    next.I();
                }
            }
        }
    }

    public void x() {
        synchronized (this) {
            Iterator<ILiveSetDataObserver> it = this.b.iterator();
            while (it.hasNext()) {
                ILiveSetDataObserver next = it.next();
                if (next != null) {
                    next.J();
                }
            }
        }
    }

    public void y() {
        synchronized (this) {
            Iterator<ILiveSetDataObserver> it = this.b.iterator();
            while (it.hasNext()) {
                ILiveSetDataObserver next = it.next();
                if (next != null) {
                    next.v();
                }
            }
        }
    }

    public void z() {
        synchronized (this) {
            Iterator<ILiveSetDataObserver> it = this.b.iterator();
            while (it.hasNext()) {
                ILiveSetDataObserver next = it.next();
                if (next != null) {
                    next.w();
                }
            }
        }
    }
}
