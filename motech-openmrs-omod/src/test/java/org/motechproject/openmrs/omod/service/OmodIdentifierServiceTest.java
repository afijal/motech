package org.motechproject.openmrs.omod.service;

import org.apache.poi.ss.usermodel.DateUtil;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.openmrs.PatientIdentifierType;
import org.openmrs.api.PatientService;
import org.openmrs.api.context.Context;
import org.openmrs.module.idgen.IdentifierSource;
import org.openmrs.module.idgen.SequentialIdentifierGenerator;
import org.openmrs.module.idgen.service.IdentifierSourceService;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.ArrayList;

import static org.hamcrest.JMock1Matchers.equalTo;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;
import static org.powermock.api.mockito.PowerMockito.mock;
import static org.powermock.api.mockito.PowerMockito.mockStatic;

@RunWith(PowerMockRunner.class)
@PrepareForTest(Context.class)
public class OmodIdentifierServiceTest {
    private OmodIdentifierService omodIdentifierService;

    @Mock
    private IdentifierSourceService identifierSourceService;
    @Mock
    private PatientService patientService;


    @Before
    public void setUp() {
        initMocks(this);
        mockStatic(Context.class);
        omodIdentifierService = new OmodIdentifierService();
        ReflectionTestUtils.setField(omodIdentifierService, "idSourceService", identifierSourceService);
        ReflectionTestUtils.setField(omodIdentifierService, "patientService", patientService);
    }

    @Test
    public void shouldGetIdFromGivenIdentifierGenerator() {
        final String generatorName = "MoTeCH Staff ID Generator";
        final String patientIdTypeName = "MoTeCH Staff Id";
        final String expectedId = "12345";
        IdentifierSource mockSequentiamIdentifierGenerator = mock(SequentialIdentifierGenerator.class);
        PatientIdentifierType patientIdentifierType = new PatientIdentifierType();
        ArrayList<IdentifierSource> idSources = new ArrayList<IdentifierSource>();
        idSources.add(mockSequentiamIdentifierGenerator);

        when(mockSequentiamIdentifierGenerator.getName()).thenReturn(generatorName);
        when(mockSequentiamIdentifierGenerator.getIdentifierType()).thenReturn(patientIdentifierType);

        when(patientService.getPatientIdentifierTypeByName(patientIdTypeName)).thenReturn(patientIdentifierType);
        when(identifierSourceService.getAllIdentifierSources(false)).thenReturn(idSources);
        when(identifierSourceService.generateIdentifier(mockSequentiamIdentifierGenerator, "AUTO GENERATED")).thenReturn(expectedId);

        String idGenerated = omodIdentifierService.getIdFor(generatorName, patientIdTypeName);

        assertEquals(expectedId, idGenerated);
    }

}
