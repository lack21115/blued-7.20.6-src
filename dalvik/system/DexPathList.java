package dalvik.system;

import android.system.ErrnoException;
import android.system.OsConstants;
import android.system.StructStat;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.zip.ZipFile;
import libcore.io.IoUtils;
import libcore.io.Libcore;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-2895416-dex2jar.jar:dalvik/system/DexPathList.class */
public final class DexPathList {
    private static final String DEX_SUFFIX = ".dex";
    private final ClassLoader definingContext;
    private final Element[] dexElements;
    private final IOException[] dexElementsSuppressedExceptions;
    private final File[] nativeLibraryDirectories;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-2895416-dex2jar.jar:dalvik/system/DexPathList$Element.class */
    public static class Element {
        private final DexFile dexFile;
        private final File file;
        private boolean initialized;
        private final boolean isDirectory;
        private final File zip;
        private ZipFile zipFile;

        public Element(File file, boolean z, File file2, DexFile dexFile) {
            this.file = file;
            this.isDirectory = z;
            this.zip = file2;
            this.dexFile = dexFile;
        }

        public URL findResource(String str) {
            maybeInit();
            if (this.isDirectory) {
                File file = new File(this.file, str);
                if (file.exists()) {
                    try {
                        return file.toURI().toURL();
                    } catch (MalformedURLException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
            if (this.zipFile == null || this.zipFile.getEntry(str) == null) {
                return null;
            }
            try {
                return new URL("jar:" + this.file.toURL() + "!/" + str);
            } catch (MalformedURLException e2) {
                throw new RuntimeException(e2);
            }
        }

        public void maybeInit() {
            synchronized (this) {
                if (!this.initialized) {
                    this.initialized = true;
                    if (!this.isDirectory && this.zip != null) {
                        try {
                            this.zipFile = new ZipFile(this.zip);
                        } catch (IOException e) {
                            System.logE("Unable to open zip file: " + this.file, e);
                            this.zipFile = null;
                        }
                    }
                }
            }
        }

        public String toString() {
            return this.isDirectory ? "directory \"" + this.file + "\"" : this.zip != null ? "zip file \"" + this.zip + "\"" : "dex file \"" + this.dexFile + "\"";
        }
    }

    public DexPathList(ClassLoader classLoader, String str, String str2, File file) {
        if (classLoader == null) {
            throw new NullPointerException("definingContext == null");
        }
        if (str == null) {
            throw new NullPointerException("dexPath == null");
        }
        if (file != null) {
            if (!file.exists()) {
                throw new IllegalArgumentException("optimizedDirectory doesn't exist: " + file);
            }
            if (!file.canRead() || !file.canWrite()) {
                throw new IllegalArgumentException("optimizedDirectory not readable/writable: " + file);
            }
        }
        this.definingContext = classLoader;
        ArrayList arrayList = new ArrayList();
        this.dexElements = makeDexElements(splitDexPath(str), file, arrayList);
        if (arrayList.size() > 0) {
            this.dexElementsSuppressedExceptions = (IOException[]) arrayList.toArray(new IOException[arrayList.size()]);
        } else {
            this.dexElementsSuppressedExceptions = null;
        }
        this.nativeLibraryDirectories = splitLibraryPath(str2);
    }

    private static DexFile loadDexFile(File file, File file2) throws IOException {
        if (file2 == null) {
            return new DexFile(file);
        }
        return DexFile.loadDex(file.getPath(), optimizedPathFor(file, file2), 0);
    }

    private static Element[] makeDexElements(ArrayList<File> arrayList, File file, ArrayList<IOException> arrayList2) {
        ArrayList arrayList3 = new ArrayList();
        Iterator<File> it = arrayList.iterator();
        while (it.hasNext()) {
            File next = it.next();
            File file2 = null;
            DexFile dexFile = null;
            String name = next.getName();
            if (next.isDirectory()) {
                arrayList3.add(new Element(next, true, null, null));
            } else if (!next.isFile()) {
                System.logW("ClassLoader referenced unknown path: " + next);
            } else if (name.endsWith(".dex")) {
                try {
                    dexFile = loadDexFile(next, file);
                } catch (IOException e) {
                    System.logE("Unable to load dex file: " + next, e);
                }
            } else {
                file2 = next;
                try {
                    dexFile = loadDexFile(next, file);
                } catch (IOException e2) {
                    arrayList2.add(e2);
                }
            }
            if (file2 != null || dexFile != null) {
                arrayList3.add(new Element(next, false, file2, dexFile));
            }
        }
        return (Element[]) arrayList3.toArray(new Element[arrayList3.size()]);
    }

    private static String optimizedPathFor(File file, File file2) {
        String name = file.getName();
        String str = name;
        if (!name.endsWith(".dex")) {
            int lastIndexOf = name.lastIndexOf(".");
            if (lastIndexOf < 0) {
                str = name + ".dex";
            } else {
                StringBuilder sb = new StringBuilder(lastIndexOf + 4);
                sb.append((CharSequence) name, 0, lastIndexOf);
                sb.append(".dex");
                str = sb.toString();
            }
        }
        return new File(file2, str).getPath();
    }

    private static void splitAndAdd(String str, boolean z, ArrayList<File> arrayList) {
        if (str == null) {
            return;
        }
        String[] split = str.split(":");
        int length = split.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            String str2 = split[i2];
            try {
                StructStat stat = Libcore.os.stat(str2);
                if (!z || OsConstants.S_ISDIR(stat.st_mode)) {
                    arrayList.add(new File(str2));
                }
            } catch (ErrnoException e) {
            }
            i = i2 + 1;
        }
    }

    private static ArrayList<File> splitDexPath(String str) {
        return splitPaths(str, null, false);
    }

    private static File[] splitLibraryPath(String str) {
        ArrayList<File> splitPaths = splitPaths(str, System.getProperty("java.library.path"), true);
        return (File[]) splitPaths.toArray(new File[splitPaths.size()]);
    }

    private static ArrayList<File> splitPaths(String str, String str2, boolean z) {
        ArrayList<File> arrayList = new ArrayList<>();
        splitAndAdd(str, z, arrayList);
        splitAndAdd(str2, z, arrayList);
        return arrayList;
    }

    public Class findClass(String str, List<Throwable> list) {
        Class loadClassBinaryName;
        Element[] elementArr = this.dexElements;
        int length = elementArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                if (this.dexElementsSuppressedExceptions != null) {
                    list.addAll(Arrays.asList(this.dexElementsSuppressedExceptions));
                    return null;
                }
                return null;
            }
            DexFile dexFile = elementArr[i2].dexFile;
            if (dexFile != null && (loadClassBinaryName = dexFile.loadClassBinaryName(str, this.definingContext, list)) != null) {
                return loadClassBinaryName;
            }
            i = i2 + 1;
        }
    }

