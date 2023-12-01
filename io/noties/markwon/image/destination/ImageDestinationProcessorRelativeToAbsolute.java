package io.noties.markwon.image.destination;

import java.net.MalformedURLException;
import java.net.URL;

/* loaded from: source-3503164-dex2jar.jar:io/noties/markwon/image/destination/ImageDestinationProcessorRelativeToAbsolute.class */
public class ImageDestinationProcessorRelativeToAbsolute extends ImageDestinationProcessor {
    private final URL base;

    public ImageDestinationProcessorRelativeToAbsolute(String str) {
        this.base = obtain(str);
    }

    public ImageDestinationProcessorRelativeToAbsolute(URL url) {
        this.base = url;
    }

    public static ImageDestinationProcessorRelativeToAbsolute create(String str) {
        return new ImageDestinationProcessorRelativeToAbsolute(str);
    }

    public static ImageDestinationProcessorRelativeToAbsolute create(URL url) {
        return new ImageDestinationProcessorRelativeToAbsolute(url);
    }

    private static URL obtain(String str) {
        try {
            return new URL(str);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // io.noties.markwon.image.destination.ImageDestinationProcessor
    public String process(String str) {
        if (this.base != null) {
            try {
                return new URL(this.base, str).toString();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
        return str;
    }
}
