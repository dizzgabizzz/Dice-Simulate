package com.inf2fm.dicesimulate2f;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.chip.ChipGroup;
import com.google.android.material.navigation.NavigationBarView;

import java.util.Random;

public class ChoiceActivity extends AppCompatActivity {

    private EmptyFragment mEmptyFragment = new EmptyFragment();
    private LoseFragment mLoseFragment = new LoseFragment();
    private PlayingTimeFragment mPlayingTimeFragment = new PlayingTimeFragment();
    private WinFragment mWinFragment = new WinFragment();

    public int mNumberMatches=0;
    public int mNumberWins=0;

    public long mTimeStart = 0;

    Random rnd = new Random();

    public String mMessageDisplay;

    public BottomNavigationView mBottomNavigationView;
    public ChipGroup mChipGroup;
    public Button mButton;
    public ImageView mImageView;
    public TextView mTextView;

    private int mChipSelected=0;

    private void showMessage(int value) {
        mMessageDisplay="Errou...";
        if( value==mChipSelected ) {
            mMessageDisplay="Acertou";
            mNumberWins++;

        }
        Toast.makeText(this, mMessageDisplay , Toast.LENGTH_SHORT).show();

    }

    private void showImage(int value){
        switch (value){
            case 1: mImageView.setImageResource(R.drawable.ic_dice_yellow_1); break;
            case 2: mImageView.setImageResource(R.drawable.ic_dice_yellow_2); break;
            case 3: mImageView.setImageResource(R.drawable.ic_dice_yellow_3); break;
            case 4: mImageView.setImageResource(R.drawable.ic_dice_yellow_4); break;
            case 5: mImageView.setImageResource(R.drawable.ic_dice_yellow_5); break;
            case 6: mImageView.setImageResource(R.drawable.ic_dice_yellow_6); break;
            

        }

    }


    private void launchDice(){
        mNumberMatches++;
        if(mTimeStart==0){
            mTimeStart= SystemClock.elapsedRealtime();
        }
        int number = rnd.nextInt(6)+1;
        mTextView.setText(""+number);
        showImage(number);
        showMessage(number);

    }


    public class FilterChipSelectedInTheGroup implements ChipGroup.OnCheckedChangeListener{
        @Override
        public void onCheckedChanged(@NonNull ChipGroup group, int checkedId) {
            switch (group.getCheckedChipId()) {
                case R.id.chip1: mChipSelected=1; break;
                case R.id.chip2: mChipSelected=2; break;
                case R.id.chip3: mChipSelected=3; break;
                case R.id.chip4: mChipSelected=4; break;
                case R.id.chip5: mChipSelected=5; break;
                case R.id.chip6: mChipSelected=6; break;


            }
        }
    }

    public class ClickMyButtonStart implements View

            .OnClickListener{
        @Override
        public void onClick(View v) {
            launchDice();
        }
    }


    private void setDisableWidGets(boolean value) {
        if(value) {
            mChipGroup.setVisibility(View.GONE);
            mButton.setVisibility(View.GONE);
            mImageView.setVisibility(View.GONE);
            mTextView.setVisibility(View.GONE);


        } else { mChipGroup.setVisibility(View.VISIBLE);
            mButton.setVisibility(View.VISIBLE);
            mImageView.setVisibility(View.VISIBLE);
            mTextView.setVisibility(View.VISIBLE); }


    }



    public class ClickStarPlay implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            launchDice();
        }
    }

    private void setCurrentFragment(Fragment currentFragment, long value){
        Bundle mBundle = new Bundle();
        mBundle.putLong("message", value);
        currentFragment.setArguments(mBundle);
        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout_message, currentFragment).commit();

    }

    public class ClickItemBottomNavigationView implements NavigationBarView.OnItemSelectedListener{
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            switch (item.getItemId()){

                case R.id.item_game: setDisableWidGets(false); setCurrentFragment(mEmptyFragment, mNumberMatches); return true;
                case R.id.item_lose: setDisableWidGets(false); setCurrentFragment(mLoseFragment, (mNumberMatches-mNumberWins)); return true;
                case R.id.item_time: setDisableWidGets(false); setCurrentFragment(mPlayingTimeFragment,mTimeStart); return true;
                case R.id.item_win: setDisableWidGets(false); setCurrentFragment(mWinFragment, mNumberWins); return true;




            }


            return false;

        }
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}