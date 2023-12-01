package android.webkit;

import java.util.Map;

/* loaded from: source-4181928-dex2jar.jar:android/webkit/WebStorage.class */
public class WebStorage {

    /* loaded from: source-4181928-dex2jar.jar:android/webkit/WebStorage$Origin.class */
    public static class Origin {
        private String mOrigin;
        private long mQuota;
        private long mUsage;

        protected Origin(String str, long j, long j2) {
            this.mOrigin = null;
            this.mQuota = 0L;
            this.mUsage = 0L;
            this.mOrigin = str;
            this.mQuota = j;
            this.mUsage = j2;
        }

        public String getOrigin() {
            return this.mOrigin;
        }

        public long getQuota() {
            return this.mQuota;
        }

        public long getUsage() {
            return this.mUsage;
        }
    }

    @Deprecated
    /* loaded from: source-4181928-dex2jar.jar:android/webkit/WebStorage$QuotaUpdater.class */
    public interface QuotaUpdater {
        void updateQuota(long j);
    }

    public static WebStorage getInstance() {
        return WebViewFactory.getProvider().getWebStorage();
    }

    public void deleteAllData() {
    }

    public void deleteOrigin(String str) {
    }

    public void getOrigins(ValueCallback<Map> valueCallback) {
    }

    public void getQuotaForOrigin(String str, ValueCallback<Long> valueCallback) {
    }

    public void getUsageForOrigin(String str, ValueCallback<Long> valueCallback) {
    }

    @Deprecated
    public void setQuotaForOrigin(String str, long j) {
    }
}
