package com.example.clase5.fragmentos;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.clase5.R;
import com.example.clase5.databinding.FragmentBlankBinding;
import com.example.clase5.entity.Persona;
import com.example.clase5.viewModels.MainActivityViewModel;

import java.util.List;
import java.util.Random;

public class BlankFragment extends Fragment {

    FragmentBlankBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentBlankBinding.inflate(inflater, container, false);

        MainActivityViewModel mainActivityViewModel =
                new ViewModelProvider(getActivity()).get(MainActivityViewModel.class);

        binding.button.setOnClickListener(view -> {
            Toast.makeText(container.getContext(), "Un toast desde el fragmento", Toast.LENGTH_SHORT).show();
            String s = binding.editTextText.getText().toString();

            mainActivityViewModel.getTexto().setValue(s);
        });



        mainActivityViewModel.getListMutableLiveData().observe(getViewLifecycleOwner(), personas -> {
            Random r = new Random();
            binding.textView4.setText(personas.get(r.nextInt(personas.size())).getDni());
        });

        return binding.getRoot();
    }

}