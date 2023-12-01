package com.bumptech.glide;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/MemoryCategory.class */
public enum MemoryCategory {
    LOW(0.5f),
    NORMAL(1.0f),
    HIGH(1.5f);
    
    private final float d;

    MemoryCategory(float f) {
        this.d = f;
    }
}
