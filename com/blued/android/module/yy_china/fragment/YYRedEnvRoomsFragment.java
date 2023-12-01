package com.blued.android.module.yy_china.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import com.blued.android.core.ui.BaseFragmentActivity;
import com.blued.android.core.ui.StatusBarHelper;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.view.shape.ShapeModel;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.base.config.ListConfig;
import com.blued.android.module.common.base.mvi.BaseListAction;
import com.blued.android.module.common.base.mvi.BaseListFragment;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.android.module.common.view.NoDataAndLoadFailView;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.adapter.YYRedEnvRoomAdapter;
import com.blued.android.module.yy_china.model.YYHongbaoModel;
import com.blued.android.module.yy_china.presenter.YYRedEnvRoomsViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYRedEnvRoomsFragment.class */
public final class YYRedEnvRoomsFragment extends BaseListFragment<YYRedEnvRoomsViewModel, YYHongbaoModel> {
    public static final Companion b = new Companion(null);

    @Metadata
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYRedEnvRoomsFragment$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(Context context) {
            Bundle bundle = new Bundle();
            TerminalActivity.a(bundle);
            TerminalActivity.d(context, YYRedEnvRoomsFragment.class, bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYRedEnvRoomsFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        if (activity == null) {
            return;
        }
        activity.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(YYRedEnvRoomsFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        ((YYRedEnvRoomsViewModel) this$0.y()).dispatchAction(BaseListAction.RefreshData.a);
    }

    @Override // com.blued.android.module.common.base.mvi.BaseListFragment
    /* renamed from: C */
    public YYRedEnvRoomAdapter i() {
        BaseFragmentActivity activity = getActivity();
        if (activity != null) {
            return new YYRedEnvRoomAdapter(activity);
        }
        throw new NullPointerException("null cannot be cast to non-null type com.blued.android.core.ui.BaseFragmentActivity");
    }

    @Override // com.blued.android.module.common.base.mvi.BaseListFragment
    public ListConfig h() {
        return new ListConfig.Builder().e(true).a(20).a(ListConfig.LoadMoreModel.PULL_UP).b(true).c(true).d(false).a(true).a();
    }

    @Override // com.blued.android.module.common.base.mvi.BaseListFragment, com.blued.android.module.common.base.mvi.MVIBaseFragment
    public void m() {
        ShapeTextView btn;
        CommonTopTitleNoTrans b2;
        super.m();
        if (StatusBarHelper.a() && (b2 = b()) != null) {
            b2.setPadding(0, StatusBarHelper.a(getActivity()), 0, 0);
        }
        CommonTopTitleNoTrans b3 = b();
        if (b3 != null) {
            b3.setVisibility(0);
        }
        CommonTopTitleNoTrans b4 = b();
        if (b4 != null) {
            b4.setCenterText("红包");
        }
        CommonTopTitleNoTrans b5 = b();
        if (b5 != null) {
            b5.setLeftImgDrawable(BluedSkinUtils.b(getContext(), R.drawable.icon_title_back));
        }
        NoDataAndLoadFailView c = c();
        if (c != null) {
            c.setNoDataStr(R.string.yy_no_data);
        }
        NoDataAndLoadFailView c2 = c();
        if (c2 != null) {
            c2.setFailBtnVisibility(8);
        }
        NoDataAndLoadFailView c3 = c();
        if (c3 != null) {
            c3.setNoDataBtnListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYRedEnvRoomsFragment$DUKRQBscLUp71gF_0uLBy3qeBHk
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    YYRedEnvRoomsFragment.a(YYRedEnvRoomsFragment.this, view);
                }
            });
        }
        FrameLayout d = d();
        if (d != null) {
            d.setBackgroundColor(BluedSkinUtils.a(getContext(), R.color.syc_b));
        }
        Context context = getContext();
        if (context != null) {
            NoDataAndLoadFailView c4 = c();
            ShapeTextView shapeTextView = null;
            ShapeModel shapeModel = (c4 == null || (btn = c4.getBtn()) == null) ? null : btn.getShapeModel();
            if (shapeModel != null) {
                shapeModel.b = ContextCompat.getColor(context, R.color.syc_dark_b);
            }
            NoDataAndLoadFailView c5 = c();
            if (c5 != null) {
                shapeTextView = c5.getBtn();
            }
            if (shapeTextView != null) {
                shapeTextView.setShapeModel(shapeModel);
            }
        }
        NoDataAndLoadFailView c6 = c();
        if (c6 != null) {
            c6.setFailBtnListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYRedEnvRoomsFragment$Q24zK73RB-jDjirS9sT9w9YkCh0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    YYRedEnvRoomsFragment.b(YYRedEnvRoomsFragment.this, view);
                }
            });
        }
        f().notifyDataSetChanged();
    }
}
