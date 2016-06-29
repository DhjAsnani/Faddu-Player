package son_gohan.fadduplayer;

import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;

import java.net.URI;
import java.util.ArrayList;

public class ActivityDisplaySngs extends AppCompatActivity implements View.OnClickListener {

    Button importButton;
    private String[] STAR = {"*"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void init()
    {
        importButton = (Button) findViewById(R.id.import_btn);
        importButton.setOnClickListener(ActivityDisplaySngs.this);
    }

    @Override
    public void onClick(View v) {

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
                    }
                }
            }
        }
        return arrayList;
    }
    private static boolean isSdCardPresent()
    {
        return android.os.Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
    }
}
