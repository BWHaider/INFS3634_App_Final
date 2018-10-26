package com.example.haider.infs2608learningapp;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class ChapterEightYoutubeActivity extends YouTubeBaseActivity
implements YouTubePlayer.OnInitializedListener {
    private static final String TAG = "ChapterEightYoutubeActi";
        static final String GOOGLE_API_KEY = "AIzaSyBRuf_ZX_Q_wTodzDVaYDNfWdw-xsUCbiU";
        static final String YOUTUBE_VIDEO_ID = "R-sGvh6tI04";
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            ConstraintLayout layout = (ConstraintLayout) getLayoutInflater().inflate(R.layout.activity_chapter_eight_youtube, null);
            setContentView(layout);

            YouTubePlayerView playerView = new YouTubePlayerView(this);
            layout.addView(playerView);
            playerView.initialize(GOOGLE_API_KEY, this);

        }

        @Override
        public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean wasRestored) {
            Log.d(TAG, "onInitialisationSuccess: provider is " + provider.getClass().toString());
            Toast.makeText(this, "Initialised Youtube Player Successfully", Toast.LENGTH_LONG).show();
            if(!wasRestored) {
                youTubePlayer.cueVideo(YOUTUBE_VIDEO_ID);
            }

        }

        @Override
        public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult
        youTubeInitializationResult) {
            final int REQUEST_CODE = 1;
            if(youTubeInitializationResult.isUserRecoverableError()){
                youTubeInitializationResult.getErrorDialog(this, REQUEST_CODE).show();
            }
            else {
                String errorMessage = String.format("There was an error initialising the YouTubePlayer (%1$s)", youTubeInitializationResult.toString());
                Toast.makeText(this, errorMessage, Toast.LENGTH_LONG).show();
            }

        }
    }