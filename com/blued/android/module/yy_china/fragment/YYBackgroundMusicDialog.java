package com.blued.android.module.yy_china.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
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
    private BlackMusicListener a;
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
        this.a = blackMusicListener;
    }

    public final BackgroundMusicView f() {
        return this.b;
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.e(inflater, "inflater");
        YYMusicManager.a.c().a(false, "", "");
        View inflate = getLayoutInflater().inflate(R.layout.fragment_yy_background_music, (ViewGroup) null);
        FragmentYyBackgroundMusicBinding a = FragmentYyBackgroundMusicBinding.a(inflate);
        Intrinsics.c(a, "bind(view)");
        BlackMusicListener blackMusicListener = this.a;
        if (blackMusicListener != null) {
            Context context = inflate.getContext();
            Intrinsics.c(context, "view.context");
            a(new BackgroundMusicView(context, blackMusicListener, (Fragment) this, a()));
            BackgroundMusicView f = f();
            if (f != null) {
                f.setDissListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYBackgroundMusicDialog$TnxYi-FvfSf50hv8VZu9mnAyCnI
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        YYBackgroundMusicDialog.a(YYBackgroundMusicDialog.this, view);
                    }
                });
            }
            a.a.addView(f(), -1, -1);
            BackgroundMusicView f2 = f();
            if (f2 != null) {
                f2.a();
            }
            BackgroundMusicView f3 = f();
            if (f3 != null) {
                f3.b();
            }
            LiveEventBus.get("show_music_close", String.class).observe((LifecycleOwner) this, new Observer() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYBackgroundMusicDialog$uk-OycvhYjgZV7ipTAqqjJdhVgA
                public final void onChanged(Object obj) {
                    YYBackgroundMusicDialog.a(YYBackgroundMusicDialog.this, (String) obj);
                }
            });
        }
        if (this.a == null) {
            a.a.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYBackgroundMusicDialog$t-VvbAY9-L9u_WXrqV4d_k2tyXk
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    YYBackgroundMusicDialog.b(YYBackgroundMusicDialog.this, view);
                }
            });
        }
        return inflate;
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment
    public void onDestroy() {
        super.onDestroy();
        BackgroundMusicView backgroundMusicView = this.b;
        if (backgroundMusicView != null) {
            backgroundMusicView.f();
        }
        LiveEventBus.get("inner_fragment_close").post("");
    }
}
