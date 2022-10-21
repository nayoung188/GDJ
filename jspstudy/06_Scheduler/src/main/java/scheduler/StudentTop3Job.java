package scheduler;

import java.util.List;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import domain.Student;
import repository.StudentDao;

public class StudentTop3Job implements Job {

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		
		// Job : 스케쥴러가 처리하는 작업
		
		List<Student> top3 = StudentDao.getInstance().selectStudentsTop3();
		
		for (Student s : top3) {
			System.out.println(s.getName() + "(" + s.getAve() + "점)");
		}
	}

}
