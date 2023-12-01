package io.noties.markwon.image.destination;

/* loaded from: source-3503164-dex2jar.jar:io/noties/markwon/image/destination/ImageDestinationProcessor.class */
public abstract class ImageDestinationProcessor {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-3503164-dex2jar.jar:io/noties/markwon/image/destination/ImageDestinationProcessor$NoOp.class */
    public static class NoOp extends ImageDestinationProcessor {
        private NoOp() {
        }

        @Override // io.noties.markwon.image.destination.ImageDestinationProcessor
        public String process(String str) {
            return str;
        }
    }

    public static ImageDestinationProcessor noOp() {
        return new NoOp();
    }

    public abstract String process(String str);
}
