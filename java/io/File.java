package java.io;

import android.content.ContentResolver;
import android.system.ErrnoException;
import android.system.OsConstants;
import android.system.StructStat;
import android.system.StructStatVfs;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import libcore.io.DeleteOnExit;
import libcore.io.IoUtils;
import libcore.io.Libcore;

/* loaded from: source-2895416-dex2jar.jar:java/io/File.class */
public class File implements Serializable, Comparable<File> {
    private static final long serialVersionUID = 301077366599181567L;
    private String path;
    private static final Random tempFileRandom = new Random();
    public static final char separatorChar = System.getProperty("file.separator", BridgeUtil.SPLIT_MARK).charAt(0);
    public static final char pathSeparatorChar = System.getProperty("path.separator", ":").charAt(0);
    public static final String separator = String.valueOf(separatorChar);
    public static final String pathSeparator = String.valueOf(pathSeparatorChar);

    public File(File file, String str) {
        this(file == null ? null : file.getPath(), str);
    }

    public File(String str) {
        this.path = fixSlashes(str);
    }

    public File(String str, String str2) {
        if (str2 == null) {
            throw new NullPointerException("name == null");
        }
        if (str == null || str.isEmpty()) {
            this.path = fixSlashes(str2);
        } else if (str2.isEmpty()) {
            this.path = fixSlashes(str);
        } else {
            this.path = fixSlashes(join(str, str2));
        }
    }

    public File(URI uri) {
        checkURI(uri);
        this.path = fixSlashes(uri.getPath());
    }

    private static native String canonicalizePath(String str);

    private static void checkURI(URI uri) {
        if (!uri.isAbsolute()) {
            throw new IllegalArgumentException("URI is not absolute: " + uri);
        }
        if (!uri.getRawSchemeSpecificPart().startsWith(BridgeUtil.SPLIT_MARK)) {
            throw new IllegalArgumentException("URI is not hierarchical: " + uri);
        }
        if (!ContentResolver.SCHEME_FILE.equals(uri.getScheme())) {
            throw new IllegalArgumentException("Expected file scheme in URI: " + uri);
        }
        String rawPath = uri.getRawPath();
        if (rawPath == null || rawPath.isEmpty()) {
            throw new IllegalArgumentException("Expected non-empty path in URI: " + uri);
        }
        if (uri.getRawAuthority() != null) {
            throw new IllegalArgumentException("Found authority in URI: " + uri);
        }
        if (uri.getRawQuery() != null) {
            throw new IllegalArgumentException("Found query in URI: " + uri);
        }
        if (uri.getRawFragment() != null) {
            throw new IllegalArgumentException("Found fragment in URI: " + uri);
        }
    }

    public static File createTempFile(String str, String str2) throws IOException {
        return createTempFile(str, str2, null);
    }

    public static File createTempFile(String str, String str2, File file) throws IOException {
        File file2;
        if (str.length() < 3) {
            throw new IllegalArgumentException("prefix must be at least 3 characters");
        }
        String str3 = str2;
        if (str2 == null) {
            str3 = ".tmp";
        }
        File file3 = file;
        if (file == null) {
            file3 = new File(System.getProperty("java.io.tmpdir", "."));
        }
        do {
            file2 = new File(file3, str + tempFileRandom.nextInt() + str3);
        } while (!file2.createNewFile());
        return file2;
    }

    private boolean doAccess(int i) {
        try {
            return Libcore.os.access(this.path, i);
        } catch (ErrnoException e) {
            return false;
        }
    }

    private boolean doChmod(int i, boolean z) {
        try {
            StructStat stat = Libcore.os.stat(this.path);
            Libcore.os.chmod(this.path, z ? stat.st_mode | i : stat.st_mode & (i ^ (-1)));
            return true;
        } catch (ErrnoException e) {
            return false;
        }
    }

