package tn.esprit.devops_project.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.devops_project.entities.ActivitySector;
import tn.esprit.devops_project.repositories.ActivitySectorRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@SpringBootTest
@ExtendWith(MockitoExtension.class)
class ActivitySectorImplTest {
    @InjectMocks
    ActivitySectorImpl activitySectorimp;
    @Mock
    ActivitySectorRepository activitySectorRepository;

    List<ActivitySector> activitySectorList = new ArrayList<ActivitySector>() {
        {
        add( new ActivitySector(1L,"123mock","mock") );
        add( new ActivitySector(250L,"456","libelletest1") );

    }};


    ActivitySector activitySector = new ActivitySector(1L,"123mock", "mock");



    @Test
    void retrieveAllActivitySectors() {

        Mockito.when(activitySectorRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(activitySector));

        ActivitySector activiy = activitySectorimp.retrieveActivitySector(4L);

        Assertions.assertNotNull(activiy);
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