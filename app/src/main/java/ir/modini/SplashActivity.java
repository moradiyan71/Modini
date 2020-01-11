package ir.modini;

import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Paint;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import java.util.Locale;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //TextView textView=findViewById(R.id.txxx);
/*        VideoView videoView=findViewById(R.id.video);
        MediaController mediaController= new MediaController(this);
        mediaController.setAnchorView(videoView);
        videoView.setVideoURI(Uri.parse("https://mrmdeveloper.ir/video/b.mp4"));

        videoView.start();
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                //mp.setLooping(true);
            }
        });*/
        //cast
        Button btnRegister = findViewById(R.id.btnRegister);
        Button btnLogin = findViewById(R.id.btnLogin);
        ImageView logo = findViewById(R.id.logo);
        TextView nextPage = findViewById(R.id.nextPage);
        nextPage.setPaintFlags(nextPage.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        //animation
        Animation animFadein, animslideup;
        animFadein = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in);
        animslideup = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_up);
        AnimationSet s = new AnimationSet(true);
        s.setInterpolator(new AccelerateInterpolator());
        s.addAnimation(animslideup);
        s.addAnimation(animFadein);
        btnLogin.startAnimation(s);
        btnRegister.startAnimation(s);
        logo.startAnimation(s);
        logo.startAnimation(s);
        nextPage.startAnimation(s);

        //next page clicklistener
        nextPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SplashActivity.this,MainActivity.class);
                ActivityOptions options =
                        ActivityOptions.makeCustomAnimation(SplashActivity.this, R.anim.fade_in_activity, R.anim.fade_in_activity);
                startActivity(intent,options.toBundle());
            }
        });

    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        setLocale("fa");
    }

    public void setLocale(String language) {
        Locale locale = new Locale(language);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getBaseContext().getResources().updateConfiguration(config,
                getBaseContext().getResources().getDisplayMetrics());
    }


    @Override
    protected void onResume() {
        super.onResume();
        Locale locale = new Locale("fa");
        Locale.setDefault(locale);
        final Configuration config = new Configuration();
        config.locale = locale;
        Context context = getApplicationContext();
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences preferences_fav = PreferenceManager.getDefaultSharedPreferences(context);
        getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
    }
}
