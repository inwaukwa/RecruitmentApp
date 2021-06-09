package cogent.recruitment.service;
import cogent.recruitment.dao.InterviewDao;
import cogent.recruitment.entities.Interview;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class InterviewService {

    @Autowired
    InterviewDao interviewDao;

    /**
     * post a interview to the database
     * @param interview object that is passed from front-end
     */
    @Transactional
    public void scheduleInterview(Interview interview) {
        interviewDao.save(interview);
    }

    /**
     * get all interviews by the applicant id
     * @param id
     * @return
     */
    @Transactional
    public List<Interview> getAllInterviewsByApplicant(int id) {
        List<Interview> interviewList = interviewDao.findAllByApplicationApplicantId(id);
        return interviewList;
    }

    /**
     * get all completed interviews by applicant id
     * @param id
     * @return
     */
    @Transactional
    public List<Interview> getCompletedInterviewsByApplicant(int id) {
        List<Interview> interviewList = interviewDao.findAllByApplicationApplicantIdAndEndTimeBefore(id,LocalDateTime.now());
        return interviewList;
    }

    /**
     * get all incoming interviews by applicant id
     * @param id
     * @return
     */
    @Transactional
    public List<Interview> getIncomingInterviewByApplicant(int id) {
        List<Interview> interviewList = interviewDao.findAllByApplicationApplicantIdAndStartTimeAfter(id, LocalDateTime.now());
        return interviewList;
    }

    /**
     * delete interview by interview id
     * @param id
     */
    @Transactional
    public void deleteInterviewById(int id) {
        interviewDao.deleteById(id);
    }

    /**
     * update hte interview start time and end time
     * @param id
     * @param newStart
     * @param newEnd
     */
    @Transactional
    public void updateInterview(int id, LocalDateTime newStart, LocalDateTime newEnd){
        interviewDao.updateInterviewById(newStart,newEnd,id);
    }

}
