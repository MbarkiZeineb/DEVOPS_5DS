package tn.esprit.devops_project.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import tn.esprit.devops_project.entities.Invoice;
import tn.esprit.devops_project.repositories.InvoiceDetailRepository;
import tn.esprit.devops_project.repositories.InvoiceRepository;
import tn.esprit.devops_project.repositories.OperatorRepository;
import tn.esprit.devops_project.repositories.SupplierRepository;
import tn.esprit.devops_project.services.InvoiceServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

    class InvoiceServiceImplTest {

    @Mock
    private InvoiceRepository invoiceRepository;

    @Mock
    private OperatorRepository operatorRepository;

    @Mock
    private InvoiceDetailRepository invoiceDetailRepository;

    @Mock
    private SupplierRepository supplierRepository;

    @InjectMocks
    private InvoiceServiceImpl invoiceService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testRetrieveAllInvoices() {
        // Arrange
        List<Invoice> invoices = new ArrayList<>();
        invoices.add(new Invoice());
        invoices.add(new Invoice());

        when(invoiceRepository.findAll()).thenReturn(invoices);

        // Act
        List<Invoice> result = invoiceService.retrieveAllInvoices();

        // Assert
        assertEquals(invoices.size(), result.size());
        verify(invoiceRepository, times(1)).findAll();
    }

    @Test
    void testCancelInvoice() {
        // Arrange
        Long invoiceId = 1L;
        Invoice invoice = new Invoice();
        invoice.setIdInvoice(invoiceId);

        when(invoiceRepository.findById(invoiceId)).thenReturn(Optional.of(invoice));

        // Act
        invoiceService.cancelInvoice(invoiceId);

        // Assert
        assertEquals(true, invoice.getArchived());
        verify(invoiceRepository, times(1)).save(invoice);
    }

    @Test
    void testRetrieveInvoice() {
        // Arrange
        Long invoiceId = 1L;
        Invoice invoice = new Invoice();
        invoice.setIdInvoice(invoiceId);

        when(invoiceRepository.findById(invoiceId)).thenReturn(Optional.of(invoice));

        // Act
        Invoice result = invoiceService.retrieveInvoice(invoiceId);

        // Assert
        assertEquals(invoiceId, result.getIdInvoice());
        verify(invoiceRepository, times(1)).findById(invoiceId);
    }

    // Add more test methods for other methods in the InvoiceServiceImpl class
}