package android.print;

import android.os.Parcel;
import android.os.Parcelable;
import android.print.PrintAttributes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* loaded from: source-9557208-dex2jar.jar:android/print/PrinterCapabilitiesInfo.class */
public final class PrinterCapabilitiesInfo implements Parcelable {
    public static final int DEFAULT_UNDEFINED = -1;
    private static final int PROPERTY_COLOR_MODE = 2;
    private static final int PROPERTY_COUNT = 3;
    private static final int PROPERTY_MEDIA_SIZE = 0;
    private static final int PROPERTY_RESOLUTION = 1;
    private int mColorModes;
    private final int[] mDefaults;
    private List<PrintAttributes.MediaSize> mMediaSizes;
    private PrintAttributes.Margins mMinMargins;
    private List<PrintAttributes.Resolution> mResolutions;
    private static final PrintAttributes.Margins DEFAULT_MARGINS = new PrintAttributes.Margins(0, 0, 0, 0);
    public static final Parcelable.Creator<PrinterCapabilitiesInfo> CREATOR = new Parcelable.Creator<PrinterCapabilitiesInfo>() { // from class: android.print.PrinterCapabilitiesInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PrinterCapabilitiesInfo createFromParcel(Parcel parcel) {
            return new PrinterCapabilitiesInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PrinterCapabilitiesInfo[] newArray(int i) {
            return new PrinterCapabilitiesInfo[i];
        }
    };

    /* loaded from: source-9557208-dex2jar.jar:android/print/PrinterCapabilitiesInfo$Builder.class */
    public static final class Builder {
        private final PrinterCapabilitiesInfo mPrototype;

        public Builder(PrinterId printerId) {
            if (printerId == null) {
                throw new IllegalArgumentException("printerId cannot be null.");
            }
            this.mPrototype = new PrinterCapabilitiesInfo();
        }

        private void throwIfDefaultAlreadySpecified(int i) {
            if (this.mPrototype.mDefaults[i] != -1) {
                throw new IllegalArgumentException("Default already specified.");
            }
        }

        public Builder addMediaSize(PrintAttributes.MediaSize mediaSize, boolean z) {
            if (this.mPrototype.mMediaSizes == null) {
                this.mPrototype.mMediaSizes = new ArrayList();
            }
            int size = this.mPrototype.mMediaSizes.size();
            this.mPrototype.mMediaSizes.add(mediaSize);
            if (z) {
                throwIfDefaultAlreadySpecified(0);
                this.mPrototype.mDefaults[0] = size;
            }
            return this;
        }

        public Builder addResolution(PrintAttributes.Resolution resolution, boolean z) {
            if (this.mPrototype.mResolutions == null) {
                this.mPrototype.mResolutions = new ArrayList();
            }
            int size = this.mPrototype.mResolutions.size();
            this.mPrototype.mResolutions.add(resolution);
            if (z) {
                throwIfDefaultAlreadySpecified(1);
                this.mPrototype.mDefaults[1] = size;
            }
            return this;
        }

        public PrinterCapabilitiesInfo build() {
            if (this.mPrototype.mMediaSizes == null || this.mPrototype.mMediaSizes.isEmpty()) {
                throw new IllegalStateException("No media size specified.");
            }
            if (this.mPrototype.mDefaults[0] == -1) {
                throw new IllegalStateException("No default media size specified.");
            }
            if (this.mPrototype.mResolutions == null || this.mPrototype.mResolutions.isEmpty()) {
                throw new IllegalStateException("No resolution specified.");
            }
            if (this.mPrototype.mDefaults[1] == -1) {
                throw new IllegalStateException("No default resolution specified.");
            }
            if (this.mPrototype.mColorModes == 0) {
                throw new IllegalStateException("No color mode specified.");
            }
            if (this.mPrototype.mDefaults[2] == -1) {
                throw new IllegalStateException("No default color mode specified.");
            }
            if (this.mPrototype.mMinMargins == null) {
                throw new IllegalArgumentException("margins cannot be null");
            }
            return this.mPrototype;
        }

