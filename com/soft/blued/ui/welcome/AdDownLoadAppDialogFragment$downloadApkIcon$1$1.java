package com.soft.blued.ui.welcome;

import android.graphics.drawable.Drawable;
import android.util.Log;
import com.blued.android.module.common.login.model.BluedADExtra;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.constant.EventBusConstant;
import com.soft.blued.ui.welcome.helper.DownLoadADApkHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/welcome/AdDownLoadAppDialogFragment$downloadApkIcon$1$1.class */
public final class AdDownLoadAppDialogFragment$downloadApkIcon$1$1 extends CustomTarget<Drawable> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AdDownLoadAppDialogFragment f20816a;
    final /* synthetic */ BluedADExtra.DownLoadModel b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AdDownLoadAppDialogFragment$downloadApkIcon$1$1(AdDownLoadAppDialogFragment adDownLoadAppDialogFragment, BluedADExtra.DownLoadModel downLoadModel) {
        this.f20816a = adDownLoadAppDialogFragment;
        this.b = downLoadModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(Drawable drawable, BluedADExtra.DownLoadModel downLoadModel, AdDownLoadAppDialogFragment adDownLoadAppDialogFragment) {
        Intrinsics.e(drawable, "$resource");
        Intrinsics.e(downLoadModel, "$this_apply");
        Intrinsics.e(adDownLoadAppDialogFragment, "this$0");
        Log.v("drb", "「开机图下载」app_icon下载完成，开始apk下载");
        DownLoadADApkHelper.f20948a.a(drawable, downLoadModel);
        adDownLoadAppDialogFragment.dismiss();
        LiveEventBus.get(EventBusConstant.KEY_EVENT_SPLASH_AD_SKIP_TO_HOME).post(true);
    }

    @Override // com.bumptech.glide.request.target.Target
    /* renamed from: a */
    public void onResourceReady(final Drawable drawable, Transition<? super Drawable> transition) {
        Intrinsics.e(drawable, "resource");
        final AdDownLoadAppDialogFragment adDownLoadAppDialogFragment = this.f20816a;
        final BluedADExtra.DownLoadModel downLoadModel = this.b;
        adDownLoadAppDialogFragment.a(new Runnable() { // from class: com.soft.blued.ui.welcome.-$$Lambda$AdDownLoadAppDialogFragment$downloadApkIcon$1$1$iOTW9Vh_NyppDNwImhYsELNrf1Q
            @Override // java.lang.Runnable
            public final void run() {
                AdDownLoadAppDialogFragment$downloadApkIcon$1$1.a(Drawable.this, downLoadModel, adDownLoadAppDialogFragment);
            }
        });
    }

    @Override // com.bumptech.glide.request.target.Target
    public void onLoadCleared(Drawable drawable) {
    }
}
