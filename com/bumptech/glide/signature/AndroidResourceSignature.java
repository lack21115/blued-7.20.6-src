package com.bumptech.glide.signature;

import android.content.Context;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.util.Util;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/signature/AndroidResourceSignature.class */
public final class AndroidResourceSignature implements Key {
    private final int b;

    /* renamed from: c  reason: collision with root package name */
    private final Key f21090c;

    private AndroidResourceSignature(int i, Key key) {
        this.b = i;
        this.f21090c = key;
    }

    public static Key a(Context context) {
        return new AndroidResourceSignature(context.getResources().getConfiguration().uiMode & 48, ApplicationVersionSignature.a(context));
    }

    @Override // com.bumptech.glide.load.Key
    public void a(MessageDigest messageDigest) {
        this.f21090c.a(messageDigest);
        messageDigest.update(ByteBuffer.allocate(4).putInt(this.b).array());
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        boolean z = false;
        if (obj instanceof AndroidResourceSignature) {
            AndroidResourceSignature androidResourceSignature = (AndroidResourceSignature) obj;
            z = false;
            if (this.b == androidResourceSignature.b) {
                z = false;
                if (this.f21090c.equals(androidResourceSignature.f21090c)) {
                    z = true;
                }
            }
        }
        return z;
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return Util.a(this.f21090c, this.b);
    }
}
