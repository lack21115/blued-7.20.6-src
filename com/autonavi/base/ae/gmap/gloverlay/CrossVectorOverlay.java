package com.autonavi.base.ae.gmap.gloverlay;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.opengl.EGL14;
import android.os.Build;
import android.util.TypedValue;
import com.amap.api.col.3sl.dw;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.CrossOverlay;
import com.autonavi.ae.gmap.gloverlay.AVectorCrossAttr;
import com.autonavi.amap.mapcore.interfaces.IAMap;
import com.autonavi.amap.mapcore.interfaces.ICrossVectorOverlay;

/* loaded from: source-8756600-dex2jar.jar:com/autonavi/base/ae/gmap/gloverlay/CrossVectorOverlay.class */
public class CrossVectorOverlay extends BaseMapOverlay<GLCrossVector, Object> implements ICrossVectorOverlay {
    AVectorCrossAttr attr;
    private CrossOverlay.GenerateCrossImageListener imageListener;
    private boolean isImageMode;
    private CrossOverlay.OnCrossVectorUpdateListener updateListener;

    public CrossVectorOverlay(int i, Context context, IAMap iAMap) {
        super(i, context, iAMap);
        this.isImageMode = false;
        this.attr = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void drawVectorFailed(int i) {
        CrossOverlay.GenerateCrossImageListener generateCrossImageListener;
        if (this.isImageMode && (generateCrossImageListener = this.imageListener) != null) {
            generateCrossImageListener.onGenerateComplete((Bitmap) null, i);
        }
        if (this.updateListener != null) {
            CrossOverlay.UpdateItem updateItem = new CrossOverlay.UpdateItem();
            updateItem.dataUpdateFlag = i;
            this.updateListener.onUpdate(0, updateItem);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initImageMode(boolean z) {
        if (this.mGLOverlay != 0) {
            ((GLCrossVector) this.mGLOverlay).initTextureCallback(this, z);
        }
    }

    @Override // com.autonavi.base.ae.gmap.gloverlay.BaseMapOverlay
    public void addItem(Object obj) {
    }

    public void addOverlayTexture(Bitmap bitmap, int i, int i2) {
        GLTextureProperty gLTextureProperty = new GLTextureProperty();
        gLTextureProperty.mId = i;
        gLTextureProperty.mAnchor = i2;
        gLTextureProperty.mBitmap = bitmap;
        gLTextureProperty.mXRatio = 0.0f;
        gLTextureProperty.mYRatio = 0.0f;
        gLTextureProperty.isGenMimps = true;
        this.mMapView.addOverlayTexture(this.mEngineID, gLTextureProperty);
    }

    public int dipToPixel(Context context, int i) {
        if (context == null) {
            return i;
        }
        try {
            return (int) TypedValue.applyDimension(1, i, context.getResources().getDisplayMetrics());
        } catch (Exception e) {
            return i;
        }
    }

    public void imageContentResult(int[] iArr, int i, int i2) {
        if (iArr == null) {
            drawVectorFailed(-1);
        } else if (this.imageListener != null) {
            Bitmap a2 = dw.a(iArr, i, i2);
            CrossOverlay.GenerateCrossImageListener generateCrossImageListener = this.imageListener;
            int i3 = -1;
            if (a2 != null) {
                i3 = 0;
            }
            generateCrossImageListener.onGenerateComplete(a2, i3);
        }
    }

    @Override // com.autonavi.base.ae.gmap.gloverlay.BaseMapOverlay
    protected void iniGLOverlay() {
        if (this.mMapView != null) {
            this.mMapView.queueEvent(new Runnable() { // from class: com.autonavi.base.ae.gmap.gloverlay.CrossVectorOverlay.1
                @Override // java.lang.Runnable
                public void run() {
                    CrossVectorOverlay crossVectorOverlay = CrossVectorOverlay.this;
                    crossVectorOverlay.mGLOverlay = new GLCrossVector(crossVectorOverlay.mEngineID, CrossVectorOverlay.this.mMapView, hashCode());
                }
            });
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.ICrossVectorOverlay
    public void remove() {
        this.imageListener = null;
        setVisible(false);
        if (this.mMapView != null) {
            this.mMapView.queueEvent(new Runnable() { // from class: com.autonavi.base.ae.gmap.gloverlay.CrossVectorOverlay.5
                @Override // java.lang.Runnable
                public void run() {
                    CrossVectorOverlay.this.releaseInstance();
                }
            });
        }
    }

    @Override // com.autonavi.base.ae.gmap.gloverlay.BaseMapOverlay
    public void resumeMarker(final Bitmap bitmap) {
        if (this.mMapView != null) {
            this.mMapView.queueEvent(new Runnable() { // from class: com.autonavi.base.ae.gmap.gloverlay.CrossVectorOverlay.2
                @Override // java.lang.Runnable
                public void run() {
                    CrossVectorOverlay.this.addOverlayTexture(bitmap, EGL14.EGL_BIND_TO_TEXTURE_RGB, 4);
                    ((GLCrossVector) CrossVectorOverlay.this.mGLOverlay).setArrowResId(false, EGL14.EGL_BIND_TO_TEXTURE_RGB);
                    ((GLCrossVector) CrossVectorOverlay.this.mGLOverlay).setCarResId(EGL14.EGL_BIND_TO_TEXTURE_RGB);
                    BitmapDescriptor fromAsset = BitmapDescriptorFactory.fromAsset("cross/crossing_nigth_bk.data");
                    CrossVectorOverlay.this.addOverlayTexture(fromAsset != null ? fromAsset.getBitmap() : null, 54321, 0);
                    ((GLCrossVector) CrossVectorOverlay.this.mGLOverlay).setBackgroundResId(54321);
                }
            });
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.ICrossVectorOverlay
    public void setAttribute(AVectorCrossAttr aVectorCrossAttr) {
        this.attr = aVectorCrossAttr;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.ICrossVectorOverlay
    public int setData(final byte[] bArr) {
        if (Build.VERSION.SDK_INT < 21) {
            drawVectorFailed(-1);
            return -1;
        }
        if (this.attr == null) {
            AVectorCrossAttr aVectorCrossAttr = new AVectorCrossAttr();
            this.attr = aVectorCrossAttr;
            aVectorCrossAttr.stAreaRect = new Rect(0, 0, this.mMapView.getMapWidth(), (this.mMapView.getMapHeight() * 4) / 11);
            this.attr.stAreaColor = Color.argb(217, 95, 95, 95);
            this.attr.fArrowBorderWidth = dipToPixel(this.mContext, 22);
            this.attr.stArrowBorderColor = Color.argb(0, 0, 50, 20);
            this.attr.fArrowLineWidth = dipToPixel(this.mContext, 18);
            this.attr.stArrowLineColor = Color.argb(255, 255, 253, 65);
            this.attr.dayMode = false;
        }
        if (bArr == null || this.attr == null || this.mMapView == null) {
            return -1;
        }
        this.mMapView.queueEvent(new Runnable() { // from class: com.autonavi.base.ae.gmap.gloverlay.CrossVectorOverlay.4
            @Override // java.lang.Runnable
            public void run() {
                CrossVectorOverlay crossVectorOverlay = CrossVectorOverlay.this;
                crossVectorOverlay.initImageMode(crossVectorOverlay.isImageMode);
                GLCrossVector gLCrossVector = (GLCrossVector) CrossVectorOverlay.this.mGLOverlay;
                AVectorCrossAttr aVectorCrossAttr2 = CrossVectorOverlay.this.attr;
                byte[] bArr2 = bArr;
                int addVectorItem = gLCrossVector.addVectorItem(aVectorCrossAttr2, bArr2, bArr2.length);
                if (addVectorItem != 0) {
                    CrossVectorOverlay.this.drawVectorFailed(addVectorItem);
                } else if (CrossVectorOverlay.this.updateListener != null) {
                    CrossOverlay.UpdateItem updateItem = new CrossOverlay.UpdateItem();
                    updateItem.dataUpdateFlag = addVectorItem;
                    CrossVectorOverlay.this.updateListener.onUpdate(0, updateItem);
                }
            }
        });
        return -1;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.ICrossVectorOverlay
    public void setGenerateCrossImageListener(CrossOverlay.GenerateCrossImageListener generateCrossImageListener) {
        this.imageListener = generateCrossImageListener;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.ICrossVectorOverlay
    public void setImageMode(boolean z) {
        this.isImageMode = z;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.ICrossVectorOverlay
    public void setOnCrossVectorUpdateListener(CrossOverlay.OnCrossVectorUpdateListener onCrossVectorUpdateListener) {
        this.updateListener = onCrossVectorUpdateListener;
    }

    @Override // com.autonavi.base.ae.gmap.gloverlay.BaseMapOverlay, com.autonavi.amap.mapcore.interfaces.ICrossVectorOverlay
    public void setVisible(final boolean z) {
        if (this.mMapView != null) {
            this.mMapView.queueEvent(new Runnable() { // from class: com.autonavi.base.ae.gmap.gloverlay.CrossVectorOverlay.3
                @Override // java.lang.Runnable
                public void run() {
                    if (CrossVectorOverlay.this.mGLOverlay != 0) {
                        ((GLCrossVector) CrossVectorOverlay.this.mGLOverlay).setVisible(z);
                    }
                }
            });
        }
    }
}
