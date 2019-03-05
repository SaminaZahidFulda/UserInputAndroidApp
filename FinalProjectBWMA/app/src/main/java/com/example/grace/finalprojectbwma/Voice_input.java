package com.example.grace.finalprojectbwma;


import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.speech.tts.TextToSpeech;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.format.DateUtils;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.Date;
import java.util.List;
import java.util.Locale;

public class Voice_input extends AppCompatActivity {
    private TextToSpeech tts;
    private SpeechRecognizer speechRecognizer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.voice_layout);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                        RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
                intent.putExtra(RecognizerIntent.EXTRA_MAX_RESULTS, 1);
                speechRecognizer.startListening(intent);
            }
        });

        initializeTextToSpeech();
        initializeSpeechRecognizer();

    }

    private void initializeSpeechRecognizer() {
        if(SpeechRecognizer.isRecognitionAvailable(this)){
            speechRecognizer = SpeechRecognizer.createSpeechRecognizer(this);
            speechRecognizer.setRecognitionListener(new RecognitionListener() {
                @Override
                public void onReadyForSpeech(Bundle params) {

                }

                @Override
                public void onBeginningOfSpeech() {

                }

                @Override
                public void onRmsChanged(float rmsdB) {

                }

                @Override
                public void onBufferReceived(byte[] buffer) {

                }

                @Override
                public void onEndOfSpeech() {

                }

                @Override
                public void onError(int error) {

                }

                @Override
                public void onResults(Bundle bundle) {
                    List<String> results = bundle.getStringArrayList(
                            SpeechRecognizer.RESULTS_RECOGNITION
                    );
                    processResult(results.get(0));
                }

                @Override
                public void onPartialResults(Bundle partialResults) {

                }

                @Override
                public void onEvent(int eventType, Bundle params) {

                }
            });
        }


    }

    private void processResult(String command) {
        command = command.toLowerCase();
        //what is your name
        // what is the time
        //open the browser
        if(command.indexOf("what") != -1){
            if(command.indexOf("your name") != -1){
                speak("My name is Samina.");
            }
            if(command.indexOf("time") != -1){
                Date now = new Date();
                String time = DateUtils.formatDateTime(this,now.getTime(),DateUtils.FORMAT_SHOW_TIME);
                speak("The time is "+time);
            }
        }
        else if(command.indexOf("open") != -1){
            if(command.indexOf("browser") != -1){
                Intent intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://www.google.com/"));
                startActivity(intent);
            }

        }

    }

    private void initializeTextToSpeech() {
        tts = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(tts.getEngines().size()==0){
                    Toast.makeText(Voice_input.this,"There is no Text to Speech Engine on your phone",
                            Toast.LENGTH_LONG).show();
                    finish();
                }
                else
                {
                    tts.setLanguage(Locale.US);
                    speak("Hello I am ready");
                }
            }
        });
    }

    private void speak(String message) {
        if(Build.VERSION.SDK_INT >= 21){
            tts.speak(message,TextToSpeech.QUEUE_FLUSH,null,null);
        }
        else{
            tts.speak(message,TextToSpeech.QUEUE_FLUSH,null);

        }
    }


    @Override
    protected void onPause() {
        super.onPause();
        tts.shutdown();
    }

}
