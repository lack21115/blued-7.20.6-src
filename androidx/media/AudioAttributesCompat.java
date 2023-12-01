package androidx.media;

import android.media.AudioAttributes;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseIntArray;
import androidx.versionedparcelable.VersionedParcelable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: source-8756600-dex2jar.jar:androidx/media/AudioAttributesCompat.class */
public class AudioAttributesCompat implements VersionedParcelable {
    public static final int CONTENT_TYPE_MOVIE = 3;
    public static final int CONTENT_TYPE_MUSIC = 2;
    public static final int CONTENT_TYPE_SONIFICATION = 4;
    public static final int CONTENT_TYPE_SPEECH = 1;
    public static final int CONTENT_TYPE_UNKNOWN = 0;
    public static final int FLAG_AUDIBILITY_ENFORCED = 1;
    public static final int FLAG_HW_AV_SYNC = 16;
    public static final int USAGE_ALARM = 4;
    public static final int USAGE_ASSISTANCE_ACCESSIBILITY = 11;
    public static final int USAGE_ASSISTANCE_NAVIGATION_GUIDANCE = 12;
    public static final int USAGE_ASSISTANCE_SONIFICATION = 13;
    public static final int USAGE_ASSISTANT = 16;
    public static final int USAGE_GAME = 14;
    public static final int USAGE_MEDIA = 1;
    public static final int USAGE_NOTIFICATION = 5;
    public static final int USAGE_NOTIFICATION_COMMUNICATION_DELAYED = 9;
    public static final int USAGE_NOTIFICATION_COMMUNICATION_INSTANT = 8;
    public static final int USAGE_NOTIFICATION_COMMUNICATION_REQUEST = 7;
    public static final int USAGE_NOTIFICATION_EVENT = 10;
    public static final int USAGE_NOTIFICATION_RINGTONE = 6;
    public static final int USAGE_UNKNOWN = 0;
    public static final int USAGE_VOICE_COMMUNICATION = 2;
    public static final int USAGE_VOICE_COMMUNICATION_SIGNALLING = 3;

    /* renamed from: a  reason: collision with root package name */
    static boolean f3052a;

    /* renamed from: c  reason: collision with root package name */
    private static final SparseIntArray f3053c;
    private static final int[] d;
    AudioAttributesImpl b;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: source-8756600-dex2jar.jar:androidx/media/AudioAttributesCompat$AttributeContentType.class */
    public @interface AttributeContentType {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: source-8756600-dex2jar.jar:androidx/media/AudioAttributesCompat$AttributeUsage.class */
    public @interface AttributeUsage {
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/media/AudioAttributesCompat$AudioManagerHidden.class */
    static abstract class AudioManagerHidden {
        public static final int STREAM_ACCESSIBILITY = 10;
        public static final int STREAM_BLUETOOTH_SCO = 6;
        public static final int STREAM_SYSTEM_ENFORCED = 7;
        public static final int STREAM_TTS = 9;

