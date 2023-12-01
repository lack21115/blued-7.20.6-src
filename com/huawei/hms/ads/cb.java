package com.huawei.hms.ads;

import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.anythink.expressad.exoplayer.b;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/cb.class */
public class cb extends cp<com.huawei.openalliance.ad.views.AppDownloadButton> {
    private int L;

    /* renamed from: a  reason: collision with root package name */
    private Typeface f22444a;

    public cb(com.huawei.openalliance.ad.views.AppDownloadButton appDownloadButton) {
        super(appDownloadButton);
        this.L = -1;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.huawei.hms.ads.ci
    public void Code(AttributeSet attributeSet) {
        boolean z;
        boolean z2;
        if (this.Code == 0 || attributeSet == null) {
            return;
        }
        String attributeValue = attributeSet.getAttributeValue(null, "textStyle");
        if (!TextUtils.isEmpty(attributeValue)) {
            switch (attributeValue.hashCode()) {
                case -1178781136:
                    if (attributeValue.equals("italic")) {
                        z2 = true;
                        break;
                    }
                    z2 = true;
                    break;
                case -1039745817:
                    if (attributeValue.equals("normal")) {
                        z2 = true;
                        break;
                    }
                    z2 = true;
                    break;
                case 3029637:
                    if (attributeValue.equals("bold")) {
                        z2 = false;
                        break;
                    }
                    z2 = true;
                    break;
                case 1702544263:
                    if (attributeValue.equals("bold|italic")) {
                        z2 = true;
                        break;
                    }
                    z2 = true;
                    break;
                default:
                    z2 = true;
                    break;
            }
            if (!z2) {
                this.L = 1;
            } else if (z2) {
                this.L = 3;
            } else if (z2) {
                this.L = 2;
            } else if (z2) {
                this.L = 0;
            }
        }
        String attributeValue2 = attributeSet.getAttributeValue(null, "typeface");
        if (!TextUtils.isEmpty(attributeValue2)) {
            switch (attributeValue2.hashCode()) {
                case -1431958525:
                    z = true;
                    if (attributeValue2.equals("monospace")) {
                        z = true;
                        break;
                    }
                    break;
                case -1039745817:
                    z = true;
                    if (attributeValue2.equals("normal")) {
                        z = false;
                        break;
                    }
                    break;
                case 3522707:
                    z = true;
                    if (attributeValue2.equals("sans")) {
                        z = true;
                        break;
                    }
                    break;
                case 109326717:
                    z = true;
                    if (attributeValue2.equals(b.l)) {
                        z = true;
                        break;
                    }
                    break;
                default:
                    z = true;
                    break;
            }
            this.f22444a = z ? !z ? !z ? !z ? Typeface.DEFAULT : Typeface.MONOSPACE : Typeface.SERIF : Typeface.SANS_SERIF : Typeface.DEFAULT_BOLD;
        }
        String attributeValue3 = attributeSet.getAttributeValue(null, "fontFamily");
        if (TextUtils.isEmpty(attributeValue3)) {
            ((com.huawei.openalliance.ad.views.AppDownloadButton) this.Code).Code(this.f22444a, this.L);
        } else {
            ((com.huawei.openalliance.ad.views.AppDownloadButton) this.Code).setPaintTypeface(Typeface.create(attributeValue3, this.L));
        }
    }
}
