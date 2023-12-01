package java.sql;

import java.io.Serializable;

/* loaded from: source-2895416-dex2jar.jar:java/sql/DataTruncation.class */
public class DataTruncation extends SQLWarning implements Serializable {
    private static final int THE_ERROR_CODE = 0;
    private static final String THE_REASON = "Data truncation";
    private static final String THE_SQLSTATE_READ = "01004";
    private static final String THE_SQLSTATE_WRITE = "22001";
    private static final long serialVersionUID = 6464298989504059473L;
    private int dataSize;
    private int index;
    private boolean parameter;
    private boolean read;
    private int transferSize;

    public DataTruncation(int i, boolean z, boolean z2, int i2, int i3) {
        super(THE_REASON, THE_SQLSTATE_READ, 0);
        this.index = 0;
        this.parameter = false;
        this.read = false;
        this.dataSize = 0;
        this.transferSize = 0;
        this.index = i;
        this.parameter = z;
        this.read = z2;
        this.dataSize = i2;
        this.transferSize = i3;
    }

    public DataTruncation(int i, boolean z, boolean z2, int i2, int i3, Throwable th) {
        super(THE_REASON, z2 ? THE_SQLSTATE_READ : THE_SQLSTATE_WRITE, 0, th);
        this.index = 0;
        this.parameter = false;
        this.read = false;
        this.dataSize = 0;
        this.transferSize = 0;
        this.index = i;
        this.parameter = z;
        this.read = z2;
        this.dataSize = i2;
        this.transferSize = i3;
    }

    public int getDataSize() {
        return this.dataSize;
    }

    public int getIndex() {
        return this.index;
    }

    public boolean getParameter() {
        return this.parameter;
    }

    public boolean getRead() {
        return this.read;
    }

    public int getTransferSize() {
        return this.transferSize;
    }
}
