package com.blued.android.module.yy_china.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.Observer;
import com.blued.android.module.live.base.manager.YYMusicManager;
import com.blued.android.module.live.base.music.BackgroundMusicView;
import com.blued.android.module.live.base.music.BlackMusicListener;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.databinding.FragmentYyBackgroundMusicBinding;
import com.jeremyliao.liveeventbus.LiveEventBus;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYBackgroundMusicDialog.class */
public final class YYBackgroundMusicDialog extends BaseFullScreenDialog {

    /* renamed from: a  reason: collision with root package name */
    private BlackMusicListener f17105a;
    private BackgroundMusicView b;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYBackgroundMusicDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYBackgroundMusicDialog this$0, String str) {
        Intrinsics.e(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(YYBackgroundMusicDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    public final void a(BackgroundMusicView backgroundMusicView) {
        this.b = backgroundMusicView;
    }

    public final void a(BlackMusicListener blackMusicListener) {
        this.f17105a = blackMusicListener;
    }

    public final BackgroundMusicView f() {
        return this.b;
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.e(inflater, "inflater");
        YYMusicManager.f11418a.c().a(false, "", "");
        View inflate = getLayoutInflater().inflate(R.layout.fragment_yy_background_music, (ViewGroup) null);
        FragmentYyBackgroundMusicBinding a2 = FragmentYyBackgroundMusicBinding.a(inflate);
        Intrinsics.c(a2, "bind(view)");
        BlackMusicListener blackMusicListener = this.f17105a;
        if (blackMusicListener != null) {
            Context context = inflate.getContext();
            Intrinsics.c(context, "view.context");
            a(new BackgroundMusicView(context, blackMusicListener, this, a()));
            BackgroundMusicView f = f();
            if (f != null) {
                f.setDissListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYBackgroundMusicDialog$TnxYi-FvfSf50hv8VZu9mnAyCnI
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        YYBackgroundMusicDialog.a(YYBackgroundMusicDialog.this, view);
                    }
                });
            }
            a2.f16491a.addView(f(), -1, -1);
            BackgroundMusicView f2 = f();
            if (f2 != null) {
                f2.a();
            }
            BackgroundMusicView f3 = f();
            if (f3 != null) {
                f3.b();
            }
            LiveEventBus.get("show_music_close", String.class).observe(this, new Observer() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYBackgroundMusicDialog$uk-OycvhYjgZV7ipTAqqjJdhVgA
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    YYBackgroundMusicDialog.a(YYBackgroundMusicDialog.this, (String) obj);
                }
            });
        }
        if (this.f17105a == null) {
            a2.f16491a.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYBackgroundMusicDialog$t-VvbAY9-L9u_WXrqV4d_k2tyXk
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    YYBackgroundMusicDialog.b(YYBackgroundMusicDialog.this, view);
                }
            });
        }
        return inflate;
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        BackgroundMusicView backgroundMusicView = this.b;
        if (backgroundMusicView != null) {
            backgroundMusicView.f();
        }
        LiveEventBus.get("inner_fragment_close").post("");
    }
}