    public String findLibrary(String str) {
        String mapLibraryName = System.mapLibraryName(str);
        File[] fileArr = this.nativeLibraryDirectories;
        int length = fileArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return null;
            }
            String path = new File(fileArr[i2], mapLibraryName).getPath();
            if (IoUtils.canOpenReadOnly(path)) {
                return path;
            }
            i = i2 + 1;
        }
    }

    public URL findResource(String str) {
        Element[] elementArr = this.dexElements;
        int length = elementArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return null;
            }
            URL findResource = elementArr[i2].findResource(str);
            if (findResource != null) {
                return findResource;
            }
            i = i2 + 1;
        }
    }

    public Enumeration<URL> findResources(String str) {
        ArrayList arrayList = new ArrayList();
        Element[] elementArr = this.dexElements;
        int length = elementArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return Collections.enumeration(arrayList);
            }
            URL findResource = elementArr[i2].findResource(str);
            if (findResource != null) {
                arrayList.add(findResource);
            }
            i = i2 + 1;
        }
    }

    public File[] getNativeLibraryDirectories() {
        return this.nativeLibraryDirectories;
    }

    public String toString() {
        return "DexPathList[" + Arrays.toString(this.dexElements) + ",nativeLibraryDirectories=" + Arrays.toString(this.nativeLibraryDirectories) + "]";
    }
}
