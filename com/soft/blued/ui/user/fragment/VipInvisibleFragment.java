package com.soft.blued.ui.user.fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.http.BluedHttpTools;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.user.model.UserTag;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.android.module.common.widget.dialog.CommonAlertDialog;
import com.blued.community.view.PhotoGridView;
import com.blued.das.profile.PersonalProfileProtos;
import com.blued.das.vip.VipProtos;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.http.PayHttpUtils;
import com.soft.blued.http.ProfileHttpUtils;
import com.soft.blued.log.track.EventTrackPersonalProfile;
import com.soft.blued.log.track.EventTrackVIP;
import com.soft.blued.ui.find.manager.FilterHelper;
import com.soft.blued.ui.find.view.TwoWaysBar;
import com.soft.blued.ui.user.adapter.UserTagAdapter;
import com.soft.blued.ui.user.model.VipInvisibleSettingModel;
import com.soft.blued.ui.user.model.VipUpgradeModel;
import com.soft.blued.ui.user.presenter.PayUtils;
import com.soft.blued.user.BluedConfig;
import com.soft.blued.utils.StringUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/fragment/VipInvisibleFragment.class */
public class VipInvisibleFragment extends BaseFragment implements View.OnClickListener {
    private VipInvisibleSettingModel A;
    private Map<String, String> B;
    private boolean C;
    private Context D;
    private boolean J;
    private RelativeLayout K;

    /* renamed from: a  reason: collision with root package name */
    public VipInvisibleDialogFragment f34163a;
    private View b;

    /* renamed from: c  reason: collision with root package name */
    private ImageView f34164c;
    private TextView d;
    private TwoWaysBar e;
    private ImageView f;
    private ImageView g;
    private PhotoGridView h;
    private ImageView i;
    private TwoWaysBar j;
    private TextView k;
    private TextView l;
    private TextView m;
    private TextView n;
    private String[] o;
    private UserTagAdapter p;
    private boolean r;
    private String s;
    private boolean t;
    private String u;
    private boolean v;
    private String w;
    private boolean x;
    private Dialog y;
    private CommonTopTitleNoTrans z;
    private List<UserTag> q = new ArrayList();
    private String E = "";
    private String F = "";
    private final int G = 0;
    private final int H = 1;
    private final int I = 2;

    /* renamed from: com.soft.blued.ui.user.fragment.VipInvisibleFragment$7  reason: invalid class name */
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/fragment/VipInvisibleFragment$7.class */
    class AnonymousClass7 extends BluedUIHttpResponse<BluedEntityA<Object>> {
        AnonymousClass7() {
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        /* renamed from: a */
        public void onUIUpdate(BluedEntityA<Object> bluedEntityA) {
        }
    }

