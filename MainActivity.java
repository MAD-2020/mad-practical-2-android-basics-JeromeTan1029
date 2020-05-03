package sg.edu.np.whack_a_mole;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button ButtonLeft;
    private Button ButtonMiddle;
    private Button ButtonRight;
    private TextView ScoreText;
    private List<Button> buttonList = new ArrayList<Button>();
    private int score;

    private static final String TAG = "Whack-A-Mole";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setTitle("Whack-A-Mole!"); // Sets Title Of App

        ButtonLeft = (Button) findViewById(R.id.ButtonLeft);
        ButtonMiddle = (Button) findViewById(R.id.ButtonMiddle);
        ButtonRight = (Button) findViewById(R.id.ButtonRight);
        ScoreText = findViewById(R.id.Score);
        score = 0;

        buttonList.add(ButtonLeft);
        buttonList.add(ButtonMiddle);
        buttonList.add(ButtonRight);

        ButtonLeft.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Log.v(TAG, "Left Button Clicked!");
                if (hitCorrectButton(ButtonLeft)){
                    Log.v(TAG, "Hit, score added!");
                    score += 1;
                }
                else{
                    Log.v(TAG, "Missed, score deducted!");
                    score -= 1;
                }
                ScoreText.setText(score + "");
                setNewMole(buttonList);
            }
        });

        ButtonMiddle.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Log.v(TAG, "Middle Button Clicked!");
                if (hitCorrectButton(ButtonMiddle)){
                    Log.v(TAG, "Hit, score added!");
                    score += 1;
                }
                else{
                    Log.v(TAG, "Missed, score deducted!");
                    score -= 1;
                }
                ScoreText.setText(score + "");
                setNewMole(buttonList);
            }
        });

        ButtonRight.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Log.v(TAG, "Right Button Clicked!");
                if (hitCorrectButton(ButtonRight)){
                    Log.v(TAG, "Hit, score added!");
                    score += 1;
                }
                else{
                    Log.v(TAG, "Missed, score deducted!");
                    score -= 1;
                }
                ScoreText.setText(score + "");
                setNewMole(buttonList);
            }
        });

        Log.v(TAG, "Finished Pre-Initialisation!");
    }

    protected void onStart(){
        super.onStart();
        setNewMole(buttonList);
    }

    private boolean hitCorrectButton(Button button){
        if (button.getText().equals("*")){
            return true;
        }

        else if (button.getText().equals("O")){
            return false;
        }

        return false;
    }

    private void setNewMole(List<Button> buttonList){
        Random r = new Random();
        int molePlace = r.nextInt(3);
        for (Button button : buttonList){
            button.setText("O");
        }
        buttonList.get(molePlace).setText("*");
    }
}
