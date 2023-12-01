package com.soft.blued.ui.group;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.anythink.expressad.video.dynview.a.a;
import com.blued.android.core.AppMethods;
import com.blued.android.core.BlueAppLocal;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.user.model.VerifyStatus;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.android.module.common.widget.dialog.CommonAlertDialog;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.http.GroupHttpUtils;
import com.soft.blued.ui.group.model.BluedGroupAdminLists;
import com.soft.blued.ui.setting.fragment.PersonalVerifyFragment;
import com.soft.blued.ui.user.presenter.PayUtils;
import com.soft.blued.user.BluedConfig;
import com.soft.blued.utils.StringUtils;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/group/GroupUpdateCountFragment.class */
public class GroupUpdateCountFragment extends BaseFragment implements View.OnClickListener {
    private static String j;
    private static String k;

    /* renamed from: c  reason: collision with root package name */
    private View f30861c;
    private Context d;
    private TextView e;
    private LinearLayout f;
    private LinearLayout g;
    private LinearLayout h;
    private Dialog i;
    private int l;
    private TextView m;
    private TextView n;
    private String o;
    private TextView p;
    private LinearLayout q;
    private ImageView r;
    private String b = GroupUpdateCountFragment.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    public BluedUIHttpResponse f30860a = new BluedUIHttpResponse<BluedEntityA<BluedGroupAdminLists>>() { // from class: com.soft.blued.ui.group.GroupUpdateCountFragment.4
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        /* renamed from: a */
        public void onUIUpdate(BluedEntityA<BluedGroupAdminLists> bluedEntityA) {
            AppMethods.d((int) R.string.done);
            GroupUpdateCountFragment.this.p.setVisibility(8);
            GroupUpdateCountFragment.this.q.setVisibility(0);
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public void onUIFinish() {
            super.onUIFinish();
            DialogUtils.b(GroupUpdateCountFragment.this.i);
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public void onUIStart() {
            super.onUIStart();
            DialogUtils.a(GroupUpdateCountFragment.this.i);
        }
    };

    private void c() {
        CommonTopTitleNoTrans commonTopTitleNoTrans = (CommonTopTitleNoTrans) this.f30861c.findViewById(2131370749);
        commonTopTitleNoTrans.a();
        commonTopTitleNoTrans.setCenterText(getString(R.string.up_group));
        commonTopTitleNoTrans.setLeftClickListener(this);
    }

    private void d() {
        this.i = DialogUtils.a(this.d);
        this.h = (LinearLayout) this.f30861c.findViewById(R.id.ll_already_upgraded);
        this.m = (TextView) this.f30861c.findViewById(R.id.up_verify_title);
        TextView textView = (TextView) this.f30861c.findViewById(R.id.up_group_verify);
        this.n = textView;
        textView.setOnClickListener(this);
        this.e = (TextView) this.f30861c.findViewById(R.id.no_update);
        this.f = (LinearLayout) this.f30861c.findViewById(R.id.liner_update);
        this.g = (LinearLayout) this.f30861c.findViewById(R.id.up_verify_title_liner);
        TextView textView2 = (TextView) this.f30861c.findViewById(R.id.up_vip_group_verify);
        this.p = textView2;
        textView2.setOnClickListener(this);
        this.q = (LinearLayout) this.f30861c.findViewById(R.id.ll_vip_already_upgraded);
        ImageView imageView = (ImageView) this.f30861c.findViewById(R.id.iv_vip_icon);
        this.r = imageView;
        if (this.l == 2) {
            imageView.setImageResource(2131233998);
        }
        int i = this.l;
        if (i == 0 || ((i == 1 && UserInfo.getInstance().getLoginUserInfo().vip_grade == 2) || (this.l == 3 && UserInfo.getInstance().getLoginUserInfo().vip_grade == 2))) {
            this.p.setVisibility(0);
            this.q.setVisibility(4);
        } else {
            this.p.setVisibility(8);
            this.q.setVisibility(0);
        }
        if (Integer.parseInt(j) >= 100) {
            this.n.setVisibility(8);
            this.g.setVisibility(8);
            this.h.setVisibility(0);
        } else if (!StringUtils.d(k)) {
            if (k.equals("2")) {
                this.f.setVisibility(8);
                this.e.setVisibility(0);
                if (a.V.equals(BlueAppLocal.c().getLanguage())) {
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.d.getResources().getString(R.string.up_already_blue));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan((int) Color.BLUE), 4, 8, 34);
                    this.e.setText(spannableStringBuilder);
                } else {
                    this.e.setText(R.string.up_already_blue);
                }
            } else if (k.equals("3")) {
                this.f.setVisibility(8);
                this.e.setVisibility(0);
                if (a.V.equals(BlueAppLocal.c().getLanguage())) {
                    SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(this.d.getResources().getString(R.string.up_already_purple));
                    spannableStringBuilder2.setSpan(new ForegroundColorSpan(Color.rgb(255, 0, 255)), 4, 8, 34);
                    this.e.setText(spannableStringBuilder2);
                } else {
                    this.e.setText(R.string.up_already_purple);
                }
            } else {
                this.n.setVisibility(0);
                this.h.setVisibility(8);
                this.m.setText(R.string.up_condition_need_icon_verify);
            }
        }
        ((TerminalActivity) getActivity()).a(new TerminalActivity.IRestartListener() { // from class: com.soft.blued.ui.group.GroupUpdateCountFragment.1
            @Override // com.blued.android.core.ui.TerminalActivity.IRestartListener
            public void a() {
                GroupUpdateCountFragment.this.e();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        GroupHttpUtils.k(null, new BluedUIHttpResponse<BluedEntityA<VerifyStatus>>() { // from class: com.soft.blued.ui.group.GroupUpdateCountFragment.2
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<VerifyStatus> bluedEntityA) {
                if (bluedEntityA != null) {
                    try {
                        if (bluedEntityA.hasData()) {
                            UserInfo.getInstance().getLoginUserInfo().setVerify(new VerifyStatus[]{bluedEntityA.data.get(0)});
                            if ("1".equals(bluedEntityA.data.get(0).has_audited)) {
                                GroupUpdateCountFragment.this.n.setVisibility(8);
                                GroupUpdateCountFragment.this.g.setVisibility(8);
                                GroupUpdateCountFragment.this.h.setVisibility(0);
                                return;
                            }
                            GroupUpdateCountFragment.this.n.setVisibility(0);
                            GroupUpdateCountFragment.this.h.setVisibility(8);
                            GroupUpdateCountFragment.this.g.setVisibility(0);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }, UserInfo.getInstance().getLoginUserInfo().getUid(), null);
    }

    private void f() {
        PayUtils.a(getActivity(), 8, "group_member_expand");
    }

    private void g() {
        CommonAlertDialog.a(this.d, "", getString(R.string.upgrade_this_group), getString(R.string.submit), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.group.GroupUpdateCountFragment.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Tracker.onClick(dialogInterface, i);
                GroupUpdateCountFragment.this.b();
            }
        }, (String) null, (DialogInterface.OnClickListener) null, (DialogInterface.OnDismissListener) null);
    }

    public void a() {
        Bundle arguments = getArguments();
        if (arguments == null) {
            return;
        }
        this.o = arguments.getString("gid");
        j = arguments.getString("up_group_total");
        this.l = arguments.getInt("groups_member_vip");
        k = UserInfo.getInstance().getLoginUserInfo().getVBadge() + "";
    }

    public void b() {
        GroupHttpUtils.c(this.d, this.f30860a, this.o, "0", "1", getFragmentActive());
    }

    @Override // com.blued.android.core.ui.BaseFragment, com.blued.android.core.ui.BaseFragmentActivity.IOnBackPressedListener
    public boolean onBackPressed() {
        getActivity().setResult(-1);
        getActivity().finish();
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        int id = view.getId();
        if (id == 2131363120) {
            getActivity().setResult(-1);
            getActivity().finish();
        } else if (id == 2131373014) {
            PersonalVerifyFragment.a(getActivity());
        } else if (id != 2131373017) {
        } else {
            if (UserInfo.getInstance().getLoginUserInfo().vip_grade == 0 && BluedConfig.a().g().is_improve_grouplist == 0) {
                f();
            } else {
                g();
            }
        }
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.d = getActivity();
        View view = this.f30861c;
        if (view == null) {
            this.f30861c = layoutInflater.inflate(R.layout.fragment_group_upcount_set, viewGroup, false);
            a();
            c();
            d();
            e();
        } else if (view.getParent() != null) {
            ((ViewGroup) this.f30861c.getParent()).removeView(this.f30861c);
        }
        return this.f30861c;
    }
}
