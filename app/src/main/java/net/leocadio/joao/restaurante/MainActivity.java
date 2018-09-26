package net.leocadio.joao.restaurante;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Declara os objetos referentes ao elementos no layout
    private EditText mEditTextValorConta, mEditTextDinheiro;
    private TextView mTextViewValorGorjeta, mTextViewTotal, mTextViewTroco;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializamos todos os objetos referentes aos elementos do layout
        mEditTextValorConta = findViewById(R.id.editTextValorConta);
        mEditTextDinheiro = findViewById(R.id.editTextDinheiro);
        mTextViewValorGorjeta = findViewById(R.id.textViewValorGorojeta);
        mTextViewTotal = findViewById(R.id.textViewTotal);
        mTextViewTroco = findViewById(R.id.textViewTroco);
    }

    public void calcular(View view) {
        // Recuperamos os valores digitados
        String valorContaDigitada = mEditTextValorConta.getText().toString();
        String valorDinheiroDigitado = mEditTextDinheiro.getText().toString();
        // Verificamos se existe algum valor recuperado vazio
        // Observe o operador lógico negativo !
        if (!(valorContaDigitada.isEmpty()) && !(valorDinheiroDigitado.isEmpty())) {
            // Se os valores não são vazios, converte-os para float
            float valorConta = Float.parseFloat(valorContaDigitada);
            float valorDinheiro = Float.parseFloat(valorDinheiroDigitado);
            // Realiza os cálculos
            float valorGorjeta = valorConta * 15 / 100;
            float total = valorConta + valorGorjeta;
            float troco = valorDinheiro - total;
            // Exibe os resultados para o usuário
            mTextViewValorGorjeta.setText(String.format("R$ %.2f", valorGorjeta));
            mTextViewTotal.setText(String.format("R$ %.2f", total));
            mTextViewTroco.setText(String.format("R$ %.2f", troco));
        }
    }

    public void limparDados(View view) {
        // Limpa todos os EditText no layout
        mEditTextValorConta.setText("");
        mEditTextDinheiro.setText("");
    }

}
