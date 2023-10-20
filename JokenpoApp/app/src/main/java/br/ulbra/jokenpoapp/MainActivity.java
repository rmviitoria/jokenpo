package br.ulbra.jokenpoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int  pontuacaoJogador = 0,pontuacaoApp =0;
    Button btnReiniciar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void selecionadoPedra(View view) {
        this.opcaoSelecionado("pedra");
    }
    public void SelecionadoPapel(View view){
        this.opcaoSelecionado("papel");
    }
    public void selecionadoTesoura(View view){
        this.opcaoSelecionado("tesoura");
    }
    public void opcaoSelecionado(String opcaoSelecionada){
        ImageView imageResultado = findViewById(R.id.Padrao);
        TextView txtResult = findViewById(R.id.txtResultado);

        String[] opcoes = {"pedra", "papel","tesoura"};
        String opcaoApp = opcoes[new Random().nextInt(3)];
        btnReiniciar=(Button)findViewById(R.id.btnReiniciar);
        switch (opcaoApp){
            case "pedra":
                imageResultado.setImageResource(R.drawable.pedra);
                break;
            case "papel":
                imageResultado.setImageResource(R.drawable.papel);
                break;
            case "tesoura":
                imageResultado.setImageResource(R.drawable.tesoura);
                break;
        }
        if ((opcaoApp.equals("tesoura")&& opcaoSelecionada.equals("papel"))||
                (opcaoApp.equals("papel")&& opcaoSelecionada.equals("pedra"))||
                (opcaoApp.equals("pedra")&& opcaoSelecionada.equals("tesoura"))){
            pontuacaoApp += 1;
            atualizarPlacar ();
            if(pontuacaoApp ==2){
                txtResult.setText("Resultado: Você PERDEU!");
            }
        }else if ((opcaoSelecionada.equals("tesoura")&& opcaoApp.equals("papel"))||
                (opcaoSelecionada.equals("papel")&& opcaoApp.equals("pedra")) ||
                (opcaoSelecionada.equals("pedra")&& opcaoApp.equals("tesoura"))){
            pontuacaoJogador +=1;
            atualizarPlacar();
            if(pontuacaoJogador == 2){
            txtResult.setText("Reultado: Você GANHOU! :D");
            }
        }else{
            txtResult.setText("Resultado: Vocês EMPATARAM!");
        }
}

    public void atualizarPlacar() {
        TextView txtPlacar = findViewById(R.id.txtPlacar);
        txtPlacar.setText("Jogador: "+ pontuacaoJogador + " - App: " +
                pontuacaoApp);}


    public void reiniciarJogo(View view){
        pontuacaoJogador = 0;
        pontuacaoApp =0;
    atualizarPlacar();
    ImageView imageResultado =  findViewById(R.id.Padrao);
    imageResultado.setImageResource(android.R.color.transparent);
    }
}