package androidx.documentfile.provider;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.DocumentsContract;
import android.util.Log;
import java.util.ArrayList;

/* loaded from: source-8756600-dex2jar.jar:androidx/documentfile/provider/TreeDocumentFile.class */
class TreeDocumentFile extends DocumentFile {

    /* renamed from: a  reason: collision with root package name */
    private Context f2780a;
    private Uri b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TreeDocumentFile(DocumentFile documentFile, Context context, Uri uri) {
        super(documentFile);
        this.f2780a = context;
        this.b = uri;
    }

    private static Uri a(Context context, Uri uri, String str, String str2) {
        try {
            return DocumentsContract.createDocument(context.getContentResolver(), uri, str, str2);
        } catch (Exception e) {
            return null;
        }
    }

    private static void a(AutoCloseable autoCloseable) {
        if (autoCloseable != null) {
            try {
                autoCloseable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception e2) {
            }
        }
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public boolean canRead() {
        return DocumentsContractApi19.canRead(this.f2780a, this.b);
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public boolean canWrite() {
        return DocumentsContractApi19.canWrite(this.f2780a, this.b);
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public DocumentFile createDirectory(String str) {
        Uri a2 = a(this.f2780a, this.b, DocumentsContract.Document.MIME_TYPE_DIR, str);
        if (a2 != null) {
            return new TreeDocumentFile(this, this.f2780a, a2);
        }
        return null;
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public DocumentFile createFile(String str, String str2) {
        Uri a2 = a(this.f2780a, this.b, str, str2);
        if (a2 != null) {
            return new TreeDocumentFile(this, this.f2780a, a2);
        }
        return null;
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public boolean delete() {
        try {
            return DocumentsContract.deleteDocument(this.f2780a.getContentResolver(), this.b);
        } catch (Exception e) {
            return false;
        }
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public boolean exists() {
        return DocumentsContractApi19.exists(this.f2780a, this.b);
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public String getName() {
        return DocumentsContractApi19.getName(this.f2780a, this.b);
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public String getType() {
        return DocumentsContractApi19.getType(this.f2780a, this.b);
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public Uri getUri() {
        return this.b;
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public boolean isDirectory() {
        return DocumentsContractApi19.isDirectory(this.f2780a, this.b);
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public boolean isFile() {
        return DocumentsContractApi19.isFile(this.f2780a, this.b);
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public boolean isVirtual() {
        return DocumentsContractApi19.isVirtual(this.f2780a, this.b);
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public long lastModified() {
        return DocumentsContractApi19.lastModified(this.f2780a, this.b);
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public long length() {
        return DocumentsContractApi19.length(this.f2780a, this.b);
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public DocumentFile[] listFiles() {
        Cursor cursor;
        ContentResolver contentResolver = this.f2780a.getContentResolver();
        Uri uri = this.b;
        Uri buildChildDocumentsUriUsingTree = DocumentsContract.buildChildDocumentsUriUsingTree(uri, DocumentsContract.getDocumentId(uri));
        ArrayList arrayList = new ArrayList();
        Cursor cursor2 = null;
        Cursor cursor3 = null;
        try {
            try {
                Cursor query = contentResolver.query(buildChildDocumentsUriUsingTree, new String[]{"document_id"}, null, null, null);
                while (true) {
                    cursor = query;
                    cursor3 = query;
                    cursor2 = query;
                    if (!query.moveToNext()) {
                        break;
                    }
                    arrayList.add(DocumentsContract.buildDocumentUriUsingTree(this.b, query.getString(0)));
                }
            } catch (Exception e) {
                StringBuilder sb = new StringBuilder();
                Cursor cursor4 = cursor2;
                sb.append("Failed query: ");
                Cursor cursor5 = cursor2;
                sb.append(e);
                Cursor cursor6 = cursor2;
                Log.w("DocumentFile", sb.toString());
                cursor = cursor2;
            }
            Uri[] uriArr = (Uri[]) arrayList.toArray(new Uri[arrayList.size()]);
            DocumentFile[] documentFileArr = new DocumentFile[uriArr.length];
            for (int i = 0; i < uriArr.length; i++) {
                documentFileArr[i] = new TreeDocumentFile(this, this.f2780a, uriArr[i]);
            }
            return documentFileArr;
        } finally {
            a(cursor3);
        }
    }

    @Override // androidx.documentfile.provider.DocumentFile
    public boolean renameTo(String str) {
        try {
            Uri renameDocument = DocumentsContract.renameDocument(this.f2780a.getContentResolver(), this.b, str);
            if (renameDocument != null) {
                this.b = renameDocument;
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }
}
