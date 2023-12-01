package android.media;

/* loaded from: source-9557208-dex2jar.jar:android/media/MediaSyncEvent.class */
public class MediaSyncEvent {
    public static final int SYNC_EVENT_NONE = 0;
    public static final int SYNC_EVENT_PRESENTATION_COMPLETE = 1;
    private int mAudioSession = 0;
    private final int mType;

    private MediaSyncEvent(int i) {
        this.mType = i;
    }

    public static MediaSyncEvent createEvent(int i) throws IllegalArgumentException {
        if (isValidType(i)) {
            return new MediaSyncEvent(i);
        }
        throw new IllegalArgumentException(i + "is not a valid MediaSyncEvent type.");
    }

    private static boolean isValidType(int i) {
        switch (i) {
            case 0:
            case 1:
                return true;
            default:
                return false;
        }
    }

    public int getAudioSessionId() {
        return this.mAudioSession;
    }

    public int getType() {
        return this.mType;
    }

    public MediaSyncEvent setAudioSessionId(int i) throws IllegalArgumentException {
        if (i > 0) {
            this.mAudioSession = i;
            return this;
        }
        throw new IllegalArgumentException(i + " is not a valid session ID.");
    }
}
