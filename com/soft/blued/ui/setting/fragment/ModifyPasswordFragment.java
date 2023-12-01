package com.soft.blued.ui.setting.fragment;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.blued.android.core.AppMethods;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.http.BluedHttpTools;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.android.module.common.view.CommonEdittextView;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.http.MineHttpUtils;
import com.soft.blued.utils.StringUtils;
import com.soft.blued.utils.password.PasswordCheckUtils;
import com.soft.blued.utils.password.PasswordStatusView;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/fragment/ModifyPasswordFragment.class */
public class ModifyPasswordFragment extends BaseFragment implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public BluedUIHttpResponse f33430a = new BluedUIHttpResponse() { // from class: com.soft.blued.ui.setting.fragment.ModifyPasswordFragment.1
        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public void onUIFinish() {
            super.onUIFinish();
            DialogUtils.b(ModifyPasswordFragment.this.f33431c);
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public void onUIStart() {
            super.onUIStart();
            DialogUtils.a(ModifyPasswordFragment.this.f33431c);
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public void onUIUpdate(BluedEntity bluedEntity) {
            try {
                DialogUtils.b(ModifyPasswordFragment.this.f33431c);
                AppMethods.d((int) R.string.modify_success);
                BluedHttpTools.b(ModifyPasswordFragment.this.g.getText().toString());
                ModifyPasswordFragment.this.getActivity().finish();
            } catch (Exception e) {
            }
        }
    };
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private Dialog f33431c;
    private View d;
    private CommonEdittextView e;
    private CommonEdittextView f;
    private CommonEdittextView g;
    private TextView h;
    private PasswordStatusView i;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(boolean z) {
        if (z) {
            this.h.setEnabled(false);
        } else {
            this.h.setEnabled(true);
        }
    }

    public void a() {
        CommonTopTitleNoTrans commonTopTitleNoTrans = (CommonTopTitleNoTrans) this.d.findViewById(2131370749);
        commonTopTitleNoTrans.a();
        commonTopTitleNoTrans.setLeftClickListener(this);
        commonTopTitleNoTrans.setRightClickListener(this);
        commonTopTitleNoTrans.f();
        CommonEdittextView commonEdittextView = (CommonEdittextView) this.d.findViewById(R.id.et_origion_pwd);
        this.e = commonEdittextView;
        commonEdittextView.getEditText().setInputType(128);
        CommonEdittextView commonEdittextView2 = (CommonEdittextView) this.d.findViewById(R.id.et_new_pwd);
        this.f = commonEdittextView2;
        commonEdittextView2.getEditText().setInputType(128);
        CommonEdittextView commonEdittextView3 = (CommonEdittextView) this.d.findViewById(R.id.et_new_pwd_confirm);
        this.g = commonEdittextView3;
        commonEdittextView3.getEditText().setInputType(128);
        TextView textView = (TextView) this.d.findViewById(2131371023);
        this.h = textView;
        textView.setOnClickListener(this);
        this.f33431c = DialogUtils.a(getActivity());
        PasswordStatusView passwordStatusView = (PasswordStatusView) this.d.findViewById(R.id.pwd_check_view);
        this.i = passwordStatusView;
        passwordStatusView.a(this.f.getEditText(), this.g.getEditText(), UserInfo.getInstance().getUserName(), UserInfo.getInstance().getLoginUserInfo().name, PasswordCheckUtils.PWD_CHECK_PAGE.MODIFY_PWD, getFragmentActive(), new PasswordStatusView.OnCheckResult() { // from class: com.soft.blued.ui.setting.fragment.-$$Lambda$ModifyPasswordFragment$nIcibWCFRoocUgzJDiOntm982o8
            @Override // com.soft.blued.utils.password.PasswordStatusView.OnCheckResult
            public final void onResult(boolean z) {
                ModifyPasswordFragment.this.a(z);
            }
        });
    }

    public void a(String str, String str2) {
        MineHttpUtils.i(getActivity(), this.f33430a, UserInfo.getInstance().getLoginUserInfo().getUid(), str, str2, getFragmentActive());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        int id = view.getId();
        if (id == 2131363120) {
            getActivity().finish();
        } else if (id != 2131371023) {
        } else {
            if (StringUtils.d(this.e.getText().toString()) || StringUtils.d(this.f.getText().toString()) || StringUtils.d(this.g.getText().toString())) {
                AppMethods.d((int) R.string.pwd_errorone);
            } else if (this.f.getText().toString().length() < 8) {
                AppMethods.d(2131886713);
            } else if (this.f.getText().toString().equals(this.g.getText().toString())) {
                a(this.e.getText().toString(), this.g.getText().toString());
            } else {
                AppMethods.d((int) R.string.pwd_errorthree);
            }
        }
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view = this.d;
        if (view == null) {
            this.d = layoutInflater.inflate(R.layout.fragment_modify_pwd, viewGroup, false);
            this.b = ModifyPasswordFragment.class.getSimpleName();
            a();
        } else if (view.getParent() != null) {
            ((ViewGroup) this.d.getParent()).removeView(this.d);
        }
        return this.d;
    }
}
