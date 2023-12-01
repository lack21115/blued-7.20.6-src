package android.app.usage;

import android.content.res.Configuration;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.List;

/* loaded from: source-9557208-dex2jar.jar:android/app/usage/UsageEvents.class */
public final class UsageEvents implements Parcelable {
    public static final Parcelable.Creator<UsageEvents> CREATOR = new Parcelable.Creator<UsageEvents>() { // from class: android.app.usage.UsageEvents.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public UsageEvents createFromParcel(Parcel parcel) {
            return new UsageEvents(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public UsageEvents[] newArray(int i) {
            return new UsageEvents[i];
        }
    };
    private final int mEventCount;
    private List<Event> mEventsToWrite;
    private int mIndex;
    private Parcel mParcel;
    private String[] mStringPool;

    /* loaded from: source-9557208-dex2jar.jar:android/app/usage/UsageEvents$Event.class */
    public static final class Event {
        public static final int CONFIGURATION_CHANGE = 5;
        public static final int CONTINUE_PREVIOUS_DAY = 4;
        public static final int END_OF_DAY = 3;
        public static final int MOVE_TO_BACKGROUND = 2;
        public static final int MOVE_TO_FOREGROUND = 1;
        public static final int NONE = 0;
        public String mClass;
        public Configuration mConfiguration;
        public int mEventType;
        public String mPackage;
        public long mTimeStamp;

        public String getClassName() {
            return this.mClass;
        }

        public Configuration getConfiguration() {
            return this.mConfiguration;
        }

        public int getEventType() {
            return this.mEventType;
        }

        public String getPackageName() {
            return this.mPackage;
        }

        public long getTimeStamp() {
            return this.mTimeStamp;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public UsageEvents() {
        this.mEventsToWrite = null;
        this.mParcel = null;
        this.mIndex = 0;
        this.mEventCount = 0;
    }

    public UsageEvents(Parcel parcel) {
        this.mEventsToWrite = null;
        this.mParcel = null;
        this.mIndex = 0;
        this.mEventCount = parcel.readInt();
        this.mIndex = parcel.readInt();
        if (this.mEventCount > 0) {
            this.mStringPool = parcel.createStringArray();
            int readInt = parcel.readInt();
            int readInt2 = parcel.readInt();
            this.mParcel = Parcel.obtain();
            this.mParcel.setDataPosition(0);
            this.mParcel.appendFrom(parcel, parcel.dataPosition(), readInt);
            this.mParcel.setDataSize(this.mParcel.dataPosition());
            this.mParcel.setDataPosition(readInt2);
        }
    }

    public UsageEvents(List<Event> list, String[] strArr) {
        this.mEventsToWrite = null;
        this.mParcel = null;
        this.mIndex = 0;
        this.mStringPool = strArr;
        this.mEventCount = list.size();
        this.mEventsToWrite = list;
    }

    private int findStringIndex(String str) {
        int binarySearch = Arrays.binarySearch(this.mStringPool, str);
        if (binarySearch < 0) {
            throw new IllegalStateException("String '" + str + "' is not in the string pool");
        }
        return binarySearch;
    }

    private void readEventFromParcel(Parcel parcel, Event event) {
        int readInt = parcel.readInt();
        if (readInt >= 0) {
            event.mPackage = this.mStringPool[readInt];
        } else {
            event.mPackage = null;
        }
        int readInt2 = parcel.readInt();
        if (readInt2 >= 0) {
            event.mClass = this.mStringPool[readInt2];
        } else {
            event.mClass = null;
        }
        event.mEventType = parcel.readInt();
        event.mTimeStamp = parcel.readLong();
        if (event.mEventType == 5) {
            event.mConfiguration = Configuration.CREATOR.createFromParcel(parcel);
        } else {
            event.mConfiguration = null;
        }
    }

    private void writeEventToParcel(Event event, Parcel parcel, int i) {
        int findStringIndex = event.mPackage != null ? findStringIndex(event.mPackage) : -1;
        int findStringIndex2 = event.mClass != null ? findStringIndex(event.mClass) : -1;
        parcel.writeInt(findStringIndex);
        parcel.writeInt(findStringIndex2);
        parcel.writeInt(event.mEventType);
        parcel.writeLong(event.mTimeStamp);
        if (event.mEventType == 5) {
            event.mConfiguration.writeToParcel(parcel, i);
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    protected void finalize() throws Throwable {
        super.finalize();
        if (this.mParcel != null) {
            this.mParcel.recycle();
            this.mParcel = null;
        }
    }

    public boolean getNextEvent(Event event) {
        if (this.mIndex >= this.mEventCount) {
            return false;
        }
        readEventFromParcel(this.mParcel, event);
        this.mIndex++;
        if (this.mIndex >= this.mEventCount) {
            this.mParcel.recycle();
            this.mParcel = null;
            return true;
        }
        return true;
    }

    public boolean hasNextEvent() {
        return this.mIndex < this.mEventCount;
    }

    public void resetToStart() {
        this.mIndex = 0;
        if (this.mParcel != null) {
            this.mParcel.setDataPosition(0);
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mEventCount);
        parcel.writeInt(this.mIndex);
        if (this.mEventCount <= 0) {
            return;
        }
        parcel.writeStringArray(this.mStringPool);
        if (this.mEventsToWrite == null) {
            if (this.mParcel == null) {
                throw new IllegalStateException("Either mParcel or mEventsToWrite must not be null");
            }
            parcel.writeInt(this.mParcel.dataSize());
            parcel.writeInt(this.mParcel.dataPosition());
            parcel.appendFrom(this.mParcel, 0, this.mParcel.dataSize());
            return;
        }
        Parcel obtain = Parcel.obtain();
        try {
            obtain.setDataPosition(0);
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= this.mEventCount) {
                    int dataPosition = obtain.dataPosition();
                    parcel.writeInt(dataPosition);
                    parcel.writeInt(0);
                    parcel.appendFrom(obtain, 0, dataPosition);
                    return;
                }
                writeEventToParcel(this.mEventsToWrite.get(i3), obtain, i);
                i2 = i3 + 1;
            }
        } finally {
            obtain.recycle();
        }
    }
}
