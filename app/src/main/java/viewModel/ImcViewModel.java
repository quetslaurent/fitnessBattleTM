package viewModel;

import androidx.lifecycle.ViewModel;

import model.IMC;
/**
 * VIEW MODEL , elle va instancier l'objet ici
 * et appeler ses méthodes
 */
public class ImcViewModel extends ViewModel {

    private IMC imc = new IMC();

    public String calculerImc(float pValue,float tValue){
        return  imc.valeurImc(pValue,tValue);
    }
}
