package com.example.electronicapplication.ui.Profile;

import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.electronicapplication.ProfileActivity;
import com.example.electronicapplication.R;

public class ProfileFragment extends Fragment {

    private ProfileViewModel toolsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        toolsViewModel =
                ViewModelProviders.of(this).get(ProfileViewModel.class);
        View root = inflater.inflate(R.layout.fragment_profile, container, false);
        Intent intent = new Intent(getContext(), ProfileActivity.class);
        startActivity(intent);

        return root;
    }

}