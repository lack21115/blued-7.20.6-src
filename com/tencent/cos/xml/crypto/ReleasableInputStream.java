package com.tencent.cos.xml.crypto;

import java.io.FileInputStream;
import java.io.InputStream;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/crypto/ReleasableInputStream.class */
public class ReleasableInputStream extends SdkFilterInputStream implements Releasable {
    private boolean closeDisabled;

    /* JADX INFO: Access modifiers changed from: protected */
    public ReleasableInputStream(InputStream inputStream) {
        super(inputStream);
    }

    private void doRelease() {
        try {
            this.in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (this.in instanceof Releasable) {
            ((Releasable) this.in).release();
        }
        abortIfNeeded();
    }

    public static ReleasableInputStream wrap(InputStream inputStream) {
        return inputStream instanceof ReleasableInputStream ? (ReleasableInputStream) inputStream : inputStream instanceof FileInputStream ? ResettableInputStream.newResettableInputStream((FileInputStream) inputStream) : new ReleasableInputStream(inputStream);
    }

    @Override // com.tencent.cos.xml.crypto.SdkFilterInputStream, java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.closeDisabled) {
            return;
        }
        doRelease();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T extends ReleasableInputStream> T disableClose() {
        this.closeDisabled = true;
        return this;
    }

    public final boolean isCloseDisabled() {
        return this.closeDisabled;
    }

    @Override // com.tencent.cos.xml.crypto.SdkFilterInputStream, com.tencent.cos.xml.crypto.Releasable
    public final void release() {
        doRelease();
    }
}
