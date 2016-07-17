package br.ufs.dcomp.farms.model.service.map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import br.ufs.dcomp.farms.model.service.map.MappingService;
import junit.framework.TestCase;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:test-application-context.xml")
public class MappingServiceTest extends TestCase {

	@Autowired
	private MappingService mappingService;
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
	}
	
	@Test
	@Transactional
    @Rollback(true)
	public void testShowAllTablesNotMapped() throws NoSuchMethodException, SecurityException {
		
		mappingService.getAllTablesNotMapped();
	}
	
	@Test
	@Transactional
    @Rollback(true)
	public void testShowAllSequenceColumnsNotMapped() throws NoSuchMethodException, SecurityException {
		
		// Exibe sequences que não estão mapeadas.
		//List<SequenceDba> sequenceDbList = sequencesDao.getByNmSchema(SCHEMA_NAME);
	}
	
	@Test
	@Transactional
    @Rollback(true)
	public void testShowAllTableColumnsNotMapped() throws NoSuchMethodException, SecurityException {
		
		mappingService.getAllTableColumnsNotMapped();
	}
	
	@Test
	@Transactional
    @Rollback(true)
	public void testShowObjectsMappedWithoutMatchingDatabaseObject() throws NoSuchMethodException, SecurityException {
		
		mappingService.getAllObjectsMappedWithoutMatchingDatabaseObject();
	}
}