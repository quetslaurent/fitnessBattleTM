package modele.inputDataModel;

public class TrainingInput {

   private int id;
    private double repetitions;
    private int UserId;
    private int ActivityId;
    private int TrainingDateId;

    public TrainingInput(double repetitions, int UserId, int ActivityId, int TrainingDateId) {
        this.repetitions = repetitions;
        this.UserId = UserId;
        this.ActivityId = ActivityId;
        this.TrainingDateId = TrainingDateId;
    }


    @Override
    public String toString() {
        return "Training{" +
                "id=" + id +
                ", repetitions=" + repetitions +
                ", UserId=" + UserId +
                ", ActivityId=" + ActivityId +
                ", TrainingDateId=" + TrainingDateId +
                '}';
    }
}
