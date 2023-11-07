package tn.esprit.devops_project.services;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.devops_project.entities.ActivitySector;
import tn.esprit.devops_project.repositories.ActivitySectorRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Slf4j
class ActivitySectorImplTestjuint {

    @Autowired
    ActivitySectorImpl activitySectorimp;
    @Autowired
    ActivitySectorRepository activitySectorRepository;

    @Test
    void addActivitySector() {
        log.info("***Test ajouter employe ***");
        ActivitySector act = new ActivitySector(2L,"test1","test");
        act= activitySectorRepository.save(act);
        assertTrue(activitySectorRepository.findById(act.getIdSecteurActivite()).isPresent());

    }

    @Test
    void retrieveAllActivitySectors() {

        ActivitySector act = new ActivitySector(8L, "test2","test1");
        ActivitySector act1 = new ActivitySector(5L, "test2","test1");



        activitySectorimp.addActivitySector(act1);
        activitySectorimp.addActivitySector(act);



        List<ActivitySector> result = activitySectorimp.retrieveAllActivitySectors();
        assertNotNull(result);
        assertFalse(result.isEmpty());

    }

    @Test
    void updateActivitySector() {
        ActivitySector act = new ActivitySector(8L, "test2","test1");
       activitySectorRepository.save(act);
        String newlibelle="test@gmail.com";
        ActivitySector act1 = activitySectorRepository.findById(act.getIdSecteurActivite()).orElseThrow(() -> new NullPointerException("act not found"));
        act1.setLibelleSecteurActivite(newlibelle);
        activitySectorRepository.save(act1);
        assertEquals(true, act1.getLibelleSecteurActivite().equals(newlibelle));
    }
}