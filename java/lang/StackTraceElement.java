package java.lang;

import java.io.Serializable;

/* loaded from: source-2895416-dex2jar.jar:java/lang/StackTraceElement.class */
public final class StackTraceElement implements Serializable {
    private static final int NATIVE_LINE_NUMBER = -2;
    private static final long serialVersionUID = 6992337162326171013L;
    String declaringClass;
    String fileName;
    int lineNumber;
    String methodName;

    private StackTraceElement() {
    }

    public StackTraceElement(String str, String str2, String str3, int i) {
        if (str == null) {
            throw new NullPointerException("cls == null");
        }
        if (str2 == null) {
            throw new NullPointerException("method == null");
        }
        this.declaringClass = str;
        this.methodName = str2;
        this.fileName = str3;
        this.lineNumber = i;
    }

    public boolean equals(Object obj) {
        if (obj instanceof StackTraceElement) {
            StackTraceElement stackTraceElement = (StackTraceElement) obj;
            if (this.methodName == null || stackTraceElement.methodName == null || !getMethodName().equals(stackTraceElement.getMethodName()) || !getClassName().equals(stackTraceElement.getClassName())) {
                return false;
            }
            String fileName = getFileName();
            if (fileName == null) {
                if (stackTraceElement.getFileName() != null) {
                    return false;
                }
            } else if (!fileName.equals(stackTraceElement.getFileName())) {
                return false;
            }
            return getLineNumber() == stackTraceElement.getLineNumber();
        }
        return false;
    }

    public String getClassName() {
        return this.declaringClass == null ? "<unknown class>" : this.declaringClass;
    }

    public String getFileName() {
        return this.fileName;
    }

    public int getLineNumber() {
        return this.lineNumber;
    }

    public String getMethodName() {
        return this.methodName == null ? "<unknown method>" : this.methodName;
    }

    public int hashCode() {
        if (this.methodName == null) {
            return 0;
        }
        return this.methodName.hashCode() ^ this.declaringClass.hashCode();
    }

    public boolean isNativeMethod() {
        return this.lineNumber == -2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(80);
        sb.append(getClassName());
        sb.append('.');
        sb.append(getMethodName());
        if (isNativeMethod()) {
            sb.append("(Native Method)");
        } else {
            String fileName = getFileName();
            if (fileName == null) {
                sb.append("(Unknown Source)");
            } else {
                int lineNumber = getLineNumber();
                sb.append('(');
                sb.append(fileName);
                if (lineNumber >= 0) {
                    sb.append(':');
                    sb.append(lineNumber);
                }
                sb.append(')');
            }
        }
        return sb.toString();
    }
}
