package android.hardware.fingerprint;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.JsonReader;
import android.util.JsonToken;
import android.util.JsonWriter;
import java.io.IOException;

/* loaded from: source-9557208-dex2jar.jar:android/hardware/fingerprint/Fingerprint.class */
public class Fingerprint implements Parcelable {
    private int mFingerId;
    private String mName;
    private int mUserId;
    private static final String TAG = Fingerprint.class.getSimpleName();
    public static final Parcelable.Creator<Fingerprint> CREATOR = new Parcelable.Creator<Fingerprint>() { // from class: android.hardware.fingerprint.Fingerprint.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Fingerprint createFromParcel(Parcel parcel) {
            return new Fingerprint(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Fingerprint[] newArray(int i) {
            return new Fingerprint[i];
        }
    };

    /* loaded from: source-9557208-dex2jar.jar:android/hardware/fingerprint/Fingerprint$Builder.class */
    public static class Builder {
        private Integer mId;
        private String mName;
        private Integer mUserId;

        public Builder(Fingerprint fingerprint) {
            this.mName = fingerprint.getName();
            this.mId = fingerprint.getFingerId();
            this.mUserId = fingerprint.getUserId();
        }

        public Fingerprint build() {
            return new Fingerprint(this.mName, this.mId, this.mUserId);
        }

        public Builder id(int i) {
            this.mId = Integer.valueOf(i);
            return this;
        }

        public Builder name(String str) {
            this.mName = str;
            return this;
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/hardware/fingerprint/Fingerprint$JsonSerializer.class */
    public static class JsonSerializer {
        private static final String NAME_FINGERNAME = "fingerName";
        private static final String NAME_ID = "fingerId";
        private static final String NAME_USERID = "userId";

        /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
            jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
            	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:35)
            	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
            	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:202)
            	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:45)
            	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
            */
        public static java.util.List<android.hardware.fingerprint.Fingerprint> fromJson(java.lang.String r4) {
            /*
                Method dump skipped, instructions count: 257
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: android.hardware.fingerprint.Fingerprint.JsonSerializer.fromJson(java.lang.String):java.util.List");
        }

        private static Fingerprint readFingerprint(JsonReader jsonReader) throws IOException {
            String str = null;
            int i = 0;
            int i2 = 0;
            jsonReader.beginObject();
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                if (NAME_ID.equals(nextName) && jsonReader.peek() != JsonToken.NULL) {
                    i = jsonReader.nextInt();
                } else if (NAME_FINGERNAME.equals(nextName) && jsonReader.peek() != JsonToken.NULL) {
                    str = jsonReader.nextString();
                } else if ("userId".equals(nextName)) {
                    i2 = jsonReader.nextInt();
                } else {
                    jsonReader.skipValue();
                }
            }
            jsonReader.endObject();
            return new Fingerprint(str, Integer.valueOf(i), Integer.valueOf(i2));
        }

        /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
            jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
            	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:35)
            	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
            	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:202)
            	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:45)
            	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
            */
        public static java.lang.String toJson(java.util.List<android.hardware.fingerprint.Fingerprint> r4) {
            /*
                Method dump skipped, instructions count: 304
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: android.hardware.fingerprint.Fingerprint.JsonSerializer.toJson(java.util.List):java.lang.String");
        }

        private static void writeFingerprint(JsonWriter jsonWriter, Fingerprint fingerprint) throws IOException {
            jsonWriter.beginObject();
            jsonWriter.name(NAME_ID).value(fingerprint.getFingerId());
            jsonWriter.name(NAME_FINGERNAME).value(fingerprint.getName());
            jsonWriter.name("userId").value(fingerprint.getUserId());
            jsonWriter.endObject();
        }
    }

    public Fingerprint() {
    }

    private Fingerprint(Parcel parcel) {
        this.mName = parcel.readString();
        this.mFingerId = parcel.readInt();
        this.mUserId = parcel.readInt();
    }

    public Fingerprint(String str, Integer num, Integer num2) {
        this.mName = str;
        this.mFingerId = num.intValue();
        this.mUserId = num2.intValue();
    }

    static /* synthetic */ String access$100() {
        return TAG;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Integer getFingerId() {
        return Integer.valueOf(this.mFingerId);
    }

    public String getName() {
        return this.mName;
    }

    public Integer getUserId() {
        return Integer.valueOf(this.mUserId);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mName);
        parcel.writeInt(this.mFingerId);
        parcel.writeInt(this.mUserId);
    }
}