    private File[] filenamesToFiles(String[] strArr) {
        File[] fileArr;
        if (strArr != null) {
            int length = strArr.length;
            File[] fileArr2 = new File[length];
            int i = 0;
            while (true) {
                int i2 = i;
                fileArr = fileArr2;
                if (i2 >= length) {
                    break;
                }
                fileArr2[i2] = new File(this, strArr[i2]);
                i = i2 + 1;
            }
        } else {
            fileArr = null;
        }
        return fileArr;
    }

    private static String fixSlashes(String str) {
        boolean z = false;
        char[] charArray = str.toCharArray();
        int length = charArray.length;
        int i = 0;
        for (char c2 : charArray) {
            if (c2 != '/') {
                charArray[i] = c2;
                z = false;
                i++;
            } else if (!z) {
                charArray[i] = separatorChar;
                i++;
                z = true;
            }
        }
        if (z && i > 1) {
            i--;
        }
        if (i != length) {
            str = new String(charArray, 0, i);
        }
        return str;
    }

    private String getAbsoluteName() {
        File absoluteFile = getAbsoluteFile();
        String path = absoluteFile.getPath();
        String str = path;
        if (absoluteFile.isDirectory()) {
            str = path;
            if (path.charAt(path.length() - 1) != separatorChar) {
                str = path + BridgeUtil.SPLIT_MARK;
            }
        }
        String str2 = str;
        if (separatorChar != '/') {
            str2 = str.replace(separatorChar, '/');
        }
        return str2;
    }

    private static String join(String str, String str2) {
        int length = str.length();
        boolean z = length > 0 && str.charAt(length - 1) == separatorChar;
        boolean z2 = z;
        if (!z) {
            z2 = str2.length() > 0 && str2.charAt(0) == separatorChar;
        }
        return z2 ? str + str2 : str + separatorChar + str2;
    }

    private static native String[] listImpl(String str);

    public static File[] listRoots() {
        return new File[]{new File(BridgeUtil.SPLIT_MARK)};
    }

    private void mkdirErrno() throws ErrnoException {
        Libcore.os.mkdir(this.path, OsConstants.S_IRWXU);
    }

    private boolean mkdirs(boolean z) {
        try {
            mkdirErrno();
            return true;
        } catch (ErrnoException e) {
            if (e.errno == OsConstants.ENOENT) {
                File parentFile = getParentFile();
                return parentFile != null && parentFile.mkdirs(true) && mkdir();
            } else if (e.errno == OsConstants.EEXIST) {
                return z;
            } else {
                return false;
            }
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.path = fixSlashes(this.path.replace(objectInputStream.readChar(), separatorChar));
    }

    private static native boolean setLastModifiedImpl(String str, long j);

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeChar(separatorChar);
    }

    public boolean canExecute() {
        return doAccess(OsConstants.X_OK);
    }

    public boolean canRead() {
        return doAccess(OsConstants.R_OK);
    }

    public boolean canWrite() {
        return doAccess(OsConstants.W_OK);
    }

    @Override // java.lang.Comparable
    public int compareTo(File file) {
        return getPath().compareTo(file.getPath());
    }

    public boolean createNewFile() throws IOException {
        try {
            try {
                IoUtils.close(Libcore.os.open(this.path, OsConstants.O_RDWR | OsConstants.O_CREAT | OsConstants.O_EXCL, 384));
                return true;
            } catch (ErrnoException e) {
                if (e.errno != OsConstants.EEXIST) {
                    throw e.rethrowAsIOException();
                }
                IoUtils.close(null);
                return false;
            }
        } catch (Throwable th) {
            IoUtils.close(null);
            throw th;
        }
    }

    public boolean delete() {
        try {
            Libcore.os.remove(this.path);
            return true;
        } catch (ErrnoException e) {
            return false;
        }
    }

    public void deleteOnExit() {
        DeleteOnExit.getInstance().addFile(getAbsolutePath());
    }

