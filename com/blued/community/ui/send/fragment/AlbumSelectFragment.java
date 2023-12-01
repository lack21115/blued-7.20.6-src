package com.blued.community.ui.send.fragment;

import android.app.Activity;
import android.app.Application;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.blued.android.core.AppMethods;
import com.blued.android.core.imagecache.RecyclingUtils;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.permission.PermissionCallbacks;
import com.blued.android.framework.pool.ThreadExecutor;
import com.blued.android.framework.pool.ThreadManager;
import com.blued.android.framework.utils.FileUtils;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.framework.view.CustomDialog;
import com.blued.android.module.base.shortvideo.DeleteAutoCheckedListener;
import com.blued.android.module.base.shortvideo.ShortVideoProxy;
import com.blued.android.module.common.utils.ComplianceUtils;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.android.module.common.utils.PermissionUtils;
import com.blued.android.module.common.utils.click.SingleTouchProxy;
import com.blued.android.module.media.selector.fragment.AlbumBaseFragment;
import com.blued.android.module.media.selector.model.AlbumDataManager;
import com.blued.android.module.media.selector.model.AlbumSelectInfo;
import com.blued.android.module.media.selector.present.AlbumBasePresenter;
import com.blued.android.module.player.media.model.MediaInfo;
import com.blued.community.R;
import com.blued.community.auto.CommunityServiceManager;
import com.blued.community.ui.send.dialog.PayVIPPopupWindow;
import com.blued.community.ui.send.observer.FeedRefreshObserver;
import com.blued.community.ui.send.presenter.AlbumSelectPresent;
import com.blued.community.ui.send.view.AlbumTabsView;
import com.blued.community.utils.StorageUtils;
import com.bytedance.applog.tracker.Tracker;

/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/send/fragment/AlbumSelectFragment.class */
public class AlbumSelectFragment extends AlbumBaseFragment implements FeedRefreshObserver.IFeedRefreshObserver, AlbumTabsView.ITabsClickListener {

    /* renamed from: a  reason: collision with root package name */
    protected int f19947a;
    private int d;
    private int e;
    private int f;
    private AlbumSelectPresent g;
    private CustomDialog h;
    private View i;
    private TextView j;
    private TextView k;
    private TextView l;
    private TextView m;
    private Dialog n;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.blued.community.ui.send.fragment.AlbumSelectFragment$3  reason: invalid class name */
    /* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/send/fragment/AlbumSelectFragment$3.class */
    public class AnonymousClass3 implements DeleteAutoCheckedListener {
        AnonymousClass3() {
        }

        @Override // com.blued.android.module.base.shortvideo.DeleteAutoCheckedListener
        public void a(final CheckBox checkBox) {
            checkBox.setOnTouchListener(new SingleTouchProxy(new SingleTouchProxy.TouchListener() { // from class: com.blued.community.ui.send.fragment.AlbumSelectFragment.3.1
                @Override // com.blued.android.module.common.utils.click.SingleTouchProxy.TouchListener
                public boolean a() {
                    if (ComplianceUtils.f10878a.a(checkBox.getContext())) {
                        return true;
                    }
                    if (CommunityServiceManager.a().E() < 1) {
                        PayVIPPopupWindow.f19924c.a(checkBox.getContext(), 1, new DialogInterface.OnDismissListener() { // from class: com.blued.community.ui.send.fragment.AlbumSelectFragment.3.1.1
                            @Override // android.content.DialogInterface.OnDismissListener
                            public void onDismiss(DialogInterface dialogInterface) {
                                CheckBox checkBox2 = checkBox;
                                StringBuilder sb = new StringBuilder();
                                sb.append(AlbumSelectFragment.this.getContext().getString(R.string.msg_look_burn));
                                sb.append(!TextUtils.isEmpty(CommunityServiceManager.a().F()) ? CommunityServiceManager.a().F() : "");
                                checkBox2.setText(sb.toString());
                            }
                        });
                        return true;
                    }
                    return false;
                }
            }));
        }
    }

    private DeleteAutoCheckedListener F() {
        AnonymousClass3 anonymousClass3 = new AnonymousClass3();
        if (this.f19947a == 1) {
            return anonymousClass3;
        }
        return null;
    }

