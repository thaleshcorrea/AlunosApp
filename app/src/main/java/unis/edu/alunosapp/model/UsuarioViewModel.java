package unis.edu.alunosapp.model;

import android.app.Application;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import unis.edu.alunosapp.helpers.AsyncResponse;


public class UsuarioViewModel extends AndroidViewModel {

    private UsuarioDao usuarioDao;
    private AppDatabase database;
    public AsyncResponse delegate = null;


    public UsuarioViewModel(@NonNull Application application) {
        super(application);

        database = AppDatabase.getDatabase(application);
        usuarioDao = database.usuarioDao();
    }

    public void getById(int id) {
        new UsuarioViewModel.GetByIdAsyncTask(usuarioDao).execute(id);
    }

    public void getByNome(String nome) {
        new UsuarioViewModel.GetByNomeAsyncTask(usuarioDao).execute(nome);
    }

    public void insert(Usuario usuario) {
        new UsuarioViewModel.InsertAsyncTask(usuarioDao).execute(usuario);
    }

    public void update(Usuario usuario) {
        new UsuarioViewModel.UpdateAsyncTask(usuarioDao).execute(usuario);
    }

    public void delete(Usuario usuario) {
        new UsuarioViewModel.DeleteAsyncTask(usuarioDao).execute(usuario);
    }

    private class GetByIdAsyncTask extends AsyncTask<Integer, Void, Usuario> {
        private UsuarioDao usuarioDao;

        public GetByIdAsyncTask(UsuarioDao usuarioDao) {
            this.usuarioDao = usuarioDao;
        }

        @Override
        protected Usuario doInBackground(Integer... integers) {
            return usuarioDao.getById(integers[0]);
        }

        @Override
        protected void onPostExecute(Usuario usuario) {
            delegate.processFinish(usuario);
        }
    }

    private class GetByNomeAsyncTask extends AsyncTask<String, Void, Usuario> {
        private UsuarioDao usuarioDao;

        public GetByNomeAsyncTask(UsuarioDao usuarioDao) {
            this.usuarioDao = usuarioDao;
        }

        @Override
        protected Usuario doInBackground(String... strings) {
            return usuarioDao.getByNome(strings[0]);
        }

        @Override
        protected void onPostExecute(Usuario usuario) {
            delegate.processFinish(usuario);
        }
    }

    private class InsertAsyncTask extends AsyncTask<Usuario, Void, Void> {
        private UsuarioDao usuarioDao;

        public InsertAsyncTask(UsuarioDao usuarioDao) {
            this.usuarioDao = usuarioDao;
        }

        @Override
        protected Void doInBackground(Usuario... usuarios) {
            usuarioDao.insert(usuarios[0]);
            return null;
        }
    }

    private class UpdateAsyncTask extends AsyncTask<Usuario, Void, Void> {
        private UsuarioDao usuarioDao;

        public UpdateAsyncTask(UsuarioDao usuarioDao) {
            this.usuarioDao = usuarioDao;
        }

        @Override
        protected Void doInBackground(Usuario... usuarios) {
            usuarioDao.update(usuarios[0]);
            return null;
        }
    }

    private class DeleteAsyncTask extends AsyncTask<Usuario, Void, Void> {
        private UsuarioDao usuarioDao;

        public DeleteAsyncTask(UsuarioDao usuarioDao) {
            this.usuarioDao = usuarioDao;
        }

        @Override
        protected Void doInBackground(Usuario... usuarios) {
            usuarioDao.delete(usuarios[0]);
            return null;
        }
    }
}
