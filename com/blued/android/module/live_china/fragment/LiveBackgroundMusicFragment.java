package com.blued.android.module.live_china.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.fragment.app.Fragment;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.module.live.base.manager.YYMusicManager;
import com.blued.android.module.live.base.music.BackgroundMusicView;
import com.blued.android.module.live.base.music.BlackMusicListener;
import com.blued.android.module.live.base.music.model.LiveMusicModel;
import com.blued.android.module.live_china.databinding.FragmentLiveBackgroundMusicBinding;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.das.client.chatroom.ChatRoomProtos;
import com.blued.das.live.LiveProtos;
import com.tencent.txcopyrightedmedia.ITXCMMusicTrack;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveBackgroundMusicFragment.class */
public final class LiveBackgroundMusicFragment extends BaseFragment {
    private BlackMusicListener a;
    private final Lazy b;
    private BackgroundMusicView c;
    private LiveBackgroundMusicFragment$defaultCallBack$1 d;

    public LiveBackgroundMusicFragment() {
        this(null);
    }

    /* JADX WARN: Type inference failed for: r1v4, types: [com.blued.android.module.live_china.fragment.LiveBackgroundMusicFragment$defaultCallBack$1] */
    public LiveBackgroundMusicFragment(BlackMusicListener blackMusicListener) {
        this.a = blackMusicListener;
        this.b = LazyKt.a(new Function0<FragmentLiveBackgroundMusicBinding>() { // from class: com.blued.android.module.live_china.fragment.LiveBackgroundMusicFragment$vb$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: a */
            public final FragmentLiveBackgroundMusicBinding invoke() {
                return FragmentLiveBackgroundMusicBinding.a(LayoutInflater.from(LiveBackgroundMusicFragment.this.getContext()));
            }
        });
        this.d = new BlackMusicListener() { // from class: com.blued.android.module.live_china.fragment.LiveBackgroundMusicFragment$defaultCallBack$1
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
    public static final void a(LiveBackgroundMusicFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        if (this$0.b()) {
            this$0.c();
        }
    }

    private final FragmentLiveBackgroundMusicBinding d() {
        return (FragmentLiveBackgroundMusicBinding) this.b.getValue();
    }

    public final void a() {
        if (this.a == null) {
            this.a = this.d;
        }
        if (getContext() != null) {
            YYMusicManager.a.c().a(true, LiveRoomManager.a().c(), LiveRoomManager.a().b());
            Context requireContext = requireContext();
            Intrinsics.c(requireContext, "requireContext()");
            BlackMusicListener blackMusicListener = this.a;
            Intrinsics.a(blackMusicListener);
            BackgroundMusicView backgroundMusicView = new BackgroundMusicView(requireContext, blackMusicListener, this, getFragmentActive());
            this.c = backgroundMusicView;
            if (backgroundMusicView != null) {
                backgroundMusicView.setDissListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveBackgroundMusicFragment$8OyT0_BIsN8PtXLELCvjXkRGSZ8
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        LiveBackgroundMusicFragment.a(LiveBackgroundMusicFragment.this, view);
                    }
                });
            }
            d().a.removeAllViews();
            d().a.addView(this.c, -1, -1);
            BackgroundMusicView backgroundMusicView2 = this.c;
            if (backgroundMusicView2 != null) {
                backgroundMusicView2.a();
            }
            BackgroundMusicView backgroundMusicView3 = this.c;
            if (backgroundMusicView3 == null) {
                return;
            }
            backgroundMusicView3.b();
        }
    }

    public final boolean b() {
        return (isHidden() || getFragmentActive() == null || !getFragmentActive().isActive()) ? false : true;
    }

    public final void c() {
        if (getParentFragment() instanceof RecordingOnliveFragment) {
            Fragment parentFragment = getParentFragment();
            if (parentFragment == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.blued.android.module.live_china.fragment.RecordingOnliveFragment");
            }
            ((RecordingOnliveFragment) parentFragment).bj();
        }
    }

    @Override // com.blued.android.core.ui.BaseFragment, com.blued.android.core.ui.BaseFragmentActivity.IOnBackPressedListener
    public boolean onBackPressed() {
        if (b()) {
            c();
            return true;
        }
        return false;
    }

    @Override // com.blued.android.core.ui.BaseFragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.e(inflater, "inflater");
        if (d().getRoot().getParent() instanceof ViewGroup) {
            ViewParent parent = d().getRoot().getParent();
            if (parent == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
            }
            ((ViewGroup) parent).removeView(d().getRoot());
        }
        a();
        return d().getRoot();
    }

    @Override // com.blued.android.core.ui.BaseFragment
    public void onDestroy() {
        super.onDestroy();
        BackgroundMusicView backgroundMusicView = this.c;
        if (backgroundMusicView != null) {
            backgroundMusicView.f();
        }
        this.c = null;
    }
}
