package androidx.media;

import androidx.versionedparcelable.VersionedParcel;

/* loaded from: source-8756600-dex2jar.jar:androidx/media/AudioAttributesImplBaseParcelizer.class */
public final class AudioAttributesImplBaseParcelizer {
    public static AudioAttributesImplBase read(VersionedParcel versionedParcel) {
        AudioAttributesImplBase audioAttributesImplBase = new AudioAttributesImplBase();
        audioAttributesImplBase.f3058a = versionedParcel.readInt(audioAttributesImplBase.f3058a, 1);
        audioAttributesImplBase.b = versionedParcel.readInt(audioAttributesImplBase.b, 2);
        audioAttributesImplBase.f3059c = versionedParcel.readInt(audioAttributesImplBase.f3059c, 3);
        audioAttributesImplBase.d = versionedParcel.readInt(audioAttributesImplBase.d, 4);
        return audioAttributesImplBase;
    }

    public static void write(AudioAttributesImplBase audioAttributesImplBase, VersionedParcel versionedParcel) {
        versionedParcel.setSerializationFlags(false, false);
        versionedParcel.writeInt(audioAttributesImplBase.f3058a, 1);
        versionedParcel.writeInt(audioAttributesImplBase.b, 2);
        versionedParcel.writeInt(audioAttributesImplBase.f3059c, 3);
        versionedParcel.writeInt(audioAttributesImplBase.d, 4);
    }
}
