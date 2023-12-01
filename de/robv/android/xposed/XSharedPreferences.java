package de.robv.android.xposed;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Environment;
import android.util.Log;
import com.android.internal.util.XmlUtils;
import de.robv.android.xposed.services.FileResult;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: source-259656-dex2jar.jar:de/robv/android/xposed/XSharedPreferences.class */
public final class XSharedPreferences implements SharedPreferences {
    private static final String TAG = "XSharedPreferences";
    private final File mFile;
    private long mFileSize;
    private final String mFilename;
    private long mLastModified;
    private boolean mLoaded;
    private Map<String, Object> mMap;

    public XSharedPreferences(File file) {
        this.mLoaded = false;
        this.mFile = file;
        this.mFilename = this.mFile.getAbsolutePath();
        startLoadFromDisk();
    }

    public XSharedPreferences(String str) {
        this(str, str + "_preferences");
    }

    public XSharedPreferences(String str, String str2) {
        this.mLoaded = false;
        this.mFile = new File(Environment.getDataDirectory(), "data/" + str + "/shared_prefs/" + str2 + ".xml");
        this.mFilename = this.mFile.getAbsolutePath();
        startLoadFromDisk();
    }

    private void awaitLoadedLocked() {
        while (!this.mLoaded) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadFromDiskLocked() {
        Map<String, Object> map;
        FileResult fileResult;
        HashMap<String, ?> hashMap;
        if (this.mLoaded) {
            return;
        }
        FileResult fileResult2 = null;
        FileResult fileResult3 = null;
        FileResult fileResult4 = null;
        FileResult fileResult5 = null;
        try {
            try {
                try {
                    FileResult fileInputStream = SELinuxHelper.getAppDataFileService().getFileInputStream(this.mFilename, this.mFileSize, this.mLastModified);
                    if (fileInputStream.stream != null) {
                        HashMap<String, ?> readMapXml = XmlUtils.readMapXml(fileInputStream.stream);
                        fileInputStream.stream.close();
                        hashMap = readMapXml;
                    } else {
                        hashMap = this.mMap;
                    }
                    map = hashMap;
                    fileResult = fileInputStream;
                    if (fileInputStream != null) {
                        map = hashMap;
                        fileResult = fileInputStream;
                        if (fileInputStream.stream != null) {
                            try {
                                fileInputStream.stream.close();
                                fileResult = fileInputStream;
                                map = hashMap;
                            } catch (RuntimeException e) {
                                throw e;
                            } catch (Exception e2) {
                                map = hashMap;
                                fileResult = fileInputStream;
                            }
                        }
                    }
                } catch (FileNotFoundException e3) {
                    map = null;
                    fileResult = null;
                    if (0 != 0) {
                        map = null;
                        fileResult = null;
                        if (fileResult2.stream != null) {
                            try {
                                fileResult2.stream.close();
                                map = null;
                                fileResult = null;
                            } catch (RuntimeException e4) {
                                throw e4;
                            } catch (Exception e5) {
                                map = null;
                                fileResult = null;
                            }
                        }
                    }
                } catch (IOException e6) {
                    Log.w(TAG, "getSharedPreferences", e6);
                    map = null;
                    fileResult = null;
                    if (0 != 0) {
                        map = null;
                        fileResult = null;
                        if (fileResult3.stream != null) {
                            try {
                                fileResult3.stream.close();
                                map = null;
                                fileResult = null;
                            } catch (RuntimeException e7) {
                                throw e7;
                            } catch (Exception e8) {
                                map = null;
                                fileResult = null;
                            }
                        }
                    }
                }
            } catch (XmlPullParserException e9) {
                Log.w(TAG, "getSharedPreferences", e9);
                map = null;
                fileResult = null;
                if (0 != 0) {
                    map = null;
                    fileResult = null;
                    if (fileResult5.stream != null) {
                        try {
                            fileResult5.stream.close();
                            map = null;
                            fileResult = null;
                        } catch (RuntimeException e10) {
                            throw e10;
                        } catch (Exception e11) {
                            map = null;
                            fileResult = null;
                        }
                    }
                }
            }
            this.mLoaded = true;
            if (map != null) {
                this.mMap = map;
                this.mLastModified = fileResult.mtime;
                this.mFileSize = fileResult.size;
            } else {
                this.mMap = new HashMap();
            }
            notifyAll();
        } catch (Throwable th) {
            if (0 != 0 && fileResult4.stream != null) {
                try {
                    fileResult4.stream.close();
                } catch (RuntimeException e12) {
                    throw e12;
                } catch (Exception e13) {
                }
            }
            throw th;
        }
    }

    private void startLoadFromDisk() {
        synchronized (this) {
            this.mLoaded = false;
        }
        new Thread("XSharedPreferences-load") { // from class: de.robv.android.xposed.XSharedPreferences.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                synchronized (XSharedPreferences.this) {
                    XSharedPreferences.this.loadFromDiskLocked();
                }
            }
        }.start();
    }

    @Override // android.content.SharedPreferences
    public boolean contains(String str) {
        boolean containsKey;
        synchronized (this) {
            awaitLoadedLocked();
            containsKey = this.mMap.containsKey(str);
        }
        return containsKey;
    }

    @Override // android.content.SharedPreferences
    @Deprecated
    public SharedPreferences.Editor edit() {
        throw new UnsupportedOperationException("read-only implementation");
    }

    @Override // android.content.SharedPreferences
    public Map<String, ?> getAll() {
        HashMap hashMap;
        synchronized (this) {
            awaitLoadedLocked();
            hashMap = new HashMap(this.mMap);
        }
        return hashMap;
    }

    @Override // android.content.SharedPreferences
    public boolean getBoolean(String str, boolean z) {
        synchronized (this) {
            awaitLoadedLocked();
            Boolean bool = (Boolean) this.mMap.get(str);
            if (bool != null) {
                z = bool.booleanValue();
            }
        }
        return z;
    }

    public File getFile() {
        return this.mFile;
    }

    @Override // android.content.SharedPreferences
    public float getFloat(String str, float f) {
        synchronized (this) {
            awaitLoadedLocked();
            Float f2 = (Float) this.mMap.get(str);
            if (f2 != null) {
                f = f2.floatValue();
            }
        }
        return f;
    }

    @Override // android.content.SharedPreferences
    public int getInt(String str, int i) {
        synchronized (this) {
            awaitLoadedLocked();
            Integer num = (Integer) this.mMap.get(str);
            if (num != null) {
                i = num.intValue();
            }
        }
        return i;
    }

    @Override // android.content.SharedPreferences
    public long getLong(String str, long j) {
        synchronized (this) {
            awaitLoadedLocked();
            Long l = (Long) this.mMap.get(str);
            if (l != null) {
                j = l.longValue();
            }
        }
        return j;
    }

    @Override // android.content.SharedPreferences
    public String getString(String str, String str2) {
        String str3;
        synchronized (this) {
            awaitLoadedLocked();
            str3 = (String) this.mMap.get(str);
            if (str3 == null) {
                str3 = str2;
            }
        }
        return str3;
    }

    @Override // android.content.SharedPreferences
    public Set<String> getStringSet(String str, Set<String> set) {
        Set<String> set2;
        synchronized (this) {
            awaitLoadedLocked();
            set2 = (Set) this.mMap.get(str);
            if (set2 == null) {
                set2 = set;
            }
        }
        return set2;
    }

    public boolean hasFileChanged() {
        boolean z;
        synchronized (this) {
            try {
                FileResult statFile = SELinuxHelper.getAppDataFileService().statFile(this.mFilename);
                z = true;
                if (this.mLastModified == statFile.mtime) {
                    z = this.mFileSize != statFile.size;
                }
            } catch (FileNotFoundException e) {
                z = true;
            } catch (IOException e2) {
                Log.w(TAG, "hasFileChanged", e2);
                z = true;
            }
        }
        return z;
    }

    @SuppressLint({"SetWorldReadable"})
    public boolean makeWorldReadable() {
        if (SELinuxHelper.getAppDataFileService().hasDirectFileAccess() && this.mFile.exists()) {
            return this.mFile.setReadable(true, false);
        }
        return false;
    }

    @Override // android.content.SharedPreferences
    @Deprecated
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        throw new UnsupportedOperationException("listeners are not supported in this implementation");
    }

    public void reload() {
        synchronized (this) {
            if (hasFileChanged()) {
                startLoadFromDisk();
            }
        }
    }

    @Override // android.content.SharedPreferences
    @Deprecated
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        throw new UnsupportedOperationException("listeners are not supported in this implementation");
    }
}
