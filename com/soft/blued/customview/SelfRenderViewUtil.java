package com.soft.blued.customview;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.anythink.core.api.ATAdAppInfo;
import com.anythink.nativead.api.ATNativeImageView;
import com.anythink.nativead.api.ATNativeMaterial;
import com.anythink.nativead.api.ATNativePrepareExInfo;
import com.anythink.nativead.api.ATNativePrepareInfo;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.module.common.login.model.BluedADExtra;
import com.bytedance.applog.tracker.Tracker;
import com.qq.e.ads.nativ.MediaView;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import com.qq.e.ads.nativ.widget.NativeAdContainer;
import com.scwang.smartrefresh.layout.util.DensityUtil;
import com.soft.blued.R;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import java.util.ArrayList;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/SelfRenderViewUtil.class */
public class SelfRenderViewUtil {
    public static int a(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static void a(final Context context, final ATAdAppInfo aTAdAppInfo, View view) {
        ViewGroup viewGroup = (ViewGroup) view.findViewById(R.id.cl_information_layout);
        ViewGroup viewGroup2 = (ViewGroup) view.findViewById(R.id.cl_download_layout);
        TextView textView = (TextView) view.findViewById(R.id.tv_publisher);
        TextView textView2 = (TextView) view.findViewById(2131370894);
        TextView textView3 = (TextView) view.findViewById(R.id.tv_permission);
        TextView textView4 = (TextView) view.findViewById(R.id.tv_privacy);
        TextView textView5 = (TextView) view.findViewById(R.id.app_name);
        TextView textView6 = (TextView) view.findViewById(R.id.native_ad_install_btn);
        viewGroup.setVisibility(0);
        viewGroup2.setVisibility(0);
        textView.setText(aTAdAppInfo.getPublisher());
        textView2.setText(aTAdAppInfo.getAppVersion());
        textView5.setText(aTAdAppInfo.getAppName());
        textView3.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.customview.-$$Lambda$SelfRenderViewUtil$oiv8yzEav6kyUquyOj_naq5jN7E
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                SelfRenderViewUtil.c(Context.this, aTAdAppInfo, view2);
            }
        });
        textView4.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.customview.-$$Lambda$SelfRenderViewUtil$EIfK2cNdF5xYvBze6FPys0YcghY
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                SelfRenderViewUtil.b(Context.this, aTAdAppInfo, view2);
            }
        });
    }

    public static void a(Context context, ATNativeMaterial aTNativeMaterial, View view, ATNativePrepareInfo aTNativePrepareInfo, int i) {
        TextView textView = (TextView) view.findViewById(2131368652);
        TextView textView2 = (TextView) view.findViewById(2131371262);
        TextView textView3 = (TextView) view.findViewById(R.id.native_ad_install_btn);
        ImageView imageView = (ImageView) view.findViewById(2131364232);
        ImageView imageView2 = (ImageView) view.findViewById(R.id.img_style_1_ad_icon);
        ImageView imageView3 = (ImageView) view.findViewById(R.id.img_style_2_ad_icon);
        ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.cl_style_1);
        ConstraintLayout constraintLayout2 = (ConstraintLayout) view.findViewById(R.id.cl_style_2);
        FrameLayout frameLayout = (FrameLayout) view.findViewById(2131363785);
        view.findViewById(2131364488);
        ViewGroup viewGroup = (ViewGroup) view.findViewById(R.id.cl_information_layout);
        ViewGroup viewGroup2 = (ViewGroup) view.findViewById(R.id.cl_download_layout);
        if (aTNativePrepareInfo == null) {
            aTNativePrepareInfo = new ATNativePrepareInfo();
        }
        ArrayList arrayList = new ArrayList();
        String title = aTNativeMaterial.getTitle();
        if (TextUtils.isEmpty(title)) {
            textView.setVisibility(8);
        } else {
            textView.setText(title);
            aTNativePrepareInfo.setTitleView(textView);
            arrayList.add(textView);
            textView.setVisibility(0);
        }
        String descriptionText = aTNativeMaterial.getDescriptionText();
        if (TextUtils.isEmpty(descriptionText)) {
            textView2.setVisibility(8);
        } else {
            textView2.setText(descriptionText);
            aTNativePrepareInfo.setDescView(textView2);
            arrayList.add(textView2);
            textView2.setVisibility(0);
        }
        ImageLoader.a((IRequestHost) null, aTNativeMaterial.getIconImageUrl()).b(2131237310).c().a(imageView);
        aTNativePrepareInfo.setIconView(imageView);
        arrayList.add(imageView);
        String callToActionText = aTNativeMaterial.getCallToActionText();
        if (TextUtils.isEmpty(callToActionText)) {
            textView3.setVisibility(8);
        } else {
            textView3.setText(callToActionText);
            aTNativePrepareInfo.setCtaView(textView3);
            arrayList.add(textView3);
            textView3.setVisibility(0);
        }
        View adMediaView = aTNativeMaterial.getAdMediaView(frameLayout);
        int mainImageHeight = aTNativeMaterial.getMainImageHeight();
        int mainImageWidth = aTNativeMaterial.getMainImageWidth();
        int a2 = AppInfo.l - DensityUtil.a(95.0f);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        if (mainImageWidth <= 0 || mainImageHeight <= 0 || mainImageWidth <= mainImageHeight) {
            layoutParams.width = -1;
            layoutParams.height = ((AppInfo.l - DensityUtil.a(95.0f)) / 16) * 9;
        } else {
            layoutParams.width = a2;
            layoutParams.height = (mainImageHeight * a2) / mainImageWidth;
        }
        frameLayout.removeAllViews();
        if (adMediaView != null) {
            if (adMediaView.getParent() != null) {
                ((ViewGroup) adMediaView.getParent()).removeView(adMediaView);
            }
            layoutParams.gravity = 17;
            adMediaView.setLayoutParams(layoutParams);
            frameLayout.addView(adMediaView, layoutParams);
            arrayList.add(adMediaView);
            frameLayout.setVisibility(0);
        } else if (TextUtils.isEmpty(aTNativeMaterial.getMainImageUrl())) {
            frameLayout.removeAllViews();
            frameLayout.setVisibility(8);
        } else {
            ATNativeImageView aTNativeImageView = new ATNativeImageView(context);
            aTNativeImageView.setImage(aTNativeMaterial.getMainImageUrl());
            aTNativeImageView.setLayoutParams(layoutParams);
            frameLayout.addView(aTNativeImageView, layoutParams);
            aTNativePrepareInfo.setMainImageView(aTNativeImageView);
            arrayList.add(aTNativeImageView);
            frameLayout.setVisibility(0);
        }
        if (i == 15) {
            imageView3.setImageResource(2131233931);
        } else if (i == 28) {
            imageView3.setImageResource(2131233453);
        } else if (i == 22) {
            imageView3.setImageResource(2131233022);
        } else if (i == 51) {
            imageView3.setImageResource(R.drawable.icon_klevin_ad_icon);
            ViewGroup.LayoutParams layoutParams2 = textView3.getLayoutParams();
            layoutParams2.width = -1;
            layoutParams2.height = DensityUtil.a(70.0f);
        } else {
            ImageLoader.a((IRequestHost) null, aTNativeMaterial.getAdChoiceIconUrl()).a(imageView3);
        }
        aTNativePrepareInfo.setAdLogoView(imageView3);
        if (i == 8) {
            imageView3.setVisibility(8);
            constraintLayout2.setVisibility(8);
        } else {
            imageView3.setVisibility(0);
            constraintLayout2.setVisibility(0);
        }
        aTNativeMaterial.getAdFrom();
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(a(context, 40.0f), a(context, 10.0f));
        layoutParams3.gravity = 85;
        aTNativePrepareInfo.setChoiceViewLayoutParams(layoutParams3);
        aTNativePrepareInfo.setClickViewList(arrayList);
        if (aTNativePrepareInfo instanceof ATNativePrepareExInfo) {
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(textView3);
            ((ATNativePrepareExInfo) aTNativePrepareInfo).setCreativeClickViewList(arrayList2);
        }
        if (aTNativeMaterial.getNativeAdInteractionType() == 1) {
            a(context, aTNativeMaterial.getAdAppInfo(), view);
        } else {
            viewGroup.setVisibility(8);
            viewGroup2.setVisibility(8);
        }
        ATAdAppInfo adAppInfo = aTNativeMaterial.getAdAppInfo();
        if (adAppInfo != null) {
            Log.v("drb", "当前topon原生广告 atAdAppInfo:" + adAppInfo.toString());
        }
    }

    public static void a(Context context, NativeAdContainer nativeAdContainer, BluedADExtra bluedADExtra) {
        int i;
        TextView textView = (TextView) nativeAdContainer.findViewById(2131368652);
        TextView textView2 = (TextView) nativeAdContainer.findViewById(2131371262);
        TextView textView3 = (TextView) nativeAdContainer.findViewById(R.id.native_ad_install_btn);
        ImageView imageView = (ImageView) nativeAdContainer.findViewById(2131364232);
        ImageView imageView2 = (ImageView) nativeAdContainer.findViewById(R.id.img_style_1_ad_icon);
        ImageView imageView3 = (ImageView) nativeAdContainer.findViewById(R.id.img_style_2_ad_icon);
        ConstraintLayout constraintLayout = (ConstraintLayout) nativeAdContainer.findViewById(R.id.cl_style_1);
        ConstraintLayout constraintLayout2 = (ConstraintLayout) nativeAdContainer.findViewById(R.id.cl_style_2);
        FrameLayout frameLayout = (FrameLayout) nativeAdContainer.findViewById(2131363785);
        MediaView mediaView = (MediaView) nativeAdContainer.findViewById(R.id.media_view);
        ImageView imageView4 = (ImageView) nativeAdContainer.findViewById(R.id.iv_resource);
        nativeAdContainer.findViewById(2131364488);
        LinearLayout linearLayout = (LinearLayout) nativeAdContainer.findViewById(R.id.layout_native_ad);
        ViewGroup viewGroup = (ViewGroup) nativeAdContainer.findViewById(R.id.cl_information_layout);
        ViewGroup viewGroup2 = (ViewGroup) nativeAdContainer.findViewById(R.id.cl_download_layout);
        final NativeUnifiedADData nativeUnifiedADData = bluedADExtra.nativeUnifiedADData;
        textView.setText(nativeUnifiedADData.getTitle());
        textView2.setText(nativeUnifiedADData.getDesc());
        ImageLoader.a((IRequestHost) null, nativeUnifiedADData.getIconUrl()).b(2131237310).c().a(imageView);
        if ("15".equalsIgnoreCase(bluedADExtra.adm_type_source)) {
            constraintLayout2.setVisibility(0);
            imageView3.setVisibility(0);
            imageView3.setImageResource(2131233022);
        } else if ("13".equalsIgnoreCase(bluedADExtra.adm_type_source)) {
            constraintLayout2.setVisibility(0);
            imageView3.setVisibility(0);
            imageView3.setImageResource(2131233453);
        } else if ("4".equalsIgnoreCase(bluedADExtra.adm_type_source)) {
            constraintLayout2.setVisibility(0);
            imageView3.setVisibility(0);
            imageView3.setImageResource(2131233931);
        } else if ("0".equalsIgnoreCase(bluedADExtra.adm_type_source)) {
            if (bluedADExtra.is_show_adm_icon == 1) {
                constraintLayout2.setVisibility(0);
            } else {
                constraintLayout2.setVisibility(8);
            }
            imageView3.setVisibility(8);
        } else if ("3".equalsIgnoreCase(bluedADExtra.adm_type_source)) {
            constraintLayout2.setVisibility(0);
            imageView3.setVisibility(0);
            imageView3.setImageResource(2131233025);
        } else {
            Log.v("adx", "bindSelfRenderAdx 隐藏logo");
            constraintLayout2.setVisibility(8);
            imageView3.setVisibility(8);
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(imageView4);
        ViewGroup.LayoutParams layoutParams = imageView4.getLayoutParams();
        layoutParams.width = -1;
        int a2 = AppInfo.l - DensityUtil.a(95.0f);
        if ("0".equalsIgnoreCase(bluedADExtra.adm_type_source)) {
            i = (int) (a2 / 2.3f);
            Log.v("adx", "直客原生素材高度：" + i);
        } else {
            i = (a2 / 16) * 9;
            Log.v("adx", "第三方原生素材高度：" + i);
        }
        layoutParams.height = i;
        imageView4.setLayoutParams(layoutParams);
        arrayList.add(imageView);
        arrayList.add(textView);
        arrayList.add(textView2);
        arrayList.add(textView3);
        arrayList.add(imageView4);
        arrayList.add(mediaView);
        arrayList.add(linearLayout);
        nativeUnifiedADData.bindAdToView(context, nativeAdContainer, null, arrayList);
        if (nativeUnifiedADData.getAdPatternType() == 2) {
            Log.v("adx", "原生自渲染：视频模式");
            imageView4.setVisibility(8);
            mediaView.setVisibility(0);
            nativeUnifiedADData.bindMediaView(mediaView, null, null);
        } else if (TextUtils.isEmpty(nativeUnifiedADData.getImgUrl())) {
            Log.v("adx", "原生自渲染：资源为空");
            imageView4.setVisibility(8);
            mediaView.setVisibility(8);
        } else {
            Log.v("adx", "原生自渲染：大图模式:" + nativeUnifiedADData.getImgUrl());
            nativeUnifiedADData.bindImageViews(arrayList2, 0);
            imageView4.setVisibility(0);
            mediaView.setVisibility(8);
        }
        if (!TextUtils.isEmpty(nativeUnifiedADData.getCTAText())) {
            textView3.setText(nativeUnifiedADData.getCTAText());
            textView3.setVisibility(0);
        } else if (TextUtils.isEmpty(nativeUnifiedADData.getButtonText())) {
            textView3.setVisibility(8);
        } else {
            textView3.setText(nativeUnifiedADData.getButtonText());
            textView3.setVisibility(0);
        }
        if (nativeUnifiedADData.isAppAd() && nativeUnifiedADData.getAppMiitInfo() != null) {
            a(context, new ATAdAppInfo() { // from class: com.soft.blued.customview.SelfRenderViewUtil.1
                @Override // com.anythink.core.api.ATAdAppInfo
                public String getAppDownloadCount() {
                    return "";
                }

                @Override // com.anythink.core.api.ATAdAppInfo
                public String getAppName() {
                    return NativeUnifiedADData.this.getAppMiitInfo().getAppName();
                }

                @Override // com.anythink.core.api.ATAdAppInfo
                public String getAppPackageName() {
                    return "";
                }

                @Override // com.anythink.core.api.ATAdAppInfo
                public String getAppPermissonUrl() {
                    return NativeUnifiedADData.this.getAppMiitInfo().getPermissionsUrl();
                }

                @Override // com.anythink.core.api.ATAdAppInfo
                public String getAppPrivacyUrl() {
                    return NativeUnifiedADData.this.getAppMiitInfo().getPrivacyAgreement();
                }

                @Override // com.anythink.core.api.ATAdAppInfo
                public long getAppSize() {
                    return NativeUnifiedADData.this.getAppMiitInfo().getPackageSizeBytes();
                }

                @Override // com.anythink.core.api.ATAdAppInfo
                public String getAppVersion() {
                    return NativeUnifiedADData.this.getAppMiitInfo().getVersionName();
                }

                @Override // com.anythink.core.api.ATAdAppInfo
                public String getPublisher() {
                    return NativeUnifiedADData.this.getAppMiitInfo().getAuthorName();
                }
            }, nativeAdContainer);
            return;
        }
        viewGroup.setVisibility(8);
        viewGroup2.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(Context context, ATAdAppInfo aTAdAppInfo, View view) {
        Tracker.onClick(view);
        WebViewShowInfoFragment.show(context, aTAdAppInfo.getAppPrivacyUrl());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void c(Context context, ATAdAppInfo aTAdAppInfo, View view) {
        Tracker.onClick(view);
        WebViewShowInfoFragment.show(context, aTAdAppInfo.getAppPermissonUrl());
    }
}
