package com.soft.blued.ui.group;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiEnterpriseConfig;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.anythink.expressad.video.dynview.a.a;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.BlueAppLocal;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.imagecache.LoadOptions;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.common.login.model.UserBasicModel;
import com.blued.android.module.common.url.BluedHttpUrl;
import com.blued.android.module.common.user.UserInfoHelper;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.android.module.common.utils.TimeAndDateUtils;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.bytedance.applog.tracker.Tracker;
import com.efs.sdk.base.core.util.NetworkUtil;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.reflect.TypeToken;
import com.igexin.push.core.b;
import com.soft.blued.R;
import com.soft.blued.http.GroupHttpUtils;
import com.soft.blued.ui.group.fragment.GroupInfoFragment;
import com.soft.blued.ui.group.model.BluedGroupNotifyInfo;
import com.soft.blued.ui.group.model.BluedGroupOpsAlreadyNotify;
import com.soft.blued.ui.user.fragment.UserInfoFragmentNew;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import com.soft.blued.utils.StringUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/group/GroupNotifyInfoFragment.class */
public class GroupNotifyInfoFragment extends BaseFragment implements View.OnClickListener {
    private String A;
    private String B;
    private String C;
    private String D;
    private String E;
    private String F;
    private String G;
    private String H;
    private String I;
    private String J;
    private String K;
    private String L;
    private String M;
    private String N;
    private int O;
    private int P;
    private LoadOptions Q;
    private LinearLayout b;

    /* renamed from: c  reason: collision with root package name */
    private LinearLayout f17148c;
    private LinearLayout d;
    private LinearLayout e;
    private TextView f;
    private TextView g;
    private TextView h;
    private TextView i;
    private TextView j;
    private TextView k;
    private TextView l;
    private TextView m;
    private TextView n;
    private TextView o;
    private TextView p;
    private TextView q;
    private Button r;
    private Button s;
    private ImageView t;
    private ImageView u;
    private View v;
    private Context w;
    private Dialog x;
    private String y;
    private String z;

    /* renamed from: a  reason: collision with root package name */
    private String f17147a = GroupNotifyInfoFragment.class.getSimpleName();
    private String R = "/";

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/group/GroupNotifyInfoFragment$Clickable.class */
    public class Clickable extends ClickableSpan {
        private Context b;

        /* renamed from: c  reason: collision with root package name */
        private String f17154c;
        private String d;
        private String e;

        public Clickable(Context context, String str, String str2, String str3) {
            this.b = context;
            this.f17154c = str;
            this.d = str2;
            this.e = str3;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            if (StringUtils.d(this.f17154c)) {
                UserInfoFragmentNew.d(this.b, this.d, "");
            } else {
                UserInfoFragmentNew.a(this.b, this.f17154c, "");
            }
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(this.b.getResources().getColor(2131101285));
            textPaint.setUnderlineText(false);
        }
    }

