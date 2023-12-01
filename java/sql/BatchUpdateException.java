package java.sql;

import java.io.Serializable;

/* loaded from: source-2895416-dex2jar.jar:java/sql/BatchUpdateException.class */
public class BatchUpdateException extends SQLException implements Serializable {
    private static final long serialVersionUID = 5977529877145521757L;
    private int[] updateCounts;

    public BatchUpdateException() {
        this.updateCounts = null;
    }

    public BatchUpdateException(String str, String str2, int i, int[] iArr) {
        super(str, str2, i);
        this.updateCounts = null;
        this.updateCounts = iArr;
    }

    public BatchUpdateException(String str, String str2, int i, int[] iArr, Throwable th) {
        super(str, str2, i, th);
        this.updateCounts = null;
        this.updateCounts = iArr;
    }

    public BatchUpdateException(String str, String str2, int[] iArr) {
        super(str, str2);
        this.updateCounts = null;
        this.updateCounts = iArr;
    }

    public BatchUpdateException(String str, String str2, int[] iArr, Throwable th) {
        super(str, str2, th);
        this.updateCounts = null;
        this.updateCounts = iArr;
    }

    public BatchUpdateException(String str, int[] iArr) {
        super(str);
        this.updateCounts = null;
        this.updateCounts = iArr;
    }

    public BatchUpdateException(String str, int[] iArr, Throwable th) {
        super(str, th);
        this.updateCounts = null;
        this.updateCounts = iArr;
    }

    public BatchUpdateException(Throwable th) {
        this((int[]) null, th);
    }

    public BatchUpdateException(int[] iArr) {
        this.updateCounts = null;
        this.updateCounts = iArr;
    }

    public BatchUpdateException(int[] iArr, Throwable th) {
        super(th);
        this.updateCounts = null;
        this.updateCounts = iArr;
    }

    public int[] getUpdateCounts() {
        return this.updateCounts;
    }
}
