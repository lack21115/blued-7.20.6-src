package android.media;

/* loaded from: source-9557208-dex2jar.jar:android/media/MediaTimeProvider.class */
public interface MediaTimeProvider {
    public static final long NO_TIME = -1;

    /* loaded from: source-9557208-dex2jar.jar:android/media/MediaTimeProvider$OnMediaTimeListener.class */
    public interface OnMediaTimeListener {
        void onSeek(long j);

        void onStop();

        void onTimedEvent(long j);
    }

    void cancelNotifications(OnMediaTimeListener onMediaTimeListener);

    long getCurrentTimeUs(boolean z, boolean z2) throws IllegalStateException;

    void notifyAt(long j, OnMediaTimeListener onMediaTimeListener);

    void scheduleUpdate(OnMediaTimeListener onMediaTimeListener);
}