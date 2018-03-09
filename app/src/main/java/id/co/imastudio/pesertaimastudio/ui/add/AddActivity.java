package id.co.imastudio.pesertaimastudio.ui.add;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import id.co.imastudio.pesertaimastudio.R;
import id.co.imastudio.pesertaimastudio.db.model.ModelPeserta;

public class AddActivity extends AppCompatActivity {
    Button submit;
    EditText edtNama, edtPelatihan;

    AddViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        submit = findViewById(R.id.btnSubmit);
        edtNama = findViewById(R.id.edtNama);
        edtPelatihan = findViewById(R.id.edtPelatihan);

        viewModel = ViewModelProviders.of(this).get(AddViewModel.class);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nama = edtNama.getText().toString();
                String pelatihan = edtPelatihan.getText().toString();
                if (nama.isEmpty() && pelatihan.isEmpty()) {
                    Toast.makeText(AddActivity.this, "Masih Kosong", Toast.LENGTH_SHORT).show();
                } else {
                    viewModel.addPeserta(new ModelPeserta(nama, pelatihan));
                    finish();
                }
            }
        });
    }
}
