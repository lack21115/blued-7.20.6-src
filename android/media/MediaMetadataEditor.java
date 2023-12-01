package android.media;

import android.graphics.Bitmap;
import android.media.MediaMetadata;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.util.SparseIntArray;

@Deprecated
/* loaded from: source-9557208-dex2jar.jar:android/media/MediaMetadataEditor.class */
public abstract class MediaMetadataEditor {
    public static final int BITMAP_KEY_ARTWORK = 100;
    public static final int KEY_EDITABLE_MASK = 536870911;
    protected static final SparseIntArray METADATA_KEYS_TYPE = new SparseIntArray(18);
    protected static final int METADATA_TYPE_BITMAP = 2;
    protected static final int METADATA_TYPE_INVALID = -1;
    protected static final int METADATA_TYPE_LONG = 0;
    protected static final int METADATA_TYPE_RATING = 3;
    protected static final int METADATA_TYPE_STRING = 1;
    public static final int RATING_KEY_BY_OTHERS = 101;
    public static final int RATING_KEY_BY_USER = 268435457;
    private static final String TAG = "MediaMetadataEditor";
    protected long mEditableKeys;
    protected Bitmap mEditorArtwork;
    protected Bundle mEditorMetadata;
    protected MediaMetadata.Builder mMetadataBuilder;
    protected boolean mMetadataChanged = false;
    protected boolean mApplied = false;
    protected boolean mArtworkChanged = false;

    static {
        METADATA_KEYS_TYPE.put(0, 0);
        METADATA_KEYS_TYPE.put(14, 0);
        METADATA_KEYS_TYPE.put(9, 0);
        METADATA_KEYS_TYPE.put(8, 0);
        METADATA_KEYS_TYPE.put(1, 1);
        METADATA_KEYS_TYPE.put(13, 1);
        METADATA_KEYS_TYPE.put(7, 1);
        METADATA_KEYS_TYPE.put(2, 1);
        METADATA_KEYS_TYPE.put(3, 1);
        METADATA_KEYS_TYPE.put(15, 1);
        METADATA_KEYS_TYPE.put(4, 1);
        METADATA_KEYS_TYPE.put(5, 1);
        METADATA_KEYS_TYPE.put(6, 1);
        METADATA_KEYS_TYPE.put(11, 1);
        METADATA_KEYS_TYPE.put(100, 2);
        METADATA_KEYS_TYPE.put(101, 3);
        METADATA_KEYS_TYPE.put(RATING_KEY_BY_USER, 3);
        METADATA_KEYS_TYPE.put(10, 0);
    }

    public void addEditableKey(int i) {
        synchronized (this) {
            if (this.mApplied) {
                Log.e(TAG, "Can't change editable keys of a previously applied MetadataEditor");
            } else if (i == 268435457) {
                this.mEditableKeys |= 536870911 & i;
                this.mMetadataChanged = true;
            } else {
                Log.e(TAG, "Metadata key " + i + " cannot be edited");
            }
        }
    }

    public abstract void apply();

    public void clear() {
        synchronized (this) {
            if (this.mApplied) {
                Log.e(TAG, "Can't clear a previously applied MediaMetadataEditor");
            } else {
                this.mEditorMetadata.clear();
                this.mEditorArtwork = null;
                this.mMetadataBuilder = new MediaMetadata.Builder();
            }
        }
    }

    public Bitmap getBitmap(int i, Bitmap bitmap) throws IllegalArgumentException {
        synchronized (this) {
            if (i != 100) {
                throw new IllegalArgumentException("Invalid type 'Bitmap' for key " + i);
            }
            if (this.mEditorArtwork != null) {
                bitmap = this.mEditorArtwork;
            }
        }
        return bitmap;
    }

    public int[] getEditableKeys() {
        int[] iArr;
        synchronized (this) {
            if (this.mEditableKeys == 268435457) {
                iArr = new int[1];
                iArr[0] = 268435457;
            } else {
                iArr = null;
            }
        }
        return iArr;
    }

    public long getLong(int i, long j) throws IllegalArgumentException {
        long j2;
        synchronized (this) {
            if (METADATA_KEYS_TYPE.get(i, -1) != 0) {
                throw new IllegalArgumentException("Invalid type 'long' for key " + i);
            }
            j2 = this.mEditorMetadata.getLong(String.valueOf(i), j);
        }
        return j2;
    }

