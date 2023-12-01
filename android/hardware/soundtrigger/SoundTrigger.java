package android.hardware.soundtrigger;

import android.media.AudioFormat;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.UUID;

/* loaded from: source-9557208-dex2jar.jar:android/hardware/soundtrigger/SoundTrigger.class */
public class SoundTrigger {
    public static final int RECOGNITION_MODE_USER_AUTHENTICATION = 4;
    public static final int RECOGNITION_MODE_USER_IDENTIFICATION = 2;
    public static final int RECOGNITION_MODE_VOICE_TRIGGER = 1;
    public static final int RECOGNITION_STATUS_ABORT = 1;
    public static final int RECOGNITION_STATUS_FAILURE = 2;
    public static final int RECOGNITION_STATUS_SUCCESS = 0;
    public static final int SERVICE_STATE_DISABLED = 1;
    public static final int SERVICE_STATE_ENABLED = 0;
    public static final int SOUNDMODEL_STATUS_UPDATED = 0;
    public static final int STATUS_BAD_VALUE = -22;
    public static final int STATUS_DEAD_OBJECT = -32;
    public static final int STATUS_ERROR = Integer.MIN_VALUE;
    public static final int STATUS_INVALID_OPERATION = -38;
    public static final int STATUS_NO_INIT = -19;
    public static final int STATUS_OK = 0;
    public static final int STATUS_PERMISSION_DENIED = -1;

