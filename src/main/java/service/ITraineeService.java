package service;

public interface ITraineeService {

    String addTrainee(String trainee);

    String retrieveTrainee(Long traineeId);

    String updateTrainee(String trainee);

    String deleteTrainee(Long traineeId);

    String getTrainees();

}
