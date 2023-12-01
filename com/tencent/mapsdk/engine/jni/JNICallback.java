package com.tencent.mapsdk.engine.jni;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Typeface;
import android.os.AsyncTask;
import com.tencent.map.lib.JNIInterfaceCallback;
import com.tencent.map.lib.models.MapTileID;
import com.tencent.mapsdk.engine.jni.models.IconImageInfo;
import com.tencent.mapsdk.engine.jni.models.TextBitmapInfo;
import com.tencent.mapsdk.internal.be;
import com.tencent.mapsdk.internal.ee;
import com.tencent.mapsdk.internal.f7;
import com.tencent.mapsdk.internal.ge;
import com.tencent.mapsdk.internal.hb;
import com.tencent.mapsdk.internal.he;
import com.tencent.mapsdk.internal.le;
import com.tencent.mapsdk.internal.ma;
import com.tencent.mapsdk.internal.me;
import com.tencent.mapsdk.internal.na;
import com.tencent.mapsdk.internal.nc;
import com.tencent.mapsdk.internal.ne;
import com.tencent.mapsdk.internal.oe;
import com.tencent.mapsdk.internal.pe;
import com.tencent.mapsdk.internal.qe;
import com.tencent.mapsdk.internal.ra;
import com.tencent.mapsdk.internal.t1;
import com.tencent.mapsdk.internal.w;
import java.util.Hashtable;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/engine/jni/JNICallback.class */
public class JNICallback implements JNIInterfaceCallback {
    private static final int CB_TYPE_CAL_TEXT_SIZE = 2;
    private static final int CB_TYPE_CANCEL_DOWNLOAD = 10;
    private static final int CB_TYPE_DOWNLOAD = 3;
    private static final int CB_TYPE_DRAW_TEXT = 1;
    private static final int CB_TYPE_INDOOR_BUILDING_CHANGED = 8;
    private static final int CB_TYPE_LOAD_RES = 4;
    private static final int CB_TYPE_NOTIFY_SET_CENTER_AND_SCALE_ANIM_FINISHED = 9;
    private static final int CB_TYPE_REPORT_ENGINE_CRASH_INFO = 7;
    private static final int CB_TYPE_UPDATE_MAP_PARAM = 6;
    private static final int CB_TYPE_WRITE_FILE = 5;
    private static final int IMG_TYPE_SAT = 1;
    private ge mCancelDownloadCallback;
    private me mCbkGetGLContext;
    private he mDownloadCallback;
    private t1 mEngineCrashInfoRecorder;
    private le mIndoorBuildingChangeCallback;
    private oe mMapAnimCallback;
    private ne mMapCameraChangeCallback;
    private ee mMapLayerClickResultCallback;
    private pe mMapLoadFinishedCallback;
    private qe mMapParamChangeCallback;
    private be mRender;
    private w mResources;
    private Hashtable<Long, Paint> mTextPaints = new Hashtable<>();
    private Hashtable<Long, PointF> mTextSizeBuffers = new Hashtable<>();
    private Bitmap textCanvas;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/engine/jni/JNICallback$a.class */
    public static final class a extends AsyncTask<Void, Void, Void> {

        /* renamed from: a  reason: collision with root package name */
        private String f23588a;
        private byte[] b;

