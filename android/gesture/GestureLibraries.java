package android.gesture;

import android.content.Context;
import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;

/* loaded from: source-9557208-dex2jar.jar:android/gesture/GestureLibraries.class */
public final class GestureLibraries {

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/gesture/GestureLibraries$FileGestureLibrary.class */
    public static class FileGestureLibrary extends GestureLibrary {
        private final File mPath;

        public FileGestureLibrary(File file) {
            this.mPath = file;
        }

        @Override // android.gesture.GestureLibrary
        public boolean isReadOnly() {
            return !this.mPath.canWrite();
        }

        @Override // android.gesture.GestureLibrary
        public boolean load() {
            File file = this.mPath;
            boolean z = false;
            if (file.exists()) {
                z = false;
                if (file.canRead()) {
                    try {
                        this.mStore.load(new FileInputStream(file), true);
                        z = true;
                    } catch (FileNotFoundException e) {
                        Log.d(GestureConstants.LOG_TAG, "Could not load the gesture library from " + this.mPath, e);
                        return false;
                    } catch (IOException e2) {
                        Log.d(GestureConstants.LOG_TAG, "Could not load the gesture library from " + this.mPath, e2);
                        return false;
                    }
                }
            }
            return z;
        }

        @Override // android.gesture.GestureLibrary
        public boolean save() {
            if (this.mStore.hasChanged()) {
                File file = this.mPath;
                File parentFile = file.getParentFile();
                if (parentFile.exists() || parentFile.mkdirs()) {
                    try {
                        file.createNewFile();
                        this.mStore.save(new FileOutputStream(file), true);
                        return true;
                    } catch (FileNotFoundException e) {
                        Log.d(GestureConstants.LOG_TAG, "Could not save the gesture library in " + this.mPath, e);
                        return false;
                    } catch (IOException e2) {
                        Log.d(GestureConstants.LOG_TAG, "Could not save the gesture library in " + this.mPath, e2);
                        return false;
                    }
                }
                return false;
            }
            return true;
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/gesture/GestureLibraries$ResourceGestureLibrary.class */
    private static class ResourceGestureLibrary extends GestureLibrary {
        private final WeakReference<Context> mContext;
        private final int mResourceId;

        public ResourceGestureLibrary(Context context, int i) {
            this.mContext = new WeakReference<>(context);
            this.mResourceId = i;
        }

        @Override // android.gesture.GestureLibrary
        public boolean isReadOnly() {
            return true;
        }

        @Override // android.gesture.GestureLibrary
        public boolean load() {
            boolean z = false;
            Context context = this.mContext.get();
            if (context != null) {
                try {
                    this.mStore.load(context.getResources().openRawResource(this.mResourceId), true);
                    z = true;
                } catch (IOException e) {
                    Log.d(GestureConstants.LOG_TAG, "Could not load the gesture library from raw resource " + context.getResources().getResourceName(this.mResourceId), e);
                    return false;
                }
            }
            return z;
        }

        @Override // android.gesture.GestureLibrary
        public boolean save() {
            return false;
        }
    }

    private GestureLibraries() {
    }

    public static GestureLibrary fromFile(File file) {
        return new FileGestureLibrary(file);
    }

    public static GestureLibrary fromFile(String str) {
        return fromFile(new File(str));
    }

    public static GestureLibrary fromPrivateFile(Context context, String str) {
        return fromFile(context.getFileStreamPath(str));
    }

    public static GestureLibrary fromRawResource(Context context, int i) {
        return new ResourceGestureLibrary(context, i);
    }
}
