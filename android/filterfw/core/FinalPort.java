package android.filterfw.core;

import java.lang.reflect.Field;

/* loaded from: source-9557208-dex2jar.jar:android/filterfw/core/FinalPort.class */
public class FinalPort extends FieldPort {
    public FinalPort(Filter filter, String str, Field field, boolean z) {
        super(filter, str, field, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.filterfw.core.FieldPort
    public void setFieldFrame(Frame frame, boolean z) {
        synchronized (this) {
            assertPortIsOpen();
            checkFrameType(frame, z);
            if (this.mFilter.getStatus() != 0) {
                throw new RuntimeException("Attempting to modify " + this + "!");
            }
            super.setFieldFrame(frame, z);
            super.transfer(null);
        }
    }

    @Override // android.filterfw.core.FieldPort, android.filterfw.core.FilterPort
    public String toString() {
        return "final " + super.toString();
    }
}
