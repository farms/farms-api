package br.ufs.dcomp.farms.model.service;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import br.ufs.dcomp.farms.core.FarmsException;
import br.ufs.dcomp.farms.model.dto.ResearcherRegisterDto;
import br.ufs.dcomp.farms.model.entity.Researcher;
import br.ufs.dcomp.farms.model.enums.StateEnum;
import br.ufs.dcomp.farms.model.service.ResearcherService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:test-application-context.xml")
public class ResearcherServiceTest {

	@Autowired
	private ResearcherService researcherService;

	@Test
	@Transactional
    @Rollback(true)
	public void testShouldGetByEmailPassword() throws FarmsException {
		ResearcherRegisterDto researcherRegisterDto1 = new ResearcherRegisterDto("Maria José Santos", "mariajsantos", "mariajsantos@gmail.com", "12345678", "12345678", StateEnum.A);
		ResearcherRegisterDto researcherRegisterDto2 = new ResearcherRegisterDto("José Silva", "josesilva", "josesilva@gmail.com", "87654321", "12345678", StateEnum.A);
		
		researcherService.save(researcherRegisterDto1);
		researcherService.save(researcherRegisterDto2);
		
		List<Researcher> researchers = researcherService.getAll();
		
		Assert.assertNotNull(researchers);
		Assert.assertFalse(researchers.isEmpty());
		Assert.assertEquals(2, researchers.size());
	}

	@Test
    @Transactional
    @Rollback(true)
	public void testShouldGetAllResearchers() throws FarmsException {
		ResearcherRegisterDto researcherRegisterDto1 = new ResearcherRegisterDto("Maria José Santos", "mariajsantos", "mariajsantos@gmail.com", "12345678", "12345678", StateEnum.A);
		ResearcherRegisterDto researcherRegisterDto2 = new ResearcherRegisterDto("José Silva", "josesilva", "josesilva@gmail.com", "87654321", "12345678", StateEnum.A);
		ResearcherRegisterDto researcherRegisterDto3 = new ResearcherRegisterDto("João Carlos", "joaocarlos", "joaocarlos@gmail.com", "56781234", "12345678", StateEnum.A);

		researcherService.save(researcherRegisterDto1);
		researcherService.save(researcherRegisterDto2);
		researcherService.save(researcherRegisterDto3);
		
		List<Researcher> researchers = researcherService.getAll();
		
		Assert.assertNotNull(researchers);
		Assert.assertFalse(researchers.isEmpty());
		Assert.assertEquals(3, researchers.size());
	}
}
