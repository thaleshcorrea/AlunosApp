package unis.edu.alunosapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import unis.edu.alunosapp.R;
import unis.edu.alunosapp.model.Aluno;

public class AlunoAdapter extends RecyclerView.Adapter<AlunoAdapter.AlunoHolder> {

    private List<Aluno> alunos = new ArrayList<>();

    @NonNull
    @Override
    public AlunoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.aluno_item, parent, false);
        return new AlunoHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull AlunoHolder holder, int position) {
        Aluno alunoAtual = alunos.get(position);
        holder.textViewTitulo.setText(alunoAtual.getNome());
        holder.textViewSubtitulo.setText(alunoAtual.getPerfil());
    }

    @Override
    public int getItemCount() {
        return alunos.size();
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    class AlunoHolder extends RecyclerView.ViewHolder {
        private TextView textViewTitulo;
        private TextView textViewSubtitulo;

        public AlunoHolder(View itemView) {
            super(itemView);
            textViewTitulo = itemView.findViewById(R.id.text_view_titulo);
            textViewSubtitulo = itemView.findViewById(R.id.text_view_subtitulo);
        }
    }
}
