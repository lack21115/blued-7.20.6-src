package android.media;

import android.content.ContentValues;
import android.content.IContentProvider;
import android.net.Uri;
import android.os.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: source-9557208-dex2jar.jar:android/media/MediaInserter.class */
public class MediaInserter {
    private final int mBufferSizePerUri;
    private final String mPackageName;
    private final IContentProvider mProvider;
    private final HashMap<Uri, List<ContentValues>> mRowMap = new HashMap<>();
    private final HashMap<Uri, List<ContentValues>> mPriorityRowMap = new HashMap<>();

    public MediaInserter(IContentProvider iContentProvider, String str, int i) {
        this.mProvider = iContentProvider;
        this.mPackageName = str;
        this.mBufferSizePerUri = i;
    }

    private void flush(Uri uri, List<ContentValues> list) throws RemoteException {
        if (list.isEmpty()) {
            return;
        }
        this.mProvider.bulkInsert(this.mPackageName, uri, (ContentValues[]) list.toArray(new ContentValues[list.size()]));
        list.clear();
    }

    private void flushAllPriority() throws RemoteException {
        for (Uri uri : this.mPriorityRowMap.keySet()) {
            flush(uri, this.mPriorityRowMap.get(uri));
        }
        this.mPriorityRowMap.clear();
    }

    private void insert(Uri uri, ContentValues contentValues, boolean z) throws RemoteException {
        HashMap<Uri, List<ContentValues>> hashMap = z ? this.mPriorityRowMap : this.mRowMap;
        List<ContentValues> list = hashMap.get(uri);
        ArrayList arrayList = list;
        if (list == null) {
            arrayList = new ArrayList();
            hashMap.put(uri, arrayList);
        }
        arrayList.add(new ContentValues(contentValues));
        if (arrayList.size() >= this.mBufferSizePerUri) {
            flushAllPriority();
            flush(uri, arrayList);
        }
    }

    public void flushAll() throws RemoteException {
        flushAllPriority();
        for (Uri uri : this.mRowMap.keySet()) {
            flush(uri, this.mRowMap.get(uri));
        }
        this.mRowMap.clear();
    }

    public void insert(Uri uri, ContentValues contentValues) throws RemoteException {
        insert(uri, contentValues, false);
    }

    public void insertwithPriority(Uri uri, ContentValues contentValues) throws RemoteException {
        insert(uri, contentValues, true);
    }
}
