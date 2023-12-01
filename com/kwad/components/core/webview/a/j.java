package com.kwad.components.core.webview.a;

import android.text.TextUtils;
import com.kwad.sdk.core.report.KSLoggerReporter;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwai.adclient.kscommerciallogger.model.BusinessType;
import java.util.Iterator;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/webview/a/j.class */
public final class j {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static String b(String str, AdTemplate adTemplate) {
        boolean z;
        AdMatrixInfo.BaseMatrixTemplate baseMatrixTemplate;
        String str2;
        AdMatrixInfo.AdDataV2 adDataV2 = com.kwad.sdk.core.response.a.b.aJ(adTemplate).adDataV2;
        switch (str.hashCode()) {
            case -1777431161:
                if (str.equals("ksad-video-top-bar")) {
                    z = false;
                    break;
                }
                z = true;
                break;
            case -1589174862:
                if (str.equals("ksad-fullscreen-video-card")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case -1545218748:
                if (str.equals("ksad-video-task-card")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case -259656373:
                if (str.equals("ksad-video-bottom-card-v2")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case -206391259:
                if (str.equals("ksad-splash-play-card")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 44717817:
                if (str.equals("ksad-neo-video-card")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 144881219:
                if (str.equals("ksad-pre-landingpage-card")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 625896230:
                if (str.equals("ksad-splash-end-card")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 787160939:
                if (str.equals("ksad-video-topfloor")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 1188774735:
                if (str.equals("ksad-interstitial-card")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 1339306036:
                if (str.equals("ksad-video-middle-card")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 1619320353:
                if (str.equals("ksad-push-card")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 1649519421:
                if (str.equals("ksad-video-secondclick-card")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 1651568242:
                if (str.equals("ksad-video-web-close-card")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 1866270907:
                if (str.equals("ksad-video-playend-dialog-card")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 1892692881:
                if (str.equals("ksad-video-confirm-card")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 2001659187:
                if (str.equals("ksad-video-interact-card")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            default:
                z = true;
                break;
        }
        switch (z) {
            case false:
                baseMatrixTemplate = adDataV2.topBarTKInfo;
                str2 = baseMatrixTemplate.templateId;
                break;
            case true:
                baseMatrixTemplate = adDataV2.middleTKCardInfo;
                str2 = baseMatrixTemplate.templateId;
                break;
            case true:
                baseMatrixTemplate = adDataV2.actionBarTKInfo;
                str2 = baseMatrixTemplate.templateId;
                break;
            case true:
                baseMatrixTemplate = adDataV2.confirmTKInfo;
                str2 = baseMatrixTemplate.templateId;
                break;
            case true:
                baseMatrixTemplate = adDataV2.playendTKInfo;
                str2 = baseMatrixTemplate.templateId;
                break;
            case true:
                baseMatrixTemplate = adDataV2.activityTKInfo;
                str2 = baseMatrixTemplate.templateId;
                break;
            case true:
                str2 = adDataV2.interstitialCardInfo.templateId;
                break;
            case true:
                str2 = adDataV2.rewardVideoInteractInfo.templateId;
                break;
            case true:
                str2 = adDataV2.rewardVideoTaskInfo.templateId;
                break;
            case true:
                str2 = adDataV2.mRewardWebTaskCloseInfo.templateId;
                break;
            case true:
                str2 = adDataV2.fullScreenInfo.templateId;
                break;
            case true:
                str2 = adDataV2.splashPlayCardTKInfo.templateId;
                break;
            case true:
                str2 = adDataV2.splashEndCardTKInfo.templateId;
                break;
            case true:
                str2 = adDataV2.topFloorTKInfo.templateId;
                break;
            case true:
                baseMatrixTemplate = adDataV2.neoTKInfo;
                str2 = baseMatrixTemplate.templateId;
                break;
            case true:
                str2 = adDataV2.pushTKInfo.templateId;
                break;
            case true:
                str2 = adDataV2.preLandingPageTKInfo.templateId;
                break;
            default:
                str2 = "";
                break;
        }
        String str3 = str2;
        if (TextUtils.isEmpty(str2)) {
            Iterator<AdMatrixInfo.MatrixTemplate> it = com.kwad.sdk.core.response.a.b.aJ(adTemplate).styles.templateList.iterator();
            while (true) {
                str3 = str2;
                if (it.hasNext()) {
                    if (it.next().templateId.equals(str)) {
                        str3 = str;
                    }
                }
            }
        }
        if (TextUtils.isEmpty(str3)) {
            KSLoggerReporter.ReportClient.RESPONE_MONITOR.buildNormalApmReporter().cC("response_biz_error_tk").aF(adTemplate).a(BusinessType.TACHIKOMA).J("TkTemplateIdLost", str).report();
            return str;
        }
        return str3;
    }
}
