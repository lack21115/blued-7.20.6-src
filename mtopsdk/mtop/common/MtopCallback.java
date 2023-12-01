package mtopsdk.mtop.common;

/* loaded from: source-3503164-dex2jar.jar:mtopsdk/mtop/common/MtopCallback.class */
public interface MtopCallback {

    /* loaded from: source-3503164-dex2jar.jar:mtopsdk/mtop/common/MtopCallback$MtopCacheListener.class */
    public interface MtopCacheListener extends MtopListener {
    }

    /* loaded from: source-3503164-dex2jar.jar:mtopsdk/mtop/common/MtopCallback$MtopFinishListener.class */
    public interface MtopFinishListener extends MtopListener {
        void onFinished(MtopFinishEvent mtopFinishEvent, Object obj);
    }

    /* loaded from: source-3503164-dex2jar.jar:mtopsdk/mtop/common/MtopCallback$MtopHeaderListener.class */
    public interface MtopHeaderListener extends MtopListener {
        void onHeader(MtopHeaderEvent mtopHeaderEvent, Object obj);
    }

    /* loaded from: source-3503164-dex2jar.jar:mtopsdk/mtop/common/MtopCallback$MtopProgressListener.class */
    public interface MtopProgressListener extends MtopListener {
    }
}