    public boolean equals(Object obj) {
        if (obj instanceof File) {
            return this.path.equals(((File) obj).getPath());
        }
        return false;
    }

    public boolean exists() {
        return doAccess(OsConstants.F_OK);
    }

    public File getAbsoluteFile() {
        return new File(getAbsolutePath());
    }

    public String getAbsolutePath() {
        String str;
        if (isAbsolute()) {
            str = this.path;
        } else {
            String property = System.getProperty("user.dir");
            str = property;
            if (!this.path.isEmpty()) {
                return join(property, this.path);
            }
        }
        return str;
    }

    public File getCanonicalFile() throws IOException {
        return new File(getCanonicalPath());
    }

    public String getCanonicalPath() throws IOException {
        return canonicalizePath(getAbsolutePath());
    }

    public long getFreeSpace() {
        try {
            StructStatVfs statvfs = Libcore.os.statvfs(this.path);
            return statvfs.f_bfree * statvfs.f_bsize;
        } catch (ErrnoException e) {
            return 0L;
        }
    }

    public String getName() {
        int lastIndexOf = this.path.lastIndexOf(separator);
        return lastIndexOf < 0 ? this.path : this.path.substring(lastIndexOf + 1, this.path.length());
    }

    public String getParent() {
        int length = this.path.length();
        int i = 0;
        if (separatorChar == '\\') {
            i = 0;
            if (length > 2) {
                i = 0;
                if (this.path.charAt(1) == ':') {
                    i = 2;
                }
            }
        }
        int lastIndexOf = this.path.lastIndexOf(separatorChar);
        int i2 = lastIndexOf;
        if (lastIndexOf == -1) {
            i2 = lastIndexOf;
            if (i > 0) {
                i2 = 2;
            }
        }
        if (i2 == -1 || this.path.charAt(length - 1) == separatorChar) {
            return null;
        }
        return (this.path.indexOf(separatorChar) == i2 && this.path.charAt(i) == separatorChar) ? this.path.substring(0, i2 + 1) : this.path.substring(0, i2);
    }

    public File getParentFile() {
        String parent = getParent();
        if (parent == null) {
            return null;
        }
        return new File(parent);
    }

    public String getPath() {
        return this.path;
    }

    public long getTotalSpace() {
        try {
            StructStatVfs statvfs = Libcore.os.statvfs(this.path);
            return statvfs.f_blocks * statvfs.f_bsize;
        } catch (ErrnoException e) {
            return 0L;
        }
    }

    public long getUsableSpace() {
        try {
            StructStatVfs statvfs = Libcore.os.statvfs(this.path);
            return statvfs.f_bavail * statvfs.f_bsize;
        } catch (ErrnoException e) {
            return 0L;
        }
    }

    public int hashCode() {
        return getPath().hashCode() ^ 1234321;
    }

    public boolean isAbsolute() {
        boolean z = false;
        if (this.path.length() > 0) {
            z = false;
            if (this.path.charAt(0) == separatorChar) {
                z = true;
            }
        }
        return z;
    }

    public boolean isDirectory() {
        try {
            return OsConstants.S_ISDIR(Libcore.os.stat(this.path).st_mode);
        } catch (ErrnoException e) {
            return false;
        }
    }

    public boolean isFile() {
        try {
            return OsConstants.S_ISREG(Libcore.os.stat(this.path).st_mode);
        } catch (ErrnoException e) {
            return false;
        }
    }

    public boolean isHidden() {
        if (this.path.isEmpty()) {
            return false;
        }
        return getName().startsWith(".");
    }

    public long lastModified() {
        try {
            return Libcore.os.stat(this.path).st_mtime * 1000;
        } catch (ErrnoException e) {
            return 0L;
        }
    }

    public long length() {
        try {
            return Libcore.os.stat(this.path).st_size;
        } catch (ErrnoException e) {
            return 0L;
        }
    }

    public String[] list() {
        return listImpl(this.path);
    }

