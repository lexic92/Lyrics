package me.lexichristiansen.lyrics.lyriclist;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import me.lexichristiansen.lyrics.AddLyricActivity;
import me.lexichristiansen.lyrics.LyricDetailActivity;
import me.lexichristiansen.lyrics.R;
import me.lexichristiansen.lyrics.database.DatabaseHelper;
import me.lexichristiansen.lyrics.database.Lyric;

import java.util.List;

/**
 * A list of Lyrics. On small screens, a list of items which open a {@link LyricDetailActivity} when clicked.
 * On tablets, the list of items are on the left and item details open on the right in a double-pane view.
 */
public class LyricListActivity extends AppCompatActivity {

    /**
     * Whether or not the activity is in two-pane mode, i.e. running on a tablet
     * device.
     */
    private boolean mTwoPane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lyric_list);
        /*
        DatabaseHelper db = new DatabaseHelper(this);
        db.addLyric(new Lyric(0, "RIVER", "AKB~!\n" +
                "48!\n" +
                "\n" +
                "Advance forward! (Got it!)\n" +
                "Don't you dare to halt! (Got it!)\n" +
                "Our aim is that place where the sun rise\n" +
                "Walk on the path of hope!\n" +
                "\n" +
                "What blocked this path is River! River! River!\n" +
                "A stretched-out River!\n" +
                "The fated River! River! River!\n" +
                "An ordeal River!\n" +
                "\n" +
                "Throw away all your doubts!\n" +
                "Show your willpower!\n" +
                "Don't hesitate!\n" +
                "Immediately\n" +
                "One step forward! Believe yourself!\n" +
                "\n" +
                "Forward forward!\n" +
                "Go straight ahead!\n" +
                "Cross the river!! Ho! Ho! Ho! Ho!\n" +
                "\n" +
                "A dream is always\n" +
                "Looked so far away\n" +
                "Feels like its distance could not be reached\n" +
                "Pick up that stone\n" +
                "Under your foot\n" +
                "And with all your might\n" +
                "Throw it away!\n" +
                "\n" +
                "Just before your very eyes\n" +
                "A river is flowing\n" +
                "Broadly, such a great river\n" +
                "Darkly, deeply, even so\n" +
                "The current is fast, even so\n" +
                "Do not be scared, OK?\n" +
                "Do not wander off\n" +
                "That's right, the opposite side is there\n" +
                "So more, believe in yourself\n" +
                "\n" +
                "Inside the darkness\n" +
                "Just keep swimming!\n" +
                "Don't turn your head! Ho! Ho! Ho! Ho!\n" +
                "\n" +
                "When you extend your hand, there\n" +
                "Future exists, you see\n" +
                "Don't give up on the thing you can not reach!\n" +
                "The stone that you toss\n" +
                "Is the dream granter\n" +
                "Somehow its falling sound could not be heard\n" +
                "\n" +
                "Inside your heart too\n" +
                "A river is flowing\n" +
                "So painful, a river of trial\n" +
                "Maybe it doesn't go smoothly, even so\n" +
                "Sometimes you're almost drown, even so\n" +
                "It's OK to repeat again\n" +
                "Do not give it up\n" +
                "The bank exists just there\n" +
                "Someday your struggle will bring you to it\n" +
                "\n" +
                "Get over it!\n" +
                "RIVER!", "AKB~!\n" +
                "48!\n" +
                "\n" +
                "[Mae/Tak] mae e susume! (Got it!)\n" +
                "[Mae/Tak] tachidomaru na! (Got it!)\n" +
                "[Mae/Tak] mezasu wa hi ga noboru basho\n" +
                "[Mae/Tak] kibou no michi wo aruke!\n" +
                "\n" +
                "[Koj/Mae/Tak/Ita/Min/Osh/Wat/Mat] yukute habamu River! River! River!\n" +
                "[Koj/Mae/Tak/Ita/Min/Osh/Wat/Mat] yokotawaru River!\n" +
                "[Shi/Kit/Miy/Aki/Miy/Ono/Kas/Kas] unmei no River! River! River!\n" +
                "[Shi/Kit/Miy/Aki/Miy/Ono/Kas/Kas] tamesareru River!\n" +
                "\n" +
                "[Koj/Mae/Tak/Ita/Min/Osh/Wat/Mat] mayoi wa suterunda!\n" +
                "[Koj/Mae/Tak/Ita/Min/Osh/Wat/Mat] konjou wo misero yo!\n" +
                "tamerau na!\n" +
                "ima sugu\n" +
                "ippo fumidase yo! Believe yourself!\n" +
                "\n" +
                "mae e mae e!\n" +
                "massugu susume!\n" +
                "kawa wo watare!! Ho! Ho! Ho! Ho!\n" +
                "\n" +
                "[Mae/Tak] itsu datte yume wa\n" +
                "[Mae/Tak] tooku ni mieru\n" +
                "[Mae/Tak] todokanai kurai kyori kanjiru\n" +
                "[Koj/Osh/Wat/Mat] ashimoto no ishi wo\n" +
                "[Koj/Osh/Wat/Mat] hitotsu hirotte\n" +
                "[Koj/Osh/Wat/Mat] gamushara ni natte\n" +
                "[Koj/Osh/Wat/Mat] nagete miro!\n" +
                "\n" +
                "kimi no me no mae ni\n" +
                "kawa ga nagareru\n" +
                "[Shi/Kit/Miy/Aki/Miy/Ono/Kas/Kas] hiroku ooki na kawa da\n" +
                "[Shi/Kit/Miy/Aki/Miy/Ono/Kas/Kas] kuraku fukakute mo\n" +
                "[Shi/Kit/Miy/Aki/Miy/Ono/Kas/Kas] nagare hayakute mo\n" +
                "obienakute ii\n" +
                "hanarete ite mo\n" +
                "[Koj/Mae/Tak/Ita/Min/Osh/Wat/Mat] sou da mukougishi wa aru\n" +
                "[Koj/Mae/Tak/Ita/Min/Osh/Wat/Mat] motto jibun wo shinjiro yo\n" +
                "\n" +
                "yami no naka wo\n" +
                "hitasura oyoge!\n" +
                "furikaeru na! Ho! Ho! Ho! Ho!\n" +
                "\n" +
                "[Shi/Miy/Kas] te nobaseba soko ni\n" +
                "[Shi/Miy/Kas] mirai wa aru yo\n" +
                "[Shi/Miy/Kas] todokanai mono to akiramenaide!\n" +
                "[Ita/Kit/Ono] houri nageta ishi wa\n" +
                "[Ita/Kit/Ono] yume wo kanaete\n" +
                "[Ita/Kit/Ono] ochiru oto nanka kikoenai\n" +
                "\n" +
                "kimi no kokoro ni mo\n" +
                "kawa ga nagareru\n" +
                "[Koj/Mae/Tak/Ita/Min/Osh/Wat/Mat] tsurai shiren no kawa da\n" +
                "[Koj/Mae/Tak/Ita/Min/Osh/Wat/Mat] umaku ikanakute mo\n" +
                "[Koj/Mae/Tak/Ita/Min/Osh/Wat/Mat] toki ni oborete mo\n" +
                "kurikaeseba ii\n" +
                "akirameru na yo"));
        db.addLyric(new Lyric(1, "Oogoe Diamond", "English", "Japanese"));
        db.addLyric(new Lyric(2, "Iiwake Maybe", "English", "Japanese"));
        */

        //Set toolbar title
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(getTitle());

        //Floating button opens add-lyric page
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AddLyricActivity.class);
                startActivity(intent);
            }
        });

        //Set recycler view to show list of lyrics
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.lyric_list);
        recyclerView.setAdapter(new LyricListAdapter(this, mTwoPane, getSupportFragmentManager()));

        //Determine single or double-pane mode
        if (findViewById(R.id.lyric_detail_container) != null) {
            mTwoPane = true;
        }
    }


}
