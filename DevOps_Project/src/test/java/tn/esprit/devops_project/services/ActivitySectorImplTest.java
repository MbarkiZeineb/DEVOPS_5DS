package tn.esprit.devops_project.services;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.core.annotation.Order;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;



import java.util.Optional;


import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.devops_project.entities.ActivitySector;
import tn.esprit.devops_project.repositories.ActivitySectorRepository;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
@ExtendWith(MockitoExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ActivitySectorImplTest {

    @InjectMocks
    ActivitySectorImpl activitySectorimp;
    @Mock
    ActivitySectorRepository activitySectorRepository;

    @Test
    @Order(1)
    void retrieveAllActivitySectors() {

        ActivitySector activitySector = new ActivitySector(1L, "123mock", "mock");

        // Mock the behavior of activitySectorRepository.findById
        Mockito.when(activitySectorRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(activitySector));

        // Call the method you want to test
        ActivitySector activity = activitySectorimp.retrieveActivitySector(1L);
        Assertions.assertNotNull(activity);


    }

    @Test
    void deleteActivitySector() {

        doNothing().when(activitySectorRepository).deleteById((Long) any());
        activitySectorimp.deleteActivitySector(1L);
        verify(activitySectorRepository).deleteById((Long) any());
    }


  /*  @Test
    void addActivitySector() {
    }

    @Test
    void deleteActivitySector() {

    doNothing().when(productRepository).deleteById((Long) any());
        productServiceImpl.deleteProduct(2L);
        verify(productRepository).deleteById((Long) any());
    }

    @Test
    void updateActivitySector() {
    }

    @Test
    void retrieveActivitySector() {
    }*/
}