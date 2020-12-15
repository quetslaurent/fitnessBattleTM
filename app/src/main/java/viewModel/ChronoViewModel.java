package viewModel;

import android.os.Handler;

import androidx.lifecycle.ViewModel;

import model.Chrono;


/**
 * VIEW MODEL , elle va instancier l'objet ici
 * et appeler ses méthodes
 */
public class ChronoViewModel extends ViewModel {

    private Handler handler = new Handler();
    private Chrono chrono = new Chrono();
    public Handler getHandler() {
        return handler;
    }

    public void start(){
        chrono.start();
    }

    public void stop(){
        chrono.stop();
    }
    public void addtime(){
        chrono.addtime();
    }
    public void run(){
        chrono.run();
    }


    public long getMin() {
        return chrono.getMin();
    }

    public long getSec() {
        return chrono.getSec();
   }
    public long getMilliSec() {
        return chrono.getMilliSec();
    }

}