    private void a() {
        if (getArguments() != null) {
            this.E = getArguments().getString("title");
            this.F = getArguments().getString("KEY_VIP_DETAIL");
        }
        this.B = BluedHttpTools.a();
        String[] a2 = FilterHelper.d().a();
        this.o = a2;
        if (a2.length <= 0) {
            return;
        }
        String[] strArr = new String[a2.length - 1];
        int i = 0;
        while (true) {
            int i2 = i;
            String[] strArr2 = this.o;
            if (i2 >= strArr2.length - 1) {
                this.o = strArr;
                return;
            } else {
                strArr[i2] = strArr2[i2];
                i = i2 + 1;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(AdapterView adapterView, View view, int i, long j) {
        Tracker.onItemClick(adapterView, view, i, j);
        if (this.q.get(i).checked == 1) {
            this.q.get(i).checked = 0;
        } else {
            this.q.get(i).checked = 1;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (UserTag userTag : this.q) {
            if (userTag.checked == 1) {
                if (TextUtils.equals(userTag.id, "0.5")) {
                    stringBuffer.append(userTag.id + ",");
                    stringBuffer.append("0.75,");
                    stringBuffer.append("0.25,");
                } else {
                    stringBuffer.append(userTag.id + ",");
                }
            }
        }
        this.u = stringBuffer.toString();
        Log.v("drb", "invisibleRole:" + this.u);
        this.p.notifyDataSetChanged();
        this.C = true;
    }

    private void a(final String str, final int i, final VipProtos.FromType fromType) {
        PayHttpUtils.c(new BluedUIHttpResponse<BluedEntityA<VipUpgradeModel>>(getFragmentActive()) { // from class: com.soft.blued.ui.user.fragment.VipInvisibleFragment.6
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<VipUpgradeModel> bluedEntityA) {
                if (bluedEntityA == null || bluedEntityA.data == null || bluedEntityA.data.size() <= 0) {
                    PayUtils.a(VipInvisibleFragment.this.D, 2, str, i, fromType);
                } else {
                    VipUpgradeDialogFragment.f34178a.a(VipInvisibleFragment.this.getContext(), VipInvisibleFragment.this.getParentFragmentManager(), bluedEntityA.data, 2, str, i, VipProtos.FromType.UNKNOWN_FROM);
                }
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i2, String str2, String str3) {
                PayUtils.a(VipInvisibleFragment.this.D, 2, str, i, fromType);
                return true;
            }
        }, getFragmentActive());
    }

    private void a(boolean z) {
        this.f34164c.setSelected(z);
        if (z) {
            d(false);
            e(false);
            c(false);
            b(false);
        } else {
            b(true);
        }
        this.r = z;
    }

    private boolean a(int i) {
        String str;
        if (BluedConfig.a().g().is_invisible_all == 1) {
            return true;
        }
        switch (i) {
            case R.id.sbt_age_onoff /* 2131369609 */:
                str = "vip_center_super_hide_age_svip";
                break;
            case R.id.sbt_all_onoff /* 2131369611 */:
                str = "vip_center_super_hide_all_svip";
                break;
            case R.id.sbt_distance_onoff /* 2131369612 */:
                str = "vip_center_super_hide_distance_svip";
                break;
            case R.id.sbt_role_onoff /* 2131369616 */:
                str = "vip_center_super_hide_role_svip";
                break;
            default:
                str = "";
                break;
        }
        if (!TextUtils.isEmpty(this.F)) {
            str = this.F;
        }
        a(str, 4, VipProtos.FromType.UNKNOWN_FROM);
        return false;
    }

    private void b() {
        CommonTopTitleNoTrans commonTopTitleNoTrans = (CommonTopTitleNoTrans) this.b.findViewById(2131370749);
        this.z = commonTopTitleNoTrans;
        commonTopTitleNoTrans.setCenterText(this.E);
        this.z.setRightText(R.string.done);
        this.z.setLeftClickListener(this);
        this.z.setRightClickListener(this);
        this.z.getTitleBackground().setBackground(new ColorDrawable(0));
        ShapeTextView rightTextView = this.z.getRightTextView();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) rightTextView.getLayoutParams();
        layoutParams.rightMargin = DensityUtils.a(getContext(), 10.0f);
        rightTextView.setLayoutParams(layoutParams);
        rightTextView.setTextColor(getResources().getColor(2131101766));
        ImageView leftImg = this.z.getLeftImg();
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) leftImg.getLayoutParams();
        layoutParams2.leftMargin = DensityUtils.a(getContext(), 10.0f);
        leftImg.setLayoutParams(layoutParams2);
        leftImg.setImageResource(2131233904);
    }

    private void b(boolean z) {
        this.g.setEnabled(z);
        this.i.setEnabled(z);
        this.f.setEnabled(z);
        this.l.setTextColor(BluedSkinUtils.a(this.D, z ? 2131102254 : 2131101529));
        this.n.setTextColor(BluedSkinUtils.a(this.D, z ? 2131102254 : 2131101529));
        this.m.setTextColor(BluedSkinUtils.a(this.D, z ? 2131102254 : 2131101529));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        this.f34164c = (ImageView) this.b.findViewById(R.id.sbt_all_onoff);
        this.d = (TextView) this.b.findViewById(R.id.tv_distance_range);
        this.e = (TwoWaysBar) this.b.findViewById(R.id.bar_distance);
        this.f = (ImageView) this.b.findViewById(R.id.sbt_distance_onoff);
        this.g = (ImageView) this.b.findViewById(R.id.sbt_role_onoff);
        this.h = (PhotoGridView) this.b.findViewById(R.id.gv_role);
        this.i = (ImageView) this.b.findViewById(R.id.sbt_age_onoff);
        this.j = (TwoWaysBar) this.b.findViewById(R.id.bar_age);
        this.k = (TextView) this.b.findViewById(R.id.tv_age_range);
        this.l = (TextView) this.b.findViewById(2131371285);
        this.m = (TextView) this.b.findViewById(2131372467);
        this.n = (TextView) this.b.findViewById(R.id.tv_age);
        this.K = (RelativeLayout) this.b.findViewById(R.id.rl_invisible_to_user_list);
        this.e.a(this.s, 100);
        this.d.setText(TwoWaysBar.a(getContext(), this.s, 1));
        this.e.setTwoWaysBarListner(new TwoWaysBar.TowWaysBarListenerAdapter() { // from class: com.soft.blued.ui.user.fragment.VipInvisibleFragment.1
            @Override // com.soft.blued.ui.find.view.TwoWaysBar.TowWaysBarListenerAdapter, com.soft.blued.ui.find.view.TwoWaysBar.TwoWaysBarListner
            public void a(int i, int i2) {
                StringBuilder sb = new StringBuilder();
                sb.append(i);
                sb.append("-");
                sb.append(i2 >= 100 ? "max" : Integer.valueOf(i2));
                VipInvisibleFragment.this.s = sb.toString();
                VipInvisibleFragment.this.d.setText(TwoWaysBar.a(VipInvisibleFragment.this.getContext(), i, i2, 1));
            }
        });
        this.w = d();
        this.j.d = 3;
        this.k.setText(a(this.w));
        this.j.a(this.w, this.o.length);
        this.j.setTwoWaysBarListner(new TwoWaysBar.TowWaysBarListenerAdapter() { // from class: com.soft.blued.ui.user.fragment.VipInvisibleFragment.2
            @Override // com.soft.blued.ui.find.view.TwoWaysBar.TowWaysBarListenerAdapter, com.soft.blued.ui.find.view.TwoWaysBar.TwoWaysBarListner
            public void a(int i, int i2) {
                String str = i + "-" + i2;
                VipInvisibleFragment.this.w = str;
                VipInvisibleFragment.this.k.setText(VipInvisibleFragment.this.a(str));
            }
        });
        f();
        this.f34164c.setOnClickListener(this);
        this.f.setOnClickListener(this);
        this.i.setOnClickListener(this);
        this.g.setOnClickListener(this);
        this.K.setOnClickListener(this);
        if (this.r) {
            a(true);
        }
        if (this.v) {
            c(true);
        }
        if (this.t) {
            e(true);
        }
        if (this.x) {
            d(true);
        }
    }

    private void c(boolean z) {
        this.g.setSelected(z);
        this.h.setVisibility(z ? 0 : 8);
        this.v = z;
    }

    private String d() {
        String[] strArr;
        int i;
        int i2;
        if (TextUtils.isEmpty(this.w) || (strArr = this.o) == null || strArr.length == 0) {
            return "0-" + (this.o.length - 1);
        }
        try {
            String[] split = this.w.split("-");
            int i3 = 0;
            String str = split[0];
            String str2 = split[1];
            int length = str2.equals("max") ? this.o.length - 1 : -1;
            int i4 = -1;
            while (true) {
                int i5 = i4;
                i = length;
                i2 = i5;
                if (i3 < this.o.length) {
                    if (i5 == -1 && str.equals(this.o[i3])) {
                        i2 = i3;
                        i = length;
                    } else {
                        i = length;
                        i2 = i5;
                        if (length == -1) {
                            i = length;
                            i2 = i5;
                            if (str2.equals(this.o[i3])) {
                                i = i3;
                                i2 = i5;
                            }
                        }
                    }
                    if (i2 != -1 && i != -1) {
                        break;
                    }
                    i3++;
                    length = i;
                    i4 = i2;
                } else {
                    break;
                }
            }
            return i2 + "-" + i;
        } catch (Exception e) {
            return "0-" + (this.o.length - 1);
        }
    }

    private void d(boolean z) {
        this.i.setSelected(z);
        this.j.setVisibility(z ? 0 : 8);
        this.k.setVisibility(z ? 0 : 8);
        this.x = z;
    }

    private void e() {
        Dialog a2 = DialogUtils.a(getContext());
        this.y = a2;
        a2.show();
        ProfileHttpUtils.a(getContext(), new BluedUIHttpResponse<BluedEntityA<VipInvisibleSettingModel>>(getFragmentActive()) { // from class: com.soft.blued.ui.user.fragment.VipInvisibleFragment.3
            /* JADX INFO: Access modifiers changed from: protected */
            /* JADX WARN: Code restructure failed: missing block: B:34:0x0118, code lost:
                if (r4.f34167a.r != false) goto L33;
             */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void onUIUpdate(com.blued.android.framework.http.parser.BluedEntityA<com.soft.blued.ui.user.model.VipInvisibleSettingModel> r5) {
                /*
                    Method dump skipped, instructions count: 329
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.soft.blued.ui.user.fragment.VipInvisibleFragment.AnonymousClass3.onUIUpdate(com.blued.android.framework.http.parser.BluedEntityA):void");
            }
        }, UserInfo.getInstance().getLoginUserInfo().getUid(), getFragmentActive());
    }

    private void e(boolean z) {
        this.f.setSelected(z);
        this.e.setVisibility(z ? 0 : 8);
        this.d.setVisibility(z ? 0 : 8);
        this.t = z;
    }

    private void f() {
        UserTag userTag = new UserTag("1", this.D.getResources().getString(2131891552), 0);
        UserTag userTag2 = new UserTag("0.5", this.D.getResources().getString(2131891551), 0);
        UserTag userTag3 = new UserTag("0", this.D.getResources().getString(2131891550), 0);
        UserTag userTag4 = new UserTag("-1", this.D.getResources().getString(2131891554), 0);
        this.q.add(userTag);
        this.q.add(userTag2);
        this.q.add(userTag3);
        this.q.add(userTag4);
        String[] split = !TextUtils.isEmpty(this.u) ? this.u.split(",") : null;
        if (split != null && split.length > 0) {
            for (String str : split) {
                for (UserTag userTag5 : this.q) {
                    if (str.equals(userTag5.id)) {
                        userTag5.checked = 1;
                    }
                }
            }
        }
        UserTagAdapter userTagAdapter = new UserTagAdapter(getContext(), this.q);
        this.p = userTagAdapter;
        this.h.setAdapter((ListAdapter) userTagAdapter);
        this.h.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$VipInvisibleFragment$V0BxkOmwjPaGgcGqOlM1GhHM7b8
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
                VipInvisibleFragment.this.a(adapterView, view, i, j);
            }
        });
    }

    private void g() {
        this.J = this.r || this.x || this.v || this.t;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    public void h() {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    private String i() {
        String str;
        String str2;
        try {
            String[] split = this.w.split("-");
            int parseInt = Integer.parseInt(split[0]);
            int parseInt2 = Integer.parseInt(split[1]);
            if (parseInt <= this.o.length - 1 && parseInt2 <= this.o.length - 1) {
                str = this.o[parseInt];
                str2 = parseInt2 == this.o.length - 1 ? "max" : this.o[parseInt2];
                return str + "-" + str2;
            }
            str = this.o[0];
            str2 = this.o[this.o.length - 1];
            return str + "-" + str2;
        } catch (Exception e) {
            return "18-max";
        }
    }

    private int j() {
        if (this.r && this.A.is_invisible_all == 0) {
            return 1;
        }
        if (this.x && this.A.is_age_stealth == 0) {
            return 2;
        }
        if (this.t && this.A.is_stealth_distance == 0) {
            return 2;
        }
        return (this.v && this.A.is_role_stealth == 0) ? 2 : 0;
    }

    public String a(String str) {
        String str2;
        String str3;
        String string = AppInfo.d().getResources().getString(R.string.old);
        if (StringUtils.d(str) || str.split("-").length != 2) {
            return "18-80" + string + "+";
        }
        String[] split = str.split("-");
        int parseInt = Integer.parseInt(split[0]);
        int parseInt2 = Integer.parseInt(split[1]);
        String[] strArr = this.o;
        if (parseInt > strArr.length - 1 || parseInt2 > strArr.length - 1) {
            String[] strArr2 = this.o;
            str2 = strArr2[0];
            str3 = strArr2[strArr2.length - 1];
        } else {
            str2 = strArr[parseInt];
            str3 = strArr[parseInt2];
        }
        if (str2.equals(str3)) {
            return str2 + string;
        } else if (parseInt2 != this.o.length - 1) {
            return str2 + " ～ " + str3 + string;
        } else {
            return str2 + " ～ " + str3 + string + "+";
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        switch (view.getId()) {
            case 2131363120:
                VipInvisibleDialogFragment vipInvisibleDialogFragment = this.f34163a;
                if (vipInvisibleDialogFragment != null) {
                    vipInvisibleDialogFragment.dismiss();
                    return;
                }
                return;
            case 2131363126:
                int j = j();
                if (j == 0) {
                    h();
                    return;
                } else if (j == 1) {
                    if (this.A.avatar_location_status != 1) {
                        h();
                        return;
                    }
                    Context context = this.D;
                    CommonAlertDialog.a(context, context.getResources().getString(R.string.common_string_notice), this.D.getResources().getString(R.string.header_location_need_to_close), this.D.getResources().getString(R.string.close_now), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.VipInvisibleFragment.4
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Tracker.onClick(dialogInterface, i);
                            VipInvisibleFragment.this.A.avatar_location_status = 0;
                            VipInvisibleFragment.this.h();
                        }
                    }, this.D.getResources().getString(2131886885), (DialogInterface.OnClickListener) null, (DialogInterface.OnDismissListener) null);
                    return;
                } else if (j != 2) {
                    return;
                } else {
                    if (this.A.avatar_location_status != 1) {
                        h();
                        return;
                    }
                    Context context2 = this.D;
                    CommonAlertDialog.a(context2, context2.getResources().getString(2131888879), this.D.getResources().getString(R.string.invisible_take_effect_simultaneously), this.D.getResources().getString(2131887320), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.VipInvisibleFragment.5
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Tracker.onClick(dialogInterface, i);
                            VipInvisibleFragment.this.h();
                        }
                    }, this.D.getResources().getString(2131886885), (DialogInterface.OnClickListener) null, (DialogInterface.OnDismissListener) null);
                    return;
                }
            case R.id.rl_invisible_to_user_list /* 2131369335 */:
                if (UserInfo.getInstance().getLoginUserInfo().vip_grade == 2) {
                    VIPInvisibleToUserDialogFragment vIPInvisibleToUserDialogFragment = new VIPInvisibleToUserDialogFragment();
                    vIPInvisibleToUserDialogFragment.a("nearby_settings_hide");
                    vIPInvisibleToUserDialogFragment.show(getChildFragmentManager(), VipInvisibleFragment.class.getName());
                } else {
                    a("vip_hide_for", 10002, VipProtos.FromType.VIP_HIDE_FOR);
                }
                EventTrackPersonalProfile.a(PersonalProfileProtos.Event.HIDE_SETTING_SEE_HIDE_LIST_CLICK);
                return;
            case R.id.sbt_age_onoff /* 2131369609 */:
                if (a(view.getId())) {
                    d(!this.x);
                }
                EventTrackVIP.a(VipProtos.Event.VIP_CENTRE_SUPER_HIDE_SECOND_BTN_CLICK, VipProtos.HideType.HIDE_AGE);
                g();
                return;
            case R.id.sbt_all_onoff /* 2131369611 */:
                if (a(view.getId())) {
                    a(!this.r);
                }
                EventTrackVIP.a(VipProtos.Event.VIP_CENTRE_SUPER_HIDE_SECOND_BTN_CLICK, VipProtos.HideType.HIDE_ALL);
                g();
                return;
            case R.id.sbt_distance_onoff /* 2131369612 */:
                if (a(view.getId())) {
                    e(!this.t);
                }
                EventTrackVIP.a(VipProtos.Event.VIP_CENTRE_SUPER_HIDE_SECOND_BTN_CLICK, VipProtos.HideType.HIDE_DISTANCE);
                g();
                return;
            case R.id.sbt_role_onoff /* 2131369616 */:
                if (a(view.getId())) {
                    c(!this.v);
                }
                EventTrackVIP.a(VipProtos.Event.VIP_CENTRE_SUPER_HIDE_SECOND_BTN_CLICK, VipProtos.HideType.HIDE_ROLE);
                g();
                return;
            default:
                return;
        }
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        EventTrackVIP.a(VipProtos.Event.VIP_CENTRE_SUPER_HIDE_SECOND_PAGE_SHOW, EventTrackVIP.b(UserInfo.getInstance().getLoginUserInfo().vip_grade));
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.D = getActivity();
        this.b = layoutInflater.inflate(R.layout.pop_vip_invisible, (ViewGroup) null);
        a();
        b();
        e();
        return this.b;
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.f34163a = null;
    }
}