        public a(String str, byte[] bArr) {
            this.f23588a = str;
            this.b = bArr;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:41:0x00bf  */
        /* JADX WARN: Removed duplicated region for block: B:53:0x00df A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:63:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Type inference failed for: r0v12, types: [java.io.FileOutputStream] */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public java.lang.Void doInBackground(java.lang.Void... r6) {
            /*
                Method dump skipped, instructions count: 240
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mapsdk.engine.jni.JNICallback.a.doInBackground(java.lang.Void[]):java.lang.Void");
        }
    }

    public JNICallback(be beVar, w wVar, he heVar, ge geVar, pe peVar, le leVar, oe oeVar, t1 t1Var, qe qeVar, ne neVar, ee eeVar) {
        this.mRender = beVar;
        this.mResources = wVar;
        this.mDownloadCallback = heVar;
        this.mCancelDownloadCallback = geVar;
        this.mMapLoadFinishedCallback = peVar;
        this.mMapParamChangeCallback = qeVar;
        this.mIndoorBuildingChangeCallback = leVar;
        this.mMapCameraChangeCallback = neVar;
        this.mMapAnimCallback = oeVar;
        this.mEngineCrashInfoRecorder = t1Var;
        this.mMapLayerClickResultCallback = eeVar;
    }

    private void cacheTextPaint(Paint paint) {
        Hashtable<Long, Paint> hashtable = this.mTextPaints;
        if (hashtable != null) {
            hashtable.put(Long.valueOf(Thread.currentThread().getId()), paint);
        }
    }

    private void cacheTextSize(PointF pointF) {
        Hashtable<Long, PointF> hashtable = this.mTextSizeBuffers;
        if (hashtable != null) {
            hashtable.put(Long.valueOf(Thread.currentThread().getId()), pointF);
        }
    }

    private PointF calTextSize(String str, int i) {
        float measureText = initTextPaint(i).measureText(str);
        PointF textSize = getTextSize();
        PointF pointF = textSize;
        if (textSize == null) {
            pointF = new PointF();
            cacheTextSize(pointF);
        }
        pointF.x = measureText + 1.0f;
        pointF.y = i + 2;
        return pointF;
    }

    private void cancelDownload(String str, hb hbVar) {
        if (this.mCancelDownloadCallback != null) {
            na.c("Engine callback cancel download:" + str);
            this.mCancelDownloadCallback.a(str, hbVar);
        }
    }

    private void download(String str, hb hbVar) {
        if (this.mDownloadCallback != null) {
            na.c("Engine callback download:" + str + ":" + hbVar);
            this.mDownloadCallback.b(str, hbVar);
        }
    }

    private Bitmap drawText(int i, String str, byte[] bArr) {
        TextBitmapInfo textBitmapInfo = new TextBitmapInfo();
        textBitmapInfo.fill(bArr);
        if (textBitmapInfo.width == 0 || textBitmapInfo.height == 0) {
            return null;
        }
        if (this.textCanvas == null) {
            this.textCanvas = Bitmap.createBitmap(400, 400, Bitmap.Config.ALPHA_8);
        }
        if (this.textCanvas == null) {
            return null;
        }
        Paint initTextPaint = initTextPaint(i);
        this.textCanvas.eraseColor(0);
        Canvas canvas = new Canvas(this.textCanvas);
        initTextPaint.setFakeBoldText(textBitmapInfo.bold);
        canvas.drawText(str, 200.0f, 200.0f - ((initTextPaint.descent() + initTextPaint.ascent()) / 2.0f), initTextPaint);
        return this.textCanvas;
    }

    private Paint getTextPaint() {
        Hashtable<Long, Paint> hashtable = this.mTextPaints;
        if (hashtable == null) {
            return null;
        }
        return hashtable.get(Long.valueOf(Thread.currentThread().getId()));
    }

    private PointF getTextSize() {
        Hashtable<Long, PointF> hashtable = this.mTextSizeBuffers;
        if (hashtable == null) {
            return null;
        }
        return hashtable.get(Long.valueOf(Thread.currentThread().getId()));
    }

    private Paint initTextPaint(int i) {
        Paint textPaint = getTextPaint();
        nc ncVar = textPaint;
        if (textPaint == null) {
            ncVar = new nc(this.mResources.a());
            ncVar.setTypeface(Typeface.DEFAULT);
            ncVar.setAntiAlias(true);
            ncVar.setStyle(Paint.Style.FILL);
            ncVar.setTextAlign(Paint.Align.CENTER);
            ncVar.setLinearText(true);
            cacheTextPaint(ncVar);
        }
        ncVar.setTextAlign(Paint.Align.CENTER);
        ncVar.setTextSize(i);
        return ncVar;
    }

    private IconImageInfo loadImage(int i, byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        try {
            String str = new String(bArr);
            return i == 1 ? this.mResources.c(str) : this.mResources.b(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private void writeFile(String str, byte[] bArr) {
        if (bArr == null) {
            return;
        }
        new a(str, bArr).execute(new Void[0]);
    }

    @Override // com.tencent.map.lib.JNIInterfaceCallback
    public Object callback(int i, int i2, String str, byte[] bArr, Object obj) {
        JNIEvent jNIEvent = new JNIEvent();
        jNIEvent.id = i2;
        jNIEvent.name = str;
        jNIEvent.data = bArr;
        jNIEvent.extra = obj;
        return callback(i, jNIEvent);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public Object callback(int i, JNIEvent jNIEvent) {
        IconImageInfo iconImageInfo;
        boolean z = true;
        switch (i) {
            case 1:
                return drawText(jNIEvent.id, jNIEvent.name, jNIEvent.data);
            case 2:
                return calTextSize(jNIEvent.name, jNIEvent.id);
            case 3:
                if (!f7.b(jNIEvent.name)) {
                    hb hbVar = new hb();
                    hbVar.f23831a = jNIEvent.id;
                    Object obj = jNIEvent.extra;
                    if (obj instanceof MapTileID) {
                        MapTileID mapTileID = (MapTileID) obj;
                        hbVar.b = mapTileID.getDataSource().getValue();
                        hbVar.f23832c = mapTileID.getPriority().getValue();
                    }
                    hbVar.d = jNIEvent.extra;
                    download(jNIEvent.name, hbVar);
                }
                iconImageInfo = null;
                break;
            case 4:
                IconImageInfo loadImage = loadImage(jNIEvent.id, jNIEvent.data);
                iconImageInfo = loadImage;
                if (jNIEvent.data != null) {
                    new String(jNIEvent.data);
                    return loadImage;
                }
                break;
            case 5:
                na.a(ma.f, "CB_TYPE_WRITE_FILE:" + jNIEvent.name);
                writeFile(jNIEvent.name, jNIEvent.data);
                iconImageInfo = null;
                break;
            case 6:
                qe qeVar = this.mMapParamChangeCallback;
                if (qeVar != null) {
                    qeVar.a(jNIEvent.id);
                }
                iconImageInfo = null;
                break;
            case 7:
                t1 t1Var = this.mEngineCrashInfoRecorder;
                if (t1Var != null) {
                    t1Var.a(jNIEvent.name);
                }
                iconImageInfo = null;
                break;
            case 8:
                le leVar = this.mIndoorBuildingChangeCallback;
                if (leVar != null) {
                    leVar.d();
                }
                iconImageInfo = null;
                break;
            case 9:
                oe oeVar = this.mMapAnimCallback;
                if (oeVar != null) {
                    if (jNIEvent.id <= 0) {
                        z = false;
                    }
                    oeVar.a(z);
                }
                iconImageInfo = null;
                break;
            case 10:
                ra.a("CB_TYPE_CANCEL_DOWNLOAD", jNIEvent);
                if (!f7.b(jNIEvent.name)) {
                    hb hbVar2 = new hb();
                    hbVar2.f23831a = jNIEvent.id;
                    Object obj2 = jNIEvent.extra;
                    if (obj2 instanceof MapTileID) {
                        MapTileID mapTileID2 = (MapTileID) obj2;
                        hbVar2.b = mapTileID2.getDataSource().getValue();
                        hbVar2.f23832c = mapTileID2.getPriority().getValue();
                    }
                    hbVar2.d = jNIEvent.extra;
                    cancelDownload(jNIEvent.name, hbVar2);
                }
                iconImageInfo = null;
                break;
            default:
                iconImageInfo = null;
                break;
        }
        return iconImageInfo;
    }

    @Override // com.tencent.map.lib.JNIInterfaceCallback
    public int callbackGetGLContext() {
        me meVar = this.mCbkGetGLContext;
        if (meVar != null) {
            return meVar.getEGLContextHash();
        }
        return 0;
    }

    public void destory() {
        Hashtable<Long, Paint> hashtable = this.mTextPaints;
        if (hashtable != null) {
            hashtable.clear();
            this.mTextPaints = null;
        }
        Hashtable<Long, PointF> hashtable2 = this.mTextSizeBuffers;
        if (hashtable2 != null) {
            hashtable2.clear();
            this.mTextSizeBuffers = null;
        }
        this.mResources = null;
        this.mDownloadCallback = null;
        this.mCancelDownloadCallback = null;
        this.mMapParamChangeCallback = null;
        this.mIndoorBuildingChangeCallback = null;
        this.mMapCameraChangeCallback = null;
        this.mRender = null;
    }

    @Override // com.tencent.map.lib.JNIInterfaceCallback
    public boolean onJniCallbackRenderMapFrame(int i) {
        be beVar = this.mRender;
        if (beVar != null) {
            return beVar.a(i);
        }
        return false;
    }

    @Override // com.tencent.map.lib.JNIInterfaceCallback
    public void onMapCameraChangeStopped() {
        ne neVar = this.mMapCameraChangeCallback;
        if (neVar != null) {
            neVar.onMapCameraChangeStopped();
        }
    }

    @Override // com.tencent.map.lib.JNIInterfaceCallback
    public void onMapCameraChanged() {
        ne neVar = this.mMapCameraChangeCallback;
        if (neVar != null) {
            neVar.onMapCameraChanged();
        }
    }

    @Override // com.tencent.map.lib.JNIInterfaceCallback
    public void onMapLoaded() {
        pe peVar = this.mMapLoadFinishedCallback;
        if (peVar != null) {
            peVar.onMapLoaded();
        }
    }

    @Override // com.tencent.map.lib.JNIInterfaceCallback
    public void onVisualLayerClickResult(float f, float f2, long j, String str, String str2) {
        ee eeVar = this.mMapLayerClickResultCallback;
        if (eeVar != null) {
            eeVar.a(f, f2, j, str, str2);
        }
    }

    public void setMapCallbackGetGLContext(me meVar) {
        this.mCbkGetGLContext = meVar;
    }
}
