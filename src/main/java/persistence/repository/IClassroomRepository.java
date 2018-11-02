package persistence.repository;

public interface IClassroomRepository {
    String addClassroom(String classroom);

    String updateClassroom(String classroom);

    String retrieveClassroom(Long id);

    String deleteClassroom(Long id);

    String getClassrooms();
}
