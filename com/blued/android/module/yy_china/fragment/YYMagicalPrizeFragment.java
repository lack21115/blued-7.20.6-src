package com.blued.android.module.yy_china.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.image.ImageWrapper;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.databinding.FragmentMagicalPrizeBinding;
import com.blued.android.module.yy_china.model.YYMagicalPrizeModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYMagicalPrizeFragment.class */
public final class YYMagicalPrizeFragment extends BaseFullScreenDialog {
    private YYMagicalPrizeModel a;
    private FragmentMagicalPrizeBinding b;

    public YYMagicalPrizeFragment(YYMagicalPrizeModel yYMagicalPrizeModel) {
        this.a = yYMagicalPrizeModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYMagicalPrizeFragment this$0) {
        Intrinsics.e(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYMagicalPrizeFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(YYMagicalPrizeFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    private final void f() {
        FragmentMagicalPrizeBinding fragmentMagicalPrizeBinding = this.b;
        FragmentMagicalPrizeBinding fragmentMagicalPrizeBinding2 = fragmentMagicalPrizeBinding;
        if (fragmentMagicalPrizeBinding == null) {
            Intrinsics.c("mBinding");
            fragmentMagicalPrizeBinding2 = null;
        }
        fragmentMagicalPrizeBinding2.b.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYMagicalPrizeFragment$7o1Y6UccCwxoUrmbaHRJOoF6Voc
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYMagicalPrizeFragment.a(YYMagicalPrizeFragment.this, view);
            }
        });
        FragmentMagicalPrizeBinding fragmentMagicalPrizeBinding3 = this.b;
        FragmentMagicalPrizeBinding fragmentMagicalPrizeBinding4 = fragmentMagicalPrizeBinding3;
        if (fragmentMagicalPrizeBinding3 == null) {
            Intrinsics.c("mBinding");
            fragmentMagicalPrizeBinding4 = null;
        }
        fragmentMagicalPrizeBinding4.a.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYMagicalPrizeFragment$NEmapZ5YT7w6pIQXGjRWBKLMgRQ
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYMagicalPrizeFragment.b(YYMagicalPrizeFragment.this, view);
            }
        });
        YYMagicalPrizeModel yYMagicalPrizeModel = this.a;
        if (yYMagicalPrizeModel == null) {
            return;
        }
        FragmentMagicalPrizeBinding fragmentMagicalPrizeBinding5 = this.b;
        FragmentMagicalPrizeBinding fragmentMagicalPrizeBinding6 = fragmentMagicalPrizeBinding5;
        if (fragmentMagicalPrizeBinding5 == null) {
            Intrinsics.c("mBinding");
            fragmentMagicalPrizeBinding6 = null;
        }
        fragmentMagicalPrizeBinding6.f.setText("恭喜抢到" + ((Object) yYMagicalPrizeModel.name) + '*' + ((Object) yYMagicalPrizeModel.days) + (char) 22825);
        ImageWrapper a = ImageLoader.a(a(), yYMagicalPrizeModel.icon);
        FragmentMagicalPrizeBinding fragmentMagicalPrizeBinding7 = this.b;
        if (fragmentMagicalPrizeBinding7 == null) {
            Intrinsics.c("mBinding");
            fragmentMagicalPrizeBinding7 = null;
        }
        a.a(fragmentMagicalPrizeBinding7.c);
    }

    @Override // com.blued.android.module.yy_china.fragment.BaseFullScreenDialog
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        a(new Runnable() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYMagicalPrizeFragment$Y6VWgR9El1Cx10IXUUc3UwVFFw4
            @Override // java.lang.Runnable
            public final void run() {
                YYMagicalPrizeFragment.a(YYMagicalPrizeFragment.this);
            }
        }, 5000L);
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.e(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.fragment_magical_prize, viewGroup, true);
        Intrinsics.c(inflate, "inflater.inflate(R.layou…l_prize, container, true)");
        FragmentMagicalPrizeBinding a = FragmentMagicalPrizeBinding.a(inflate);
        Intrinsics.c(a, "bind(view)");
        this.b = a;
        f();
        return inflate;
    }
}
