package com.opos.exoplayer.core.f;

import com.anythink.expressad.exoplayer.k.o;
import com.opos.exoplayer.core.Format;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/f/g.class */
public interface g {

    /* renamed from: a  reason: collision with root package name */
    public static final g f11699a = new g() { // from class: com.opos.exoplayer.core.f.g.1
        @Override // com.opos.exoplayer.core.f.g
        public boolean a(Format format) {
            String str = format.f;
            return "text/vtt".equals(str) || o.P.equals(str) || o.Z.equals(str) || o.ab.equals(str) || "application/x-subrip".equals(str) || o.aa.equals(str) || o.W.equals(str) || o.ac.equals(str) || o.X.equals(str) || o.aj.equals(str) || o.af.equals(str);
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // com.opos.exoplayer.core.f.g
        public e b(Format format) {
            boolean z;
            e aVar;
            String str = format.f;
            switch (str.hashCode()) {
                case -1351681404:
                    if (str.equals(o.aj)) {
                        z = true;
                        break;
                    }
                    z = true;
                    break;
                case -1248334819:
                    if (str.equals(o.af)) {
                        z = true;
                        break;
                    }
                    z = true;
                    break;
                case -1026075066:
                    if (str.equals(o.ab)) {
                        z = true;
                        break;
                    }
                    z = true;
                    break;
                case -1004728940:
                    if (str.equals("text/vtt")) {
                        z = false;
                        break;
                    }
                    z = true;
                    break;
                case 691401887:
                    if (str.equals(o.aa)) {
                        z = true;
                        break;
                    }
                    z = true;
                    break;
                case 822864842:
                    if (str.equals(o.P)) {
                        z = true;
                        break;
                    }
                    z = true;
                    break;
                case 930165504:
                    if (str.equals(o.ac)) {
                        z = true;
                        break;
                    }
                    z = true;
                    break;
                case 1566015601:
                    if (str.equals(o.W)) {
                        z = true;
                        break;
                    }
                    z = true;
                    break;
                case 1566016562:
                    if (str.equals(o.X)) {
                        z = true;
                        break;
                    }
                    z = true;
                    break;
                case 1668750253:
                    if (str.equals("application/x-subrip")) {
                        z = true;
                        break;
                    }
                    z = true;
                    break;
                case 1693976202:
                    if (str.equals(o.Z)) {
                        z = true;
                        break;
                    }
                    z = true;
                    break;
                default:
                    z = true;
                    break;
            }
            switch (z) {
                case false:
                    return new com.opos.exoplayer.core.f.h.e();
                case true:
                    aVar = new com.opos.exoplayer.core.f.d.a(format.h);
                    break;
                case true:
                    return new com.opos.exoplayer.core.f.h.a();
                case true:
                    return new com.opos.exoplayer.core.f.f.a();
                case true:
                    return new com.opos.exoplayer.core.f.e.a();
                case true:
                    aVar = new com.opos.exoplayer.core.f.g.a(format.h);
                    break;
                case true:
                case true:
                    aVar = new com.opos.exoplayer.core.f.a.a(format.f, format.z);
                    break;
                case true:
                    aVar = new com.opos.exoplayer.core.f.a.b(format.z);
                    break;
                case true:
                    aVar = new com.opos.exoplayer.core.f.b.a(format.h);
                    break;
                case true:
                    return new com.opos.exoplayer.core.f.c.a();
                default:
                    throw new IllegalArgumentException("Attempted to create decoder for unsupported format");
            }
            return aVar;
        }
    };

    boolean a(Format format);

    e b(Format format);
}
