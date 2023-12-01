package android.renderscript;

import android.content.res.AssetManager;
import android.content.res.Resources;
import java.io.File;
import java.io.InputStream;

/* loaded from: source-9557208-dex2jar.jar:android/renderscript/FileA3D.class */
public class FileA3D extends BaseObj {
    IndexEntry[] mFileEntries;
    InputStream mInputStream;

    /* loaded from: source-9557208-dex2jar.jar:android/renderscript/FileA3D$EntryType.class */
    public enum EntryType {
        UNKNOWN(0),
        MESH(1);
        
        int mID;

        EntryType(int i) {
            this.mID = i;
        }

        static EntryType toEntryType(int i) {
            return values()[i];
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/renderscript/FileA3D$IndexEntry.class */
    public static class IndexEntry {
        EntryType mEntryType;
        long mID;
        int mIndex;
        BaseObj mLoadedObj = null;
        String mName;
        RenderScript mRS;

        IndexEntry(RenderScript renderScript, int i, long j, String str, EntryType entryType) {
            this.mRS = renderScript;
            this.mIndex = i;
            this.mID = j;
            this.mName = str;
            this.mEntryType = entryType;
        }

        static BaseObj internalCreate(RenderScript renderScript, IndexEntry indexEntry) {
            BaseObj baseObj;
            synchronized (IndexEntry.class) {
                try {
                    if (indexEntry.mLoadedObj != null) {
                        baseObj = indexEntry.mLoadedObj;
                    } else {
                        baseObj = null;
                        if (indexEntry.mEntryType != EntryType.UNKNOWN) {
                            long nFileA3DGetEntryByIndex = renderScript.nFileA3DGetEntryByIndex(indexEntry.mID, indexEntry.mIndex);
                            baseObj = null;
                            if (nFileA3DGetEntryByIndex != 0) {
                                switch (indexEntry.mEntryType) {
                                    case MESH:
                                        indexEntry.mLoadedObj = new Mesh(nFileA3DGetEntryByIndex, renderScript);
                                        break;
                                }
                                indexEntry.mLoadedObj.updateFromNative();
                                baseObj = indexEntry.mLoadedObj;
                            }
                        }
                    }
                } finally {
                }
            }
            return baseObj;
        }

        public EntryType getEntryType() {
            return this.mEntryType;
        }

        public Mesh getMesh() {
            return (Mesh) getObject();
        }

        public String getName() {
            return this.mName;
        }

        public BaseObj getObject() {
            this.mRS.validate();
            return internalCreate(this.mRS, this);
        }
    }

    FileA3D(long j, RenderScript renderScript, InputStream inputStream) {
        super(j, renderScript);
        this.mInputStream = inputStream;
    }

    public static FileA3D createFromAsset(RenderScript renderScript, AssetManager assetManager, String str) {
        renderScript.validate();
        long nFileA3DCreateFromAsset = renderScript.nFileA3DCreateFromAsset(assetManager, str);
        if (nFileA3DCreateFromAsset == 0) {
            throw new RSRuntimeException("Unable to create a3d file from asset " + str);
        }
        FileA3D fileA3D = new FileA3D(nFileA3DCreateFromAsset, renderScript, null);
        fileA3D.initEntries();
        return fileA3D;
    }

    public static FileA3D createFromFile(RenderScript renderScript, File file) {
        return createFromFile(renderScript, file.getAbsolutePath());
    }

    public static FileA3D createFromFile(RenderScript renderScript, String str) {
        long nFileA3DCreateFromFile = renderScript.nFileA3DCreateFromFile(str);
        if (nFileA3DCreateFromFile == 0) {
            throw new RSRuntimeException("Unable to create a3d file from " + str);
        }
        FileA3D fileA3D = new FileA3D(nFileA3DCreateFromFile, renderScript, null);
        fileA3D.initEntries();
        return fileA3D;
    }

    public static FileA3D createFromResource(RenderScript renderScript, Resources resources, int i) {
        renderScript.validate();
        try {
            InputStream openRawResource = resources.openRawResource(i);
            if (openRawResource instanceof AssetManager.AssetInputStream) {
                long nFileA3DCreateFromAssetStream = renderScript.nFileA3DCreateFromAssetStream(((AssetManager.AssetInputStream) openRawResource).getNativeAsset());
                if (nFileA3DCreateFromAssetStream == 0) {
                    throw new RSRuntimeException("Unable to create a3d file from resource " + i);
                }
                FileA3D fileA3D = new FileA3D(nFileA3DCreateFromAssetStream, renderScript, openRawResource);
                fileA3D.initEntries();
                return fileA3D;
            }
            throw new RSRuntimeException("Unsupported asset stream");
        } catch (Exception e) {
            throw new RSRuntimeException("Unable to open resource " + i);
        }
    }

    private void initEntries() {
        int nFileA3DGetNumIndexEntries = this.mRS.nFileA3DGetNumIndexEntries(getID(this.mRS));
        if (nFileA3DGetNumIndexEntries <= 0) {
            return;
        }
        this.mFileEntries = new IndexEntry[nFileA3DGetNumIndexEntries];
        int[] iArr = new int[nFileA3DGetNumIndexEntries];
        String[] strArr = new String[nFileA3DGetNumIndexEntries];
        this.mRS.nFileA3DGetIndexEntries(getID(this.mRS), nFileA3DGetNumIndexEntries, iArr, strArr);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= nFileA3DGetNumIndexEntries) {
                return;
            }
            this.mFileEntries[i2] = new IndexEntry(this.mRS, i2, getID(this.mRS), strArr[i2], EntryType.toEntryType(iArr[i2]));
            i = i2 + 1;
        }
    }

    public IndexEntry getIndexEntry(int i) {
        if (getIndexEntryCount() == 0 || i < 0 || i >= this.mFileEntries.length) {
            return null;
        }
        return this.mFileEntries[i];
    }

    public int getIndexEntryCount() {
        if (this.mFileEntries == null) {
            return 0;
        }
        return this.mFileEntries.length;
    }
}
