package com.soft.blued.ui.setting.fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ToggleButton;
import androidx.fragment.app.FragmentActivity;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.imagecache.LoadOptions;
import com.blued.android.core.imagecache.RecyclingUtils;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.permission.PermissionCallbacks;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.upload.QiniuUploadTools;
import com.blued.android.framework.view.pulltorefresh.RenrenPullToRefreshListView;
import com.blued.android.module.common.user.model.BluedAlbum;
import com.blued.android.module.common.user.model.BluedLoginResult;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.user.model.UserRestrictedDescModel;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.android.module.common.utils.PermissionUtils;
import com.blued.android.module.common.utils.third.QiniuUploadUtils;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.android.module.common.widget.dialog.CommonAlertDialog;
import com.blued.android.module.common.widget.menu.ActionSheet;
import com.blued.android.module.common.widget.menu.CommonShowBottomWindow;
import com.blued.community.view.PhotoGridView;
import com.blued.das.vip.VipProtos;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.customview.DragGridBaseAdapter;
import com.soft.blued.http.LoginRegisterHttpUtils;
import com.soft.blued.http.ProfileHttpUtils;
import com.soft.blued.http.UserHttpUtils;
import com.soft.blued.log.track.EventTrackVIP;
import com.soft.blued.ui.feed.fragment.PhotoSelectFragment;
import com.soft.blued.ui.find.model.UserFindResult;
import com.soft.blued.ui.photo.fragment.BasePhotoFragment;
import com.soft.blued.ui.setting.Contract.PrivacyPhotoAlbumContract;
import com.soft.blued.ui.setting.Presenter.PrivacyPhotoAlbumPresenter;
import com.soft.blued.ui.setting.adapter.PrivacyPhotoAlbumAuthedUsersItemAdapter;
import com.soft.blued.ui.setting.fragment.PrivacyPhotoAlbumFragment;
import com.soft.blued.ui.user.model.UserInfoEntity;
import com.soft.blued.ui.user.presenter.PayUtils;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.StringUtils;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/fragment/PrivacyPhotoAlbumFragment.class */
public class PrivacyPhotoAlbumFragment extends BaseFragment implements View.OnClickListener, PrivacyPhotoAlbumContract.IView {
    private Context b;

    /* renamed from: c  reason: collision with root package name */
    private PrivacyPhotoAlbumContract.IPresenter f33536c;
    private LayoutInflater d;
    private View e;
    private CommonTopTitleNoTrans f;
    private Dialog g;
    private View h;
    private ListView i;
    private RenrenPullToRefreshListView j;
    private TextView k;
    private TextView l;
    private TextView m;
    private ToggleButton n;
    private RelativeLayout o;
    private PhotoGridView p;
    private PhotoAlbumGirdAdapter r;
    private int s;
    private BluedAlbum t;
    private PrivacyPhotoAlbumAuthedUsersItemAdapter w;
    private List<UserFindResult> x;
    private boolean y;
    private List<BluedAlbum> q = new ArrayList();
    private int u = 1;
    private final int v = 30;
    private boolean z = false;
    private boolean A = false;
    private boolean B = false;

