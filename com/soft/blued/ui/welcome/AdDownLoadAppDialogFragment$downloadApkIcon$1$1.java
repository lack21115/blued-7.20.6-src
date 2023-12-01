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
    final /* synthetic */ AdDownLoadAppDialogFragment f34507a;
    final /* synthetic */ BluedADExtra.DownLoadModel b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AdDownLoadAppDialogFragment$downloadApkIcon$1$1(AdDownLoadAppDialogFragment adDownLoadAppDialogFragment, BluedADExtra.DownLoadModel downLoadModel) {
        this.f34507a = adDownLoadAppDialogFragment;
        this.b = downLoadModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(Drawable resource, BluedADExtra.DownLoadModel this_apply, AdDownLoadAppDialogFragment this$0) {
        Intrinsics.e(resource, "$resource");
        Intrinsics.e(this_apply, "$this_apply");
        Intrinsics.e(this$0, "this$0");
        Log.v("drb", "「开机图下载」app_icon下载完成，开始apk下载");
        DownLoadADApkHelper.f34639a.a(resource, this_apply);
        this$0.dismiss();
        LiveEventBus.get(EventBusConstant.KEY_EVENT_SPLASH_AD_SKIP_TO_HOME).post(true);
    }

    @Override // com.bumptech.glide.request.target.Target
    /* renamed from: a */
    public void onResourceReady(final Drawable resource, Transition<? super Drawable> transition) {
        Intrinsics.e(resource, "resource");
        final AdDownLoadAppDialogFragment adDownLoadAppDialogFragment = this.f34507a;
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
