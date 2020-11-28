package viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;


import java.util.List;

import model.Training;
import repository.TrainingRepository;


public class GraphicalModelView extends ViewModel  {

    private TrainingRepository trainingRepository = new TrainingRepository();
    private LiveData<List<Training>> trainingLiveData;
    public LiveData<List<Training>>getTrainingLiveData(){
        return trainingLiveData=trainingRepository.getTrainingByuserId(1);
    }
}
