package viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;


import java.util.List;

import modele.outputDataModel.TrainingOutput;
import repository.TrainingRepository;


public class GraphicalModelView extends ViewModel  {

    private TrainingRepository trainingRepository = new TrainingRepository();
    private LiveData<List<TrainingOutput>> trainingLiveData;
    public LiveData<List<TrainingOutput>>getTrainingLiveData(){
        return trainingLiveData=trainingRepository.getTrainingByuserId(1);
    }
}
