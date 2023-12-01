package com.amap.api.col.p0003sl;

import com.amap.api.col.p0003sl.hx;

/* renamed from: com.amap.api.col.3sl.hy  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/hy.class */
public final class hy {

    /* renamed from: a  reason: collision with root package name */
    public final hx.c f5127a;
    public final String b;

    /* renamed from: com.amap.api.col.3sl.hy$1  reason: invalid class name */
    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/hy$1.class */
    static final /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f5128a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0071 -> B:49:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0075 -> B:45:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0079 -> B:41:0x002a). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x007d -> B:53:0x0035). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x0081 -> B:47:0x0040). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x0085 -> B:43:0x004c). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x0089 -> B:39:0x0058). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x008d -> B:51:0x0064). Please submit an issue!!! */
        static {
            int[] iArr = new int[hx.c.values().length];
            f5128a = iArr;
            try {
                iArr[hx.c.ShowUnknowCode.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f5128a[hx.c.ShowNoShowCode.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f5128a[hx.c.InfoUnknowCode.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f5128a[hx.c.InfoNotContainCode.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f5128a[hx.c.AgreeUnknowCode.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f5128a[hx.c.AgreeNotAgreeCode.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f5128a[hx.c.InvaildUserKeyCode.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                f5128a[hx.c.IllegalArgument.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                f5128a[hx.c.SuccessCode.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public hy(hx.c cVar, ia iaVar) {
        String format;
        this.f5127a = cVar;
        switch (AnonymousClass1.f5128a[cVar.ordinal()]) {
            case 1:
                format = String.format("***确保调用SDK任何接口前先调用更新隐私合规updatePrivacyShow、updatePrivacyAgree两个接口并且参数值都为true，若未正确设置有崩溃风险***\n使用%s SDK 功能前请设置隐私权政策是否弹窗告知用户", iaVar.a());
                break;
            case 2:
                format = String.format("***确保调用SDK任何接口前先调用更新隐私合规updatePrivacyShow、updatePrivacyAgree两个接口并且参数值都为true，若未正确设置有崩溃风险***\n使用%s SDK 功能前请确保隐私权政策已弹窗告知用户", iaVar.a());
                break;
            case 3:
                format = String.format("***确保调用SDK任何接口前先调用更新隐私合规updatePrivacyShow、updatePrivacyAgree两个接口并且参数值都为true，若未正确设置有崩溃风险***\n使用%s SDK 功能前请确保设置隐私权政策是否包含高德开平隐私权政策", iaVar.a());
                break;
            case 4:
                format = String.format("***确保调用SDK任何接口前先调用更新隐私合规updatePrivacyShow、updatePrivacyAgree两个接口并且参数值都为true，若未正确设置有崩溃风险***\n使用%s SDK 功能前请确保隐私权政策已经包含高德开平隐私权政策", iaVar.a());
                break;
            case 5:
                format = String.format("***确保调用SDK任何接口前先调用更新隐私合规updatePrivacyShow、updatePrivacyAgree两个接口并且参数值都为true，若未正确设置有崩溃风险***\n使用%s SDK 功能前请确保设置隐私权政策是否取得用户同意", iaVar.a());
                break;
            case 6:
                format = String.format("***确保调用SDK任何接口前先调用更新隐私合规updatePrivacyShow、updatePrivacyAgree两个接口并且参数值都为true，若未正确设置有崩溃风险***\n使用%s SDK 功能前请确保隐私权政策已取得用户同意", iaVar.a());
                break;
            case 7:
                format = String.format("***确保调用SDK任何接口前先调用更新隐私合规updatePrivacyShow、updatePrivacyAgree两个接口并且参数值都为true，若未正确设置有崩溃风险***\n使用%s SDK 功能使用前请确保已经正确设置apiKey，如有疑问请在高德开放平台官网中搜索【INVALID_USER_KEY】相关内容进行解决。", iaVar.a());
                break;
            case 8:
                format = String.format("***确保调用SDK任何接口前先调用更新隐私合规updatePrivacyShow、updatePrivacyAgree两个接口并且参数值都为true，若未正确设置有崩溃风险***\n参数非法，context 或 sdkInfo为空", new Object[0]);
                break;
            case 9:
                format = String.format("设置隐私政策成功", new Object[0]);
                break;
            default:
                format = "";
                break;
        }
        this.b = format;
    }
}
