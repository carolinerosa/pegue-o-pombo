package pegueupombo;

import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends Activity {
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        GameView game = new GameView(this);
        setContentView(game);
    }
}