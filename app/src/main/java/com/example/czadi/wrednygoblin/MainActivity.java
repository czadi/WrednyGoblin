package com.example.czadi.wrednygoblin;


import android.graphics.Point;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity {

    int stan=1;
    int pozycja=1;
    int liczbaPrzeszkod=10;
/////////////////////////////////////////////////////
    //przeszkody
    /////////////////////////////////////////////////////
    interface przeszkoda{
        int stanPrzeszkody=1;
        int pozycjaPrzeszkody=1;
        int wysokoscPozycjiPrzeszkody=0;
        int szerokoscPozycjiPrzeszkody=0;
    }
    przeszkoda tabPrzeszkod[];

    class dol implements przeszkoda{
        int stanPrzeszkody=0;
    }
    class mur implements przeszkoda{
        int stanPrzeszkody=1;
    }
    class sufit implements przeszkoda{
        int stanPrzeszkody=2;
    }

/////////////////////////////////////////////////////////////
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ////////////////////////////////////////////////


        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        final int width = size.x;
        final int height = size.y;

        //tworzenie przyciskow i obrazkow
        Button bU = (Button)findViewById(R.id.button);
        Button bD = (Button)findViewById(R.id.button2);
        Button bL = (Button)findViewById(R.id.button3);
        Button bR = (Button)findViewById(R.id.button4);
        Button start=(Button)findViewById(R.id.button5);

        final ImageView przeszkoda01 = (ImageView)findViewById(R.id.pozycja0numer1);
        ImageView przeszkoda11 = (ImageView)findViewById(R.id.pozycja1numer1);
        ImageView przeszkoda21 = (ImageView)findViewById(R.id.pozycja2numer1);

        /////////////////////////
        przeszkoda01.setImageResource(R.drawable.niskimur);
        przeszkoda11.setImageResource(R.drawable.mur);
        przeszkoda21.setImageResource(R.drawable.dziurawmurze);
        final ImageView ludek = (ImageView)findViewById(R.id.ludek);

        przeszkoda01.setY((float) (przeszkoda01.getY()-0.13*(width)));
        przeszkoda11.setY((float) (przeszkoda01.getY()-0.13*(width)));
        przeszkoda21.setY((float) (przeszkoda01.getY()-0.13*(width)));



        /////////////////////////////////////////////
        View.OnClickListener ruch = new View.OnClickListener() {

            @Override
            public void onClick(final View v) {

                new Thread(
                        new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    while(przeszkoda01.getY()<height) {
                                        Thread.sleep(10);
                                        przeszkoda01.setY(przeszkoda01.getY()+3);
                                    }
                                }catch (InterruptedException e){
                                    e.printStackTrace();
                                }
                            }
                        }
                ).start();

            }
        };
        start.setOnClickListener(ruch);


        View.OnClickListener l1 = new View.OnClickListener() {

            @Override
            public void onClick(final View v) {

                new Thread(
                        new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    if(v.getId()==R.id.button)
                                    {
                                        if(stan==1){
                                            stan=2;

                                                ludek.setY(9*(ludek.getY())/10);

                                                Thread.sleep(1000);

                                                ludek.setY(10*(ludek.getY())/9);

                                            stan = 1;
                                        }
                                    }
                                    if(v.getId()==R.id.button2)
                                    {
                                        if(stan==1){
                                            stan = 0;
                                                ludek.setY(11*(ludek.getY())/10);

                                                Thread.sleep(1000);

                                                ludek.setY(10*(ludek.getY())/11);

                                            stan = 1;

                                        }
                                    }

                                    if(v.getId()==R.id.button3)
                                    {

                                        switch (pozycja){
                                            case 1:ludek.setX(ludek.getX()/3);
                                                break;
                                            case 2:ludek.setX(ludek.getX()*3/5);
                                                break;



                                        }
                                        if(pozycja==0)
                                            pozycja=0;
                                        else
                                            pozycja--;

                                    }
                                    if(v.getId()==R.id.button4)
                                    {

                                        switch (pozycja){
                                            case 0:ludek.setX(ludek.getX()*3);
                                                break;
                                            case 1:ludek.setX(ludek.getX()*5/3);
                                                break;


                                        }
                                        if(pozycja==2)
                                            pozycja=2;
                                        else
                                            pozycja++;
                                    }

                                }catch (InterruptedException e){
                                    e.printStackTrace();
                                }
                            }
                        }
                ).start();

            }
        };
        bU.setOnClickListener(l1);
        bD.setOnClickListener(l1);
        bL.setOnClickListener(l1);
        bR.setOnClickListener(l1);



        /////////////////////////////////////////////
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void tworzeniePrzeszkod(){
        for(int i=1;i>=liczbaPrzeszkod;i++){

        }
    }

}



