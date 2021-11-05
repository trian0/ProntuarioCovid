package com.example.prontuariocovid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Resultado extends AppCompatActivity implements View.OnClickListener{

    DatabaseReference pacientes = FirebaseDatabase.getInstance().getReference("Pacientes");
    PacienteResultado paciente = new PacienteResultado();
    Paciente paciente1 = new Paciente();
    String nome, idade, tosse, temperatura, dorCabeca, italia, china, indonesia, portugal, eua
            , diasItalia, diasChina, diasIndo, diasPt, diasEua;


    private ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);



        this.mViewHolder.editResultado = (TextView) findViewById(R.id.edit_resultado);
        this.mViewHolder.btnResultado = (Button) findViewById(R.id.btn_resultado);

        pacientes.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                    nome = dataSnapshot.child("nome").getValue().toString();
                    idade = dataSnapshot.child("idade").getValue().toString();
                    tosse = dataSnapshot.child("tosse").getValue().toString();
                    dorCabeca = dataSnapshot.child("dorCabeca").getValue().toString();
                    temperatura = dataSnapshot.child("temperatura").getValue().toString();
                    italia = dataSnapshot.child("italia").getValue().toString();
                    china = dataSnapshot.child("china").getValue().toString();
                    indonesia = dataSnapshot.child("indonesia").getValue().toString();
                    portugal = dataSnapshot.child("portugal").getValue().toString();
                    eua = dataSnapshot.child("eua").getValue().toString();
                    diasItalia = dataSnapshot.child("diasItalia").getValue().toString();
                    diasChina = dataSnapshot.child("diasChina").getValue().toString();
                    diasIndo = dataSnapshot.child("diasIndonesia").getValue().toString();
                    diasPt = dataSnapshot.child("diasPortugal").getValue().toString();
                    diasEua = dataSnapshot.child("diasEua").getValue().toString();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }

        });

        this.mViewHolder.btnResultado.setOnClickListener(this);

        this.clearValue();

    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btn_resultado){
            if((Integer.parseInt(diasItalia) >= 6 || Integer.parseInt(diasChina) >= 6 ||
                    Integer.parseInt(diasIndo) >= 6 || Integer.parseInt(diasPt) >= 6 ||
                    Integer.parseInt(diasEua) >= 6) && (Integer.parseInt(tosse) > 5 &&
                    Integer.parseInt(dorCabeca) > 5) &&
                    Integer.parseInt(temperatura) > 37){
                this.mViewHolder.editResultado.setText("Paciente deve ser internado");
            } else if((Integer.parseInt(diasItalia) >= 6 || Integer.parseInt(diasChina) >= 6 ||
                    Integer.parseInt(diasIndo) >= 6 || Integer.parseInt(diasPt) >= 6 ||
                    Integer.parseInt(diasEua) >= 6) || ((Integer.parseInt(paciente.getIdade()) < 10 ||
                    Integer.parseInt(paciente.getIdade()) > 60) &&
                    (Integer.parseInt(temperatura) > 37 || Integer.parseInt(dorCabeca) > 30 ||
                            Integer.parseInt(tosse) > 5)) ||
                    (Integer.parseInt(idade) >= 10 && Integer.parseInt(idade) <=60 &&
                            Integer.parseInt(tosse) > 5 &&
                            Integer.parseInt(dorCabeca) > 5 && Integer.parseInt(temperatura) > 5)){
                this.mViewHolder.editResultado.setText("Paciente deve ficar em quarentena");

            }
                this.mViewHolder.editResultado.setText("Paciente liberado!");


        }
    }

    private static class ViewHolder {
        TextView editResultado;
        Button btnResultado;
    }

    private void clearValue(){
        this.mViewHolder.editResultado.setText("");
    }
}