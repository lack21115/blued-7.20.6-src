package com.blued.android.module.yy_china.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.adapter.MedalPageAdapter;
import com.blued.android.module.yy_china.databinding.DialogMedalInfoBinding;
import com.blued.android.module.yy_china.fragment.BaseFullScreenDialog;
import com.blued.android.module.yy_china.fragment.BaseYYStudioFragment;
import com.blued.android.module.yy_china.model.YYUserInfo;
import com.blued.android.module.yy_china.view.ban.transformer.MedalTransformer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYMedalInfoDialog.class */
public final class YYMedalInfoDialog extends BaseFullScreenDialog {

    /* renamed from: a  reason: collision with root package name */
    private DialogMedalInfoBinding f18304a;
    private YYUserInfo b;

    /* renamed from: c  reason: collision with root package name */
    private String f18305c;
    private BaseYYStudioFragment d;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYMedalInfoDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(YYMedalInfoDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    private final void j() {
        FrameLayout frameLayout;
        ViewPager viewPager;
        YYUserInfo yYUserInfo = this.b;
        if (yYUserInfo != null) {
            DialogMedalInfoBinding f = f();
            ViewPager viewPager2 = f == null ? null : f.b;
            if (viewPager2 != null) {
                viewPager2.setOffscreenPageLimit(3);
            }
            DialogMedalInfoBinding f2 = f();
            if (f2 != null && (viewPager = f2.b) != null) {
                viewPager.setPageTransformer(true, new MedalTransformer());
            }
            DialogMedalInfoBinding f3 = f();
            ViewPager viewPager3 = f3 == null ? null : f3.b;
            if (viewPager3 != null) {
                YYUserInfo g = g();
                viewPager3.setAdapter(new MedalPageAdapter(g == null ? null : g.badge, i(), new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYMedalInfoDialog$HNV4PdnneTkahkQEVJWz_aybJLU
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        YYMedalInfoDialog.a(YYMedalInfoDialog.this, view);
                    }
                }));
            }
            int i = 0;
            int size = yYUserInfo.badge.size();
            while (true) {
                if (i >= size) {
                    break;
                } else if (Intrinsics.a((Object) h(), (Object) yYUserInfo.badge.get(i).getBid())) {
                    DialogMedalInfoBinding f4 = f();
                    ViewPager viewPager4 = f4 == null ? null : f4.b;
                    if (viewPager4 != null) {
                        viewPager4.setCurrentItem(i);
                    }
                } else {
                    i++;
                }
            }
        }
        DialogMedalInfoBinding dialogMedalInfoBinding = this.f18304a;
        if (dialogMedalInfoBinding == null || (frameLayout = dialogMedalInfoBinding.f16364a) == null) {
            return;
        }
        frameLayout.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYMedalInfoDialog$gP30AZTl1xJiecLf3GV1-Xs9cFQ
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYMedalInfoDialog.b(YYMedalInfoDialog.this, view);
            }
        });
    }

    public final YYMedalInfoDialog a(YYUserInfo info, String bid, BaseYYStudioFragment fra) {
        Intrinsics.e(info, "info");
        Intrinsics.e(bid, "bid");
        Intrinsics.e(fra, "fra");
        this.b = info;
        this.d = fra;
        this.f18305c = bid;
        return this;
    }

    public final DialogMedalInfoBinding f() {
        return this.f18304a;
    }

    public final YYUserInfo g() {
        return this.b;
    }

    public final String h() {
        return this.f18305c;
    }

    public final BaseYYStudioFragment i() {
        return this.d;
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.e(inflater, "inflater");
        this.f18304a = DialogMedalInfoBinding.a(inflater.inflate(R.layout.dialog_medal_info, viewGroup, true));
        j();
        DialogMedalInfoBinding dialogMedalInfoBinding = this.f18304a;
        return dialogMedalInfoBinding == null ? null : dialogMedalInfoBinding.getRoot();
    }
}
