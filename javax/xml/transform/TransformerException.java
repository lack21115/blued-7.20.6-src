package javax.xml.transform;

import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;

/* loaded from: source-2895416-dex2jar.jar:javax/xml/transform/TransformerException.class */
public class TransformerException extends Exception {
    private static final long serialVersionUID = 975798773772956428L;
    Throwable containedException;
    SourceLocator locator;

    public TransformerException(String str) {
        super(str);
        this.containedException = null;
        this.locator = null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x000a, code lost:
        if (r4.length() == 0) goto L8;
     */
    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public TransformerException(java.lang.String r4, java.lang.Throwable r5) {
        /*
            r3 = this;
            r0 = r4
            if (r0 == 0) goto Ld
            r0 = r4
            r6 = r0
            r0 = r4
            int r0 = r0.length()
            if (r0 != 0) goto L12
        Ld:
            r0 = r5
            java.lang.String r0 = r0.toString()
            r6 = r0
        L12:
            r0 = r3
            r1 = r6
            r0.<init>(r1)
            r0 = r3
            r1 = r5
            r0.containedException = r1
            r0 = r3
            r1 = 0
            r0.locator = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.xml.transform.TransformerException.<init>(java.lang.String, java.lang.Throwable):void");
    }

    public TransformerException(String str, SourceLocator sourceLocator) {
        super(str);
        this.containedException = null;
        this.locator = sourceLocator;
    }

    public TransformerException(String str, SourceLocator sourceLocator, Throwable th) {
        super(str);
        this.containedException = th;
        this.locator = sourceLocator;
    }

    public TransformerException(Throwable th) {
        super(th.toString());
        this.containedException = th;
        this.locator = null;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        if (this.containedException == this) {
            return null;
        }
        return this.containedException;
    }

    public Throwable getException() {
        return this.containedException;
    }

    public String getLocationAsString() {
        if (this.locator != null) {
            StringBuilder sb = new StringBuilder();
            String systemId = this.locator.getSystemId();
            int lineNumber = this.locator.getLineNumber();
            int columnNumber = this.locator.getColumnNumber();
            if (systemId != null) {
                sb.append("; SystemID: ");
                sb.append(systemId);
            }
            if (lineNumber != 0) {
                sb.append("; Line#: ");
                sb.append(lineNumber);
            }
            if (columnNumber != 0) {
                sb.append("; Column#: ");
                sb.append(columnNumber);
            }
            return sb.toString();
        }
        return null;
    }

    public SourceLocator getLocator() {
        return this.locator;
    }

    public String getMessageAndLocation() {
        StringBuilder sb = new StringBuilder();
        String message = super.getMessage();
        if (message != null) {
            sb.append(message);
        }
        if (this.locator != null) {
            String systemId = this.locator.getSystemId();
            int lineNumber = this.locator.getLineNumber();
            int columnNumber = this.locator.getColumnNumber();
            if (systemId != null) {
                sb.append("; SystemID: ");
                sb.append(systemId);
            }
            if (lineNumber != 0) {
                sb.append("; Line#: ");
                sb.append(lineNumber);
            }
            if (columnNumber != 0) {
                sb.append("; Column#: ");
                sb.append(columnNumber);
            }
        }
        return sb.toString();
    }

    @Override // java.lang.Throwable
    public Throwable initCause(Throwable th) {
        synchronized (this) {
            if (this.containedException != null) {
                throw new IllegalStateException("Can't overwrite cause");
            }
            if (th == this) {
                throw new IllegalArgumentException("Self-causation not permitted");
            }
            this.containedException = th;
        }
        return this;
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        printStackTrace(new PrintWriter((OutputStream) System.err, true));
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream printStream) {
        printStackTrace(new PrintWriter(printStream));
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter printWriter) {
        PrintWriter printWriter2 = printWriter;
        if (printWriter == null) {
            printWriter2 = new PrintWriter((OutputStream) System.err, true);
        }
        try {
            String locationAsString = getLocationAsString();
            if (locationAsString != null) {
                printWriter2.println(locationAsString);
            }
            super.printStackTrace(printWriter2);
        } catch (Throwable th) {
        }
    }

    public void setLocator(SourceLocator sourceLocator) {
        this.locator = sourceLocator;
    }
}
