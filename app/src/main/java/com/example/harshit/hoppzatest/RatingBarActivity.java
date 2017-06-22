package com.example.harshit.hoppzatest;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

public class RatingBarActivity extends AppCompatActivity implements RatingBarFragment.OnRatingBarFragmentInteractionListener {
    RatingBarFragment ratingBarFragment;
    RatingBar ratingbar1;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating_bar);
        addListenerOnButtonClick();
    }

    public void addListenerOnButtonClick(){
        Log.d("Harshit","in AddListenerOnButtonClicked");
        FragmentManager fragmentManager=getSupportFragmentManager();
        if(fragmentManager.findFragmentById(R.id.rating_bar_fragment_activity)==null){
            ratingBarFragment = RatingBarFragment.newInstance();
            FragmentTransaction ratingBarFragmentTransaction= fragmentManager.beginTransaction();
            ratingBarFragmentTransaction.add(R.id.rating_bar_fragment_activity,ratingBarFragment);
            ratingBarFragmentTransaction.commit();
        }
    }

    @Override
    public void OnRatingBarFragmentInteraction(View ratingBar, float rating, boolean fromUser) {
        Log.d("Harshit","In onRatingBarFragmentInteraction");
        if (ratingBar.getId()==R.id.ratingBar1){
            TextView afterRatingTextView=(TextView)findViewById(R.id.after_rating);
            ImageView emojiImage=(ImageView)findViewById(R.id.rating_emoji);
            LinearLayout rating4Layout=(LinearLayout)findViewById(R.id.rating_4_linear_layout);
            LinearLayout rating3Layout=(LinearLayout)findViewById(R.id.rating_3_linear_layout);
            if(rating<=1.1){
                afterRatingTextView.setText("Bad");
                rating4Layout.setVisibility(View.GONE);
                rating3Layout.setVisibility(View.VISIBLE);
                emojiImage.setImageResource(R.drawable.rating_1_image);

            }
            else if (rating>1.1 && rating<=2.1){
                afterRatingTextView.setText("Bad");
                emojiImage.setImageResource(R.drawable.rating_2_image);
                rating4Layout.setVisibility(View.GONE);
                rating3Layout.setVisibility(View.VISIBLE);
            }
            else if (rating>2.1 && rating<=3.7){
                afterRatingTextView.setText("Okay");
                emojiImage.setImageResource(R.drawable.rating_3_image);
                rating4Layout.setVisibility(View.GONE);
                rating3Layout.setVisibility(View.VISIBLE);
            }
            else if (rating>3.8 && rating<=4.6){
                afterRatingTextView.setText("Good");
                rating4Layout.setVisibility(View.VISIBLE);
                rating3Layout.setVisibility(View.GONE);
                emojiImage.setImageResource(R.drawable.rating_4_image);
            }
            else {
                afterRatingTextView.setText("Excellent");
                rating4Layout.setVisibility(View.VISIBLE);
                rating3Layout.setVisibility(View.GONE);
                emojiImage.setImageResource(R.drawable.rating_5_image);
            }
        }
        else if(ratingBar.getId()==R.id.rating4_button){
            Uri uri = Uri.parse("market://details?id=" + this.getPackageName());
            Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
            // To count with Play market backstack, After pressing back button,
            // to taken back to our application, we need to add following flags to intent.
            goToMarket.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY |
                    Intent.FLAG_ACTIVITY_NEW_DOCUMENT |
                    Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
            try {
                startActivity(goToMarket);
            } catch (ActivityNotFoundException e) {
                startActivity(new Intent(Intent.ACTION_VIEW,
                        Uri.parse("http://play.google.com/store/apps/details?id=" + this.getPackageName())));
            }
        }
        else if(ratingBar.getId()==R.id.rating_3_button){
            //get the place where to send the feedback
        }
    }

}