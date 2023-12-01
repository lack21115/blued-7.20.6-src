package com.wrapper.proxyapplication;

import com.anythink.core.common.b.g;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import dalvik.system.DexFile;
import dalvik.system.PathClassLoader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.lang.reflect.Field;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* loaded from: source-63640-dex2jar.jar:com/wrapper/proxyapplication/CustomerClassLoader.class */
public class CustomerClassLoader extends PathClassLoader {
    private static final boolean VERBOSE_DEBUG = false;
    private boolean initialized;
    private final String libPath;
    private final String mDexOutputPath;
    private DexFile[] mDexs;
    private File[] mFiles;
    private String[] mLibPaths;
    private String[] mPaths;
    private ZipFile[] mZips;
    private final String path;

    public CustomerClassLoader(String str, String str2, String str3, ClassLoader classLoader) throws NoSuchFieldException, IllegalAccessException, IllegalArgumentException, NullPointerException, IOException {
        super("", str3, classLoader.getParent());
        if (str == null || str2 == null) {
            throw new NullPointerException();
        }
        this.path = str;
        this.libPath = str3;
        this.mDexOutputPath = str2;
        try {
            findField(classLoader, "parent").set(classLoader, this);
            ensureInit();
        } catch (IOException e) {
            throw e;
        } catch (NoSuchFieldException e2) {
            throw e2;
        }
    }

    private native int ShowLogs(String str, int i);

