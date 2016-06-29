package son_gohan.fadduplayer;

import android.net.Uri;

/**
 * Created by Dheeraj Asnani on 29-Jun-16.
 */
public class Song {
    private String mSongName, mSongAlbumName,mSongFullPath,mSongDuration;
    private Uri mSongUri;
    private int mSongId;

    public Song(){}
    public Song(String name,int id,String albumName,String fullPath,String duration,Uri songuri)
    {
        this.setmSongName(name);
        this.setmSongAlbumName(albumName);
        this.setmSongDuration(duration);
        this.setmSongFullPath(fullPath);
        this.setmSongId(id);
        this.setmSongUri(songuri);

    }

    public String getmSongName() {
        return mSongName;
    }

    public void setmSongName(String mSongName) {
        this.mSongName = mSongName;
    }

    public String getmSongAlbumName() {
        return mSongAlbumName;
    }

    public void setmSongAlbumName(String mSongAlbumName) {
        this.mSongAlbumName = mSongAlbumName;
    }

    public String getmSongFullPath() {
        return mSongFullPath;
    }

    public void setmSongFullPath(String mSongFullPath) {
        this.mSongFullPath = mSongFullPath;
    }

    public String getmSongDuration() {
        return mSongDuration;
    }

    public void setmSongDuration(String mSongDuration) {
        this.mSongDuration = mSongDuration;
    }

    public Uri getmSongUri() {
        return mSongUri;
    }

    public void setmSongUri(Uri mSongUri) {
        this.mSongUri = mSongUri;
    }

    public int getmSongId() {
        return mSongId;
    }

    public void setmSongId(int mSongId) {
        this.mSongId = mSongId;
    }
}