    private void a() {
        String str;
        String str2;
        String str3;
        this.x = DialogUtils.a(this.w);
        LinearLayout linearLayout = (LinearLayout) this.v.findViewById(R.id.ll_group_notify_info_user);
        this.b = linearLayout;
        linearLayout.setOnClickListener(this);
        this.f17148c = (LinearLayout) this.v.findViewById(R.id.ll_group_notify_oprate);
        this.d = (LinearLayout) this.v.findViewById(R.id.ll_group_notify_info_detail);
        this.e = (LinearLayout) this.v.findViewById(R.id.ll_group_notify_apply_detail);
        this.f = (TextView) this.v.findViewById(R.id.tv_user_name);
        this.g = (TextView) this.v.findViewById(R.id.tv_user_info);
        TextView textView = (TextView) this.v.findViewById(R.id.tv_group_name);
        this.h = textView;
        textView.setOnClickListener(this);
        this.i = (TextView) this.v.findViewById(R.id.tv_group_apply_describe);
        this.l = (TextView) this.v.findViewById(R.id.tv_group_notify_info_time);
        this.m = (TextView) this.v.findViewById(R.id.tv_group_notify_info_description);
        TextView textView2 = (TextView) this.v.findViewById(R.id.tv_group_notify_info_site);
        this.n = textView2;
        textView2.setOnClickListener(this);
        this.o = (TextView) this.v.findViewById(R.id.tv_group_notify_info_division);
        TextView textView3 = (TextView) this.v.findViewById(R.id.tv_group_notify_info_groups);
        this.p = textView3;
        textView3.setOnClickListener(this);
        this.q = (TextView) this.v.findViewById(R.id.tv_group_notify_lock_icon);
        this.k = (TextView) this.v.findViewById(R.id.group_apply_result);
        this.j = (TextView) this.v.findViewById(R.id.tv_group_join_time);
        this.t = (ImageView) this.v.findViewById(R.id.iv_group_profile_pic);
        this.u = (ImageView) this.v.findViewById(R.id.iv_group_notify_info_verify_icon);
        Button button = (Button) this.v.findViewById(R.id.btn_group_refuse);
        this.r = button;
        button.setOnClickListener(this);
        Button button2 = (Button) this.v.findViewById(R.id.btn_group_agree);
        this.s = button2;
        button2.setOnClickListener(this);
        if (getArguments() != null) {
            this.y = getArguments().getString("UID");
            this.A = getArguments().getString("avatar");
            this.z = getArguments().getString(ContactsContract.Contacts.AggregationSuggestions.PARAMETER_MATCH_NICKNAME);
            this.B = getArguments().getString("age");
            this.C = getArguments().getString("height");
            this.D = getArguments().getString("weight");
            this.E = getArguments().getString("role");
            this.J = getArguments().getString("iid");
            if ("-1".equals(this.E)) {
                this.E = Constants.WAVE_SEPARATOR;
            }
            this.F = getArguments().getString("groupName");
            this.G = getArguments().getString("groupId");
            this.H = getArguments().getString("group avatar");
            this.I = getArguments().getString("applyDescrible");
            this.K = getArguments().getString("ops");
            this.L = getArguments().getString("time");
            this.M = getArguments().getString("opsuid");
            this.N = getArguments().getString("opsname");
            this.P = getArguments().getInt("vbadge");
            this.O = getArguments().getInt("type");
        }
        if (2 != this.O) {
            this.e.setVisibility(8);
            this.d.setVisibility(0);
            ImageLoader.a(getFragmentActive(), this.H).c().b(2131237310).a(this.t);
            this.f.setText(this.F);
            if (TextUtils.isEmpty(this.G)) {
                this.g.setVisibility(4);
            } else {
                this.g.setText(getResources().getString(R.string.group_id) + this.G);
            }
            if (TextUtils.isEmpty(this.L)) {
                this.l.setVisibility(4);
            } else {
                String g = TimeAndDateUtils.g(getActivity(), TimeAndDateUtils.c(this.L));
                this.l.setVisibility(0);
                this.l.setText(g);
            }
            int i = this.O;
            if (1 == i) {
                this.n.setVisibility(8);
                this.m.setVisibility(0);
                this.o.setVisibility(0);
                this.m.setText(getResources().getString(R.string.group_info_dissolution));
                return;
            } else if (i != 0) {
                if (3 == i) {
                    this.n.setVisibility(8);
                    a(this.m, this.z, this.y, this.A);
                    return;
                }
                return;
            } else {
                this.m.setVisibility(0);
                this.o.setVisibility(8);
                this.q.setVisibility(0);
                if (BlueAppLocal.d()) {
                    this.n.setText(BluedHttpUrl.e());
                    this.n.setVisibility(0);
                } else {
                    this.n.setVisibility(8);
                }
                this.m.setText(String.format(getResources().getString(R.string.group_notify_info_locked_detail), this.F));
                return;
            }
        }
        this.e.setVisibility(0);
        ImageLoader.a(getFragmentActive(), this.A).c().b(2131237310).a(this.t);
        UserInfoHelper.a(this.u, this.P, 3);
        this.f.setText(this.z);
        if (BlueAppLocal.c().getLanguage().equals(a.V)) {
            str = this.B + this.R + StringUtils.a(this.C, BlueAppLocal.c(), false) + this.R + StringUtils.b(this.D, BlueAppLocal.c(), false) + this.R + this.E;
        } else {
            str = this.B + " yrs" + this.R + StringUtils.a(this.C, BlueAppLocal.c(), true) + this.R + StringUtils.b(this.D, BlueAppLocal.c(), true) + this.R + this.E;
        }
        String replace = str.replace(WifiEnterpriseConfig.EMPTY_VALUE, "").replace(b.l, "");
        while (true) {
            String str4 = replace;
            str2 = str4;
            if (!str4.contains(this.R + this.R)) {
                break;
            }
            replace = str4.replace(this.R + this.R, this.R);
        }
        while (true) {
            str3 = str2;
            if (!str2.contains("  ")) {
                break;
            }
            str2 = str2.replace("  ", " ");
        }
        while (str3.contains(" / / ")) {
            str3 = str3.replace(" / / ", "");
        }
        this.g.setText(str3);
        this.h.setText(this.F);
        if (StringUtils.d(this.I)) {
            this.i.setVisibility(8);
        } else {
            this.i.setText(this.I);
        }
        String uid = UserInfo.getInstance().getLoginUserInfo().getUid();
        if (this.K.equals("allowed")) {
            this.f17148c.setVisibility(8);
            this.k.setVisibility(0);
            if (uid.equals(this.M)) {
                this.k.setText(R.string.group_notify_agree_already_me);
            } else {
                this.k.setText(String.format(this.w.getResources().getString(R.string.group_notify_agree_already), this.N));
            }
        } else if (this.K.equals(NetworkUtil.NETWORK_CLASS_DENIED)) {
            this.f17148c.setVisibility(8);
            this.k.setVisibility(0);
            if (uid.equals(this.M)) {
                this.k.setText(R.string.group_notify_refuse_already_me);
            } else {
                this.k.setText(String.format(this.w.getResources().getString(R.string.group_notify_refuse_already), this.N));
            }
        } else {
            this.f17148c.setVisibility(0);
            this.k.setVisibility(8);
        }
        this.j.setText(TimeAndDateUtils.g(getActivity(), TimeAndDateUtils.c(this.L)));
        GroupHttpUtils.c(this.w, new BluedUIHttpResponse<BluedEntityA<BluedGroupNotifyInfo>>() { // from class: com.soft.blued.ui.group.GroupNotifyInfoFragment.1
            /* JADX INFO: Access modifiers changed from: protected */
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<BluedGroupNotifyInfo> bluedEntityA) {
                try {
                    if (bluedEntityA.hasData()) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.addAll(bluedEntityA.data);
                        String obj = ((BluedGroupNotifyInfo) arrayList.get(0)).operator.toString();
                        GroupNotifyInfoFragment.this.K = ((BluedGroupNotifyInfo) arrayList.get(0)).ops;
                        if ("[]".equals(obj)) {
                            return;
                        }
                        GroupNotifyInfoFragment.this.N = ((LinkedTreeMap) ((BluedGroupNotifyInfo) arrayList.get(0)).operator).get("name").toString();
                        String name = UserInfo.getInstance().getLoginUserInfo().getName();
                        if (GroupNotifyInfoFragment.this.K.equals("allowed")) {
                            GroupNotifyInfoFragment.this.f17148c.setVisibility(8);
                            GroupNotifyInfoFragment.this.k.setVisibility(0);
                            if (name.equals(GroupNotifyInfoFragment.this.N)) {
                                GroupNotifyInfoFragment.this.k.setText(R.string.group_notify_agree_already_me);
                                return;
                            }
                            GroupNotifyInfoFragment.this.k.setText(String.format(GroupNotifyInfoFragment.this.w.getResources().getString(R.string.group_notify_agree_already), GroupNotifyInfoFragment.this.N));
                        } else if (!GroupNotifyInfoFragment.this.K.equals(NetworkUtil.NETWORK_CLASS_DENIED)) {
                            GroupNotifyInfoFragment.this.f17148c.setVisibility(0);
                            GroupNotifyInfoFragment.this.k.setVisibility(8);
                        } else {
                            GroupNotifyInfoFragment.this.f17148c.setVisibility(8);
                            GroupNotifyInfoFragment.this.k.setVisibility(0);
                            if (name.equals(GroupNotifyInfoFragment.this.N)) {
                                GroupNotifyInfoFragment.this.k.setText(R.string.group_notify_refuse_already_me);
                                return;
                            }
                            GroupNotifyInfoFragment.this.k.setText(String.format(GroupNotifyInfoFragment.this.w.getResources().getString(R.string.group_notify_refuse_already), GroupNotifyInfoFragment.this.N));
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            public void onUIFinish() {
                super.onUIFinish();
                DialogUtils.b(GroupNotifyInfoFragment.this.x);
            }

            public void onUIStart() {
                super.onUIStart();
                DialogUtils.a(GroupNotifyInfoFragment.this.x);
            }
        }, UserInfo.getInstance().getLoginUserInfo().getUid(), this.J, getFragmentActive());
    }

    private void a(TextView textView, String str, String str2, String str3) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(String.format(getResources().getString(R.string.group_notify_kicked), str));
        if (TextUtils.isEmpty(str)) {
            textView.setVisibility(4);
            return;
        }
        textView.setVisibility(0);
        if (BlueAppLocal.d()) {
            spannableStringBuilder.setSpan(new Clickable(getActivity(), str2, str, str3), 4, str.length() + 4, 33);
        } else {
            spannableStringBuilder.setSpan(new Clickable(getActivity(), str2, str, str3), 24, str.length() + 24, 33);
        }
        textView.setText(spannableStringBuilder);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
    }

    private void a(final boolean z) {
        GroupHttpUtils.d(getActivity(), new BluedUIHttpResponse<BluedEntity>() { // from class: com.soft.blued.ui.group.GroupNotifyInfoFragment.2

            /* renamed from: a  reason: collision with root package name */
            boolean f17150a;
            int b;

            /* renamed from: c  reason: collision with root package name */
            String f17151c;

            public boolean onUIFailure(int i, String str, String str2) {
                this.f17150a = true;
                this.b = i;
                this.f17151c = str2;
                return super.onUIFailure(i, str, str2);
            }

            public void onUIFinish() {
                super.onUIFinish();
                DialogUtils.b(GroupNotifyInfoFragment.this.x);
                if (this.f17150a && this.b == 403009014) {
                    this.f17150a = false;
                    if (StringUtils.d(this.f17151c)) {
                        return;
                    }
                    BluedEntity bluedEntity = (BluedEntity) AppInfo.f().fromJson(this.f17151c, new TypeToken<BluedEntity<Object, BluedGroupOpsAlreadyNotify>>() { // from class: com.soft.blued.ui.group.GroupNotifyInfoFragment.2.1
                    }.getType());
                    String uid = UserInfo.getInstance().getLoginUserInfo().getUid();
                    if (((BluedGroupOpsAlreadyNotify) bluedEntity.extra).ops.equals("allowed")) {
                        GroupNotifyInfoFragment.this.f17148c.setVisibility(8);
                        GroupNotifyInfoFragment.this.k.setVisibility(0);
                        if (uid.equals(((BluedGroupOpsAlreadyNotify) bluedEntity.extra).uid)) {
                            GroupNotifyInfoFragment.this.k.setText(R.string.group_notify_agree_already_me);
                        } else {
                            GroupNotifyInfoFragment.this.k.setText(String.format(GroupNotifyInfoFragment.this.w.getResources().getString(R.string.group_notify_agree_already), ((BluedGroupOpsAlreadyNotify) bluedEntity.extra).name));
                        }
                    } else if (((BluedGroupOpsAlreadyNotify) bluedEntity.extra).ops.equals(NetworkUtil.NETWORK_CLASS_DENIED)) {
                        GroupNotifyInfoFragment.this.f17148c.setVisibility(8);
                        GroupNotifyInfoFragment.this.k.setVisibility(0);
                        if (uid.equals(((BluedGroupOpsAlreadyNotify) bluedEntity.extra).uid)) {
                            GroupNotifyInfoFragment.this.k.setText(R.string.group_notify_refuse_already_me);
                        } else {
                            GroupNotifyInfoFragment.this.k.setText(String.format(GroupNotifyInfoFragment.this.w.getResources().getString(R.string.group_notify_refuse_already), ((BluedGroupOpsAlreadyNotify) bluedEntity.extra).name));
                        }
                    } else {
                        GroupNotifyInfoFragment.this.f17148c.setVisibility(0);
                        GroupNotifyInfoFragment.this.k.setVisibility(8);
                    }
                    AppMethods.a(bluedEntity.message);
                }
            }

            public void onUIStart() {
                super.onUIStart();
                DialogUtils.a(GroupNotifyInfoFragment.this.x);
            }

            public void onUIUpdate(BluedEntity bluedEntity) {
                try {
                    GroupNotifyInfoFragment.this.f17148c.setVisibility(8);
                    GroupNotifyInfoFragment.this.k.setVisibility(0);
                    if (z) {
                        GroupNotifyInfoFragment.this.k.setText(R.string.group_notify_agree_already_me);
                    } else {
                        GroupNotifyInfoFragment.this.k.setText(R.string.group_notify_refuse_already_me);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, UserInfo.getInstance().getLoginUserInfo().getUid(), this.J, !z ? NetworkUtil.NETWORK_CLASS_DENIED : "allowed", getFragmentActive());
    }

    private void b() {
        CommonTopTitleNoTrans findViewById = this.v.findViewById(R.id.top_title);
        findViewById.a();
        findViewById.setCenterText(getString(R.string.group_notification));
        findViewById.setLeftClickListener(this);
    }

    private void c() {
        getActivity().setResult(-1, new Intent());
        getActivity().finish();
    }

    public boolean onBackPressed() {
        c();
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        switch (view.getId()) {
            case R.id.btn_group_agree /* 2131362585 */:
                a(true);
                return;
            case R.id.btn_group_refuse /* 2131362589 */:
                a(false);
                return;
            case 2131363120:
                c();
                return;
            case R.id.ll_group_notify_info_user /* 2131367868 */:
                System.currentTimeMillis();
                if (this.O != 2) {
                    GroupInfoFragment.a(this.w, this.G);
                    return;
                }
                UserBasicModel userBasicModel = new UserBasicModel();
                userBasicModel.avatar = this.A;
                userBasicModel.uid = this.y;
                userBasicModel.name = this.z;
                UserInfoFragmentNew.a(this.w, userBasicModel, (String) null, this.t);
                return;
            case R.id.tv_group_name /* 2131371618 */:
                GroupInfoFragment.a(this.w, this.G);
                return;
            case R.id.tv_group_notify_info_groups /* 2131371625 */:
                TerminalActivity.d(getActivity(), GroupFragment.class, (Bundle) null);
                return;
            case R.id.tv_group_notify_info_site /* 2131371626 */:
                WebViewShowInfoFragment.show(this.w, BluedHttpUrl.e(), 7);
                return;
            default:
                return;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.w = getActivity();
        View view = this.v;
        if (view == null) {
            this.v = layoutInflater.inflate(R.layout.fragment_group_notify_info, viewGroup, false);
            LoadOptions loadOptions = new LoadOptions();
            this.Q = loadOptions;
            loadOptions.d = 2131237310;
            this.Q.b = 2131237310;
            a();
            b();
        } else if (view.getParent() != null) {
            ((ViewGroup) this.v.getParent()).removeView(this.v);
        }
        return this.v;
    }
}
