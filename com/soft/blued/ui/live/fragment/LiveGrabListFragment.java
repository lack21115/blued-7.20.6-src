package com.soft.blued.ui.live.fragment;

import android.content.Context;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.view.shape.ShapeModel;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.base.config.ListConfig;
import com.blued.android.module.common.base.mvi.BaseListAction;
import com.blued.android.module.common.base.mvi.BaseListFragment;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.android.module.common.view.NoDataAndLoadFailView;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.ui.live.adapter.LiveGrabAdapter;
import com.soft.blued.ui.live.model.LiveGrabModel;
import com.soft.blued.ui.live.model.LiveGrabViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/live/fragment/LiveGrabListFragment.class */
public final class LiveGrabListFragment extends BaseListFragment<LiveGrabViewModel, LiveGrabModel> {
    public static final Companion b = new Companion(null);

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/live/fragment/LiveGrabListFragment$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(Context context) {
            TerminalActivity.d(context, LiveGrabListFragment.class, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LiveGrabListFragment this$0, View view) {
        Tracker.onClick(view);
        Intrinsics.e(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        if (activity == null) {
            return;
        }
        activity.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(LiveGrabListFragment this$0, View view) {
        Tracker.onClick(view);
        Intrinsics.e(this$0, "this$0");
        ((LiveGrabViewModel) this$0.y()).dispatchAction(BaseListAction.RefreshData.f10668a);
    }

    @Override // com.blued.android.module.common.base.mvi.BaseListFragment
    /* renamed from: C */
    public LiveGrabAdapter i() {
        return new LiveGrabAdapter();
    }

    @Override // com.blued.android.module.common.base.mvi.BaseListFragment
    public ListConfig h() {
        return new ListConfig.Builder().e(true).a(20).a(ListConfig.LoadMoreModel.PULL_UP).b(true).c(true).d(true).a(true).a();
    }

    @Override // com.blued.android.module.common.base.mvi.BaseListFragment, com.blued.android.module.common.base.mvi.MVIBaseFragment
    public void m() {
        ShapeTextView btn;
        super.m();
        CommonTopTitleNoTrans b2 = b();
        if (b2 != null) {
            b2.setVisibility(0);
        }
        CommonTopTitleNoTrans b3 = b();
        if (b3 != null) {
            b3.setCenterText(getString(R.string.recommend_grab_title));
        }
        NoDataAndLoadFailView c2 = c();
        if (c2 != null) {
            c2.setNoDataStr(R.string.recommend_no_grab);
        }
        NoDataAndLoadFailView c3 = c();
        if (c3 != null) {
            c3.setFailBtnVisibility(8);
        }
        NoDataAndLoadFailView c4 = c();
        if (c4 != null) {
            c4.setNoDataBtnListener(new View.OnClickListener() { // from class: com.soft.blued.ui.live.fragment.-$$Lambda$LiveGrabListFragment$W6BHk5mK-DqwpzqxfB2vuGvSMHY
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LiveGrabListFragment.a(LiveGrabListFragment.this, view);
                }
            });
        }
        Context context = getContext();
        if (context != null) {
            NoDataAndLoadFailView c5 = c();
            ShapeTextView shapeTextView = null;
            ShapeModel shapeModel = (c5 == null || (btn = c5.getBtn()) == null) ? null : btn.getShapeModel();
            if (shapeModel != null) {
                shapeModel.b = ContextCompat.getColor(context, 2131102170);
            }
            NoDataAndLoadFailView c6 = c();
            if (c6 != null) {
                shapeTextView = c6.getBtn();
            }
            if (shapeTextView != null) {
                shapeTextView.setShapeModel(shapeModel);
            }
        }
        NoDataAndLoadFailView c7 = c();
        if (c7 == null) {
            return;
        }
        c7.setFailBtnListener(new View.OnClickListener() { // from class: com.soft.blued.ui.live.fragment.-$$Lambda$LiveGrabListFragment$SqfLvsRQuC27b9gEo5j2q0fjoBU
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveGrabListFragment.b(LiveGrabListFragment.this, view);
            }
        });
    }
}
