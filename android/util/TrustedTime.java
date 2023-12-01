package android.util;

/* loaded from: source-9557208-dex2jar.jar:android/util/TrustedTime.class */
public interface TrustedTime {
    long currentTimeMillis();

    boolean forceRefresh();

    long getCacheAge();

    long getCacheCertainty();

    boolean hasCache();
}