    private void ensureInit() throws IOException {
        synchronized (this) {
            if (this.initialized) {
                return;
            }
            this.initialized = true;
            this.mPaths = this.path.split(":");
            int length = this.mPaths.length;
            this.mFiles = new File[length];
            this.mZips = new ZipFile[length];
            this.mDexs = new DexFile[length];
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    break;
                }
                File file = new File(this.mPaths[i2]);
                this.mFiles[i2] = file;
                if (file.isFile()) {
                    try {
                        this.mZips[i2] = new ZipFile(file);
                    } catch (IOException e) {
                    }
                    try {
                        if (this.mDexOutputPath != null) {
                            this.mDexs[i2] = DexFile.loadDex(this.mPaths[i2], generateOutputName(this.mPaths[i2], this.mDexOutputPath), 0);
                        }
                    } catch (IOException e2) {
                        throw new IOException("load dex fail");
                    } catch (RuntimeException e3) {
                        throw new IOException("load dex fail");
                    }
                }
                i = i2 + 1;
            }
            String property = System.getProperty("java.library.path", ".");
            String property2 = System.getProperty("path.separator", ":");
            String property3 = System.getProperty("file.separator", BridgeUtil.SPLIT_MARK);
            String str = property;
            if (this.libPath != null) {
                if (property.length() > 0) {
                    str = this.libPath + property2 + property;
                } else {
                    str = this.libPath;
                }
            }
            this.mLibPaths = str.split(property2);
            int length2 = this.mLibPaths.length;
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= length2) {
                    return;
                }
                if (!this.mLibPaths[i4].endsWith(property3)) {
                    StringBuilder sb = new StringBuilder();
                    String[] strArr = this.mLibPaths;
                    sb.append(strArr[i4]);
                    sb.append(property3);
                    strArr[i4] = sb.toString();
                }
                i3 = i4 + 1;
            }
        }
    }

    private static Field findField(Object obj, String str) throws NoSuchFieldException {
        Field declaredField;
        Class<?> cls = obj.getClass();
        while (true) {
            Class<?> cls2 = cls;
            if (cls2 == null) {
                throw new NoSuchFieldException("Field " + str + " not found in " + obj.getClass());
            }
            try {
                declaredField = cls2.getDeclaredField(str);
                if (!declaredField.isAccessible()) {
                    declaredField.setAccessible(true);
                    break;
                }
                break;
            } catch (NoSuchFieldException e) {
                cls = cls2.getSuperclass();
            }
        }
        return declaredField;
    }

    private static String generateOutputName(String str, String str2) {
        StringBuilder sb = new StringBuilder(80);
        sb.append(str2);
        if (!str2.endsWith(BridgeUtil.SPLIT_MARK)) {
            sb.append(BridgeUtil.SPLIT_MARK);
        }
        int lastIndexOf = str.lastIndexOf(BridgeUtil.SPLIT_MARK);
        if (lastIndexOf >= 0) {
            str = str.substring(lastIndexOf + 1);
        }
        int lastIndexOf2 = str.lastIndexOf(".");
        if (lastIndexOf2 < 0) {
            sb.append(str);
        } else {
            sb.append((CharSequence) str, 0, lastIndexOf2);
        }
        sb.append(".dex");
        return sb.toString();
    }

    private boolean isInArchive(ZipFile zipFile, String str) {
        return zipFile.getEntry(str) != null;
    }

    private byte[] loadFromArchive(ZipFile zipFile, String str) {
        ZipEntry entry = zipFile.getEntry(str);
        if (entry == null) {
            return null;
        }
        try {
            InputStream inputStream = zipFile.getInputStream(entry);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream((int) entry.getSize());
            byte[] bArr = new byte[4096];
            while (true) {
                int read = inputStream.read(bArr);
                if (read <= 0) {
                    inputStream.close();
                    return byteArrayOutputStream.toByteArray();
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
        } catch (IOException e) {
            return null;
        }
    }

    private byte[] loadFromDirectory(String str) {
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(str, g.o.o);
            try {
                byte[] bArr = new byte[(int) randomAccessFile.length()];
                randomAccessFile.read(bArr);
                randomAccessFile.close();
                return bArr;
            } catch (IOException e) {
                return null;
            }
        } catch (FileNotFoundException e2) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // dalvik.system.BaseDexClassLoader, java.lang.ClassLoader
    public Class<?> findClass(String str) throws ClassNotFoundException {
        try {
            ensureInit();
        } catch (IOException e) {
            e.printStackTrace();
        }
        int length = this.mPaths.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                throw new ClassNotFoundException(str + " in loader " + this);
            }
            if (this.mDexs[i2] != null) {
                ShowLogs(str, i2);
                Class<?> loadClass = this.mDexs[i2].loadClass(str.replace('.', '/'), this);
                if (loadClass != null) {
                    return loadClass;
                }
                try {
                    Class<?> findClass = super.findClass(str);
                    if (findClass != null) {
                        return findClass;
                    }
                } catch (ClassNotFoundException e2) {
                }
            } else if (this.mZips[i2] != null) {
                loadFromArchive(this.mZips[i2], str.replace('.', '/') + ".class");
            } else if (this.mFiles[i2].isDirectory()) {
                loadFromDirectory(this.mPaths[i2] + BridgeUtil.SPLIT_MARK + str.replace('.', '/') + ".class");
            }
            i = i2 + 1;
        }
    }

    @Override // dalvik.system.BaseDexClassLoader, java.lang.ClassLoader
    public String findLibrary(String str) {
        try {
            ensureInit();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String mapLibraryName = System.mapLibraryName(str);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.mLibPaths.length) {
                return null;
            }
            String str2 = this.mLibPaths[i2] + mapLibraryName;
            if (new File(str2).exists()) {
                return str2;
            }
            String findLibrary = super.findLibrary(str);
            if (findLibrary != null) {
                return findLibrary;
            }
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // dalvik.system.BaseDexClassLoader, java.lang.ClassLoader
    public URL findResource(String str) {
        URL findResource = super.findResource(str);
        if (findResource != null) {
            return findResource;
        }
        int length = this.mPaths.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return null;
            }
            File file = this.mFiles[i2];
            ZipFile zipFile = this.mZips[i2];
            if (!this.mPaths[i2].endsWith(".dex") && zipFile.getEntry(str) != null) {
                try {
                    return new URL("jar:" + file.toURL() + "!/" + str);
                } catch (MalformedURLException e) {
                    throw new RuntimeException(e);
                }
            }
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // dalvik.system.BaseDexClassLoader, java.lang.ClassLoader
    public Package getPackage(String str) {
        Package r12;
        if (str == null || "".equals(str)) {
            return null;
        }
        synchronized (this) {
            Package r0 = super.getPackage(str);
            r12 = r0;
            if (r0 == null) {
                r12 = definePackage(str, "Unknown", "0.0", "Unknown", "Unknown", "0.0", "Unknown", null);
            }
        }
        return r12;
    }
}
