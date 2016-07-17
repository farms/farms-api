package br.ufs.dcomp.farms.model.dao;

import javax.transaction.Transactional;

import org.junit.Test;

import br.ufs.dcomp.farms.model.entity.Researcher;
import br.ufs.dcomp.farms.model.enums.StateEnum;
import junit.framework.TestCase;

public class ReseacherDaoTest extends TestCase {
	
	private ResearcherDao researcherDAO;
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		researcherDAO = (ResearcherDao) SpringUtil.getInstance().getBean(ResearcherDao.class);
	}
	
	@Test
	public void testShouldSaveResearcher() {
		String dsNmReseacher = "Maria José Santos";
		String dsSSO = "mariajsantos@gmail.com";
		String dsEmail = "mariajsantos@gmail.com";
		String dsPassword = "12345678";
		StateEnum tpState = StateEnum.A;
		Researcher researcher = new Researcher(dsNmReseacher, dsSSO, dsEmail, dsPassword, tpState);
		
		researcherDAO.save(researcher);
		
		assertNotNull(researcher.getIdResearcher());
		assertTrue(researcher.getIdResearcher() > 0);
		assertEquals(dsNmReseacher, researcher.getNmResearcher());
		assertEquals(dsEmail, researcher.getDsEmail());
		assertEquals(dsPassword, researcher.getDsPassword());
	}
	
	@Test
	public void testShouldGetResearcherSaved() {
		Researcher researcher = new Researcher("Maria José Santos", "mariajsantos", "mariajsantos@gmail.com", "12345678", StateEnum.A);
		researcherDAO.save(researcher);
		assertNotNull(researcherDAO.get(researcher.getIdResearcher()));
	}
	
	@Test
	public void testShouldDeleteResearcherSaved() {
		Researcher researcher = new Researcher("Maria José Santos", "mariajsantos", "mariajsantos@gmail.com", "12345678", StateEnum.A);
		researcherDAO.save(researcher);
		assertNotNull(researcherDAO.get(researcher.getIdResearcher()));
		researcherDAO.delete(researcher);
		assertNull(researcherDAO.get(researcher.getIdResearcher()));
	}

	@Test
	public void testShouldUpdateResearcher() {
		Researcher researcher = new Researcher("Maria José Santos", "mariajsantos", "mariajsantos@gmail.com", "12345678", StateEnum.A);
		researcherDAO.save(researcher);
		
		String newDsNmResearcher = "Maria José dos Santos";
		researcher.setNmResearcher(newDsNmResearcher);
		researcherDAO.save(researcher);
		
		Researcher researcherUpdated = researcherDAO.get(researcher.getIdResearcher());
		
		assertEquals(researcher.getIdResearcher(), researcherUpdated.getIdResearcher());
		assertEquals(newDsNmResearcher, researcherUpdated.getNmResearcher());
		assertEquals(researcher.getDsEmail(), researcherUpdated.getDsEmail());
		assertEquals(researcher.getDsPassword(), researcherUpdated.getDsPassword());
	}
	
	@Transactional
	@Test
	public void testShouldGetAllResearchers() {
		Researcher researcher = new Researcher("Maria José Santos", "mariajsantos", "mariajsantos@gmail.com", "12345678", StateEnum.A);
		researcherDAO.save(researcher);
		
		//researcher = new Researcher("Maria José Santos", "mariajsantos@gmail.com", "12345678");
		//researcherDAO.save(researcher);
		
		//researcher = new Researcher("Maria José Santos", "mariajsantos@gmail.com", "12345678");
		//researcherDAO.save(researcher);
		
		assertNotNull(researcherDAO.getAll());
		
		assertFalse(researcherDAO.getAll().isEmpty());
		assertEquals(3, researcherDAO.getAll().size());
		
		//assertNotNull(researcherDAO.get(researcher.getIdResearcher()));
	}
	
//	@Test
//	public void testShouldGetResearcherByEmail() {
//		Researcher researcher = new Researcher("Maria José Santos", "mariajsantos@gmail.com", "12345678");
//		researcherDAO.save(researcher);
//		researcher = new Researcher("Maria José Santos", "mariajsantos@gmail.com", "12345678");
//		researcherDAO.save(researcher);
//		researcher = new Researcher("Maria José Santos", "mariajsantos@gmail.com", "12345678");
//		researcherDAO.save(researcher);
//		
//		assertEquals(researcherDAO.get(researcher.getIdResearcher()));
//		
//		assertNotNull(researcherDAO.get(researcher.getIdResearcher()));
//	}
}
