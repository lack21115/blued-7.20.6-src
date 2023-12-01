package com.opos.exoplayer.core.h;

import android.text.TextUtils;
import com.opos.exoplayer.core.h.g;
import com.opos.exoplayer.core.i.u;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.XMLConstants;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/h/q.class */
public interface q extends g {

    /* renamed from: a  reason: collision with root package name */
    public static final com.opos.exoplayer.core.i.o<String> f25466a = new com.opos.exoplayer.core.i.o<String>() { // from class: com.opos.exoplayer.core.h.q.1
        @Override // com.opos.exoplayer.core.i.o
        public boolean a(String str) {
            String d2 = u.d(str);
            if (TextUtils.isEmpty(d2)) {
                return false;
            }
            return ((d2.contains("text") && !d2.contains("text/vtt")) || d2.contains(com.baidu.mobads.sdk.internal.a.f) || d2.contains(XMLConstants.XML_NS_PREFIX)) ? false : true;
        }
    };

    /* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/h/q$a.class */
    public static abstract class a implements b {

        /* renamed from: a  reason: collision with root package name */
        private final f f25467a = new f();

        @Override // com.opos.exoplayer.core.h.g.a
        /* renamed from: b */
        public final q a() {
            return b(this.f25467a);
        }

        protected abstract q b(f fVar);
    }

    /* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/h/q$b.class */
    public interface b extends g.a {
    }

    /* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/h/q$c.class */
    public static class c extends IOException {

        /* renamed from: a  reason: collision with root package name */
        public final int f25468a;
        public final i b;

        public c(IOException iOException, i iVar, int i) {
            super(iOException);
            this.b = iVar;
            this.f25468a = i;
        }

        public c(String str, i iVar, int i) {
            super(str);
            this.b = iVar;
            this.f25468a = i;
        }

        public c(String str, IOException iOException, i iVar, int i) {
            super(str, iOException);
            this.b = iVar;
            this.f25468a = i;
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/h/q$d.class */
    public static final class d extends c {

        /* renamed from: c  reason: collision with root package name */
        public final String f25469c;

        public d(String str, i iVar) {
            super("Invalid content type: " + str, iVar, 1);
            this.f25469c = str;
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/h/q$e.class */
    public static final class e extends c {

        /* renamed from: c  reason: collision with root package name */
        public final int f25470c;
        public final Map<String, List<String>> d;

        public e(int i, Map<String, List<String>> map, i iVar) {
            super("Response code: " + i, iVar, 1);
            this.f25470c = i;
            this.d = map;
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/h/q$f.class */
    public static final class f {

        /* renamed from: a  reason: collision with root package name */
        private final Map<String, String> f25471a = new HashMap();
        private Map<String, String> b;

        public Map<String, String> a() {
            Map<String, String> map;
            synchronized (this) {
                if (this.b == null) {
                    this.b = Collections.unmodifiableMap(new HashMap(this.f25471a));
                }
                map = this.b;
            }
            return map;
        }
    }
}
