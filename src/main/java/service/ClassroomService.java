package service;

import persistence.repository.IClassroomRepository;

import javax.inject.Inject;

public class ClassroomService implements IClassroomService {

    @Inject
    private IClassroomRepository classroomRepo;

    public String addClassroom(String account) {
        return classroomRepo.addClassroom(account);
    }

    public String retrieveClassroom(Long classroomId) {
        return classroomRepo.retrieveClassroom(classroomId);
    }

    public String updateClassroom(String classroom) {
        return classroomRepo.updateClassroom(classroom);
    }

    public String deleteClassroom(Long classroomId) {
        return classroomRepo.deleteClassroom(classroomId);
    }

    public String getClassrooms() {
        return classroomRepo.getClassrooms();
    }
}
