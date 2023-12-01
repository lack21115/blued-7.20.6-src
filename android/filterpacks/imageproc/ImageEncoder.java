package android.filterpacks.imageproc;

import android.app.Instrumentation;
import android.filterfw.core.Filter;
import android.filterfw.core.FilterContext;
import android.filterfw.core.GenerateFieldPort;
import android.filterfw.format.ImageFormat;
import android.graphics.Bitmap;
import android.media.MediaFormat;
import java.io.OutputStream;

/* loaded from: source-9557208-dex2jar.jar:android/filterpacks/imageproc/ImageEncoder.class */
public class ImageEncoder extends Filter {
    @GenerateFieldPort(name = Instrumentation.REPORT_KEY_STREAMRESULT)
    private OutputStream mOutputStream;
    @GenerateFieldPort(hasDefault = true, name = MediaFormat.KEY_QUALITY)
    private int mQuality;

    public ImageEncoder(String str) {
        super(str);
        this.mQuality = 80;
    }

    @Override // android.filterfw.core.Filter
    public void process(FilterContext filterContext) {
        pullInput("image").getBitmap().compress(Bitmap.CompressFormat.JPEG, this.mQuality, this.mOutputStream);
    }

    @Override // android.filterfw.core.Filter
    public void setupPorts() {
        addMaskedInputPort("image", ImageFormat.create(3, 0));
    }
}
