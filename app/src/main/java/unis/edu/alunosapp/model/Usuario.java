package unis.edu.alunosapp.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "usuario")
public class Usuario {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NonNull
    public String getNome() {
        return nome;
    }

    @NonNull
    public String getSenha() {
        return senha;
    }

    public Usuario(String nome, String senha) {
        this.nome = nome;
        this.senha = senha;
    }

    @PrimaryKey(autoGenerate = true)
    private int id;

    @NonNull
    private String nome;

    @NonNull
    private String senha;
}
