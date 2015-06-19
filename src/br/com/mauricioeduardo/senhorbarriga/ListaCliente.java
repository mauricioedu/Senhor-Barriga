package br.com.mauricioeduardo.senhorbarriga;




import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;

public class ListaCliente extends Activity {
	
	private ListView lista;
	private EditText busca;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lista_cliente);
		
		
		String[] nomes = { "Mauricio", "Carol", "Rafael", "Nazare", "João",
				"Jose", "Celina", "Douglas", "Socorro", "Fulano", "Sicrano",
				"Natalia" };
		lista = (ListView) findViewById(R.id.lista);
		busca = (EditText) findViewById(R.id.busca);
		int layout = android.R.layout.simple_list_item_1;
		final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				layout, nomes);

		lista.setAdapter(adapter);

		busca.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence cs, int arg1, int arg2,
					int arg3) {
				adapter.getFilter().filter(cs);
			}

			@Override
			public void beforeTextChanged(CharSequence arg0, int arg1,
					int arg2, int arg3) {
				// TODO Auto-generated method stub
			}

			@Override
			public void afterTextChanged(Editable arg0) {
				// TODO Auto-generated method stub
			}
		});

		// pegando a posição do clique na lista
		lista.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> adapter, View view,
					int posicao, long id) {

				Toast.makeText(ListaCliente.this,
						"Clique foi dado na posicao " +posicao,
						Toast.LENGTH_SHORT).show();
			}
		});
		lista.setOnItemLongClickListener(new OnItemLongClickListener() {

			@Override
			public boolean onItemLongClick(AdapterView<?> adapter, View view,
					int posicao, long id) {
				Toast.makeText(
						ListaCliente.this,
						"Clique longo na " + adapter.getItemAtPosition(posicao),
						Toast.LENGTH_SHORT).show();
				return true;
			}
		});

	}
		
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.lista_cliente, menu);
		return super.onCreateOptionsMenu(menu);
		
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		 
		 int itemClicado = item.getItemId();
			if (itemClicado == R.id.novo) {
				Intent cadastroCliente = new Intent(this,CadastroCliente.class);
				startActivity(cadastroCliente);
			}
		 
		 return super.onOptionsItemSelected(item);
	}
}

	

