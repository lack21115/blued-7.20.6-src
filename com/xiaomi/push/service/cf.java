package com.xiaomi.push.service;

import com.xiaomi.push.hg;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/service/cf.class */
/* synthetic */ class cf {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ int[] f41663a;

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
        int[] iArr = new int[hg.values().length];
        f41663a = iArr;
        try {
            iArr[hg.Registration.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f41663a[hg.UnRegistration.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f41663a[hg.Subscription.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            f41663a[hg.UnSubscription.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
        try {
            f41663a[hg.SendMessage.ordinal()] = 5;
        } catch (NoSuchFieldError e5) {
        }
        try {
            f41663a[hg.AckMessage.ordinal()] = 6;
        } catch (NoSuchFieldError e6) {
        }
        try {
            f41663a[hg.SetConfig.ordinal()] = 7;
        } catch (NoSuchFieldError e7) {
        }
        try {
            f41663a[hg.ReportFeedback.ordinal()] = 8;
        } catch (NoSuchFieldError e8) {
        }
        try {
            f41663a[hg.Notification.ordinal()] = 9;
        } catch (NoSuchFieldError e9) {
        }
        try {
            f41663a[hg.Command.ordinal()] = 10;
        } catch (NoSuchFieldError e10) {
        }
    }
}