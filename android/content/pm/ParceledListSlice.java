package android.content.pm;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-9557208-dex2jar.jar:android/content/pm/ParceledListSlice.class */
public class ParceledListSlice<T extends Parcelable> implements Parcelable {
    private static final int MAX_FIRST_IPC_SIZE = 131072;
    private static final int MAX_IPC_SIZE = 262144;
    private final List<T> mList;
    private static String TAG = "ParceledListSlice";
    private static boolean DEBUG = false;
    public static final Parcelable.ClassLoaderCreator<ParceledListSlice> CREATOR = new Parcelable.ClassLoaderCreator<ParceledListSlice>() { // from class: android.content.pm.ParceledListSlice.2
        @Override // android.os.Parcelable.Creator
        public ParceledListSlice createFromParcel(Parcel parcel) {
            return new ParceledListSlice(parcel, null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.ClassLoaderCreator
        public ParceledListSlice createFromParcel(Parcel parcel, ClassLoader classLoader) {
            return new ParceledListSlice(parcel, classLoader);
        }

        @Override // android.os.Parcelable.Creator
        public ParceledListSlice[] newArray(int i) {
            return new ParceledListSlice[i];
        }
    };

    /* JADX WARN: Multi-variable type inference failed */
    private ParceledListSlice(Parcel parcel, ClassLoader classLoader) {
        int i;
        int readInt = parcel.readInt();
        this.mList = new ArrayList(readInt);
        if (DEBUG) {
            Log.d(TAG, "Retrieving " + readInt + " items");
        }
        if (readInt <= 0) {
            return;
        }
        Parcelable.Creator<T> readParcelableCreator = parcel.readParcelableCreator(classLoader);
        Class<?> cls = null;
        int i2 = 0;
        while (true) {
            i = i2;
            if (i >= readInt || parcel.readInt() == 0) {
                break;
            }
            Parcelable readCreator = parcel.readCreator(readParcelableCreator, classLoader);
            if (cls == null) {
                cls = readCreator.getClass();
            } else {
                verifySameType(cls, readCreator.getClass());
            }
            this.mList.add(readCreator);
            if (DEBUG) {
                Log.d(TAG, "Read inline #" + i + ": " + this.mList.get(this.mList.size() - 1));
            }
            i2 = i + 1;
        }
        if (i < readInt) {
            IBinder readStrongBinder = parcel.readStrongBinder();
            while (i < readInt) {
                if (DEBUG) {
                    Log.d(TAG, "Reading more @" + i + " of " + readInt + ": retriever=" + readStrongBinder);
                }
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                obtain.writeInt(i);
                try {
                    readStrongBinder.transact(1, obtain, obtain2, 0);
                    while (i < readInt && obtain2.readInt() != 0) {
                        Parcelable readCreator2 = obtain2.readCreator(readParcelableCreator, classLoader);
                        verifySameType(cls, readCreator2.getClass());
                        this.mList.add(readCreator2);
                        if (DEBUG) {
                            Log.d(TAG, "Read extra #" + i + ": " + this.mList.get(this.mList.size() - 1));
                        }
                        i++;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                } catch (RemoteException e) {
                    Log.w(TAG, "Failure retrieving array; only received " + i + " of " + readInt, e);
                    return;
                }
            }
        }
    }

    public ParceledListSlice(List<T> list) {
        this.mList = list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void verifySameType(Class<?> cls, Class<?> cls2) {
        if (!cls2.equals(cls)) {
            throw new IllegalArgumentException("Can't unparcel type " + cls2.getName() + " in list of type " + cls.getName());
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.mList.size()) {
                return i;
            }
            i |= this.mList.get(i3).describeContents();
            i2 = i3 + 1;
        }
    }

    public List<T> getList() {
        return this.mList;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, final int i) {
        int i2;
        final int size = this.mList.size();
        parcel.writeInt(size);
        if (DEBUG) {
            Log.d(TAG, "Writing " + size + " items");
        }
        if (size > 0) {
            final Class<?> cls = this.mList.get(0).getClass();
            parcel.writeParcelableCreator(this.mList.get(0));
            int i3 = 0;
            while (true) {
                i2 = i3;
                if (i2 >= size || parcel.dataSize() >= 131072) {
                    break;
                }
                parcel.writeInt(1);
                T t = this.mList.get(i2);
                verifySameType(cls, t.getClass());
                t.writeToParcel(parcel, i);
                if (DEBUG) {
                    Log.d(TAG, "Wrote inline #" + i2 + ": " + this.mList.get(i2));
                }
                i3 = i2 + 1;
            }
            if (i2 < size) {
                parcel.writeInt(0);
                Binder binder = new Binder() { // from class: android.content.pm.ParceledListSlice.1
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // android.os.Binder
                    public boolean onTransact(int i4, Parcel parcel2, Parcel parcel3, int i5) throws RemoteException {
                        boolean z = true;
                        if (i4 != 1) {
                            z = super.onTransact(i4, parcel2, parcel3, i5);
                        } else {
                            int readInt = parcel2.readInt();
                            int i6 = readInt;
                            if (ParceledListSlice.DEBUG) {
                                Log.d(ParceledListSlice.TAG, "Writing more @" + readInt + " of " + size);
                                i6 = readInt;
                            }
                            while (i6 < size && parcel3.dataSize() < 262144) {
                                parcel3.writeInt(1);
                                Parcelable parcelable = (Parcelable) ParceledListSlice.this.mList.get(i6);
                                ParceledListSlice.verifySameType(cls, parcelable.getClass());
                                parcelable.writeToParcel(parcel3, i);
                                if (ParceledListSlice.DEBUG) {
                                    Log.d(ParceledListSlice.TAG, "Wrote extra #" + i6 + ": " + ParceledListSlice.this.mList.get(i6));
                                }
                                i6++;
                            }
                            if (i6 < size) {
                                if (ParceledListSlice.DEBUG) {
                                    Log.d(ParceledListSlice.TAG, "Breaking @" + i6 + " of " + size);
                                }
                                parcel3.writeInt(0);
                                return true;
                            }
                        }
                        return z;
                    }
                };
                if (DEBUG) {
                    Log.d(TAG, "Breaking @" + i2 + " of " + size + ": retriever=" + binder);
                }
                parcel.writeStrongBinder(binder);
            }
        }
    }
}
