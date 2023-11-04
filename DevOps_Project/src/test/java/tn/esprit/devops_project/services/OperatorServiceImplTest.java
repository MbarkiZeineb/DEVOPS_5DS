package tn.esprit.devops_project.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import tn.esprit.devops_project.entities.Operator;
import tn.esprit.devops_project.repositories.OperatorRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

    class OperatorServiceImplTest {

    @Mock
    private OperatorRepository operatorRepository;

    @InjectMocks
    private OperatorServiceImpl operatorService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testRetrieveAllOperators() {
        // Arrange
        Operator operator1 = new Operator();
        operator1.setIdOperateur(1L);
        Operator operator2 = new Operator();
        operator2.setIdOperateur(2L);
        List<Operator> operators = Arrays.asList(operator1, operator2);

        when(operatorRepository.findAll()).thenReturn(operators);

        // Act
        List<Operator> result = operatorService.retrieveAllOperators();

        // Assert
        assertEquals(2, result.size());
        assertEquals(operator1, result.get(0));
        assertEquals(operator2, result.get(1));
        verify(operatorRepository, times(1)).findAll();
    }

    @Test
    void testAddOperator() {
        // Arrange
        Operator operator = new Operator();
        operator.setIdOperateur(1L);

        when(operatorRepository.save(operator)).thenReturn(operator);

        // Act
        Operator result = operatorService.addOperator(operator);

        // Assert
        assertEquals(operator, result);
        verify(operatorRepository, times(1)).save(operator);
    }

    @Test
    void testDeleteOperator() {
        // Arrange
        Long id = 1L;

        // Act
        operatorService.deleteOperator(id);

        // Assert
        verify(operatorRepository, times(1)).deleteById(id);
    }

    @Test
    void testUpdateOperator() {
        // Arrange
        Operator operator = new Operator();
        operator.setIdOperateur(1L);

        when(operatorRepository.save(operator)).thenReturn(operator);

        // Act
        Operator result = operatorService.updateOperator(operator);

        // Assert
        assertEquals(operator, result);
        verify(operatorRepository, times(1)).save(operator);
    }

    @Test
    void testRetrieveOperator() {
        // Arrange
        Long id = 1L;
        Operator operator = new Operator();
        operator.setIdOperateur(id);

        when(operatorRepository.findById(id)).thenReturn(Optional.of(operator));

        // Act
        Operator result = operatorService.retrieveOperator(id);

        // Assert
        assertEquals(operator, result);
        verify(operatorRepository, times(1)).findById(id);
    }
}