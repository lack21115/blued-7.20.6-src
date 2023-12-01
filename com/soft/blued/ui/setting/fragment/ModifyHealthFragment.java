package com.soft.blued.ui.setting.fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.module.common.user.model.UserTag;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.android.module.common.utils.TimeAndDateUtils;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.android.module.common.widget.dialog.CommonAlertDialog;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/fragment/ModifyHealthFragment.class */
public class ModifyHealthFragment extends BaseFragment implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private Context f19729a;
    private View b;

    /* renamed from: c  reason: collision with root package name */
    private Dialog f19730c;
    private LinearLayout f;
    private LinearLayout g;
    private LinearLayout h;
    private LinearLayout i;
    private TextView j;
    private TextView k;
    private TextView l;
    private TextView m;
    private TextView n;
    private String r;
    private String s;
    private String t;
    private ArrayList<String> d = new ArrayList<>();
    private List<UserTag> e = new ArrayList();
    private List<UserTag> o = new ArrayList();
    private List<UserTag> p = new ArrayList();
    private List<UserTag> q = new ArrayList();

    private void a() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.r = arguments.getString("health_result");
            this.s = arguments.getString("health_time");
            this.t = arguments.getString("health_prep");
        }
        Log.v("drb", "initData healthResult id:" + this.r);
        Log.v("drb", "initData healthTime id:" + this.s);
        Log.v("drb", "initData healthPrep id:" + this.t);
        d();
        c();
        b();
    }

    public static void a(BaseFragment baseFragment, String str, String str2, String str3, int i) {
        Bundle bundle = new Bundle();
        bundle.putString("health_result", str);
        bundle.putString("health_time", str2);
        bundle.putString("health_prep", str3);
        TerminalActivity.a(baseFragment, ModifyHealthFragment.class, bundle, i);
    }

    private void b() {
        this.q.add(new UserTag("-1", getString(R.string.hiv_detection_prep1)));
        this.q.add(new UserTag("1", getString(R.string.hiv_detection_prep2)));
        this.q.add(new UserTag("2", getString(R.string.hiv_detection_prep3)));
        this.q.add(new UserTag("3", getString(R.string.hiv_detection_prep4)));
    }

    private void c() {
        String[] e = e();
        this.p.add(new UserTag("-1", getString(R.string.hiv_detection_result3)));
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 12) {
                break;
            }
            this.p.add(new UserTag(TimeAndDateUtils.d(e[i2]), TimeAndDateUtils.e(TimeAndDateUtils.d(e[i2]))));
            i = i2 + 1;
        }
        this.p.add(new UserTag("1", getString(R.string.hiv_detection_time14)));
        for (UserTag userTag : this.p) {
            Log.v("drb", "id:" + userTag.id + " -- name:" + userTag.name);
        }
    }

    private void d() {
        this.o.add(new UserTag("1", getString(R.string.hiv_detection_result1)));
        this.o.add(new UserTag("2", getString(R.string.hiv_detection_result2)));
        this.o.add(new UserTag("-1", getString(R.string.hiv_detection_result3)));
        this.o.add(new UserTag("3", getString(R.string.hiv_detection_result4)));
        this.o.add(new UserTag("4", getString(R.string.hiv_detection_result5)));
        this.o.add(new UserTag("5", getString(R.string.hiv_detection_result6)));
    }

    private String[] e() {
        String[] strArr = new String[12];
        Calendar calendar = Calendar.getInstance();
        calendar.set(5, 1);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 12) {
                return strArr;
            }
            strArr[i2] = calendar.get(1) + "年" + (calendar.get(2) + 1) + "月";
            calendar.set(2, calendar.get(2) - 1);
            i = i2 + 1;
        }
    }

    private void f() {
        CommonTopTitleNoTrans findViewById = this.b.findViewById(R.id.top_title);
        findViewById.setCenterText(getString(R.string.health_information));
        findViewById.setLeftClickListener(this);
        findViewById.a();
    }

    private void g() {
        this.f19730c = DialogUtils.a(getActivity());
        this.f = (LinearLayout) this.b.findViewById(R.id.ll_hiv_detection_result);
        this.g = (LinearLayout) this.b.findViewById(R.id.ll_hiv_detection_time);
        this.h = (LinearLayout) this.b.findViewById(R.id.ll_hiv_detection_prep);
        this.i = (LinearLayout) this.b.findViewById(R.id.ll_encyclopedia_of_health);
        this.j = (TextView) this.b.findViewById(R.id.tv_hiv_detection_result);
        this.l = (TextView) this.b.findViewById(R.id.tv_hiv_detection_time);
        this.k = (TextView) this.b.findViewById(R.id.tv_hiv_detection_title);
        this.m = (TextView) this.b.findViewById(R.id.tv_hiv_detection_prep);
        this.n = (TextView) this.b.findViewById(R.id.tv_encyclopedia_of_health);
        this.f.setOnClickListener(this);
        this.g.setOnClickListener(this);
        this.h.setOnClickListener(this);
        this.i.setOnClickListener(this);
        if (!TextUtils.isEmpty(this.r)) {
            Iterator<UserTag> it = this.o.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                UserTag next = it.next();
                if (TextUtils.equals(next.id, this.r)) {
                    next.select = true;
                    this.j.setText(next.name);
                    break;
                }
            }
        } else {
            Iterator<UserTag> it2 = this.o.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                UserTag next2 = it2.next();
                if (TextUtils.equals(next2.id, "-1")) {
                    next2.select = true;
                    break;
                }
            }
            this.j.setText(getString(R.string.hiv_detection_result3));
        }
        if (TextUtils.isEmpty(this.s)) {
            this.l.setText(getString(R.string.hiv_detection_result3));
        } else if (TextUtils.equals(this.s, "-1")) {
            this.l.setText(getString(R.string.hiv_detection_result3));
        } else if (TextUtils.equals(this.s, "1")) {
            this.l.setText(getString(R.string.hiv_detection_time14));
        } else {
            this.l.setText(TimeAndDateUtils.e(this.s));
        }
        if (!TextUtils.isEmpty(this.t)) {
            Iterator<UserTag> it3 = this.q.iterator();
            while (true) {
                if (!it3.hasNext()) {
                    break;
                }
                UserTag next3 = it3.next();
                if (TextUtils.equals(next3.id, this.t)) {
                    next3.select = true;
                    this.m.setText(next3.name);
                    break;
                }
            }
        } else {
            Iterator<UserTag> it4 = this.q.iterator();
            while (true) {
                if (!it4.hasNext()) {
                    break;
                }
                UserTag next4 = it4.next();
                if (TextUtils.equals(next4.id, "-1")) {
                    next4.select = true;
                    break;
                }
            }
            this.m.setText(getString(R.string.hiv_detection_result3));
        }
        h();
        i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        for (UserTag userTag : this.o) {
            if (userTag.select) {
                boolean z = true;
                if (TextUtils.equals(userTag.id, "1")) {
                    this.k.setTextColor(BluedSkinUtils.a(this.f19729a, 2131102263));
                    this.l.setTextColor(BluedSkinUtils.a(this.f19729a, 2131102263));
                    this.l.setText("");
                    this.l.setHint(R.string.hiv_detection_after);
                    for (UserTag userTag2 : this.p) {
                        userTag2.select = false;
                        if (TextUtils.equals(userTag2.id, "-1")) {
                            userTag2.select = true;
                        }
                    }
                    return;
                }
                this.k.setTextColor(BluedSkinUtils.a(this.f19729a, 2131102254));
                this.l.setTextColor(BluedSkinUtils.a(this.f19729a, 2131102254));
                Iterator<UserTag> it = this.p.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = false;
                        break;
                    }
                    UserTag next = it.next();
                    if (next.select) {
                        if (TextUtils.equals(next.id, "-1")) {
                            this.l.setText(getString(R.string.hiv_detection_result3));
                        } else if (TextUtils.equals(next.id, "1")) {
                            this.l.setText(getString(R.string.hiv_detection_time14));
                        } else {
                            this.l.setText(TimeAndDateUtils.e(next.id));
                        }
                    }
                }
                if (z) {
                    return;
                }
                if (TextUtils.isEmpty(this.s)) {
                    this.l.setText(getString(R.string.hiv_detection_result3));
                    return;
                } else if (TextUtils.equals(this.s, "1")) {
                    this.l.setText(getString(R.string.hiv_detection_time14));
                    return;
                } else if (TextUtils.equals(this.s, "-1")) {
                    this.l.setText(getString(R.string.hiv_detection_result3));
                    return;
                } else {
                    this.l.setText(TimeAndDateUtils.e(this.s));
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        for (UserTag userTag : this.o) {
            if (userTag.select) {
                if (TextUtils.equals(userTag.id, "4") || TextUtils.equals(userTag.id, "5")) {
                    Iterator<UserTag> it = this.q.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        UserTag next = it.next();
                        if (TextUtils.equals(next.id, "3")) {
                            next.enable = true;
                            break;
                        }
                    }
                    for (UserTag userTag2 : this.q) {
                        if (userTag2.select) {
                            Log.v("drb", "PrEP使用情况的选项中是:" + userTag2.id);
                            if (TextUtils.equals(userTag2.id, "3")) {
                                userTag2.select = false;
                                for (UserTag userTag3 : this.q) {
                                    Log.v("drb", "更改前的PrEP使用情况选项为:" + userTag3.id);
                                    if (TextUtils.equals(userTag3.id, "2")) {
                                        userTag3.select = true;
                                        this.m.setText(userTag3.name);
                                        Log.v("drb", "setText:" + userTag3.name);
                                    }
                                }
                            }
                        }
                    }
                } else {
                    for (UserTag userTag4 : this.q) {
                        userTag4.enable = false;
                    }
                }
            }
        }
    }

    private void j() {
        boolean z;
        Intent intent = new Intent();
        Iterator<UserTag> it = this.o.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            UserTag next = it.next();
            if (next.select) {
                intent.putExtra("health_result", next.id);
                intent.putExtra("health_result_name", next.name);
                Log.v("drb", "finish result id:" + next.id + " -- name:" + next.name);
                break;
            }
        }
        Iterator<UserTag> it2 = this.p.iterator();
        while (true) {
            z = false;
            if (!it2.hasNext()) {
                break;
            }
            UserTag next2 = it2.next();
            if (next2.select) {
                intent.putExtra("health_time", next2.id);
                intent.putExtra("health_time_name", next2.name);
                Log.v("drb", "finish time id:" + next2.id + " -- name:" + next2.name);
                z = true;
                break;
            }
        }
        if (!z) {
            if (TextUtils.isEmpty(this.s)) {
                intent.putExtra("health_time", "-1");
                intent.putExtra("health_time_name", getString(R.string.hiv_detection_result3));
                Log.v("drb", "finish time id:-1 -- name:" + getString(R.string.hiv_detection_result3));
            } else {
                intent.putExtra("health_time", this.s);
                if (TextUtils.equals(this.s, "1")) {
                    intent.putExtra("health_time_name", getString(R.string.hiv_detection_time14));
                    Log.v("drb", "finish time id:" + this.s + " -- name:" + getString(R.string.hiv_detection_time14));
                } else if (TextUtils.equals(this.s, "-1")) {
                    intent.putExtra("health_time", "-1");
                    intent.putExtra("health_time_name", getString(R.string.hiv_detection_result3));
                    Log.v("drb", "finish time id:-1 -- name:" + getString(R.string.hiv_detection_result3));
                } else {
                    intent.putExtra("health_time_name", TimeAndDateUtils.e(this.s));
                    Log.v("drb", "finish time id:" + this.s + " -- name:" + TimeAndDateUtils.e(this.s));
                }
            }
        }
        Iterator<UserTag> it3 = this.q.iterator();
        while (true) {
            if (!it3.hasNext()) {
                break;
            }
            UserTag next3 = it3.next();
            if (next3.select) {
                intent.putExtra("health_prep", next3.id);
                intent.putExtra("health_prep_name", next3.name);
                Log.v("drb", "finish prep id:" + next3.id + " -- name:" + next3.name);
                break;
            }
        }
        getActivity().setResult(-1, intent);
        getActivity().finish();
    }

    public boolean onBackPressed() {
        j();
        return true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        int id = view.getId();
        if (id == 2131363120) {
            j();
        } else if (id != 2131367764) {
            switch (id) {
                case R.id.ll_hiv_detection_prep /* 2131367908 */:
                    ArrayList arrayList = new ArrayList();
                    for (UserTag userTag : this.q) {
                        if (!userTag.enable) {
                            arrayList.add(userTag.name);
                        }
                    }
                    CommonAlertDialog.a(this.f19729a, getString(R.string.hiv_detection_prep), (String[]) arrayList.toArray(new String[arrayList.size()]), new CommonAlertDialog.TextOnClickListener() { // from class: com.soft.blued.ui.setting.fragment.ModifyHealthFragment.3
                        public void a(String str) {
                            ModifyHealthFragment.this.m.setText(str);
                            for (UserTag userTag2 : ModifyHealthFragment.this.q) {
                                userTag2.select = false;
                                if (TextUtils.equals(userTag2.name, str)) {
                                    userTag2.select = true;
                                }
                            }
                        }
                    });
                    return;
                case R.id.ll_hiv_detection_result /* 2131367909 */:
                    ArrayList arrayList2 = new ArrayList();
                    for (UserTag userTag2 : this.o) {
                        arrayList2.add(userTag2.name);
                    }
                    CommonAlertDialog.a(this.f19729a, getString(R.string.hiv_detection_result), (String[]) arrayList2.toArray(new String[arrayList2.size()]), new CommonAlertDialog.TextOnClickListener() { // from class: com.soft.blued.ui.setting.fragment.ModifyHealthFragment.1
                        public void a(final String str) {
                            CommonAlertDialog.a(ModifyHealthFragment.this.f19729a, ModifyHealthFragment.this.f19729a.getString(R.string.privacy_alert), ModifyHealthFragment.this.f19729a.getString(R.string.privacy_alert_msg), ModifyHealthFragment.this.f19729a.getString(R.string.privacy_alert_confirm), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.setting.fragment.ModifyHealthFragment.1.1
                                @Override // android.content.DialogInterface.OnClickListener
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    Tracker.onClick(dialogInterface, i);
                                    ModifyHealthFragment.this.j.setText(str);
                                    for (UserTag userTag3 : ModifyHealthFragment.this.o) {
                                        userTag3.select = false;
                                        if (TextUtils.equals(userTag3.name, str)) {
                                            userTag3.select = true;
                                        }
                                    }
                                    ModifyHealthFragment.this.h();
                                    ModifyHealthFragment.this.i();
                                }
                            }, ModifyHealthFragment.this.f19729a.getString(2131886718), (DialogInterface.OnClickListener) null, (DialogInterface.OnDismissListener) null);
                        }
                    });
                    return;
                case R.id.ll_hiv_detection_time /* 2131367910 */:
                    for (UserTag userTag3 : this.o) {
                        if (userTag3.select && TextUtils.equals(userTag3.id, "1")) {
                            return;
                        }
                    }
                    ArrayList arrayList3 = new ArrayList();
                    for (UserTag userTag4 : this.p) {
                        arrayList3.add(userTag4.name);
                    }
                    CommonAlertDialog.a(this.f19729a, getString(R.string.hiv_detection_time), (String[]) arrayList3.toArray(new String[arrayList3.size()]), new CommonAlertDialog.TextOnClickListener() { // from class: com.soft.blued.ui.setting.fragment.ModifyHealthFragment.2
                        public void a(String str) {
                            ModifyHealthFragment.this.l.setText(str);
                            for (UserTag userTag5 : ModifyHealthFragment.this.p) {
                                userTag5.select = false;
                                if (TextUtils.equals(userTag5.name, str)) {
                                    userTag5.select = true;
                                }
                            }
                        }
                    });
                    return;
                default:
                    return;
            }
        } else {
            WebViewShowInfoFragment.show(getActivity(), "http://native.blued.cn?action=store_yz&url=https%3A%2F%2Fj.youzan.com%2F49GTF2", -1);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f19729a = getActivity();
        View view = this.b;
        if (view == null) {
            this.b = layoutInflater.inflate(R.layout.fragment_health_for_modify, viewGroup, false);
            a();
            g();
            f();
        } else if (view.getParent() != null) {
            ((ViewGroup) this.b.getParent()).removeView(this.b);
        }
        return this.b;
    }
}
