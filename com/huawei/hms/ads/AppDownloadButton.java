package com.huawei.hms.ads;

import android.content.Context;
import android.util.AttributeSet;
import com.huawei.hms.ads.AppDownloadButtonStyle;
import com.huawei.openalliance.ad.inter.data.AppInfo;
import com.huawei.openalliance.ad.views.AppDownloadButton;
import com.huawei.openalliance.ad.views.a;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/AppDownloadButton.class */
public class AppDownloadButton extends com.huawei.openalliance.ad.views.AppDownloadButton implements IAppDownloadButton, AppDownloadButton.b, AppDownloadButton.c {
    private OnDownloadStatusChangedListener B;
    private OnNonWifiDownloadListener C;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.huawei.hms.ads.AppDownloadButton$1  reason: invalid class name */
    /* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/AppDownloadButton$1.class */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] Code;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x007d -> B:61:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0081 -> B:55:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x0085 -> B:51:0x002a). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x0089 -> B:45:0x0035). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x008d -> B:59:0x0040). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x0091 -> B:53:0x004c). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x0095 -> B:49:0x0058). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x0099 -> B:43:0x0064). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x009d -> B:57:0x0070). Please submit an issue!!! */
        static {
            int[] iArr = new int[com.huawei.openalliance.ad.download.app.k.values().length];
            Code = iArr;
            try {
                iArr[com.huawei.openalliance.ad.download.app.k.WAITING.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                Code[com.huawei.openalliance.ad.download.app.k.DOWNLOADING.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                Code[com.huawei.openalliance.ad.download.app.k.PAUSE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                Code[com.huawei.openalliance.ad.download.app.k.RESUME.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                Code[com.huawei.openalliance.ad.download.app.k.DOWNLOADED.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                Code[com.huawei.openalliance.ad.download.app.k.DOWNLOADFAILED.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                Code[com.huawei.openalliance.ad.download.app.k.INSTALLING.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                Code[com.huawei.openalliance.ad.download.app.k.INSTALL.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                Code[com.huawei.openalliance.ad.download.app.k.INSTALLED.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
            try {
                Code[com.huawei.openalliance.ad.download.app.k.DOWNLOAD.ordinal()] = 10;
            } catch (NoSuchFieldError e10) {
            }
        }
    }

    /* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/AppDownloadButton$OnDownloadStatusChangedListener.class */
    public interface OnDownloadStatusChangedListener {
        void onStatusChanged(AppDownloadStatus appDownloadStatus);
    }

    /* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/AppDownloadButton$OnNonWifiDownloadListener.class */
    public interface OnNonWifiDownloadListener {
        boolean onNonWifiDownload(long j);
    }

    /* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/AppDownloadButton$a.class */
    class a extends com.huawei.openalliance.ad.views.a {
        private AppDownloadButtonStyle B;
        private a.C0272a C;

        public a(Context context, AppDownloadButtonStyle appDownloadButtonStyle) {
            super(context);
            this.C = new a.C0272a();
            this.B = appDownloadButtonStyle;
            Code(this.V, this.B.normalStyle);
            Code(this.I, this.B.processingStyle);
            Code(this.Z, this.B.installingStyle);
        }

        private void Code(a.C0272a c0272a, AppDownloadButtonStyle.Style style) {
            c0272a.Code(style.getBackground());
            c0272a.Code(style.getTextColor());
            c0272a.V(style.getTextSize());
            c0272a.Code(style.getTypeface());
        }

        @Override // com.huawei.openalliance.ad.views.a
        public a.C0272a Code(Context context, com.huawei.openalliance.ad.download.app.k kVar) {
            AppDownloadButtonStyle.Style style = this.B.getStyle(context, AppDownloadButton.this.V(kVar));
            if (style == this.B.processingStyle) {
                return this.I;
            }
            if (style == this.B.installingStyle) {
                return this.Z;
            }
            if (style == this.B.normalStyle) {
                return this.V;
            }
            Code(this.C, style);
            return this.C;
        }
    }

    public AppDownloadButton(Context context) {
        super(context);
    }

    public AppDownloadButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AppDownloadButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public AppDownloadButton(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AppDownloadStatus V(com.huawei.openalliance.ad.download.app.k kVar) {
        if (kVar == null) {
            return AppDownloadStatus.DOWNLOAD;
        }
        switch (AnonymousClass1.Code[kVar.ordinal()]) {
            case 1:
                return AppDownloadStatus.WAITING;
            case 2:
                return AppDownloadStatus.DOWNLOADING;
            case 3:
                return AppDownloadStatus.PAUSE;
            case 4:
                return AppDownloadStatus.RESUME;
            case 5:
                return AppDownloadStatus.DOWNLOADED;
            case 6:
                return AppDownloadStatus.DOWNLOADFAILED;
            case 7:
                return AppDownloadStatus.INSTALLING;
            case 8:
                return AppDownloadStatus.INSTALL;
            case 9:
                return AppDownloadStatus.INSTALLED;
            default:
                return AppDownloadStatus.DOWNLOAD;
        }
    }

    @Override // com.huawei.openalliance.ad.views.AppDownloadButton.b
    public void Code(com.huawei.openalliance.ad.download.app.k kVar) {
        OnDownloadStatusChangedListener onDownloadStatusChangedListener = this.B;
        if (onDownloadStatusChangedListener != null) {
            onDownloadStatusChangedListener.onStatusChanged(V(kVar));
        }
    }

    @Override // com.huawei.openalliance.ad.views.AppDownloadButton.c
    public boolean Code(AppInfo appInfo, long j) {
        OnNonWifiDownloadListener onNonWifiDownloadListener = this.C;
        if (onNonWifiDownloadListener != null) {
            return onNonWifiDownloadListener.onNonWifiDownload(j);
        }
        return false;
    }

    @Override // com.huawei.openalliance.ad.views.AppDownloadButton, com.huawei.hms.ads.kz, com.huawei.hms.ads.IAppDownloadButton
    public void cancel() {
        super.cancel();
    }

    @Override // com.huawei.openalliance.ad.views.AppDownloadButton, com.huawei.hms.ads.IAppDownloadButton
    public void continueDownload() {
        super.continueDownload();
    }

    @Override // com.huawei.hms.ads.IAppDownloadButton
    public AppDownloadStatus refreshAppStatus() {
        return V(super.Code());
    }

    @Override // com.huawei.openalliance.ad.views.AppDownloadButton, com.huawei.hms.ads.IAppDownloadButton
    public void setAllowedNonWifiNetwork(boolean z) {
        super.setAllowedNonWifiNetwork(z);
    }

    @Override // com.huawei.hms.ads.IAppDownloadButton
    public void setAppDownloadButtonStyle(AppDownloadButtonStyle appDownloadButtonStyle) {
        if (appDownloadButtonStyle != null) {
            super.setAppDownloadButtonStyle(new a(getContext(), appDownloadButtonStyle));
        }
    }

    @Override // com.huawei.hms.ads.IAppDownloadButton
    public void setOnDownloadStatusChangedListener(OnDownloadStatusChangedListener onDownloadStatusChangedListener) {
        if (onDownloadStatusChangedListener != null) {
            this.B = onDownloadStatusChangedListener;
            super.setOnDownloadStatusChangedListener(this);
        }
    }

    @Override // com.huawei.hms.ads.IAppDownloadButton
    public void setOnNonWifiDownloadListener(OnNonWifiDownloadListener onNonWifiDownloadListener) {
        if (onNonWifiDownloadListener != null) {
            this.C = onNonWifiDownloadListener;
            super.setOnNonWifiDownloadListener(this);
        }
    }

    @Override // com.huawei.openalliance.ad.views.AppDownloadButton, com.huawei.hms.ads.IAppDownloadButton
    public void setShowPermissionDialog(boolean z) {
        super.setShowPermissionDialog(z);
    }
}
