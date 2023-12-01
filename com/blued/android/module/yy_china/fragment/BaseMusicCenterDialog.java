package com.blued.android.module.yy_china.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentResultListener;
import androidx.lifecycle.LifecycleOwner;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.adapter.BaseMusicPagerAdapter;
import com.blued.android.module.yy_china.databinding.FragmentYyKtvMusicCenterBinding;
import com.jeremyliao.liveeventbus.LiveEventBus;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/BaseMusicCenterDialog.class */
public abstract class BaseMusicCenterDialog<T> extends BaseFullScreenDialog {
    public static final Companion a = new Companion(null);
    protected FragmentYyKtvMusicCenterBinding b;
    protected BaseMusicPagerAdapter<T> c;

    @Metadata
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/BaseMusicCenterDialog$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(BaseMusicCenterDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(BaseMusicCenterDialog this$0, String noName_0, Bundle noName_1) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(noName_0, "$noName_0");
        Intrinsics.e(noName_1, "$noName_1");
        this$0.dismissAllowingStateLoss();
    }

    protected final void a(BaseMusicPagerAdapter<T> baseMusicPagerAdapter) {
        Intrinsics.e(baseMusicPagerAdapter, "<set-?>");
        this.c = baseMusicPagerAdapter;
    }

    protected final void a(FragmentYyKtvMusicCenterBinding fragmentYyKtvMusicCenterBinding) {
        Intrinsics.e(fragmentYyKtvMusicCenterBinding, "<set-?>");
        this.b = fragmentYyKtvMusicCenterBinding;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final FragmentYyKtvMusicCenterBinding f() {
        FragmentYyKtvMusicCenterBinding fragmentYyKtvMusicCenterBinding = this.b;
        if (fragmentYyKtvMusicCenterBinding != null) {
            return fragmentYyKtvMusicCenterBinding;
        }
        Intrinsics.c("mBinding");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final BaseMusicPagerAdapter<T> g() {
        BaseMusicPagerAdapter<T> baseMusicPagerAdapter = this.c;
        if (baseMusicPagerAdapter != null) {
            return baseMusicPagerAdapter;
        }
        Intrinsics.c("mPagerAdapter");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void h() {
        f().d.setTabPaddingLeftRight(16);
        f().d.setTabTextColorUnfocused(R.color.syc_989898);
        f().d.setTextColor(R.color.syc_EAEAEA);
        f().d.setIndicatorColor(R.color.syc_a);
        f().d.setViewPager(f().c);
    }

    public abstract void i();

    public abstract BaseMusicPagerAdapter<T> j();

    @Override // com.blued.android.module.yy_china.fragment.BaseFullScreenDialog, com.blued.android.core.ui.BaseDialogFragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getChildFragmentManager().setFragmentResultListener("key_cancel", (LifecycleOwner) this, new FragmentResultListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$BaseMusicCenterDialog$2NCOWWdK7wTuyuaS4gE-U6E-pVQ
            public final void onFragmentResult(String str, Bundle bundle2) {
                BaseMusicCenterDialog.a(BaseMusicCenterDialog.this, str, bundle2);
            }
        });
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.e(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.fragment_yy_ktv_music_center, viewGroup, true);
        Intrinsics.c(inflate, "inflater.inflate(R.layou…_center, container, true)");
        FragmentYyKtvMusicCenterBinding a2 = FragmentYyKtvMusicCenterBinding.a(inflate);
        Intrinsics.c(a2, "bind(view)");
        a(a2);
        f().a.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$BaseMusicCenterDialog$NVBed9EblKF54e25oocSiwoOUFg
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BaseMusicCenterDialog.a(BaseMusicCenterDialog.this, view);
            }
        });
        a(j());
        f().c.setAdapter(g());
        f().c.setCurrentItem(0);
        f().c.setOffscreenPageLimit(1);
        return inflate;
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment
    public void onDestroy() {
        super.onDestroy();
        LiveEventBus.get("inner_fragment_close").post("");
    }

    @Override // com.blued.android.module.yy_china.fragment.BaseFullScreenDialog, com.blued.android.core.ui.BaseDialogFragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.e(view, "view");
        super.onViewCreated(view, bundle);
        i();
    }
}
