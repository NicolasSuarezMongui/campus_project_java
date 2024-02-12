package com.university.services.impl;

import java.util.List;

import com.university.exceptions.scheduleexceptions.ScheduleException;
import com.university.exceptions.scheduleexceptions.ScheduleNullException;
import com.university.repository.RepositorySchedule;
import com.university.repository.models.Schedule;
import com.university.services.ServiceSchedule;

public class ServiceScheduleImpl implements ServiceSchedule{

    private final RepositorySchedule crudRepositorySchedule;

    public ServiceScheduleImpl(RepositorySchedule crudRepositorySchedule) {
        this.crudRepositorySchedule = crudRepositorySchedule;
    }
    
    public List<Schedule> toList(){
        return crudRepositorySchedule.toList();
    }

    public Schedule findById(int schedule_id) throws ScheduleNullException{
        Schedule schedule = crudRepositorySchedule.findById(schedule_id);
        if(schedule == null){
            throw new ScheduleNullException("Schedule not found");
        } else {
            return schedule;
        }
    }

    public void create(Schedule schedule) {
        crudRepositorySchedule.create(schedule);
    }

    public void update(Schedule schedule) {
        
    }

    public List<Schedule> toListByStudentId(int student_id){
        return crudRepositorySchedule.toListByStudentId(student_id);
    }

    public List<Schedule> toListByTeacherId(int teacher_id){
        return crudRepositorySchedule.toListByTeacherId(teacher_id);
    }

    public List<Schedule> toListBySignatureId(int signature_id){
        return crudRepositorySchedule.toListBySignatureId(signature_id);
    }

    public List<Schedule> toListByClassroomId(int classroom_id){
        return crudRepositorySchedule.toListByClassroomId(classroom_id);
    }

    public List<Schedule> toListByDay(String day){
        return crudRepositorySchedule.toListByDay(day);
    }

}
