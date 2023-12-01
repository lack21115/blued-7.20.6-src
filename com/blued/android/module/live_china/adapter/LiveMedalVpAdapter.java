package com.blued.android.module.live_china.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewpager.widget.PagerAdapter;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.module.common.utils.PermissionUtils;
import com.blued.android.module.live.base.utils.LiveTimeAndDateUtils;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.model.LiveMedalItemData;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/adapter/LiveMedalVpAdapter.class */
public final class LiveMedalVpAdapter extends PagerAdapter {

    /* renamed from: a  reason: collision with root package name */
    private final ArrayList<LiveMedalItemData> f11665a;

    public LiveMedalVpAdapter(ArrayList<LiveMedalItemData> medalDataList) {
        Intrinsics.e(medalDataList, "medalDataList");
        this.f11665a = medalDataList;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup container, int i, Object object) {
        Intrinsics.e(container, "container");
        Intrinsics.e(object, "object");
        container.removeView((View) object);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.f11665a.size();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(Object object) {
        Intrinsics.e(object, "object");
        return -2;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup container, int i) {
        Intrinsics.e(container, "container");
        View inflate = LayoutInflater.from(AppInfo.d()).inflate(R.layout.fragment_live_medal_detail_item, container, false);
        Intrinsics.c(inflate, "from(AppInfo.getAppConte…l_item, container, false)");
        LiveMedalItemData liveMedalItemData = this.f11665a.get(i);
        Intrinsics.c(liveMedalItemData, "medalDataList[position]");
        LiveMedalItemData liveMedalItemData2 = liveMedalItemData;
        View findViewById = inflate.findViewById(R.id.iv_medal_detail);
        Intrinsics.c(findViewById, "view.findViewById(R.id.iv_medal_detail)");
        ImageView imageView = (ImageView) findViewById;
        View findViewById2 = inflate.findViewById(R.id.tv_medal_name);
        Intrinsics.c(findViewById2, "view.findViewById(R.id.tv_medal_name)");
        TextView textView = (TextView) findViewById2;
        View findViewById3 = inflate.findViewById(R.id.tv_medal_desc);
        Intrinsics.c(findViewById3, "view.findViewById(R.id.tv_medal_desc)");
        TextView textView2 = (TextView) findViewById3;
        View findViewById4 = inflate.findViewById(R.id.tv_get_time);
        Intrinsics.c(findViewById4, "view.findViewById(R.id.tv_get_time)");
        TextView textView3 = (TextView) findViewById4;
        View findViewById5 = inflate.findViewById(R.id.tv_valid_time);
        Intrinsics.c(findViewById5, "view.findViewById(R.id.tv_valid_time)");
        TextView textView4 = (TextView) findViewById5;
        String icon = liveMedalItemData2.getIcon();
        Intrinsics.a((Object) icon);
        ImageLoader.a((IRequestHost) null, icon).b(R.drawable.anchor_badge_default).f().g(-1).a(imageView);
        textView.setText(liveMedalItemData2.getName());
        textView2.setText(liveMedalItemData2.getDescription());
        String a2 = PermissionUtils.a(R.string.live_get_medal_time);
        long created_time = liveMedalItemData2.getCreated_time();
        long j = 1000;
        textView3.setText(Intrinsics.a(a2, (Object) LiveTimeAndDateUtils.b(created_time * j)));
        textView4.setVisibility(0);
        if (liveMedalItemData2.is_hide_expire_time() == 1) {
            textView4.setVisibility(8);
        } else if (liveMedalItemData2.getExpire_time() == 0) {
            textView4.setText("永久有效");
        } else {
            textView4.setText(Intrinsics.a(PermissionUtils.a(R.string.live_valid_time), (Object) LiveTimeAndDateUtils.b(liveMedalItemData2.getExpire_time() * j)));
        }
        if (inflate.getParent() != null) {
            ((ViewGroup) inflate).removeView(inflate);
        }
        container.addView(inflate);
        return inflate;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object object) {
        Intrinsics.e(view, "view");
        Intrinsics.e(object, "object");
        return view == object;
    }
}