    /* renamed from: a  reason: collision with root package name */
    public BluedUIHttpResponse f33535a = new BluedUIHttpResponse<BluedEntityA<UserInfoEntity>>() { // from class: com.soft.blued.ui.setting.fragment.PrivacyPhotoAlbumFragment.7
        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        /* renamed from: a */
        public void onUIUpdate(BluedEntityA<UserInfoEntity> bluedEntityA) {
            if (bluedEntityA == null) {
                AppMethods.d(2131888227);
                return;
            }
            DialogUtils.b(PrivacyPhotoAlbumFragment.this.g);
            UserInfoEntity userInfoEntity = bluedEntityA.data.get(0);
            if (userInfoEntity == null) {
                AppMethods.d(2131888227);
                return;
            }
            if (userInfoEntity.album != null) {
                UserInfo.getInstance().getLoginUserInfo().setAlbum(userInfoEntity.album);
            }
            PrivacyPhotoAlbumFragment.this.e();
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.soft.blued.ui.setting.fragment.PrivacyPhotoAlbumFragment$5  reason: invalid class name */
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/fragment/PrivacyPhotoAlbumFragment$5.class */
    public class AnonymousClass5 implements QiniuUploadTools.QiNiuListener {

        /* renamed from: a  reason: collision with root package name */
        double f33542a = 0.0d;
        final /* synthetic */ String b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f33543c;

        AnonymousClass5(String str, String str2) {
            this.b = str;
            this.f33543c = str2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(double d, String str) {
            StringBuilder sb = new StringBuilder();
            double d2 = d * 100.0d;
            sb.append(Math.round(d2));
            sb.append("%");
            String sb2 = sb.toString();
            int b = PrivacyPhotoAlbumFragment.this.b(str);
            if (d2 >= 100.0d) {
                ((BluedAlbum) PrivacyPhotoAlbumFragment.this.q.get(b)).setProgress("99%");
            } else if (d > this.f33542a) {
                ((BluedAlbum) PrivacyPhotoAlbumFragment.this.q.get(b)).setProgress(sb2);
                this.f33542a = d;
            }
            PrivacyPhotoAlbumFragment.this.r.notifyDataSetChanged();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(String str, String str2, String str3, String str4) {
            PrivacyPhotoAlbumFragment.this.a(str, str2, str3, str4);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(String str) {
            AppMethods.a((CharSequence) PrivacyPhotoAlbumFragment.this.getResources().getString(2131887272));
            ((BluedAlbum) PrivacyPhotoAlbumFragment.this.q.get(PrivacyPhotoAlbumFragment.this.b(str))).setProgress(PrivacyPhotoAlbumFragment.this.getResources().getString(R.string.failure));
            PrivacyPhotoAlbumFragment.this.r.notifyDataSetChanged();
        }

        @Override // com.blued.android.framework.utils.upload.QiniuUploadTools.QiNiuListener
        public void a(final String str) {
            PrivacyPhotoAlbumFragment.this.postSafeRunOnUiThread(new Runnable() { // from class: com.soft.blued.ui.setting.fragment.-$$Lambda$PrivacyPhotoAlbumFragment$5$-RG1rj3v4bq07T0gNjMfd0o6VKU
                @Override // java.lang.Runnable
                public final void run() {
                    PrivacyPhotoAlbumFragment.AnonymousClass5.this.b(str);
                }
            });
        }

        @Override // com.blued.android.framework.utils.upload.QiniuUploadTools.QiNiuListener
        public void a(final String str, final double d) {
            if (PrivacyPhotoAlbumFragment.this.y) {
                return;
            }
            PrivacyPhotoAlbumFragment.this.postSafeRunOnUiThread(new Runnable() { // from class: com.soft.blued.ui.setting.fragment.-$$Lambda$PrivacyPhotoAlbumFragment$5$SjlIqoO5vjd0tqg0GwhcOLV1oS8
                @Override // java.lang.Runnable
                public final void run() {
                    PrivacyPhotoAlbumFragment.AnonymousClass5.this.a(d, str);
                }
            });
        }

        @Override // com.blued.android.framework.utils.upload.QiniuUploadTools.QiNiuListener
        public void a(final String str, final String str2) {
            PrivacyPhotoAlbumFragment privacyPhotoAlbumFragment = PrivacyPhotoAlbumFragment.this;
            final String str3 = this.b;
            final String str4 = this.f33543c;
            privacyPhotoAlbumFragment.postSafeRunOnUiThread(new Runnable() { // from class: com.soft.blued.ui.setting.fragment.-$$Lambda$PrivacyPhotoAlbumFragment$5$AaUkE7cEtNH7BjVPsuaXMvktBO4
                @Override // java.lang.Runnable
                public final void run() {
                    PrivacyPhotoAlbumFragment.AnonymousClass5.this.a(str3, str, str4, str2);
                }
            });
        }

        @Override // com.blued.android.framework.utils.upload.QiniuUploadTools.QiNiuListener
        public boolean a() {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/fragment/PrivacyPhotoAlbumFragment$MyPullDownListener.class */
    public class MyPullDownListener implements RenrenPullToRefreshListView.OnPullDownListener {
        private MyPullDownListener() {
        }

        @Override // com.blued.android.framework.view.pulltorefresh.RenrenPullToRefreshListView.OnPullDownListener
        public void a() {
        }

        @Override // com.blued.android.framework.view.pulltorefresh.RenrenPullToRefreshListView.OnPullDownListener
        public void b() {
            PrivacyPhotoAlbumFragment.a(PrivacyPhotoAlbumFragment.this, 1);
            PrivacyPhotoAlbumFragment.this.f33536c.a(PrivacyPhotoAlbumFragment.this.u, 30);
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/fragment/PrivacyPhotoAlbumFragment$PhotoAlbumGirdAdapter.class */
    public class PhotoAlbumGirdAdapter extends BaseAdapter implements DragGridBaseAdapter {
        private LayoutInflater b;

        /* renamed from: c  reason: collision with root package name */
        private ImageView f33549c;
        private TextView d;
        private TextView e;
        private TextView f;
        private int g = -1;
        private LoadOptions h;

        /* renamed from: com.soft.blued.ui.setting.fragment.PrivacyPhotoAlbumFragment$PhotoAlbumGirdAdapter$1  reason: invalid class name */
        /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/fragment/PrivacyPhotoAlbumFragment$PhotoAlbumGirdAdapter$1.class */
        class AnonymousClass1 implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ BluedAlbum f33550a;
            final /* synthetic */ int b;

            AnonymousClass1(BluedAlbum bluedAlbum, int i) {
                this.f33550a = bluedAlbum;
                this.b = i;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                EventTrackVIP.a(VipProtos.Event.VIP_PRIVACY_PHOTO_LOCKED_CLICK);
                if (TextUtils.isEmpty(this.f33550a.getUrl())) {
                    CommonShowBottomWindow.a((FragmentActivity) PrivacyPhotoAlbumFragment.this.b, new String[]{PrivacyPhotoAlbumFragment.this.getResources().getString(2131891328)}, new ActionSheet.ActionSheetListener() { // from class: com.soft.blued.ui.setting.fragment.PrivacyPhotoAlbumFragment.PhotoAlbumGirdAdapter.1.2
                        @Override // com.blued.android.module.common.widget.menu.ActionSheet.ActionSheetListener
                        public void a(ActionSheet actionSheet, int i) {
                            if (i != 0) {
                                return;
                            }
                            EventTrackVIP.a(VipProtos.Event.VIP_PRIVACY_PHOTO_LOCKED_RENEW_CLICK);
                            PayUtils.a(PrivacyPhotoAlbumFragment.this.b, 0, "privacy_photo_locked_renew", 25, VipProtos.FromType.PRIVACY_PHOTO_LOCKED_RENEW);
                        }

                        @Override // com.blued.android.module.common.widget.menu.ActionSheet.ActionSheetListener
                        public void a(ActionSheet actionSheet, boolean z) {
                        }
                    });
                    return;
                }
                String[] stringArray = PrivacyPhotoAlbumFragment.this.getResources().getStringArray(R.array.headpic_items);
                stringArray[0] = PrivacyPhotoAlbumFragment.this.getResources().getString(2131891328);
                stringArray[1] = PrivacyPhotoAlbumFragment.this.getResources().getString(R.string.privacy_photo_album_look_big_pic);
                CommonShowBottomWindow.a((FragmentActivity) PrivacyPhotoAlbumFragment.this.b, stringArray, new ActionSheet.ActionSheetListener() { // from class: com.soft.blued.ui.setting.fragment.PrivacyPhotoAlbumFragment.PhotoAlbumGirdAdapter.1.1
                    @Override // com.blued.android.module.common.widget.menu.ActionSheet.ActionSheetListener
                    public void a(ActionSheet actionSheet, int i) {
                        if (i == 0) {
                            EventTrackVIP.a(VipProtos.Event.VIP_PRIVACY_PHOTO_LOCKED_RENEW_CLICK);
                            PayUtils.a(PrivacyPhotoAlbumFragment.this.b, 0, "privacy_photo_locked_renew", 25, VipProtos.FromType.PRIVACY_PHOTO_LOCKED_RENEW);
                        } else if (i != 1) {
                            if (i != 2) {
                                return;
                            }
                            CommonAlertDialog.a(PrivacyPhotoAlbumFragment.this.b, "", PrivacyPhotoAlbumFragment.this.getResources().getString(R.string.privacy_photo_album_delete_content), PrivacyPhotoAlbumFragment.this.getResources().getString(R.string.privacy_photo_album_delete_ok), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.setting.fragment.PrivacyPhotoAlbumFragment.PhotoAlbumGirdAdapter.1.1.1
                                @Override // android.content.DialogInterface.OnClickListener
                                public void onClick(DialogInterface dialogInterface, int i2) {
                                    Tracker.onClick(dialogInterface, i2);
                                    PrivacyPhotoAlbumFragment.this.f33536c.a(AnonymousClass1.this.f33550a.getPid());
                                }
                            }, PrivacyPhotoAlbumFragment.this.getResources().getString(R.string.privacy_photo_album_delete_cancel), (DialogInterface.OnClickListener) null, (DialogInterface.OnDismissListener) null);
                        } else {
                            ArrayList arrayList = new ArrayList();
                            for (BluedAlbum bluedAlbum : PrivacyPhotoAlbumFragment.this.q) {
                                if (bluedAlbum.getPid() != null && StringUtils.d(bluedAlbum.key)) {
                                    arrayList.add(bluedAlbum);
                                }
                            }
                            String[] strArr = new String[arrayList.size()];
                            String[] strArr2 = new String[arrayList.size()];
                            int i2 = 0;
                            while (true) {
                                int i3 = i2;
                                if (i3 >= arrayList.size()) {
                                    BasePhotoFragment.a(PrivacyPhotoAlbumFragment.this.b, strArr, strArr2, AnonymousClass1.this.b, 3, UserInfo.getInstance().getLoginUserInfo().getName(), PhotoAlbumGirdAdapter.this.h);
                                    return;
                                }
                                strArr[i3] = ((BluedAlbum) arrayList.get(i3)).getUrl();
                                strArr2[i3] = ((BluedAlbum) arrayList.get(i3)).getPid();
                                i2 = i3 + 1;
                            }
                        }
                    }

                    @Override // com.blued.android.module.common.widget.menu.ActionSheet.ActionSheetListener
                    public void a(ActionSheet actionSheet, boolean z) {
                    }
                });
            }
        }

        /* renamed from: com.soft.blued.ui.setting.fragment.PrivacyPhotoAlbumFragment$PhotoAlbumGirdAdapter$4  reason: invalid class name */
        /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/fragment/PrivacyPhotoAlbumFragment$PhotoAlbumGirdAdapter$4.class */
        class AnonymousClass4 implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ BluedAlbum f33559a;
            final /* synthetic */ int b;

            AnonymousClass4(BluedAlbum bluedAlbum, int i) {
                this.f33559a = bluedAlbum;
                this.b = i;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                PrivacyPhotoAlbumFragment.this.t = this.f33559a;
                PrivacyPhotoAlbumFragment.this.t.position = this.b;
                UserRestrictedDescModel userRestrictedDescModel = UserInfo.getInstance().getLoginUserInfo().restricted_desc;
                if (TextUtils.isEmpty(this.f33559a.getUrl())) {
                    if (userRestrictedDescModel == null) {
                        PermissionUtils.f(new PermissionCallbacks() { // from class: com.soft.blued.ui.setting.fragment.PrivacyPhotoAlbumFragment.PhotoAlbumGirdAdapter.4.1
                            @Override // com.blued.android.framework.permission.PermissionCallbacks
                            public void U_() {
                                PhotoSelectFragment.a(PrivacyPhotoAlbumFragment.this, 2, 22);
                            }

                            @Override // com.blued.android.framework.permission.PermissionCallbacks
                            public void a(String[] strArr) {
                            }
                        });
                        return;
                    } else if (userRestrictedDescModel.isExist("photo")) {
                        AppMethods.a((CharSequence) userRestrictedDescModel.getPhoto_desc());
                        return;
                    } else {
                        return;
                    }
                }
                String[] stringArray = PrivacyPhotoAlbumFragment.this.getResources().getStringArray(R.array.headpic_items);
                stringArray[0] = PrivacyPhotoAlbumFragment.this.getResources().getString(R.string.change_photo);
                int[] iArr = null;
                if (userRestrictedDescModel != null) {
                    iArr = null;
                    if (userRestrictedDescModel.isExist("photo")) {
                        iArr = new int[]{0};
                    }
                }
                CommonShowBottomWindow.a((FragmentActivity) PrivacyPhotoAlbumFragment.this.b, stringArray, iArr, "#8F8F91", new ActionSheet.ActionSheetListener() { // from class: com.soft.blued.ui.setting.fragment.PrivacyPhotoAlbumFragment.PhotoAlbumGirdAdapter.4.2
                    @Override // com.blued.android.module.common.widget.menu.ActionSheet.ActionSheetListener
                    public void a(ActionSheet actionSheet, int i) {
                        if (i == 0) {
                            PermissionUtils.f(new PermissionCallbacks() { // from class: com.soft.blued.ui.setting.fragment.PrivacyPhotoAlbumFragment.PhotoAlbumGirdAdapter.4.2.1
                                @Override // com.blued.android.framework.permission.PermissionCallbacks
                                public void U_() {
                                    PhotoSelectFragment.a(PrivacyPhotoAlbumFragment.this, 2, 22);
                                }

                                @Override // com.blued.android.framework.permission.PermissionCallbacks
                                public void a(String[] strArr) {
                                }
                            });
                        } else if (i != 1) {
                            if (i != 2) {
                                return;
                            }
                            CommonAlertDialog.a(PrivacyPhotoAlbumFragment.this.b, "", PrivacyPhotoAlbumFragment.this.getResources().getString(R.string.privacy_photo_album_delete_content), PrivacyPhotoAlbumFragment.this.getResources().getString(R.string.privacy_photo_album_delete_ok), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.setting.fragment.PrivacyPhotoAlbumFragment.PhotoAlbumGirdAdapter.4.2.2
                                @Override // android.content.DialogInterface.OnClickListener
                                public void onClick(DialogInterface dialogInterface, int i2) {
                                    Tracker.onClick(dialogInterface, i2);
                                    PrivacyPhotoAlbumFragment.this.f33536c.a(AnonymousClass4.this.f33559a.getPid());
                                }
                            }, PrivacyPhotoAlbumFragment.this.getResources().getString(R.string.privacy_photo_album_delete_cancel), (DialogInterface.OnClickListener) null, (DialogInterface.OnDismissListener) null);
                        } else {
                            ArrayList arrayList = new ArrayList();
                            for (BluedAlbum bluedAlbum : PrivacyPhotoAlbumFragment.this.q) {
                                if (bluedAlbum.getPid() != null && StringUtils.d(bluedAlbum.key)) {
                                    arrayList.add(bluedAlbum);
                                }
                            }
                            String[] strArr = new String[arrayList.size()];
                            String[] strArr2 = new String[arrayList.size()];
                            int i2 = 0;
                            while (true) {
                                int i3 = i2;
                                if (i3 >= arrayList.size()) {
                                    BasePhotoFragment.a(PrivacyPhotoAlbumFragment.this.b, strArr, strArr2, AnonymousClass4.this.b, 3, UserInfo.getInstance().getLoginUserInfo().getName(), PhotoAlbumGirdAdapter.this.h);
                                    return;
                                }
                                strArr[i3] = ((BluedAlbum) arrayList.get(i3)).getUrl();
                                strArr2[i3] = ((BluedAlbum) arrayList.get(i3)).getPid();
                                i2 = i3 + 1;
                            }
                        }
                    }

                    @Override // com.blued.android.module.common.widget.menu.ActionSheet.ActionSheetListener
                    public void a(ActionSheet actionSheet, boolean z) {
                    }
                });
            }
        }

        public PhotoAlbumGirdAdapter(Context context) {
            this.b = LayoutInflater.from(context);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return PrivacyPhotoAlbumFragment.this.q.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return Integer.valueOf(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(final int i, View view, ViewGroup viewGroup) {
            View inflate = this.b.inflate(R.layout.fragment_modify_grid_item, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R.id.tv_shadow);
            this.d = textView;
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) textView.getLayoutParams();
            layoutParams.height = PrivacyPhotoAlbumFragment.this.s;
            this.d.setLayoutParams(layoutParams);
            this.e = (TextView) inflate.findViewById(2131372318);
            ImageView imageView = (ImageView) inflate.findViewById(2131364232);
            this.f33549c = imageView;
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) imageView.getLayoutParams();
            layoutParams2.height = PrivacyPhotoAlbumFragment.this.s;
            this.d.setLayoutParams(layoutParams2);
            final BluedAlbum bluedAlbum = (BluedAlbum) PrivacyPhotoAlbumFragment.this.q.get(i);
            if (StringUtils.d(bluedAlbum.progress)) {
                this.e.setVisibility(8);
                this.d.setVisibility(8);
            } else {
                this.d.setVisibility(0);
                this.e.setVisibility(0);
                this.e.setText(bluedAlbum.progress);
            }
            this.f = (TextView) inflate.findViewById(R.id.tv_under_review);
            if (bluedAlbum.audit_status == 1) {
                this.f.setVisibility(0);
            } else {
                this.f.setVisibility(8);
            }
            LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.ll_lock_view);
            if (PrivacyPhotoAlbumFragment.this.z && i > 5) {
                linearLayout.setVisibility(0);
                this.d.setVisibility(0);
            }
            linearLayout.setOnClickListener(new AnonymousClass1(bluedAlbum, i));
            if (TextUtils.isEmpty(bluedAlbum.getUrl())) {
                this.f33549c.setImageResource(2131232686);
            } else {
                ImageLoader.a(PrivacyPhotoAlbumFragment.this.getFragmentActive(), bluedAlbum.getUrl()).b(2131232686).a(6.0f).a(this.f33549c);
            }
            this.d.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.setting.fragment.PrivacyPhotoAlbumFragment.PhotoAlbumGirdAdapter.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    Tracker.onClick(view2);
                    if (bluedAlbum.progress.equals(PrivacyPhotoAlbumFragment.this.getResources().getString(R.string.failure))) {
                        PrivacyPhotoAlbumFragment.this.t = bluedAlbum;
                        PrivacyPhotoAlbumFragment.this.t.position = i;
                        PhotoSelectFragment.a(PrivacyPhotoAlbumFragment.this, 2, 22);
                    }
                }
            });
            this.e.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.setting.fragment.PrivacyPhotoAlbumFragment.PhotoAlbumGirdAdapter.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    Tracker.onClick(view2);
                    if (bluedAlbum.progress.equals(PrivacyPhotoAlbumFragment.this.getResources().getString(R.string.failure))) {
                        PrivacyPhotoAlbumFragment.this.t = bluedAlbum;
                        PrivacyPhotoAlbumFragment.this.t.position = i;
                        PhotoSelectFragment.a(PrivacyPhotoAlbumFragment.this, 2, 22);
                    }
                }
            });
            this.f33549c.setOnClickListener(new AnonymousClass4(bluedAlbum, i));
            if (i == this.g) {
                inflate.setVisibility(4);
            }
            return inflate;
        }
    }

    static /* synthetic */ int a(PrivacyPhotoAlbumFragment privacyPhotoAlbumFragment, int i) {
        int i2 = privacyPhotoAlbumFragment.u + i;
        privacyPhotoAlbumFragment.u = i2;
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, BluedAlbum bluedAlbum, String str2) {
        QiniuUploadUtils.a(str, bluedAlbum, new AnonymousClass5(str, str2));
    }

    private void a(final String str, final String str2, final int i) {
        LoginRegisterHttpUtils.a(this.b, new BluedUIHttpResponse<BluedEntityA<BluedAlbum>>(getFragmentActive()) { // from class: com.soft.blued.ui.setting.fragment.PrivacyPhotoAlbumFragment.4
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<BluedAlbum> bluedEntityA) {
                if (bluedEntityA.data == null || bluedEntityA.data.size() <= 0) {
                    return;
                }
                BluedAlbum bluedAlbum = bluedEntityA.data.get(0);
                ((BluedAlbum) PrivacyPhotoAlbumFragment.this.q.get(i)).key = bluedAlbum.key;
                PrivacyPhotoAlbumFragment.this.a(str, bluedAlbum, str2);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i2, String str3) {
                PrivacyPhotoAlbumFragment.this.A = true;
                return super.onUIFailure(i2, str3);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                super.onUIFinish();
                if (PrivacyPhotoAlbumFragment.this.A) {
                    ((BluedAlbum) PrivacyPhotoAlbumFragment.this.q.get(i)).setProgress(PrivacyPhotoAlbumFragment.this.getResources().getString(R.string.failure));
                    PrivacyPhotoAlbumFragment.this.r.notifyDataSetChanged();
                }
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
                super.onUIStart();
                PrivacyPhotoAlbumFragment.this.A = false;
                ((BluedAlbum) PrivacyPhotoAlbumFragment.this.q.get(i)).setProgress("0%");
                ((BluedAlbum) PrivacyPhotoAlbumFragment.this.q.get(i)).setUrl(RecyclingUtils.Scheme.FILE.b(str));
                PrivacyPhotoAlbumFragment.this.r.notifyDataSetChanged();
            }
        }, getFragmentActive());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final String str, String str2, String str3, final String str4) {
        ProfileHttpUtils.a(this.b, new BluedUIHttpResponse<BluedEntityA<BluedAlbum>>(getFragmentActive()) { // from class: com.soft.blued.ui.setting.fragment.PrivacyPhotoAlbumFragment.6
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<BluedAlbum> bluedEntityA) {
                BluedAlbum bluedAlbum;
                int b = PrivacyPhotoAlbumFragment.this.b(str4);
                ((BluedAlbum) PrivacyPhotoAlbumFragment.this.q.get(b)).setProgress("100%");
                PrivacyPhotoAlbumFragment.this.r.notifyDataSetChanged();
                if (bluedEntityA.data != null && bluedEntityA.data.size() > 0) {
                    BluedAlbum bluedAlbum2 = bluedEntityA.data.get(0);
                    ((BluedAlbum) PrivacyPhotoAlbumFragment.this.q.get(b)).setPid(bluedAlbum2.getPid());
                    ((BluedAlbum) PrivacyPhotoAlbumFragment.this.q.get(b)).setProgress("");
                    ((BluedAlbum) PrivacyPhotoAlbumFragment.this.q.get(b)).audit_status = bluedAlbum2.audit_status;
                    PrivacyPhotoAlbumFragment.this.r.notifyDataSetChanged();
                    List<BluedAlbum> album = UserInfo.getInstance().getLoginUserInfo().getAlbum();
                    if (album.size() > b) {
                        bluedAlbum = album.get(b);
                    } else {
                        bluedAlbum = new BluedAlbum();
                        album.add(bluedAlbum);
                    }
                    bluedAlbum.setUrl(RecyclingUtils.Scheme.FILE.b(str));
                    bluedAlbum.setPid(bluedAlbum2.getPid());
                    bluedAlbum.audit_status = bluedAlbum2.audit_status;
                    for (BluedAlbum bluedAlbum3 : album) {
                        Log.v("drb", "onUIUpdate bluedAlbum pid:" + bluedAlbum3.getPid() + " -- " + bluedAlbum3.audit_status);
                    }
                }
                AppMethods.d((int) R.string.new_pics);
                UserHttpUtils.a(PrivacyPhotoAlbumFragment.this.b, PrivacyPhotoAlbumFragment.this.f33535a, UserInfo.getInstance().getLoginUserInfo().getName(), PrivacyPhotoAlbumFragment.this.getFragmentActive());
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String str5) {
                PrivacyPhotoAlbumFragment.this.B = true;
                return super.onUIFailure(i, str5);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                super.onUIFinish();
                if (PrivacyPhotoAlbumFragment.this.B) {
                    ((BluedAlbum) PrivacyPhotoAlbumFragment.this.q.get(PrivacyPhotoAlbumFragment.this.b(str4))).setProgress(PrivacyPhotoAlbumFragment.this.getResources().getString(R.string.failure));
                    PrivacyPhotoAlbumFragment.this.r.notifyDataSetChanged();
                }
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
                super.onUIStart();
                PrivacyPhotoAlbumFragment.this.B = false;
            }
        }, str2, str3, getFragmentActive());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int b(String str) {
        if (StringUtils.d(str)) {
            return 0;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.q.size()) {
                return 0;
            }
            if (str.equals(this.q.get(i2).key)) {
                return i2;
            }
            i = i2 + 1;
        }
    }

    private void g() {
        CommonTopTitleNoTrans commonTopTitleNoTrans = (CommonTopTitleNoTrans) this.e.findViewById(2131370749);
        this.f = commonTopTitleNoTrans;
        commonTopTitleNoTrans.a();
        this.f.setCenterText(getString(R.string.private_album));
        this.f.setLeftClickListener(this);
        View inflate = this.d.inflate(R.layout.header_privacy_photo_album, (ViewGroup) null);
        this.h = inflate;
        this.n = (ToggleButton) inflate.findViewById(R.id.tb_album_onoff);
        if (BluedPreferences.bo()) {
            this.n.setChecked(true);
        } else {
            this.n.setChecked(false);
        }
        this.k = (TextView) this.h.findViewById(R.id.tv_sticker);
        RenrenPullToRefreshListView renrenPullToRefreshListView = (RenrenPullToRefreshListView) this.e.findViewById(R.id.rprlv_authed_users_list);
        this.j = renrenPullToRefreshListView;
        renrenPullToRefreshListView.setRefreshEnabled(false);
        ListView listView = (ListView) this.j.getRefreshableView();
        this.i = listView;
        listView.addHeaderView(this.h);
        this.l = (TextView) this.e.findViewById(R.id.tv_cover_transparent);
        if (this.n.isChecked()) {
            this.l.setVisibility(0);
            this.k.setTextColor(Color.parseColor("#80adafb0"));
        } else {
            this.l.setVisibility(8);
            this.k.setTextColor(BluedSkinUtils.a(this.b, 2131101291));
        }
        this.m = (TextView) this.e.findViewById(R.id.tv_bottom_button);
        this.g = DialogUtils.a(this.b);
        this.x = new ArrayList();
        PrivacyPhotoAlbumAuthedUsersItemAdapter privacyPhotoAlbumAuthedUsersItemAdapter = new PrivacyPhotoAlbumAuthedUsersItemAdapter(this.b, getFragmentActive(), this.x);
        this.w = privacyPhotoAlbumAuthedUsersItemAdapter;
        this.i.setAdapter((ListAdapter) privacyPhotoAlbumAuthedUsersItemAdapter);
        RelativeLayout relativeLayout = (RelativeLayout) this.e.findViewById(R.id.rl_dilatation);
        this.o = relativeLayout;
        relativeLayout.setOnClickListener(this);
    }

    private void h() {
        this.s = (this.b.getResources().getDisplayMetrics().widthPixels - DensityUtils.a(this.b, 66.0f)) / 3;
        this.p = (PhotoGridView) this.e.findViewById(2131364131);
        PhotoAlbumGirdAdapter photoAlbumGirdAdapter = new PhotoAlbumGirdAdapter(this.b);
        this.r = photoAlbumGirdAdapter;
        this.p.setAdapter((ListAdapter) photoAlbumGirdAdapter);
        this.p.setColumnWidth(this.s);
    }

    private void i() {
        this.f33536c.a(this.u, 30);
    }

    private void j() {
        this.w.a(new PrivacyPhotoAlbumAuthedUsersItemAdapter.OnDeleteClickListener() { // from class: com.soft.blued.ui.setting.fragment.PrivacyPhotoAlbumFragment.1
            @Override // com.soft.blued.ui.setting.adapter.PrivacyPhotoAlbumAuthedUsersItemAdapter.OnDeleteClickListener
            public void a(String str, int i) {
                PrivacyPhotoAlbumFragment.this.f33536c.a(str, i);
            }
        });
        this.j.setOnPullDownListener(new MyPullDownListener());
        this.f.setLeftClickListener(this);
        this.n.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.soft.blued.ui.setting.fragment.PrivacyPhotoAlbumFragment.2
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                Tracker.onCheckedChanged(compoundButton, z);
                PrivacyPhotoAlbumFragment.this.f33536c.a(z);
                PrivacyPhotoAlbumFragment.this.w.a(z);
                if (!z) {
                    PrivacyPhotoAlbumFragment.this.k.setTextColor(PrivacyPhotoAlbumFragment.this.b.getResources().getColor(2131101291));
                    PrivacyPhotoAlbumFragment.this.l.setVisibility(8);
                    return;
                }
                if (PrivacyPhotoAlbumFragment.this.m.getVisibility() == 0) {
                    PrivacyPhotoAlbumFragment.this.l.setVisibility(0);
                } else {
                    PrivacyPhotoAlbumFragment.this.l.setVisibility(8);
                }
                PrivacyPhotoAlbumFragment.this.k.setTextColor(Color.parseColor("#80adafb0"));
            }
        });
        this.m.setOnClickListener(this);
        this.l.setOnClickListener(this);
    }

    @Override // com.soft.blued.ui.setting.Contract.PrivacyPhotoAlbumContract.IView
    public void a() {
        this.w.a();
        this.m.setVisibility(8);
        this.k.setText(R.string.privacy_photo_album_no_authed);
    }

    @Override // com.soft.blued.ui.setting.Contract.PrivacyPhotoAlbumContract.IView
    public void a(int i) {
        List<UserFindResult> list = this.x;
        if (list != null && list.size() == 1) {
            this.m.setVisibility(8);
            this.k.setText(R.string.privacy_photo_album_no_authed);
        }
        this.w.a(i);
    }

    @Override // com.soft.blued.ui.setting.Contract.PrivacyPhotoAlbumContract.IView
    public void a(String str) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.q.size()) {
                break;
            } else if (str.equals(this.q.get(i2).getPid())) {
                this.q.remove(i2);
                BluedAlbum bluedAlbum = new BluedAlbum();
                if (UserInfo.getInstance().getLoginUserInfo().vip_grade == 0 && i2 > 5) {
                    this.z = true;
                }
                this.q.add(bluedAlbum);
                this.r.notifyDataSetChanged();
            } else {
                i = i2 + 1;
            }
        }
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= this.q.size()) {
                break;
            }
            if (this.q.get(i4).getUrl() != null) {
                arrayList.add(this.q.get(i4));
            }
            i3 = i4 + 1;
        }
        if (arrayList.size() == 6 && UserInfo.getInstance().getLoginUserInfo().vip_grade == 0) {
            this.q.clear();
            this.q.addAll(arrayList);
            this.o.setVisibility(0);
        }
    }

    @Override // com.soft.blued.ui.setting.Contract.PrivacyPhotoAlbumContract.IView
    public void a(List<UserFindResult> list) {
        if (this.f33536c.c()) {
            this.j.o();
        } else {
            this.j.p();
        }
        if (list == null || list.size() == 0) {
            this.k.setText(R.string.privacy_photo_album_no_authed);
            this.m.setVisibility(8);
            this.l.setVisibility(8);
        }
        if (list == null || list.size() <= 0) {
            return;
        }
        this.m.setVisibility(0);
        if (this.n.isChecked()) {
            this.w.a(true);
            this.l.setVisibility(0);
        } else {
            this.w.a(false);
            this.l.setVisibility(8);
        }
        this.w.a(list);
    }

    @Override // com.soft.blued.ui.setting.Contract.PrivacyPhotoAlbumContract.IView
    public void b() {
        this.j.q();
    }

    @Override // com.soft.blued.ui.setting.Contract.PrivacyPhotoAlbumContract.IView
    public void c() {
        DialogUtils.b(this.g);
    }

    @Override // com.soft.blued.ui.setting.Contract.PrivacyPhotoAlbumContract.IView
    public void d() {
        DialogUtils.a(this.g);
    }

    public void e() {
        int i;
        LinkedList album = UserInfo.getInstance().getLoginUserInfo().getAlbum();
        if (album != null) {
            i = album.size();
        } else {
            album = new LinkedList();
            i = 0;
        }
        this.q = new LinkedList();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= i) {
                break;
            }
            BluedAlbum bluedAlbum = new BluedAlbum();
            bluedAlbum.setPid(album.get(i3).getPid());
            bluedAlbum.setUrl(album.get(i3).getUrl());
            bluedAlbum.id = album.get(i3).id;
            bluedAlbum.key = album.get(i3).key;
            bluedAlbum.audit_status = album.get(i3).audit_status;
            this.q.add(bluedAlbum);
            i2 = i3 + 1;
        }
        BluedLoginResult loginUserInfo = UserInfo.getInstance().getLoginUserInfo();
        if (loginUserInfo.vip_grade == 0) {
            if (this.q.size() > 6) {
                int i4 = i;
                while (true) {
                    int i5 = i4;
                    if (i5 >= 12) {
                        break;
                    }
                    this.q.add(new BluedAlbum());
                    this.z = true;
                    i4 = i5 + 1;
                }
                if (i == 12) {
                    int i6 = 6;
                    while (true) {
                        int i7 = i6;
                        if (i7 >= 12) {
                            break;
                        }
                        this.z = true;
                        i6 = i7 + 1;
                    }
                }
                this.o.setVisibility(8);
                EventTrackVIP.a(VipProtos.Event.VIP_PRIVACY_PHOTO_LOCKED_SHOW);
            } else {
                for (int i8 = i; i8 < 6; i8++) {
                    this.q.add(new BluedAlbum());
                }
                this.o.setVisibility(0);
            }
        } else if (loginUserInfo.vip_grade != 0) {
            this.o.setVisibility(8);
            while (i < 12) {
                this.q.add(new BluedAlbum());
                i++;
            }
        }
        for (BluedAlbum bluedAlbum2 : album) {
            Log.v("drb", "initPhotoData bluedAlbum pid:" + bluedAlbum2.getPid() + " -- " + bluedAlbum2.audit_status);
        }
    }

    public void f() {
        Context context = this.b;
        CommonAlertDialog.a(context, "", context.getResources().getString(R.string.message_clean_all_dialog), this.b.getResources().getString(2131887320), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.setting.fragment.PrivacyPhotoAlbumFragment.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Tracker.onClick(dialogInterface, i);
                PrivacyPhotoAlbumFragment.this.f33536c.b();
            }
        }, this.b.getResources().getString(2131886885), (DialogInterface.OnClickListener) null, (DialogInterface.OnDismissListener) null);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1 && i == 22 && intent != null) {
            String stringExtra = intent.getStringExtra("photo_path");
            if (this.t != null && !StringUtils.d(stringExtra)) {
                a(stringExtra, this.t.getPid(), this.t.position);
            }
        }
        super.onActivityResult(i, i2, intent);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        int id = view.getId();
        if (id == 2131363120) {
            getActivity().finish();
        } else if (id == 2131369271) {
            EventTrackVIP.a(VipProtos.Event.VIP_PRIVACY_PHOTO_EXPAND_CLICK);
            PayUtils.a(this.b, 0, "privacy_photo_expand", 25, VipProtos.FromType.PRIVACY_PHOTO_EXPAND);
        } else if (id != 2131371009) {
        } else {
            f();
        }
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view = this.e;
        if (view == null) {
            this.e = layoutInflater.inflate(R.layout.fragment_privacy_photo_album, viewGroup, false);
            FragmentActivity activity = getActivity();
            this.b = activity;
            this.d = LayoutInflater.from(activity);
            this.f33536c = new PrivacyPhotoAlbumPresenter(this.b, this, getFragmentActive());
            g();
            h();
            i();
        } else if (view.getParent() != null) {
            ((ViewGroup) this.e.getParent()).removeView(this.e);
        }
        return this.e;
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.y = true;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.q.size()) {
                return;
            }
            int i3 = i2;
            if (!StringUtils.d(this.q.get(i2).progress)) {
                this.q.remove(i2);
                i3 = i2 - 1;
            }
            i = i3 + 1;
        }
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        e();
        PhotoAlbumGirdAdapter photoAlbumGirdAdapter = this.r;
        if (photoAlbumGirdAdapter != null) {
            photoAlbumGirdAdapter.notifyDataSetChanged();
        }
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        j();
        this.f33536c.ar_();
    }
}
