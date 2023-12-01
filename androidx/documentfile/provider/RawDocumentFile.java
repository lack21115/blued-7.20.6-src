package androidx.documentfile.provider;

import android.net.Uri;
import android.util.Log;
import android.webkit.MimeTypeMap;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/* loaded from: source-8756600-dex2jar.jar:androidx/documentfile/provider/RawDocumentFile.class */
class RawDocumentFile extends DocumentFile {

    /* renamed from: a  reason: collision with root package name */
    private File f2778a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RawDocumentFile(DocumentFile documentFile, File file) {
        super(documentFile);
        this.f2778a = file;
    }

    private static String a(String str) {
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf >= 0) {
            String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(str.substring(lastIndexOf + 1).toLowerCase());
            return mimeTypeFromExtension != null ? mimeTypeFromExtension : "application/octet-stream";
        }
        return "application/octet-stream";
    }

    private static boolean a(File file) {
        File[] listFiles = file.listFiles();
        boolean z = true;
        boolean z2 = true;
        if (listFiles != null) {
            int length = listFiles.length;
            int i = 0;
            while (true) {
                int i2 = i;
                z = z2;
                if (i2 >= length) {
                    break;
                }
                File file2 = listFiles[i2];
                boolean z3 = z2;
                if (file2.isDirectory()) {
                    z3 = z2 & a(file2);
                }
                z2 = z3;
                if (!file2.delete()) {
                    Log.w("DocumentFile", "Failed to delete " + file2);
                    z2 = false;
                }
                i = i2 + 1;
            }
        }
        return z;
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public boolean canRead() {
        return this.f2778a.canRead();
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public boolean canWrite() {
        return this.f2778a.canWrite();
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public DocumentFile createDirectory(String str) {
        File file = new File(this.f2778a, str);
        if (file.isDirectory() || file.mkdir()) {
            return new RawDocumentFile(this, file);
        }
        return null;
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public DocumentFile createFile(String str, String str2) {
        String extensionFromMimeType = MimeTypeMap.getSingleton().getExtensionFromMimeType(str);
        String str3 = str2;
        if (extensionFromMimeType != null) {
            str3 = str2 + "." + extensionFromMimeType;
        }
        File file = new File(this.f2778a, str3);
        try {
            file.createNewFile();
            return new RawDocumentFile(this, file);
        } catch (IOException e) {
            Log.w("DocumentFile", "Failed to createFile: " + e);
            return null;
        }
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public boolean delete() {
        a(this.f2778a);
        return this.f2778a.delete();
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public boolean exists() {
        return this.f2778a.exists();
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public String getName() {
        return this.f2778a.getName();
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public String getType() {
        if (this.f2778a.isDirectory()) {
            return null;
        }
        return a(this.f2778a.getName());
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public Uri getUri() {
        return Uri.fromFile(this.f2778a);
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public boolean isDirectory() {
        return this.f2778a.isDirectory();
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public boolean isFile() {
        return this.f2778a.isFile();
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public boolean isVirtual() {
        return false;
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public long lastModified() {
        return this.f2778a.lastModified();
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public long length() {
        return this.f2778a.length();
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public DocumentFile[] listFiles() {
        ArrayList arrayList = new ArrayList();
        File[] listFiles = this.f2778a.listFiles();
        if (listFiles != null) {
            int length = listFiles.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    break;
                }
                arrayList.add(new RawDocumentFile(this, listFiles[i2]));
                i = i2 + 1;
            }
        }
        return (DocumentFile[]) arrayList.toArray(new DocumentFile[arrayList.size()]);
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public boolean renameTo(String str) {
        File file = new File(this.f2778a.getParentFile(), str);
        if (this.f2778a.renameTo(file)) {
            this.f2778a = file;
            return true;
        }
        return false;
    }
}
