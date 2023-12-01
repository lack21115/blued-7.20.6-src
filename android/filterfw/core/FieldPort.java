package android.filterfw.core;

import java.lang.reflect.Field;

/* loaded from: source-9557208-dex2jar.jar:android/filterfw/core/FieldPort.class */
public class FieldPort extends InputPort {
    protected Field mField;
    protected boolean mHasFrame;
    protected Object mValue;
    protected boolean mValueWaiting;

    public FieldPort(Filter filter, String str, Field field, boolean z) {
        super(filter, str);
        this.mValueWaiting = false;
        this.mField = field;
        this.mHasFrame = z;
    }

    @Override // android.filterfw.core.InputPort
    public boolean acceptsFrame() {
        boolean z;
        synchronized (this) {
            z = !this.mValueWaiting;
        }
        return z;
    }

    @Override // android.filterfw.core.FilterPort
    public void clear() {
    }

    @Override // android.filterfw.core.InputPort
    public Object getTarget() {
        try {
            return this.mField.get(this.mFilter);
        } catch (IllegalAccessException e) {
            return null;
        }
    }

    @Override // android.filterfw.core.FilterPort
    public boolean hasFrame() {
        boolean z;
        synchronized (this) {
            z = this.mHasFrame;
        }
        return z;
    }

    @Override // android.filterfw.core.FilterPort
    public Frame pullFrame() {
        synchronized (this) {
            throw new RuntimeException("Cannot pull frame on " + this + "!");
        }
    }

    @Override // android.filterfw.core.FilterPort
    public void pushFrame(Frame frame) {
        setFieldFrame(frame, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setFieldFrame(Frame frame, boolean z) {
        synchronized (this) {
            assertPortIsOpen();
            checkFrameType(frame, z);
            Object objectValue = frame.getObjectValue();
            if ((objectValue == null && this.mValue != null) || !objectValue.equals(this.mValue)) {
                this.mValue = objectValue;
                this.mValueWaiting = true;
            }
            this.mHasFrame = true;
        }
    }

    @Override // android.filterfw.core.FilterPort
    public void setFrame(Frame frame) {
        setFieldFrame(frame, true);
    }

    @Override // android.filterfw.core.FilterPort
    public String toString() {
        return "field " + super.toString();
    }

    @Override // android.filterfw.core.InputPort
    public void transfer(FilterContext filterContext) {
        synchronized (this) {
            if (this.mValueWaiting) {
                try {
                    this.mField.set(this.mFilter, this.mValue);
                    this.mValueWaiting = false;
                    if (filterContext != null) {
                        this.mFilter.notifyFieldPortValueUpdated(this.mName, filterContext);
                    }
                } catch (IllegalAccessException e) {
                    throw new RuntimeException("Access to field '" + this.mField.getName() + "' was denied!");
                }
            }
        }
    }
}
