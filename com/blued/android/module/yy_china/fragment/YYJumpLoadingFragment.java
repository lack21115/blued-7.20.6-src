package com.blued.android.module.yy_china.fragment;

import android.content.Context;
import android.os.Bundle;
import androidx.lifecycle.Observer;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.android.module.common.utils.ImgURLMap;
import com.blued.android.module.svgaplayer.SVGAImageView;
import com.blued.android.module.svgaplayer.SVGAPlayer;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.presenter.YYApplyPresenter;
import com.jeremyliao.liveeventbus.LiveEventBus;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYJumpLoadingFragment.class */
public class YYJumpLoadingFragment extends MvpFragment<YYApplyPresenter> implements Observer<String> {
    public static void a(Context context) {
        Bundle bundle = new Bundle();
        TerminalActivity.a(bundle);
        TerminalActivity.b(bundle);
        TerminalActivity.d(context, YYJumpLoadingFragment.class, bundle);
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public void a(Bundle bundle) {
        super.a(bundle);
        new SVGAPlayer.Builder(ImgURLMap.a.a("yy_home_small_white")).a((SVGAImageView) this.i.findViewById(R.id.iv_loading));
    }

    /* renamed from: c */
    public void onChanged(String str) {
        t();
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public int g() {
        return R.layout.fragment_jump_loading;
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.core.ui.BaseFragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        LiveEventBus.get("notify_close_jump_room", String.class).observe(this, this);
    }
}
