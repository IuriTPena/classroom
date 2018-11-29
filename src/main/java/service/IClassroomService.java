package service;

public interface IClassroomService {

    String addClassroom(String classroom);

    String retrieveClassroom(Long classroomId);

    String updateClassroom(String classroom);

    String deleteClassroom(Long classroomId);

    String getClassrooms();

}
