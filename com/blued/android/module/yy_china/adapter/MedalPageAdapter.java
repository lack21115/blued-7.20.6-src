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
    private List<BadgeMode> a;
    private BaseFragment b;
    private View.OnClickListener c;

    public MedalPageAdapter(List<BadgeMode> list, BaseFragment baseFragment, View.OnClickListener onClickListener) {
        ArrayList arrayList = new ArrayList();
        this.a = arrayList;
        arrayList.addAll(list);
        this.b = baseFragment;
        this.c = onClickListener;
    }

    private int a() {
        List<BadgeMode> list = this.a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    private void a(ItemYyBadgeInfoBinding itemYyBadgeInfoBinding, int i) {
        BadgeMode badgeMode = this.a.get(i);
        ImageLoader.a(this.b.getFragmentActive(), badgeMode.getPic()).b(R.drawable.anchor_badge_default).d(R.drawable.anchor_badge_default).a(itemYyBadgeInfoBinding.a);
        itemYyBadgeInfoBinding.c.setText(badgeMode.getName());
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
        String c = TimeAndDateUtils.c(TimeAndDateUtils.c(badgeMode.getEnd_time() + ""));
        if (StringUtils.b(c) || badgeMode.getEnd_time() == 0) {
            itemYyBadgeInfoBinding.g.setVisibility(4);
        } else {
            itemYyBadgeInfoBinding.g.setVisibility(0);
            TextView textView = itemYyBadgeInfoBinding.g;
            textView.setText(this.b.getResources().getString(R.string.valid_to) + c);
        }
        itemYyBadgeInfoBinding.getRoot().setOnClickListener(this.c);
        itemYyBadgeInfoBinding.b.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.adapter.MedalPageAdapter.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
            }
        });
    }

    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView((View) obj);
    }

    public int getCount() {
        return a() * 1;
    }

    public Object instantiateItem(ViewGroup viewGroup, int i) {
        int a = a();
        ItemYyBadgeInfoBinding a2 = ItemYyBadgeInfoBinding.a(LayoutInflater.from(viewGroup.getContext()));
        a(a2, i % a);
        viewGroup.addView(a2.getRoot(), new ViewGroup.LayoutParams(-1, -1));
        return a2.getRoot();
    }

    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }
}
