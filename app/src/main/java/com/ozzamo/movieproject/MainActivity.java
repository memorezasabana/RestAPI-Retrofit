public class MainActivity extends AppCompatActivity {
    @BindView(R.id.list_movies)
    RecyclerView listMovies;
    MovieAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        adapter = new MovieAdapter();
        listMovies.setLayoutManager(new LinearLayoutManager(this));
        listMovies.setAdapter(adapter);
        listMovies.addItemDecoration(new DividerItemDecoration(this,
                DividerItemDecoration.VERTICAL));
        RestClient.getMovieService().getMovies().enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call,
                                   Response<MovieResponse> response) {
                adapter.listMovies.addAll(response.body().getSearch());
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        };
    }
}