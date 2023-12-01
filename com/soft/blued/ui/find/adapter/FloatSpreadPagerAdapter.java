package com.soft.blued.ui.find.adapter;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewpager.widget.PagerAdapter;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.live_china.model.AnchorLiveStateModel;
import com.blued.android.module.live_china.model.LiveRoomData;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.android.similarity_operation_provider.BluedURIRouterAdapter;
import com.blued.das.live.LiveProtos;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.http.LiveHttpUtils;
import com.soft.blued.ui.live.LiveRoomInfoChannel;
import com.soft.blued.ui.live.model.LiveFloatSpreadModel;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/adapter/FloatSpreadPagerAdapter.class */
public class FloatSpreadPagerAdapter extends PagerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public BaseFragment f30041a;
    private List<LiveFloatSpreadModel> b;

    /* renamed from: c  reason: collision with root package name */
    private List<View> f30042c = new ArrayList();
    private List<ViewHolder> d = new ArrayList();
    private List<Unbinder> e = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/adapter/FloatSpreadPagerAdapter$ImgViewHolder.class */
    public class ImgViewHolder extends ViewHolder {
        @BindView
        ImageView iv_img;

        ImgViewHolder() {
            super();
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/adapter/FloatSpreadPagerAdapter$ImgViewHolder_ViewBinding.class */
    public class ImgViewHolder_ViewBinding implements Unbinder {
        private ImgViewHolder b;

        public ImgViewHolder_ViewBinding(ImgViewHolder imgViewHolder, View view) {
            this.b = imgViewHolder;
            imgViewHolder.iv_img = (ImageView) Utils.a(view, 2131365520, "field 'iv_img'", ImageView.class);
        }

        @Override // butterknife.Unbinder
        public void unbind() {
            ImgViewHolder imgViewHolder = this.b;
            if (imgViewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.b = null;
            imgViewHolder.iv_img = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/adapter/FloatSpreadPagerAdapter$ReddishBagViewHolder.class */
    public class ReddishBagViewHolder extends ViewHolder {
        @BindView
        ImageView iv_avatar;
        @BindView
        TextView tv_bag_num;

        ReddishBagViewHolder() {
            super();
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/adapter/FloatSpreadPagerAdapter$ReddishBagViewHolder_ViewBinding.class */
    public class ReddishBagViewHolder_ViewBinding implements Unbinder {
        private ReddishBagViewHolder b;

        public ReddishBagViewHolder_ViewBinding(ReddishBagViewHolder reddishBagViewHolder, View view) {
            this.b = reddishBagViewHolder;
            reddishBagViewHolder.iv_avatar = (ImageView) Utils.a(view, 2131365082, "field 'iv_avatar'", ImageView.class);
            reddishBagViewHolder.tv_bag_num = (TextView) Utils.a(view, R.id.tv_bag_num, "field 'tv_bag_num'", TextView.class);
        }

        @Override // butterknife.Unbinder
        public void unbind() {
            ReddishBagViewHolder reddishBagViewHolder = this.b;
            if (reddishBagViewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.b = null;
            reddishBagViewHolder.iv_avatar = null;
            reddishBagViewHolder.tv_bag_num = null;
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/adapter/FloatSpreadPagerAdapter$ViewHolder.class */
    class ViewHolder {
        ViewHolder() {
        }
    }

    public FloatSpreadPagerAdapter(BaseFragment baseFragment, List<LiveFloatSpreadModel> list) {
        this.f30041a = baseFragment;
        this.b = list;
    }

    private void a(View view, int i, ImgViewHolder imgViewHolder) {
        List<LiveFloatSpreadModel> list = this.b;
        if (list == null || i >= list.size() || this.b.get(i) == null || this.b.get(i).image == null || this.b.get(i).image.isEmpty()) {
            return;
        }
        final LiveFloatSpreadModel liveFloatSpreadModel = this.b.get(i);
        ImageLoader.a(this.f30041a.getFragmentActive(), liveFloatSpreadModel.image.get(0)).b(R.drawable.icon_float_spread_img_default).a(imgViewHolder.iv_img);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.find.adapter.-$$Lambda$FloatSpreadPagerAdapter$cPWo7tmIQ6HGDkHkhJMZQcqzqQM
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                FloatSpreadPagerAdapter.this.a(liveFloatSpreadModel, view2);
            }
        });
    }

    private void a(View view, int i, ReddishBagViewHolder reddishBagViewHolder, boolean z) {
        List<LiveFloatSpreadModel> list = this.b;
        if (list == null || i >= list.size() || this.b.get(i) == null || this.b.get(i).image == null || this.b.get(i).image.isEmpty()) {
            return;
        }
        final LiveFloatSpreadModel liveFloatSpreadModel = this.b.get(i);
        a(reddishBagViewHolder.iv_avatar, liveFloatSpreadModel.image, 0, z);
        TextView textView = reddishBagViewHolder.tv_bag_num;
        String string = this.f30041a.getResources().getString(2131890213);
        textView.setText(String.format(string, liveFloatSpreadModel.image.size() + ""));
        view.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.find.adapter.-$$Lambda$FloatSpreadPagerAdapter$MHsL7xylEa2tFzjDAwWTicmn5tg
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                FloatSpreadPagerAdapter.this.b(liveFloatSpreadModel, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(final ImageView imageView, final List list, final int i) {
        imageView.animate().alpha(0.0f).translationX(-10.0f).setDuration(200L).setInterpolator(new AccelerateInterpolator(1.5f)).setListener(new AnimatorListenerAdapter() { // from class: com.soft.blued.ui.find.adapter.FloatSpreadPagerAdapter.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                imageView.setTranslationX(10.0f);
                FloatSpreadPagerAdapter.this.a(imageView, (List<String>) list, i + 1, true);
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final ImageView imageView, final List<String> list, int i, boolean z) {
        if (list == null || list.size() == 0) {
            return;
        }
        int i2 = i;
        if (i >= list.size()) {
            i2 = 0;
        }
        ImageLoader.a(this.f30041a.getFragmentActive(), list.get(i2)).b(2131237310).c().a(imageView);
        if (!z || list.size() == 1) {
            imageView.animate().setDuration(0L).setListener(null);
            return;
        }
        imageView.animate().alpha(1.0f).translationX(0.0f).setDuration(200L).setInterpolator(new DecelerateInterpolator(1.5f)).setListener(null).start();
        final int i3 = i2;
        this.f30041a.postDelaySafeRunOnUiThread(new Runnable() { // from class: com.soft.blued.ui.find.adapter.-$$Lambda$FloatSpreadPagerAdapter$bBJXB-kwkDqlO9dov4WEoQknxKQ
            @Override // java.lang.Runnable
            public final void run() {
                FloatSpreadPagerAdapter.this.a(imageView, list, i3);
            }
        }, 2800L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(LiveFloatSpreadModel liveFloatSpreadModel, View view) {
        Tracker.onClick(view);
        if (liveFloatSpreadModel.type == 2) {
            EventTrackLive.b(LiveProtos.Event.LIVE_RESOURCE_CLICK, liveFloatSpreadModel.id, liveFloatSpreadModel.lid);
            a(liveFloatSpreadModel.uid);
        } else if (liveFloatSpreadModel.type == 3) {
            EventTrackLive.d(LiveProtos.Event.LIVE_RESOURCE_CLICK, liveFloatSpreadModel.id, liveFloatSpreadModel.redirect);
            WebViewShowInfoFragment.show(this.f30041a.getContext(), liveFloatSpreadModel.redirect, 7);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(LiveFloatSpreadModel liveFloatSpreadModel, View view) {
        Tracker.onClick(view);
        EventTrackLive.d(LiveProtos.Event.LIVE_RESOURCE_CLICK, liveFloatSpreadModel.id, liveFloatSpreadModel.redirect);
        WebViewShowInfoFragment.show(this.f30041a.getContext(), liveFloatSpreadModel.redirect, 7);
    }

    public void a(String str) {
        LiveHttpUtils.a(this.f30041a.getActivity(), new BluedUIHttpResponse<BluedEntityA<AnchorLiveStateModel>>() { // from class: com.soft.blued.ui.find.adapter.FloatSpreadPagerAdapter.2
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<AnchorLiveStateModel> bluedEntityA) {
                if (bluedEntityA == null || bluedEntityA.getSingleData() == null) {
                    return;
                }
                AnchorLiveStateModel singleData = bluedEntityA.getSingleData();
                if (singleData.is_live != 1) {
                    BluedURIRouterAdapter.openUserInfoPage(FloatSpreadPagerAdapter.this.f30041a.getActivity(), singleData.uid, singleData.name, 0, 1, "live_float_banner", false, "");
                    return;
                }
                LiveRoomInfoChannel.a(AppInfo.d(), new LiveRoomData(singleData.lid, 0, "footprint", singleData.uid, singleData.name, singleData.avatar, 0), -1, null);
            }
        }, str, (IRequestHost) null);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView((View) obj);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        List<LiveFloatSpreadModel> list = this.b;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v4, types: [java.lang.Object, com.soft.blued.ui.find.adapter.FloatSpreadPagerAdapter$ImgViewHolder] */
    /* JADX WARN: Type inference failed for: r12v5 */
    /* JADX WARN: Type inference failed for: r12v6, types: [java.lang.Object, com.soft.blued.ui.find.adapter.FloatSpreadPagerAdapter$ReddishBagViewHolder] */
    /* JADX WARN: Type inference failed for: r6v0, types: [com.soft.blued.ui.find.adapter.FloatSpreadPagerAdapter] */
    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        ?? imgViewHolder;
        View inflate;
        Unbinder a2;
        List<LiveFloatSpreadModel> list = this.b;
        if (list == null || i >= list.size()) {
            return null;
        }
        if (this.f30042c.size() != this.b.size()) {
            List<View> list2 = this.f30042c;
            if (list2 != null) {
                list2.clear();
            } else {
                this.f30042c = new ArrayList();
            }
            List<ViewHolder> list3 = this.d;
            if (list3 != null) {
                list3.clear();
            } else {
                this.d = new ArrayList();
            }
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= this.b.size()) {
                    break;
                }
                boolean z = true;
                if (this.b.get(i3).type == 1) {
                    imgViewHolder = new ReddishBagViewHolder();
                    inflate = LayoutInflater.from(this.f30041a.getContext()).inflate(R.layout.item_float_spread_reddish_bag, viewGroup, false);
                    a2 = ButterKnife.a(imgViewHolder, inflate);
                    if (this.b.size() != 1) {
                        z = false;
                    }
                    a(inflate, i3, imgViewHolder, z);
                } else {
                    imgViewHolder = new ImgViewHolder();
                    inflate = LayoutInflater.from(this.f30041a.getContext()).inflate(R.layout.item_float_spread_img, viewGroup, false);
                    a2 = ButterKnife.a(imgViewHolder, inflate);
                    a(inflate, i3, imgViewHolder);
                }
                this.f30042c.add(inflate);
                this.d.add(imgViewHolder);
                this.e.add(a2);
                i2 = i3 + 1;
            }
        }
        View view = this.f30042c.get(i);
        if (view != null && view.getParent() != null) {
            ((ViewGroup) view).removeView(view);
        }
        viewGroup.addView(view);
        return view;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }
}
