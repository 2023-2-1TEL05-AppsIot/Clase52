package com.example.clase5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.os.Parcelable;

import com.example.clase5.databinding.ActivityMainBinding;
import com.example.clase5.entity.Persona;
import com.example.clase5.fragmentos.BlueFragment;
import com.example.clase5.viewModels.MainActivityViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    MainActivityViewModel mainActivityViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        mainActivityViewModel =
                new ViewModelProvider(MainActivity.this).get(MainActivityViewModel.class);

        binding.button2.setOnClickListener(view -> {

            String dniStr = binding.editTextDni.getText().toString();
            Persona persona = new Persona(dniStr);
            Bundle bundle = new Bundle();
            bundle.putSerializable("persona", persona);
            bundle.putString("dni", dniStr);

            getSupportFragmentManager()
                    .beginTransaction()
                    .setReorderingAllowed(true)
                    .addToBackStack(null)
                    .add(R.id.fragmentContainerView2, BlueFragment.class, bundle)
                    .commit();
        });

        binding.buttonEnviarData1.setOnClickListener(view -> {
            mainActivityViewModel.getListMutableLiveData().setValue(create10People());
        });

        mainActivityViewModel.getTexto().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                binding.editTextDni.setText(s);
            }
        });

    }

    public List<Persona> create10People() {
        ArrayList<Persona> lista = new ArrayList<>();
        lista.add(new Persona("123"));
        lista.add(new Persona("234"));
        lista.add(new Persona("96437"));
        lista.add(new Persona("56867"));
        lista.add(new Persona("86876"));
        lista.add(new Persona("65876"));
        lista.add(new Persona("756865"));
        lista.add(new Persona("3534"));
        return lista;
    }
}