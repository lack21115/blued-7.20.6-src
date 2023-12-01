package androidx.core.provider;

import android.util.Base64;
import androidx.core.util.Preconditions;
import com.xiaomi.mipush.sdk.Constants;
import java.util.List;

/* loaded from: source-8756600-dex2jar.jar:androidx/core/provider/FontRequest.class */
public final class FontRequest {

    /* renamed from: a  reason: collision with root package name */
    private final String f2481a;
    private final String b;

    /* renamed from: c  reason: collision with root package name */
    private final String f2482c;
    private final List<List<byte[]>> d;
    private final int e;
    private final String f;

    public FontRequest(String str, String str2, String str3, int i) {
        this.f2481a = (String) Preconditions.checkNotNull(str);
        this.b = (String) Preconditions.checkNotNull(str2);
        this.f2482c = (String) Preconditions.checkNotNull(str3);
        this.d = null;
        Preconditions.checkArgument(i != 0);
        this.e = i;
        this.f = a(str, str2, str3);
    }

    public FontRequest(String str, String str2, String str3, List<List<byte[]>> list) {
        this.f2481a = (String) Preconditions.checkNotNull(str);
        this.b = (String) Preconditions.checkNotNull(str2);
        this.f2482c = (String) Preconditions.checkNotNull(str3);
        this.d = (List) Preconditions.checkNotNull(list);
        this.e = 0;
        this.f = a(str, str2, str3);
    }

    private String a(String str, String str2, String str3) {
        return str + Constants.ACCEPT_TIME_SEPARATOR_SERVER + str2 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + str3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a() {
        return this.f;
    }

    public List<List<byte[]>> getCertificates() {
        return this.d;
    }

    public int getCertificatesArrayResId() {
        return this.e;
    }

    @Deprecated
    public String getIdentifier() {
        return this.f;
    }

    public String getProviderAuthority() {
        return this.f2481a;
    }

    public String getProviderPackage() {
        return this.b;
    }

    public String getQuery() {
        return this.f2482c;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FontRequest {mProviderAuthority: " + this.f2481a + ", mProviderPackage: " + this.b + ", mQuery: " + this.f2482c + ", mCertificates:");
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.d.size()) {
                sb.append("}");
                sb.append("mCertificatesArray: " + this.e);
                return sb.toString();
            }
            sb.append(" [");
            List<byte[]> list = this.d.get(i2);
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 < list.size()) {
                    sb.append(" \"");
                    sb.append(Base64.encodeToString(list.get(i4), 0));
                    sb.append("\"");
                    i3 = i4 + 1;
                }
            }
            sb.append(" ]");
            i = i2 + 1;
        }
    }
}
