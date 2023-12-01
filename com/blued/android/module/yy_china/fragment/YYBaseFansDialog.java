package com.blued.android.module.yy_china.fragment;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentManager;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.model.YYUserInfo;
import com.blued.android.module.yy_china.view.YYNoDataView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYBaseFansDialog.class */
public abstract class YYBaseFansDialog extends BaseFullScreenDialog {
    private BaseFragment a;
    private final YYUserInfo b;
    private YYRoomModel c;
    private YYNoDataView d;

    public YYBaseFansDialog(BaseFragment fragment, YYUserInfo us) {
        Intrinsics.e(fragment, "fragment");
        Intrinsics.e(us, "us");
        this.a = fragment;
        this.b = us;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYBaseFansDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        YYWebViewDialogFragment yYWebViewDialogFragment = new YYWebViewDialogFragment();
        yYWebViewDialogFragment.a(this$0.f(), "https://activity.blued.cn/activityblued/work/CXyGSGo1");
        yYWebViewDialogFragment.a(false);
        FragmentManager childFragmentManager = this$0.getChildFragmentManager();
        Intrinsics.c(childFragmentManager, "childFragmentManager");
        yYWebViewDialogFragment.show(childFragmentManager, "yy_fans_guide");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(YYBaseFansDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    public BaseFragment f() {
        return this.a;
    }

    public YYUserInfo g() {
        return this.b;
    }

    public final YYRoomModel h() {
        return this.c;
    }

    public final YYNoDataView i() {
        return this.d;
    }

    public abstract View j();

    public abstract View k();

    @Override // com.blued.android.module.yy_china.fragment.BaseFullScreenDialog
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        View j = j();
        if (j != null) {
            j.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYBaseFansDialog$IxhWbvTLzxY5_vlibs6I1p2n2d0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    YYBaseFansDialog.a(YYBaseFansDialog.this, view);
                }
            });
        }
        View k = k();
        if (k == null) {
            return;
        }
        k.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYBaseFansDialog$YHSE9etJ0fuuhAnFkMM0Zp6Oi-Y
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYBaseFansDialog.b(YYBaseFansDialog.this, view);
            }
        });
    }

    @Override // com.blued.android.module.yy_china.fragment.BaseFullScreenDialog, com.blued.android.core.ui.BaseDialogFragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.c = YYRoomInfoManager.e().b();
        YYNoDataView yYNoDataView = new YYNoDataView(getContext());
        this.d = yYNoDataView;
        if (yYNoDataView != null) {
            yYNoDataView.setNoDataColor(R.color.syc_dark_000000);
        }
        YYNoDataView yYNoDataView2 = this.d;
        if (yYNoDataView2 != null) {
            yYNoDataView2.setNoDataImg(R.drawable.icon_nodata_img);
        }
        YYNoDataView yYNoDataView3 = this.d;
        if (yYNoDataView3 != null) {
            yYNoDataView3.setNoDataStr(R.string.yy_no_member);
        }
        YYNoDataView yYNoDataView4 = this.d;
        if (yYNoDataView4 == null) {
            return;
        }
        yYNoDataView4.setRootViewBackground(R.color.transparent);
    }
}
