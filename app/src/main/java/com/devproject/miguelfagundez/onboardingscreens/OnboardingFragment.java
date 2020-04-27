package com.devproject.miguelfagundez.onboardingscreens;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/********************************************
 * A simple {@link Fragment} subclass.
 * @author: Miguel Fagundez
 * @date: April 26th, 2020
 * @version: 1.0
 * *******************************************/
public class OnboardingFragment extends Fragment {

    public OnboardingFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_onboarding, container, false);
    }
}
