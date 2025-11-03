package com.talent_bridge.TalentBridge.serviceImp;
import com.talent_bridge.TalentBridge.DTO.JobDTO;
import com.talent_bridge.TalentBridge.entity.Job;
import com.talent_bridge.TalentBridge.mapper.JobMapper;
import com.talent_bridge.TalentBridge.repository.JobRepository;
import com.talent_bridge.TalentBridge.service.JobService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class JobServiceImp implements JobService {
    private final JobRepository jobRepository;
    public JobServiceImp(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }
    @Override
    public JobDTO createJob(JobDTO jobDTO) {
        Job job = JobMapper.toEntity(jobDTO);
        Job saved = jobRepository.save(job);
        return JobMapper.toDTO(saved);
    }

    @Override
    public JobDTO getJobById(Long id) {
        return jobRepository.findById(id)
                .map(JobMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Job not found with id " + id));
    }

    @Override
    public List<JobDTO> getAllJobs() {
        return jobRepository.findAll().stream()
                .map(JobMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<JobDTO> getJobsByUserId(Long userId) {
        return jobRepository.findByUserId(userId).stream()
                .map(JobMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public JobDTO updateJob(Long id, JobDTO jobDTO) {
        Job existing = jobRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Job not found with id " + id));
        existing.setTitle(jobDTO.getTitle());
        existing.setCompany(jobDTO.getCompany());
        existing.setLocation(jobDTO.getLocation());
        existing.setType(jobDTO.getType());
        existing.setSalary(jobDTO.getSalary());
        existing.setDescription(jobDTO.getDescription());
        existing.setUserId(jobDTO.getUserId());
        Job updated = jobRepository.save(existing);

        existing.setApprove(jobDTO.isApprove());
        existing.setStatus(jobDTO.getStatus());

        return JobMapper.toDTO(updated);
    }
    @Override
    public void deleteJob(Long id) {
        jobRepository.deleteById(id);
    }

    @Override
    public JobDTO changeApprovalStatus(Long id, boolean approve, String status) {
        Job job = jobRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Job not found with id " + id));
        job.setApprove(approve);
        job.setStatus(status);
        Job updated = jobRepository.save(job);
        return JobMapper.toDTO(updated);
    }
}
