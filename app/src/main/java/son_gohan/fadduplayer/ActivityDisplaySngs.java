package son_gohan.fadduplayer;

import android.content.ContentUris;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.net.URI;
import java.util.ArrayList;

public class ActivityDisplaySngs extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {

    Button importButton;
    private String[] STAR = {"*"};
    ListView songListView;
    ArrayList<Song> songList;
    ArrayAdapter<Song> arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void init()
    {
        importButton = (Button) findViewById(R.id.import_btn);
        importButton.setOnClickListener(ActivityDisplaySngs.this);
        songListView = (ListView) findViewById(R.id.list_importer);
    }

    @Override
    public void onClick(View v) {
        songList = listAllSongs();

    }

    private ArrayList<Song> listAllSongs(){
        Cursor cursor;
        ArrayList<Song> arrayList = new ArrayList<Song>();
        Uri allSongUri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        String selection = MediaStore.Audio.Media.IS_MUSIC+"!= 0";
        if(isSdCardPresent())
        {
            cursor = managedQuery(allSongUri,STAR,selection,null,null);
            if(cursor!=null)
            {
                if(cursor.moveToFirst())
                {
                    do {
                        Song song = new Song();
                        String data = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.DISPLAY_NAME));
                        String[] res = data.split("\\.");
                        song.setmSongName(res[0]);
                        song.setmSongFullPath(cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.DATA)));
                        song.setmSongId(cursor.getInt(cursor.getColumnIndex(MediaStore.Audio.Media._ID)));
                        song.setmSongAlbumName(cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.ALBUM)));
                        song.setmSongUri(ContentUris.withAppendedId(
                                MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
                                cursor.getInt(cursor.getColumnIndex(MediaStore.Audio.Media._ID))
                        ));
                        String duration =(cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.DURATION)));
                        song.setmSongDuration(duration);
                        arrayList.add(song);
                    }while (cursor.moveToNext());
                    return arrayList;
                }
                cursor.close();
            }
        }
        return null;
    }
    private static boolean isSdCardPresent()
    {
        return android.os.Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
