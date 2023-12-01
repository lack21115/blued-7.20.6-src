package android.content;

import android.content.res.AssetFileDescriptor;
import android.database.BulkCursorDescriptor;
import android.database.Cursor;
import android.database.CursorToBulkCursorAdaptor;
import android.database.DatabaseUtils;
import android.database.IContentObserver;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.ICancellationSignal;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import java.util.ArrayList;

/* loaded from: source-9557208-dex2jar.jar:android/content/ContentProviderNative.class */
public abstract class ContentProviderNative extends Binder implements IContentProvider {
    public ContentProviderNative() {
        attachInterface(this, IContentProvider.descriptor);
    }

    public static IContentProvider asInterface(IBinder iBinder) {
        IContentProvider iContentProvider;
        if (iBinder == null) {
            iContentProvider = null;
        } else {
            IContentProvider iContentProvider2 = (IContentProvider) iBinder.queryLocalInterface(IContentProvider.descriptor);
            iContentProvider = iContentProvider2;
            if (iContentProvider2 == null) {
                return new ContentProviderProxy(iBinder);
            }
        }
        return iContentProvider;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this;
    }

    public abstract String getProviderName();

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v141, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r9v0, types: [android.os.Binder, android.content.ContentProviderNative] */
    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        CursorToBulkCursorAdaptor cursorToBulkCursorAdaptor;
        Cursor th;
        try {
            switch (i) {
                case 1:
                    parcel.enforceInterface(IContentProvider.descriptor);
                    String readString = parcel.readString();
                    Uri createFromParcel = Uri.CREATOR.createFromParcel(parcel);
                    int readInt = parcel.readInt();
                    String[] strArr = null;
                    if (readInt > 0) {
                        String[] strArr2 = new String[readInt];
                        int i3 = 0;
                        while (true) {
                            int i4 = i3;
                            strArr = strArr2;
                            if (i4 < readInt) {
                                strArr2[i4] = parcel.readString();
                                i3 = i4 + 1;
                            }
                        }
                    }
                    String readString2 = parcel.readString();
                    int readInt2 = parcel.readInt();
                    String[] strArr3 = null;
                    if (readInt2 > 0) {
                        String[] strArr4 = new String[readInt2];
                        int i5 = 0;
                        while (true) {
                            int i6 = i5;
                            strArr3 = strArr4;
                            if (i6 < readInt2) {
                                strArr4[i6] = parcel.readString();
                                i5 = i6 + 1;
                            }
                        }
                    }
                    String readString3 = parcel.readString();
                    IContentObserver asInterface = IContentObserver.Stub.asInterface(parcel.readStrongBinder());
                    Cursor query = query(readString, createFromParcel, strArr, readString2, strArr3, readString3, ICancellationSignal.Stub.asInterface(parcel.readStrongBinder()));
                    if (query == null) {
                        parcel2.writeNoException();
                        parcel2.writeInt(0);
                        return true;
                    }
                    Cursor cursor = query;
                    try {
                        cursorToBulkCursorAdaptor = new CursorToBulkCursorAdaptor(query, asInterface, getProviderName());
                        cursor = null;
                        try {
                            BulkCursorDescriptor bulkCursorDescriptor = cursorToBulkCursorAdaptor.getBulkCursorDescriptor();
                            parcel2.writeNoException();
                            parcel2.writeInt(1);
                            cursor = null;
                            bulkCursorDescriptor.writeToParcel(parcel2, 1);
                            if (0 != 0) {
                                throw new NullPointerException();
                            }
                            if (0 != 0) {
                                throw new NullPointerException();
                            }
                            return true;
                        } catch (Throwable th2) {
                            th = th2;
                            if (cursorToBulkCursorAdaptor != null) {
                                cursorToBulkCursorAdaptor.close();
                            }
                            if (cursor != null) {
                                cursor.close();
                            }
                            throw th;
                        }
                    } catch (Throwable unused) {
                        cursorToBulkCursorAdaptor = null;
                        th = query;
                    }
                case 2:
                    parcel.enforceInterface(IContentProvider.descriptor);
                    String type = getType(Uri.CREATOR.createFromParcel(parcel));
                    parcel2.writeNoException();
                    parcel2.writeString(type);
                    return true;
                case 3:
                    parcel.enforceInterface(IContentProvider.descriptor);
                    Uri insert = insert(parcel.readString(), Uri.CREATOR.createFromParcel(parcel), ContentValues.CREATOR.createFromParcel(parcel));
                    parcel2.writeNoException();
                    Uri.writeToParcel(parcel2, insert);
                    return true;
                case 4:
                    parcel.enforceInterface(IContentProvider.descriptor);
                    int delete = delete(parcel.readString(), Uri.CREATOR.createFromParcel(parcel), parcel.readString(), parcel.readStringArray());
                    parcel2.writeNoException();
                    parcel2.writeInt(delete);
                    return true;
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                case 11:
                case 12:
                case 16:
                case 17:
                case 18:
                case 19:
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
                case 10:
                    parcel.enforceInterface(IContentProvider.descriptor);
                    int update = update(parcel.readString(), Uri.CREATOR.createFromParcel(parcel), ContentValues.CREATOR.createFromParcel(parcel), parcel.readString(), parcel.readStringArray());
                    parcel2.writeNoException();
                    parcel2.writeInt(update);
                    return true;
                case 13:
                    parcel.enforceInterface(IContentProvider.descriptor);
                    int bulkInsert = bulkInsert(parcel.readString(), Uri.CREATOR.createFromParcel(parcel), (ContentValues[]) parcel.createTypedArray(ContentValues.CREATOR));
                    parcel2.writeNoException();
                    parcel2.writeInt(bulkInsert);
                    return true;
                case 14:
                    parcel.enforceInterface(IContentProvider.descriptor);
                    ParcelFileDescriptor openFile = openFile(parcel.readString(), Uri.CREATOR.createFromParcel(parcel), parcel.readString(), ICancellationSignal.Stub.asInterface(parcel.readStrongBinder()), parcel.readStrongBinder());
                    parcel2.writeNoException();
                    if (openFile == null) {
                        parcel2.writeInt(0);
                        return true;
                    }
                    parcel2.writeInt(1);
                    openFile.writeToParcel(parcel2, 1);
                    return true;
                case 15:
                    parcel.enforceInterface(IContentProvider.descriptor);
                    AssetFileDescriptor openAssetFile = openAssetFile(parcel.readString(), Uri.CREATOR.createFromParcel(parcel), parcel.readString(), ICancellationSignal.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    if (openAssetFile == null) {
                        parcel2.writeInt(0);
                        return true;
                    }
                    parcel2.writeInt(1);
                    openAssetFile.writeToParcel(parcel2, 1);
                    return true;
                case 20:
                    parcel.enforceInterface(IContentProvider.descriptor);
                    String readString4 = parcel.readString();
                    int readInt3 = parcel.readInt();
                    ArrayList arrayList = new ArrayList(readInt3);
                    int i7 = 0;
                    while (true) {
                        int i8 = i7;
                        if (i8 >= readInt3) {
                            ContentProviderResult[] applyBatch = applyBatch(readString4, arrayList);
                            parcel2.writeNoException();
                            parcel2.writeTypedArray(applyBatch, 0);
                            return true;
                        }
                        arrayList.add(i8, ContentProviderOperation.CREATOR.createFromParcel(parcel));
                        i7 = i8 + 1;
                    }
                case 21:
                    parcel.enforceInterface(IContentProvider.descriptor);
                    Bundle call = call(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readBundle());
                    parcel2.writeNoException();
                    parcel2.writeBundle(call);
                    return true;
                case 22:
                    parcel.enforceInterface(IContentProvider.descriptor);
                    String[] streamTypes = getStreamTypes(Uri.CREATOR.createFromParcel(parcel), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeStringArray(streamTypes);
                    return true;
                case 23:
                    parcel.enforceInterface(IContentProvider.descriptor);
                    AssetFileDescriptor openTypedAssetFile = openTypedAssetFile(parcel.readString(), Uri.CREATOR.createFromParcel(parcel), parcel.readString(), parcel.readBundle(), ICancellationSignal.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    if (openTypedAssetFile == null) {
                        parcel2.writeInt(0);
                        return true;
                    }
                    parcel2.writeInt(1);
                    openTypedAssetFile.writeToParcel(parcel2, 1);
                    return true;
                case 24:
                    parcel.enforceInterface(IContentProvider.descriptor);
                    ICancellationSignal createCancellationSignal = createCancellationSignal();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(createCancellationSignal.asBinder());
                    return true;
                case 25:
                    parcel.enforceInterface(IContentProvider.descriptor);
                    Uri canonicalize = canonicalize(parcel.readString(), Uri.CREATOR.createFromParcel(parcel));
                    parcel2.writeNoException();
                    Uri.writeToParcel(parcel2, canonicalize);
                    return true;
                case 26:
                    parcel.enforceInterface(IContentProvider.descriptor);
                    Uri uncanonicalize = uncanonicalize(parcel.readString(), Uri.CREATOR.createFromParcel(parcel));
                    parcel2.writeNoException();
                    Uri.writeToParcel(parcel2, uncanonicalize);
                    return true;
            }
        } catch (Exception e) {
            DatabaseUtils.writeExceptionToParcel(parcel2, e);
            return true;
        }
    }
}
