package id.co.imastudio.pesertaimastudio.ui.main;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import id.co.imastudio.pesertaimastudio.R;
import id.co.imastudio.pesertaimastudio.db.model.ModelPeserta;
import id.co.imastudio.pesertaimastudio.ui.add.AddActivity;

public class MainActivity extends AppCompatActivity implements View.OnLongClickListener {

    private RecyclerView recyclerView;
    private MainAdapter adapter;
    private MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, AddActivity.class));
            }
        });
        adapter = new MainAdapter(new ArrayList<ModelPeserta>(), this);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        viewModel = ViewModelProviders.of(this).get(MainViewModel.class);

        //subcribe
        viewModel.getAll().observe(MainActivity.this, new Observer<List<ModelPeserta>>() {
            @Override
            public void onChanged(@Nullable List<ModelPeserta> modelPesertas) {
                adapter.addUser(modelPesertas);
                Toast.makeText(MainActivity.this, "Berhasil Ditambahkan", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onLongClick(View view) {
        ModelPeserta modelPeserta = (ModelPeserta) view.getTag();
        viewModel.deleteItem(modelPeserta);
        Toast.makeText(this, "Berhasil dihapus", Toast.LENGTH_SHORT).show();
        return true;
    }
}
