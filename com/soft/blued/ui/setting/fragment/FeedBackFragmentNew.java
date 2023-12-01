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
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.http.BluedUIHttpResponse;
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
    public static final Companion f33353a = new Companion(null);
    private FragmentFeedbackBinding b;

    /* renamed from: c  reason: collision with root package name */
    private EditText f33354c;
    private FeedBackAdapter d;
    private final Lazy e = LazyKt.a(new Function0<Dialog>() { // from class: com.soft.blued.ui.setting.fragment.FeedBackFragmentNew$loadingDialog$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
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
        public static final void a(FeedBackAdapter this$0, FeedBackModel model, View view) {
            Tracker.onClick(view);
            Intrinsics.e(this$0, "this$0");
            Intrinsics.e(model, "$model");
            for (FeedBackModel feedBackModel : this$0.getData()) {
                feedBackModel.setSelect(false);
            }
            model.setSelect(true);
            this$0.notifyDataSetChanged();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.chad.library.adapter.base.BaseQuickAdapter
        /* renamed from: a */
        public void convert(BaseViewHolder helper, final FeedBackModel model) {
            Intrinsics.e(helper, "helper");
            Intrinsics.e(model, "model");
            View view = helper.getView(2131372708);
            Intrinsics.c(view, "helper.getView<ShapeTextView>(R.id.tv_text)");
            ShapeTextView shapeTextView = (ShapeTextView) view;
            shapeTextView.setText(model.getType());
            if (model.isSelect()) {
                ShapeTextView shapeTextView2 = shapeTextView;
                ShapeHelper.b(shapeTextView2, 2131102163);
                ShapeHelper.a((ShapeHelper.ShapeView) shapeTextView2, 2131102170);
            } else {
                ShapeTextView shapeTextView3 = shapeTextView;
                ShapeHelper.b(shapeTextView3, 2131102212);
                ShapeHelper.a((ShapeHelper.ShapeView) shapeTextView3, 2131102203);
            }
            shapeTextView.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.setting.fragment.-$$Lambda$FeedBackFragmentNew$FeedBackAdapter$3KaJPLkZ_reJAnLA4cAJv4orpOI
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    FeedBackFragmentNew.FeedBackAdapter.a(FeedBackFragmentNew.FeedBackAdapter.this, model, view2);
                }
            });
        }
    }

    @JvmStatic
    public static final void a(Context context) {
        f33353a.a(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(FeedBackFragmentNew this$0, View view) {
        Tracker.onClick(view);
        Intrinsics.e(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        if (activity == null) {
            return;
        }
        activity.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(FeedBackFragmentNew this$0, View view) {
        Tracker.onClick(view);
        Intrinsics.e(this$0, "this$0");
        this$0.d();
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
            commonTopTitleNoTrans.setCenterText(R.string.feed_back);
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
        EditText editText = fragmentFeedbackBinding5 == null ? null : fragmentFeedbackBinding5.f28819a;
        if (editText != null) {
            editText.setHint("请写下您的意见或建议");
        }
        FragmentFeedbackBinding fragmentFeedbackBinding6 = this.b;
        ShapeTextView shapeTextView2 = fragmentFeedbackBinding6 == null ? null : fragmentFeedbackBinding6.f;
        if (shapeTextView2 != null) {
            shapeTextView2.setText("提交");
        }
        FragmentFeedbackBinding fragmentFeedbackBinding7 = this.b;
        this.f33354c = fragmentFeedbackBinding7 == null ? null : fragmentFeedbackBinding7.f28819a;
        FragmentFeedbackBinding fragmentFeedbackBinding8 = this.b;
        if (fragmentFeedbackBinding8 != null && (editInputNumView = fragmentFeedbackBinding8.b) != null) {
            editInputNumView.init(this.f33354c, 256, false);
        }
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 3, 1, false);
        FragmentFeedbackBinding fragmentFeedbackBinding9 = this.b;
        RecyclerView recyclerView = fragmentFeedbackBinding9 == null ? null : fragmentFeedbackBinding9.f28820c;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(gridLayoutManager);
        }
        this.d = getContext() == null ? null : new FeedBackAdapter();
        FragmentFeedbackBinding fragmentFeedbackBinding10 = this.b;
        RecyclerView recyclerView2 = fragmentFeedbackBinding10 == null ? null : fragmentFeedbackBinding10.f28820c;
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
            AppMethods.a((CharSequence) "不能超过256个字");
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
            AppMethods.a((CharSequence) "请选择反馈类型");
            return;
        }
        EditText editText = this.f33354c;
        if (TextUtils.isEmpty(String.valueOf((editText == null || (text = editText.getText()) == null) ? null : StringsKt.b(text)))) {
            AppMethods.a((CharSequence) "请输入问题或建议");
            return;
        }
        final ActivityFragmentActive fragmentActive = getFragmentActive();
        BluedUIHttpResponse<BluedEntityA<Object>> bluedUIHttpResponse = new BluedUIHttpResponse<BluedEntityA<Object>>(fragmentActive) { // from class: com.soft.blued.ui.setting.fragment.FeedBackFragmentNew$submit$2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
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
        EditText editText2 = this.f33354c;
        FeedHttpUtils.a(bluedUIHttpResponse, String.valueOf(editText2 == null ? null : editText2.getText()), feedBackModel.getId());
    }

    private final void e() {
        final ActivityFragmentActive fragmentActive = getFragmentActive();
        FeedHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<FeedBackModel>>(fragmentActive) { // from class: com.soft.blued.ui.setting.fragment.FeedBackFragmentNew$getFeedBack$1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUICache(BluedEntityA<FeedBackModel> bluedEntityA) {
                FeedBackFragmentNew.FeedBackAdapter a2;
                super.onUICache(bluedEntityA);
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
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
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

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
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
                    a2.setNewData(CollectionsKt.d(new FeedBackModel("测试数据", false), new FeedBackModel("账号相关", false), new FeedBackModel("身边", false), new FeedBackModel("直播相关", false), new FeedBackModel("发现推荐", false), new FeedBackModel("聊天消息", false), new FeedBackModel("增值服务", false), new FeedBackModel("个人主页", false)));
                }
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
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

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        ConstraintLayout root;
        ConstraintLayout root2;
        Intrinsics.e(inflater, "inflater");
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
