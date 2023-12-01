package android.media.audiopolicy;

import android.media.AudioFormat;
import android.media.audiopolicy.AudioMix;
import android.media.audiopolicy.AudioMixingRule;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

/* loaded from: source-9557208-dex2jar.jar:android/media/audiopolicy/AudioPolicyConfig.class */
public class AudioPolicyConfig implements Parcelable {
    public static final Parcelable.Creator<AudioPolicyConfig> CREATOR = new Parcelable.Creator<AudioPolicyConfig>() { // from class: android.media.audiopolicy.AudioPolicyConfig.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AudioPolicyConfig createFromParcel(Parcel parcel) {
            return new AudioPolicyConfig(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AudioPolicyConfig[] newArray(int i) {
            return new AudioPolicyConfig[i];
        }
    };
    private static final String TAG = "AudioPolicyConfig";
    protected int mDuckingPolicy;
    protected ArrayList<AudioMix> mMixes;
    private String mRegistrationId;

    /* JADX INFO: Access modifiers changed from: protected */
    public AudioPolicyConfig(AudioPolicyConfig audioPolicyConfig) {
        this.mDuckingPolicy = 0;
        this.mRegistrationId = null;
        this.mMixes = audioPolicyConfig.mMixes;
    }

    private AudioPolicyConfig(Parcel parcel) {
        this.mDuckingPolicy = 0;
        this.mRegistrationId = null;
        this.mMixes = new ArrayList<>();
        int readInt = parcel.readInt();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= readInt) {
                return;
            }
            AudioMix.Builder builder = new AudioMix.Builder();
            builder.setRouteFlags(parcel.readInt());
            int readInt2 = parcel.readInt();
            builder.setFormat(new AudioFormat.Builder().setSampleRate(readInt2).setChannelMask(parcel.readInt()).setEncoding(parcel.readInt()).build());
            int readInt3 = parcel.readInt();
            AudioMixingRule.Builder builder2 = new AudioMixingRule.Builder();
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 < readInt3) {
                    builder2.addRuleFromParcel(parcel);
                    i3 = i4 + 1;
                }
            }
            builder.setMixingRule(builder2.build());
            this.mMixes.add(builder.build());
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AudioPolicyConfig(ArrayList<AudioMix> arrayList) {
        this.mDuckingPolicy = 0;
        this.mRegistrationId = null;
        this.mMixes = arrayList;
    }

    private static String mixTypeId(int i) {
        return i == 0 ? "p" : i == 1 ? "r" : "i";
    }

    public void addMix(AudioMix audioMix) throws IllegalArgumentException {
        if (audioMix == null) {
            throw new IllegalArgumentException("Illegal null AudioMix argument");
        }
        this.mMixes.add(audioMix);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getRegistration() {
        return this.mRegistrationId;
    }

    public int hashCode() {
        return Objects.hash(this.mMixes);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setRegistration(String str) {
        boolean z = false;
        boolean z2 = this.mRegistrationId == null || this.mRegistrationId.isEmpty();
        if (str == null || str.isEmpty()) {
            z = true;
        }
        if (!z2 && !z && !this.mRegistrationId.equals(str)) {
            Log.e(TAG, "Invalid registration transition from " + this.mRegistrationId + " to " + str);
            return;
        }
        String str2 = str;
        if (str == null) {
            str2 = "";
        }
        this.mRegistrationId = str2;
        int i = 0;
        Iterator<AudioMix> it = this.mMixes.iterator();
        while (it.hasNext()) {
            AudioMix next = it.next();
            if (this.mRegistrationId.isEmpty()) {
                next.setRegistration("");
            } else {
                next.setRegistration(this.mRegistrationId + "mix" + mixTypeId(next.getMixType()) + ":" + i);
                i++;
            }
        }
    }

    public String toLogFriendlyString() {
        AudioMix next;
        AudioMixingRule.AttributeMatchCriterion next2;
        String str;
        String str2 = new String("android.media.audiopolicy.AudioPolicyConfig:\n") + this.mMixes.size() + " AudioMix: " + this.mRegistrationId + "\n";
        Iterator<AudioMix> it = this.mMixes.iterator();
        while (it.hasNext()) {
            String str3 = ((((str2 + "* route flags=0x" + Integer.toHexString(next.getRouteFlags()) + "\n") + "  rate=" + next.getFormat().getSampleRate() + "Hz\n") + "  encoding=" + next.getFormat().getEncoding() + "\n") + "  channels=0x") + Integer.toHexString(next.getFormat().getChannelMask()).toUpperCase() + "\n";
            Iterator<AudioMixingRule.AttributeMatchCriterion> it2 = it.next().getRule().getCriteria().iterator();
            while (true) {
                str2 = str3;
                if (it2.hasNext()) {
                    switch (it2.next().mRule) {
                        case 1:
                            str = (str3 + "  match usage ") + next2.mAttr.usageToString();
                            break;
                        case 2:
                            str = (str3 + "  match capture preset ") + next2.mAttr.getCapturePreset();
                            break;
                        case 32769:
                            str = (str3 + "  exclude usage ") + next2.mAttr.usageToString();
                            break;
                        case 32770:
                            str = (str3 + "  exclude capture preset ") + next2.mAttr.getCapturePreset();
                            break;
                        default:
                            str = str3 + "invalid rule!";
                            break;
                    }
                    str3 = str + "\n";
                }
            }
        }
        return str2;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mMixes.size());
        Iterator<AudioMix> it = this.mMixes.iterator();
        while (it.hasNext()) {
            AudioMix next = it.next();
            parcel.writeInt(next.getRouteFlags());
            parcel.writeInt(next.getFormat().getSampleRate());
            parcel.writeInt(next.getFormat().getEncoding());
            parcel.writeInt(next.getFormat().getChannelMask());
            ArrayList<AudioMixingRule.AttributeMatchCriterion> criteria = next.getRule().getCriteria();
            parcel.writeInt(criteria.size());
            Iterator<AudioMixingRule.AttributeMatchCriterion> it2 = criteria.iterator();
            while (it2.hasNext()) {
                it2.next().writeToParcel(parcel);
            }
        }
    }
}
