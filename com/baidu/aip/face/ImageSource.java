package com.baidu.aip.face;

import com.baidu.aip.ImageFrame;
import java.util.ArrayList;

/* loaded from: source-8756600-dex2jar.jar:com/baidu/aip/face/ImageSource.class */
public class ImageSource {
    private ArrayList<OnFrameAvailableListener> listeners = new ArrayList<>();

    public void addOnFrameAvailableListener(OnFrameAvailableListener onFrameAvailableListener) {
        this.listeners.add(onFrameAvailableListener);
    }

    public ImageFrame borrowImageFrame() {
        return new ImageFrame();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ArrayList<OnFrameAvailableListener> getListeners() {
        return this.listeners;
    }

    public void removeOnFrameAvailableListener(OnFrameAvailableListener onFrameAvailableListener) {
        if (onFrameAvailableListener != null) {
            this.listeners.remove(onFrameAvailableListener);
        }
    }

    public void setPreviewView(PreviewView previewView) {
    }

    public void start() {
    }

    public void stop() {
    }
}
