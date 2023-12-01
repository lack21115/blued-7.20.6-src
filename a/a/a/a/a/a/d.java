package a.a.a.a.a.a;

import a.a.a.a.a.e.h;
import com.qiniu.pili.droid.streaming.StreamingProfile;

/* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/a/d.class */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static final String f1219a = null;
    public StreamingProfile.Stream b;

    /* renamed from: c  reason: collision with root package name */
    public String f1220c;

    public d(StreamingProfile.Stream stream, String str) {
        if (stream == null) {
            this.f1220c = str;
        }
        this.b = stream;
    }

    public String a() {
        StreamingProfile.Stream stream = this.b;
        if (stream != null) {
            this.f1220c = a(stream);
        }
        String str = f1219a;
        if (str != null) {
            this.f1220c = str;
        }
        return this.f1220c;
    }

    public final String a(StreamingProfile.Stream stream) {
        if (!"dynamic".equals(stream.getPublishSecurity()) && "static".equals(stream.getPublishSecurity())) {
            return h.a(stream, "rtmp");
        }
        return h.b(stream, "rtmp");
    }
}
