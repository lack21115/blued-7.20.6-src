package com.soft.blued.ui.welcome;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.core.AppInfo;
import com.blued.android.module.common.user.model.UserInfo;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.ui.home.HomeArgumentHelper;
import com.soft.blued.ui.login_register.SignInActivity;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/welcome/NewfeatureGuideAdapter.class */
public class NewfeatureGuideAdapter extends PagerAdapter implements View.OnClickListener {

    /* renamed from: c  reason: collision with root package name */
    private ViewPager f34540c;
    private Activity d;
    private List<View> b = new ArrayList();

    /* renamed from: a  reason: collision with root package name */
    public LayoutInflater f34539a = (LayoutInflater) AppInfo.d().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    public NewfeatureGuideAdapter(Activity activity, ViewPager viewPager) {
        this.d = activity;
        this.f34540c = viewPager;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView((View) obj);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.b.size();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        View view = this.b.get(i);
        if (i == this.b.size() - 1) {
            view.findViewById(2131371023).setOnClickListener(this);
        }
        viewGroup.addView(view);
        return view;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        if (view.getId() != 2131371023) {
            return;
        }
        if (UserInfo.getInstance().isLogin()) {
            HomeArgumentHelper.a(this.d);
        } else {
            SignInActivity.a(this.d, new Bundle[0]);
        }
        this.f34540c.setEnabled(false);
        this.d.finish();
    }
}