        public Builder setColorModes(int i, int i2) {
            int i3 = i;
            while (i3 > 0) {
                int numberOfTrailingZeros = 1 << Integer.numberOfTrailingZeros(i3);
                i3 &= numberOfTrailingZeros ^ (-1);
                PrintAttributes.enforceValidColorMode(numberOfTrailingZeros);
            }
            if ((i & i2) == 0) {
                throw new IllegalArgumentException("Default color mode not in color modes.");
            }
            PrintAttributes.enforceValidColorMode(i);
            this.mPrototype.mColorModes = i;
            this.mPrototype.mDefaults[2] = i2;
            return this;
        }

        public Builder setMinMargins(PrintAttributes.Margins margins) {
            if (margins == null) {
                throw new IllegalArgumentException("margins cannot be null");
            }
            this.mPrototype.mMinMargins = margins;
            return this;
        }
    }

    public PrinterCapabilitiesInfo() {
        this.mMinMargins = DEFAULT_MARGINS;
        this.mDefaults = new int[3];
        Arrays.fill(this.mDefaults, -1);
    }

    private PrinterCapabilitiesInfo(Parcel parcel) {
        this.mMinMargins = DEFAULT_MARGINS;
        this.mDefaults = new int[3];
        this.mMinMargins = readMargins(parcel);
        readMediaSizes(parcel);
        readResolutions(parcel);
        this.mColorModes = parcel.readInt();
        readDefaults(parcel);
    }

    public PrinterCapabilitiesInfo(PrinterCapabilitiesInfo printerCapabilitiesInfo) {
        this.mMinMargins = DEFAULT_MARGINS;
        this.mDefaults = new int[3];
        copyFrom(printerCapabilitiesInfo);
    }

