package com.soft.blued.ui.group;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextWatcher;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.core.AppMethods;
import com.blued.android.core.BlueAppLocal;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.pool.ThreadExecutor;
import com.blued.android.framework.pool.ThreadManager;
import com.blued.android.module.common.log.oldtrack.LogData;
import com.blued.android.module.common.url.H5Url;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.user.model.VerifyStatus;
import com.blued.android.module.common.utils.CommonPreferences;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.android.module.common.view.NoDataAndLoadFailView;
import com.blued.das.message.MessageProtos;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.http.GroupHttpUtils;
import com.soft.blued.ui.group.model.BluedCreatedGroupInfo;
import com.soft.blued.ui.group.model.BluedGroupCheck;
import com.soft.blued.ui.msg.controller.tools.ChatHelperV4;
import com.soft.blued.ui.msg.model.MsgSourceEntity;
import com.soft.blued.ui.setting.fragment.PersonalVerifyFragment;
import com.soft.blued.ui.user.fragment.ChooseCountryFragment;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import com.soft.blued.utils.Logger;
import com.soft.blued.utils.StringUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/group/GroupCreateFragment.class */
public class GroupCreateFragment extends BaseFragment implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public static int f30759a = 256;

    /* renamed from: c  reason: collision with root package name */
    public static String f30760c = "account";
    public static String d = "groupNum";
    public static String e = "groupNumRest";
    public static String f = "accountAble";
    public static String g = "groupAble";
    private ImageView A;
    private ImageView B;
    private TextView C;
    private String D;
    private String E;
    private String F;
    private String G;
    private String H;
    private String I;
    public BluedGroupCheck.GroupFailureReason b;
    private View l;
    private CommonTopTitleNoTrans m;
    private EditText n;
    private EditText o;
    private TextView p;
    private Context q;
    private Dialog r;
    private List<BluedCreatedGroupInfo> s;
    private View t;
    private View u;
    private NoDataAndLoadFailView v;
    private TextView w;
    private TextView x;
    private TextView y;
    private TextView z;
    private String k = GroupCreateFragment.class.getSimpleName();
    private BluedUIHttpResponse J = new BluedUIHttpResponse<BluedEntityA<BluedGroupCheck>>() { // from class: com.soft.blued.ui.group.GroupCreateFragment.3
        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        /* renamed from: a */
        public void onUIUpdate(BluedEntityA<BluedGroupCheck> bluedEntityA) {
            if (GroupCreateFragment.this.getFragmentActive() == null || !GroupCreateFragment.this.getFragmentActive().isActive()) {
                return;
            }
            if (bluedEntityA != null) {
                try {
                    if (bluedEntityA.hasData()) {
                        GroupCreateFragment.this.v.d();
                        if ("1".equals(bluedEntityA.data.get(0).getAble())) {
                            GroupCreateFragment.this.t.setVisibility(0);
                            GroupCreateFragment.this.u.setVisibility(8);
                            GroupCreateFragment.this.getActivity().getWindow().setSoftInputMode(21);
                            return;
                        }
                        GroupCreateFragment.this.t.setVisibility(8);
                        GroupCreateFragment.this.u.setVisibility(0);
                        GroupCreateFragment.this.b = bluedEntityA.data.get(0).getReason();
                        GroupCreateFragment.this.D = GroupCreateFragment.this.b.getDays().getAble();
                        GroupCreateFragment.this.F = GroupCreateFragment.this.b.getDays().getReason();
                        GroupCreateFragment.this.E = GroupCreateFragment.this.b.getNum().getAble();
                        GroupCreateFragment.this.G = GroupCreateFragment.this.b.getNum().getReason().get(0);
                        GroupCreateFragment.this.H = GroupCreateFragment.this.b.getNum().getReason().get(1);
                        GroupCreateFragment.this.c();
                        return;
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                    AppMethods.a((CharSequence) GroupCreateFragment.this.getResources().getString(2131887272));
                    GroupCreateFragment.this.v.b();
                    return;
                }
            }
            GroupCreateFragment.this.v.b();
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse, com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.http.AbstractHttpResponseHandler
        public void onFailure(Throwable th, int i, String str) {
            super.onFailure(th, i, str);
            GroupCreateFragment.this.postSafeRunOnUiThread(new Runnable() { // from class: com.soft.blued.ui.group.GroupCreateFragment.3.1
                @Override // java.lang.Runnable
                public void run() {
                    GroupCreateFragment.this.v.b();
                }
            });
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public void onUIFinish() {
            Logger.a(GroupCreateFragment.this.k, "onFinish");
            DialogUtils.b(GroupCreateFragment.this.r);
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public void onUIStart() {
            DialogUtils.a(GroupCreateFragment.this.r);
        }
    };
    public BluedUIHttpResponse h = new BluedUIHttpResponse<BluedEntity>() { // from class: com.soft.blued.ui.group.GroupCreateFragment.4
        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public void onUIUpdate(BluedEntity bluedEntity) {
            new Bundle().putString("groupName", GroupCreateFragment.this.n.getText().toString());
            GroupHttpUtils.d(GroupCreateFragment.this.q, GroupCreateFragment.this.i, GroupCreateFragment.this.o.getText().toString(), GroupCreateFragment.this.getFragmentActive());
        }
    };
    public BluedUIHttpResponse i = new BluedUIHttpResponse<BluedEntity>() { // from class: com.soft.blued.ui.group.GroupCreateFragment.5
        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public void onUIUpdate(BluedEntity bluedEntity) {
            ChooseCountryFragment.a(GroupCreateFragment.this, 8000);
        }
    };
    public BluedUIHttpResponse j = new BluedUIHttpResponse<BluedEntityA<BluedCreatedGroupInfo>>() { // from class: com.soft.blued.ui.group.GroupCreateFragment.6
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        /* renamed from: a */
        public void onUIUpdate(BluedEntityA<BluedCreatedGroupInfo> bluedEntityA) {
            if (bluedEntityA == null || !bluedEntityA.hasData()) {
                return;
            }
            AppMethods.a((CharSequence) GroupCreateFragment.this.getResources().getString(R.string.group_create_successful));
            GroupCreateFragment.this.s.clear();
            GroupCreateFragment.this.s.addAll(bluedEntityA.data);
            GroupCreateFragment.this.g();
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public void onUIFinish() {
            super.onUIFinish();
            DialogUtils.b(GroupCreateFragment.this.r);
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public void onUIStart() {
            super.onUIStart();
            DialogUtils.a(GroupCreateFragment.this.r);
        }
    };
    private TextWatcher K = new TextWatcher() { // from class: com.soft.blued.ui.group.GroupCreateFragment.8
        private int b;

        /* renamed from: c  reason: collision with root package name */
        private int f30771c;

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            try {
                this.b = GroupCreateFragment.this.o.getSelectionStart();
                this.f30771c = GroupCreateFragment.this.o.getSelectionEnd();
                GroupCreateFragment.this.o.removeTextChangedListener(GroupCreateFragment.this.K);
                while (editable.length() > GroupCreateFragment.f30759a) {
                    editable.delete(this.b - 1, this.f30771c);
                    this.b--;
                    this.f30771c--;
                }
                int length = editable.length();
                GroupCreateFragment.this.p.setText(length + " ");
                GroupCreateFragment.this.o.setSelection(this.b);
                GroupCreateFragment.this.o.addTextChangedListener(GroupCreateFragment.this.K);
            } catch (Exception e2) {
                e2.printStackTrace();
                GroupCreateFragment.this.p.setText("");
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    };

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/group/GroupCreateFragment$RevoClickSpan.class */
    public class RevoClickSpan extends ClickableSpan {

        /* renamed from: a  reason: collision with root package name */
        Context f30772a;

        public RevoClickSpan(Context context) {
            this.f30772a = context;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            Selection.removeSelection((Spannable) ((TextView) view).getText());
            WebViewShowInfoFragment.show(this.f30772a, H5Url.a(27), 0);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(this.f30772a.getResources().getColor(2131101220));
            textPaint.setUnderlineText(false);
        }
    }

    private void a() {
        this.s = new ArrayList();
        this.t = this.l.findViewById(R.id.ll_create_group);
        this.u = this.l.findViewById(R.id.ll_create_failed);
        NoDataAndLoadFailView noDataAndLoadFailView = (NoDataAndLoadFailView) this.l.findViewById(2131368727);
        this.v = noDataAndLoadFailView;
        noDataAndLoadFailView.setFailBtnListener(new View.OnClickListener() { // from class: com.soft.blued.ui.group.GroupCreateFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                GroupCreateFragment.this.d();
                GroupCreateFragment.this.e();
            }
        });
        TextView textView = (TextView) this.t.findViewById(R.id.tv_word_count);
        this.p = textView;
        textView.setText(((Object) getResources().getText(R.string.group_name_count)) + " ");
        this.n = (EditText) this.t.findViewById(R.id.et_group_name);
        EditText editText = (EditText) this.t.findViewById(R.id.et_group_description);
        this.o = editText;
        editText.addTextChangedListener(this.K);
        EditText editText2 = this.o;
        editText2.setSelection(editText2.length());
        this.y = (TextView) this.l.findViewById(R.id.tv_group_created_account);
        this.z = (TextView) this.l.findViewById(R.id.tv_group_created_amount);
        this.A = (ImageView) this.l.findViewById(R.id.iv_acount_judge);
        this.B = (ImageView) this.l.findViewById(R.id.iv_group_judge);
        this.w = (TextView) this.l.findViewById(R.id.tv_verify_info);
        TextView textView2 = (TextView) this.l.findViewById(R.id.tv_btn_verify);
        this.x = textView2;
        textView2.setOnClickListener(this);
        this.C = (TextView) this.l.findViewById(R.id.tv_group_term);
        String string = this.q.getResources().getString(R.string.group_create_remind);
        String string2 = this.q.getResources().getString(R.string.group_term_link);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string + string2);
        RevoClickSpan revoClickSpan = new RevoClickSpan(this.q);
        int length = (string + string2).length();
        int length2 = string2.length();
        spannableStringBuilder.setSpan(revoClickSpan, length - length2, (string + string2).length(), 33);
        this.C.setText(spannableStringBuilder);
        this.C.setOnClickListener(this);
    }

    private void b() {
        CommonTopTitleNoTrans commonTopTitleNoTrans = (CommonTopTitleNoTrans) this.l.findViewById(2131370749);
        this.m = commonTopTitleNoTrans;
        commonTopTitleNoTrans.a();
        this.m.setCenterText(getString(R.string.group_create));
        this.m.setLeftClickListener(this);
        this.m.setRightClickListener(this);
        this.m.setRightText(this.q.getString(R.string.next_step));
        this.r = DialogUtils.a(this.q);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        try {
            this.m.a();
            if (this.D.equals("0")) {
                TextView textView = this.y;
                textView.setText(getResources().getString(R.string.group_account_less) + " " + this.F + " " + getResources().getString(R.string.group_account_time));
            } else {
                TextView textView2 = this.y;
                textView2.setText(getResources().getString(R.string.group_account_more) + " " + this.F + " " + getResources().getString(R.string.group_account_time));
            }
            if (BlueAppLocal.d()) {
                TextView textView3 = this.z;
                textView3.setText(getResources().getString(R.string.group_created) + " " + this.G + " " + getResources().getString(R.string.group_num) + getResources().getString(R.string.group_num_rest) + " " + this.H + " " + getResources().getString(R.string.group_num_left));
            } else {
                int a2 = StringUtils.a(this.G, 0);
                int a3 = StringUtils.a(this.H, 0);
                this.z.setText(getResources().getString(R.string.group_created) + " " + a2 + " " + getResources().getString(R.string.group_num_rest) + " " + (a3 + a2));
            }
            String charSequence = this.y.getText().toString();
            String charSequence2 = this.z.getText().toString();
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(charSequence);
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(charSequence2);
            if (BlueAppLocal.d()) {
                if (this.D.equals("0")) {
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(this.q.getResources().getColor(2131101201)), 9, 11, 33);
                } else {
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(this.q.getResources().getColor(2131101202)), 9, 11, 33);
                }
                if (this.E.equals("0")) {
                    spannableStringBuilder2.setSpan(new ForegroundColorSpan(this.q.getResources().getColor(2131101201)), 14, 15, 33);
                } else {
                    spannableStringBuilder2.setSpan(new ForegroundColorSpan(this.q.getResources().getColor(2131101202)), 14, 15, 33);
                }
            } else {
                if (this.D.equals("0")) {
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(this.q.getResources().getColor(2131101201)), 13, 15, 33);
                } else {
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(this.q.getResources().getColor(2131101202)), 13, 15, 33);
                }
                if (this.E.equals("0")) {
                    spannableStringBuilder2.setSpan(new ForegroundColorSpan(this.q.getResources().getColor(2131101201)), 15, 16, 33);
                } else {
                    spannableStringBuilder2.setSpan(new ForegroundColorSpan(this.q.getResources().getColor(2131101202)), 15, 16, 33);
                }
            }
            this.y.setText(spannableStringBuilder);
            this.z.setText(spannableStringBuilder2);
            if (this.D.equals("0")) {
                this.A.setBackgroundResource(R.drawable.group_create_object);
            } else {
                this.A.setBackgroundResource(R.drawable.group_create_check);
            }
            if (this.E.equals("0")) {
                this.B.setBackgroundResource(R.drawable.group_create_object);
            } else {
                this.B.setBackgroundResource(R.drawable.group_create_check);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        GroupHttpUtils.b(this.q, this.J, UserInfo.getInstance().getLoginUserInfo().getUid(), null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        GroupHttpUtils.k(null, new BluedUIHttpResponse<BluedEntityA<VerifyStatus>>() { // from class: com.soft.blued.ui.group.GroupCreateFragment.2
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<VerifyStatus> bluedEntityA) {
                if (bluedEntityA != null) {
                    try {
                        if (bluedEntityA.hasData()) {
                            UserInfo.getInstance().getLoginUserInfo().setVerify(new VerifyStatus[]{bluedEntityA.data.get(0)});
                            GroupCreateFragment.this.I = UserInfo.getInstance().getLoginUserInfo().getVerify()[0].has_audited;
                            GroupCreateFragment.this.f();
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            }
        }, UserInfo.getInstance().getLoginUserInfo().getUid(), null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        if ("1".equals(this.I)) {
            this.w.setVisibility(8);
            this.x.setVisibility(8);
            return;
        }
        this.w.setVisibility(0);
        this.x.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        final BluedCreatedGroupInfo bluedCreatedGroupInfo = this.s.get(0);
        if (bluedCreatedGroupInfo == null) {
            return;
        }
        DialogUtils.a(this.r);
        ThreadManager.a().a(new ThreadExecutor("toChat") { // from class: com.soft.blued.ui.group.GroupCreateFragment.7
            @Override // com.blued.android.framework.pool.ThreadExecutor
            public void execute() {
                ChatHelperV4.a().a(GroupCreateFragment.this.q, bluedCreatedGroupInfo);
                GroupCreateFragment.this.postSafeRunOnUiThread(new Runnable() { // from class: com.soft.blued.ui.group.GroupCreateFragment.7.1
                    @Override // java.lang.Runnable
                    public void run() {
                        LogData logData = new LogData();
                        logData.from = "group_create";
                        ChatHelperV4.a().a(GroupCreateFragment.this.q, Long.parseLong(bluedCreatedGroupInfo.groups_gid), bluedCreatedGroupInfo.groups_name, bluedCreatedGroupInfo.groups_avatar, bluedCreatedGroupInfo.vbadge, 0, 0, 0, "", false, 1, 0, logData, new MsgSourceEntity(MessageProtos.StrangerSource.UNKNOWN_STRANGER_SOURCE, ""));
                        DialogUtils.b(GroupCreateFragment.this.r);
                        GroupCreateFragment.this.getActivity().finish();
                    }
                });
            }
        });
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i != 8000) {
            return;
        }
        if (intent == null || StringUtils.d(intent.getStringExtra("areacode"))) {
            AppMethods.d((int) R.string.group_location_prompt);
            return;
        }
        GroupHttpUtils.a(getActivity(), this.j, this.n.getText().toString(), this.o.getText().toString(), intent.getStringExtra("areacode"), CommonPreferences.u(), CommonPreferences.v(), getFragmentActive());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        switch (view.getId()) {
            case 2131363120:
                getActivity().finish();
                return;
            case 2131363126:
                if (!StringUtils.d(this.n.getText().toString()) && !StringUtils.d(this.o.getText().toString())) {
                    GroupHttpUtils.c(this.q, this.h, this.n.getText().toString(), getFragmentActive());
                    return;
                } else if (StringUtils.d(this.n.getText().toString()) || !StringUtils.d(this.o.getText().toString())) {
                    AppMethods.d((int) R.string.group_name_prompt);
                    return;
                } else {
                    AppMethods.d((int) R.string.group_desc_prompt);
                    return;
                }
            case R.id.tv_btn_verify /* 2131371027 */:
                PersonalVerifyFragment.a(getActivity());
                return;
            case R.id.tv_group_term /* 2131371637 */:
                WebViewShowInfoFragment.show(this.q, H5Url.a(27), 0);
                return;
            case 2131372398:
                d();
                e();
                return;
            default:
                return;
        }
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        this.q = getActivity();
        super.onCreate(bundle);
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.l = layoutInflater.inflate(R.layout.fragment_root_create_group, viewGroup, false);
        a();
        b();
        return this.l;
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        d();
        e();
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
    }
}
