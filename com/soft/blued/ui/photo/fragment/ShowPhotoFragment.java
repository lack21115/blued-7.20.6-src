package com.soft.blued.ui.photo.fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.imagecache.LoadOptions;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.permission.PermissionCallbacks;
import com.blued.android.framework.ui.xpop.XPopup;
import com.blued.android.framework.ui.xpop.core.BasePopupView;
import com.blued.android.module.common.user.model.BluedAlbum;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.utils.CommonPreferences;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.android.module.common.utils.PermissionUtils;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.blued.android.module.common.widget.dialog.CommonAlertDialog;
import com.blued.android.module.common.widget.menu.ActionSheet;
import com.blued.android.module.common.widget.menu.BottomMenuPop;
import com.blued.android.module.common.widget.menu.CommonShowBottomWindow;
import com.blued.das.profile.PersonalProfileProtos;
import com.blued.das.vip.VipProtos;
import com.bytedance.applog.tracker.Tracker;
import com.github.chrisbanes.photoview.PhotoView;
import com.j256.ormlite.stmt.query.SimpleComparison;
import com.soft.blued.R;
import com.soft.blued.customview.HackyViewPager;
import com.soft.blued.http.MineHttpUtils;
import com.soft.blued.http.ProfileHttpUtils;
import com.soft.blued.log.InstantLog;
import com.soft.blued.log.track.EventTrackPersonalProfile;
import com.soft.blued.ui.live.manager.LiveApplyDelPhotoObserver;
import com.soft.blued.ui.user.fragment.WidgetListFragment;
import com.soft.blued.utils.BluedPreferences;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/photo/fragment/ShowPhotoFragment.class */
public class ShowPhotoFragment extends BasePhotoFragment implements View.OnClickListener {

    /* renamed from: c  reason: collision with root package name */
    private Context f33093c;
    private View d;
    private LayoutInflater e;
    private ImagePagerAdapter f;
    private LoadOptions g;
    private int h;
    private int i;
    private Dialog j;
    private HackyViewPager k;
    private ImageView l;
    private int m;
    private String n;
    private List<BluedAlbum> o = new ArrayList();
    private String[] p;
    private String[] q;
    private View r;
    private TextView s;
    private TextView t;
    private String u;
    private int v;
    private BottomMenuPop w;

    /* renamed from: com.soft.blued.ui.photo.fragment.ShowPhotoFragment$3  reason: invalid class name */
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/photo/fragment/ShowPhotoFragment$3.class */
    class AnonymousClass3 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ PhotoView f33096a;
        final /* synthetic */ ShowPhotoFragment b;

