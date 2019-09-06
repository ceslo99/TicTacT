package spideyninja.com.connect3game;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // red = 1
    // yellow = 0
    int playerTurn = 1;
    boolean gameOver = false;

    int [] gameState = {0,0,0,0,0,0,0,0,0};

    int numPlay = 0;



    public void dropIn(View view){

        TextView displayPlayer = (TextView) findViewById(R.id.winTextView);

        ImageView counter = (ImageView) view;


        int boxTouched = Integer.parseInt(counter.getTag().toString());

        if(gameState[boxTouched] == 0 && !gameOver){

            numPlay++;

            counter.setTranslationY(-1500);

            gameState[boxTouched] = playerTurn;


            if(playerTurn == 1){
                counter.setImageResource(R.drawable.red);
                playerTurn = 2;
                displayPlayer.setText("Yellow's Turn");

            }
            else{
                counter.setImageResource(R.drawable.yellow);
                playerTurn = 1;
                displayPlayer.setText("Red's Turn");
            }

            counter.animate().translationYBy(1500).rotation(3600).setDuration(300);

            //row 0
            if( gameState[0] == gameState[1] && gameState[0] == gameState[2] && gameState[0] != 0){
                Log.i("winner1", String.valueOf(gameState[0]));
                gameOver = true;
                winner(gameState[0]);
            }
            //row 1
            else if(gameState[3] == gameState[4] && gameState[3] == gameState[5] && gameState[3] != 0){
                Log.i("winner2", String.valueOf(gameState[3]));
                gameOver = true;
                winner(gameState[3]);
            }
            //row 2
            else if(gameState[6] == gameState[7] && gameState[6] == gameState[8] && gameState[6] != 0){
                Log.i("winner3", String.valueOf(gameState[6]));
                gameOver = true;
                winner(gameState[6]);
            }
            //column 0
            else if(gameState[0] == gameState[3] && gameState[0] == gameState[6] && gameState[0] != 0){
                Log.i("winner4", String.valueOf(gameState[0]));
                gameOver = true;
                winner(gameState[0]);
            }
            //column 1
            else if(gameState[1] == gameState[4] && gameState[1] == gameState[7] && gameState[1] != 0){
                Log.i("winner5", String.valueOf(gameState[1]));
                gameOver = true;
                winner(gameState[1]);
            }
            //column 2
            else if(gameState[2] == gameState[5] && gameState[2] == gameState[8] && gameState[2] != 0){
                Log.i("winner**", String.valueOf(gameState[2]));
                gameOver = true;
                winner(gameState[2]);
            }
            //left corner
            else if(gameState[0] == gameState[4] && gameState[0] == gameState[8] && gameState[0] != 0){
                Log.i("winner7", String.valueOf(gameState[0]));
                gameOver = true;
                winner(gameState[0]);
            }
            //right corner
            else if(gameState[2] == gameState[4] && gameState[2] == gameState[6] && gameState[2] != 0){
                Log.i("winner8", String.valueOf(gameState[2]));
                gameOver = true;
                winner(gameState[2]);
            }

            else if(numPlay == 9){
                displayPlayer.setText("Play Again!");
            }

        }


    }
    public void winner(int player){
        TextView displayPlayer = (TextView) findViewById(R.id.winTextView);

        if(player == 1){
            displayPlayer.setText("Winner Red!");
        }
        else{
            displayPlayer.setText("Winner Yellow!");
        }


    }

    public void resetGame(View view){
        GridLayout gridReset = (GridLayout) findViewById(R.id.gridLayout);
        TextView displayPlayer = (TextView) findViewById(R.id.winTextView);
        if(playerTurn == 1){
            displayPlayer.setText("Red's Turn");
        }
        else{
            displayPlayer.setText("Yellow's Turn");

        }

        numPlay = 0;
        for(int i = 0 ; i < 9 ;i++){
            gameState[i] = 0;
            ImageView counter = (ImageView) gridReset.getChildAt(i);
            counter.setImageDrawable(null);
        }

        gameOver = false;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
