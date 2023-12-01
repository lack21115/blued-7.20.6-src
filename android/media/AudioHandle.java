package android.media;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-9557208-dex2jar.jar:android/media/AudioHandle.class */
public class AudioHandle {
    private final int mId;

    AudioHandle(int i) {
        this.mId = i;
    }

    public boolean equals(Object obj) {
        return obj != null && (obj instanceof AudioHandle) && this.mId == ((AudioHandle) obj).id();
    }

    public int hashCode() {
        return this.mId;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int id() {
        return this.mId;
    }

    public String toString() {
        return Integer.toString(this.mId);
    }
}
