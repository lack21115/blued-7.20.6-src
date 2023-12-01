package java.sql;

import java.io.Serializable;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: source-2895416-dex2jar.jar:java/sql/SQLException.class */
public class SQLException extends Exception implements Serializable, Iterable<Throwable> {
    private static final long serialVersionUID = 2135244094396331484L;
    private String SQLState;
    private SQLException next;
    private int vendorCode;

    /* loaded from: source-2895416-dex2jar.jar:java/sql/SQLException$InternalIterator.class */
    private static class InternalIterator implements Iterator<Throwable> {
        private SQLException current;

        InternalIterator(SQLException sQLException) {
            this.current = sQLException;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.current != null;
        }

        @Override // java.util.Iterator
        public Throwable next() {
            if (this.current == null) {
                throw new NoSuchElementException();
            }
            SQLException sQLException = this.current;
            this.current = this.current.next;
            return sQLException;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public SQLException() {
        this.SQLState = null;
        this.vendorCode = 0;
        this.next = null;
    }

    public SQLException(String str) {
        this(str, (String) null, 0);
    }

    public SQLException(String str, String str2) {
        this(str, str2, 0);
    }

    public SQLException(String str, String str2, int i) {
        super(str);
        this.SQLState = null;
        this.vendorCode = 0;
        this.next = null;
        this.SQLState = str2;
        this.vendorCode = i;
    }

    public SQLException(String str, String str2, int i, Throwable th) {
        this(str, str2, th);
        this.vendorCode = i;
    }

    public SQLException(String str, String str2, Throwable th) {
        super(str, th);
        this.SQLState = null;
        this.vendorCode = 0;
        this.next = null;
        this.SQLState = str2;
    }

    public SQLException(String str, Throwable th) {
        super(str, th);
        this.SQLState = null;
        this.vendorCode = 0;
        this.next = null;
    }

    public SQLException(Throwable th) {
        this(th == null ? null : th.toString(), null, 0, th);
    }

    public int getErrorCode() {
        return this.vendorCode;
    }

    public SQLException getNextException() {
        return this.next;
    }

    public String getSQLState() {
        return this.SQLState;
    }

    @Override // java.lang.Iterable
    public Iterator<Throwable> iterator() {
        return new InternalIterator(this);
    }

    public void setNextException(SQLException sQLException) {
        if (this.next != null) {
            this.next.setNextException(sQLException);
        } else {
            this.next = sQLException;
        }
    }
}
