package com.soft.blued.ui.user.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.viewpager.widget.PagerAdapter;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.das.vip.VipProtos;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.log.track.EventTrackVIP;
import com.soft.blued.ui.user.model.VIPCenterForJsonParse;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/adapter/VIPCenterBannerAdapter.class */
public class VIPCenterBannerAdapter extends PagerAdapter {

    /* renamed from: a  reason: collision with root package name */
    private List<View> f33789a = new ArrayList();
    private int b;

    public VIPCenterBannerAdapter(final Context context, IRequestHost iRequestHost, final int i, List<VIPCenterForJsonParse._banner> list) {
        this.b = i;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (final VIPCenterForJsonParse._banner _bannerVar : list) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.item_vip_head_avatar, (ViewGroup) null);
            ImageView imageView = (ImageView) inflate.findViewById(2131364628);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            ImageLoader.a(iRequestHost, _bannerVar.img).b(2131231620).a(imageView);
            inflate.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.adapter.-$$Lambda$VIPCenterBannerAdapter$Z9EsfbfbIP6lYa0sQ3miIg3bjUc
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    VIPCenterBannerAdapter.a(i, _bannerVar, context, view);
                }
            });
            inflate.setTag(_bannerVar);
            this.f33789a.add(inflate);
        }
        notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(int i, VIPCenterForJsonParse._banner _bannerVar, Context context, View view) {
        Tracker.onClick(view);
        EventTrackVIP.a(VipProtos.Event.VIP_CENTRE_BANNER_CLICK, UserInfo.getInstance().getLoginUserInfo().vip_grade, i, _bannerVar.link);
        WebViewShowInfoFragment.show(context, _bannerVar.link, -1);
    }

    public VIPCenterForJsonParse._banner a(int i) {
        List<View> list = this.f33789a;
        if (list == null || i >= list.size()) {
            return null;
        }
        return (VIPCenterForJsonParse._banner) this.f33789a.get(i).getTag();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView((View) obj);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        List<View> list = this.f33789a;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(Object obj) {
        return -2;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        viewGroup.addView(this.f33789a.get(i));
        return this.f33789a.get(i);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }
}
