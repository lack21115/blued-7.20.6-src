package com.soft.blued.ui.setting.fragment;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.AppMethods;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.das.vip.VipProtos;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.log.InstantLog;
import com.soft.blued.log.track.EventTrackVIP;
import com.soft.blued.push.PushManager;
import com.soft.blued.ui.setting.adapter.BluedIconAdapter;
import com.soft.blued.ui.setting.model.BluedIcon;
import com.soft.blued.ui.user.presenter.PayUtils;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.StringUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/fragment/ChangeBluedIconFragment.class */
public class ChangeBluedIconFragment extends BaseFragment {

    /* renamed from: a  reason: collision with root package name */
    private Context f33334a;
    private View b;

    /* renamed from: c  reason: collision with root package name */
    private List<BluedIcon> f33335c;
    private BluedIconAdapter d;
    private RecyclerView e;
    private int f = 2;

    private void a() {
        ArrayList arrayList = new ArrayList();
        this.f33335c = arrayList;
        arrayList.add(new BluedIcon(R.drawable.blued_icon_0, false, "com.soft.blued.icon0"));
        this.f33335c.add(new BluedIcon(R.drawable.blued_icon_1, false, "com.soft.blued.icon1"));
        this.f33335c.add(new BluedIcon(R.drawable.blued_icon_2, false, "com.soft.blued.icon2"));
        this.f33335c.add(new BluedIcon(R.drawable.blued_icon_3, false, "com.soft.blued.icon3"));
        this.f33335c.add(new BluedIcon(R.drawable.blued_icon_4, false, "com.soft.blued.icon4"));
        this.f33335c.add(new BluedIcon(R.drawable.blued_icon_5, false, "com.soft.blued.icon5"));
        this.f33335c.add(new BluedIcon(R.drawable.blued_icon_6, false, "com.soft.blued.icon6"));
        Iterator<BluedIcon> it = this.f33335c.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            BluedIcon next = it.next();
            if (next.getLauncherName().equals(BluedPreferences.a("com.soft.blued.icon0"))) {
                next.setChecked(true);
                break;
            }
        }
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this.f33334a, 3) { // from class: com.soft.blued.ui.setting.fragment.ChangeBluedIconFragment.1
            @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
            public boolean canScrollVertically() {
                return false;
            }
        };
        RecyclerView recyclerView = (RecyclerView) this.b.findViewById(R.id.rv_icon);
        this.e = recyclerView;
        recyclerView.setLayoutManager(gridLayoutManager);
        BluedIconAdapter bluedIconAdapter = new BluedIconAdapter(this.f33334a, this.f33335c);
        this.d = bluedIconAdapter;
        this.e.setAdapter(bluedIconAdapter);
        this.d.a(new BluedIconAdapter.OnItemClickListener() { // from class: com.soft.blued.ui.setting.fragment.ChangeBluedIconFragment.2
            @Override // com.soft.blued.ui.setting.adapter.BluedIconAdapter.OnItemClickListener
            public void a(View view, int i) {
                InstantLog.b("change_icon_click", i);
                ChangeBluedIconFragment.this.a(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        if (UserInfo.getInstance().getLoginUserInfo().vip_grade == 0) {
            PayUtils.a(this.f33334a, this.f, "", 14, VipProtos.FromType.UNKNOWN_FROM);
            return;
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.f33335c.size()) {
                this.d.notifyDataSetChanged();
                return;
            }
            if (i3 == i) {
                this.f33335c.get(i3).setChecked(true);
            } else {
                this.f33335c.get(i3).setChecked(false);
            }
            i2 = i3 + 1;
        }
    }

    public static void a(Context context) {
        TerminalActivity.d(context, ChangeBluedIconFragment.class, null);
    }

    public static void a(Context context, int i) {
        Bundle bundle = new Bundle();
        bundle.putInt("KEY_VIP_GRADE", i);
        TerminalActivity.d(context, ChangeBluedIconFragment.class, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        Tracker.onClick(view);
        if (UserInfo.getInstance().getLoginUserInfo().vip_grade == 0) {
            getActivity().finish();
        } else {
            c();
        }
    }

    private void b() {
        CommonTopTitleNoTrans commonTopTitleNoTrans = (CommonTopTitleNoTrans) this.b.findViewById(2131370749);
        commonTopTitleNoTrans.setCenterText(getString(R.string.change_blued_icon));
        commonTopTitleNoTrans.setLeftClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.setting.fragment.-$$Lambda$ChangeBluedIconFragment$f8QShhFKgEGDZWE0t2LrpopiUKQ
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ChangeBluedIconFragment.this.b(view);
            }
        });
        commonTopTitleNoTrans.setRightText(R.string.save);
        commonTopTitleNoTrans.setRightTextColor(2131102254);
        commonTopTitleNoTrans.setRightClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.setting.fragment.-$$Lambda$ChangeBluedIconFragment$w8-BsQjyhXtdn5TrRNkhwkHTheE
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ChangeBluedIconFragment.this.a(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        Tracker.onClick(view);
        getActivity().finish();
    }

    private void c() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f33335c.size()) {
                return;
            }
            if (this.f33335c.get(i2).isChecked()) {
                VipProtos.Event event = VipProtos.Event.VIP_CHANGE_ICON_SAVE_BTN_CLICK;
                EventTrackVIP.b(event, i2 + "");
                InstantLog.b("change_icon_use", i2);
                a(this.f33335c.get(i2).getLauncherName());
                AppMethods.d((int) R.string.change_blued_icon_done);
                getActivity().finish();
                return;
            }
            i = i2 + 1;
        }
    }

    public void a(String str) {
        if (StringUtils.d(str)) {
            return;
        }
        PackageManager packageManager = getActivity().getPackageManager();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f33335c.size()) {
                packageManager.setComponentEnabledSetting(new ComponentName(getActivity(), str), 1, 1);
                BluedPreferences.b(str);
                PushManager.a().e();
                return;
            }
            try {
                packageManager.setComponentEnabledSetting(new ComponentName(getActivity(), this.f33335c.get(i2).getLauncherName()), 2, 1);
            } catch (Exception e) {
                e.printStackTrace();
            }
            i = i2 + 1;
        }
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f33334a = getActivity();
        if (getArguments() != null) {
            this.f = getArguments().getInt("KEY_VIP_GRADE", 2);
        }
        View view = this.b;
        if (view == null) {
            this.b = layoutInflater.inflate(R.layout.fragment_change_blued_icon, viewGroup, false);
            b();
            a();
        } else if (view.getParent() != null) {
            ((ViewGroup) this.b.getParent()).removeView(this.b);
        }
        return this.b;
    }
}
