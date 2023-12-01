package com.tencent.mapsdk.internal;

import android.graphics.Rect;
import com.tencent.mapsdk.internal.p0;
import com.tencent.tencentmap.mapsdk.maps.interfaces.Boundable;
import com.tencent.tencentmap.mapsdk.maps.interfaces.Selectable;
import java.util.List;
import javax.microedition.khronos.opengles.GL10;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/v0.class */
public abstract class v0<D extends p0> implements u4 {
    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Boundable
    /* renamed from: a */
    public Rect getBound(t4 t4Var) {
        return x().getBound(t4Var);
    }

    @Override // com.tencent.mapsdk.internal.o4
    public void a(GL10 gl10) {
        x().a(gl10);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Boundable
    /* renamed from: b */
    public Rect getScreenBound(t4 t4Var) {
        return x().getScreenBound(t4Var);
    }

    public List<Boundable<t4>> getGroupBounds() {
        return x().getGroupBounds();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.IOverlay
    public String getId() {
        return x().getId();
    }

    public int getLevel() {
        return x().getLevel();
    }

    public int getZIndex() {
        return x().getZIndex();
    }

    public boolean handleOnTap() {
        return x().handleOnTap();
    }

    public boolean isRemoved() {
        return x().isRemoved();
    }

    public boolean isSelected() {
        return x().isSelected();
    }

    public boolean isVisible() {
        return x().isVisible();
    }

    public boolean onTap(float f, float f2) {
        return x().onTap(f, f2);
    }

    public void releaseData() {
        x().releaseData();
    }

    public void remove() {
        x().remove();
    }

    public void setLevel(int i) {
        x().setLevel(i);
    }

    public void setSelected(boolean z) {
        x().setSelected(z);
    }

    public <T> void setSelectedListener(Selectable.OnSelectedListener<T> onSelectedListener) {
        x().setSelectedListener(onSelectedListener);
    }

    public void setVisible(boolean z) {
        x().setVisible(z);
    }

    public void setZIndex(float f) {
        setZIndex((int) f);
    }

    public void setZIndex(int i) {
        x().setZIndex(i);
    }

    public abstract D x();
}
