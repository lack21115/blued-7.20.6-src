package com.blued.android.module.live_china.fragment;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.blued.android.module.live.base.manager.YYMusicManager;
import com.blued.android.module.live.base.music.BackgroundMusicView;
import com.blued.android.module.live.base.music.BlackMusicListener;
import com.blued.android.module.live.base.music.model.LiveMusicModel;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.databinding.FragmentLiveBackgroundMusicBinding;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.das.client.chatroom.ChatRoomProtos;
import com.blued.das.live.LiveProtos;
import com.tencent.txcopyrightedmedia.ITXCMMusicTrack;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveBackgroundMusicDialog.class */
public final class LiveBackgroundMusicDialog extends BaseFullScreenDialog {
    private BlackMusicListener a;
    private LiveBackgroundMusicDialog$defaultCallBack$1 b;

    public LiveBackgroundMusicDialog() {
        this(null);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [com.blued.android.module.live_china.fragment.LiveBackgroundMusicDialog$defaultCallBack$1] */
    public LiveBackgroundMusicDialog(BlackMusicListener blackMusicListener) {
        this.a = blackMusicListener;
        this.b = new BlackMusicListener() { // from class: com.blued.android.module.live_china.fragment.LiveBackgroundMusicDialog$defaultCallBack$1
            @Override // com.blued.android.module.live.base.music.BlackMusicListener
            public void J_() {
            }

            @Override // com.blued.android.module.live.base.music.BlackMusicListener
            public void K_() {
            }

            @Override // com.blued.android.module.live.base.music.BlackMusicListener
            public void L_() {
            }

            @Override // com.blued.android.module.live.base.music.BlackMusicListener
            public void a() {
            }

            @Override // com.blued.android.module.live.base.music.BlackMusicListener
            public void a(LiveMusicModel liveMusicModel) {
            }

            @Override // com.blued.android.module.live.base.music.BlackMusicListener
            public void a(ChatRoomProtos.Event event, LiveProtos.Event event2, String str, String str2) {
            }

            @Override // com.blued.android.module.live.base.music.BlackMusicListener
            public void a(ChatRoomProtos.Event event, LiveProtos.Event event2, String str, String str2, String str3) {
            }

            @Override // com.blued.android.module.live.base.music.BlackMusicListener
            public void a(ChatRoomProtos.Event event, LiveProtos.Event event2, String str, String str2, String str3, int i) {
            }

            @Override // com.blued.android.module.live.base.music.BlackMusicListener
            public void a(ITXCMMusicTrack iTXCMMusicTrack) {
            }

            @Override // com.blued.android.module.live.base.music.BlackMusicListener
            public void a(String str) {
            }

            @Override // com.blued.android.module.live.base.music.BlackMusicListener
            public void b(String str) {
            }

            @Override // com.blued.android.module.live.base.music.BlackMusicListener
            public void c() {
            }

            @Override // com.blued.android.module.live.base.music.BlackMusicListener
            public void d() {
            }

            @Override // com.blued.android.module.live.base.music.BlackMusicListener
            public String f() {
                return "";
            }

            @Override // com.blued.android.module.live.base.music.BlackMusicListener
            public void g() {
            }

            @Override // com.blued.android.module.live.base.music.BlackMusicListener
            public void h() {
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LiveBackgroundMusicDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        if (this$0.f()) {
            this$0.dismissAllowingStateLoss();
        }
    }

    public final boolean f() {
        if (getDialog() != null) {
            Dialog dialog = getDialog();
            Intrinsics.a(dialog);
            return dialog.isShowing();
        }
        return false;
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.e(inflater, "inflater");
        YYMusicManager.a.c().a(true, LiveRoomManager.a().c(), LiveRoomManager.a().b());
        View inflate = getLayoutInflater().inflate(R.layout.fragment_live_background_music, (ViewGroup) null);
        FragmentLiveBackgroundMusicBinding a = FragmentLiveBackgroundMusicBinding.a(inflate);
        Intrinsics.c(a, "bind(view)");
        if (this.a == null) {
            this.a = this.b;
        }
        Context context = inflate.getContext();
        Intrinsics.c(context, "view.context");
        BlackMusicListener blackMusicListener = this.a;
        Intrinsics.a(blackMusicListener);
        BackgroundMusicView backgroundMusicView = new BackgroundMusicView(context, blackMusicListener, (Fragment) this, a());
        backgroundMusicView.setDissListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveBackgroundMusicDialog$RsurlEDLE31dkLDUkAnTXRAD2M0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveBackgroundMusicDialog.a(LiveBackgroundMusicDialog.this, view);
            }
        });
        a.a.addView(backgroundMusicView, -1, -1);
        backgroundMusicView.a();
        backgroundMusicView.b();
        return inflate;
    }
}
