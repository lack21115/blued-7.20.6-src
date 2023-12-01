package androidx.constraintlayout.core.parser;

/* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/core/parser/CLParsingException.class */
public class CLParsingException extends Exception {

    /* renamed from: a  reason: collision with root package name */
    private final String f2081a;
    private final int b;

    /* renamed from: c  reason: collision with root package name */
    private final String f2082c;

    public CLParsingException(String str, CLElement cLElement) {
        this.f2081a = str;
        if (cLElement != null) {
            this.f2082c = cLElement.a();
            this.b = cLElement.getLine();
            return;
        }
        this.f2082c = "unknown";
        this.b = 0;
    }

    public String reason() {
        return this.f2081a + " (" + this.f2082c + " at line " + this.b + ")";
    }

    @Override // java.lang.Throwable
    public String toString() {
        return "CLParsingException (" + hashCode() + ") : " + reason();
    }
}
