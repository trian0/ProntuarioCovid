package com.example.prontuariocovid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;


import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private ViewHolder mViewHolder = new ViewHolder();
    int it = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        this.mViewHolder.editNome = (EditText) findViewById(R.id.edit_nome);
        this.mViewHolder.editIdade = (EditText) findViewById(R.id.edit_idade);
        this.mViewHolder.editTemperatura = (EditText) findViewById(R.id.edit_temperatura);
        this.mViewHolder.editTosse = (EditText) findViewById(R.id.edit_tosse);
        this.mViewHolder.editDorCabeca = (EditText) findViewById(R.id.edit_dor_cabeca);
        this.mViewHolder.editItalia = (CheckBox) findViewById(R.id.edit_italia);
        this.mViewHolder.editChina = (CheckBox) findViewById(R.id.edit_china);
        this.mViewHolder.editIndonesia = (CheckBox) findViewById(R.id.edit_indonesia);
        this.mViewHolder.editPortugal = (CheckBox) findViewById(R.id.edit_portugal);
        this.mViewHolder.editEua = (CheckBox) findViewById(R.id.edit_eua);
        this.mViewHolder.editDiasIt = (EditText) findViewById(R.id.edit_diasIt);
        this.mViewHolder.editDiasChi = (EditText) findViewById(R.id.edit_diasChi);
        this.mViewHolder.editDiasIndo = (EditText) findViewById(R.id.edit_diasInd);
        this.mViewHolder.editDiasPt = (EditText) findViewById(R.id.edit_diasPt);
        this.mViewHolder.editDiasEua = (EditText) findViewById(R.id.edit_diasEua);
        this.mViewHolder.btnEnviar = (Button) findViewById(R.id.button_enviar);

        Paciente paciente = new Paciente();

        DatabaseReference pacientes = FirebaseDatabase.getInstance().getReference("Pacientes");

        mViewHolder.btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mViewHolder.editNome.getText().toString().equals("") ||
                        mViewHolder.editIdade.getText().toString().equals("") ||
                        mViewHolder.editTemperatura.getText().toString().equals("") ||
                        mViewHolder.editTosse.getText().toString().equals("") ||
                        mViewHolder.editDorCabeca.getText().toString().equals("") ||
                        mViewHolder.editDiasIt.getText().toString().equals("") ||
                        mViewHolder.editDiasChi.getText().toString().equals("") ||
                        mViewHolder.editDiasIndo.getText().toString().equals("") ||
                        mViewHolder.editDiasPt.getText().toString().equals("") ||
                        mViewHolder.editDiasEua.getText().toString().equals(""))
                {
                    Toast.makeText(MainActivity.this,"Informe os dados corretamente!",Toast.LENGTH_LONG).show();
                } else{
                    paciente.setNome(mViewHolder.editNome.getText().toString());
                    paciente.setIdade(Integer.parseInt(mViewHolder.editIdade.getText().toString()));
                    paciente.setTemperatura(Double.parseDouble(mViewHolder.editTemperatura.getText().toString()));
                    paciente.setTosse(Integer.parseInt(mViewHolder.editTosse.getText().toString()));
                    paciente.setDorCabeca(Integer.parseInt(mViewHolder.editDorCabeca.getText().toString()));
                    paciente.setDiasItalia(Integer.parseInt(mViewHolder.editDiasIt.getText().toString()));
                    paciente.setDiasChina(Integer.parseInt(mViewHolder.editDiasChi.getText().toString()));
                    paciente.setDiasIndonesia(Integer.parseInt(mViewHolder.editDiasIndo.getText().toString()));
                    paciente.setDiasPortugal(Integer.parseInt(mViewHolder.editDiasPt.getText().toString()));
                    paciente.setDiasEua(Integer.parseInt(mViewHolder.editDiasEua.getText().toString()));
                    paciente.setItalia(mViewHolder.editItalia.isChecked());
                    paciente.setChina(mViewHolder.editIndonesia.isChecked());
                    paciente.setIndonesia(mViewHolder.editIndonesia.isChecked());
                    paciente.setPortugal(mViewHolder.editPortugal.isChecked());
                    paciente.setEua(mViewHolder.editEua.isChecked());
                    pacientes.child(pacientes.push().getKey()).setValue(paciente).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            Toast.makeText(MainActivity.this,"Sucesso",Toast.LENGTH_LONG).show();
                        }
                    });

                    irParaResultado();
                }











            }
        });


    }

    private void irParaResultado(){
         Intent resultado = new Intent(this, Resultado.class);
         startActivity(resultado);
    }

    private static class ViewHolder {
        EditText editNome;
        EditText editIdade;
        EditText editTemperatura;
        EditText editTosse;
        EditText editDorCabeca;
        CheckBox editItalia;
        CheckBox editChina;
        CheckBox editIndonesia;
        CheckBox editPortugal;
        CheckBox editEua;
        EditText editDiasIt;
        EditText editDiasChi;
        EditText editDiasIndo;
        EditText editDiasPt;
        EditText editDiasEua;
        Button btnEnviar;
    }

}