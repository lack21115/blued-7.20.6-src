package android.media.audiopolicy;

import android.media.AudioAttributes;
import android.os.Parcel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

/* loaded from: source-9557208-dex2jar.jar:android/media/audiopolicy/AudioMixingRule.class */
public class AudioMixingRule {
    public static final int RULE_EXCLUDE_ATTRIBUTE_CAPTURE_PRESET = 32770;
    public static final int RULE_EXCLUDE_ATTRIBUTE_USAGE = 32769;
    private static final int RULE_EXCLUSION_MASK = 32768;
    public static final int RULE_MATCH_ATTRIBUTE_CAPTURE_PRESET = 2;
    public static final int RULE_MATCH_ATTRIBUTE_USAGE = 1;
    private final ArrayList<AttributeMatchCriterion> mCriteria;
    private final int mTargetMixType;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-9557208-dex2jar.jar:android/media/audiopolicy/AudioMixingRule$AttributeMatchCriterion.class */
    public static final class AttributeMatchCriterion {
        AudioAttributes mAttr;
        int mRule;

        AttributeMatchCriterion(AudioAttributes audioAttributes, int i) {
            this.mAttr = audioAttributes;
            this.mRule = i;
        }

        public int hashCode() {
            return Objects.hash(this.mAttr, Integer.valueOf(this.mRule));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void writeToParcel(Parcel parcel) {
            parcel.writeInt(this.mRule);
            if (this.mRule == 1 || this.mRule == 32769) {
                parcel.writeInt(this.mAttr.getUsage());
            } else {
                parcel.writeInt(this.mAttr.getCapturePreset());
            }
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/media/audiopolicy/AudioMixingRule$Builder.class */
    public static class Builder {
        private int mTargetMixType = -1;
        private ArrayList<AttributeMatchCriterion> mCriteria = new ArrayList<>();

        public Builder addRule(AudioAttributes audioAttributes, int i) throws IllegalArgumentException {
            if (AudioMixingRule.isValidSystemApiRule(i)) {
                return addRuleInt(audioAttributes, i);
            }
            throw new IllegalArgumentException("Illegal rule value " + i);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Builder addRuleFromParcel(Parcel parcel) throws IllegalArgumentException {
            AudioAttributes build;
            int readInt = parcel.readInt();
            if (readInt == 1 || readInt == 32769) {
                build = new AudioAttributes.Builder().setUsage(parcel.readInt()).build();
            } else if (readInt != 2 && readInt != 32770) {
                parcel.readInt();
                throw new IllegalArgumentException("Illegal rule value " + readInt + " in parcel");
            } else {
                build = new AudioAttributes.Builder().setInternalCapturePreset(parcel.readInt()).build();
            }
            return addRuleInt(build, readInt);
        }

        Builder addRuleInt(AudioAttributes audioAttributes, int i) throws IllegalArgumentException {
            if (audioAttributes == null) {
                throw new IllegalArgumentException("Illegal null AudioAttributes argument");
            }
            if (AudioMixingRule.isValidIntRule(i)) {
                if (this.mTargetMixType == -1) {
                    if (AudioMixingRule.isPlayerRule(i)) {
                        this.mTargetMixType = 0;
                    } else {
                        this.mTargetMixType = 1;
                    }
                } else if ((this.mTargetMixType == 0 && !AudioMixingRule.isPlayerRule(i)) || (this.mTargetMixType == 1 && AudioMixingRule.isPlayerRule(i))) {
                    throw new IllegalArgumentException("Incompatible rule for mix");
                }
                synchronized (this.mCriteria) {
                    Iterator<AttributeMatchCriterion> it = this.mCriteria.iterator();
                    while (it.hasNext()) {
                        AttributeMatchCriterion next = it.next();
                        if (i == 1 || i == 32769) {
                            if (next.mAttr.getUsage() == audioAttributes.getUsage()) {
                                if (next.mRule == i) {
                                    return this;
                                }
                                throw new IllegalArgumentException("Contradictory rule exists for " + audioAttributes);
                            }
                        } else if (i == 2 || i == 32770) {
                            if (next.mAttr.getCapturePreset() == audioAttributes.getCapturePreset()) {
                                if (next.mRule == i) {
                                    return this;
                                }
                                throw new IllegalArgumentException("Contradictory rule exists for " + audioAttributes);
                            }
                        }
                    }
                    this.mCriteria.add(new AttributeMatchCriterion(audioAttributes, i));
                    return this;
                }
            }
            throw new IllegalArgumentException("Illegal rule value " + i);
        }

        public AudioMixingRule build() {
            return new AudioMixingRule(this.mTargetMixType, this.mCriteria);
        }

        public Builder excludeRule(AudioAttributes audioAttributes, int i) throws IllegalArgumentException {
            if (AudioMixingRule.isValidSystemApiRule(i)) {
                return addRuleInt(audioAttributes, 32768 | i);
            }
            throw new IllegalArgumentException("Illegal rule value " + i);
        }
    }

    private AudioMixingRule(int i, ArrayList<AttributeMatchCriterion> arrayList) {
        this.mCriteria = arrayList;
        this.mTargetMixType = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isPlayerRule(int i) {
        return i == 1 || i == 32769;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isValidIntRule(int i) {
        switch (i) {
            case 1:
            case 2:
            case 32769:
            case 32770:
                return true;
            default:
                return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isValidSystemApiRule(int i) {
        switch (i) {
            case 1:
            case 2:
                return true;
            default:
                return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<AttributeMatchCriterion> getCriteria() {
        return this.mCriteria;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getTargetMixType() {
        return this.mTargetMixType;
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(this.mTargetMixType), this.mCriteria);
    }
}
