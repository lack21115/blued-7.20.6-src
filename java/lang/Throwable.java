package java.lang;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import libcore.util.EmptyArray;

/* loaded from: source-2895416-dex2jar.jar:java/lang/Throwable.class */
public class Throwable implements Serializable {
    private static final long serialVersionUID = -3042686055658047285L;
    private Throwable cause;
    private String detailMessage;
    private volatile transient Object stackState;
    private StackTraceElement[] stackTrace;
    private List<Throwable> suppressedExceptions;

    public Throwable() {
        this.cause = this;
        this.suppressedExceptions = Collections.emptyList();
        this.stackTrace = EmptyArray.STACK_TRACE_ELEMENT;
        fillInStackTrace();
    }

    public Throwable(String str) {
        this.cause = this;
        this.suppressedExceptions = Collections.emptyList();
        this.detailMessage = str;
        this.stackTrace = EmptyArray.STACK_TRACE_ELEMENT;
        fillInStackTrace();
    }

    public Throwable(String str, Throwable th) {
        this.cause = this;
        this.suppressedExceptions = Collections.emptyList();
        this.detailMessage = str;
        this.cause = th;
        this.stackTrace = EmptyArray.STACK_TRACE_ELEMENT;
        fillInStackTrace();
    }

    protected Throwable(String str, Throwable th, boolean z, boolean z2) {
        this.cause = this;
        this.suppressedExceptions = Collections.emptyList();
        this.detailMessage = str;
        this.cause = th;
        if (!z) {
            this.suppressedExceptions = null;
        }
        if (!z2) {
            this.stackTrace = null;
            return;
        }
        this.stackTrace = EmptyArray.STACK_TRACE_ELEMENT;
        fillInStackTrace();
    }

    public Throwable(Throwable th) {
        this.cause = this;
        this.suppressedExceptions = Collections.emptyList();
        this.detailMessage = th == null ? null : th.toString();
        this.cause = th;
        this.stackTrace = EmptyArray.STACK_TRACE_ELEMENT;
        fillInStackTrace();
    }

    private static int countDuplicates(StackTraceElement[] stackTraceElementArr, StackTraceElement[] stackTraceElementArr2) {
        int i = 0;
        int length = stackTraceElementArr2.length;
        int length2 = stackTraceElementArr.length;
        while (true) {
            length2--;
            if (length2 < 0) {
                break;
            }
            length--;
            if (length < 0 || !stackTraceElementArr2[length].equals(stackTraceElementArr[length2])) {
                break;
            }
            i++;
        }
        return i;
    }

    private StackTraceElement[] getInternalStackTrace() {
        if (this.stackTrace != EmptyArray.STACK_TRACE_ELEMENT) {
            return this.stackTrace == null ? EmptyArray.STACK_TRACE_ELEMENT : this.stackTrace;
        }
        this.stackTrace = nativeGetStackTrace(this.stackState);
        this.stackState = null;
        return this.stackTrace;
    }

    private static native Object nativeFillInStackTrace();

    private static native StackTraceElement[] nativeGetStackTrace(Object obj);

    private void printStackTrace(Appendable appendable, String str, StackTraceElement[] stackTraceElementArr) throws IOException {
        appendable.append(toString());
        appendable.append("\n");
        StackTraceElement[] internalStackTrace = getInternalStackTrace();
        if (internalStackTrace != null) {
            int countDuplicates = stackTraceElementArr != null ? countDuplicates(internalStackTrace, stackTraceElementArr) : 0;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= internalStackTrace.length - countDuplicates) {
                    break;
                }
                appendable.append(str);
                appendable.append("\tat ");
                appendable.append(internalStackTrace[i2].toString());
                appendable.append("\n");
                i = i2 + 1;
            }
            if (countDuplicates > 0) {
                appendable.append(str);
                appendable.append("\t... ");
                appendable.append(Integer.toString(countDuplicates));
                appendable.append(" more\n");
            }
        }
        if (this.suppressedExceptions != null) {
            for (Throwable th : this.suppressedExceptions) {
                appendable.append(str);
                appendable.append("\tSuppressed: ");
                th.printStackTrace(appendable, str + "\t", internalStackTrace);
            }
        }
        Throwable cause = getCause();
        if (cause != null) {
            appendable.append(str);
            appendable.append("Caused by: ");
            cause.printStackTrace(appendable, str, internalStackTrace);
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        if (this.suppressedExceptions != null) {
            this.suppressedExceptions = new ArrayList(this.suppressedExceptions);
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        getInternalStackTrace();
        objectOutputStream.defaultWriteObject();
    }

    public final void addSuppressed(Throwable th) {
        if (th == this) {
            throw new IllegalArgumentException("throwable == this");
        }
        if (th == null) {
            throw new NullPointerException("throwable == null");
        }
        if (this.suppressedExceptions != null) {
            if (this.suppressedExceptions.isEmpty()) {
                this.suppressedExceptions = new ArrayList(1);
            }
            this.suppressedExceptions.add(th);
        }
    }

    public Throwable fillInStackTrace() {
        if (this.stackTrace == null) {
            return this;
        }
        this.stackState = nativeFillInStackTrace();
        this.stackTrace = EmptyArray.STACK_TRACE_ELEMENT;
        return this;
    }

    public Throwable getCause() {
        if (this.cause == this) {
            return null;
        }
        return this.cause;
    }

    public String getLocalizedMessage() {
        return getMessage();
    }

    public String getMessage() {
        return this.detailMessage;
    }

    public StackTraceElement[] getStackTrace() {
        return (StackTraceElement[]) getInternalStackTrace().clone();
    }

    public final Throwable[] getSuppressed() {
        return (this.suppressedExceptions == null || this.suppressedExceptions.isEmpty()) ? EmptyArray.THROWABLE : (Throwable[]) this.suppressedExceptions.toArray(new Throwable[this.suppressedExceptions.size()]);
    }

    public Throwable initCause(Throwable th) {
        if (this.cause != this) {
            throw new IllegalStateException("Cause already initialized");
        }
        if (th == this) {
            throw new IllegalArgumentException("throwable == this");
        }
        this.cause = th;
        return this;
    }

    public void printStackTrace() {
        printStackTrace(System.err);
    }

    public void printStackTrace(PrintStream printStream) {
        try {
            printStackTrace(printStream, "", null);
        } catch (IOException e) {
            throw new AssertionError();
        }
    }

    public void printStackTrace(PrintWriter printWriter) {
        try {
            printStackTrace(printWriter, "", null);
        } catch (IOException e) {
            throw new AssertionError();
        }
    }

    public void setStackTrace(StackTraceElement[] stackTraceElementArr) {
        if (this.stackTrace == null) {
            return;
        }
        StackTraceElement[] stackTraceElementArr2 = (StackTraceElement[]) stackTraceElementArr.clone();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= stackTraceElementArr2.length) {
                this.stackTrace = stackTraceElementArr2;
                return;
            } else if (stackTraceElementArr2[i2] == null) {
                throw new NullPointerException("trace[" + i2 + "] == null");
            } else {
                i = i2 + 1;
            }
        }
    }

    public String toString() {
        String localizedMessage = getLocalizedMessage();
        String name = getClass().getName();
        return localizedMessage == null ? name : name + ": " + localizedMessage;
    }
}
