package com.soft.blued.ui.msg;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.android.module.common.view.PageTabLayout;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.ui.msg.model.ShareToMsgEntity;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/ShareToFragment.class */
public class ShareToFragment extends BaseFragment {

    /* renamed from: a  reason: collision with root package name */
    private Bundle f31920a;
    private Context b;

    /* renamed from: c  reason: collision with root package name */
    private ViewPager f31921c;
    private CommonTopTitleNoTrans d;
    private PageTabLayout e;
    private ShapeTextView f;
    private int g = 0;

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/ShareToFragment$MyAdapter.class */
    public class MyAdapter extends FragmentPagerAdapter {
        private String[] b;

        public MyAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
            this.b = ShareToFragment.this.a();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return this.b.length;
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            return i != 1 ? i != 2 ? ShareToChatRecentFragment.a(ShareToFragment.this.f31920a) : ShareToGroupsFragment.a(ShareToFragment.this.f31920a) : ShareToFriendsFragment.a(ShareToFragment.this.f31920a);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public CharSequence getPageTitle(int i) {
            return this.b[i];
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/ShareToFragment$Type.class */
    public @interface Type {
    }

    public static void a(Context context, ShareToMsgEntity shareToMsgEntity) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("share_entity", shareToMsgEntity);
        bundle.putInt("share_type", 0);
        TerminalActivity.d(context, ShareToFragment.class, bundle);
    }

    public static void a(Context context, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("circle_id", str);
        bundle.putInt("share_type", 1);
        TerminalActivity.d(context, ShareToFragment.class, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        Tracker.onClick(view);
        ((Activity) this.b).finish();
    }

    public String[] a() {
        return new String[]{getResources().getString(2131891417), getResources().getString(2131888205)};
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        this.b = context;
        this.f31920a = getArguments();
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_share_to, viewGroup, false);
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.tab_background);
        this.f = shapeTextView;
        ShapeHelper.b(shapeTextView, 2131102360);
        this.f31921c = (ViewPager) view.findViewById(R.id.vp_pagers);
        this.d = (CommonTopTitleNoTrans) view.findViewById(R.id.cttnt_title);
        PageTabLayout pageTabLayout = (PageTabLayout) view.findViewById(2131370555);
        this.e = pageTabLayout;
        pageTabLayout.setupWithViewPager(this.f31921c);
        this.f31921c.setAdapter(new MyAdapter(getFragmentManager()));
        this.d.a();
        this.d.setLeftImg(2131233902);
        this.d.setLeftClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.-$$Lambda$ShareToFragment$hkVTXruTIWrlO8a6imuiC8HRji0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ShareToFragment.this.a(view2);
            }
        });
        if (getArguments() != null) {
            this.g = getArguments().getInt("share_type");
        }
        if (this.g != 1) {
            this.d.setCenterText(2131891704);
        } else {
            this.d.setCenterText(2131887083);
        }
    }
}
