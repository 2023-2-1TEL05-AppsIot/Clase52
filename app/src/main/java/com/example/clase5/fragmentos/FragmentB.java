package com.example.clase5.fragmentos;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.clase5.R;
import com.example.clase5.databinding.FragmentABinding;
import com.example.clase5.databinding.FragmentBBinding;
import com.example.clase5.databinding.FragmentCBinding;

public class FragmentB extends Fragment {

    FragmentBBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentBBinding.inflate(inflater, container, false);

        binding.buttonToC.setOnClickListener(view -> {

            NavController navController = NavHostFragment.findNavController(FragmentB.this);
            navController.navigate(FragmentBDirections.actionFragmentBToFragmentC());
        });

        return binding.getRoot();
    }
}