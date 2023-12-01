package android.media.audiopolicy;

import android.media.AudioFormat;
import android.media.AudioSystem;
import java.util.Objects;

/* loaded from: source-9557208-dex2jar.jar:android/media/audiopolicy/AudioMix.class */
public class AudioMix {
    public static final int MIX_TYPE_INVALID = -1;
    public static final int MIX_TYPE_PLAYERS = 0;
    public static final int MIX_TYPE_RECORDERS = 1;
    public static final int ROUTE_FLAG_LOOP_BACK = 2;
    public static final int ROUTE_FLAG_RENDER = 1;
    private AudioFormat mFormat;
    private int mMixType;
    private String mRegistrationId;
    private int mRouteFlags;
    private AudioMixingRule mRule;

    /* loaded from: source-9557208-dex2jar.jar:android/media/audiopolicy/AudioMix$Builder.class */
    public static class Builder {
        private AudioFormat mFormat;
        private int mRouteFlags;
        private AudioMixingRule mRule;

        /* JADX INFO: Access modifiers changed from: package-private */
        public Builder() {
            this.mRule = null;
            this.mFormat = null;
            this.mRouteFlags = 0;
        }

        public Builder(AudioMixingRule audioMixingRule) throws IllegalArgumentException {
            this.mRule = null;
            this.mFormat = null;
            this.mRouteFlags = 0;
            if (audioMixingRule == null) {
                throw new IllegalArgumentException("Illegal null AudioMixingRule argument");
            }
            this.mRule = audioMixingRule;
        }

        public AudioMix build() throws IllegalArgumentException {
            if (this.mRule == null) {
                throw new IllegalArgumentException("Illegal null AudioMixingRule");
            }
            if (this.mRouteFlags == 0) {
                this.mRouteFlags = 1;
            }
            if (this.mFormat == null) {
                int primaryOutputSamplingRate = AudioSystem.getPrimaryOutputSamplingRate();
                int i = primaryOutputSamplingRate;
                if (primaryOutputSamplingRate <= 0) {
                    i = 44100;
                }
                this.mFormat = new AudioFormat.Builder().setSampleRate(i).build();
            }
            return new AudioMix(this.mRule, this.mFormat, this.mRouteFlags);
        }

        public Builder setFormat(AudioFormat audioFormat) throws IllegalArgumentException {
            if (audioFormat == null) {
                throw new IllegalArgumentException("Illegal null AudioFormat argument");
            }
            this.mFormat = audioFormat;
            return this;
        }

        public Builder setMixingRule(AudioMixingRule audioMixingRule) throws IllegalArgumentException {
            if (audioMixingRule == null) {
                throw new IllegalArgumentException("Illegal null AudioMixingRule argument");
            }
            this.mRule = audioMixingRule;
            return this;
        }

        public Builder setRouteFlags(int i) throws IllegalArgumentException {
            if (i == 0) {
                throw new IllegalArgumentException("Illegal empty route flags");
            }
            if ((i & 3) == 0) {
                throw new IllegalArgumentException("Invalid route flags 0x" + Integer.toHexString(i) + "when creating an AudioMix");
            }
            this.mRouteFlags = i;
            return this;
        }
    }

    private AudioMix(AudioMixingRule audioMixingRule, AudioFormat audioFormat, int i) {
        this.mMixType = -1;
        this.mRule = audioMixingRule;
        this.mFormat = audioFormat;
        this.mRouteFlags = i;
        this.mRegistrationId = null;
        this.mMixType = audioMixingRule.getTargetMixType();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AudioFormat getFormat() {
        return this.mFormat;
    }

    public int getMixType() {
        return this.mMixType;
    }

    public String getRegistration() {
        return this.mRegistrationId;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getRouteFlags() {
        return this.mRouteFlags;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AudioMixingRule getRule() {
        return this.mRule;
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(this.mRouteFlags), this.mRule, Integer.valueOf(this.mMixType), this.mFormat);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setRegistration(String str) {
        this.mRegistrationId = str;
    }
}
