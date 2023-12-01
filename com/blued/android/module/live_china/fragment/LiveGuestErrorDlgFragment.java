package com.blued.android.module.live_china.fragment;

import android.os.CountDownTimer;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.anythink.expressad.video.module.a.a.m;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.manager.LiveDataListManager;
import com.blued.android.module.live_china.manager.LiveFloatManager;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.utils.log.InstantLog;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveGuestErrorDlgFragment.class */
public class LiveGuestErrorDlgFragment extends com.blued.android.module.common.fragment.LiveBaseDialogFragment {
    public TextView j;
    public PlayingOnliveFragment k;
    public ImageView l;
    private String m;
    private TextView n;
    private CountDownTimer o;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(View view) {
    }

    private void l() {
        n();
        LiveFloatManager.a().b(false);
        LiveFloatManager.a().n();
        if (getTargetFragment() == null || !(getTargetFragment() instanceof PlayingOnliveFragment)) {
            return;
        }
        ((PlayingOnliveFragment) getTargetFragment()).T();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        if (this.k == null) {
            LiveFloatManager.a().n();
            return;
        }
        InstantLog.a("live_room_slide");
        this.k.aT.setVisibility(8);
        LiveFloatManager.a().b(false);
        if (!LiveDataListManager.a().a(getContext(), this.k.t, 0, "live_end_recommend")) {
            LiveFloatManager.a().n();
        }
        this.k.T();
        getActivity().overridePendingTransition(0, 0);
    }

    private void n() {
        CountDownTimer countDownTimer = this.o;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.o = null;
        }
    }

    public void a(PlayingOnliveFragment playingOnliveFragment) {
        this.k = playingOnliveFragment;
    }

    @Override // com.blued.android.module.common.fragment.LiveBaseDialogFragment
    public int d() {
        return R.layout.fragment_live_guest_error;
    }

    @Override // com.blued.android.module.common.fragment.LiveBaseDialogFragment
    public void e() {
        this.b.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveGuestErrorDlgFragment$QNJv7_d-u5cJGMnhcmfWDJdbyYo
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveGuestErrorDlgFragment.b(view);
            }
        });
        this.j = (TextView) this.b.findViewById(R.id.live_guest_error_tv);
        this.l = (ImageView) this.b.findViewById(R.id.background_header);
        this.j.setText(this.m);
        this.b.findViewById(R.id.live_guest_error_btn).setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveGuestErrorDlgFragment$itYW2zILfrlabKI8_lmwkSSDET4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveGuestErrorDlgFragment.this.a(view);
            }
        });
        this.n = (TextView) this.b.findViewById(R.id.tv_error_finish_countdown_tips);
        if (LiveDataListManager.a().b().size() <= 1) {
            this.n.setVisibility(8);
            return;
        }
        this.n.setVisibility(0);
        k();
    }

    @Override // com.blued.android.module.common.fragment.LiveBaseDialogFragment
    public void f() {
        this.m = this.f10822c.getString("msg_text");
    }

    @Override // com.blued.android.module.common.fragment.LiveBaseDialogFragment
    public void g() {
        super.g();
        ImageLoader.a(a(), LiveRoomManager.a().p().profile.avatar).d().a(this.l);
    }

    public void k() {
        n();
        this.o = new CountDownTimer(m.ag, 1000L) { // from class: com.blued.android.module.live_china.fragment.LiveGuestErrorDlgFragment.1
            @Override // android.os.CountDownTimer
            public void onFinish() {
                LogUtils.d("pLog", "000 倒计时结束---");
                LiveGuestErrorDlgFragment.this.m();
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j) {
                if (LiveGuestErrorDlgFragment.this.n != null) {
                    LiveGuestErrorDlgFragment.this.n.setText(String.format(AppInfo.d().getString(R.string.live_error_finish_auto_next_tips), String.valueOf(j / 1000)));
                }
            }
        }.start();
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment, com.blued.android.core.ui.BaseFragmentActivity.IOnBackPressedListener
    public boolean onBackPressed() {
        l();
        return true;
    }

    @Override // com.blued.android.module.common.fragment.LiveBaseDialogFragment, com.blued.android.core.ui.BaseDialogFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        n();
    }
}
