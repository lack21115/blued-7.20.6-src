package com.weimob.library.groups.imageloader.Imagepipeline;

import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.facebook.imagepipeline.core.ImagePipelineFactory;
import com.facebook.imagepipeline.platform.PlatformDecoder;
import com.weimob.library.groups.imageloader.decoder.platform.ImageLoaderPlatformDecoderFactory;

/* loaded from: source-8829756-dex2jar.jar:com/weimob/library/groups/imageloader/Imagepipeline/ImageLoaderImagePipelineFactory.class */
public class ImageLoaderImagePipelineFactory extends ImagePipelineFactory {
    private ImagePipelineConfig imagePipelineConfig;
    private PlatformDecoder mPlatformDecoder;

    public ImageLoaderImagePipelineFactory(ImagePipelineConfig imagePipelineConfig) {
        super(imagePipelineConfig);
        this.imagePipelineConfig = imagePipelineConfig;
    }

    public PlatformDecoder getPlatformDecoder() {
        if (this.mPlatformDecoder == null) {
            this.mPlatformDecoder = ImageLoaderPlatformDecoderFactory.buildPlatformDecoder(this.imagePipelineConfig.getPoolFactory(), this.imagePipelineConfig.getExperiments().isGingerbreadDecoderEnabled());
        }
        return this.mPlatformDecoder;
    }
}
