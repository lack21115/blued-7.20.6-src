package com.soft.blued.ui.user.model;

import com.blued.android.module.common.user.model.BluedAlbum;
import com.blued.community.model.AlbumFlow;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/model/AlbumDataForJsonParse.class */
public class AlbumDataForJsonParse {
    public _album album;
    public AlbumFlow feed;
    public int type;

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/model/AlbumDataForJsonParse$_album.class */
    public class _album {
        public int access_private_photos;
        public List<BluedAlbum> pics;
        public int pics_num;
        public int privacy_photos_has_locked;
        public int status;

        public _album() {
        }
    }
}
