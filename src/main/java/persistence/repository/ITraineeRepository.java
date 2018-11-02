package persistence.repository;

public interface ITraineeRepository {
    String addTrainee(String trainee);

    String updateTrainee(String trainee);

    String retrieveTrainee(Long id);

    String deleteTrainee(Long id);

    String getTrainees();
}
