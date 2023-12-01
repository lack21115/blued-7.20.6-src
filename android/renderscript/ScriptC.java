package android.renderscript;

import android.content.res.Resources;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: source-9557208-dex2jar.jar:android/renderscript/ScriptC.class */
public class ScriptC extends Script {
    private static final String CACHE_PATH = "com.android.renderscript.cache";
    private static final String TAG = "ScriptC";
    static String mCachePath;

    protected ScriptC(int i, RenderScript renderScript) {
        super(i, renderScript);
    }

    protected ScriptC(long j, RenderScript renderScript) {
        super(j, renderScript);
    }

    protected ScriptC(RenderScript renderScript, Resources resources, int i) {
        super(0L, renderScript);
        long internalCreate = internalCreate(renderScript, resources, i);
        if (internalCreate == 0) {
            throw new RSRuntimeException("Loading of ScriptC script failed.");
        }
        setID(internalCreate);
    }

    protected ScriptC(RenderScript renderScript, String str, byte[] bArr, byte[] bArr2) {
        super(0L, renderScript);
        long internalStringCreate = RenderScript.sPointerSize == 4 ? internalStringCreate(renderScript, str, bArr) : internalStringCreate(renderScript, str, bArr2);
        if (internalStringCreate == 0) {
            throw new RSRuntimeException("Loading of ScriptC script failed.");
        }
        setID(internalStringCreate);
    }

    private static long internalCreate(RenderScript renderScript, Resources resources, int i) {
        byte[] bArr;
        long nScriptCCreate;
        synchronized (ScriptC.class) {
            try {
                try {
                    InputStream openRawResource = resources.openRawResource(i);
                    try {
                        byte[] bArr2 = new byte[1024];
                        int i2 = 0;
                        while (true) {
                            int length = bArr2.length - i2;
                            int i3 = length;
                            bArr = bArr2;
                            if (length == 0) {
                                bArr = new byte[bArr2.length * 2];
                                System.arraycopy(bArr2, 0, bArr, 0, bArr2.length);
                                i3 = bArr.length - i2;
                            }
                            int read = openRawResource.read(bArr, i2, i3);
                            if (read <= 0) {
                                break;
                            }
                            i2 += read;
                            bArr2 = bArr;
                        }
                        String resourceEntryName = resources.getResourceEntryName(i);
                        if (mCachePath == null) {
                            File file = new File(RenderScript.mCacheDir, CACHE_PATH);
                            mCachePath = file.getAbsolutePath();
                            file.mkdirs();
                        }
                        nScriptCCreate = renderScript.nScriptCCreate(resourceEntryName, mCachePath, bArr, i2);
                    } finally {
                        openRawResource.close();
                    }
                } catch (IOException e) {
                    throw new Resources.NotFoundException();
                }
            } finally {
            }
        }
        return nScriptCCreate;
    }

    private static long internalStringCreate(RenderScript renderScript, String str, byte[] bArr) {
        long nScriptCCreate;
        synchronized (ScriptC.class) {
            try {
                if (mCachePath == null) {
                    File file = new File(RenderScript.mCacheDir, CACHE_PATH);
                    mCachePath = file.getAbsolutePath();
                    file.mkdirs();
                }
                nScriptCCreate = renderScript.nScriptCCreate(str, mCachePath, bArr, bArr.length);
            } catch (Throwable th) {
                throw th;
            }
        }
        return nScriptCCreate;
    }
}
