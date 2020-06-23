package unis.edu.alunosapp.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "aluno")
public class Aluno {

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @NonNull
    public String getNome() {
        return nome;
    }

    public String getPerfil() {
        return perfil;
    }

    public String getFoto() {
        return foto;
    }

    public Aluno(String nome, String perfil, String foto) {
        this.nome = nome;
        this.perfil = perfil;
        this.foto = foto;
    }

    @PrimaryKey(autoGenerate = true)
    private int id;

    @NonNull
    private String nome;

    private String perfil;

    private String foto;
}