        private AudioManagerHidden() {
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/media/AudioAttributesCompat$Builder.class */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        private int f3054a;
        private int b;

        /* renamed from: c  reason: collision with root package name */
        private int f3055c;
        private int d;

        public Builder() {
            this.f3054a = 0;
            this.b = 0;
            this.f3055c = 0;
            this.d = -1;
        }

        public Builder(AudioAttributesCompat audioAttributesCompat) {
            this.f3054a = 0;
            this.b = 0;
            this.f3055c = 0;
            this.d = -1;
            this.f3054a = audioAttributesCompat.getUsage();
            this.b = audioAttributesCompat.getContentType();
            this.f3055c = audioAttributesCompat.getFlags();
            this.d = audioAttributesCompat.a();
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        Builder a(int i) {
            switch (i) {
                case 0:
                    this.b = 1;
                    break;
                case 1:
                    this.b = 4;
                    break;
                case 2:
                    this.b = 4;
                    break;
                case 3:
                    this.b = 2;
                    break;
                case 4:
                    this.b = 4;
                    break;
                case 5:
                    this.b = 4;
                    break;
                case 6:
                    this.b = 1;
                    this.f3055c |= 4;
                    break;
                case 7:
                    this.f3055c = 1 | this.f3055c;
                    this.b = 4;
                    break;
                case 8:
                    this.b = 4;
                    break;
                case 9:
                    this.b = 4;
                    break;
                case 10:
                    this.b = 1;
                    break;
                default:
                    Log.e("AudioAttributesCompat", "Invalid stream type " + i + " for AudioAttributesCompat");
                    break;
            }
            this.f3054a = AudioAttributesCompat.b(i);
            return this;
        }

        public AudioAttributesCompat build() {
            AudioAttributesImpl audioAttributesImplBase;
            if (AudioAttributesCompat.f3052a || Build.VERSION.SDK_INT < 21) {
                audioAttributesImplBase = new AudioAttributesImplBase(this.b, this.f3055c, this.f3054a, this.d);
            } else {
                AudioAttributes.Builder usage = new AudioAttributes.Builder().setContentType(this.b).setFlags(this.f3055c).setUsage(this.f3054a);
                int i = this.d;
                if (i != -1) {
                    usage.setLegacyStreamType(i);
                }
                audioAttributesImplBase = new AudioAttributesImplApi21(usage.build(), this.d);
            }
            return new AudioAttributesCompat(audioAttributesImplBase);
        }

        public Builder setContentType(int i) {
            if (i == 0 || i == 1 || i == 2 || i == 3 || i == 4) {
                this.b = i;
                return this;
            }
            this.f3054a = 0;
            return this;
        }

        public Builder setFlags(int i) {
            this.f3055c = (i & 1023) | this.f3055c;
            return this;
        }

        public Builder setLegacyStreamType(int i) {
            if (i != 10) {
                this.d = i;
                return Build.VERSION.SDK_INT >= 21 ? a(i) : this;
            }
            throw new IllegalArgumentException("STREAM_ACCESSIBILITY is not a legacy stream type that was used for audio playback");
        }

        public Builder setUsage(int i) {
            switch (i) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                case 10:
                case 11:
                case 12:
                case 13:
                case 14:
                case 15:
                    this.f3054a = i;
                    return this;
                case 16:
                    if (AudioAttributesCompat.f3052a || Build.VERSION.SDK_INT <= 25) {
                        this.f3054a = 12;
                        return this;
                    }
                    this.f3054a = i;
                    return this;
                default:
                    this.f3054a = 0;
                    return this;
            }
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f3053c = sparseIntArray;
        sparseIntArray.put(5, 1);
        f3053c.put(6, 2);
        f3053c.put(7, 2);
        f3053c.put(8, 1);
        f3053c.put(9, 1);
        f3053c.put(10, 1);
        d = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 16};
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AudioAttributesCompat() {
    }

    AudioAttributesCompat(AudioAttributesImpl audioAttributesImpl) {
        this.b = audioAttributesImpl;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static int a(boolean z, int i, int i2) {
        if ((i & 1) == 1) {
            return z ? 1 : 7;
        } else if ((i & 4) == 4) {
            return z ? 0 : 6;
        } else {
            int i3 = 0;
            switch (i2) {
                case 0:
                    int i4 = 3;
                    if (z) {
                        i4 = Integer.MIN_VALUE;
                    }
                    return i4;
                case 1:
                case 12:
                case 14:
                case 16:
                    return 3;
                case 2:
                    break;
                case 3:
                    if (!z) {
                        i3 = 8;
                        break;
                    } else {
                        return 0;
                    }
                case 4:
                    return 4;
                case 5:
                case 7:
                case 8:
                case 9:
                case 10:
                    return 5;
                case 6:
                    return 2;
                case 11:
                    return 10;
                case 13:
                    return 1;
                case 15:
                default:
                    if (z) {
                        throw new IllegalArgumentException("Unknown usage value " + i2 + " in audio attributes");
                    }
                    return 3;
            }
            return i3;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(int i) {
        switch (i) {
            case 0:
                return "USAGE_UNKNOWN";
            case 1:
                return "USAGE_MEDIA";
            case 2:
                return "USAGE_VOICE_COMMUNICATION";
            case 3:
                return "USAGE_VOICE_COMMUNICATION_SIGNALLING";
            case 4:
                return "USAGE_ALARM";
            case 5:
                return "USAGE_NOTIFICATION";
            case 6:
                return "USAGE_NOTIFICATION_RINGTONE";
            case 7:
                return "USAGE_NOTIFICATION_COMMUNICATION_REQUEST";
            case 8:
                return "USAGE_NOTIFICATION_COMMUNICATION_INSTANT";
            case 9:
                return "USAGE_NOTIFICATION_COMMUNICATION_DELAYED";
            case 10:
                return "USAGE_NOTIFICATION_EVENT";
            case 11:
                return "USAGE_ASSISTANCE_ACCESSIBILITY";
            case 12:
                return "USAGE_ASSISTANCE_NAVIGATION_GUIDANCE";
            case 13:
                return "USAGE_ASSISTANCE_SONIFICATION";
            case 14:
                return "USAGE_GAME";
            case 15:
            default:
                return "unknown usage " + i;
            case 16:
                return "USAGE_ASSISTANT";
        }
    }

    static int b(int i) {
        switch (i) {
            case 0:
                return 2;
            case 1:
            case 7:
                return 13;
            case 2:
                return 6;
            case 3:
                return 1;
            case 4:
                return 4;
            case 5:
                return 5;
            case 6:
                return 2;
            case 8:
                return 3;
            case 9:
            default:
                return 0;
            case 10:
                return 11;
        }
    }

    public static AudioAttributesCompat fromBundle(Bundle bundle) {
        AudioAttributesImpl fromBundle = Build.VERSION.SDK_INT >= 21 ? AudioAttributesImplApi21.fromBundle(bundle) : AudioAttributesImplBase.fromBundle(bundle);
        if (fromBundle == null) {
            return null;
        }
        return new AudioAttributesCompat(fromBundle);
    }

    public static void setForceLegacyBehavior(boolean z) {
        f3052a = z;
    }

    public static AudioAttributesCompat wrap(Object obj) {
        if (Build.VERSION.SDK_INT < 21 || f3052a) {
            return null;
        }
        AudioAttributesImplApi21 audioAttributesImplApi21 = new AudioAttributesImplApi21((AudioAttributes) obj);
        AudioAttributesCompat audioAttributesCompat = new AudioAttributesCompat();
        audioAttributesCompat.b = audioAttributesImplApi21;
        return audioAttributesCompat;
    }

    int a() {
        return this.b.getRawLegacyStreamType();
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (obj instanceof AudioAttributesCompat) {
            AudioAttributesCompat audioAttributesCompat = (AudioAttributesCompat) obj;
            AudioAttributesImpl audioAttributesImpl = this.b;
            if (audioAttributesImpl == null) {
                if (audioAttributesCompat.b == null) {
                    z = true;
                }
                return z;
            }
            return audioAttributesImpl.equals(audioAttributesCompat.b);
        }
        return false;
    }

    public int getContentType() {
        return this.b.getContentType();
    }

    public int getFlags() {
        return this.b.getFlags();
    }

    public int getLegacyStreamType() {
        return this.b.getLegacyStreamType();
    }

    public int getUsage() {
        return this.b.getUsage();
    }

    public int getVolumeControlStream() {
        return this.b.getVolumeControlStream();
    }

    public int hashCode() {
        return this.b.hashCode();
    }

    public Bundle toBundle() {
        return this.b.toBundle();
    }

    public String toString() {
        return this.b.toString();
    }

    public Object unwrap() {
        return this.b.getAudioAttributes();
    }
}
