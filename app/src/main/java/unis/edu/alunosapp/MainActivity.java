package unis.edu.alunosapp;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import unis.edu.alunosapp.adapter.AlunoAdapter;
import unis.edu.alunosapp.model.Aluno;
import unis.edu.alunosapp.model.AlunoViewModel;

public class MainActivity extends AppCompatActivity {
    private AlunoViewModel alunoViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        final AlunoAdapter alunoAdapter = new AlunoAdapter();
        recyclerView.setAdapter(alunoAdapter);

        alunoViewModel = ViewModelProviders.of(this).get(AlunoViewModel.class);

        alunoViewModel.getAll().observe(this, new Observer<List<Aluno>>() {
            @Override
            public void onChanged(List<Aluno> alunos) {
                alunoAdapter.setAlunos(alunos);
            }
        });
    }
}