    /* loaded from: source-9557208-dex2jar.jar:android/hardware/soundtrigger/SoundTrigger$ConfidenceLevel.class */
    public static class ConfidenceLevel implements Parcelable {
        public static final Parcelable.Creator<ConfidenceLevel> CREATOR = new Parcelable.Creator<ConfidenceLevel>() { // from class: android.hardware.soundtrigger.SoundTrigger.ConfidenceLevel.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public ConfidenceLevel createFromParcel(Parcel parcel) {
                return ConfidenceLevel.fromParcel(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public ConfidenceLevel[] newArray(int i) {
                return new ConfidenceLevel[i];
            }
        };
        public final int confidenceLevel;
        public final int userId;

        public ConfidenceLevel(int i, int i2) {
            this.userId = i;
            this.confidenceLevel = i2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static ConfidenceLevel fromParcel(Parcel parcel) {
            return new ConfidenceLevel(parcel.readInt(), parcel.readInt());
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && getClass() == obj.getClass()) {
                ConfidenceLevel confidenceLevel = (ConfidenceLevel) obj;
                return this.confidenceLevel == confidenceLevel.confidenceLevel && this.userId == confidenceLevel.userId;
            }
            return false;
        }

        public int hashCode() {
            return ((this.confidenceLevel + 31) * 31) + this.userId;
        }

        public String toString() {
            return "ConfidenceLevel [userId=" + this.userId + ", confidenceLevel=" + this.confidenceLevel + "]";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.userId);
            parcel.writeInt(this.confidenceLevel);
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/hardware/soundtrigger/SoundTrigger$Keyphrase.class */
    public static class Keyphrase implements Parcelable {
        public static final Parcelable.Creator<Keyphrase> CREATOR = new Parcelable.Creator<Keyphrase>() { // from class: android.hardware.soundtrigger.SoundTrigger.Keyphrase.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public Keyphrase createFromParcel(Parcel parcel) {
                return Keyphrase.fromParcel(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public Keyphrase[] newArray(int i) {
                return new Keyphrase[i];
            }
        };
        public final int id;
        public final String locale;
        public final int recognitionModes;
        public final String text;
        public final int[] users;

        public Keyphrase(int i, int i2, String str, String str2, int[] iArr) {
            this.id = i;
            this.recognitionModes = i2;
            this.locale = str;
            this.text = str2;
            this.users = iArr;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static Keyphrase fromParcel(Parcel parcel) {
            int readInt = parcel.readInt();
            int readInt2 = parcel.readInt();
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            int[] iArr = null;
            int readInt3 = parcel.readInt();
            if (readInt3 >= 0) {
                iArr = new int[readInt3];
                parcel.readIntArray(iArr);
            }
            return new Keyphrase(readInt, readInt2, readString, readString2, iArr);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && getClass() == obj.getClass()) {
                Keyphrase keyphrase = (Keyphrase) obj;
                if (this.text == null) {
                    if (keyphrase.text != null) {
                        return false;
                    }
                } else if (!this.text.equals(keyphrase.text)) {
                    return false;
                }
                if (this.id != keyphrase.id) {
                    return false;
                }
                if (this.locale == null) {
                    if (keyphrase.locale != null) {
                        return false;
                    }
                } else if (!this.locale.equals(keyphrase.locale)) {
                    return false;
                }
                return this.recognitionModes == keyphrase.recognitionModes && Arrays.equals(this.users, keyphrase.users);
            }
            return false;
        }

        public int hashCode() {
            int i = 0;
            int hashCode = this.text == null ? 0 : this.text.hashCode();
            int i2 = this.id;
            if (this.locale != null) {
                i = this.locale.hashCode();
            }
            return ((((((((hashCode + 31) * 31) + i2) * 31) + i) * 31) + this.recognitionModes) * 31) + Arrays.hashCode(this.users);
        }

        public String toString() {
            return "Keyphrase [id=" + this.id + ", recognitionModes=" + this.recognitionModes + ", locale=" + this.locale + ", text=" + this.text + ", users=" + Arrays.toString(this.users) + "]";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.id);
            parcel.writeInt(this.recognitionModes);
            parcel.writeString(this.locale);
            parcel.writeString(this.text);
            if (this.users == null) {
                parcel.writeInt(-1);
                return;
            }
            parcel.writeInt(this.users.length);
            parcel.writeIntArray(this.users);
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/hardware/soundtrigger/SoundTrigger$KeyphraseRecognitionEvent.class */
    public static class KeyphraseRecognitionEvent extends RecognitionEvent {
        public static final Parcelable.Creator<KeyphraseRecognitionEvent> CREATOR = new Parcelable.Creator<KeyphraseRecognitionEvent>() { // from class: android.hardware.soundtrigger.SoundTrigger.KeyphraseRecognitionEvent.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public KeyphraseRecognitionEvent createFromParcel(Parcel parcel) {
                return KeyphraseRecognitionEvent.fromParcel(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public KeyphraseRecognitionEvent[] newArray(int i) {
                return new KeyphraseRecognitionEvent[i];
            }
        };
        public final KeyphraseRecognitionExtra[] keyphraseExtras;

        public KeyphraseRecognitionEvent(int i, int i2, boolean z, int i3, int i4, int i5, boolean z2, AudioFormat audioFormat, byte[] bArr, KeyphraseRecognitionExtra[] keyphraseRecognitionExtraArr) {
            super(i, i2, z, i3, i4, i5, z2, audioFormat, bArr);
            this.keyphraseExtras = keyphraseRecognitionExtraArr;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static KeyphraseRecognitionEvent fromParcel(Parcel parcel) {
            int readInt = parcel.readInt();
            int readInt2 = parcel.readInt();
            boolean z = parcel.readByte() == 1;
            int readInt3 = parcel.readInt();
            int readInt4 = parcel.readInt();
            int readInt5 = parcel.readInt();
            boolean z2 = parcel.readByte() == 1;
            AudioFormat audioFormat = null;
            if (parcel.readByte() == 1) {
                audioFormat = new AudioFormat.Builder().setChannelMask(parcel.readInt()).setEncoding(parcel.readInt()).setSampleRate(parcel.readInt()).build();
            }
            return new KeyphraseRecognitionEvent(readInt, readInt2, z, readInt3, readInt4, readInt5, z2, audioFormat, parcel.readBlob(), (KeyphraseRecognitionExtra[]) parcel.createTypedArray(KeyphraseRecognitionExtra.CREATOR));
        }

        @Override // android.hardware.soundtrigger.SoundTrigger.RecognitionEvent, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.hardware.soundtrigger.SoundTrigger.RecognitionEvent
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return super.equals(obj) && getClass() == obj.getClass() && Arrays.equals(this.keyphraseExtras, ((KeyphraseRecognitionEvent) obj).keyphraseExtras);
        }

        @Override // android.hardware.soundtrigger.SoundTrigger.RecognitionEvent
        public int hashCode() {
            return (super.hashCode() * 31) + Arrays.hashCode(this.keyphraseExtras);
        }

        @Override // android.hardware.soundtrigger.SoundTrigger.RecognitionEvent
        public String toString() {
            return "KeyphraseRecognitionEvent [keyphraseExtras=" + Arrays.toString(this.keyphraseExtras) + ", status=" + this.status + ", soundModelHandle=" + this.soundModelHandle + ", captureAvailable=" + this.captureAvailable + ", captureSession=" + this.captureSession + ", captureDelayMs=" + this.captureDelayMs + ", capturePreambleMs=" + this.capturePreambleMs + ", triggerInData=" + this.triggerInData + (this.captureFormat == null ? "" : ", sampleRate=" + this.captureFormat.getSampleRate()) + (this.captureFormat == null ? "" : ", encoding=" + this.captureFormat.getEncoding()) + (this.captureFormat == null ? "" : ", channelMask=" + this.captureFormat.getChannelMask()) + ", data=" + (this.data == null ? 0 : this.data.length) + "]";
        }

        @Override // android.hardware.soundtrigger.SoundTrigger.RecognitionEvent, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.status);
            parcel.writeInt(this.soundModelHandle);
            parcel.writeByte((byte) (this.captureAvailable ? 1 : 0));
            parcel.writeInt(this.captureSession);
            parcel.writeInt(this.captureDelayMs);
            parcel.writeInt(this.capturePreambleMs);
            parcel.writeByte((byte) (this.triggerInData ? 1 : 0));
            if (this.captureFormat != null) {
                parcel.writeByte((byte) 1);
                parcel.writeInt(this.captureFormat.getSampleRate());
                parcel.writeInt(this.captureFormat.getEncoding());
                parcel.writeInt(this.captureFormat.getChannelMask());
            } else {
                parcel.writeByte((byte) 0);
            }
            parcel.writeBlob(this.data);
            parcel.writeTypedArray(this.keyphraseExtras, i);
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/hardware/soundtrigger/SoundTrigger$KeyphraseRecognitionExtra.class */
    public static class KeyphraseRecognitionExtra implements Parcelable {
        public static final Parcelable.Creator<KeyphraseRecognitionExtra> CREATOR = new Parcelable.Creator<KeyphraseRecognitionExtra>() { // from class: android.hardware.soundtrigger.SoundTrigger.KeyphraseRecognitionExtra.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public KeyphraseRecognitionExtra createFromParcel(Parcel parcel) {
                return KeyphraseRecognitionExtra.fromParcel(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public KeyphraseRecognitionExtra[] newArray(int i) {
                return new KeyphraseRecognitionExtra[i];
            }
        };
        public final int coarseConfidenceLevel;
        public final ConfidenceLevel[] confidenceLevels;
        public final int id;
        public final int recognitionModes;

        public KeyphraseRecognitionExtra(int i, int i2, int i3, ConfidenceLevel[] confidenceLevelArr) {
            this.id = i;
            this.recognitionModes = i2;
            this.coarseConfidenceLevel = i3;
            this.confidenceLevels = confidenceLevelArr;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static KeyphraseRecognitionExtra fromParcel(Parcel parcel) {
            return new KeyphraseRecognitionExtra(parcel.readInt(), parcel.readInt(), parcel.readInt(), (ConfidenceLevel[]) parcel.createTypedArray(ConfidenceLevel.CREATOR));
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && getClass() == obj.getClass()) {
                KeyphraseRecognitionExtra keyphraseRecognitionExtra = (KeyphraseRecognitionExtra) obj;
                return Arrays.equals(this.confidenceLevels, keyphraseRecognitionExtra.confidenceLevels) && this.id == keyphraseRecognitionExtra.id && this.recognitionModes == keyphraseRecognitionExtra.recognitionModes && this.coarseConfidenceLevel == keyphraseRecognitionExtra.coarseConfidenceLevel;
            }
            return false;
        }

        public int hashCode() {
            return ((((((Arrays.hashCode(this.confidenceLevels) + 31) * 31) + this.id) * 31) + this.recognitionModes) * 31) + this.coarseConfidenceLevel;
        }

        public String toString() {
            return "KeyphraseRecognitionExtra [id=" + this.id + ", recognitionModes=" + this.recognitionModes + ", coarseConfidenceLevel=" + this.coarseConfidenceLevel + ", confidenceLevels=" + Arrays.toString(this.confidenceLevels) + "]";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.id);
            parcel.writeInt(this.recognitionModes);
            parcel.writeInt(this.coarseConfidenceLevel);
            parcel.writeTypedArray(this.confidenceLevels, i);
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/hardware/soundtrigger/SoundTrigger$KeyphraseSoundModel.class */
    public static class KeyphraseSoundModel extends SoundModel implements Parcelable {
        public static final Parcelable.Creator<KeyphraseSoundModel> CREATOR = new Parcelable.Creator<KeyphraseSoundModel>() { // from class: android.hardware.soundtrigger.SoundTrigger.KeyphraseSoundModel.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public KeyphraseSoundModel createFromParcel(Parcel parcel) {
                return KeyphraseSoundModel.fromParcel(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public KeyphraseSoundModel[] newArray(int i) {
                return new KeyphraseSoundModel[i];
            }
        };
        public final Keyphrase[] keyphrases;

        public KeyphraseSoundModel(UUID uuid, UUID uuid2, byte[] bArr, Keyphrase[] keyphraseArr) {
            super(uuid, uuid2, 0, bArr);
            this.keyphrases = keyphraseArr;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static KeyphraseSoundModel fromParcel(Parcel parcel) {
            UUID fromString = UUID.fromString(parcel.readString());
            UUID uuid = null;
            if (parcel.readInt() >= 0) {
                uuid = UUID.fromString(parcel.readString());
            }
            return new KeyphraseSoundModel(fromString, uuid, parcel.readBlob(), (Keyphrase[]) parcel.createTypedArray(Keyphrase.CREATOR));
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.hardware.soundtrigger.SoundTrigger.SoundModel
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return super.equals(obj) && (obj instanceof KeyphraseSoundModel) && Arrays.equals(this.keyphrases, ((KeyphraseSoundModel) obj).keyphrases);
        }

        @Override // android.hardware.soundtrigger.SoundTrigger.SoundModel
        public int hashCode() {
            return (super.hashCode() * 31) + Arrays.hashCode(this.keyphrases);
        }

        public String toString() {
            return "KeyphraseSoundModel [keyphrases=" + Arrays.toString(this.keyphrases) + ", uuid=" + this.uuid + ", vendorUuid=" + this.vendorUuid + ", type=" + this.type + ", data=" + (this.data == null ? 0 : this.data.length) + "]";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.uuid.toString());
            if (this.vendorUuid == null) {
                parcel.writeInt(-1);
            } else {
                parcel.writeInt(this.vendorUuid.toString().length());
                parcel.writeString(this.vendorUuid.toString());
            }
            parcel.writeBlob(this.data);
            parcel.writeTypedArray(this.keyphrases, i);
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/hardware/soundtrigger/SoundTrigger$ModuleProperties.class */
    public static class ModuleProperties implements Parcelable {
        public static final Parcelable.Creator<ModuleProperties> CREATOR = new Parcelable.Creator<ModuleProperties>() { // from class: android.hardware.soundtrigger.SoundTrigger.ModuleProperties.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public ModuleProperties createFromParcel(Parcel parcel) {
                return ModuleProperties.fromParcel(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public ModuleProperties[] newArray(int i) {
                return new ModuleProperties[i];
            }
        };
        public final String description;
        public final int id;
        public final String implementor;
        public final int maxBufferMs;
        public final int maxKeyphrases;
        public final int maxSoundModels;
        public final int maxUsers;
        public final int powerConsumptionMw;
        public final int recognitionModes;
        public final boolean returnsTriggerInEvent;
        public final boolean supportsCaptureTransition;
        public final boolean supportsConcurrentCapture;
        public final UUID uuid;
        public final int version;

        ModuleProperties(int i, String str, String str2, String str3, int i2, int i3, int i4, int i5, int i6, boolean z, int i7, boolean z2, int i8, boolean z3) {
            this.id = i;
            this.implementor = str;
            this.description = str2;
            this.uuid = UUID.fromString(str3);
            this.version = i2;
            this.maxSoundModels = i3;
            this.maxKeyphrases = i4;
            this.maxUsers = i5;
            this.recognitionModes = i6;
            this.supportsCaptureTransition = z;
            this.maxBufferMs = i7;
            this.supportsConcurrentCapture = z2;
            this.powerConsumptionMw = i8;
            this.returnsTriggerInEvent = z3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static ModuleProperties fromParcel(Parcel parcel) {
            return new ModuleProperties(parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readByte() == 1, parcel.readInt(), parcel.readByte() == 1, parcel.readInt(), parcel.readByte() == 1);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String toString() {
            return "ModuleProperties [id=" + this.id + ", implementor=" + this.implementor + ", description=" + this.description + ", uuid=" + this.uuid + ", version=" + this.version + ", maxSoundModels=" + this.maxSoundModels + ", maxKeyphrases=" + this.maxKeyphrases + ", maxUsers=" + this.maxUsers + ", recognitionModes=" + this.recognitionModes + ", supportsCaptureTransition=" + this.supportsCaptureTransition + ", maxBufferMs=" + this.maxBufferMs + ", supportsConcurrentCapture=" + this.supportsConcurrentCapture + ", powerConsumptionMw=" + this.powerConsumptionMw + ", returnsTriggerInEvent=" + this.returnsTriggerInEvent + "]";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.id);
            parcel.writeString(this.implementor);
            parcel.writeString(this.description);
            parcel.writeString(this.uuid.toString());
            parcel.writeInt(this.version);
            parcel.writeInt(this.maxSoundModels);
            parcel.writeInt(this.maxKeyphrases);
            parcel.writeInt(this.maxUsers);
            parcel.writeInt(this.recognitionModes);
            parcel.writeByte((byte) (this.supportsCaptureTransition ? 1 : 0));
            parcel.writeInt(this.maxBufferMs);
            parcel.writeByte((byte) (this.supportsConcurrentCapture ? 1 : 0));
            parcel.writeInt(this.powerConsumptionMw);
            parcel.writeByte((byte) (this.returnsTriggerInEvent ? 1 : 0));
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/hardware/soundtrigger/SoundTrigger$RecognitionConfig.class */
    public static class RecognitionConfig implements Parcelable {
        public static final Parcelable.Creator<RecognitionConfig> CREATOR = new Parcelable.Creator<RecognitionConfig>() { // from class: android.hardware.soundtrigger.SoundTrigger.RecognitionConfig.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public RecognitionConfig createFromParcel(Parcel parcel) {
                return RecognitionConfig.fromParcel(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public RecognitionConfig[] newArray(int i) {
                return new RecognitionConfig[i];
            }
        };
        public final boolean allowMultipleTriggers;
        public final boolean captureRequested;
        public final byte[] data;
        public final KeyphraseRecognitionExtra[] keyphrases;

        public RecognitionConfig(boolean z, boolean z2, KeyphraseRecognitionExtra[] keyphraseRecognitionExtraArr, byte[] bArr) {
            this.captureRequested = z;
            this.allowMultipleTriggers = z2;
            this.keyphrases = keyphraseRecognitionExtraArr;
            this.data = bArr;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static RecognitionConfig fromParcel(Parcel parcel) {
            return new RecognitionConfig(parcel.readByte() == 1, parcel.readByte() == 1, (KeyphraseRecognitionExtra[]) parcel.createTypedArray(KeyphraseRecognitionExtra.CREATOR), parcel.readBlob());
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String toString() {
            return "RecognitionConfig [captureRequested=" + this.captureRequested + ", allowMultipleTriggers=" + this.allowMultipleTriggers + ", keyphrases=" + Arrays.toString(this.keyphrases) + ", data=" + Arrays.toString(this.data) + "]";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeByte((byte) (this.captureRequested ? 1 : 0));
            parcel.writeByte((byte) (this.allowMultipleTriggers ? 1 : 0));
            parcel.writeTypedArray(this.keyphrases, i);
            parcel.writeBlob(this.data);
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/hardware/soundtrigger/SoundTrigger$RecognitionEvent.class */
    public static class RecognitionEvent implements Parcelable {
        public static final Parcelable.Creator<RecognitionEvent> CREATOR = new Parcelable.Creator<RecognitionEvent>() { // from class: android.hardware.soundtrigger.SoundTrigger.RecognitionEvent.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public RecognitionEvent createFromParcel(Parcel parcel) {
                return RecognitionEvent.fromParcel(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public RecognitionEvent[] newArray(int i) {
                return new RecognitionEvent[i];
            }
        };
        public final boolean captureAvailable;
        public final int captureDelayMs;
        public AudioFormat captureFormat;
        public final int capturePreambleMs;
        public final int captureSession;
        public final byte[] data;
        public final int soundModelHandle;
        public final int status;
        public final boolean triggerInData;

        public RecognitionEvent(int i, int i2, boolean z, int i3, int i4, int i5, boolean z2, AudioFormat audioFormat, byte[] bArr) {
            this.status = i;
            this.soundModelHandle = i2;
            this.captureAvailable = z;
            this.captureSession = i3;
            this.captureDelayMs = i4;
            this.capturePreambleMs = i5;
            this.triggerInData = z2;
            this.captureFormat = audioFormat;
            this.data = bArr;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static RecognitionEvent fromParcel(Parcel parcel) {
            int readInt = parcel.readInt();
            int readInt2 = parcel.readInt();
            boolean z = parcel.readByte() == 1;
            int readInt3 = parcel.readInt();
            int readInt4 = parcel.readInt();
            int readInt5 = parcel.readInt();
            boolean z2 = parcel.readByte() == 1;
            AudioFormat audioFormat = null;
            if (parcel.readByte() == 1) {
                audioFormat = new AudioFormat.Builder().setChannelMask(parcel.readInt()).setEncoding(parcel.readInt()).setSampleRate(parcel.readInt()).build();
            }
            return new RecognitionEvent(readInt, readInt2, z, readInt3, readInt4, readInt5, z2, audioFormat, parcel.readBlob());
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && getClass() == obj.getClass()) {
                RecognitionEvent recognitionEvent = (RecognitionEvent) obj;
                return this.captureAvailable == recognitionEvent.captureAvailable && this.captureDelayMs == recognitionEvent.captureDelayMs && this.capturePreambleMs == recognitionEvent.capturePreambleMs && this.captureSession == recognitionEvent.captureSession && Arrays.equals(this.data, recognitionEvent.data) && this.soundModelHandle == recognitionEvent.soundModelHandle && this.status == recognitionEvent.status && this.triggerInData == recognitionEvent.triggerInData && this.captureFormat.getSampleRate() == recognitionEvent.captureFormat.getSampleRate() && this.captureFormat.getEncoding() == recognitionEvent.captureFormat.getEncoding() && this.captureFormat.getChannelMask() == recognitionEvent.captureFormat.getChannelMask();
            }
            return false;
        }

        public int hashCode() {
            int i = 1231;
            int i2 = this.captureAvailable ? 1231 : 1237;
            int i3 = this.captureDelayMs;
            int i4 = this.capturePreambleMs;
            int i5 = this.captureSession;
            if (!this.triggerInData) {
                i = 1237;
            }
            int i6 = ((((((((i2 + 31) * 31) + i3) * 31) + i4) * 31) + i5) * 31) + i;
            int i7 = i6;
            if (this.captureFormat != null) {
                i7 = (((((i6 * 31) + this.captureFormat.getSampleRate()) * 31) + this.captureFormat.getEncoding()) * 31) + this.captureFormat.getChannelMask();
            }
            return (((((i7 * 31) + Arrays.hashCode(this.data)) * 31) + this.soundModelHandle) * 31) + this.status;
        }

        public String toString() {
            return "RecognitionEvent [status=" + this.status + ", soundModelHandle=" + this.soundModelHandle + ", captureAvailable=" + this.captureAvailable + ", captureSession=" + this.captureSession + ", captureDelayMs=" + this.captureDelayMs + ", capturePreambleMs=" + this.capturePreambleMs + ", triggerInData=" + this.triggerInData + (this.captureFormat == null ? "" : ", sampleRate=" + this.captureFormat.getSampleRate()) + (this.captureFormat == null ? "" : ", encoding=" + this.captureFormat.getEncoding()) + (this.captureFormat == null ? "" : ", channelMask=" + this.captureFormat.getChannelMask()) + ", data=" + (this.data == null ? 0 : this.data.length) + "]";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.status);
            parcel.writeInt(this.soundModelHandle);
            parcel.writeByte((byte) (this.captureAvailable ? 1 : 0));
            parcel.writeInt(this.captureSession);
            parcel.writeInt(this.captureDelayMs);
            parcel.writeInt(this.capturePreambleMs);
            parcel.writeByte((byte) (this.triggerInData ? 1 : 0));
            if (this.captureFormat != null) {
                parcel.writeByte((byte) 1);
                parcel.writeInt(this.captureFormat.getSampleRate());
                parcel.writeInt(this.captureFormat.getEncoding());
                parcel.writeInt(this.captureFormat.getChannelMask());
            } else {
                parcel.writeByte((byte) 0);
            }
            parcel.writeBlob(this.data);
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/hardware/soundtrigger/SoundTrigger$SoundModel.class */
    public static class SoundModel {
        public static final int TYPE_KEYPHRASE = 0;
        public static final int TYPE_UNKNOWN = -1;
        public final byte[] data;
        public final int type;
        public final UUID uuid;
        public final UUID vendorUuid;

        public SoundModel(UUID uuid, UUID uuid2, int i, byte[] bArr) {
            this.uuid = uuid;
            this.vendorUuid = uuid2;
            this.type = i;
            this.data = bArr;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && (obj instanceof SoundModel)) {
                SoundModel soundModel = (SoundModel) obj;
                if (Arrays.equals(this.data, soundModel.data) && this.type == soundModel.type) {
                    if (this.uuid == null) {
                        if (soundModel.uuid != null) {
                            return false;
                        }
                    } else if (!this.uuid.equals(soundModel.uuid)) {
                        return false;
                    }
                    return this.vendorUuid == null ? soundModel.vendorUuid == null : this.vendorUuid.equals(soundModel.vendorUuid);
                }
                return false;
            }
            return false;
        }

        public int hashCode() {
            int i = 0;
            int hashCode = Arrays.hashCode(this.data);
            int i2 = this.type;
            int hashCode2 = this.uuid == null ? 0 : this.uuid.hashCode();
            if (this.vendorUuid != null) {
                i = this.vendorUuid.hashCode();
            }
            return ((((((hashCode + 31) * 31) + i2) * 31) + hashCode2) * 31) + i;
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/hardware/soundtrigger/SoundTrigger$SoundModelEvent.class */
    public static class SoundModelEvent implements Parcelable {
        public static final Parcelable.Creator<SoundModelEvent> CREATOR = new Parcelable.Creator<SoundModelEvent>() { // from class: android.hardware.soundtrigger.SoundTrigger.SoundModelEvent.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SoundModelEvent createFromParcel(Parcel parcel) {
                return SoundModelEvent.fromParcel(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SoundModelEvent[] newArray(int i) {
                return new SoundModelEvent[i];
            }
        };
        public final byte[] data;
        public final int soundModelHandle;
        public final int status;

        SoundModelEvent(int i, int i2, byte[] bArr) {
            this.status = i;
            this.soundModelHandle = i2;
            this.data = bArr;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static SoundModelEvent fromParcel(Parcel parcel) {
            return new SoundModelEvent(parcel.readInt(), parcel.readInt(), parcel.readBlob());
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && getClass() == obj.getClass()) {
                SoundModelEvent soundModelEvent = (SoundModelEvent) obj;
                return Arrays.equals(this.data, soundModelEvent.data) && this.soundModelHandle == soundModelEvent.soundModelHandle && this.status == soundModelEvent.status;
            }
            return false;
        }

        public int hashCode() {
            return ((((Arrays.hashCode(this.data) + 31) * 31) + this.soundModelHandle) * 31) + this.status;
        }

        public String toString() {
            return "SoundModelEvent [status=" + this.status + ", soundModelHandle=" + this.soundModelHandle + ", data=" + (this.data == null ? 0 : this.data.length) + "]";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.status);
            parcel.writeInt(this.soundModelHandle);
            parcel.writeBlob(this.data);
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/hardware/soundtrigger/SoundTrigger$StatusListener.class */
    public interface StatusListener {
        void onRecognition(RecognitionEvent recognitionEvent);

        void onServiceDied();

        void onServiceStateChange(int i);

        void onSoundModelUpdate(SoundModelEvent soundModelEvent);
    }

    public static SoundTriggerModule attachModule(int i, StatusListener statusListener, Handler handler) {
        if (statusListener == null) {
            return null;
        }
        return new SoundTriggerModule(i, statusListener, handler);
    }

    public static native int listModules(ArrayList<ModuleProperties> arrayList);
}
