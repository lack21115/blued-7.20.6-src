package com.blued.android.module.yy_china.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.view.shape.ShapeConstraintLayout;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.databinding.ViewDailyPrizeBinding;
import com.blued.android.module.yy_china.fragment.YYTaskRewardDialog;
import com.blued.android.module.yy_china.model.YYTaskRewardModel;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;
import com.blued.android.module.yy_china.view.DailyPrizeView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/DailyPrizeView.class */
public final class DailyPrizeView extends FrameLayout {
    private ViewDailyPrizeBinding a;
    private YYTaskRewardModel b;
    private BaseFragment c;
    private int d;
    private ShapeConstraintLayout e;
    private YYTaskRewardDialog f;
    private OpenPrizeListener g;

    @Metadata
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/DailyPrizeView$OpenPrizeListener.class */
    public interface OpenPrizeListener {
        void a(YYTaskRewardModel yYTaskRewardModel);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DailyPrizeView(Context context) {
        this(context, null);
        Intrinsics.e(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DailyPrizeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.e(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DailyPrizeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.e(context, "context");
        ViewDailyPrizeBinding a = ViewDailyPrizeBinding.a(LayoutInflater.from(getContext()), this, true);
        Intrinsics.c(a, "inflate(LayoutInflater.from(context), this, true)");
        this.a = a;
        this.d = 1;
        a.b.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$DailyPrizeView$CvLy0dRQeVoPi7o5jbsbITGmGVQ
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DailyPrizeView.a(DailyPrizeView.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(DailyPrizeView this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.getPrize();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b() {
        ShapeConstraintLayout shapeConstraintLayout = this.e;
        if (shapeConstraintLayout != null) {
            shapeConstraintLayout.setVisibility(0);
        }
        YYTaskRewardDialog yYTaskRewardDialog = this.f;
        if (yYTaskRewardDialog == null) {
            return;
        }
        yYTaskRewardDialog.a(this.c, this.e, this.b);
    }

    private final void getPrize() {
        final YYTaskRewardModel yYTaskRewardModel = this.b;
        if (yYTaskRewardModel == null) {
            return;
        }
        if (yYTaskRewardModel.status != 1) {
            b();
            return;
        }
        int i = this.d;
        int i2 = yYTaskRewardModel.level;
        BaseFragment fragment = getFragment();
        final ActivityFragmentActive fragmentActive = fragment == null ? null : fragment.getFragmentActive();
        BluedUIHttpResponse<BluedEntityA<Object>> bluedUIHttpResponse = new BluedUIHttpResponse<BluedEntityA<Object>>(this, fragmentActive) { // from class: com.blued.android.module.yy_china.view.DailyPrizeView$getPrize$1$1
            final /* synthetic */ DailyPrizeView b;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(fragmentActive);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<Object> bluedEntityA) {
                DailyPrizeView.OpenPrizeListener openPrizeListener;
                YYTaskRewardModel.this.status = 2;
                this.b.a(true);
                openPrizeListener = this.b.g;
                if (openPrizeListener != null) {
                    openPrizeListener.a(YYTaskRewardModel.this);
                }
                this.b.b();
            }
        };
        BaseFragment fragment2 = getFragment();
        YYRoomHttpUtils.i(String.valueOf(i), String.valueOf(i2), (BluedUIHttpResponse) bluedUIHttpResponse, fragment2 == null ? null : fragment2.getFragmentActive());
    }

    private final void setCircleColor(int i) {
        if (i == 0) {
            ShapeHelper.b(this.a.c, R.color.syc_202020);
        } else {
            ShapeHelper.b(this.a.c, R.color.syc_00E0AB);
        }
    }

    public final void a() {
        getPrize();
    }

    public final void a(BaseFragment baseFragment) {
        this.c = baseFragment;
    }

    public final void a(YYTaskRewardModel yYTaskRewardModel, int i) {
        this.b = yYTaskRewardModel;
        this.d = i;
        if (yYTaskRewardModel == null) {
            return;
        }
        getBinding().d.setText(String.valueOf(yYTaskRewardModel.condition));
        boolean z = false;
        setCirclePointVisible(0);
        if (yYTaskRewardModel.status == 2) {
            z = true;
        }
        a(z);
        setCircleColor(yYTaskRewardModel.status);
    }

    public final void a(boolean z) {
        this.a.a.setVisibility(z ? 0 : 8);
    }

    public final ViewDailyPrizeBinding getBinding() {
        return this.a;
    }

    public final YYTaskRewardDialog getDV() {
        return this.f;
    }

    public final BaseFragment getFragment() {
        return this.c;
    }

    public final ShapeConstraintLayout getRootView() {
        return this.e;
    }

    public final Integer getTaskValue() {
        int i;
        YYTaskRewardModel yYTaskRewardModel = this.b;
        if (yYTaskRewardModel == null) {
            i = 0;
        } else if (yYTaskRewardModel == null) {
            return null;
        } else {
            i = yYTaskRewardModel.condition;
        }
        return Integer.valueOf(i);
    }

    public final void setBinding(ViewDailyPrizeBinding viewDailyPrizeBinding) {
        Intrinsics.e(viewDailyPrizeBinding, "<set-?>");
        this.a = viewDailyPrizeBinding;
    }

    public final void setCirclePointVisible(int i) {
        this.a.c.setVisibility(i);
    }

    public final void setDV(YYTaskRewardDialog yYTaskRewardDialog) {
        this.f = yYTaskRewardDialog;
    }

    public final void setFragment(BaseFragment baseFragment) {
        this.c = baseFragment;
    }

    public final void setOpenPrizeListener(OpenPrizeListener openPrizeListener) {
        this.g = openPrizeListener;
    }

    public final void setPrizeValueVisible(boolean z) {
        this.a.d.setVisibility(z ? 0 : 8);
    }

    public final void setRootView(ShapeConstraintLayout shapeConstraintLayout) {
        this.e = shapeConstraintLayout;
    }
}
