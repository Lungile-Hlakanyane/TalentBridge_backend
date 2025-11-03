package com.talent_bridge.TalentBridge.service;

import com.talent_bridge.TalentBridge.DTO.AnnouncementDTO;

import java.util.List;

public interface AnnouncementService {
    List<AnnouncementDTO> getAllAnnouncements();
    AnnouncementDTO getAnnouncementById(Long id);
    AnnouncementDTO createAnnouncement(AnnouncementDTO announcementDTO);
    AnnouncementDTO updateAnnouncement(AnnouncementDTO announcementDTO, Long id);
    void deleteAnnouncement(Long id);
}
