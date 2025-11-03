package com.talent_bridge.TalentBridge.mapper;
import com.talent_bridge.TalentBridge.DTO.AnnouncementDTO;
import com.talent_bridge.TalentBridge.entity.Announcement;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AnnouncementMapper {
    public AnnouncementDTO toDTO(Announcement announcement) {
        return new AnnouncementDTO(
                announcement.getId(),
                announcement.getSubject(),
                announcement.getContext(),
                announcement.getDateAndTime()
        );
    }

    public List<AnnouncementDTO> toDTOs(List<Announcement> announcements) {
        return announcements.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public Announcement toEntity(AnnouncementDTO announcementDTO) {
        Announcement announcement = new Announcement();
        announcement.setId(announcementDTO.getId());
        announcement.setSubject(announcementDTO.getSubject());
        announcement.setContext(announcementDTO.getContext());
        announcement.setDateAndTime(announcementDTO.getDateAndTime());
        return announcement;
    }

}
