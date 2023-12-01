package com.soft.blued.ui.setting.fragment;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.EditText;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.community.http.FeedHttpUtils;
import com.blued.community.view.EditInputNumView;
import com.bytedance.applog.tracker.Tracker;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.soft.blued.R;
import com.soft.blued.databinding.FragmentFeedbackBinding;
import com.soft.blued.ui.setting.fragment.FeedBackFragmentNew;
import com.soft.blued.ui.setting.model.FeedBackModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/fragment/FeedBackFragmentNew.class */
public final class FeedBackFragmentNew extends BaseFragment {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f19662a = new Companion(null);
    private FragmentFeedbackBinding b;

    /* renamed from: c  reason: collision with root package name */
    private EditText f19663c;
    private FeedBackAdapter d;
    private final Lazy e = LazyKt.a(new Function0<Dialog>() { // from class: com.soft.blued.ui.setting.fragment.FeedBackFragmentNew$loadingDialog$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* renamed from: a */
        public final Dialog invoke() {
            return DialogUtils.a(FeedBackFragmentNew.this.getContext());
        }
    });

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/fragment/FeedBackFragmentNew$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void a(Context context) {
            Intrinsics.e(context, "context");
            TerminalActivity.d(context, FeedBackFragmentNew.class, new Bundle());
        }
    }

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/fragment/FeedBackFragmentNew$FeedBackAdapter.class */
    public static final class FeedBackAdapter extends BaseQuickAdapter<FeedBackModel, BaseViewHolder> {
        public FeedBackAdapter() {
            super(R.layout.fragment_feedback_item, new ArrayList());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void a(FeedBackAdapter feedBackAdapter, FeedBackModel feedBackModel, View view) {
            Tracker.onClick(view);
            Intrinsics.e(feedBackAdapter, "this$0");
            Intrinsics.e(feedBackModel, "$model");
            for (FeedBackModel feedBackModel2 : feedBackAdapter.getData()) {
                feedBackModel2.setSelect(false);
            }
            feedBackModel.setSelect(true);
            feedBackAdapter.notifyDataSetChanged();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.chad.library.adapter.base.BaseQuickAdapter
        /* renamed from: a */
        public void convert(BaseViewHolder baseViewHolder, final FeedBackModel feedBackModel) {
            Intrinsics.e(baseViewHolder, "helper");
            Intrinsics.e(feedBackModel, "model");
            ShapeHelper.ShapeView view = baseViewHolder.getView(2131372708);
            Intrinsics.c(view, "helper.getView<ShapeTextView>(R.id.tv_text)");
            ShapeHelper.ShapeView shapeView = (ShapeTextView) view;
            shapeView.setText(feedBackModel.getType());
            if (feedBackModel.isSelect()) {
                ShapeHelper.ShapeView shapeView2 = shapeView;
                ShapeHelper.b(shapeView2, 2131102163);
                ShapeHelper.a(shapeView2, 2131102170);
            } else {
                ShapeHelper.ShapeView shapeView3 = shapeView;
                ShapeHelper.b(shapeView3, 2131102212);
                ShapeHelper.a(shapeView3, 2131102203);
            }
            shapeView.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.setting.fragment.-$$Lambda$FeedBackFragmentNew$FeedBackAdapter$3KaJPLkZ_reJAnLA4cAJv4orpOI
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    FeedBackFragmentNew.FeedBackAdapter.a(FeedBackFragmentNew.FeedBackAdapter.this, feedBackModel, view2);
                }
            });
        }
    }

    @JvmStatic
    public static final void a(Context context) {
        f19662a.a(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(FeedBackFragmentNew feedBackFragmentNew, View view) {
        Tracker.onClick(view);
        Intrinsics.e(feedBackFragmentNew, "this$0");
        FragmentActivity activity = feedBackFragmentNew.getActivity();
        if (activity == null) {
            return;
        }
        activity.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(FeedBackFragmentNew feedBackFragmentNew, View view) {
        Tracker.onClick(view);
        Intrinsics.e(feedBackFragmentNew, "this$0");
        feedBackFragmentNew.d();
    }

    private final void c() {
        ShapeTextView shapeTextView;
        EditInputNumView editInputNumView;
        CommonTopTitleNoTrans commonTopTitleNoTrans;
        CommonTopTitleNoTrans commonTopTitleNoTrans2;
        FragmentFeedbackBinding fragmentFeedbackBinding = this.b;
        if (fragmentFeedbackBinding != null && (commonTopTitleNoTrans2 = fragmentFeedbackBinding.d) != null) {
            commonTopTitleNoTrans2.setLeftClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.setting.fragment.-$$Lambda$FeedBackFragmentNew$sLYtgxYJmRjfyfdu7f2GYoO0Rh4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FeedBackFragmentNew.a(FeedBackFragmentNew.this, view);
                }
            });
        }
        FragmentFeedbackBinding fragmentFeedbackBinding2 = this.b;
        if (fragmentFeedbackBinding2 != null && (commonTopTitleNoTrans = fragmentFeedbackBinding2.d) != null) {
            commonTopTitleNoTrans.setCenterText((int) R.string.feed_back);
        }
        FragmentFeedbackBinding fragmentFeedbackBinding3 = this.b;
        TextView textView = fragmentFeedbackBinding3 == null ? null : fragmentFeedbackBinding3.g;
        if (textView != null) {
            textView.setText("选择反馈类型");
        }
        FragmentFeedbackBinding fragmentFeedbackBinding4 = this.b;
        TextView textView2 = fragmentFeedbackBinding4 == null ? null : fragmentFeedbackBinding4.e;
        if (textView2 != null) {
            textView2.setText("问题或建议");
        }
        FragmentFeedbackBinding fragmentFeedbackBinding5 = this.b;
        EditText editText = fragmentFeedbackBinding5 == null ? null : fragmentFeedbackBinding5.f15129a;
        if (editText != null) {
            editText.setHint("请写下您的意见或建议");
        }
        FragmentFeedbackBinding fragmentFeedbackBinding6 = this.b;
        ShapeTextView shapeTextView2 = fragmentFeedbackBinding6 == null ? null : fragmentFeedbackBinding6.f;
        if (shapeTextView2 != null) {
            shapeTextView2.setText("提交");
        }
        FragmentFeedbackBinding fragmentFeedbackBinding7 = this.b;
        this.f19663c = fragmentFeedbackBinding7 == null ? null : fragmentFeedbackBinding7.f15129a;
        FragmentFeedbackBinding fragmentFeedbackBinding8 = this.b;
        if (fragmentFeedbackBinding8 != null && (editInputNumView = fragmentFeedbackBinding8.b) != null) {
            editInputNumView.init(this.f19663c, 256, false);
        }
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 3, 1, false);
        FragmentFeedbackBinding fragmentFeedbackBinding9 = this.b;
        RecyclerView recyclerView = fragmentFeedbackBinding9 == null ? null : fragmentFeedbackBinding9.f15130c;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(gridLayoutManager);
        }
        this.d = getContext() == null ? null : new FeedBackAdapter();
        FragmentFeedbackBinding fragmentFeedbackBinding10 = this.b;
        RecyclerView recyclerView2 = fragmentFeedbackBinding10 == null ? null : fragmentFeedbackBinding10.f15130c;
        if (recyclerView2 != null) {
            recyclerView2.setAdapter(this.d);
        }
        FragmentFeedbackBinding fragmentFeedbackBinding11 = this.b;
        if (fragmentFeedbackBinding11 != null && (shapeTextView = fragmentFeedbackBinding11.f) != null) {
            shapeTextView.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.setting.fragment.-$$Lambda$FeedBackFragmentNew$uFrOe93y6JStgRR6Po_G2d1YSmc
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FeedBackFragmentNew.b(FeedBackFragmentNew.this, view);
                }
            });
        }
        e();
    }

    private final void d() {
        EditInputNumView editInputNumView;
        Editable text;
        FragmentFeedbackBinding fragmentFeedbackBinding = this.b;
        if ((fragmentFeedbackBinding == null || (editInputNumView = fragmentFeedbackBinding.b) == null || !editInputNumView.isOutOfBounds()) ? false : true) {
            AppMethods.a("不能超过256个字");
            return;
        }
        FeedBackAdapter feedBackAdapter = this.d;
        List<FeedBackModel> data = feedBackAdapter == null ? null : feedBackAdapter.getData();
        if (data == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<com.soft.blued.ui.setting.model.FeedBackModel>");
        }
        FeedBackModel feedBackModel = null;
        for (FeedBackModel feedBackModel2 : data) {
            if (feedBackModel2.isSelect()) {
                feedBackModel = feedBackModel2;
            }
        }
        if (feedBackModel == null) {
            AppMethods.a("请选择反馈类型");
            return;
        }
        EditText editText = this.f19663c;
        if (TextUtils.isEmpty(String.valueOf((editText == null || (text = editText.getText()) == null) ? null : StringsKt.b(text)))) {
            AppMethods.a("请输入问题或建议");
            return;
        }
        final ActivityFragmentActive fragmentActive = getFragmentActive();
        BluedUIHttpResponse<BluedEntityA<Object>> bluedUIHttpResponse = new BluedUIHttpResponse<BluedEntityA<Object>>(fragmentActive) { // from class: com.soft.blued.ui.setting.fragment.FeedBackFragmentNew$submit$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super((IRequestHost) fragmentActive);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<Object> bluedEntityA) {
                AppMethods.d((int) R.string.receive_nopraise);
                FragmentActivity activity = FeedBackFragmentNew.this.getActivity();
                if (activity == null) {
                    return;
                }
                activity.finish();
            }
        };
        EditText editText2 = this.f19663c;
        FeedHttpUtils.a(bluedUIHttpResponse, String.valueOf(editText2 == null ? null : editText2.getText()), feedBackModel.getId());
    }

    private final void e() {
        final ActivityFragmentActive fragmentActive = getFragmentActive();
        FeedHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<FeedBackModel>>(fragmentActive) { // from class: com.soft.blued.ui.setting.fragment.FeedBackFragmentNew$getFeedBack$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super("feed_back", (IRequestHost) fragmentActive);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            /* renamed from: a */
            public void onUICache(BluedEntityA<FeedBackModel> bluedEntityA) {
                FeedBackFragmentNew.FeedBackAdapter a2;
                super.onUICache((BluedEntity) bluedEntityA);
                boolean z = false;
                if (bluedEntityA != null && bluedEntityA.hasData()) {
                    z = true;
                }
                if (!z || (a2 = FeedBackFragmentNew.this.a()) == null) {
                    return;
                }
                a2.setNewData(bluedEntityA.data);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            /* renamed from: b */
            public void onUIUpdate(BluedEntityA<FeedBackModel> bluedEntityA) {
                FeedBackFragmentNew.FeedBackAdapter a2;
                boolean z = false;
                if (bluedEntityA != null && bluedEntityA.hasData()) {
                    z = true;
                }
                if (!z || (a2 = FeedBackFragmentNew.this.a()) == null) {
                    return;
                }
                a2.setNewData(bluedEntityA.data);
            }

            public void onUIFinish() {
                List<FeedBackModel> data;
                FeedBackFragmentNew.FeedBackAdapter a2;
                super.onUIFinish();
                DialogUtils.b(FeedBackFragmentNew.this.b());
                if (AppInfo.m()) {
                    FeedBackFragmentNew.FeedBackAdapter a3 = FeedBackFragmentNew.this.a();
                    if (!((a3 == null || (data = a3.getData()) == null || data.size() != 0) ? false : true) || (a2 = FeedBackFragmentNew.this.a()) == null) {
                        return;
                    }
                    a2.setNewData(CollectionsKt.d(new FeedBackModel[]{new FeedBackModel("测试数据", false), new FeedBackModel("账号相关", false), new FeedBackModel("身边", false), new FeedBackModel("直播相关", false), new FeedBackModel("发现推荐", false), new FeedBackModel("聊天消息", false), new FeedBackModel("增值服务", false), new FeedBackModel("个人主页", false)}));
                }
            }

            public void onUIStart() {
                super.onUIStart();
                DialogUtils.a(FeedBackFragmentNew.this.b());
            }
        });
    }

    public final FeedBackAdapter a() {
        return this.d;
    }

    public final Dialog b() {
        Object value = this.e.getValue();
        Intrinsics.c(value, "<get-loadingDialog>(...)");
        return (Dialog) value;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ConstraintLayout root;
        ConstraintLayout root2;
        Intrinsics.e(layoutInflater, "inflater");
        FragmentFeedbackBinding a2 = FragmentFeedbackBinding.a(getLayoutInflater(), viewGroup, false);
        this.b = a2;
        if (((a2 == null || (root = a2.getRoot()) == null) ? null : root.getParent()) != null) {
            FragmentFeedbackBinding fragmentFeedbackBinding = this.b;
            ViewParent parent = (fragmentFeedbackBinding == null || (root2 = fragmentFeedbackBinding.getRoot()) == null) ? null : root2.getParent();
            if (parent == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
            }
            ViewGroup viewGroup2 = (ViewGroup) parent;
            FragmentFeedbackBinding fragmentFeedbackBinding2 = this.b;
            viewGroup2.removeView(fragmentFeedbackBinding2 == null ? null : fragmentFeedbackBinding2.getRoot());
        }
        c();
        FragmentFeedbackBinding fragmentFeedbackBinding3 = this.b;
        return fragmentFeedbackBinding3 == null ? null : fragmentFeedbackBinding3.getRoot();
    }
}
