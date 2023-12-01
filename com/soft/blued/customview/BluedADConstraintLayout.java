package com.soft.blued.customview;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.net.Uri;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.fragment.app.FragmentActivity;
import com.blued.android.core.AppInfo;
import com.blued.android.module.common.login.model.BluedADExtra;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.http.FindHttpUtils;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import com.soft.blued.ui.welcome.AdMiniAppDialogFragment;
import com.soft.blued.ui.welcome.BaseADVideoFragment;
import com.soft.blued.utils.AppUtils;
import com.soft.blued.utils.WeChatUtils;
import com.soft.blued.utils.activity.BDActivityManager;
import skin.support.constraint.SkinCompatConstraintLayout;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/BluedADConstraintLayout.class */
public class BluedADConstraintLayout extends SkinCompatConstraintLayout {

    /* renamed from: a  reason: collision with root package name */
    public BluedADExtra f28361a;
    public Context b;

    /* renamed from: c  reason: collision with root package name */
    public final String f28362c;
    private ViewTreeObserver.OnPreDrawListener d;

    public BluedADConstraintLayout(Context context) {
        super(context);
        this.f28362c = getClass().getName();
        a(context);
    }

    public BluedADConstraintLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f28362c = getClass().getName();
        a(context);
    }

    public BluedADConstraintLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f28362c = getClass().getName();
        a(context);
    }

    private void a() {
        post(new Runnable() { // from class: com.soft.blued.customview.-$$Lambda$BluedADConstraintLayout$IxDc7VBPnCrPfNzmmt8qwznxeBQ
            @Override // java.lang.Runnable
            public final void run() {
                BluedADConstraintLayout.this.b();
            }
        });
    }

    private void a(Context context) {
        this.b = context;
        this.d = new ViewTreeObserver.OnPreDrawListener() { // from class: com.soft.blued.customview.-$$Lambda$BluedADConstraintLayout$KNiWQyVLGW_zPtUntKh_gnNUXZ0
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public final boolean onPreDraw() {
                boolean c2;
                c2 = BluedADConstraintLayout.this.c();
                return c2;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View.OnClickListener onClickListener, BluedADExtra bluedADExtra, View view) {
        Tracker.onClick(view);
        FindHttpUtils.b(this.f28361a.click_url);
        if (onClickListener != null) {
            onClickListener.onClick(view);
        } else if (this.f28361a.wx != null && !TextUtils.isEmpty(this.f28361a.wx.id) && !TextUtils.isEmpty(this.f28361a.wx.path)) {
            if (this.f28361a.wx.is_popup != 1) {
                WeChatUtils.a(this.b, this.f28361a.wx.id, this.f28361a.wx.path);
            } else if (BDActivityManager.f34819a.a() != null) {
                Activity a2 = BDActivityManager.f34819a.a();
                if (a2 instanceof FragmentActivity) {
                    AdMiniAppDialogFragment.a(((FragmentActivity) a2).getSupportFragmentManager(), this.f28361a.wx.id, this.f28361a.wx.path, this.f28361a);
                }
            }
        } else if (bluedADExtra.adm_type == 2) {
            BaseADVideoFragment.a(this.b, bluedADExtra, 1);
        } else {
            String str = this.f28361a.target_url;
            if (TextUtils.isEmpty(this.f28361a.deep_link_url)) {
                WebViewShowInfoFragment.show(this.b, str, 9);
                return;
            }
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(this.f28361a.deep_link_url));
            if (AppUtils.a(intent)) {
                this.b.startActivity(intent);
            } else {
                WebViewShowInfoFragment.show(this.b, str, 9);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b() {
        getViewTreeObserver().addOnPreDrawListener(this.d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean c() {
        BluedADExtra bluedADExtra = this.f28361a;
        if (bluedADExtra == null || bluedADExtra.isShowUrlVisited || this.f28361a.show_url == null || this.f28361a.show_url.length == 0 || !a(this)) {
            return true;
        }
        this.f28361a.isShowUrlVisited = true;
        getViewTreeObserver().removeOnPreDrawListener(this.d);
        FindHttpUtils.b(this.f28361a.show_url);
        return true;
    }

    public void a(final BluedADExtra bluedADExtra, final View.OnClickListener onClickListener) {
        if (bluedADExtra == null) {
            setVisibility(8);
            return;
        }
        this.f28361a = bluedADExtra;
        invalidate();
        setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.customview.-$$Lambda$BluedADConstraintLayout$sNuprxUfN_D72mObCI2jL9_nSTE
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BluedADConstraintLayout.this.a(onClickListener, bluedADExtra, view);
            }
        });
        if (this.f28361a != null) {
            if (!a(this) || this.f28361a.isShowUrlVisited) {
                a();
                return;
            }
            this.f28361a.isShowUrlVisited = true;
            FindHttpUtils.b(this.f28361a.show_url);
        }
    }

    public boolean a(View view) {
        if (view == null) {
            return false;
        }
        boolean z = view.hasWindowFocus() && view.getVisibility() == 0 && view.isShown();
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        boolean z2 = false;
        if (z) {
            z2 = false;
            if (iArr[1] <= AppInfo.m) {
                z2 = true;
            }
        }
        return z2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    public void setADData(BluedADExtra bluedADExtra) {
        a(bluedADExtra, null);
    }
}