        @Override // java.lang.Runnable
        public void run() {
            boolean z = false;
            if (((int) this.f33096a.getScale()) != ((int) this.f33096a.getMinimumScale())) {
                if (this.b.f33053a) {
                    ShowPhotoFragment showPhotoFragment = this.b;
                    ImageView imageView = showPhotoFragment.l;
                    TextView textView = this.b.s;
                    if (this.b.o.size() > 1) {
                        z = true;
                    }
                    showPhotoFragment.a(imageView, textView, z);
                }
            } else if (this.b.f33053a) {
            } else {
                ShowPhotoFragment showPhotoFragment2 = this.b;
                ImageView imageView2 = showPhotoFragment2.l;
                TextView textView2 = this.b.s;
                boolean z2 = false;
                if (this.b.o.size() > 1) {
                    z2 = true;
                }
                showPhotoFragment2.b(imageView2, textView2, z2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/photo/fragment/ShowPhotoFragment$ImagePagerAdapter.class */
    public class ImagePagerAdapter extends FragmentStatePagerAdapter {
        public ImagePagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return ShowPhotoFragment.this.o.size();
        }

        @Override // androidx.fragment.app.FragmentStatePagerAdapter
        public Fragment getItem(int i) {
            return BizPhotoDetailFragment.a(((BluedAlbum) ShowPhotoFragment.this.o.get(i)).getUrl(), ShowPhotoFragment.this.m, ShowPhotoFragment.this.g);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final String str) {
        DialogUtils.a(this.j);
        MineHttpUtils.c(this.f33093c, new BluedUIHttpResponse<BluedEntityA<Object>>() { // from class: com.soft.blued.ui.photo.fragment.ShowPhotoFragment.7
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<Object> bluedEntityA) {
                try {
                    List<BluedAlbum> vip_avatars = UserInfo.getInstance().getLoginUserInfo().getVip_avatars();
                    if (vip_avatars != null && vip_avatars.size() > 0) {
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 >= vip_avatars.size()) {
                                break;
                            } else if (vip_avatars.get(i2).getPid().equals(str)) {
                                vip_avatars.remove(i2);
                                break;
                            } else {
                                i = i2 + 1;
                            }
                        }
                    }
                    ShowPhotoFragment.this.o.remove(ShowPhotoFragment.this.h);
                    if (ShowPhotoFragment.this.h >= ShowPhotoFragment.this.o.size() - 1) {
                        ShowPhotoFragment.this.h = ShowPhotoFragment.this.o.size() - 1;
                    }
                    ShowPhotoFragment.this.k.setAdapter(ShowPhotoFragment.this.f);
                    ShowPhotoFragment.this.k.setCurrentItem(ShowPhotoFragment.this.h);
                    ShowPhotoFragment.this.k();
                    if (bluedEntityA.code == 200) {
                        AppMethods.d((int) R.string.done);
                    } else {
                        AppMethods.d(2131887272);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    AppMethods.a((CharSequence) AppInfo.d().getResources().getString(2131887272));
                }
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                DialogUtils.b(ShowPhotoFragment.this.j);
                if (ShowPhotoFragment.this.o.size() == 0) {
                    ShowPhotoFragment.this.getActivity().finish();
                }
            }
        }, str, getFragmentActive());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final String str) {
        DialogUtils.a(this.j);
        ProfileHttpUtils.b(this.f33093c, new BluedUIHttpResponse<BluedEntityA<Object>>() { // from class: com.soft.blued.ui.photo.fragment.ShowPhotoFragment.8
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<Object> bluedEntityA) {
                try {
                    List<BluedAlbum> album = UserInfo.getInstance().getLoginUserInfo().getAlbum();
                    if (album != null && album.size() > 0) {
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 >= album.size()) {
                                break;
                            } else if (album.get(i2).getPid().equals(str)) {
                                album.remove(i2);
                                break;
                            } else {
                                i = i2 + 1;
                            }
                        }
                    }
                    ShowPhotoFragment.this.o.remove(ShowPhotoFragment.this.h);
                    if (ShowPhotoFragment.this.h >= ShowPhotoFragment.this.o.size() - 1) {
                        ShowPhotoFragment.this.h = ShowPhotoFragment.this.o.size() - 1;
                    }
                    ShowPhotoFragment.this.k.setAdapter(ShowPhotoFragment.this.f);
                    ShowPhotoFragment.this.k.setCurrentItem(ShowPhotoFragment.this.h);
                    ShowPhotoFragment.this.k();
                    if (bluedEntityA.code == 200) {
                        AppMethods.d((int) R.string.done);
                    } else {
                        AppMethods.d(2131887272);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    AppMethods.a((CharSequence) AppInfo.d().getResources().getString(2131887272));
                }
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                DialogUtils.b(ShowPhotoFragment.this.j);
                if (ShowPhotoFragment.this.o.size() == 0) {
                    ShowPhotoFragment.this.getActivity().finish();
                }
            }
        }, str, getFragmentActive());
    }

    private void h() {
        int i;
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.m = getArguments().getInt("show_photo");
            this.n = getArguments().getString("WATER_MASK_NAME");
            this.h = arguments.getInt("photo_index", 0);
            this.g = (LoadOptions) arguments.getSerializable("photo_options");
            this.u = arguments.getString("UID");
            this.v = arguments.getInt("avatar_widget");
            this.i = this.h;
            this.q = arguments.getStringArray("photo_datas");
            this.p = arguments.getStringArray("photo_pids");
            if (this.q != null) {
                String str = "";
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 >= this.q.length) {
                        break;
                    }
                    str = str + SimpleComparison.NOT_EQUAL_TO_OPERATION + this.q[i3];
                    i2 = i3 + 1;
                }
                for (i = 0; i < this.q.length; i++) {
                    BluedAlbum bluedAlbum = new BluedAlbum();
                    bluedAlbum.setUrl(this.q[i]);
                    String[] strArr = this.p;
                    if (strArr != null) {
                        bluedAlbum.setPid(strArr[i]);
                    }
                    this.o.add(bluedAlbum);
                }
            }
        }
    }

    private void i() {
        this.j = DialogUtils.a(getActivity());
        this.e = LayoutInflater.from(this.f33093c);
        this.k = (HackyViewPager) this.d.findViewById(2131368810);
        ImageView imageView = (ImageView) this.d.findViewById(2131362969);
        this.l = imageView;
        imageView.setOnClickListener(this);
        this.r = this.d.findViewById(2131371256);
        this.t = (TextView) this.d.findViewById(R.id.tv_avatar_widget);
        this.r.setOnClickListener(this);
        this.s = (TextView) this.d.findViewById(R.id.tv_position);
        ImagePagerAdapter imagePagerAdapter = new ImagePagerAdapter(getChildFragmentManager());
        this.f = imagePagerAdapter;
        this.k.setAdapter(imagePagerAdapter);
        this.k.setCurrentItem(this.h);
        this.k.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.soft.blued.ui.photo.fragment.ShowPhotoFragment.1
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                ShowPhotoFragment.this.h = i;
                ShowPhotoFragment.this.k();
            }
        });
        this.l.setVisibility(0);
        k();
        if (this.p != null) {
            this.r.setVisibility(0);
        } else {
            this.r.setVisibility(8);
        }
        if (this.m == 8) {
            this.r.setVisibility(8);
        }
    }

    private void j() {
        if (this.m != 1 || !TextUtils.equals(UserInfo.getInstance().getLoginUserInfo().uid, this.u) || UserInfo.getInstance().getLoginUserInfo().vip_grade == 0 || BluedPreferences.cV()) {
            return;
        }
        this.t.setVisibility(0);
        AppInfo.n().postDelayed(new Runnable() { // from class: com.soft.blued.ui.photo.fragment.ShowPhotoFragment.2
            @Override // java.lang.Runnable
            public void run() {
                ShowPhotoFragment.this.t.setVisibility(8);
                BluedPreferences.cW();
            }
        }, 5000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        if (this.o.size() <= 1) {
            this.s.setVisibility(8);
            return;
        }
        TextView textView = this.s;
        textView.setText((this.h + 1) + BridgeUtil.SPLIT_MARK + this.o.size());
        if (this.f33053a) {
            this.s.setVisibility(0);
        }
    }

    @Override // com.soft.blued.ui.photo.fragment.BasePhotoFragment, com.blued.android.module.player.media.observer.EventCallBackListener
    public void a(int i) {
        super.a(i);
        this.k.getBackground().setAlpha(i);
        if (this.f33053a) {
            ImageView imageView = this.l;
            TextView textView = this.s;
            boolean z = true;
            if (this.o.size() <= 1) {
                z = false;
            }
            a(imageView, textView, z);
        }
    }

    @Override // com.soft.blued.ui.photo.fragment.BasePhotoFragment, com.blued.android.module.player.media.observer.EventCallBackListener
    public void a(View view) {
        super.a(view);
        f();
    }

    @Override // com.soft.blued.ui.photo.fragment.BasePhotoFragment, com.blued.android.module.player.media.observer.EventCallBackListener
    public void a(Object... objArr) {
        super.a(objArr);
        if (objArr == null || objArr.length < 2) {
            return;
        }
        boolean z = true;
        if (objArr[1] == null || !(objArr[1] instanceof File)) {
            return;
        }
        final File file = (File) objArr[1];
        ArrayList arrayList = new ArrayList();
        if (TextUtils.equals(UserInfo.getInstance().getLoginUserInfo().uid, this.u)) {
            arrayList.add(this.f33093c.getResources().getString(2131887375));
            EventTrackPersonalProfile.a(PersonalProfileProtos.Event.PERSONAL_SET_PHOTO_PENDANT_SHOW);
        } else if (this.v != 0) {
            arrayList.add(this.f33093c.getResources().getString(2131892575));
            EventTrackPersonalProfile.a(PersonalProfileProtos.Event.PERSONAL_LOOK_PHOTO_PENDANT_SHOW, this.u, this.v + "");
        } else {
            z = false;
        }
        arrayList.add(this.f33093c.getResources().getString(2131887285));
        if (z) {
            CommonShowBottomWindow.a((FragmentActivity) this.f33093c, (String[]) arrayList.toArray(new String[arrayList.size()]), new ActionSheet.ActionSheetListener() { // from class: com.soft.blued.ui.photo.fragment.ShowPhotoFragment.4
                @Override // com.blued.android.module.common.widget.menu.ActionSheet.ActionSheetListener
                public void a(ActionSheet actionSheet, int i) {
                    String a2 = actionSheet.a(i);
                    if (a2.equals(ShowPhotoFragment.this.f33093c.getResources().getString(2131887375))) {
                        CommonPreferences.o();
                        EventTrackPersonalProfile.a(PersonalProfileProtos.Event.PERSONAL_SET_PHOTO_PENDANT_CLICK);
                        WidgetListFragment.a(ShowPhotoFragment.this.f33093c, 2, "photo_pendant_own", VipProtos.FromType.PHOTO_PENDANT_OWN);
                    } else if (!a2.equals(ShowPhotoFragment.this.f33093c.getResources().getString(2131892575))) {
                        if (a2.equals(ShowPhotoFragment.this.f33093c.getResources().getString(2131887285))) {
                            InstantLog.a("save_pic_click");
                            PermissionUtils.f(new PermissionCallbacks() { // from class: com.soft.blued.ui.photo.fragment.ShowPhotoFragment.4.1
                                @Override // com.blued.android.framework.permission.PermissionCallbacks
                                public void U_() {
                                    ShowPhotoFragment.this.a(file, ShowPhotoFragment.this.n);
                                }

                                @Override // com.blued.android.framework.permission.PermissionCallbacks
                                public void a(String[] strArr) {
                                }
                            });
                        }
                    } else {
                        PersonalProfileProtos.Event event = PersonalProfileProtos.Event.PERSONAL_LOOK_PHOTO_PENDANT_CLICK;
                        String str = ShowPhotoFragment.this.u;
                        EventTrackPersonalProfile.a(event, str, ShowPhotoFragment.this.v + "");
                        WidgetListFragment.a(ShowPhotoFragment.this.f33093c, 2, "photo_pendant_other", VipProtos.FromType.PHOTO_PENDANT_OTHER);
                    }
                }

                @Override // com.blued.android.module.common.widget.menu.ActionSheet.ActionSheetListener
                public void a(ActionSheet actionSheet, boolean z2) {
                }
            });
            return;
        }
        String[] stringArray = getResources().getStringArray(2130903082);
        if (stringArray.length > 0) {
            ArrayList arrayList2 = new ArrayList();
            BottomMenuPop.MenuItemInfo menuItemInfo = new BottomMenuPop.MenuItemInfo();
            menuItemInfo.f11214a = stringArray[0];
            menuItemInfo.b = 2131101766;
            menuItemInfo.d = new View.OnClickListener() { // from class: com.soft.blued.ui.photo.fragment.ShowPhotoFragment.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    if (ShowPhotoFragment.this.w != null) {
                        ShowPhotoFragment.this.w.p();
                    }
                    InstantLog.a("save_pic_click");
                    PermissionUtils.f(new PermissionCallbacks() { // from class: com.soft.blued.ui.photo.fragment.ShowPhotoFragment.5.1
                        @Override // com.blued.android.framework.permission.PermissionCallbacks
                        public void U_() {
                            ShowPhotoFragment.this.a(file, ShowPhotoFragment.this.n);
                        }

                        @Override // com.blued.android.framework.permission.PermissionCallbacks
                        public void a(String[] strArr) {
                        }
                    });
                }
            };
            arrayList2.add(menuItemInfo);
            BottomMenuPop bottomMenuPop = new BottomMenuPop(getContext());
            this.w = bottomMenuPop;
            bottomMenuPop.b = arrayList2;
            new XPopup.Builder(getContext()).a((BasePopupView) this.w).h();
        }
    }

    @Override // com.soft.blued.ui.photo.fragment.BasePhotoFragment, com.blued.android.module.player.media.observer.EventCallBackListener
    public void al_() {
        super.al_();
        if (this.f33053a) {
            return;
        }
        ImageView imageView = this.l;
        TextView textView = this.s;
        boolean z = true;
        if (this.o.size() <= 1) {
            z = false;
        }
        b(imageView, textView, z);
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
        int id = view.getId();
        if (id == 2131362969) {
            e();
        } else if (id != 2131371256) {
        } else {
            Context context = this.f33093c;
            CommonAlertDialog.a(context, (String) null, context.getResources().getString(R.string.feed_photo_delete_confirm), this.f33093c.getResources().getString(2131887281), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.photo.fragment.ShowPhotoFragment.6
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    Tracker.onClick(dialogInterface, i);
                    if (ShowPhotoFragment.this.m == 8) {
                        LiveApplyDelPhotoObserver.a().b();
                        ShowPhotoFragment.this.f();
                        return;
                    }
                    String pid = ((BluedAlbum) ShowPhotoFragment.this.o.get(ShowPhotoFragment.this.h)).getPid();
                    int i2 = ShowPhotoFragment.this.m;
                    if (i2 == 3) {
                        ShowPhotoFragment.this.b(pid);
                    } else if (i2 != 13) {
                    } else {
                        ShowPhotoFragment.this.a(pid);
                    }
                }
            }, (String) null, (DialogInterface.OnClickListener) null, (DialogInterface.OnDismissListener) null);
        }
    }

    @Override // com.soft.blued.ui.photo.fragment.BasePhotoFragment, com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT >= 21) {
            getActivity().postponeEnterTransition();
        }
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f33093c = getActivity();
        View view = this.d;
        if (view == null) {
            this.d = layoutInflater.inflate(R.layout.fragment_show_album, viewGroup, false);
            h();
            i();
            j();
        } else if (view.getParent() != null) {
            ((ViewGroup) this.d.getParent()).removeView(this.d);
        }
        if (bundle != null) {
            this.h = bundle.getInt("state_position");
        }
        return this.d;
    }

    @Override // com.soft.blued.ui.photo.fragment.BasePhotoFragment, com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("state_position", this.k.getCurrentItem());
    }
}
