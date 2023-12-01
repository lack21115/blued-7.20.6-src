package bolts;

import java.util.Locale;

/* loaded from: source-8756600-dex2jar.jar:bolts/CancellationToken.class */
public class CancellationToken {

    /* renamed from: a  reason: collision with root package name */
    private final CancellationTokenSource f3638a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CancellationToken(CancellationTokenSource cancellationTokenSource) {
        this.f3638a = cancellationTokenSource;
    }

    public boolean a() {
        return this.f3638a.a();
    }

    public String toString() {
        return String.format(Locale.US, "%s@%s[cancellationRequested=%s]", getClass().getName(), Integer.toHexString(hashCode()), Boolean.toString(this.f3638a.a()));
    }
}
