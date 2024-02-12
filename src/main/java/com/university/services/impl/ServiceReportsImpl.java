package com.university.services.impl;

import java.util.List;

import com.university.repository.impl.implregister.RepositoryRegisterMysqlImpl;
import com.university.repository.impl.implsignature.RepositorySignatureMysqlImpl;
import com.university.repository.impl.implstudent.RepositoryStudentMysqlImpl;
import com.university.repository.impl.impltuition.RepositoryTuitionMysqlImpl;
import com.university.repository.models.Register;
import com.university.repository.models.Student;
import com.university.services.ServiceRegister;
import com.university.services.ServiceSignature;
import com.university.services.ServiceStudent;
import com.university.services.ServiceTuition;

public class ServiceReportsImpl {
    private final ServiceRegister serviceRegister = new ServiceRegisterImpl(new RepositoryRegisterMysqlImpl());
    private final ServiceSignature serviceSignature = new ServiceSignatureImpl(new RepositorySignatureMysqlImpl());
    private final ServiceStudent serviceStudent = new ServiceStudentImpl(new RepositoryStudentMysqlImpl());
    private final ServiceTuition serviceTuition = new ServiceTuitionImpl(new RepositoryTuitionMysqlImpl());

    public double semesterCost(int student_id, int period_id) {
        double cost = 0.0;
        try {
            Student student = serviceStudent.findById(student_id);
            List<Register> listRegisters = serviceRegister.listByStudentId(student.getId());
            for (Register register : listRegisters) {
                cost += (serviceSignature.findById(register.getSignatureId()).getCredits()) * (serviceTuition.findByPeriodIdAndProgram(period_id, student.getProgramId()).getCreditValue());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cost;
    }


}
