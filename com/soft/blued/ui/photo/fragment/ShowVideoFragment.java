package com.soft.blued.ui.photo.fragment;

import android.content.Context;
import android.media.tv.TvContract;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import com.blued.android.framework.permission.PermissionCallbacks;
import com.blued.android.framework.ui.xpop.XPopup;
import com.blued.android.framework.ui.xpop.core.BasePopupView;
import com.blued.android.module.common.utils.PermissionUtils;
import com.blued.android.module.common.widget.menu.BottomMenuPop;
import com.blued.android.module.media.selector.utils.Tools;
import com.blued.android.module.player.media.model.VideoPlayConfig;
import com.blued.das.message.MessageProtos;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.customview.HackyViewPager;
import com.soft.blued.log.track.EventTrackMessage;
import java.util.ArrayList;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/photo/fragment/ShowVideoFragment.class */
public class ShowVideoFragment extends BasePhotoFragment implements View.OnClickListener {

    /* renamed from: c  reason: collision with root package name */
    private Context f33110c;
    private View d;
    private ImagePagerAdapter e;
    private HackyViewPager f;
    private ImageView g;
    private int h;
    private String i;
    private View j;
    private TextView k;
    private String l;
    private String m;
    private Boolean n;
    private int o;
    private int p;
    private long q;
    private String r = "";
    private BottomMenuPop s;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/photo/fragment/ShowVideoFragment$ImagePagerAdapter.class */
    public class ImagePagerAdapter extends FragmentStatePagerAdapter {
        public ImagePagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return 1;
        }

        @Override // androidx.fragment.app.FragmentStatePagerAdapter
        public Fragment getItem(int i) {
            VideoPlayConfig videoPlayConfig = new VideoPlayConfig();
            videoPlayConfig.b = ShowVideoFragment.this.l;
            videoPlayConfig.f15652a = ShowVideoFragment.this.m;
            videoPlayConfig.f15653c = ShowVideoFragment.this.q;
            return BizVideoDetailFragment.a(videoPlayConfig, ShowVideoFragment.this.h);
        }
    }

    private void a(final String str) {
        ArrayList arrayList = new ArrayList();
        BottomMenuPop.MenuItemInfo menuItemInfo = new BottomMenuPop.MenuItemInfo();
        menuItemInfo.f11214a = getResources().getString(R.string.save);
        menuItemInfo.b = 2131101766;
        menuItemInfo.d = new View.OnClickListener() { // from class: com.soft.blued.ui.photo.fragment.ShowVideoFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                if (ShowVideoFragment.this.s != null) {
                    ShowVideoFragment.this.s.p();
                }
                PermissionUtils.f(new PermissionCallbacks() { // from class: com.soft.blued.ui.photo.fragment.ShowVideoFragment.2.1
                    @Override // com.blued.android.framework.permission.PermissionCallbacks
                    public void U_() {
                        Tools.d(str);
                        EventTrackMessage.a(MessageProtos.Event.MSG_SAVE_VIDEO_CLICK, MessageProtos.StrangerSource.UNKNOWN_STRANGER_SOURCE, ShowVideoFragment.this.r);
                    }

                    @Override // com.blued.android.framework.permission.PermissionCallbacks
                    public void a(String[] strArr) {
                    }
                });
            }
        };
        arrayList.add(menuItemInfo);
        BottomMenuPop bottomMenuPop = new BottomMenuPop(getContext());
        this.s = bottomMenuPop;
        bottomMenuPop.b = arrayList;
        new XPopup.Builder(getContext()).a((BasePopupView) this.s).h();
    }

    private void h() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.i = getArguments().getString("key_feed_id");
            this.h = getArguments().getInt("show_photo");
            this.o = getArguments().getInt(TvContract.Programs.COLUMN_VIDEO_WIDTH);
            this.p = getArguments().getInt(TvContract.Programs.COLUMN_VIDEO_HEIGHT);
            this.m = arguments.getString("video_preview_url");
            this.l = arguments.getString("video_url");
            this.q = arguments.getLong("video_size");
            this.n = Boolean.valueOf(arguments.getBoolean("support_save"));
            this.r = arguments.getString("target_uid");
        }
    }

    private void i() {
        this.f = (HackyViewPager) this.d.findViewById(2131368810);
        ImageView imageView = (ImageView) this.d.findViewById(2131362969);
        this.g = imageView;
        imageView.setOnClickListener(this);
        View findViewById = this.d.findViewById(2131371256);
        this.j = findViewById;
        findViewById.setOnClickListener(this);
        this.k = (TextView) this.d.findViewById(R.id.tv_position);
        ImagePagerAdapter imagePagerAdapter = new ImagePagerAdapter(getChildFragmentManager());
        this.e = imagePagerAdapter;
        this.f.setAdapter(imagePagerAdapter);
        this.g.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.photo.fragment.ShowVideoFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                ShowVideoFragment.this.f();
            }
        });
        this.g.setVisibility(0);
        this.j.setVisibility(8);
        this.k.setVisibility(8);
    }

    private void j() {
    }

    @Override // com.soft.blued.ui.photo.fragment.BasePhotoFragment, com.blued.android.module.player.media.observer.EventCallBackListener
    public void a(int i) {
        super.a(i);
        this.f.getBackground().setAlpha(i);
        if (this.f33053a) {
            a((View) this.g, (View) this.k, false);
        }
    }

    @Override // com.soft.blued.ui.photo.fragment.BasePhotoFragment, com.blued.android.module.player.media.observer.EventCallBackListener
    public void a(View view) {
        super.a(view);
    }

    @Override // com.soft.blued.ui.photo.fragment.BasePhotoFragment, com.blued.android.module.player.media.observer.EventCallBackListener
    public void a(Object... objArr) {
        super.a(objArr);
        if (this.n.booleanValue() && objArr != null && objArr.length > 0) {
            try {
                a((String) objArr[0]);
            } catch (Throwable th) {
            }
        }
    }

    @Override // com.soft.blued.ui.photo.fragment.BasePhotoFragment, com.blued.android.module.player.media.observer.EventCallBackListener
    public void al_() {
        super.al_();
        if (this.f33053a) {
            return;
        }
        b(this.g, this.k, false);
    }

    @Override // com.soft.blued.ui.photo.fragment.BasePhotoFragment, com.blued.android.module.player.media.observer.EventCallBackListener
    public void b(View view) {
        super.b(view);
        f();
    }

    @Override // com.blued.android.core.ui.BaseFragment
    public boolean isActivitySwipeBackEnable() {
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        if (view.getId() != 2131362969) {
            return;
        }
        e();
    }

    @Override // com.soft.blued.ui.photo.fragment.BasePhotoFragment, com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        getActivity().getWindow().setFlags(128, 128);
        super.onCreate(bundle);
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f33110c = getActivity();
        View view = this.d;
        if (view == null) {
            this.d = layoutInflater.inflate(R.layout.fragment_show_album, viewGroup, false);
            h();
            i();
            j();
        } else if (view.getParent() != null) {
            ((ViewGroup) this.d.getParent()).removeView(this.d);
        }
        return this.d;
    }

    @Override // com.soft.blued.ui.photo.fragment.BasePhotoFragment, com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }
}