    public String[] list(FilenameFilter filenameFilter) {
        String[] list = list();
        if (filenameFilter == null || list == null) {
            return list;
        }
        ArrayList arrayList = new ArrayList(list.length);
        int length = list.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return (String[]) arrayList.toArray(new String[arrayList.size()]);
            }
            String str = list[i2];
            if (filenameFilter.accept(this, str)) {
                arrayList.add(str);
            }
            i = i2 + 1;
        }
    }

    public File[] listFiles() {
        return filenamesToFiles(list());
    }

    public File[] listFiles(FileFilter fileFilter) {
        File[] listFiles = listFiles();
        if (fileFilter == null || listFiles == null) {
            return listFiles;
        }
        ArrayList arrayList = new ArrayList(listFiles.length);
        int length = listFiles.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return (File[]) arrayList.toArray(new File[arrayList.size()]);
            }
            File file = listFiles[i2];
            if (fileFilter.accept(file)) {
                arrayList.add(file);
            }
            i = i2 + 1;
        }
    }

    public File[] listFiles(FilenameFilter filenameFilter) {
        return filenamesToFiles(list(filenameFilter));
    }

    public boolean mkdir() {
        try {
            mkdirErrno();
            return true;
        } catch (ErrnoException e) {
            return false;
        }
    }

    public boolean mkdirs() {
        return mkdirs(false);
    }

    public boolean renameTo(File file) {
        try {
            Libcore.os.rename(this.path, file.path);
            return true;
        } catch (ErrnoException e) {
            return false;
        }
    }

    public boolean setExecutable(boolean z) {
        return setExecutable(z, true);
    }

    public boolean setExecutable(boolean z, boolean z2) {
        return doChmod(z2 ? OsConstants.S_IXUSR : OsConstants.S_IXUSR | OsConstants.S_IXGRP | OsConstants.S_IXOTH, z);
    }

    public boolean setLastModified(long j) {
        if (j < 0) {
            throw new IllegalArgumentException("time < 0");
        }
        return setLastModifiedImpl(this.path, j);
    }

    public boolean setReadOnly() {
        return setWritable(false, false);
    }

    public boolean setReadable(boolean z) {
        return setReadable(z, true);
    }

    public boolean setReadable(boolean z, boolean z2) {
        return doChmod(z2 ? OsConstants.S_IRUSR : OsConstants.S_IRUSR | OsConstants.S_IRGRP | OsConstants.S_IROTH, z);
    }

    public boolean setWritable(boolean z) {
        return setWritable(z, true);
    }

    public boolean setWritable(boolean z, boolean z2) {
        return doChmod(z2 ? OsConstants.S_IWUSR : OsConstants.S_IWUSR | OsConstants.S_IWGRP | OsConstants.S_IWOTH, z);
    }

    public String toString() {
        return this.path;
    }

    public URI toURI() {
        String absoluteName = getAbsoluteName();
        try {
            return !absoluteName.startsWith(BridgeUtil.SPLIT_MARK) ? new URI(ContentResolver.SCHEME_FILE, null, BridgeUtil.SPLIT_MARK + absoluteName, null, null) : absoluteName.startsWith("//") ? new URI(ContentResolver.SCHEME_FILE, "", absoluteName, null) : new URI(ContentResolver.SCHEME_FILE, null, absoluteName, null, null);
        } catch (URISyntaxException e) {
            return null;
        }
    }

    @Deprecated
    public URL toURL() throws MalformedURLException {
        String absoluteName = getAbsoluteName();
        return !absoluteName.startsWith(BridgeUtil.SPLIT_MARK) ? new URL(ContentResolver.SCHEME_FILE, "", -1, BridgeUtil.SPLIT_MARK + absoluteName, null) : absoluteName.startsWith("//") ? new URL("file:" + absoluteName) : new URL(ContentResolver.SCHEME_FILE, "", -1, absoluteName, null);
    }
}