    public static Bundle a(int i, int i2, int i3, int i4) {
        Bundle bundle = new Bundle();
        bundle.putInt("from", i);
        bundle.putInt("page_type", i4);
        bundle.putInt("select_photo_max_num", i3);
        bundle.putInt("album_data_type", i2);
        return bundle;
    }

    private void a(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.layout_common_dialog, viewGroup, false);
        this.i = inflate;
        TextView textView = (TextView) inflate.findViewById(R.id.tv_title);
        this.j = textView;
        textView.setVisibility(8);
        TextView textView2 = (TextView) this.i.findViewById(R.id.tv_cancel);
        this.l = textView2;
        textView2.setText(R.string.cancel);
        TextView textView3 = (TextView) this.i.findViewById(R.id.tv_ok);
        this.k = textView3;
        textView3.setText(R.string.sure);
        TextView textView4 = (TextView) this.i.findViewById(R.id.tv_des);
        this.m = textView4;
        textView4.setText(getString(R.string.selectfile_switch_prompt_title));
    }

    public static void a(Object obj, int i, int i2, int i3, int i4) {
        a(obj, i, i2, i3, 0, i4);
    }

    public static void a(final Object obj, final int i, final int i2, final int i3, final int i4, final int i5) {
        if (obj == null) {
            return;
        }
        Context context = obj instanceof Fragment ? ((Fragment) obj).getContext() : (Context) obj;
        if (Build.VERSION.SDK_INT < 18) {
            AppMethods.d(R.string.low_version_prompt);
        } else if (CommunityServiceManager.a().b(context) || CommunityServiceManager.a().c(context)) {
        } else {
            PermissionUtils.f(new PermissionCallbacks() { // from class: com.blued.community.ui.send.fragment.AlbumSelectFragment.1
                @Override // com.blued.android.framework.permission.PermissionCallbacks
                public void U_() {
                    Bundle a2 = AlbumSelectFragment.a(i, i2, i3, i4);
                    Object obj2 = obj;
                    if (obj2 instanceof Activity) {
                        TerminalActivity.a((Activity) obj2, AlbumSelectFragment.class, a2, i5);
                    } else if (obj2 instanceof Fragment) {
                        TerminalActivity.a((Fragment) obj2, AlbumSelectFragment.class, a2, i5);
                    } else if (obj2 instanceof Application) {
                        TerminalActivity.d((Context) obj2, AlbumSelectFragment.class, a2);
                    }
                }

                @Override // com.blued.android.framework.permission.PermissionCallbacks
                public void a(String[] strArr) {
                }
            });
        }
    }

    @Override // com.blued.community.ui.send.view.AlbumTabsView.ITabsClickListener
    public void C() {
    }

    @Override // com.blued.community.ui.send.view.AlbumTabsView.ITabsClickListener
    public void D() {
        if (((AlbumBasePresenter) this.b).b() > 0) {
            b(1);
        } else if (this.d == 1) {
            c();
        } else {
            ShortVideoProxy.e().a(b(), this.f19947a, 2, 1001);
        }
    }

    @Override // com.blued.community.ui.send.view.AlbumTabsView.ITabsClickListener
    public void E() {
        if (((AlbumBasePresenter) this.b).b() > 0) {
            b(3);
        } else {
            CommunityServiceManager.b().b(b(), 1002, 11);
        }
    }

    protected void a(int i) {
        AlbumPreviewFragment.a(b(), this.f19947a, i, 1);
    }

    @Override // com.blued.community.ui.send.observer.FeedRefreshObserver.IFeedRefreshObserver
    public void a(Object obj, int i) {
        if (i == 3) {
            ShortVideoProxy.e().c();
        }
    }

    @Override // com.blued.android.module.media.selector.fragment.AlbumBaseFragment, com.blued.android.module.media.selector.contract.IAlbumBaseView
    public void a(boolean z, String str) {
        try {
            super.a(z, str);
        } catch (NullPointerException e) {
        }
    }

    @Override // com.blued.android.module.media.selector.contract.IAlbumBaseView
    public boolean a(int i, final MediaInfo mediaInfo) {
        if (mediaInfo != null) {
            if (mediaInfo.media_type != AlbumBasePresenter.k()) {
                a(i);
                return true;
            }
            LogUtils.c("start video copy");
            if (AlbumDataManager.getSelectImageSize() > 0 || mediaInfo == null) {
                return true;
            }
            if (Build.VERSION.SDK_INT >= 29 && !Environment.isExternalStorageLegacy() && !StorageUtils.a(mediaInfo.path)) {
                this.n.show();
                ThreadManager.a().a(new ThreadExecutor("CopyVideo") { // from class: com.blued.community.ui.send.fragment.AlbumSelectFragment.2
                    @Override // com.blued.android.framework.pool.ThreadExecutor
                    public void execute() {
                        LogUtils.c("start video copy thread");
                        String e = RecyclingUtils.e("video");
                        FileUtils.a(mediaInfo.path, e);
                        mediaInfo.path = e;
                        LogUtils.c("finish video copy thread: " + e);
                        AlbumSelectFragment.this.postSafeRunOnUiThread(new Runnable() { // from class: com.blued.community.ui.send.fragment.AlbumSelectFragment.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                LogUtils.c("start showShortVideoTrim");
                                if (AlbumSelectFragment.this.n != null) {
                                    AlbumSelectFragment.this.n.dismiss();
                                }
                                ShortVideoProxy.e().a(AlbumSelectFragment.this.b(), mediaInfo.path, AlbumSelectFragment.this.f19947a, 1000);
                            }
                        });
                    }
                });
                return true;
            }
            ShortVideoProxy e = ShortVideoProxy.e();
            BaseFragment b = b();
            String str = mediaInfo.path;
            int i2 = this.f19947a;
            e.a(b, str, i2, 1000, getContext().getString(R.string.stv_delete_auto_tv) + CommunityServiceManager.a().F(), CommunityServiceManager.a().E(), F());
            return true;
        }
        return true;
    }

    @Override // com.blued.android.module.media.selector.fragment.AlbumBaseFragment, com.blued.android.module.media.selector.contract.IAlbumBaseView
    public boolean a(Activity activity, int i, int i2, Intent intent) {
        if (i2 == -1) {
            if (i != 1) {
                switch (i) {
                    case 1000:
                    case 1001:
                    case 1002:
                        break;
                    default:
                        return false;
                }
            }
            if (intent == null || !intent.getBooleanExtra("close_page", false)) {
                return false;
            }
            getActivity().setResult(-1, intent);
            c();
            return true;
        }
        return false;
    }

    @Override // com.blued.android.module.media.selector.contract.IAlbumBaseView
    public boolean a(AlbumSelectInfo albumSelectInfo) {
        AlbumSelectPresent albumSelectPresent;
        if (albumSelectInfo == null || (albumSelectPresent = this.g) == null) {
            return false;
        }
        albumSelectPresent.a(b(), albumSelectInfo, this.f19947a, 1000);
        return true;
    }

    public void b(final int i) {
        if (this.h == null) {
            CustomDialog customDialog = new CustomDialog(getContext(), R.style.TranslucentBackground);
            this.h = customDialog;
            customDialog.requestWindowFeature(1);
            this.h.getWindow().setFlags(1024, 1024);
            this.h.setContentView(this.i);
            this.h.setCancelable(false);
        }
        CustomDialog customDialog2 = this.h;
        if (customDialog2 != null && customDialog2.isShowing()) {
            this.h.dismiss();
        }
        this.l.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.send.fragment.AlbumSelectFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                AlbumSelectFragment.this.h.dismiss();
            }
        });
        this.k.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.send.fragment.AlbumSelectFragment.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                AlbumSelectFragment.this.h.dismiss();
                if (AlbumSelectFragment.this.b != null) {
                    AlbumBasePresenter.m();
                    AlbumSelectFragment.this.d();
                }
                int i2 = i;
                if (i2 == 1) {
                    AlbumSelectFragment.this.D();
                } else if (i2 != 3) {
                    AlbumSelectFragment.this.c();
                } else {
                    AlbumSelectFragment.this.E();
                }
            }
        });
        this.h.show();
    }

    @Override // com.blued.android.module.media.selector.fragment.AlbumBaseFragment, com.blued.android.module.media.selector.contract.IAlbumBaseView
    public int f() {
        return this.e;
    }

    @Override // com.blued.android.module.media.selector.fragment.AlbumBaseFragment, com.blued.android.module.media.selector.contract.IAlbumBaseView
    public long g() {
        return 2950L;
    }

    @Override // com.blued.android.module.media.selector.fragment.AlbumBaseFragment, com.blued.android.module.media.selector.contract.IAlbumBaseView
    public long h() {
        return this.g.a();
    }

    @Override // com.blued.android.module.media.selector.fragment.AlbumBaseFragment, com.blued.android.module.media.selector.contract.IAlbumBaseView
    public int i() {
        int i = this.f19947a;
        if (i == 1 || i == 7) {
            return 2;
        }
        return this.f;
    }

    @Override // com.blued.android.module.media.selector.fragment.AlbumBaseFragment
    public void j() {
        if (getArguments() == null) {
            return;
        }
        this.f19947a = getArguments().getInt("from");
        this.d = getArguments().getInt("page_type");
        this.e = getArguments().getInt("select_photo_max_num", 9);
        this.f = getArguments().getInt("album_data_type", 3);
    }

    @Override // com.blued.android.module.media.selector.fragment.AlbumBaseFragment
    public int k() {
        return 4;
    }

    @Override // com.blued.android.module.media.selector.fragment.AlbumBaseFragment
    public CharSequence n() {
        String string = getString(R.string.default_maxtime_prompt);
        int indexOf = string.indexOf("^");
        int lastIndexOf = string.lastIndexOf("^");
        int length = string.length();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string.substring(0, indexOf) + string.substring(indexOf + 1, lastIndexOf) + string.substring(lastIndexOf + 1, length));
        spannableStringBuilder.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.nafio_g)), indexOf, lastIndexOf - 1, 33);
        if (this.f19947a == 8) {
            return null;
        }
        return spannableStringBuilder;
    }

    @Override // com.blued.android.module.media.selector.fragment.AlbumBaseFragment
    public int o() {
        return 6;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        u().setTextColor(BluedSkinUtils.a(getContext(), R.color.syc_h));
    }

    @Override // com.blued.android.module.media.selector.fragment.AlbumBaseFragment, com.blued.android.module.media.selector.fragment.MediaBaseFragment, com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        a(viewGroup);
        this.g = new AlbumSelectPresent(getActivity());
        ShortVideoProxy.e().a(getClass().getSimpleName());
        FeedRefreshObserver.a().a(this);
        this.n = DialogUtils.a(getActivity());
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    @Override // com.blued.android.module.media.selector.fragment.AlbumBaseFragment, com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        FeedRefreshObserver.a().b(this);
        ShortVideoProxy.e().b(getClass().getSimpleName());
        super.onDestroyView();
    }

    @Override // com.blued.android.module.media.selector.fragment.AlbumBaseFragment
    public View p() {
        int i = this.f19947a;
        if (i == 8 || i == 4) {
            return null;
        }
        AlbumTabsView albumTabsView = new AlbumTabsView(getContext());
        if (this.f19947a == 1) {
            albumTabsView.a(this, false, 2);
            return albumTabsView;
        }
        albumTabsView.a(this, true, 2);
        return albumTabsView;
    }

    @Override // com.blued.android.module.media.selector.fragment.AlbumBaseFragment
    public Drawable s() {
        return BluedSkinUtils.b(getContext(), R.drawable.live_icon_arrow_down);
    }

    @Override // com.blued.android.module.media.selector.fragment.AlbumBaseFragment
    public Drawable t() {
        return BluedSkinUtils.b(getContext(), R.drawable.live_icon_arrow_up);
    }

    @Override // com.blued.android.module.media.selector.fragment.AlbumBaseFragment
    public int v() {
        return getContext().getResources().getColor(R.color.black);
    }

    @Override // com.blued.android.module.media.selector.fragment.AlbumBaseFragment
    public boolean w() {
        return this.f19947a == 1;
    }
}
