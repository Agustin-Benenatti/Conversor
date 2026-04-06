package com.ab.conversor;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.ab.conversor.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
private com.ab.conversor.databinding.ActivityMainBinding binding;
private MainActivityViewModel viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityMainBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());
        binding.TvDolares.setEnabled(false);
        binding.TvEuros.setEnabled(false);

        viewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);

        viewModel.getResultado().observe(this, new Observer<Double>() {
            @Override
            public void onChanged(Double resultado) {
                if(resultado != null){
                    if(binding.RbDolares.isChecked()){
                        binding.TvDolares.setText(String.format("%.2f",resultado));
                    }else{
                        binding.TvEuros.setText(String.format("%.2f",resultado));
                    }
                }
            }
        });

        viewModel.getError().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String error) {
                if(error != null){
                    Toast.makeText(MainActivity.this,error,Toast.LENGTH_SHORT).show();
                }
            }
        });

        viewModel.getTipoCambio().observe(this, new Observer<Double>() {
            @Override
            public void onChanged(Double cambio) {
                if(cambio != null){
                    binding.ValorConversion.setText(String.valueOf(cambio));
                }
            }
        });

        //cuando hacemos click en el radio button de dolares
        //habilitamos el campo euros para escribir el monto para hacer la conversion
        binding.RbDolares.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.TvDolares.setEnabled(false);
                binding.TvEuros.setEnabled(true);

                binding.TvDolares.setText("");
                binding.TvEuros.setText("");
            }
        });

        //cuando hacemos click en el radio button de euros
        //habilitamos el campo dolares para escribir el monto para hacer la conversion
        binding.RbEuros.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.TvDolares.setEnabled(true);
                binding.TvEuros.setEnabled(false);

                binding.TvDolares.setText("");
                binding.TvEuros.setText("");
            }
        });

        //El boton de convertir solo hace la conversion correspondiente
        //si no se encuentran vacios los TvDolares y TvEuros, de lo contrario
        //Lanza el Toast con el mensaje..
        binding.BtnConvertir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(binding.RbDolares.isChecked()){
                    // Euros a dolares
                    viewModel.convertirADolares(
                            binding.TvEuros.getText().toString()
                    );

                }else if (binding.RbEuros.isChecked()){
                    // Dolares a Euros
                    viewModel.convertirAEuros(
                            binding.TvDolares.getText().toString()
                    );

                }else {
                    Toast.makeText(MainActivity.this,"Seleccione una opción (Dolares-Euros)",Toast.LENGTH_SHORT).show();
                }
            }
        });

        //Este boton cambia el valor para hacer la conversion, si o si tiene que haber un valor
        //de lo contrario nos salta un mensaje para que ingresemos un valor
        binding.BtnCambiarValor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.setTipoCambio(binding.ValorConversion.getText().toString());
            }
        });
    }
}