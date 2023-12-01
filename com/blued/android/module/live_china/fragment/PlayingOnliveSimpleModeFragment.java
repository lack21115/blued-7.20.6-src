package com.blued.android.module.live_china.fragment;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import com.blued.android.framework.utils.KeyboardUtils;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.model.LiveChattingModel;
import com.blued.android.module.live_china.model.LiveGiftModel;
import com.blued.android.module.live_china.model.LiveHornModelNew;
import com.blued.android.module.live_china.model.LiveRoomUserModel;
import com.blued.android.module.live_china.msg.LiveMsgSendManager;
import com.blued.android.module.live_china.msg.SendMsgListener;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/PlayingOnliveSimpleModeFragment.class */
public class PlayingOnliveSimpleModeFragment extends PlayingOnliveBaseModeFragment {
    public static PlayingOnliveSimpleModeFragment a(short s, long j) {
        return new PlayingOnliveSimpleModeFragment();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ad() {
        if (this.v) {
            return;
        }
        G();
    }

    @Override // com.blued.android.module.live_china.fragment.PlayingOnliveBaseModeFragment, com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void D() {
        super.D();
        this.d.setVisibility(0);
        this.q.d(0);
        this.m.setVisibility(0);
    }

    @Override // com.blued.android.module.live_china.fragment.PlayingOnliveBaseModeFragment, com.blued.android.module.live_china.manager.PlayGifObserver.IPlayGifObserver
    public void F() {
        if (PlayingOnliveFragment.cB != 0 || this.v) {
            return;
        }
        postSafeRunOnUiThread(new Runnable() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$PlayingOnliveSimpleModeFragment$4llJZxTqLHhszTOBF_4ydC5VK3o
            @Override // java.lang.Runnable
            public final void run() {
                PlayingOnliveSimpleModeFragment.this.ad();
            }
        });
    }

    @Override // com.blued.android.module.live_china.fragment.PlayingOnliveBaseModeFragment, com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void H() {
        if (PlayingOnliveFragment.cB == 0) {
            LiveMsgSendManager.a().e();
            LiveRoomHttpUtils.a(String.valueOf(this.s));
        }
    }

    @Override // com.blued.android.module.live_china.fragment.PlayingOnliveBaseModeFragment, com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void N() {
        super.N();
        if (PlayingOnliveFragment.cB != 0 || LiveRoomManager.a().t()) {
            return;
        }
        LiveRoomInfo a2 = LiveRoomInfo.a();
        Context context = this.f13292a;
        String g = LiveRoomManager.a().g();
        a2.a(context, this, g, "liveanchor_" + this.s, getFragmentActive());
    }

    @Override // com.blued.android.module.live_china.fragment.PlayingOnliveBaseModeFragment, com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void a(EditText editText, boolean z, SendMsgListener sendMsgListener) {
        super.a(editText, z, sendMsgListener);
        if (PlayingOnliveFragment.cB == 0) {
            LiveMsgSendManager.a().a(editText.getText().toString(), z, sendMsgListener);
        }
    }

    @Override // com.blued.android.module.live_china.fragment.PlayingOnliveBaseModeFragment, com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void a(LiveChattingModel liveChattingModel) {
        if (PlayingOnliveFragment.cB == 0) {
            this.q.c(liveChattingModel);
        }
    }

    @Override // com.blued.android.module.live_china.fragment.PlayingOnliveBaseModeFragment, com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void a(LiveHornModelNew liveHornModelNew, boolean z) {
        super.a(liveHornModelNew, z);
        if (PlayingOnliveFragment.cB != 0 || liveHornModelNew == null) {
            return;
        }
        if (liveHornModelNew.position == 1) {
            if (this.m != null) {
                this.m.a(liveHornModelNew, z);
            }
        } else if (liveHornModelNew.position != 2 || this.n == null) {
        } else {
            this.n.a(liveHornModelNew);
        }
    }

    @Override // com.blued.android.module.live_china.fragment.PlayingOnliveBaseModeFragment, com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void a(LiveRoomUserModel liveRoomUserModel) {
        if (this.q == null || this.aj) {
            return;
        }
        this.q.a(liveRoomUserModel);
    }

    @Override // com.blued.android.module.live_china.fragment.PlayingOnliveBaseModeFragment, com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void a(boolean z) {
        super.a(z);
        this.q.d(0);
        this.d.setVisibility(8);
        this.m.setVisibility(8);
    }

    @Override // com.blued.android.module.live_china.fragment.PlayingOnliveBaseModeFragment, com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void b(LiveChattingModel liveChattingModel) {
        int i = PlayingOnliveFragment.cB;
    }

    @Override // com.blued.android.module.live_china.fragment.PlayingOnliveBaseModeFragment, com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void b(LiveGiftModel liveGiftModel) {
        if (PlayingOnliveFragment.cB == 0) {
            this.q.e(liveGiftModel);
        }
    }

    @Override // com.blued.android.module.live_china.fragment.PlayingOnliveBaseModeFragment, com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void b(boolean z) {
        if (PlayingOnliveFragment.cB == 0) {
            this.q.c(z);
        }
    }

    @Override // com.blued.android.module.live_china.fragment.PlayingOnliveBaseModeFragment
    protected boolean b() {
        return PlayingOnliveFragment.cB == 0;
    }

    @Override // com.blued.android.module.live_china.fragment.PlayingOnliveBaseModeFragment, com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void c(LiveGiftModel liveGiftModel) {
        if (PlayingOnliveFragment.cB == 0) {
            d(liveGiftModel);
        }
    }

    @Override // com.blued.android.module.live_china.fragment.PlayingOnliveBaseModeFragment
    public void f() {
        super.f();
        if (this.aQ != null) {
            this.aQ.setVisibility(8);
        }
    }

    @Override // com.blued.android.module.live_china.fragment.PlayingOnliveBaseModeFragment, com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void g(String str) {
        super.g(str);
        if (PlayingOnliveFragment.cB == 0) {
            LiveMsgSendManager.a().a(str);
        }
    }

    @Override // com.blued.android.module.live_china.fragment.PlayingOnliveBaseModeFragment, com.blued.android.module.live_china.observer.LiveSetDataObserver.ILiveSetDataObserver
    public void h(String str) {
        super.h(str);
        if (!TextUtils.isEmpty(str) && PlayingOnliveFragment.cB == 0) {
            String str2 = this.S.getText().toString() + "@" + str + " ";
            int length = str2.length();
            this.S.setText(str2);
            this.S.setSelection(length);
            postDelaySafeRunOnUiThread(new Runnable() { // from class: com.blued.android.module.live_china.fragment.PlayingOnliveSimpleModeFragment.1
                @Override // java.lang.Runnable
                public void run() {
                    if (PlayingOnliveSimpleModeFragment.this.S != null) {
                        PlayingOnliveSimpleModeFragment.this.S.setFocusableInTouchMode(true);
                        PlayingOnliveSimpleModeFragment.this.S.requestFocus();
                    }
                    KeyboardUtils.c(PlayingOnliveSimpleModeFragment.this.getActivity());
                }
            }, 500L);
        }
    }

    @Override // com.blued.android.module.live_china.fragment.PlayingOnliveBaseModeFragment, com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.aj = true;
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    @Override // com.blued.android.module.live_china.fragment.PlayingOnliveBaseModeFragment, com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.q.a(8);
        this.l.setVisibility(4);
        this.q.c(false);
        if (this.P != null) {
            this.P.setVisibility(8);
        }
        if (this.aT != null) {
            this.aT.setIsSimpleModel(true);
        }
    }
}
