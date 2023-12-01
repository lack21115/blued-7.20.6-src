package com.blued.community.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import com.blued.android.core.AppInfo;
import com.blued.android.module.common.login.model.BluedADExtra;
import com.blued.community.auto.CommunityServiceManager;
import com.blued.community.http.CommunityHttpUtils;
import com.blued.community.manager.CommunityConstants;
import com.huawei.openalliance.ad.constant.t;
import skin.support.constraint.SkinCompatConstraintLayout;

/* loaded from: source-7206380-dex2jar.jar:com/blued/community/view/BluedADConstraintLayout.class */
public class BluedADConstraintLayout extends SkinCompatConstraintLayout {
    public final String TAG;
    public BluedADExtra adExtra;
    public Context mContext;
    private ViewTreeObserver.OnPreDrawListener onPreDrawListener;

    public BluedADConstraintLayout(Context context) {
        super(context);
        this.TAG = getClass().getName();
        init(context);
    }

    public BluedADConstraintLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.TAG = getClass().getName();
        init(context);
    }

    public BluedADConstraintLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.TAG = getClass().getName();
        init(context);
    }

    private void addListener() {
        post(new Runnable() { // from class: com.blued.community.view.-$$Lambda$BluedADConstraintLayout$iPS0n-NHbyjGz4wtFgKDG75gzwY
            @Override // java.lang.Runnable
            public final void run() {
                BluedADConstraintLayout.this.lambda$addListener$1$BluedADConstraintLayout();
            }
        });
    }

    private void init(Context context) {
        this.mContext = context;
        this.onPreDrawListener = new ViewTreeObserver.OnPreDrawListener() { // from class: com.blued.community.view.-$$Lambda$BluedADConstraintLayout$MEeGC2kVogcDzaSKgL7WZF-gwe0
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public final boolean onPreDraw() {
                return BluedADConstraintLayout.this.lambda$init$0$BluedADConstraintLayout();
            }
        };
    }

    public boolean isVisible(View view) {
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

    public /* synthetic */ void lambda$addListener$1$BluedADConstraintLayout() {
        getViewTreeObserver().addOnPreDrawListener(this.onPreDrawListener);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ boolean lambda$init$0$BluedADConstraintLayout() {
        BluedADExtra bluedADExtra = this.adExtra;
        if (bluedADExtra == null || bluedADExtra.isShowUrlVisited || this.adExtra.show_url == null || this.adExtra.show_url.length == 0 || !isVisible(this)) {
            return true;
        }
        this.adExtra.isShowUrlVisited = true;
        getViewTreeObserver().removeOnPreDrawListener(this.onPreDrawListener);
        CommunityHttpUtils.a(this.adExtra.show_url);
        Log.v("finalize", "postSplashUrl:" + this.adExtra.show_url);
        if (AppInfo.m()) {
            String str = "";
            for (int i = 0; i < this.adExtra.show_url.length; i++) {
                str = str + this.adExtra.show_url[i] + t.aE;
            }
            return true;
        }
        return true;
    }

    public /* synthetic */ void lambda$setADData$2$BluedADConstraintLayout(View.OnClickListener onClickListener, View view) {
        CommunityHttpUtils.a(this.adExtra.click_url);
        if (onClickListener != null) {
            onClickListener.onClick(view);
            return;
        }
        CommunityServiceManager.b().a(this.mContext, this.adExtra.target_url, CommunityConstants.WebShowType.a);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    public void postClickUrl() {
        CommunityHttpUtils.a(this.adExtra.click_url);
    }

    public void setADData(BluedADExtra bluedADExtra) {
        setADData(bluedADExtra, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setADData(BluedADExtra bluedADExtra, final View.OnClickListener onClickListener) {
        if (bluedADExtra == null) {
            setVisibility(8);
            return;
        }
        this.adExtra = bluedADExtra;
        invalidate();
        setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.view.-$$Lambda$BluedADConstraintLayout$wSkdYHa00BGzK32-BnxYi2qz3KQ
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BluedADConstraintLayout.this.lambda$setADData$2$BluedADConstraintLayout(onClickListener, view);
            }
        });
        if (this.adExtra != null) {
            if (!isVisible(this) || this.adExtra.isShowUrlVisited) {
                addListener();
                return;
            }
            this.adExtra.isShowUrlVisited = true;
            CommunityHttpUtils.a(this.adExtra.show_url);
        }
    }
}
