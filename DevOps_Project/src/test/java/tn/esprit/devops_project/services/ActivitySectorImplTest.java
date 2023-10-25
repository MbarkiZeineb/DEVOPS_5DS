package tn.esprit.devops_project.services;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;



import java.util.Optional;


import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.devops_project.entities.ActivitySector;
import tn.esprit.devops_project.repositories.ActivitySectorRepository;


@RunWith(MockitoJUnitRunner.class)
@ExtendWith(MockitoExtension.class)
class ActivitySectorImplTest {

    @InjectMocks
    ActivitySectorImpl activitySectorimp;
    @Mock
    ActivitySectorRepository activitySectorRepository;

    @Test
    void retrieveAllActivitySectors() {

        ActivitySector activitySector = new ActivitySector(1L, "123mock", "mock");

        // Mock the behavior of activitySectorRepository.findById
        Mockito.when(activitySectorRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(activitySector));

        // Call the method you want to test
        ActivitySector activity = activitySectorimp.retrieveActivitySector(1L);
        Assertions.assertNull(activity);


    }

  /*  @Test
    void addActivitySector() {
    }

    @Test
    void deleteActivitySector() {
    }

    @Test
    void updateActivitySector() {
    }

    @Test
    void retrieveActivitySector() {
    }*/
}