    private String colorModesToString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        int i = this.mColorModes;
        while (i != 0) {
            int numberOfTrailingZeros = 1 << Integer.numberOfTrailingZeros(i);
            i &= numberOfTrailingZeros ^ (-1);
            if (sb.length() > 1) {
                sb.append(", ");
            }
            sb.append(PrintAttributes.colorModeToString(numberOfTrailingZeros));
        }
        sb.append(']');
        return sb.toString();
    }

    private void readDefaults(Parcel parcel) {
        int readInt = parcel.readInt();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= readInt) {
                return;
            }
            this.mDefaults[i2] = parcel.readInt();
            i = i2 + 1;
        }
    }

    private PrintAttributes.Margins readMargins(Parcel parcel) {
        if (parcel.readInt() == 1) {
            return PrintAttributes.Margins.createFromParcel(parcel);
        }
        return null;
    }

    private void readMediaSizes(Parcel parcel) {
        int readInt = parcel.readInt();
        if (readInt > 0 && this.mMediaSizes == null) {
            this.mMediaSizes = new ArrayList();
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= readInt) {
                return;
            }
            this.mMediaSizes.add(PrintAttributes.MediaSize.createFromParcel(parcel));
            i = i2 + 1;
        }
    }

    private void readResolutions(Parcel parcel) {
        int readInt = parcel.readInt();
        if (readInt > 0 && this.mResolutions == null) {
            this.mResolutions = new ArrayList();
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= readInt) {
                return;
            }
            this.mResolutions.add(PrintAttributes.Resolution.createFromParcel(parcel));
            i = i2 + 1;
        }
    }

    private void writeDefaults(Parcel parcel) {
        int length = this.mDefaults.length;
        parcel.writeInt(length);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            parcel.writeInt(this.mDefaults[i2]);
            i = i2 + 1;
        }
    }

    private void writeMargins(PrintAttributes.Margins margins, Parcel parcel) {
        if (margins == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        margins.writeToParcel(parcel);
    }

    private void writeMediaSizes(Parcel parcel) {
        if (this.mMediaSizes == null) {
            parcel.writeInt(0);
            return;
        }
        int size = this.mMediaSizes.size();
        parcel.writeInt(size);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return;
            }
            this.mMediaSizes.get(i2).writeToParcel(parcel);
            i = i2 + 1;
        }
    }

    private void writeResolutions(Parcel parcel) {
        if (this.mResolutions == null) {
            parcel.writeInt(0);
            return;
        }
        int size = this.mResolutions.size();
        parcel.writeInt(size);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return;
            }
            this.mResolutions.get(i2).writeToParcel(parcel);
            i = i2 + 1;
        }
    }

    public void copyFrom(PrinterCapabilitiesInfo printerCapabilitiesInfo) {
        if (this == printerCapabilitiesInfo) {
            return;
        }
        this.mMinMargins = printerCapabilitiesInfo.mMinMargins;
        if (printerCapabilitiesInfo.mMediaSizes == null) {
            this.mMediaSizes = null;
        } else if (this.mMediaSizes != null) {
            this.mMediaSizes.clear();
            this.mMediaSizes.addAll(printerCapabilitiesInfo.mMediaSizes);
        } else {
            this.mMediaSizes = new ArrayList(printerCapabilitiesInfo.mMediaSizes);
        }
        if (printerCapabilitiesInfo.mResolutions == null) {
            this.mResolutions = null;
        } else if (this.mResolutions != null) {
            this.mResolutions.clear();
            this.mResolutions.addAll(printerCapabilitiesInfo.mResolutions);
        } else {
            this.mResolutions = new ArrayList(printerCapabilitiesInfo.mResolutions);
        }
        this.mColorModes = printerCapabilitiesInfo.mColorModes;
        int length = printerCapabilitiesInfo.mDefaults.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            this.mDefaults[i2] = printerCapabilitiesInfo.mDefaults[i2];
            i = i2 + 1;
        }
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
            PrinterCapabilitiesInfo printerCapabilitiesInfo = (PrinterCapabilitiesInfo) obj;
            if (this.mMinMargins == null) {
                if (printerCapabilitiesInfo.mMinMargins != null) {
                    return false;
                }
            } else if (!this.mMinMargins.equals(printerCapabilitiesInfo.mMinMargins)) {
                return false;
            }
            if (this.mMediaSizes == null) {
                if (printerCapabilitiesInfo.mMediaSizes != null) {
                    return false;
                }
            } else if (!this.mMediaSizes.equals(printerCapabilitiesInfo.mMediaSizes)) {
                return false;
            }
            if (this.mResolutions == null) {
                if (printerCapabilitiesInfo.mResolutions != null) {
                    return false;
                }
            } else if (!this.mResolutions.equals(printerCapabilitiesInfo.mResolutions)) {
                return false;
            }
            return this.mColorModes == printerCapabilitiesInfo.mColorModes && Arrays.equals(this.mDefaults, printerCapabilitiesInfo.mDefaults);
        }
        return false;
    }

    public int getColorModes() {
        return this.mColorModes;
    }

    public PrintAttributes getDefaults() {
        PrintAttributes.Builder builder = new PrintAttributes.Builder();
        builder.setMinMargins(this.mMinMargins);
        int i = this.mDefaults[0];
        if (i >= 0) {
            builder.setMediaSize(this.mMediaSizes.get(i));
        }
        int i2 = this.mDefaults[1];
        if (i2 >= 0) {
            builder.setResolution(this.mResolutions.get(i2));
        }
        int i3 = this.mDefaults[2];
        if (i3 > 0) {
            builder.setColorMode(i3);
        }
        return builder.build();
    }

    public List<PrintAttributes.MediaSize> getMediaSizes() {
        return Collections.unmodifiableList(this.mMediaSizes);
    }

    public PrintAttributes.Margins getMinMargins() {
        return this.mMinMargins;
    }

    public List<PrintAttributes.Resolution> getResolutions() {
        return Collections.unmodifiableList(this.mResolutions);
    }

    public int hashCode() {
        int i = 0;
        int hashCode = this.mMinMargins == null ? 0 : this.mMinMargins.hashCode();
        int hashCode2 = this.mMediaSizes == null ? 0 : this.mMediaSizes.hashCode();
        if (this.mResolutions != null) {
            i = this.mResolutions.hashCode();
        }
        return ((((((((hashCode + 31) * 31) + hashCode2) * 31) + i) * 31) + this.mColorModes) * 31) + Arrays.hashCode(this.mDefaults);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PrinterInfo{");
        sb.append("minMargins=").append(this.mMinMargins);
        sb.append(", mediaSizes=").append(this.mMediaSizes);
        sb.append(", resolutions=").append(this.mResolutions);
        sb.append(", colorModes=").append(colorModesToString());
        sb.append("\"}");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        writeMargins(this.mMinMargins, parcel);
        writeMediaSizes(parcel);
        writeResolutions(parcel);
        parcel.writeInt(this.mColorModes);
        writeDefaults(parcel);
    }
}
