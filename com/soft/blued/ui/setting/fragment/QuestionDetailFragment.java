package com.soft.blued.ui.setting.fragment;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import com.blued.android.module.common.base.mvvm.EmptyViewModel;
import com.blued.android.module.common.base.mvvm.MVVMBaseFragment;
import com.blued.android.module.common.extensions.DialogFragmentViewBindingProperty;
import com.blued.android.module.common.extensions.FragmentViewBindingProperty;
import com.blued.android.module.common.extensions.ViewBindingProperty;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.bytedance.applog.tracker.Tracker;
import com.sobot.chat.api.ZhiChiApi;
import com.sobot.chat.api.model.StDocModel;
import com.sobot.chat.api.model.StHelpDocModel;
import com.sobot.chat.core.channel.SobotMsgManager;
import com.sobot.chat.utils.ToastUtil;
import com.sobot.network.http.callback.StringResultCallBack;
import com.soft.blued.R;
import com.soft.blued.databinding.FmQuestionDetailBinding;
import com.soft.blued.ui.setting.tools.ServiceHelper;
import com.soft.blued.utils.TypefaceUtils;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/fragment/QuestionDetailFragment.class */
public final class QuestionDetailFragment extends MVVMBaseFragment<EmptyViewModel> {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ KProperty<Object>[] f33576a = {Reflection.a(new PropertyReference1Impl(QuestionDetailFragment.class, "vb", "getVb()Lcom/soft/blued/databinding/FmQuestionDetailBinding;", 0))};
    private final ViewBindingProperty b;

    /* renamed from: c  reason: collision with root package name */
    private StDocModel f33577c;

    public QuestionDetailFragment() {
        super(R.layout.fm_question_detail);
        this.b = this instanceof DialogFragment ? new DialogFragmentViewBindingProperty(new Function1<QuestionDetailFragment, FmQuestionDetailBinding>() { // from class: com.soft.blued.ui.setting.fragment.QuestionDetailFragment$special$$inlined$viewBindingFragment$default$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a */
            public final FmQuestionDetailBinding invoke(QuestionDetailFragment fragment) {
                Intrinsics.e(fragment, "fragment");
                return FmQuestionDetailBinding.a(fragment.requireView());
            }
        }) : new FragmentViewBindingProperty(new Function1<QuestionDetailFragment, FmQuestionDetailBinding>() { // from class: com.soft.blued.ui.setting.fragment.QuestionDetailFragment$special$$inlined$viewBindingFragment$default$2
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a */
            public final FmQuestionDetailBinding invoke(QuestionDetailFragment fragment) {
                Intrinsics.e(fragment, "fragment");
                return FmQuestionDetailBinding.a(fragment.requireView());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(QuestionDetailFragment this$0, View view) {
        Tracker.onClick(view);
        Intrinsics.e(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        if (activity == null) {
            return;
        }
        activity.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FmQuestionDetailBinding p() {
        return (FmQuestionDetailBinding) this.b.b(this, f33576a[0]);
    }

    private final void q() {
        ZhiChiApi zhiChiApi = SobotMsgManager.getInstance(getActivity()).getZhiChiApi();
        FragmentActivity activity = getActivity();
        String string = getString(R.string.sobot_app_key);
        StDocModel stDocModel = this.f33577c;
        StDocModel stDocModel2 = stDocModel;
        if (stDocModel == null) {
            Intrinsics.c("docModel");
            stDocModel2 = null;
        }
        zhiChiApi.getHelpDocByDocId(activity, string, stDocModel2.getDocId(), new StringResultCallBack<StHelpDocModel>() { // from class: com.soft.blued.ui.setting.fragment.QuestionDetailFragment$getQuestionDetail$1
            @Override // com.sobot.network.http.callback.StringResultCallBack
            /* renamed from: a */
            public void onSuccess(StHelpDocModel data) {
                FmQuestionDetailBinding p;
                FmQuestionDetailBinding p2;
                Intrinsics.e(data, "data");
                if (TextUtils.isEmpty(data.getAnswerDesc())) {
                    return;
                }
                p = QuestionDetailFragment.this.p();
                TextView textView = p == null ? null : p.d;
                if (textView != null) {
                    textView.setText(Intrinsics.a("· ", (Object) data.getQuestionTitle()));
                }
                p2 = QuestionDetailFragment.this.p();
                TextView textView2 = p2 == null ? null : p2.f28760c;
                if (textView2 == null) {
                    return;
                }
                textView2.setText(TypefaceUtils.a((Context) QuestionDetailFragment.this.getActivity(), data.getAnswerDesc(), false, (TypefaceUtils.ClickLinkListener) null));
            }

            @Override // com.sobot.network.http.callback.StringResultCallBack
            public void onFailure(Exception e, String des) {
                Intrinsics.e(e, "e");
                Intrinsics.e(des, "des");
                ToastUtil.showToast(QuestionDetailFragment.this.getActivity(), des);
            }
        });
    }

    @Override // com.blued.android.module.common.base.mvvm.MVVMBaseFragment
    public void f() {
        CommonTopTitleNoTrans commonTopTitleNoTrans;
        CommonTopTitleNoTrans commonTopTitleNoTrans2;
        ImageView leftImg;
        FmQuestionDetailBinding p = p();
        if (p != null && (commonTopTitleNoTrans2 = p.b) != null && (leftImg = commonTopTitleNoTrans2.getLeftImg()) != null) {
            leftImg.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.setting.fragment.-$$Lambda$QuestionDetailFragment$TC2k58hEF1ZlVX5i9Gh7Vk-nz_U
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    QuestionDetailFragment.a(QuestionDetailFragment.this, view);
                }
            });
        }
        Bundle arguments = getArguments();
        if (arguments == null) {
            return;
        }
        Serializable serializable = arguments.getSerializable("data");
        if (serializable == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.sobot.chat.api.model.StDocModel");
        }
        this.f33577c = (StDocModel) serializable;
        FmQuestionDetailBinding p2 = p();
        if (p2 != null && (commonTopTitleNoTrans = p2.b) != null) {
            commonTopTitleNoTrans.setCenterText(arguments.getString("title"));
        }
        q();
    }

    @Override // com.blued.android.module.common.base.mvvm.MVVMBaseFragment
    public void l() {
    }

    @Override // com.blued.android.module.common.base.mvvm.MVVMBaseFragment, com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ServiceHelper serviceHelper = ServiceHelper.f33645a;
        View requireView = requireView();
        Intrinsics.c(requireView, "requireView()");
        serviceHelper.a(requireView);
    }
}
