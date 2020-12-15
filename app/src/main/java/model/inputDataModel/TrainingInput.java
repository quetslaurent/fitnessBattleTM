package model.inputDataModel;



/**
 * Ca sera la classe qui sera envoyé au serveur lorsqu'un Training sera creer.
 *
 * repetitions = le nombre de rep que l'user a fait
 * userId = l'id de l'user
 * ActivityId = l'id de l'activty que l'user a fait
 * TrainingDateId = l'id de la date
 *
 */
public class TrainingInput {

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
                ", repetitions=" + repetitions +
                ", UserId=" + UserId +
                ", ActivityId=" + ActivityId +
                ", TrainingDateId=" + TrainingDateId +
                '}';
    }
}
