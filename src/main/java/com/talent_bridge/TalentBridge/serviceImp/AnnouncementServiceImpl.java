package com.talent_bridge.TalentBridge.serviceImp;
import com.talent_bridge.TalentBridge.DTO.AnnouncementDTO;
import com.talent_bridge.TalentBridge.entity.Announcement;
import com.talent_bridge.TalentBridge.mapper.AnnouncementMapper;
import com.talent_bridge.TalentBridge.repository.AnnouncementRepository;
import com.talent_bridge.TalentBridge.service.AnnouncementService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AnnouncementServiceImpl implements AnnouncementService {

    private final AnnouncementRepository announcementRepository;
    private final AnnouncementMapper announcementMapper;

    public AnnouncementServiceImpl(AnnouncementRepository announcementRepository, AnnouncementMapper announcementMapper) {
        this.announcementRepository = announcementRepository;
        this.announcementMapper = announcementMapper;
    }

    @Override
    public List<AnnouncementDTO> getAllAnnouncements() {
        List<Announcement> announcements = announcementRepository.findAll();
        return announcementMapper.toDTOs(announcements);
    }

    @Override
    public AnnouncementDTO getAnnouncementById(Long id) {
        Announcement announcement = announcementRepository.findById(id).orElseThrow();
        return announcementMapper.toDTO(announcement);
    }

    @Override
    public AnnouncementDTO createAnnouncement(AnnouncementDTO announcementDTO) {
        announcementDTO.setDateAndTime(LocalDateTime.now());
        Announcement announcement = announcementMapper.toEntity(announcementDTO);
        Announcement savedAnnouncement = announcementRepository.save(announcement);
        return announcementMapper.toDTO(savedAnnouncement);
    }

    @Override
    public AnnouncementDTO updateAnnouncement(AnnouncementDTO announcementDTO, Long id) {
        Announcement existingAnnouncement = announcementRepository.findById(id).orElseThrow();
        existingAnnouncement.setSubject(announcementDTO.getSubject());
        existingAnnouncement.setContext(announcementDTO.getContext());
        existingAnnouncement.setDateAndTime(LocalDateTime.now());
        Announcement updatedAnnouncement = announcementRepository.save(existingAnnouncement);
        return announcementMapper.toDTO(updatedAnnouncement);
    }

    @Override
    public void deleteAnnouncement(Long id) {
        announcementRepository.deleteById(id);
    }
}
