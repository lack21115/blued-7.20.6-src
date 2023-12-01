package com.blued.android.module.yy_china.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewpager.widget.PagerAdapter;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.url.H5Url;
import com.blued.android.module.common.utils.TimeAndDateUtils;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.databinding.ItemYyBadgeInfoBinding;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.BadgeMode;
import com.bytedance.applog.tracker.Tracker;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/adapter/MedalPageAdapter.class */
public class MedalPageAdapter extends PagerAdapter {

    /* renamed from: a  reason: collision with root package name */
    private List<BadgeMode> f16137a;
    private BaseFragment b;

    /* renamed from: c  reason: collision with root package name */
    private View.OnClickListener f16138c;

    public MedalPageAdapter(List<BadgeMode> list, BaseFragment baseFragment, View.OnClickListener onClickListener) {
        ArrayList arrayList = new ArrayList();
        this.f16137a = arrayList;
        arrayList.addAll(list);
        this.b = baseFragment;
        this.f16138c = onClickListener;
    }

    private int a() {
        List<BadgeMode> list = this.f16137a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    private void a(ItemYyBadgeInfoBinding itemYyBadgeInfoBinding, int i) {
        BadgeMode badgeMode = this.f16137a.get(i);
        ImageLoader.a(this.b.getFragmentActive(), badgeMode.getPic()).b(R.drawable.anchor_badge_default).d(R.drawable.anchor_badge_default).a(itemYyBadgeInfoBinding.f16679a);
        itemYyBadgeInfoBinding.f16680c.setText(badgeMode.getName());
        itemYyBadgeInfoBinding.d.setText(badgeMode.getTitle());
        if (StringUtils.b(badgeMode.getUpgrade_description())) {
            itemYyBadgeInfoBinding.e.setVisibility(4);
        } else {
            itemYyBadgeInfoBinding.e.setVisibility(0);
            itemYyBadgeInfoBinding.e.setText(badgeMode.getUpgrade_description());
        }
        if (badgeMode.getScore() > 0) {
            ShapeTextView shapeTextView = itemYyBadgeInfoBinding.f;
            shapeTextView.setText(badgeMode.getScore() + itemYyBadgeInfoBinding.getRoot().getResources().getString(R.string.score_point));
        } else {
            itemYyBadgeInfoBinding.f.setText(" ? ");
        }
        itemYyBadgeInfoBinding.f.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.adapter.MedalPageAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                YYRoomInfoManager.e().c().a(MedalPageAdapter.this.b.getContext(), H5Url.a(11), 7);
            }
        });
        String c2 = TimeAndDateUtils.c(TimeAndDateUtils.c(badgeMode.getEnd_time() + ""));
        if (StringUtils.b(c2) || badgeMode.getEnd_time() == 0) {
            itemYyBadgeInfoBinding.g.setVisibility(4);
        } else {
            itemYyBadgeInfoBinding.g.setVisibility(0);
            TextView textView = itemYyBadgeInfoBinding.g;
            textView.setText(this.b.getResources().getString(R.string.valid_to) + c2);
        }
        itemYyBadgeInfoBinding.getRoot().setOnClickListener(this.f16138c);
        itemYyBadgeInfoBinding.b.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.adapter.MedalPageAdapter.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
            }
        });
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView((View) obj);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return a() * 1;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        int a2 = a();
        ItemYyBadgeInfoBinding a3 = ItemYyBadgeInfoBinding.a(LayoutInflater.from(viewGroup.getContext()));
        a(a3, i % a2);
        viewGroup.addView(a3.getRoot(), new ViewGroup.LayoutParams(-1, -1));
        return a3.getRoot();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }
}
