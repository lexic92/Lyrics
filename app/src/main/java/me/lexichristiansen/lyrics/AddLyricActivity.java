package me.lexichristiansen.lyrics;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import me.lexichristiansen.lyrics.database.DatabaseHelper;
import me.lexichristiansen.lyrics.database.Lyric;

public class AddLyricActivity extends AppCompatActivity {

    private EditText english;
    private EditText japanese;
    private EditText title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_lyric);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        english = (EditText) findViewById(R.id.lyrics_english);
        japanese = (EditText) findViewById(R.id.lyrics_japanese);
        title = (EditText) findViewById(R.id.title);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseHelper helper = new DatabaseHelper(getBaseContext());
                helper.addLyric(new Lyric(title.getText().toString(), english.getText().toString(), japanese.getText().toString()));
                Snackbar.make(view, "Lyrics saved", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    }

}
