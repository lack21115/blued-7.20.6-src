package com.soft.blued.ui.setting.fragment;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewbinding.ViewBinding;
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
    static final /* synthetic */ KProperty<Object>[] f19885a = {(KProperty) Reflection.a(new PropertyReference1Impl(QuestionDetailFragment.class, "vb", "getVb()Lcom/soft/blued/databinding/FmQuestionDetailBinding;", 0))};
    private final ViewBindingProperty b;

    /* renamed from: c  reason: collision with root package name */
    private StDocModel f19886c;

    public QuestionDetailFragment() {
        super((int) R.layout.fm_question_detail);
        this.b = ((Fragment) this) instanceof DialogFragment ? (ViewBindingProperty) new DialogFragmentViewBindingProperty(new Function1<QuestionDetailFragment, FmQuestionDetailBinding>() { // from class: com.soft.blued.ui.setting.fragment.QuestionDetailFragment$special$$inlined$viewBindingFragment$default$1
            /* JADX WARN: Incorrect types in method signature: (Lcom/soft/blued/ui/setting/fragment/QuestionDetailFragment;)Lcom/soft/blued/databinding/FmQuestionDetailBinding; */
            /* renamed from: a */
            public final ViewBinding invoke(Fragment fragment) {
                Intrinsics.e(fragment, "fragment");
                return FmQuestionDetailBinding.a(fragment.requireView());
            }
        }) : new FragmentViewBindingProperty(new Function1<QuestionDetailFragment, FmQuestionDetailBinding>() { // from class: com.soft.blued.ui.setting.fragment.QuestionDetailFragment$special$$inlined$viewBindingFragment$default$2
            /* JADX WARN: Incorrect types in method signature: (Lcom/soft/blued/ui/setting/fragment/QuestionDetailFragment;)Lcom/soft/blued/databinding/FmQuestionDetailBinding; */
            /* renamed from: a */
            public final ViewBinding invoke(Fragment fragment) {
                Intrinsics.e(fragment, "fragment");
                return FmQuestionDetailBinding.a(fragment.requireView());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(QuestionDetailFragment questionDetailFragment, View view) {
        Tracker.onClick(view);
        Intrinsics.e(questionDetailFragment, "this$0");
        FragmentActivity activity = questionDetailFragment.getActivity();
        if (activity == null) {
            return;
        }
        activity.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FmQuestionDetailBinding p() {
        return (FmQuestionDetailBinding) this.b.b(this, f19885a[0]);
    }

    private final void q() {
        ZhiChiApi zhiChiApi = SobotMsgManager.getInstance(getActivity()).getZhiChiApi();
        FragmentActivity activity = getActivity();
        String string = getString(R.string.sobot_app_key);
        StDocModel stDocModel = this.f19886c;
        StDocModel stDocModel2 = stDocModel;
        if (stDocModel == null) {
            Intrinsics.c("docModel");
            stDocModel2 = null;
        }
        zhiChiApi.getHelpDocByDocId(activity, string, stDocModel2.getDocId(), new StringResultCallBack<StHelpDocModel>() { // from class: com.soft.blued.ui.setting.fragment.QuestionDetailFragment$getQuestionDetail$1
            @Override // com.sobot.network.http.callback.StringResultCallBack
            /* renamed from: a */
            public void onSuccess(StHelpDocModel stHelpDocModel) {
                FmQuestionDetailBinding p;
                FmQuestionDetailBinding p2;
                Intrinsics.e(stHelpDocModel, "data");
                if (TextUtils.isEmpty(stHelpDocModel.getAnswerDesc())) {
                    return;
                }
                p = QuestionDetailFragment.this.p();
                TextView textView = p == null ? null : p.d;
                if (textView != null) {
                    textView.setText(Intrinsics.a("· ", stHelpDocModel.getQuestionTitle()));
                }
                p2 = QuestionDetailFragment.this.p();
                TextView textView2 = p2 == null ? null : p2.f15070c;
                if (textView2 == null) {
                    return;
                }
                textView2.setText(TypefaceUtils.a((Context) QuestionDetailFragment.this.getActivity(), stHelpDocModel.getAnswerDesc(), false, (TypefaceUtils.ClickLinkListener) null));
            }

            @Override // com.sobot.network.http.callback.StringResultCallBack
            public void onFailure(Exception exc, String str) {
                Intrinsics.e(exc, "e");
                Intrinsics.e(str, "des");
                ToastUtil.showToast(QuestionDetailFragment.this.getActivity(), str);
            }
        });
    }

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
        this.f19886c = (StDocModel) serializable;
        FmQuestionDetailBinding p2 = p();
        if (p2 != null && (commonTopTitleNoTrans = p2.b) != null) {
            commonTopTitleNoTrans.setCenterText(arguments.getString("title"));
        }
        q();
    }

    public void l() {
    }

    public void onResume() {
        super.onResume();
        ServiceHelper serviceHelper = ServiceHelper.f19954a;
        View requireView = requireView();
        Intrinsics.c(requireView, "requireView()");
        serviceHelper.a(requireView);
    }
}
