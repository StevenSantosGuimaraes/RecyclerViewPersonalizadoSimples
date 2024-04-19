package br.com.recyclerview.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.com.recyclerview.R;
import br.com.recyclerview.RecyclerItemClickListener;
import br.com.recyclerview.adapter.Adapter;
import br.com.recyclerview.model.Filme;

public class MainActivity extends AppCompatActivity {

    private RecyclerView lista;
    private List<Filme> listaDeFilmes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista = findViewById(R.id.recyclerViewTeste);
        this.criarFilmes();

        Adapter adapter = new Adapter(listaDeFilmes);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        lista.setLayoutManager(layoutManager);
        lista.setHasFixedSize(true);
        lista.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        lista.setAdapter(adapter);

        lista.addOnItemTouchListener(
            new RecyclerItemClickListener(
                getApplicationContext(),
                lista,
                new RecyclerItemClickListener.OnItemClickListener() {

                    @Override
                    public void onItemClick(View view, int position) {
                        Filme filme = listaDeFilmes.get(position);
                        Toast.makeText(getApplicationContext(), "Lançamento: " + filme.getAno(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onLongItemClick(View view, int position) {
                        Filme filme = listaDeFilmes.get(position);
                        Toast.makeText(getApplicationContext(), "Letreiro: " + filme.getTitulo(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                    }

                }
            )
        );

    }

    public void criarFilmes() {

        Filme filme = new Filme("Matrix", "1999", "Ficção Científica");
        listaDeFilmes.add(filme);

        filme = new Filme("Titanic", "1997", "Romance");
        listaDeFilmes.add(filme);

        filme = new Filme("Inception", "2010", "Ação");
        listaDeFilmes.add(filme);

        filme = new Filme("The Shawshank Redemption", "1994", "Drama");
        listaDeFilmes.add(filme);

        filme = new Filme("Forrest Gump", "1994", "Drama");
        listaDeFilmes.add(filme);

        filme = new Filme("The Dark Knight", "2008", "Ação");
        listaDeFilmes.add(filme);

        filme = new Filme("Pulp Fiction", "1994", "Crime");
        listaDeFilmes.add(filme);

        filme = new Filme("Fight Club", "1999", "Drama");
        listaDeFilmes.add(filme);

        filme = new Filme("The Godfather", "1972", "Crime");
        listaDeFilmes.add(filme);

        filme = new Filme("The Lord of the Rings: The Fellowship of the Ring", "2001", "Aventura");
        listaDeFilmes.add(filme);

        filme = new Filme("Star Wars: Episode IV - A New Hope", "1977", "Ação");
        listaDeFilmes.add(filme);

        filme = new Filme("Jurassic Park", "1993", "Aventura");
        listaDeFilmes.add(filme);

        filme = new Filme("The Matrix Reloaded", "2003", "Ficção Científica");
        listaDeFilmes.add(filme);

        filme = new Filme("Avatar", "2009", "Aventura");
        listaDeFilmes.add(filme);

        filme = new Filme("The Lion King", "1994", "Animação");
        listaDeFilmes.add(filme);

        filme = new Filme("Eternal Sunshine of the Spotless Mind", "2004", "Drama");
        listaDeFilmes.add(filme);

        filme = new Filme("Inglourious Basterds", "2009", "Ação");
        listaDeFilmes.add(filme);

        filme = new Filme("The Social Network", "2010", "Drama");
        listaDeFilmes.add(filme);

        filme = new Filme("La La Land", "2016", "Comédia Musical");
        listaDeFilmes.add(filme);

        filme = new Filme("Interstellar", "2014", "Ficção Científica");
        listaDeFilmes.add(filme);

    }

}