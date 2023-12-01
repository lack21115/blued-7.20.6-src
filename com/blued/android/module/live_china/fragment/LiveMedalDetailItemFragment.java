package com.blued.android.module.live_china.fragment;

import android.os.Bundle;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.module.live.base.utils.LiveTimeAndDateUtils;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.databinding.FragmentLiveMedalDetailItemBinding;
import com.blued.android.module.live_china.model.LiveMedalItemData;
import com.blued.android.module.live_china.presenter.LiveMedalWallPresenter;
import com.blued.android.module.ui.mvp.fragment.MvpFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveMedalDetailItemFragment.class */
public final class LiveMedalDetailItemFragment extends MvpFragment<LiveMedalWallPresenter, FragmentLiveMedalDetailItemBinding> {
    private final LiveMedalItemData b;

    public final LiveMedalItemData a() {
        return this.b;
    }

    @Override // com.blued.android.module.ui.mvp.fragment.MvpFragment
    public void a(Bundle bundle) {
        super.a(bundle);
        b();
    }

    public final void b() {
        FragmentLiveMedalDetailItemBinding fragmentLiveMedalDetailItemBinding = (FragmentLiveMedalDetailItemBinding) this.f16037a;
        if (fragmentLiveMedalDetailItemBinding == null) {
            return;
        }
        ActivityFragmentActive fragmentActive = getFragmentActive();
        String icon = a().getIcon();
        Intrinsics.a((Object) icon);
        ImageLoader.a(fragmentActive, icon).b(R.drawable.anchor_badge_default).f().g(-1).a(fragmentLiveMedalDetailItemBinding.f11956a);
        fragmentLiveMedalDetailItemBinding.d.setText(a().getName());
        fragmentLiveMedalDetailItemBinding.f11957c.setText(a().getDescription());
        long j = 1000;
        fragmentLiveMedalDetailItemBinding.b.setText(Intrinsics.a(getString(R.string.live_get_medal_time), (Object) LiveTimeAndDateUtils.b(a().getCreated_time() * j)));
        fragmentLiveMedalDetailItemBinding.e.setText(Intrinsics.a(getString(R.string.live_valid_time), (Object) LiveTimeAndDateUtils.b(a().getExpire_time() * j)));
    }
}
