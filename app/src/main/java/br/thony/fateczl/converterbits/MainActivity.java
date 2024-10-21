package br.thony.fateczl.converterbits;

import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private RadioButton rbBytes;
    private RadioButton rbKb;
    private RadioButton rbMb;
    private RadioButton rbGb;
    private RadioButton rbTb;
    private Button btnConverter;
    private TextView tvRes;
    private TextInputEditText txtEntrada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        rbBytes = findViewById(R.id.rbBytes);
        rbBytes.setChecked(true);

        rbKb = findViewById(R.id.rbKb);
        rbMb = findViewById(R.id.rbMb);
        rbGb = findViewById(R.id.rbGb);
        rbTb = findViewById(R.id.rbTb);
        btnConverter = findViewById(R.id.btnConverter);
        tvRes = findViewById(R.id.tvRes);
        txtEntrada = findViewById(R.id.txtEntrada);
        
        btnConverter.setOnClickListener(op -> converterBits());
    }

    private void converterBits() {
        double bits = Double.parseDouble(txtEntrada.getText().toString());

        if (rbBytes.isChecked()) {
            bits = bits / 8;
        } else if (rbKb.isChecked()) {
            bits = bits / 8192;
        } else if (rbMb.isChecked()) {
            bits = bits / 8192;
            bits = bits / 1024;
        } else if (rbGb.isChecked()) {
            bits = bits / 8192;
            bits = bits / 1024;
            bits = bits / 1024;
        } else {
            bits = bits / 8192;
            bits = bits / 1024;
            bits = bits / 1024;
            bits = bits / 1024;
        }

        tvRes.setText(String.valueOf(bits));
    }
}