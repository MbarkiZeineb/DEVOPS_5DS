import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import tn.esprit.devops_project.entities.Supplier;
import tn.esprit.devops_project.repositories.SupplierRepository;
import tn.esprit.devops_project.services.SupplierServiceImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

class TestSupplier {

    @Mock
    private SupplierRepository supplierRepository;

    @InjectMocks
    private SupplierServiceImpl supplierService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testRetrieveAllSuppliers() {
        List<Supplier> suppliers = new ArrayList<>();
        suppliers.add(new Supplier());
        suppliers.add(new Supplier());
        when(supplierRepository.findAll()).thenReturn(suppliers);

        List<Supplier> result = supplierService.retrieveAllSuppliers();

        Assertions.assertEquals(2, result.size());
        verify(supplierRepository, times(1)).findAll();
    }

    @Test
    void testAddSupplier() {
        Supplier supplier = new Supplier();
        when(supplierRepository.save(supplier)).thenReturn(supplier);

        Supplier result = supplierService.addSupplier(supplier);

        Assertions.assertEquals(supplier, result);
        verify(supplierRepository, times(1)).save(supplier);
    }

    @Test
    void testUpdateSupplier() {
        Supplier supplier = new Supplier();
        when(supplierRepository.save(supplier)).thenReturn(supplier);

        Supplier result = supplierService.updateSupplier(supplier);

        Assertions.assertEquals(supplier, result);
        verify(supplierRepository, times(1)).save(supplier);
    }

    @Test
    void testDeleteSupplier() {
        Long supplierId = 1L;

        supplierService.deleteSupplier(supplierId);

        verify(supplierRepository, times(1)).deleteById(supplierId);
    }

    @Test
    void testRetrieveSupplier() {
        Long supplierId = 1L;
        Supplier supplier = new Supplier();
        when(supplierRepository.findById(supplierId)).thenReturn(Optional.of(supplier));

        Supplier result = supplierService.retrieveSupplier(supplierId);

        Assertions.assertEquals(supplier, result);
        verify(supplierRepository, times(1)).findById(supplierId);
    }
}