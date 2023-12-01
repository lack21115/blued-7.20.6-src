package com.opos.exoplayer.core.metadata;

import com.anythink.expressad.exoplayer.k.o;
import com.opos.exoplayer.core.Format;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/metadata/c.class */
public interface c {

    /* renamed from: a  reason: collision with root package name */
    public static final c f25519a = new c() { // from class: com.opos.exoplayer.core.metadata.c.1
        @Override // com.opos.exoplayer.core.metadata.c
        public boolean a(Format format) {
            String str = format.f;
            return o.V.equals(str) || o.ai.equals(str) || o.ag.equals(str);
        }

        @Override // com.opos.exoplayer.core.metadata.c
        public a b(Format format) {
            boolean z;
            String str = format.f;
            int hashCode = str.hashCode();
            if (hashCode == -1248341703) {
                if (str.equals(o.V)) {
                    z = false;
                }
                z = true;
            } else if (hashCode != 1154383568) {
                if (hashCode == 1652648887 && str.equals(o.ag)) {
                    z = true;
                }
                z = true;
            } else {
                if (str.equals(o.ai)) {
                    z = true;
                }
                z = true;
            }
            if (z) {
                if (!z) {
                    if (z) {
                        return new com.opos.exoplayer.core.metadata.scte35.a();
                    }
                    throw new IllegalArgumentException("Attempted to create decoder for unsupported format");
                }
                return new com.opos.exoplayer.core.metadata.emsg.a();
            }
            return new com.opos.exoplayer.core.metadata.id3.a();
        }
    };

    boolean a(Format format);

    a b(Format format);
}
