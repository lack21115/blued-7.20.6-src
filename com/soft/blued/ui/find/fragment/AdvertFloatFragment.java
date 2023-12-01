package com.soft.blued.ui.find.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import com.blued.ad.ADConstants;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.core.ui.TransparentActivity;
import com.blued.android.module.common.utils.ActivityChangeAnimationUtils;
import com.blued.community.manager.CommunityManager;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.customview.BluedADConstraintLayout;
import com.soft.blued.ui.find.model.AdvertFloatModel;
import com.soft.blued.ui.find.observer.AdFloatObserver;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import com.soft.blued.utils.ADClosePopOptionsUtils;
import com.soft.blued.utils.AppUtils;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/fragment/AdvertFloatFragment.class */
public class AdvertFloatFragment extends BaseFragment {

    /* renamed from: a  reason: collision with root package name */
    private Activity f30186a;
    private View b;

    /* renamed from: c  reason: collision with root package name */
    private View f30187c;
    private ImageView d;
    private AdvertFloatModel e;
    private BluedADConstraintLayout f;
    private ADConstants.AD_POSITION g;

    private void a() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.e = (AdvertFloatModel) arguments.getSerializable("model");
            this.g = (ADConstants.AD_POSITION) arguments.getSerializable("KEY_AD_POSITION");
        }
        if (this.e == null) {
            c();
        }
    }

    public static void a(Context context, AdvertFloatModel advertFloatModel, ADConstants.AD_POSITION ad_position) {
        CommunityManager.f19086a.a().b(true);
        Bundle bundle = new Bundle();
        bundle.putSerializable("model", advertFloatModel);
        bundle.putSerializable("KEY_AD_POSITION", ad_position);
        TerminalActivity.a(bundle);
        TransparentActivity.b(context, AdvertFloatFragment.class, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        Tracker.onClick(view);
        ADClosePopOptionsUtils.a(this.f30186a, this.e, this.f30187c, this.g, new ADClosePopOptionsUtils.ADRemovedListener() { // from class: com.soft.blued.ui.find.fragment.-$$Lambda$AdvertFloatFragment$XP-z07Sym1HGEWcsirLVyULp83E
            @Override // com.soft.blued.utils.ADClosePopOptionsUtils.ADRemovedListener
            public final void onRemoved() {
                AdvertFloatFragment.this.c();
            }
        });
    }

    private void b() {
        if (this.e == null) {
            c();
            return;
        }
        BluedADConstraintLayout bluedADConstraintLayout = (BluedADConstraintLayout) this.b.findViewById(R.id.blued_ad_layout);
        this.f = bluedADConstraintLayout;
        bluedADConstraintLayout.a(this.e, new View.OnClickListener() { // from class: com.soft.blued.ui.find.fragment.-$$Lambda$AdvertFloatFragment$KfZ1GnDkByCVVPpRBA0fBmcLd0U
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AdvertFloatFragment.this.b(view);
            }
        });
        this.f30187c = this.b.findViewById(2131364488);
        this.d = (ImageView) this.b.findViewById(R.id.img_advert);
        ImageLoader.a(getFragmentActive(), this.e.advert_pic).a(this.d);
        this.f30187c.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.find.fragment.-$$Lambda$AdvertFloatFragment$nQbj0YiutdxXk0wIppqVjH6mJsA
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AdvertFloatFragment.this.a(view);
            }
        });
        this.d.postDelayed(new Runnable() { // from class: com.soft.blued.ui.find.fragment.-$$Lambda$AdvertFloatFragment$iAdWOEG1tJ0xRryrkK8cuoBREcg
            @Override // java.lang.Runnable
            public final void run() {
                AdvertFloatFragment.this.d();
            }
        }, 100L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        Tracker.onClick(view);
        WebViewShowInfoFragment.show(this.f30186a, this.e.target_url, 9);
        c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        AdFloatObserver.a().b();
        CommunityManager.f19086a.a().b(false);
        getActivity().finish();
        ActivityChangeAnimationUtils.k(getActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d() {
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.8f, 1.0f, 0.8f, 1.0f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(300L);
        this.d.startAnimation(scaleAnimation);
        this.d.setVisibility(0);
        this.f30187c.setVisibility(0);
    }

    @Override // com.blued.android.core.ui.BaseFragment
    public boolean isActivitySwipeBackEnable() {
        return false;
    }

    @Override // com.blued.android.core.ui.BaseFragment, com.blued.android.core.ui.BaseFragmentActivity.IOnBackPressedListener
    public boolean onBackPressed() {
        this.f30187c.performClick();
        return true;
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        this.f30186a = getActivity();
        ActivityChangeAnimationUtils.h(getActivity());
        a();
        super.onCreate(bundle);
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view = this.b;
        if (view == null) {
            this.b = layoutInflater.inflate(R.layout.fragment_advert, viewGroup, false);
            b();
        } else if (view.getParent() != null) {
            ((ViewGroup) this.b.getParent()).removeView(this.b);
        }
        return this.b;
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        AppUtils.a(this.f);
    }
}
