package br.com.intelligencesoftware.conversordebases;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText inputNumber;
    private RadioButton octalRadioButton, binaryRadioButton, hexadecimalRadioButton;
    private Button convertButton;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputNumber = findViewById(R.id.input_number);
        octalRadioButton = findViewById(R.id.octal_radio_button);
        binaryRadioButton = findViewById(R.id.binary_radio_button);
        hexadecimalRadioButton = findViewById(R.id.hexadecimal_radio_button);
        convertButton = findViewById(R.id.convert_button);
        resultTextView = findViewById(R.id.result_text);

        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = inputNumber.getText().toString().trim();
                if (!input.isEmpty()) {
                    try {
                        long decimalValue;
                        if (octalRadioButton.isChecked()) {
                            decimalValue = Long.parseLong(input, 8);
                        } else if (binaryRadioButton.isChecked()) {
                            decimalValue = Long.parseLong(input, 2);
                        } else {
                            decimalValue = Long.parseLong(input, 16);
                        }
                        resultTextView.setText("Valor Decimal: " + decimalValue);
                    } catch (NumberFormatException e) {
                        resultTextView.setText("Entrada inválida! Por favor entre com um número válido.");
                    }
                } else {
                    resultTextView.setText("Por favor entre um número.");
                }
            }
        });
    }
}
