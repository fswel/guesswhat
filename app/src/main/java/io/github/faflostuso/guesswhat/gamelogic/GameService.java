package io.github.faflostuso.guesswhat.gamelogic;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;

public class GameService extends Service {
    public static final String GAMEMODE = "gamemode";
    public static final byte GAMEMODE_1 = 0;
    public static final byte GAMEMODE_2 = 1;
    private int pointsForCorrectAnswer;
    private int pointsForDeceiving;
    private ArrayList<Question> unusedQuestion; //TODO als Set!
    private ArrayList<Player> players;
    private boolean gameActive;
    private byte gamemode;

    @Override
    public void onCreate() {
        pointsForCorrectAnswer = 3; //TODO aus Einstellungen richtigen Wert auslesen
        pointsForDeceiving = 3;

        //TODO aus XML auslesen (in anderem Thread!)
        String[] antworten = {
                "offensichtlich richtige Antowrt",
                "sehr schwere Antowrt",
                "Antwort 3",
                "hier muss man schon ganz schön gut sein"
        };
        String[] fragen = {
                "Was ist die offensichtlich richtige Antwort?",
                "Welche Antwort ist die schwerste?",
                "Antwort 3?",
                "Was ist die richtige Antwort?"
        };
        for (int i = 0; i < fragen.length; i++)
            addQuestion(new Question(fragen[i], new Answer(antworten[i])));
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId){
        if (!gameActive){
             this.gamemode = intent.getByteExtra(GAMEMODE, (byte) 0 );
        }

        //runs as long as it is not explicitly stopped
        return Service.START_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public void addPlayer(){
        //TODO nur hinzufügen wenn Spiel noch nicht begonnen
    }

    public void startGame(){

    }

    public ArrayList<Player> getPlayers(){
        //TODO implement
        return null;
    }

    public boolean isGameActive(){
        return this.isGameActive();
    }

    private void addQuestion(Question question){
        //TODO exception werfen, wenn Frage schon vorhanden
        unusedQuestion.add(question);
    }

}
