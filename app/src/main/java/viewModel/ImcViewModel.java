package viewModel;

import androidx.lifecycle.ViewModel;

import model.IMC;

public class ImcViewModel extends ViewModel {

    private IMC imc = new IMC();

    public String calculerImc(float pValue,float tValue){
        return  imc.valeurImc(pValue,tValue);
    }
}
