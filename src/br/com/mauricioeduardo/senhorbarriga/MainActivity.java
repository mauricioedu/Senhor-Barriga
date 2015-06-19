package br.com.mauricioeduardo.senhorbarriga;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;


public class MainActivity extends Activity implements AnimationListener{
	
	private ImageView imageLogo;
	private Animation animFadein;
	private static int SPLASH_TIME_OUT = 3000;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		imageLogo = (ImageView) findViewById(R.id.imgLogo);
		animFadein = AnimationUtils.loadAnimation(getApplicationContext(),
				R.anim.fade_in);
		animFadein.setAnimationListener(this);

		new Handler().postDelayed(new Runnable() {
			@Override
			public void run() {

				Intent i = new Intent(MainActivity.this, ListaCliente.class);
				startActivity(i);

				finish();

				imageLogo.startAnimation(animFadein);
			}
		}, SPLASH_TIME_OUT);
	}

	@Override
	public void onAnimationStart(Animation animation) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onAnimationEnd(Animation animation) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onAnimationRepeat(Animation animation) {
		// TODO Auto-generated method stub

	}

}
	
	
	

	
