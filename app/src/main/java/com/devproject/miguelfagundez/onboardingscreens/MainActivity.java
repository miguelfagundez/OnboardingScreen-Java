package com.devproject.miguelfagundez.onboardingscreens;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

/********************************************
 * OnboardingActivity
 *
 * @author: Miguel Fagundez
 * @date: April 26th, 2020
 * @version: 1.0
 * *******************************************/
public class MainActivity extends AppCompatActivity {

    // Members
    private int position;
    private FirstTimePagerAdapter adapter;
    private OnboardingFragment onboardingFragment;

    // Views
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private Button btnBack;
    private Button btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupMembers();
        // Set up the view pager
        setupViewPager();
        // Set up view visibility
        setupViewVisibility();
        // setup buttons listeners
        setupListeners();
    }

    private void setupMembers() {
        position = 0;
        adapter = new FirstTimePagerAdapter(this, setupOnboardingData());
        onboardingFragment = new OnboardingFragment();
        viewPager = findViewById(R.id.vpIntro);
        tabLayout = findViewById(R.id.tabPagerIndicator);
        btnBack = findViewById(R.id.btnBack);
        btnNext = findViewById(R.id.btnNext);
    }

    // Initialization of Data
    private ArrayList<OnboardingData> setupOnboardingData() {
        ArrayList<OnboardingData> list = new ArrayList<OnboardingData>();

        list.add(new OnboardingData(
                getString(R.string.title_onboarding),
                getString(R.string.one_time_register),
                R.drawable.data_protection_mobile_min));

        list.add(new OnboardingData(
                getString(R.string.title_picture_onboarding),
                getString(R.string.notes_pictures),
                R.drawable.share_data_min));

        list.add(new OnboardingData(
                getString(R.string.title_memory_onboarding),
                getString(R.string.notes_external_card),
                R.drawable.delete_min));

        return list;
    }

    // Set up TabLayout with this viewpager
    private void setupViewPager() {
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupViewVisibility() {
        // Button Back visibility
        btnBack.setVisibility(View.GONE);
        if(position!=0) btnBack.setVisibility(View.VISIBLE);

        // Button next and Go to MainActivity
        btnNext.setVisibility(View.VISIBLE);
    }

    private void setupListeners() {
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                position = viewPager.getCurrentItem();
                if(position < 3){
                    position += 1;
                    viewPager.setCurrentItem(position);
                    setupViewVisibility();
                }
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                position = viewPager.getCurrentItem();
                if (position > 0){
                    position -= 1;
                    viewPager.setCurrentItem(position);
                    setupViewVisibility();
                }
            }
        });

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                position = tab.getPosition();
                if (position >= 0) setupViewVisibility();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}
