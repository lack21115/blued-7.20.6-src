package android.util;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.SntpClient;
import android.os.SystemClock;
import android.provider.Settings;
import android.text.TextUtils;
import com.android.internal.R;

/* loaded from: source-9557208-dex2jar.jar:android/util/NtpTrustedTime.class */
public class NtpTrustedTime implements TrustedTime {
    private static final boolean LOGD = false;
    private static final String TAG = "NtpTrustedTime";
    private static Context sContext;
    private static NtpTrustedTime sSingleton;
    private ConnectivityManager mCM;
    private long mCachedNtpCertainty;
    private long mCachedNtpElapsedRealtime;
    private long mCachedNtpTime;
    private boolean mHasCache;
    private final String mServer;
    private final long mTimeout;

    private NtpTrustedTime(String str, long j) {
        this.mServer = str;
        this.mTimeout = j;
    }

    public static NtpTrustedTime getInstance(Context context) {
        NtpTrustedTime ntpTrustedTime;
        synchronized (NtpTrustedTime.class) {
            try {
                if (sSingleton == null) {
                    Resources resources = context.getResources();
                    ContentResolver contentResolver = context.getContentResolver();
                    String string = resources.getString(R.string.config_ntpServer);
                    long integer = resources.getInteger(R.integer.config_ntpTimeout);
                    String string2 = Settings.Global.getString(contentResolver, Settings.Global.NTP_SERVER);
                    long j = Settings.Global.getLong(contentResolver, Settings.Global.NTP_TIMEOUT, integer);
                    if (string2 != null) {
                        string = string2;
                    }
                    sSingleton = new NtpTrustedTime(string, j);
                    sContext = context;
                }
                ntpTrustedTime = sSingleton;
            } catch (Throwable th) {
                throw th;
            }
        }
        return ntpTrustedTime;
    }

    @Override // android.util.TrustedTime
    public long currentTimeMillis() {
        if (this.mHasCache) {
            return this.mCachedNtpTime + getCacheAge();
        }
        throw new IllegalStateException("Missing authoritative time source");
    }

    @Override // android.util.TrustedTime
    public boolean forceRefresh() {
        if (TextUtils.isEmpty(this.mServer)) {
            return false;
        }
        synchronized (this) {
            if (this.mCM == null) {
                this.mCM = (ConnectivityManager) sContext.getSystemService(Context.CONNECTIVITY_SERVICE);
            }
        }
        NetworkInfo activeNetworkInfo = this.mCM == null ? null : this.mCM.getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            return false;
        }
        SntpClient sntpClient = new SntpClient();
        if (sntpClient.requestTime(this.mServer, (int) this.mTimeout)) {
            this.mHasCache = true;
            this.mCachedNtpTime = sntpClient.getNtpTime();
            this.mCachedNtpElapsedRealtime = sntpClient.getNtpTimeReference();
            this.mCachedNtpCertainty = sntpClient.getRoundTripTime() / 2;
            return true;
        }
        return false;
    }

    @Override // android.util.TrustedTime
    public long getCacheAge() {
        if (this.mHasCache) {
            return SystemClock.elapsedRealtime() - this.mCachedNtpElapsedRealtime;
        }
        return Long.MAX_VALUE;
    }

    @Override // android.util.TrustedTime
    public long getCacheCertainty() {
        if (this.mHasCache) {
            return this.mCachedNtpCertainty;
        }
        return Long.MAX_VALUE;
    }

    public long getCachedNtpTime() {
        return this.mCachedNtpTime;
    }

    public long getCachedNtpTimeReference() {
        return this.mCachedNtpElapsedRealtime;
    }

    @Override // android.util.TrustedTime
    public boolean hasCache() {
        return this.mHasCache;
    }
}
