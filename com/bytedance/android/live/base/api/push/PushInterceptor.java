package com.bytedance.android.live.base.api.push;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/android/live/base/api/push/PushInterceptor.class */
public interface PushInterceptor {

    /* loaded from: source-7206380-dex2jar.jar:com/bytedance/android/live/base/api/push/PushInterceptor$InterceptResult.class */
    public static class InterceptResult {
        public final boolean intercept;
        public final String interceptReason;

        public InterceptResult(boolean z) {
            this(z, "");
        }

        public InterceptResult(boolean z, String str) {
            this.intercept = z;
            this.interceptReason = "";
        }
    }

    InterceptResult intercept();
}