    public Object getObject(int i, Object obj) throws IllegalArgumentException {
        synchronized (this) {
            switch (METADATA_KEYS_TYPE.get(i, -1)) {
                case 0:
                    if (this.mEditorMetadata.containsKey(String.valueOf(i))) {
                        obj = Long.valueOf(this.mEditorMetadata.getLong(String.valueOf(i)));
                    }
                    break;
                case 1:
                    if (this.mEditorMetadata.containsKey(String.valueOf(i))) {
                        obj = this.mEditorMetadata.getString(String.valueOf(i));
                    }
                    break;
                case 2:
                    if (i == 100) {
                        if (this.mEditorArtwork != null) {
                            obj = this.mEditorArtwork;
                        }
                        break;
                    }
                    throw new IllegalArgumentException("Invalid key " + i);
                case 3:
                    if (this.mEditorMetadata.containsKey(String.valueOf(i))) {
                        obj = this.mEditorMetadata.getParcelable(String.valueOf(i));
                    }
                    break;
                default:
                    throw new IllegalArgumentException("Invalid key " + i);
            }
        }
        return obj;
    }

    public String getString(int i, String str) throws IllegalArgumentException {
        String string;
        synchronized (this) {
            if (METADATA_KEYS_TYPE.get(i, -1) != 1) {
                throw new IllegalArgumentException("Invalid type 'String' for key " + i);
            }
            string = this.mEditorMetadata.getString(String.valueOf(i), str);
        }
        return string;
    }

    public MediaMetadataEditor putBitmap(int i, Bitmap bitmap) throws IllegalArgumentException {
        synchronized (this) {
            if (this.mApplied) {
                Log.e(TAG, "Can't edit a previously applied MediaMetadataEditor");
            } else if (i != 100) {
                throw new IllegalArgumentException("Invalid type 'Bitmap' for key " + i);
            } else {
                this.mEditorArtwork = bitmap;
                this.mArtworkChanged = true;
            }
        }
        return this;
    }

    public MediaMetadataEditor putLong(int i, long j) throws IllegalArgumentException {
        synchronized (this) {
            if (this.mApplied) {
                Log.e(TAG, "Can't edit a previously applied MediaMetadataEditor");
            } else if (METADATA_KEYS_TYPE.get(i, -1) != 0) {
                throw new IllegalArgumentException("Invalid type 'long' for key " + i);
            } else {
                this.mEditorMetadata.putLong(String.valueOf(i), j);
                this.mMetadataChanged = true;
            }
        }
        return this;
    }

    public MediaMetadataEditor putObject(int i, Object obj) throws IllegalArgumentException {
        MediaMetadataEditor putBitmap;
        synchronized (this) {
            if (this.mApplied) {
                Log.e(TAG, "Can't edit a previously applied MediaMetadataEditor");
                putBitmap = this;
            } else {
                switch (METADATA_KEYS_TYPE.get(i, -1)) {
                    case 0:
                        if (obj instanceof Long) {
                            putBitmap = putLong(i, ((Long) obj).longValue());
                            break;
                        } else {
                            throw new IllegalArgumentException("Not a non-null Long for key " + i);
                        }
                    case 1:
                        if (obj == null || (obj instanceof String)) {
                            putBitmap = putString(i, (String) obj);
                            break;
                        } else {
                            throw new IllegalArgumentException("Not a String for key " + i);
                        }
                    case 2:
                        if (obj == null || (obj instanceof Bitmap)) {
                            putBitmap = putBitmap(i, (Bitmap) obj);
                            break;
                        } else {
                            throw new IllegalArgumentException("Not a Bitmap for key " + i);
                        }
                    case 3:
                        this.mEditorMetadata.putParcelable(String.valueOf(i), (Parcelable) obj);
                        this.mMetadataChanged = true;
                        putBitmap = this;
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid key " + i);
                }
            }
        }
        return putBitmap;
    }

    public MediaMetadataEditor putString(int i, String str) throws IllegalArgumentException {
        synchronized (this) {
            if (this.mApplied) {
                Log.e(TAG, "Can't edit a previously applied MediaMetadataEditor");
            } else if (METADATA_KEYS_TYPE.get(i, -1) != 1) {
                throw new IllegalArgumentException("Invalid type 'String' for key " + i);
            } else {
                this.mEditorMetadata.putString(String.valueOf(i), str);
                this.mMetadataChanged = true;
            }
        }
        return this;
    }

    public void removeEditableKeys() {
        synchronized (this) {
            if (this.mApplied) {
                Log.e(TAG, "Can't remove all editable keys of a previously applied MetadataEditor");
            } else if (this.mEditableKeys != 0) {
                this.mEditableKeys = 0L;
                this.mMetadataChanged = true;
            }
        }
    }
}
