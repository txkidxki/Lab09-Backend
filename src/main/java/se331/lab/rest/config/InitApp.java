package se331.lab.rest.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import se331.lab.rest.entity.Event;
import se331.lab.rest.entity.Organizer;
import se331.lab.rest.entity.Participant;
import se331.lab.rest.repository.EventRepository;
import se331.lab.rest.repository.OrganizerRepository;
import se331.lab.rest.repository.PaticipantRepository;

import javax.transaction.Transactional;

@Component
public class InitApp implements ApplicationListener<ApplicationReadyEvent> {
    @Autowired
    EventRepository eventRepository;

    @Autowired
    OrganizerRepository organizerRepository;

    @Autowired
    PaticipantRepository paticipantRepository;

    @Override
    @Transactional
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        Organizer org1,org2,org3;
        org1 = organizerRepository.save(Organizer.builder()
                .name("CAMT").build());
        org2 = organizerRepository.save(Organizer.builder()
                .name("CMU").build());
        org3 = organizerRepository.save(Organizer.builder()
                .name("ChiangMai").build());
        Event tempEvent;

        Participant p1,p2,p3,p4,p5;
        p1 = paticipantRepository.save(Participant.builder()
                .name("Childe").telNo("555").build());
        p2 = paticipantRepository.save(Participant.builder()
                .name("Zhongli").telNo("888").build());
        p3 = paticipantRepository.save(Participant.builder()
                .name("Hutao").telNo("666").build());
        p4 = paticipantRepository.save(Participant.builder()
                .name("Raiden").telNo("999").build());
        p5 = paticipantRepository.save(Participant.builder()
                .name("Lisa").telNo("969").build());

        tempEvent = eventRepository.save(Event.builder()
                .category("Academic")
                .title("Midterm Exam")
                .description("A time for taking the exam")
                .location("CAMT Building")
                .date("3rd Sept")
                .time("3.00-4.00 pm.")
                .petAllowed(false)
                .build());

        tempEvent.setOrganizer(org1);
        org1.getOwnEvents().add(tempEvent);

        tempEvent.getParticipants().add(p1);
        p1.getEventHistory().add(tempEvent);
        tempEvent.getParticipants().add(p2);
        p2.getEventHistory().add(tempEvent);
        tempEvent.getParticipants().add(p3);
        p3.getEventHistory().add(tempEvent);

        tempEvent = eventRepository.save(Event.builder()
                .category("Academic")
                .title("Commencement Day")
                .description("A time for celebration")
                .location("CMU Convention hall")
                .date("21th Jan")
                .time("8.00am-4.00 pm.")
                .petAllowed(false)
                .build());

        tempEvent.setOrganizer(org1);
        org1.getOwnEvents().add(tempEvent);

        tempEvent.getParticipants().add(p2);
        p2.getEventHistory().add(tempEvent);
        tempEvent.getParticipants().add(p3);
        p3.getEventHistory().add(tempEvent);
        tempEvent.getParticipants().add(p4);
        p4.getEventHistory().add(tempEvent);

        tempEvent = eventRepository.save(Event.builder()
                .category("Cultural")
                .title("Loy Krathong")
                .description("A time for Krathong")
                .location("Ping River")
                .date("21th Nov")
                .time("8.00-10.00 pm.")
                .petAllowed(false)
                .build());

        tempEvent.setOrganizer(org2);
        org2.getOwnEvents().add(tempEvent);

        tempEvent.getParticipants().add(p3);
        p3.getEventHistory().add(tempEvent);
        tempEvent.getParticipants().add(p4);
        p4.getEventHistory().add(tempEvent);
        tempEvent.getParticipants().add(p5);
        p5.getEventHistory().add(tempEvent);

        tempEvent = eventRepository.save(Event.builder()
                .category("Cultural")
                .title("Songkran")
                .description("Let's Play Water")
                .location("Chiang Mai Moat")
                .date("13th April")
                .time("10.00am - 6.00 pm.")
                .petAllowed(true)
                .build());
        tempEvent.setOrganizer(org3);
        org3.getOwnEvents().add(tempEvent);

        tempEvent.getParticipants().add(p1);
        p1.getEventHistory().add(tempEvent);
        tempEvent.getParticipants().add(p2);
        p2.getEventHistory().add(tempEvent);
        tempEvent.getParticipants().add(p3);
        p3.getEventHistory().add(tempEvent);
    }
}
